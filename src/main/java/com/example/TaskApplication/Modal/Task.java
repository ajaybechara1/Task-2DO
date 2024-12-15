package com.example.TaskApplication.Modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer taskNumber;
  private String taskName;
  private String taskDate;
  private boolean taskDone;

  public Task(Integer taskNumber, String taskName, String taskDate, boolean taskDone) {
    this.taskNumber = taskNumber;
    this.taskName = taskName;
    this.taskDate = taskDate;
    this.taskDone = taskDone;
  }

  public Task() {
  }

  @Override
  public String toString() {
    return "Task{" +
        "taskNumber=" + taskNumber +
        ", taskName='" + taskName + '\'' +
        ", taskDate='" + taskDate + '\'' +
        ", taskDone=" + taskDone +
        '}';
  }

}

