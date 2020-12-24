package top.cijee.jwt.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * user_auth
 * @author 
 */
@TableName("sys_user_auth")
@Data
public class UserAuth implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 密码
     */
    private String password;

    /**
     * 1为锁定，0为启用
     */
    private Boolean isLocked;

    /**
     * 最后一次登录时间
     */
    private Date loginTime;

    /**
     * 账户解锁时间
     */
    private Date unlockTime;

    /**
     * 登录失败次数，超过3次锁定账户
     */
    private Byte loginFailCount;

    /**
     * 用户信息表外键
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}