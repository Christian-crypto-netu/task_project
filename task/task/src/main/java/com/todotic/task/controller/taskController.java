package com.todotic.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.todotic.task.model.task;
import com.todotic.task.repo.TaskRepository;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/task")
public class taskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("")
    List<task> index() {
        return taskRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    task create(@RequestBody task Task) {
        return taskRepository.save(Task);
    }

    @PutMapping("{id}")
    task update(@PathVariable String id, @RequestBody task Task) {
        task TaskFromDb = taskRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        TaskFromDb.setNombre(Task.getNombre());
        TaskFromDb.setCompleted(Task.isCompleted());

        return taskRepository.save(TaskFromDb);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable String id) {
        task Task = taskRepository
                .findById(id)
                .orElseThrow(RuntimeException::new);

        taskRepository.delete(Task);
    }
}
