package com.lspeixotodev.my_task_board_api.services;

import com.lspeixotodev.my_task_board_api.dtos.TaskDTO;
import com.lspeixotodev.my_task_board_api.entities.Category;
import com.lspeixotodev.my_task_board_api.entities.Task;
import com.lspeixotodev.my_task_board_api.infra.exceptions.ResourceNotFoundException;
import com.lspeixotodev.my_task_board_api.mappers.TaskMapper;
import com.lspeixotodev.my_task_board_api.repositories.CategoryRepository;
import com.lspeixotodev.my_task_board_api.repositories.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TaskMapper taskMapper;

    public List<TaskDTO> getAllTasks() {
        logger.info("Start finding all tasks at: {}", LocalDateTime.now());

        List<Task> tasks = taskRepository.findAll();

        return taskMapper.entitiesToDtos(tasks);
    }

    public TaskDTO createTask(TaskDTO taskDTO) {
        logger.info("Start creating a new task at: {}", LocalDateTime.now());

        Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString(taskDTO.getCategoryId()));

        if(optionalCategory.isEmpty()) {
            logger.info("Required task for create already exists!");
            throw new ResourceNotFoundException("Category", "id", taskDTO.getCategoryId());
        }

        Task task = taskMapper.dtoToEntity(taskDTO);
        task.setCategory(optionalCategory.get());

        Task savedTask = taskRepository.save(task);

        return taskMapper.entityToDTO(savedTask);
    }

    public TaskDTO findTaskById(String id) {
        logger.info("Start finding a task by id at: {}", LocalDateTime.now());

        Optional<Task> optionalTask = taskRepository.findById(UUID.fromString(id));

        if(optionalTask.isEmpty()) {
            logger.info("Required task is not found");
            throw new ResourceNotFoundException("Task", "id", id);
        }

        return taskMapper.entityToDTO(optionalTask.get());
    }

    public TaskDTO updateTask(String id, TaskDTO taskDTO) {
        logger.info("Start updating a task by id at: {}", LocalDateTime.now());

        Optional<Task> optionalTask = taskRepository.findById(UUID.fromString(id));

        if(optionalTask.isEmpty()) {
            logger.info("Required task for update is not found");
            throw new ResourceNotFoundException("Task", "id", id);
        }

        Task task = optionalTask.get();
        task.setTitle(taskDTO.getTitle());
        task.setCompleted(taskDTO.getCompleted());

        Task updatedTask = taskRepository.save(task);

        return taskMapper.entityToDTO(updatedTask);
    }

    public TaskDTO updateTaskCompletedStatus(String id) {
        logger.info("Start updating a task's completed status by id at: {}", LocalDateTime.now());

        UUID taskId = UUID.fromString(id);

        Optional<Task> optionalTask = taskRepository.findById(taskId);

        if(optionalTask.isEmpty()) {
            logger.info("Required task for update completed status is not found");
            throw new ResourceNotFoundException("Task", "id", id);
        }

        Task task = optionalTask.get();

        taskRepository.updateTaskCompletedStatus(taskId);

        task.setCompleted(true);

        return taskMapper.entityToDTO(optionalTask.get());
    }

    public TaskDTO deleteTask(String id) {
        logger.info("Start deleting a task by id at: {}", LocalDateTime.now());

        UUID taskId = UUID.fromString(id);

        Optional<Task> optionalTask = taskRepository.findById(taskId);

        if(optionalTask.isEmpty()) {
            logger.info("Required task for delete is not found");
            throw new ResourceNotFoundException("Task", "id", id);
        }

        Task task = optionalTask.get();

        taskRepository.delete(task);

        return taskMapper.entityToDTO(task);
    }
}
