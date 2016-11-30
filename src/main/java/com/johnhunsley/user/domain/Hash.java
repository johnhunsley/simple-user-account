package com.johnhunsley.user.domain;

/**
 * @author John Hunsley
 *         jphunsley@gmail.com
 *         Date : 27/09/2016
 *         Time : 09:44
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
