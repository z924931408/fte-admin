package com.zhu.fte.biz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 角色机构表
 * </p>
 *
 * @author ZQJ
 * @since 2021-02-14
 */
@Data
public class SysRoleMenu extends Model<SysRoleMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    /**
     * 机构ID
     */
    private String menuId;

    /**
     * 角色ID
     */
    private String roleId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建者
     */
    private String createUser;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysRoleMenu{" +
        "id=" + id +
        ", menuId=" + menuId +
        ", roleId=" + roleId +
        ", remark=" + remark +
        ", createUser=" + createUser +
        ", createTime=" + createTime +
        "}";
    }
}
