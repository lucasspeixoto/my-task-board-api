package com.lspeixotodev.my_task_board_api.infra.validations.annotations;

import com.lspeixotodev.my_task_board_api.infra.validations.validators.UniqueTaskTitleValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { UniqueTaskTitleValidator.class })
public @interface UniqueTaskTitle {
    String message() default "O título deve ser único";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
