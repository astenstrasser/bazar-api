package com.bazarapi.bazar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/products")
public class BazarController {

  @Autowired
  ProductRepository productRepository;

  @GetMapping
  public ResponseEntity<List<Product>> getAllProducts() {
    List<Product> products = productRepository.findAll();
    return ResponseEntity.ok(products);
  }

  @PostMapping
  public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    Product productCreated = productRepository.insert(product);
    URI location = URI.create(String.format("/products/%s", productCreated.get_id()));

    return ResponseEntity.created(location).body(productCreated);
  }


  @GetMapping("/{productId}")
  public ResponseEntity<Product> getProductById(@PathVariable String productId) throws NoSuchElementException {
    Product product = productRepository.findById(productId).orElseThrow(NoSuchElementException::new);
    return ResponseEntity.ok().body(product);
  }
}


