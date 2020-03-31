package com.wy.shardingjdbc.mapper;

import com.wy.shardingjdbc.entity.TUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author wangyong
 * @date 2020/3/31
 */
@SpringBootTest
class TUserMapperTest {
    @Resource
    private TUserMapper tUserMapper;

    @Test
    public void testInsert(){
        for(int i=1;i<11;i++){
            TUser user=new TUser();
            user.setUserCode("code"+i);
            user.setUserName("name"+i);
            user.setCreateTime(LocalDateTime.now());
            tUserMapper.insert(user);
        }
    }
}