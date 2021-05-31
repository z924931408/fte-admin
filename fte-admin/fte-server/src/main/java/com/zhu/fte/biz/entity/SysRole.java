package com.zhu.fte.biz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author ZQJ
 * @since 2021-02-14
 */
@Data
public class SysRole extends Model<SysRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    /**
     * 角色名称
     */
    @NotEmpty(message = "角色名不能为空")
    private String name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
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
        return "SysRole{" +
        "id=" + id +
        ", name=" + name +
        ", remark=" + remark +
        ", createTime=" + createTime +
        ", delStatus=" + delStatus +
        "}";
    }
}
