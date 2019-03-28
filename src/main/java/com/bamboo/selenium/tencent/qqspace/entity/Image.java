package com.bamboo.selenium.tencent.qqspace.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 图片表
 * </p>
 *
 * @author 郭晴
 * @since 2019-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Image extends Model<Image> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 图片地址
     */
    private String address;

    /**
     * 图片类型
     */
    private String type;

    /**
     * 照片上传时间
     */
    @TableField("createTime")
    private LocalDateTime createTime;

    /**
     * 关联id
     */
    private Integer relatedId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
