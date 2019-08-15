package com.lzx;

import com.alibaba.fastjson.JSON;
import com.lzx.dao.DemoEntityMapper;
import com.lzx.entity.DemoEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceApplicationTests {

    @Autowired
    DemoEntityMapper mapper;

    @Test
    public void contextLoads() {
        Map<String,Object> map = new HashMap<>();
        map.put("ytytry",111);
        map.put("348","sass");

        DemoEntity de = new DemoEntity()
                .setA("11")
                .setB("22")
                .setC("333")
                .setD(new DemoEntity.Location().setX(17).setY(71))
                .setE(map);
        de.setCreateAndUpdateTime();
        de.setId("1");
        mapper.insert(de);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(JSON.toJSONString(mapper.selectList(null)));
        System.out.println();
        System.out.println();
        System.out.println(JSON.toJSONString(mapper.selectMaps(null)));
        System.out.println();
        System.out.println();
        System.out.println(JSON.toJSONString(mapper.selectById("1")));
        System.out.println();
        System.out.println();
        System.out.println(JSON.toJSONString(mapper.getList()));
        System.out.println();
        System.out.println();

    }

}
