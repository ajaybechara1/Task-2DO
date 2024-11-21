package com.example.TaskApplication.Controller;

import com.example.TaskApplication.Modal.Task;
import com.example.TaskApplication.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

  @Autowired
  TaskService taskService;


  @GetMapping("/task")
  public List<Task> gettask() {
    return taskService.getTasks();
  }

  @GetMapping("/task/{tasknumber}")
  public Task gettaskbynumber(@PathVariable Integer tasknumber) {
    return taskService.gettaskbynumber(tasknumber);
  }

  @PostMapping("/task")
  public void addtask(@RequestBody Task task) {
    taskService.addtask(task);
  }

  @PutMapping("/task")
  public void updatetask(@RequestBody Task task) {
    taskService.updatetask(task);
  }

  @DeleteMapping("/task/{tasknumber}")
  public void deletetask(@PathVariable Integer tasknumber) {
    taskService.deletetask(tasknumber);
  }


}
