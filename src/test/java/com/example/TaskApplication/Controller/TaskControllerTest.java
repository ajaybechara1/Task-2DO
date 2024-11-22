package com.example.TaskApplication.Controller;

import com.example.TaskApplication.Modal.Task;
import com.example.TaskApplication.Service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

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
  void gettaskbynumber() throws Exception {
    Task mockTask = new Task(1,"Task 1","21/11/2024",false);

    when(taskService.gettaskbynumber(1)).thenReturn(mockTask);
    mockMvc.perform(get("/task/1"))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.tasknumber").value(1))
      .andExpect(jsonPath("$.taskName").value("Task 1"))
      .andExpect(jsonPath("$.taskDate").value("21/11/2024"))
      .andExpect(jsonPath("$.taskdone").value(false));

    verify(taskService,times(1)).gettaskbynumber(1);
  }

  @Test
  void addtask() throws Exception{

    mockMvc.perform(post("/task")
      .contentType(MediaType.APPLICATION_JSON)
      .content("{\"taskNumber\":1,\"taskName\":\"Task 1\",\"taskDate\":\"2024-11-21\",\"taskDone\":false}"))
      .andExpect(status().isOk());

    verify(taskService,times(1)).addtask(any(Task.class));

  }

  @Test
  void updatetask() throws Exception {


    mockMvc.perform(put("/task")
      .contentType(MediaType.APPLICATION_JSON)
      .content("{\"taskNumber\":1,\"taskName\":\"Task 1\",\"taskDate\":\"2024-11-21\",\"taskDone\":false}"))
      .andExpect(status().isOk());

    verify(taskService,times(1)).updatetask(any(Task.class));
  }

  @Test
  void deletetask() throws Exception {

    Integer taskNumberDelete = 1;

    mockMvc.perform(delete("/task/{tasknumber}",taskNumberDelete))
      .andExpect(status().isOk());

    verify(taskService,times(1)).deletetask(taskNumberDelete);
  }
}