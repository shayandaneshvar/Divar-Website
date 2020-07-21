package ir.ac.kntu.divar.auth;

import java.util.List;

public enum Roles {
    USER, ADMIN;

    public static List<Roles> getAllRoles() {
        return List.of(USER, ADMIN);
    }
}
