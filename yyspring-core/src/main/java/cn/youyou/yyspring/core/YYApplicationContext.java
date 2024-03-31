package cn.youyou.yyspring.core;

import cn.youyou.yyspring.core.annotation.Component;
import cn.youyou.yyspring.core.annotation.ComponentScan;

import java.io.File;
import java.net.URL;
import java.util.Arrays;

/**
 * 模拟Spring的容器类
 */
public class YYApplicationContext {

    private Class<?> configClass;

    public YYApplicationContext(Class<?> configClass) {
        this.configClass = configClass;

        if (!configClass.isAnnotationPresent(ComponentScan.class)) {
            throw new RuntimeException("入参类未配置ComponentScan注解");
        }

        // 解析配置类
        // 先解析一把ComponentScan注解 ---> 获取到扫描路径 ---> 进行扫描
        ComponentScan componentScanAnnotation = configClass.getDeclaredAnnotation(ComponentScan.class);
        String path = componentScanAnnotation.value();  // 获取到扫描路径，比如：cn.youyou.yyspring.demo.dervice
        System.out.println("scan path: " + path);

        // 扫描(方案原理：1、扫描指定路径下有哪些类；2、利用jvm进行加载；3、加载完毕，获取对应的class对象，利用反射获取类上相应的注解信息)
        // 三种类加载器：1、Bootstrap ---> jre/lib; 2、Ext ---> jre/ext/lib; 3、App ---> classpath 就是当前应用的路径
        ClassLoader classLoader = YYApplicationContext.class.getClassLoader(); // 获取应用类加载器
        URL resource = classLoader.getResource(path.replace(".", "/"));   // 这里获取的资源其实就是一个目录
        File file = new File(resource.getFile());   // 转换成文件对象，方便后续操作
        if (file.isDirectory()) {

            File[] files = file.listFiles();
//            System.out.println(" ===> files:");
            for (File f : files) {
//                System.out.println(f);
                String fileName = f.getAbsolutePath();
                if (fileName.endsWith(".class")) {
                    String className = fileName.substring(
                            fileName.indexOf("\\target\\classes\\") + "\\target\\classes\\".length(),
                            fileName.indexOf(".class")
                    );
                    className = className.replace("\\", ".");   // 获取到类的全限定名,类似这种：cn.youyou.yyspring.demo.service.UserService
//                System.out.println(className);
                    try {
                        Class<?> clazz = classLoader.loadClass(className);
                        if (clazz.isAnnotationPresent(Component.class)) {
                            // 判断到当前的类是一个bean




                        }

                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }

                }

            }

            //
        }


    }

    // 提供获取bean方法
    public Object getBean(String beanName) {
        return null;
    }

}
