package br.com.gerenciamentodevendas.gerenciamentodevendas.service.validation;

import java.util.UUID;

import org.springframework.stereotype.Component;

import br.com.gerenciamentodevendas.gerenciamentodevendas.domain.exception.NotFoundException;
import br.com.gerenciamentodevendas.gerenciamentodevendas.repository.ProductRepository;

@Component
public class ProductValidator {
    private final ProductRepository repository;

    public ProductValidator(ProductRepository repository) {
        this.repository = repository;
    }

    public void validateProductExistence(UUID id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Produto não encontrado!");
        }
    }
}