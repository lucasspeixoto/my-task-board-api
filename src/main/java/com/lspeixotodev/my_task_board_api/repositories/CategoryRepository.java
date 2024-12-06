package com.lspeixotodev.my_task_board_api.repositories;

import com.lspeixotodev.my_task_board_api.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
