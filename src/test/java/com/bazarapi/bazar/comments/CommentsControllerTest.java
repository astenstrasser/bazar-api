package com.bazarapi.bazar.comments;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CommentsController.class)
class CommentsControllerTest {

  @MockBean
  CommentsRepository commentsRepository;

  @Autowired
  private MockMvc mockMvc;

  private Comment mockComment;
  private ObjectMapper objectMapper;


  @BeforeEach
  void setUp() {
    mockComment = Comment.builder()
                    .email("example@example.com")
                    .name("Full Name")
                    .productId("mock-product-id")
                    ._id("mock-id")
                    .timestamp(LocalDateTime.now().toString())
                  .build();
    objectMapper = new ObjectMapper();
  }

  @Test
  @SneakyThrows
  void shouldCreateComment() {
    when(commentsRepository.insert(any(Comment.class))).thenReturn(mockComment);
    this.mockMvc.perform(
      post("/comments")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(mockComment)))
      .andExpect(status().isCreated()).andExpect(header().string("Location", "/comments/mock-id"));
    verify(commentsRepository, times(1)).insert(eq(mockComment));
  }

}