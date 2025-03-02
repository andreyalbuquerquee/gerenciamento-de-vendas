package br.com.gerenciamentodevendas.gerenciamentodevendas.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.gerenciamentodevendas.gerenciamentodevendas.domain.product.Product;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.products.request.CreateProductRequestDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.products.response.CreateProductResponseDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.products.response.GetProductResponseDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.mapper.ProductMapper;
import br.com.gerenciamentodevendas.gerenciamentodevendas.repository.ProductRepository;
import br.com.gerenciamentodevendas.gerenciamentodevendas.service.validation.ProductValidator;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final ProductMapper productMapper;
    private final ProductValidator validator;

    public ProductService(ProductRepository repository, ProductMapper productMapper, ProductValidator validator) {
        this.repository = repository;
        this.productMapper = productMapper;
        this.validator = validator;
    }

    public CreateProductResponseDTO create(CreateProductRequestDTO request) {
        Product newProduct = productMapper.toEntity(request);
        
        return productMapper.toCreateResponse(this.repository.save(newProduct));
    }

    public List<GetProductResponseDTO> getAll() {
        return productMapper.toResponseList(repository.findAll());
    }

    public GetProductResponseDTO getById(UUID id) {
        validator.validateProductExistence(id);
    
        return productMapper.toGetResponse(repository.findById(id).get());
    }
}
