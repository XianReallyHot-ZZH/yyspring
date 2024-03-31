package cn.youyou.yyspring.demo;

import cn.youyou.yyspring.core.YYApplicationContext;

public class Test {

    public static void main(String[] args) {

        // 创建容器类
        YYApplicationContext applicationContext = new YYApplicationContext(AppConfig.class);

        Object userService = applicationContext.getBean("userService");

    }

}
