package com.example.TaskApplication.Controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.TaskApplication.Modal.Task;
import com.example.TaskApplication.Service.TaskService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
class TaskControllerTest {

  private MockMvc mockMvc;

  @Mock
  private TaskService taskService;

  @InjectMocks
  private TaskController taskController;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
  }

  @Test
  void testGetTask() throws Exception {
    List<Task> mockTasks = List.of(new Task(1, "Task 1", "2024-11-21", false));
    when(taskService.getTasks()).thenReturn(mockTasks);

    mockMvc.perform(get("/tasks"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].taskName").value("Task 1"))
        .andExpect(jsonPath("$[0].taskNumber").value(1))
        .andExpect(jsonPath("$[0].taskDate").value("2024-11-21"))
        .andExpect(jsonPath("$[0].taskDone").value(false));

    verify(taskService, times(1)).getTasks();
  }

  @Test
  void testGetTaskByNumber() throws Exception {
    Task mockTask = new Task(1, "Task 1", "21/11/2024", false);

    when(taskService.getTaskByNumber(1)).thenReturn(mockTask);
    mockMvc.perform(get("/tasks/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.taskNumber").value(1))
        .andExpect(jsonPath("$.taskName").value("Task 1"))
        .andExpect(jsonPath("$.taskDate").value("21/11/2024"))
        .andExpect(jsonPath("$.taskDone").value(false));

    verify(taskService, times(1)).getTaskByNumber(1);
  }

  @Test
  void testAddTask() throws Exception {
    mockMvc.perform(post("/tasks")
            .contentType(MediaType.APPLICATION_JSON)
            .content(
                "{\"taskNumber\":1,\"taskName\":\"Task 1\",\"taskDate\":\"2024-11-21\",\"taskDone\":false}"))
        .andExpect(status().isOk());

    verify(taskService, times(1)).addtask(any(Task.class));
  }

  @Test
  void testUpdateTask() throws Exception {
    mockMvc.perform(put("/tasks")
            .contentType(MediaType.APPLICATION_JSON)
            .content(
                "{\"taskNumber\":1,\"taskName\":\"Task 1\",\"taskDate\":\"2024-11-21\",\"taskDone\":false}"))
        .andExpect(status().isOk());

    verify(taskService, times(1)).updatetask(any(Task.class));
  }

  @Test
  void testDeleteTask() throws Exception {
    Integer taskNumber = 1;

    mockMvc.perform(delete("/tasks/{taskNumber}", taskNumber))
        .andExpect(status().isOk());

    verify(taskService, times(1)).deleteTask(taskNumber);
  }

}