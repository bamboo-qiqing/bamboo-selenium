package com.bamboo.selenium.tencent.qqspace.service.impl;

import com.bamboo.selenium.tencent.qqspace.entity.User;
import com.bamboo.selenium.tencent.qqspace.mapper.UserMapper;
import com.bamboo.selenium.tencent.qqspace.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 郭晴
 * @since 2019-03-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
