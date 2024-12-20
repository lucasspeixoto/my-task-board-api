package com.lspeixotodev.my_task_board_api.infra.validations;

import jakarta.validation.groups.Default;

/**
 * Utility classes to distinct CRUD validations.<br>
 * <br>
 * Used with the
 * {@link org.springframework.validation.annotation.Validated @Validated}
 * Spring annotation.
 */
public final class ValidationGroups {

    private ValidationGroups() {
    }

    public interface Create extends Default {
    }

    public interface Update extends Default {
    }
}
