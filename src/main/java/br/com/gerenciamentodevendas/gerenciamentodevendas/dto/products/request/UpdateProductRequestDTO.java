package br.com.gerenciamentodevendas.gerenciamentodevendas.dto.products.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateProductRequestDTO(
    @NotBlank(message = "O nome do produto não pode estar vazio!")
    @Size(max = 150, message = "Nome do produto não pode ser maior que 150 caracteres!")
    String name,
    
    @NotNull(message = "O preço do produto não pode estar vazio!")
    @DecimalMin(value = "0.01", message = "O preço do produto deve ser maior que 0!")
    @Digits(integer = 10, fraction = 2, message = "O preço do produto deve ter no máximo 10 dígitos inteiros e 2 casas decimais!")
    BigDecimal price
) {}
