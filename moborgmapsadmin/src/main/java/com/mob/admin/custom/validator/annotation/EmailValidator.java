package com.mob.admin.custom.validator.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.mob.admin.custom.validator.ValidateEmail;

@Documented
@Constraint(validatedBy = { ValidateEmail.class })
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailValidator {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
