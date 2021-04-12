package at.ac.htlstp.s2020.k5bhet.demoserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RestUser {

    /** Benutzername */
    @Setter
    private String name="";

    /** Klartextpasswort */
    private String password="";

    /** verschlüsseltes Passwort */
    private String encodedpassword="";

    /** Liste aller Authentifizierungs-Rollen des Benutzers */
    private String[] roles = new String[0];

    /**
     * Setzt das Passwort des Benutzers
     * @param password Klartextpasswort
     */
    public void setPassword(String password) {
        if (password.length()>0) {
            this.password = password;
            this.encodedpassword = (new BCryptPasswordEncoder()).encode(password);
        }
    }

    /**
     * Setzt das Passwort des Benutzers
     * @param password encrypted Passwort
     */
    public void setEncodedpassword(String password) {
        if (password.length()>0) {
            this.password = null;
            this.encodedpassword = password;
        }
    }

    /**
     * Fügt eine Benutzerrolle zu dem Benutzer hinzu
     * @param role Rollennamen
     */
    public void addRole(String role) {
        role = role.toUpperCase();
        for (String s:roles)
            if (s.equals(role)) return;
        String[] ret = new String[roles.length+1];
        for (int i=0;i< roles.length;i++)
            ret[i] = roles[i];
        ret[roles.length] = role;
        roles = ret;
    }

}
