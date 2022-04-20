package com.squadlobo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.squadlobo.api.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

    Long countByCpf(String cpf);
}
