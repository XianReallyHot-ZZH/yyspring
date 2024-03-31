package cn.youyou.yyspring.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ComponentScan {

    // 用于提供给用户指定扫描路径，不填写的话就以标注了该注解的类所在的路径作为扫描路径
    String value();

}
