package com.example.TaskApplication.Modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;



@Entity
@Data
public class Task {

  @Id
  private Integer tasknumber;
  private String taskName;
  private String taskDate;
  private boolean taskdone;

  public Task(Integer tasknumber, String taskName, String taskDate, boolean taskdone) {
    this.tasknumber = tasknumber;
    this.taskName = taskName;
    this.taskDate = taskDate;
    this.taskdone = taskdone;
  }

  public Task() {
  }

  public int getTasknumber() {
    return tasknumber;
  }

  public void setTasknumber(Integer tasknumber) {
    this.tasknumber = tasknumber;
  }

  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public String getTaskDate() {
    return taskDate;
  }

  public void setTaskDate(String taskDate) {
    this.taskDate = taskDate;
  }

  public boolean isTaskdone() {
    return taskdone;
  }

  public void setTaskdone(boolean taskdone) {
    this.taskdone = taskdone;
  }

  @Override
  public String toString() {
    return "Task{" +
      "tasknumber=" + tasknumber +
      ", taskName='" + taskName + '\'' +
      ", taskDate='" + taskDate + '\'' +
      ", taskdone=" + taskdone +
      '}';
  }

  public void orElse(Task task) {
    System.out.println("Not a task");
  }
}

