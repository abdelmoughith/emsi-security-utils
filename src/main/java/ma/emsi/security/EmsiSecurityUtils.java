package ma.emsi.security;


import jakarta.servlet.http.HttpServletRequest;

public final class EmsiSecurityUtils {

    private EmsiSecurityUtils() {
        // prevent instantiation
    }

    public static Long getUserId(HttpServletRequest req) {
        String value = req.getHeader(EmsiSecurityConstants.HEADER_USER_ID);
        if (value == null) return null;

        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            return null; // header exists but is not numeric
        }
    }

    public static String getUserRole(HttpServletRequest req) {
        return req.getHeader(EmsiSecurityConstants.HEADER_USER_ROLE);
    }
}


