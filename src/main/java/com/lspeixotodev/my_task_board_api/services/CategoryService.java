package com.lspeixotodev.my_task_board_api.services;

import com.lspeixotodev.my_task_board_api.dtos.CategoryDTO;
import com.lspeixotodev.my_task_board_api.entities.Category;
import com.lspeixotodev.my_task_board_api.mappers.CategoryMapper;
import com.lspeixotodev.my_task_board_api.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public List<CategoryDTO> getAllCategories() {
        logger.info("Start finding all categories at: {}", LocalDateTime.now());

        List<Category> categories = categoryRepository.findAll();

        return categoryMapper.entitiesToDtos(categories);
    }
}
