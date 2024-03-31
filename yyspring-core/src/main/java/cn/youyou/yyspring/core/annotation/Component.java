package cn.youyou.yyspring.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Component {

    // 用于提供给用户指定bean的命名,不写的话，就按照spring的取名方式命名bean，以类的简称命名，将一个大写字母变小写，如果开头有大于两个的大写字母，那么就不做任何变更
    String value() default "";

}
