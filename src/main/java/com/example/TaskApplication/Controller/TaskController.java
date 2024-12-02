package com.example.TaskApplication.Controller;

import com.example.TaskApplication.Modal.Task;
import com.example.TaskApplication.Service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

  @Autowired
  TaskService taskService;

  @GetMapping("/tasks")
  public List<Task> getTask() {
    return taskService.getTasks();
  }

  @GetMapping("/tasks/{taskNumber}")
  public Task getTaskByNumber(@PathVariable Integer taskNumber) {
    return taskService.getTaskByNumber(taskNumber);
  }

  @PostMapping("/tasks")
  public void addTask(@RequestBody Task task) {
    taskService.addtask(task);
  }

  @PutMapping("/tasks")
  public void updateTask(@RequestBody Task task) {
    taskService.updatetask(task);
  }

  @DeleteMapping("/tasks/{taskNumber}")
  public void deleteTask(@PathVariable Integer taskNumber) {
    taskService.deleteTask(taskNumber);
  }

}
