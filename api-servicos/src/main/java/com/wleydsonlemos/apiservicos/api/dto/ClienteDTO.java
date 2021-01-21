package com.wleydsonlemos.apiservicos.api.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private LocalDateTime dataRegistro;
    private boolean ativo;

}
