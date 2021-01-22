package com.wleydsonlemos.apiservicos.api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ServicosDTO {

    private Long id;
    private String descricao;
    private BigDecimal valor;
    private ClienteDTO cliente;

}
