package br.com.gerenciamentodevendas.gerenciamentodevendas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.gerenciamentodevendas.gerenciamentodevendas.domain.sale.Sale;
import br.com.gerenciamentodevendas.gerenciamentodevendas.domain.sale.SaleItem;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.sales.requests.CreateSaleRequestDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.sales.requests.SaleItemRequestDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.sales.responses.CreateSaleResponseDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.sales.responses.SaleItemResponseDTO;

@Mapper(componentModel = "spring")
public interface SaleMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "totalPrice", ignore = true)
    @Mapping(target = "client", ignore = true)
    @Mapping(target = "items", ignore = true)
    Sale toEntity(CreateSaleRequestDTO createSaleRequestDTO);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "sale", ignore = true)
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "subTotal", ignore = true)
    @Mapping(target = "unitPrice", ignore = true)
    SaleItem toSaleItem(SaleItemRequestDTO item);

    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "items", source = "items")
    CreateSaleResponseDTO toCreateSaleResponse(Sale sale);

    @Mapping(target = "productId", source = "product.id")
    SaleItemResponseDTO toSaleItemResponse(SaleItem saleItem);
}
