package com.lspeixotodev.my_task_board_api.repositories;

import com.lspeixotodev.my_task_board_api.entities.Task;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

    boolean existsByTitle(String title);

    @Modifying
    @Transactional
    @Query("UPDATE Task e SET e.completed = true WHERE e.id = :id")
    void updateTaskCompletedStatus(@Param("id") UUID id);
}
