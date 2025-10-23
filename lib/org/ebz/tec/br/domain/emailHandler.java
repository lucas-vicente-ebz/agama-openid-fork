package org.ebz.tec.br.domain;

import java.util.HashMap;
import java.util.Map;

public final class EmailHandler {

    private EmailHandler() {}

    private static final String DEFAULT_PROVIDER = "LemonLDAP";

    /** Extração mínima de domínio: exige existir '@' e '.' em algum lugar. */
    public static String extractDomainSimple(String email) {
        if (email == null) return null;
        String e = email.trim();
        if (e.isEmpty()) return null;
        if (e.indexOf('@') < 0 || e.indexOf('.') < 0) return null;

        int at = e.lastIndexOf('@');
        if (at < 0 || at == e.length() - 1) return null;

        String domain = e.substring(at + 1).toLowerCase();
        return domain.isEmpty() ? null : domain;
    }

    public static String providerFor(String email) {
        String domain = extractDomainSimple(email);
        if (domain == null) return null;
        if (domain.equals("ebz.tec.br")) return DEFAULT_PROVIDER; 
        if (domain.equals("openam.tec.br")) return "OpenAM"; 
        if (domain.equals("wrenam.tec.br")) return "WrenAM"; 
        if (domain.equals("keycloak.tec.br")) return "KeycloakLab"; 
        return null
    }
}