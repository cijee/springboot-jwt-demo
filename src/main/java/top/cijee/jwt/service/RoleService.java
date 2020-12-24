package top.cijee.jwt.service;

import org.springframework.security.core.GrantedAuthority;
import top.cijee.jwt.domain.User;
import top.cijee.jwt.domain.UserAuth;

import java.util.List;

/**
 * @author Cijee
 * @version 1.0
 */
public interface RoleService {

    List<GrantedAuthority> mapToGrantedAuthorities(Long userId);

}
