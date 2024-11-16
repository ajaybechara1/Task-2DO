package com.example.TaskApplication.Service;


import com.example.TaskApplication.Modal.Task;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TaskService {


  List<Task> tasks = Arrays.asList(
    new Task(1, "Leetcode 5 Questions", "14/11/2024", true),
    new Task(2, "Portal 5 Question", "14/11/2024", true),
    new Task(3, "Hospital Managment", "14/11/2024", true),
    new Task(4, "Operating System Project", "14/11/2024", true),
    new Task(5, "Patel Trading Project", "14/11/2024", true));


  public List<Task> getTasks() {
    return tasks;
  }

  public void addtask(Task task) {
    tasks.add(task);
  }

  public Task gettaskbynumber(int tasknumber) {
    return tasks.stream().filter(task -> task.getTasknumber() == tasknumber).findFirst().get();
  }

  public void updatetask(Task task) {
    int index = 0;
    for (int i = 0; i < tasks.size(); i++)
      if (tasks.get(i).getTasknumber() == task.getTasknumber())
        index = i;
    tasks.set(index, task);
  }

  public void deletetask(int tasknumber) {
    int index = 0;
    for (int i = 0; i < tasks.size(); i++)
      if (tasks.get(i).getTasknumber() == tasknumber)
        index = i;
    tasks.remove(index);
  }


//    List<Task> tasks = Arrays.asList(new Task("leetcode 5 questions","portal 5 question","hospital managment","operating system project","patel trading project"));
//
//    public List<Task> getTasks(){
//        return tasks;
//    }
}