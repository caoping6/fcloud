package com.eg.fcloud.webapp.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author caoping
 * @since 2021-01-28
 */
@Data
@EqualsAndHashCode()
@Accessors(chain = true)
// 先使用@ApiModel来标注类
@ApiModel(value="用户登录表单对象",description="用户登录表单对象")
public class User{

    private static final long serialVersionUID=1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 用户账号
     */
    @ApiModelProperty
    private String userCode;

    /**
     * 用户名
     */
    @ApiModelProperty
    private String userName;

    /**
     * 年龄
     */
    @ApiModelProperty
    private Integer age;

    /**
     * 创建时间
     */
    @ApiModelProperty
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 版本号
     */
    @ApiModelProperty
    private Integer version;

    /**
     * 删除标识
     */
    @ApiModelProperty
    @TableField("`delete`")
    private Integer delete;


}
