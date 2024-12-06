package com.lspeixotodev.my_task_board_api.dtos;

import com.lspeixotodev.my_task_board_api.enums.Color;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class CategoryDTO {

    private String id;
    
    @NotEmpty(message = "The title is required!")
    @Size(min = 3, message = "The title must contain 3 characters!")
    private String title;

    @NotEmpty(message = "The color is required!")
    private Color color;

    public CategoryDTO() {
    }

    public CategoryDTO(String id, String title, Color color) {
        this.id = id;
        this.title = title;
        this.color = color;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDTO that = (CategoryDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "CategoryDTO {" +
               "Id: '" + id + '\'' +
               "| Title: '" + title + '\'' +
               "| Color: " + color +
               '}';
    }
}
