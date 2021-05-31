package com.zhu.fte.biz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author ZQJ
 * @since 2021-02-14
 */
@Data
public class SysMenu extends Model<SysMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.INPUT)
    private String id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父菜单ID，一级菜单为0
     */
    private String parentId;

    /**
     * 菜单url,类型：1.普通页面；2.嵌套完整外部页面；3.嵌套服务器页面
     */
    private String url;

    /**
     * 授权(多个用逗号隔开，如：sys:user:add)
     */
    private String accredit;

    /**
     * 类型：0.目录；1.菜单;2.按钮
     */
    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer orderNum;

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
        return "SysMenu{" +
        "id=" + id +
        ", name=" + name +
        ", parentId=" + parentId +
        ", url=" + url +
        ", accredit=" + accredit +
        ", type=" + type +
        ", icon=" + icon +
        ", orderNum=" + orderNum +
        ", createTime=" + createTime +
        ", delStatus=" + delStatus +
        "}";
    }
}
