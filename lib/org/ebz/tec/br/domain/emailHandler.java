package org.ebz.tec.br.domain;

import java.net.IDN;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.*;


public final class getProvider(String[] email) {

    private String email, domain;
    domain = email.substring(email.indexOf("@") + 1);
        System.out.println(email + " | " + domain);
    if (domain.equals("ebz.tec.br")){
        return("LemonLDAP");
    } else if (domain.equals("wren.com")){
        return("WrenAM");
    } else if (domain.equals("ping.com")){
        return("OpenAM");
    } else if (domain.equals("keycloak.com")){
        return("KeycloakLab");
    } else {
        return("LemonLDAP");
    }

}
