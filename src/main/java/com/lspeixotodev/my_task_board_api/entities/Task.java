package com.lspeixotodev.my_task_board_api.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 50, unique = true)
    private String title;

    @Column(nullable = false)
    private boolean completed;

    /*
    O fetch = FetchType.EAGER significa que a entidade relacionada é carregada
    imediatamente junto da a entidade principal, independentemente de você precisar dela ou não.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id") //category_id será chave estrangeira na tabela task
    private Category category;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private Date updatedAt;

    public Task() {
    }

    public Task(UUID id, String title, boolean completed, Date createdAt, Date updatedAt) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Task(UUID id, String title, boolean completed, Category category, Date createdAt, Date updatedAt) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.category = category;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Task {" +
               "Id: " + id +
               "| Title: '" + title + '\'' +
               "| Completed: " + completed +
               "| Category: " + category +
               "| Created At: " + createdAt +
               "| Updated At: " + updatedAt +
               '}';
    }
}
