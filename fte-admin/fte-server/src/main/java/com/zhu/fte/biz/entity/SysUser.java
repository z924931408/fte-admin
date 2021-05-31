package com.zhu.fte.biz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author ZQJ
 * @since 2021-02-14
 */
@Data
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
    private String name;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    private String password;

    /**
     * 邮箱
     */
    @NotEmpty(message = "邮箱不能为空")
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 更新时间
     */

    private LocalDateTime createTime;

    /**
     * 是否删除 -1：已删除   0：正常
     */
    private Integer delStatus;



    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysUser{" +
        "id=" + id +
        ", name=" + name +
        ", nickName=" + nickName +
        ", avatar=" + avatar +
        ", password=" + password +
        ", email=" + email +
        ", mobile=" + mobile +
        ", createTime=" + createTime +
        ", delStatus=" + delStatus +
        "}";
    }
}
