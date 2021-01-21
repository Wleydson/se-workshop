package com.wleydsonlemos.apiservicos.api.dto;


import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
public class ClienteInputDTO {

    @NotEmpty
    private String nome;

    @NotNull
    @CPF
    private String cpf;

    @Email
    private String email;

    @Size(min = 11, max = 13)
    private String telefone;

}
