package com.wleydsonlemos.apiservicos.api.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ServicosInputDTO {

    @NotEmpty
    @NotNull
    private String descricao;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private Long clienteId;
}
