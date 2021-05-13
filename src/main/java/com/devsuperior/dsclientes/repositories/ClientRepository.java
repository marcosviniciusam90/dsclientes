package com.devsuperior.dsclientes.repositories;

import com.devsuperior.dsclientes.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
