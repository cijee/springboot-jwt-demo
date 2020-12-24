package top.cijee.jwt.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.cijee.jwt.domain.UserAuth;
import top.cijee.jwt.domain.dto.JwtUserDTO;
import top.cijee.jwt.service.RoleService;
import top.cijee.jwt.service.UserAuthService;

/**
 * @author Cijee
 * @version 1.0
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserAuthService userAuthService;

    private final RoleService roleService;

    public UserDetailsServiceImpl(UserAuthService userAuthService, RoleService roleService) {
        this.userAuthService = userAuthService;
        this.roleService = roleService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuth userAuth = userAuthService.findByName(username);
        if (userAuth == null) {
            throw new UsernameNotFoundException("");
        }
        return new JwtUserDTO(userAuth, roleService.mapToGrantedAuthorities(userAuth.getUserId()));
    }
}
