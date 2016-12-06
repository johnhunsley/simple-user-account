package com.johnhunsley.user.util;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

/**
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 06/12/2016
 *         Time : 16:19
 */
@Configurable(preConstruction = true)
public class UserTypeIdResolver implements TypeIdResolver {
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
        return null;
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
    public JavaType typeFromId(DatabindContext context, String id) throws IOException {
        //try and use Class.forname by concatenating the domainImplPackage, plus dot, to the Id value

    }

    public String getDescForKnownTypeIds() {
        return null;
    }

    public JsonTypeInfo.Id getMechanism() {
        return JsonTypeInfo.Id.CUSTOM;
    }
}
