package com.example.TaskApplication.repository;

import com.example.TaskApplication.Modal.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

  Task findByTaskNumber(Integer taskNumber);

}
