package org.jose4j.jwt.consumer;

import java.util.Locale;
import org.jose4j.jwt.consumer.ErrorCodeValidator;
import org.jose4j.lang.UncheckedJoseException;

/* JADX INFO: loaded from: classes6.dex */
public class TypeValidator implements ErrorCodeValidator {
    private static final String APPLICATION_PRIMARY_TYPE = "application";
    private SimpleMediaType expectedType;
    private boolean requireType;

    public TypeValidator(boolean z, String str) {
        try {
            SimpleMediaType mediaType = toMediaType(str);
            this.expectedType = mediaType;
            if (mediaType.getSubType().equals("*")) {
                throw new UncheckedJoseException("cannot use wildcard in subtype of expected type");
            }
            this.requireType = z;
        } catch (MediaTypeParseException e) {
            throw new UncheckedJoseException("The given expected type '" + str + "' isn't a valid media type in this context.", e);
        }
    }

    @Override // org.jose4j.jwt.consumer.ErrorCodeValidator
    public ErrorCodeValidator.Error validate(JwtContext jwtContext) {
        return validate(jwtContext.getJoseObjects().get(0).getHeader("typ"));
    }

    ErrorCodeValidator.Error validate(String str) {
        if (str == null) {
            if (this.requireType) {
                return new ErrorCodeValidator.Error(21, "No typ header parameter present in the innermost JWS/JWE");
            }
            return null;
        }
        if (this.expectedType != null) {
            try {
                SimpleMediaType mediaType = toMediaType(str);
                if (!this.expectedType.match(mediaType) || mediaType.getSubType().equals("*")) {
                    StringBuilder sb = new StringBuilder("Invalid typ header parameter value '");
                    sb.append(str).append("'. Expecting '");
                    sb.append(this.expectedType).append("'");
                    if (this.expectedType.getPrimaryType().equals(APPLICATION_PRIMARY_TYPE)) {
                        sb.append(" or just '").append(this.expectedType.getSubType()).append("'");
                    }
                    sb.append(".");
                    return new ErrorCodeValidator.Error(22, sb.toString());
                }
            } catch (MediaTypeParseException e) {
                return new ErrorCodeValidator.Error(22, "typ header parameter value '" + str + "' not parsable as a media type " + e);
            }
        }
        return null;
    }

    private SimpleMediaType toMediaType(String str) throws MediaTypeParseException {
        return str.contains("/") ? new SimpleMediaType(str) : new SimpleMediaType(APPLICATION_PRIMARY_TYPE, str);
    }

    static class MediaTypeParseException extends Exception {
        MediaTypeParseException(String str) {
            super(str);
        }
    }

    static class SimpleMediaType {
        private String primaryType;
        private String subType;

        SimpleMediaType(String str) throws MediaTypeParseException {
            parse(str);
        }

        SimpleMediaType(String str, String str2) throws MediaTypeParseException {
            String lowerCase = str.toLowerCase(Locale.ENGLISH);
            this.primaryType = lowerCase;
            checkToken(lowerCase);
            String lowerCase2 = str2.toLowerCase(Locale.ENGLISH);
            this.subType = lowerCase2;
            checkToken(lowerCase2);
        }

        private void parse(String str) throws MediaTypeParseException {
            int iIndexOf = str.indexOf(47);
            if (iIndexOf < 0) {
                throw new MediaTypeParseException("Cannot find sub type.");
            }
            int iIndexOf2 = str.indexOf(59);
            if (iIndexOf2 < 0) {
                this.primaryType = str.substring(0, iIndexOf).trim().toLowerCase(Locale.ENGLISH);
                this.subType = str.substring(iIndexOf + 1).trim().toLowerCase(Locale.ENGLISH);
            } else {
                if (iIndexOf >= iIndexOf2) {
                    throw new MediaTypeParseException("Cannot find sub type.");
                }
                this.primaryType = str.substring(0, iIndexOf).trim().toLowerCase(Locale.ENGLISH);
                this.subType = str.substring(iIndexOf + 1, iIndexOf2).trim().toLowerCase(Locale.ENGLISH);
            }
            checkToken(this.primaryType);
            checkToken(this.subType);
        }

        String getPrimaryType() {
            return this.primaryType;
        }

        String getSubType() {
            return this.subType;
        }

        public String toString() {
            return getBaseType();
        }

        String getBaseType() {
            return this.primaryType + "/" + this.subType;
        }

        boolean match(SimpleMediaType simpleMediaType) {
            return this.primaryType.equals(simpleMediaType.getPrimaryType()) && (this.subType.equals(simpleMediaType.getSubType()) || this.subType.equals("*") || simpleMediaType.getSubType().equals("*"));
        }

        private static boolean isLegitTokenChar(char c) {
            return c > ' ' && c <= '~' && "()<>@,;:/[]?=\\\"".indexOf(c) < 0;
        }

        private static void checkToken(String str) throws MediaTypeParseException {
            if (str == null || str.length() == 0) {
                throw new MediaTypeParseException("cannot have empty part");
            }
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (!isLegitTokenChar(cCharAt)) {
                    throw new MediaTypeParseException("Invalid token char " + cCharAt);
                }
            }
        }
    }
}
