package top.cijee.jwt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import top.cijee.jwt.domain.Role;

import java.util.Set;

/**
 * @author Cijee
 * @version 1.0
 */
@Repository
public interface RoleMapper extends BaseMapper<Role> {

    Set<Role> selectByUserId(Long id);
}
