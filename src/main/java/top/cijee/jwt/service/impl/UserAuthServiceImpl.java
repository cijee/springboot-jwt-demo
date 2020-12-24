package top.cijee.jwt.service.impl;

import org.springframework.stereotype.Service;
import top.cijee.jwt.domain.UserAuth;
import top.cijee.jwt.mapper.UserAuthMapper;
import top.cijee.jwt.service.UserAuthService;

/**
 * @author Cijee
 * @version 1.0
 */
@Service
public class UserAuthServiceImpl implements UserAuthService {

    private final UserAuthMapper userAuthMapper;

    public UserAuthServiceImpl(UserAuthMapper userAuthMapper) {
        this.userAuthMapper = userAuthMapper;
    }

    @Override
    public UserAuth findByName(String username) {
        return userAuthMapper.selectByName(username);
    }
}
