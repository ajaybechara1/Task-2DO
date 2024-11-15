package com.example.TaskApplication.Modal;

import org.springframework.stereotype.Component;

@Component
public class Task {

    private int tasknumber;
    private String taskName;
    private String taskDate;
    private boolean taskdone;

    public int getTasknumber() {
        return tasknumber;
    }

    public void setTasknumber(int tasknumber) {
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

    public Task(int tasknumber, String taskName, String taskDate, boolean taskdone) {
        this.tasknumber = tasknumber;
        this.taskName = taskName;
        this.taskDate = taskDate;
        this.taskdone = taskdone;
    }

    public Task() {
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

    //    private String task1;
//
//    private String task2;
//    private String task3;
//    private String task4;
//    private String task5;
//
//
//    public String getTask1() {
//        return task1;
//    }
//
//    public void setTask1(String task1) {
//        this.task1 = task1;
//    }
//
//    public String getTask2() {
//        return task2;
//    }
//
//    public void setTask2(String task2) {
//        this.task2 = task2;
//    }
//
//    public String getTask3() {
//        return task3;
//    }
//
//    public void setTask3(String task3) {
//        this.task3 = task3;
//    }
//
//    public String getTask4() {
//        return task4;
//    }
//
//    public void setTask4(String task4) {
//        this.task4 = task4;
//    }
//
//    public String getTask5() {
//        return task5;
//    }
//
//    public void setTask5(String task5) {
//        this.task5 = task5;
//    }
//
//    public Task(String task1, String task2, String task3, String task4, String task5) {
//        this.task1 = task1;
//        this.task2 = task2;
//        this.task3 = task3;
//        this.task4 = task4;
//        this.task5 = task5;
//    }
//
//    public Task() {
//    }
}
