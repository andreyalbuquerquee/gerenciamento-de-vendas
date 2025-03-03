package br.com.gerenciamentodevendas.gerenciamentodevendas.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.sales.requests.CreateSaleRequestDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.sales.responses.CreateSaleResponseDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.sales.responses.GetSaleResponseDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.service.SalesService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/sales")
public class SalesController {
    private final SalesService service;

    public SalesController(SalesService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreateSaleResponseDTO> create(@RequestBody @Valid CreateSaleRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping
    public ResponseEntity<List<GetSaleResponseDTO>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
