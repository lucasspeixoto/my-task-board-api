package com.lspeixotodev.my_task_board_api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lspeixotodev.my_task_board_api.infra.validations.ValidationGroups;
import com.lspeixotodev.my_task_board_api.infra.validations.annotations.UniqueTaskTitle;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class TaskDTO {

    private String id;

    @NotEmpty(message = "The title is required!")
    @Size(min = 3, message = "The title must contain 3 characters!")
    @UniqueTaskTitle(message = "This title already exists!", groups = ValidationGroups.Create.class)
    private String title;

    @NotNull(message = "The status is required!")
    private boolean completed;

    @NotEmpty(message = "The category id is required!")
    private String categoryId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS", timezone = "America/Sao_Paulo")
    private Date createdAt;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS", timezone = "America/Sao_Paulo")
    private Date updatedAt;

    public TaskDTO() {
    }

    public TaskDTO(String id, String title, boolean completed, String categoryId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.categoryId = categoryId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
