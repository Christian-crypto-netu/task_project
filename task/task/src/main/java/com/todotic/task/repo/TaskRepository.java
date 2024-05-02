package com.todotic.task.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.todotic.task.model.task;

public interface TaskRepository extends MongoRepository<task, String> {
}
