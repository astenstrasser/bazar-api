package com.bazarapi.bazar;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BazarController.class)
class BazarControllerTest {

  @MockBean
  ProductRepository productRepository;

  @Autowired
  private MockMvc mockMvc;


  @Test
  @SneakyThrows
  void shouldFindAll() {
    this.mockMvc.perform(get("/product")).andExpect(status().isOk());
    verify(productRepository, times(1)).findAll();
  }
}