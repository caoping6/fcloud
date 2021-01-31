package com.eg.fcloud.webapp.service.impl;

import com.eg.fcloud.entity.User;
import com.eg.fcloud.webapp.mapper.UserMapper;
import com.eg.fcloud.webapp.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author caoping
 * @since 2021-01-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
