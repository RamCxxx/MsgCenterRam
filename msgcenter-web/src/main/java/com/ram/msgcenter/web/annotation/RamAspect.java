package com.ram.msgcenter.web.annotation;

import java.lang.annotation.*;

/**
 * @author Ramxx
 * @version 1.0.0
 * @description 接口切面注解
 * @date
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RamAspect {
}
