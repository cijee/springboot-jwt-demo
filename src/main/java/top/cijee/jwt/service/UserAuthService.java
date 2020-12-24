package top.cijee.jwt.service;

import top.cijee.jwt.domain.UserAuth;

/**
 * @author Cijee
 * @version 1.0
 */
public interface UserAuthService {

    UserAuth findByName(String username);
}
