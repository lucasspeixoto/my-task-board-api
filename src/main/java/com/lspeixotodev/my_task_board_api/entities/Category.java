package com.lspeixotodev.my_task_board_api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lspeixotodev.my_task_board_api.enums.Color;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "category")
@JsonIgnoreProperties(value = {"tasks"})
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 50)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private Color color;

    /*
    O mappedBy = "category" indica que o atributo category
    na entidade Task é o lado que mapeia o relacionamento.

    O fetch = FetchType.LAZY significa qye a entidade relacionada não é
    carregada imediatamente. Em vez disso, é carregada sob demanda,
    quando o relacionamento for acessado pela primeira vez.

    O cascade = CascadeType.ALL garante que operações realizadas
    em Category sejam propagadas para as tarefas associadas.

    O orphanRemoval = true remove tarefas que não têm mais uma categoria associada.
     */
    @OneToMany(
            mappedBy = "category",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Task> tasks = new ArrayList<>();

    public Category() {
    }

    public Category(UUID id, String title, Color color) {
        this.id = id;
        this.title = title;
        this.color = color;
    }

    public Category(UUID id, String title, Color color, List<Task> tasks) {
        this.id = id;
        this.title = title;
        this.color = color;
        this.tasks = tasks;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Category {" +
               "Id: " + id +
               "| Title: '" + title + '\'' +
               "| Color: " + color +
               '}';
    }
}
