package com.lspeixotodev.my_task_board_api.infra.validations.validators;

import com.lspeixotodev.my_task_board_api.infra.validations.annotations.UniqueTaskTitle;
import com.lspeixotodev.my_task_board_api.repositories.TaskRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueTaskTitleValidator implements ConstraintValidator<UniqueTaskTitle, String> {

    @Override
    public void initialize(UniqueTaskTitle constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public boolean isValid(String title, ConstraintValidatorContext context) {
        return !taskRepository.existsByTitle(title);
    }
}