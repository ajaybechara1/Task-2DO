package com.example.TaskApplication.Service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.TaskApplication.Modal.Task;
import com.example.TaskApplication.repository.TaskRepo;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

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
  void testGetTasks_shouldReturnTasks() {
    when(taskRepo.findAll()).thenReturn(List.of(new Task(1, "LEETCODE", "19/11/2024", true)));

    List<Task> actualTasks = taskService.getTasks();

    assertThat(actualTasks.get(0).getTaskNumber()).isEqualTo(1);
    assertThat(actualTasks.get(0).getTaskName()).isEqualTo("LEETCODE");
    assertThat(actualTasks.get(0).getTaskDate()).isEqualTo("19/11/2024");
    assertThat(actualTasks.get(0).isTaskDone()).isTrue();
  }

  @Test
  void testAddTask_shouldCallRepoSaveMethod() {
    Task task = new Task(2, "LEETCODE", "20/11/2024", true);
    when(taskRepo.save(task)).thenReturn(task);
    Task actualTasks = taskService.addtask(task);

    assertThat(actualTasks.getTaskNumber()).isEqualTo(2);
    assertThat(actualTasks.getTaskName()).isEqualTo("LEETCODE");
    assertThat(actualTasks.getTaskDate()).isEqualTo("20/11/2024");
    assertThat(actualTasks.isTaskDone()).isTrue();

    verify(taskRepo).save(task);
  }

  @Test
  void testGetTaskByNumber_shouldReturnTaskForGivenTaskNumber() {
    Task task = new Task(1, "LEETCODE", "19/11/2024", true);
    when(taskRepo.findByTaskNumber(1)).thenReturn(task);

    Task actualTasks = taskService.getTaskByNumber(1);

    assertThat(actualTasks.getTaskNumber()).isEqualTo(1);
    assertThat(actualTasks.getTaskName()).isEqualTo("LEETCODE");
    assertThat(actualTasks.getTaskDate()).isEqualTo("19/11/2024");
    assertThat(actualTasks.isTaskDone()).isTrue();

    verify(taskRepo).findByTaskNumber(1);
  }

  @Test
  void testUpdateTask_shouldUpdateGivenTask() {
    Task task = new Task(1, "LEETCODE", "19/11/2024", true);

    when(taskRepo.save(task)).thenReturn(task);

    Task updatedTask = taskService.updatetask(task);

    assertThat(updatedTask.getTaskNumber()).isEqualTo(1);
    assertThat(updatedTask.getTaskName()).isEqualTo("LEETCODE");
    assertThat(updatedTask.getTaskDate()).isEqualTo("19/11/2024");
    assertThat(updatedTask.isTaskDone()).isTrue();

    verify(taskRepo).save(task);
  }

  @Test
  void testDeleteTask_shouldDeleteGivenTask() {
    taskService.deleteTask(1);

    verify(taskRepo).deleteById(1);
  }
}