package com.johnhunsley.user.domain;

/**
 * <p>
 *     Simple Hashing utility built on the bouncy castle
 * </p>
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
 *
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 27/09/2016
 *         Time : 19:44
 */
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;


public final class Hash {
    private Digest digest;
    public static final int SHA1_TYPE = 0;
    public static final int MD5_TYPE = 1;

    /**
     * <p>
     *     Creates a new Hash object implementing the encryption algorithm denoted by the given type.
     *     Will default to SHA1
     * </p>
     * @param type
     */
    public Hash(final int type) {
        switch (type) {
            case SHA1_TYPE : digest = new SHA1Digest(); break;
            case MD5_TYPE : digest = new MD5Digest(); break;
            default: digest = new SHA1Digest();
        }
    }

    /**
     * <p>
     *     Hashes the given argument according to the predefined algorithm and returns the hash
     *     representation as a byte[]. If the given arg is null or zero length then will return a
     *     null byte[].
     * </p>
     * @param arg - the String to be hashed
     * @return byte[] hashed representation of the given arg
     */
    public byte[] hash(final String arg) {
        byte[] out = null;

        if(arg == null || arg.length() < 1) return out;

        digest.reset();
        byte[] in = arg.getBytes();
        digest.update(in, 0, in.length);
        out = new byte[digest.getDigestSize()];
        digest.doFinal(out, 0);
        return out;
    }
}
