package com.example.demo.util;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CrossOrigin {

    String[] DEFAULT_ORIGINS = { "*" };

    String[] DEFAULT_ALLOWED_HEADERS = { "*" };

    boolean DEFAULT_ALLOW_CREDENTIALS = true;

    long DEFAULT_MAX_AGE = 1800;


    @AliasFor("origins")
    String[] value() default {};

    @AliasFor("value")
    String[] origins() default {};

    String[] allowedHeaders() default {};

    String[] exposedHeaders() default {};

    RequestMethod[] methods() default {};

    String allowCredentials() default "";

    long maxAge() default -1;

}