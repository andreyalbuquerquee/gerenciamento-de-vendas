package br.com.gerenciamentodevendas.gerenciamentodevendas.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.gerenciamentodevendas.gerenciamentodevendas.domain.product.Product;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.products.request.CreateProductRequestDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.products.response.CreateProductResponseDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.products.response.GetProductResponseDTO;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "id", ignore = true)
    Product toEntity(CreateProductRequestDTO createProductDTO);

    CreateProductResponseDTO toCreateResponse(Product product);
    List<GetProductResponseDTO> toResponseList(List<Product> products);
    GetProductResponseDTO toGetResponse(Product product);
}
