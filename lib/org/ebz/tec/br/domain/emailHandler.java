
package org.ebz.tec.br.domain;

import java.util.HashMap;
import java.util.Map;

public final class EmailHandler {

    private EmailHandler() {}

    // ===== Mapa domínio -> providerId =====
    private static final Map<String, String> DOMAIN_TO_PROVIDER = new HashMap<>();
    static {
        DOMAIN_TO_PROVIDER.put("ebz.tec.br", "LemonLDAP");
        DOMAIN_TO_PROVIDER.put("wren.com",   "WrenAM");
        DOMAIN_TO_PROVIDER.put("ping.com",   "OpenAM");
        DOMAIN_TO_PROVIDER.put("keycloak.com", "KeycloakLab");
        // adicione mais aqui conforme necessidade
    }

    // Fallback opcional
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

    /** Retorna o providerId mapeado para o e-mail; usa fallback se não achar. */
    public static String providerFor(String email) {
        String domain = extractDomainSimple(email);
        if (domain == null) return null; // ou retorne DEFAULT_PROVIDER, se preferir

        String provider = DOMAIN_TO_PROVIDER.get(domain);
        if (provider != null && !provider.isBlank()) {
            return provider;
        }
        // fallback (remova se não quiser)
        return DEFAULT_PROVIDER;
    }
}