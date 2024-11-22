package com.example.TaskApplication.Service;


import com.example.TaskApplication.Modal.Task;
import com.example.TaskApplication.repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {


  TaskRepo repo;

  public TaskService(TaskRepo repo) {
    this.repo = repo;
  }

//  List<Task> tasks = Arrays.asList(
//    new Task(1, "Leetcode 5 Questions", "14/11/2024", true),
//    new Task(2, "Portal 5 Question", "14/11/2024", true),
//    new Task(3, "Hospital Managment", "14/11/2024", true),
//    new Task(4, "Operating System Project", "14/11/2024", true),
//    new Task(5, "Patel Trading Project", "14/11/2024", true));


  public List<Task> getTasks() {
    return repo.findAll();
  }

  public Task addtask(Task task) {
    return repo.save(task);
  }

  public Task gettaskbynumber(Integer tasknumber) {
    return repo.findByTasknumber(tasknumber);
  }

  public Task updatetask(Task task) {
    return repo.save(task);

  }

  public void deletetask(Integer tasknumber) {
    repo.deleteById(tasknumber);
  }

}