package br.com.gerenciamentodevendas.gerenciamentodevendas.service.validation;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import br.com.gerenciamentodevendas.gerenciamentodevendas.domain.exception.NotFoundException;
import br.com.gerenciamentodevendas.gerenciamentodevendas.domain.product.Product;
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

    public void validateProductsExistence(List<UUID> ids) {
        List<Product> products = repository.findAllById(ids);
    
        if (products.size() != ids.size()) {
            throw new NotFoundException("Produto não encontrado!");
        }
    }
}