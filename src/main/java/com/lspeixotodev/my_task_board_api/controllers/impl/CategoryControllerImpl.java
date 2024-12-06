package com.lspeixotodev.my_task_board_api.controllers.impl;

import com.lspeixotodev.my_task_board_api.controllers.CategoryController;
import com.lspeixotodev.my_task_board_api.dtos.CategoryDTO;
import com.lspeixotodev.my_task_board_api.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/api/v1/category")
public class CategoryControllerImpl implements CategoryController {

    @Autowired
    private CategoryService categoryService;


    @Override()
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        return new ResponseEntity<>(this.categoryService.getAllCategories(), HttpStatus.OK);
    }
}
