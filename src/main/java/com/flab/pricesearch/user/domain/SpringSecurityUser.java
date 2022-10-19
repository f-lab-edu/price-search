package com.flab.pricesearch.user.domain;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class SpringSecurityUser extends User {

    public SpringSecurityUser(String username, String password,
        Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public SpringSecurityUser(String username, String password,
                              boolean enabled, boolean accountNonExpired,
                              boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired,
            accountNonLocked,
            authorities);
    }
}
