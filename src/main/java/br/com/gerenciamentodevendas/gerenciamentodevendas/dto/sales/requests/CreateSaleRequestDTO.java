package br.com.gerenciamentodevendas.gerenciamentodevendas.dto.sales.requests;

import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateSaleRequestDTO(
    @NotNull(message = "O id do cliente não pode ser nulo.")
    UUID clientId,

    @Size(min = 1, message = "A quantidade deve ser pelo menos 1!")
    List<SaleItemRequestDTO> items
) {}
