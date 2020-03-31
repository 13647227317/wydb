package com.wy.shardingjdbc.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wy.shardingjdbc.entity.TOrder;
import com.wy.shardingjdbc.mapper.TOrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author wangyong
 * @date 2020/3/28
 */
@SpringBootTest
public class TOrderMapperTest {
    @Resource
    private TOrderMapper tOrderMapper;

    @Test
    public void testInsert(){
        for(int i=1;i<11;i++){
            TOrder order=new TOrder();
            order.setOrderCode(i+"");
            order.setUserId(i);
            order.setCreateTime(LocalDateTime.now());
            tOrderMapper.insert(order);
        }
    }

    @Test
    public void testSelectList(){
        QueryWrapper<TOrder> query=new QueryWrapper<TOrder>();
        List<TOrder> list=tOrderMapper.selectList(query.lambda().eq(TOrder::getOrderCode,"2"));
        if(!CollectionUtils.isEmpty(list)){
            list.forEach(t-> System.out.println(t.getId()));
        }
    }

    @Test
    public void testSelectPage(){
        IPage page=new Page<TOrder>(1,5);
        QueryWrapper<TOrder> query=new QueryWrapper<>();
        query.lambda().orderBy(true,true,TOrder::getId);
        IPage<TOrder> result=tOrderMapper.selectPage(page,query);
        result.getRecords().forEach(t-> System.out.println(t.getId()));
    }
}
