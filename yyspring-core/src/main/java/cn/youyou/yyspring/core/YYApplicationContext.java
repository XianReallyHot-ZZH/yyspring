package cn.youyou.yyspring.core;

/**
 * 模拟Spring的容器类
 */
public class YYApplicationContext {

    private Class<?> configClass;

    public YYApplicationContext(Class<?> configClass) {
        this.configClass = configClass;

        // 解析配置类
        // 先解析一把ComponentScan注解 ---> 获取到扫描路径 ---> 进行扫描






    }

    // 提供获取bean方法
    public Object getBean(String beanName) {
        return null;
    }

}
