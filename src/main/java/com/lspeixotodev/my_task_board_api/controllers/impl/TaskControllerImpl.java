package com.lspeixotodev.my_task_board_api.controllers.impl;

import com.lspeixotodev.my_task_board_api.controllers.TaskController;
import com.lspeixotodev.my_task_board_api.dtos.TaskDTO;
import com.lspeixotodev.my_task_board_api.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping(value = "/api/v1/task")
public class TaskControllerImpl implements TaskController {

    @Autowired
    private TaskService taskService;


    @Override
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        return new ResponseEntity<>(this.taskService.getAllTasks(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TaskDTO> createTask(TaskDTO taskDTO) {
        return new ResponseEntity<>(this.taskService.createTask(taskDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<TaskDTO> findTaskById(String id) {
        return new ResponseEntity<>(this.taskService.findTaskById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TaskDTO> updateTask(String id, TaskDTO task) {
        return new ResponseEntity<>(this.taskService.updateTask(id, task), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TaskDTO> updateTaskCompletedStatus(String id) {
        return new ResponseEntity<>(this.taskService.updateTaskCompletedStatus(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TaskDTO> deleteTask(String id) {
        return new ResponseEntity<>(this.taskService.deleteTask(id), HttpStatus.OK);
    }
}
