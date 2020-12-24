package top.cijee.jwt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import top.cijee.jwt.domain.UserAuth;

/**
 * @author Cijee
 * @version 1.0
 */
@Repository
public interface UserAuthMapper extends BaseMapper<UserAuthMapper> {

    UserAuth selectByName(String username);

}
