package br.com.gerenciamentodevendas.gerenciamentodevendas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.gerenciamentodevendas.gerenciamentodevendas.domain.client.Client;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.clients.request.CreateClientRequestDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.clients.request.UpdateClientRequestDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.clients.response.CreateClientResponseDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.clients.response.GetClientResponseDTO;
import br.com.gerenciamentodevendas.gerenciamentodevendas.dto.clients.response.UpdateClientResponseDTO;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    @Mapping(target = "id", ignore = true)
    Client toEntity(CreateClientRequestDTO createClientDTO);
    
    @Mapping(target = "id", ignore = true)
    Client toEntity(UpdateClientRequestDTO updateClientDTO);

    CreateClientResponseDTO toCreateResponse(Client client);
    UpdateClientResponseDTO toUpdateResponse(Client client);
    GetClientResponseDTO toGetClientResponseDTO(Client client);
}
