package com.johnhunsley.user.util;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.TypeIdResolverBase;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

/**
 * <p>
 *    Implementation of the {@link TypeIdResolver} used to translate the qualifier of the JSON into a class
 *    name which can be instantiated. The type to be instantiated must be a subclass or implementation of the
 *    the given {@link JavaType}. An example of this would be the {@link com.johnhunsley.user.domain.User} type.
 *    This allows us to define JSON parsers which can (de)serialize User implementations without any constraint on the
 *    implementation.
 *
 *    The stereotype as defined by the JavaType, or the implementation itself must be annotated with the following -
 *
 *     \@JsonTypeInfo(
 *          use = JsonTypeInfo.Id.CUSTOM,
 *          include = JsonTypeInfo.As.PROPERTY,
 *          property = "@class")
 *     \@JsonTypeIdResolver(UserTypeIdResolver.class)
 *
 *     The predefined domainImplPackage must be the package where the class names, derived from the JSON qualifier, can
 *     be found. This could be in any package on the class path of whatever application implements simple-user-account.
 *     This value can be externalized and defined in the application.properties file of the application under the
 *     property - domain.impl.package
 *
 *     For Example:
 *
 *     The following JSON, where domainImplPackage is 'my.package'.....
 *
 *     {"@class":"UserImpl", "id":1234, "username":"bob"}
 *
 *     would be serialized into the following object when serialized with a Jackson ObjectMapper....
 *
 *     my.package.UserImpl
 * </p>
 *
 * <p>
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 * </p>
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 06/12/2016
 *         Time : 19:19
 */
@Configurable(preConstruction = true)
public class UserTypeIdResolver extends TypeIdResolverBase {
    private JavaType mBaseType;

    @Value("${domain.impl.package}")
    private String domainImplPackage;

    public void init(JavaType baseType) {
        mBaseType = baseType;
    }

    public String idFromValue(Object value) {
        return idFromValueAndType(value, value.getClass());
    }

    /**
     * <p>
     *     return the class name only, minus the package part
     * </p>
     * @param value
     * @param suggestedType
     * @return
     */
    public String idFromValueAndType(Object value, Class<?> suggestedType) {
        final String typeName = suggestedType.getName();

        if(typeName.startsWith(domainImplPackage)) {
            return typeName.substring(domainImplPackage.length() + 1);
        }

        throw new IllegalArgumentException(
                suggestedType + " is not found within defined domain package "+domainImplPackage);
    }


    public String idFromBaseType() {
        return idFromValueAndType(null, mBaseType.getRawClass());

    }

    /**
     * <p>
     *     prefix the id (the class name) with the predefined package, plus a 'dot'
     * </p>
     * @param context
     * @param id
     * @return
     * @throws IOException
     */
    public JavaType typeFromId(DatabindContext context, final String id) throws IOException {
        //try and use Class.forname by concatenating the domainImplPackage, plus dot, to the Id value
        StringBuilder builder = new StringBuilder(domainImplPackage).append(".").append(id);

        try {
            Class clazz = Class.forName(builder.toString());
            return TypeFactory.defaultInstance().constructSpecializedType(mBaseType, clazz);

        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        }
    }

    public String getDescForKnownTypeIds() {
        return null;
    }

    public JsonTypeInfo.Id getMechanism() {
        return JsonTypeInfo.Id.CUSTOM;
    }
}
