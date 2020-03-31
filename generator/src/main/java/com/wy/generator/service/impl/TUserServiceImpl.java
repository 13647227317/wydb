package com.wy.generator.service.impl;

import com.wy.generator.entity.TUser;
import com.wy.generator.mapper.TUserMapper;
import com.wy.generator.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wangyong
 * @since 2020-03-31
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

}
