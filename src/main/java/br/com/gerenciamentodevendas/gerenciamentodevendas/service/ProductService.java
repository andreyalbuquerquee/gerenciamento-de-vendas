package br.com.gerenciamentodevendas.gerenciamentodevendas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.gerenciamentodevendas.gerenciamentodevendas.domain.product.Product;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.products.request.CreateProductRequestDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.products.response.CreateProductResponseDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.products.response.GetProductResponseDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.mapper.ProductMapper;
import br.com.gerenciamentodevendas.gerenciamentodevendas.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final ProductMapper productMapper;


    public ProductService(ProductRepository repository, ProductMapper productMapper) {
        this.repository = repository;
        this.productMapper = productMapper;
    }

    public CreateProductResponseDTO create(CreateProductRequestDTO request) {
        Product newProduct = productMapper.toEntity(request);
        
        return productMapper.toCreateResponse(this.repository.save(newProduct));
    }

    public List<GetProductResponseDTO> getAll() {
        return productMapper.toResponseList(repository.findAll());
    }
}
