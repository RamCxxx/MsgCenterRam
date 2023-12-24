package com.ram.msgcenter.web.annotation;

import java.lang.annotation.*;

/**
 * @author Ramxx
 * @version 1.0.0
 * @description 统一返回注解
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RamResult {
}
