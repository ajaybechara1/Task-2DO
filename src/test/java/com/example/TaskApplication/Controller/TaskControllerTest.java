package com.example.TaskApplication.Controller;

import com.example.TaskApplication.Modal.Task;
import com.example.TaskApplication.Service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


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
  void gettask() throws Exception {
    List<Task> mockTasks = List.of(new Task(1, "Task 1", "2024-11-21", false));
    when(taskService.getTasks()).thenReturn(mockTasks);

    mockMvc.perform(get("/task"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$[0].taskName").value("Task 1"))
      .andExpect(jsonPath("$[0].tasknumber").value(1))
      .andExpect(jsonPath("$[0].taskDate").value("2024-11-21"))
      .andExpect(jsonPath("$[0].taskdone").value(false));

    verify(taskService, times(1)).getTasks();
  }

  @Test
  void gettaskbynumber() {
  }

  @Test
  void addtask() {
  }

  @Test
  void updatetask() {
  }

  @Test
  void deletetask() {
  }
}