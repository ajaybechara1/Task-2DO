package com.example.TaskApplication.Service;

import com.example.TaskApplication.Modal.Task;
import com.example.TaskApplication.repository.TaskRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
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
      Task task = new Task(2,"LEETCODE","20/11/2024",true);
      when(taskRepo.save(task)).thenReturn(task);
      Task actualTasks = taskService.addtask(task);

      assertThat(actualTasks.getTasknumber()).isEqualTo(2);
      assertThat(actualTasks.getTaskName()).isEqualTo("LEETCODE");
      assertThat(actualTasks.getTaskDate()).isEqualTo("20/11/2024");
      assertThat(actualTasks.isTaskdone()).isTrue();

      verify(taskRepo).save(task);
  }

  @Test
  void gettaskbynumber() {
    Task task =new Task(1,"LEETCODE","19/11/2024",true);
    when(taskRepo.findByTasknumber(1)).thenReturn(task);

    Task actualTasks = taskService.gettaskbynumber(1);

    assertThat(actualTasks.getTasknumber()).isEqualTo(1);
    assertThat(actualTasks.getTaskName()).isEqualTo("LEETCODE");
    assertThat(actualTasks.getTaskDate()).isEqualTo("19/11/2024");
    assertThat(actualTasks.isTaskdone()).isTrue();

    verify(taskRepo).findByTasknumber(1);
  }

  @Test
  void updatetask() {
    Task task =new Task(1,"LEETCODE","19/11/2024",true);

    when(taskRepo.save(task)).thenReturn(task);

    Task updatedTask = taskService.updatetask(task);

    assertThat(updatedTask.getTasknumber()).isEqualTo(1);
    assertThat(updatedTask.getTaskName()).isEqualTo("LEETCODE");
    assertThat(updatedTask.getTaskDate()).isEqualTo("19/11/2024");
    assertThat(updatedTask.isTaskdone()).isTrue();

    verify(taskRepo).save(task);
  }

  @Test
  void deletetask() {
    Task taskToDelete = new Task(1,"LEETCODE","19/11/2024",true);
    
    when(taskRepo.findByTasknumber(1)).thenReturn(taskToDelete);
    
    taskService.deletetask(1);

    verify(taskRepo).deleteById(1);
  }
}