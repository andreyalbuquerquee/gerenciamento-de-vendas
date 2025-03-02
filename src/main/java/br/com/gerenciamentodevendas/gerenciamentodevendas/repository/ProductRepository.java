package br.com.gerenciamentodevendas.gerenciamentodevendas.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciamentodevendas.gerenciamentodevendas.domain.product.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    
}
