package br.com.gerenciamentodevendas.gerenciamentodevendas.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.products.request.CreateProductRequestDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.products.request.UpdateProductRequestDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.products.response.CreateProductResponseDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.products.response.GetProductResponseDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.products.response.UpdateProductResponseDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.service.ProductService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;
    
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreateProductResponseDTO> create(@RequestBody @Valid CreateProductRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<GetProductResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<GetProductResponseDTO> getById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateProductResponseDTO> updateById(@PathVariable UUID id, @RequestBody @Valid UpdateProductRequestDTO request) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateById(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
