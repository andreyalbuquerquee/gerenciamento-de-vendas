package br.com.gerenciamentodevendas.gerenciamentodevendas.service.validation;

import java.util.UUID;

import org.springframework.stereotype.Component;

import br.com.gerenciamentodevendas.gerenciamentodevendas.domain.exception.BadRequestException;
import br.com.gerenciamentodevendas.gerenciamentodevendas.domain.exception.NotFoundException;
import br.com.gerenciamentodevendas.gerenciamentodevendas.repository.ClientRepository;

@Component
public class ClientValidator {
    private final ClientRepository repository;

    public ClientValidator(ClientRepository repository) {
        this.repository = repository;
    }

    public void validateClientExistence(UUID id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Cliente não encontrado!");
        }
    }

    public void validateEmailInUse(String email) {
        if (repository.findByEmail(email).isPresent()) {
            throw new BadRequestException("Email já cadastrado!");
        }
    }

    public void validateEmailOwnership(UUID id, String email) {
        repository.findByEmail(email).ifPresent(clientWithEmail -> {
            if (!clientWithEmail.getId().equals(id)) {
                throw new BadRequestException("Este e-mail já está em uso por outro cliente.");
            }
        });
    }
}
