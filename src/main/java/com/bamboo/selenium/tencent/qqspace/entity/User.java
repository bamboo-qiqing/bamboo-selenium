package com.bamboo.selenium.tencent.qqspace.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 郭晴
 * @since 2019-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * qq号
     */
    private String qq;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别
     */
    private String gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 生日
     */
    private String birth;

    /**
     * 血型
     */
    private String bloodGroup;

    /**
     * 星座
     */
    private String constellation;

    /**
     * 现居地
     */
    private String currentResidence;

    /**
     * 故乡
     */
    private String home;

    /**
     * 职业
     */
    private String career;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 照片数量
     */
    private String photoNumber;

    /**
     * 日志数量
     */
    private String logNumber;

    /**
     * 说说数量
     */
    private String talkAboutNumber;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
