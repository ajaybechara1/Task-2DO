package com.example.TaskApplication.Service;

import com.example.TaskApplication.Modal.Task;
import com.example.TaskApplication.repository.TaskRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

  private TaskService taskService;
  @Mock
  private TaskRepo taskRepo;

  @BeforeEach
  void setUp() {
    taskService = new TaskService(taskRepo);
  }

  @Test
  void getTasks() {
    when(taskRepo.findAll()).thenReturn(List.of(new Task(1,"LEETCODE","19/11/2024",true)));

    List<Task> actualTasks = taskService.getTasks();

    assertThat(actualTasks.get(0).getTasknumber()).isEqualTo(1);
    assertThat(actualTasks.get(0).getTaskName()).isEqualTo("LEETCODE");
    assertThat(actualTasks.get(0).getTaskDate()).isEqualTo("19/11/2024");
    assertThat(actualTasks.get(0).isTaskdone()).isTrue();
  }

  @Test
  void addtask() {
  }

  @Test
  void gettaskbynumber() {
  }

  @Test
  void updatetask() {
  }

  @Test
  void deletetask() {
  }
}