package com.wleydsonlemos.apiservicos.repository;

import com.wleydsonlemos.apiservicos.model.Cliente;
import com.wleydsonlemos.apiservicos.model.Servicos;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServicosRepository extends JpaRepository<Servicos, Long> {
}
