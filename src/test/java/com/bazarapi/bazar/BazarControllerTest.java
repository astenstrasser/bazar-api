package com.bazarapi.bazar;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BazarController.class)
class BazarControllerTest {

  @MockBean
  ProductRepository productRepository;

  @Autowired
  private MockMvc mockMvc;
  private Product mockProduct;
  private ObjectMapper objectMapper;

  @BeforeEach
  void setUp() {
    mockProduct = Product.builder()._id("mock-id").name("Mock Product Name").price(100).build();
    objectMapper = new ObjectMapper();
  }

  @Test
  @SneakyThrows
  void shouldFindAll() {
    when(productRepository.findAll()).thenReturn(List.of(mockProduct));
    this.mockMvc.perform(get("/products")).andExpect(status().isOk());
    verify(productRepository, times(1)).findAll();
  }

  @Test
  @SneakyThrows
  void shouldFindById() {
    when(productRepository.findById(any())).thenReturn(Optional.of(mockProduct));
    this.mockMvc.perform(get("/products/mock-id")).andExpect(status().isOk());
    verify(productRepository, times(1)).findById(eq("mock-id"));
  }

  @Test
  @SneakyThrows
  void shouldCreateProduct() {
    when(productRepository.insert(any(Product.class))).thenReturn(mockProduct);
    this.mockMvc.perform(
        post("/products")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(mockProduct)))
        .andExpect(status().isCreated()).andExpect(header().string("Location", "/products/mock-id"));
    verify(productRepository, times(1)).insert(eq(mockProduct));
  }

  @Test
  @SneakyThrows
  void shouldReturn404WhenNoProductIsFound() {
    when(productRepository.findById(any())).thenThrow(NoSuchElementException.class);
    this.mockMvc.perform(get("/products/mock-id")).andExpect(status().is4xxClientError());
    verify(productRepository, times(1)).findById(eq("mock-id"));
  }
}