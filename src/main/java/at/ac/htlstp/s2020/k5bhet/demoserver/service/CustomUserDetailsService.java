package at.ac.htlstp.s2020.k5bhet.demoserver.service;

import at.ac.htlstp.s2020.k5bhet.demoserver.model.RestUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    /** Liste aller Benutzer, welche sich an dem Server anmelden können */
    protected Hashtable<String, RestUser> users = new Hashtable<String, RestUser>();

    public CustomUserDetailsService() {
        updateUser("gast", "x","gast");
        updateUser("user", "y","gast,user");
        updateUser("admin","z","gast,user,admin");
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if (users.containsKey(userName)) {
            RestUser restUser = users.get(userName);
            UserDetails user = User
                    .withUsername(restUser.getName())
                    .password(restUser.getEncodedpassword())
                    .roles(restUser.getRoles()).build();
            return user;
        } else throw(new UsernameNotFoundException("Username " + userName + " not found"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(RestUser restUser) {
        return AuthorityUtils.createAuthorityList(restUser.getRoles());
    }

    public void loadUserList(List<String> userlist) {
        if (userlist!=null) {
            for (String suser:userlist) if (suser.trim().length()>0) {
                String[] params = suser.trim().split("\\s+");
                if (params.length>0) {
                    RestUser user = new RestUser();
                    user.setName(params[0]);
                    if (params.length>1) user.setPassword(params[1]);
                    if (params.length<3) user.addRole("GAST");
                    for (int i=2;i<params.length;i++)
                        user.addRole(params[i]);
                    users.put(user.getName(),user);
                }
            }
        }
    }

    public void updateUserPassword(String user, String password) {
        user = user.trim();
        password = password.trim();
        RestUser restUser;
        if (user.length()>0) {
            if (users.containsKey(user)) {
                restUser = users.get(user);
            } else {
                restUser = new RestUser();
                restUser.setName(user);
            }
            restUser.setPassword(password);
            users.put(user,restUser);
        }
    }

    public void updateUserEncryptedPassword(String user, String password) {
        user = user.trim();
        password = password.trim();
        RestUser restUser;
        if (user.length()>0) {
            if (users.containsKey(user)) {
                restUser = users.get(user);
            } else {
                restUser = new RestUser();
                restUser.setName(user);
            }
            restUser.setEncodedpassword(password);
            users.put(user,restUser);
        }
    }

    public void updateUserRoles(String user, String role) {
        user = user.trim();
        String[] roles = role.trim().split(",");
        RestUser restUser;
        if (user.length()>0) {
            if (users.containsKey(user)) {
                restUser = users.get(user);
            } else {
                restUser = new RestUser();
                restUser.setName(user);
            }
            for (String r:roles)
                if (role.trim().length()>0)
                    restUser.addRole(r.trim());
            users.put(user,restUser);
        }
    }

    public void updateUser(String user, String password, String role) {
        user = user.trim();
        String[] roles = role.trim().split(",");
        password = password.trim();
        RestUser restUser;
        if (user.length()>0) {
            if (users.containsKey(user)) {
                restUser = users.get(user);
            } else {
                restUser = new RestUser();
                restUser.setName(user);
            }
            for (String r:roles)
                if (role.trim().length()>0)
                    restUser.addRole(r.trim());
            restUser.setPassword(password);
            users.put(user,restUser);
        }
    }

}
