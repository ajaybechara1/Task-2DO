package com.example.TaskApplication.Controller;

import com.example.TaskApplication.Modal.Task;
import com.example.TaskApplication.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;

    @RequestMapping("/task")
    public List<Task> gettask(){
        return taskService.getTasks();
    }
}
