package br.com.gerenciamentodevendas.gerenciamentodevendas.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gerenciamentodevendas.gerenciamentodevendas.domain.client.Client;

import java.util.Optional;


public interface ClientRepository extends JpaRepository<Client, UUID> {
    Optional<Client> findByEmail(String email);
}
