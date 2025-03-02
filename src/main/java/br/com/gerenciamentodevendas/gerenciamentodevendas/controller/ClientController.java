package br.com.gerenciamentodevendas.gerenciamentodevendas.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gerenciamentodevendas.gerenciamentodevendas.domain.client.Client;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.clients.request.CreateClientRequestDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.clients.request.UpdateClientRequestDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.clients.response.CreateClientResponseDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.clients.response.GetClientResponseDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.clients.response.UpdateClientResponseDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService service;
    
    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreateClientResponseDTO> create(@RequestBody @Valid CreateClientRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }
    
    @GetMapping
    public ResponseEntity<List<Client>> create() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetClientResponseDTO> geyById(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<UpdateClientResponseDTO> updateById(@PathVariable UUID id, @RequestBody UpdateClientRequestDTO request) {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateById(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        service.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
