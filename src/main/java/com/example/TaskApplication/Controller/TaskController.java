package com.example.TaskApplication.Controller;

import com.example.TaskApplication.Modal.Task;
import com.example.TaskApplication.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/task")
    public List<Task> gettask(){
        return taskService.getTasks();
    }

    @GetMapping("/task/{tasknumber}")
    public Task gettaskbynumber(@PathVariable int tasknumber){
        return taskService.gettaskbynumber(tasknumber);
    }

    @PostMapping("/task")
    public void addtask(@RequestBody Task task){
        taskService.addtask(task);
    }

    @PutMapping("/task")
    public void updatetask(@RequestBody Task task){
        taskService.updatetask(task);
    }

    @DeleteMapping("/task/{tasknumber}")
    public void deletetask(@PathVariable int tasknumber){
        taskService.deletetask(tasknumber);
    }



}
