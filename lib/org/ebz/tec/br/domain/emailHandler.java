package org.ebz.tec.br.domain;

import java.net.IDN;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.*;


public final class EmailDomain {

    private EmailDomain() {}


    private static final Pattern BASIC_EMAIL =
            Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
}
