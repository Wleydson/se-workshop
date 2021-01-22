package com.wleydsonlemos.apiservicos.api.controller;

import com.wleydsonlemos.apiservicos.api.dto.ServicosDTO;
import com.wleydsonlemos.apiservicos.api.dto.ServicosInputDTO;
import com.wleydsonlemos.apiservicos.service.ServicosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/servicos")
@Api("Serviços Api")
public class ServicosController {

    @Autowired
    private ServicosService service;

    @GetMapping
    @ApiOperation("Buscar todos serviços")
    private List<ServicosDTO> buscarTodos(){
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    @ApiOperation("Buscar serviço por id")
    private ServicosDTO buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Salvar novo serviço")
    private ServicosDTO salvarServicos(@RequestBody @Valid ServicosInputDTO dto){
        return service.salvar(dto);
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualiza um serviço")
    private ServicosDTO atualizarServicos(@PathVariable Long id, @RequestBody @Valid ServicosInputDTO dto){
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Exclui um serviço")
    private void removerServico(@PathVariable Long id){
        service.remover(id);
    }

}
