package com.wleydsonlemos.apiservicos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private LocalDateTime dataRegistro;
    private boolean ativo;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Servicos> servicos = new ArrayList<>();

    @PrePersist
    public void antesDeSalvar(){
        setDataRegistro(LocalDateTime.now());
        setAtivo(true);
    }
}
