package com.wleydsonlemos.apiservicos.repository;

import com.wleydsonlemos.apiservicos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
