package top.cijee.jwt.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import top.cijee.jwt.domain.Role;
import top.cijee.jwt.mapper.RoleMapper;
import top.cijee.jwt.service.RoleService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Cijee
 * @version 1.0
 */
@Service
public class RoleServiceImpl implements RoleService {

    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public List<GrantedAuthority> mapToGrantedAuthorities(Long userId) {
        Set<Role> roles = roleMapper.selectByUserId(userId);
        Set<String> permissions = roles.stream().map(Role::getRoleName).
                collect(Collectors.toSet());
        return permissions.stream().map(SimpleGrantedAuthority::new).
                collect(Collectors.toList());
    }
}
