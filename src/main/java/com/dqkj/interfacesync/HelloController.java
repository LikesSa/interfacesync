package com.dqkj.interfacesync;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello,Spring Boot";
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;



    @RequestMapping("/getUser")
    public String getUser(){
        String maxid = jdbcTemplate.queryForObject("select max(id) from person;",String.class);
        if(maxid.equals("") || maxid ==null) {
            maxid = "0";
        }
        int maxidd = Convert.toInt(maxid);
        String sqls = "TSQL = ";
        Console.log(maxid);
        for(int a = maxidd+1;a< maxidd+1+30;a++){
            int page = RandomUtil.randomInt(10,40);
            int zz = RandomUtil.randomInt(0,3);
            String penname = RandomUtil.randomString("阳光佳美好浩然乾坤正义山有木兮木有枝心悦君兮君不知人间四月芳菲尽",zz);
            String pennamex = RandomUtil.randomString("张王李赵钱孙马蒋沈韩杨奚范彭郎俞任袁柳朱秦尤许",1);
            String uuid = RandomUtil.simpleUUID();

            String sql = "insert into person(id,name,age,description)values("+a+",'"+pennamex+penname+"','"+page+"','"+uuid+"');";
            Console.log(sql);
            sqls+=sql;
            jdbcTemplate.execute(sql);
        }
        return  sqls;

    }
}