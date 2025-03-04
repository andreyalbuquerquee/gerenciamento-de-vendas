package br.com.gerenciamentodevendas.gerenciamentodevendas.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.gerenciamentodevendas.gerenciamentodevendas.domain.client.Client;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.clients.request.CreateClientRequestDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.clients.request.UpdateClientRequestDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.clients.response.CreateClientResponseDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.clients.response.GetClientResponseDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.clients.response.UpdateClientResponseDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.mapper.ClientMapper;
import br.com.gerenciamentodevendas.gerenciamentodevendas.repository.ClientRepository;
import br.com.gerenciamentodevendas.gerenciamentodevendas.service.validation.ClientValidator;

@Service
public class ClientService {
    
    private final ClientRepository repository;
    private final ClientMapper clientMapper;
    private final ClientValidator validator;
    
    public ClientService(ClientRepository repository, ClientMapper clientMapper, ClientValidator validator) {
        this.repository = repository;
        this.clientMapper = clientMapper;
        this.validator = validator;
    }

    public CreateClientResponseDTO create(CreateClientRequestDTO request) {
        validator.validateEmailInUse(request.email());
        
        Client client = clientMapper.toEntity(request);
        Client newClient = repository.save(client);
        
        return clientMapper.toCreateResponse(newClient);
    }
    
    public List<GetClientResponseDTO> getAll() {
        return clientMapper.toResponseList(repository.findAll());
    }

    public GetClientResponseDTO getById(UUID id) {
        validator.validateClientExistence(id);

        return clientMapper.toGetClientResponseDTO(repository.findById(id).get());
    }
    
    public UpdateClientResponseDTO updateById(UUID id, UpdateClientRequestDTO request) {
        validator.validateClientExistence(id);
        validator.validateEmailOwnership(id, request.email());

        Client updatedClient = clientMapper.toEntity(request);
        updatedClient.setId(id);
        
        repository.save(updatedClient);

        return clientMapper.toUpdateResponse(updatedClient);
    }

    public void deleteById(UUID id) {
        validator.validateClientExistence(id);
        
        repository.deleteById(id);
    }
}