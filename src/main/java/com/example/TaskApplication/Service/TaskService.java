package com.example.TaskApplication.Service;


import com.example.TaskApplication.Modal.Task;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TaskService {


    List<Task> tasks = Arrays.asList(
            new Task("Leetcode 5 Questions","14/11/2024",true),
            new Task("Portal 5 Question","14/11/2024",true),
            new Task("Hospital Managment","14/11/2024",true),
            new Task("Operating System Project","14/11/2024",true),
            new Task("Patel Trading Project","14/11/2024",true));


    public List<Task> getTasks(){
        return tasks;
    }


//    List<Task> tasks = Arrays.asList(new Task("leetcode 5 questions","portal 5 question","hospital managment","operating system project","patel trading project"));
//
//    public List<Task> getTasks(){
//        return tasks;
//    }
}