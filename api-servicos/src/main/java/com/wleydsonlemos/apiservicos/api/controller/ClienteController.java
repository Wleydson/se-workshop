package com.wleydsonlemos.apiservicos.api;

import com.wleydsonlemos.apiservicos.api.dto.ClienteDTO;
import com.wleydsonlemos.apiservicos.api.dto.ClienteInputDTO;
import com.wleydsonlemos.apiservicos.model.Cliente;
import com.wleydsonlemos.apiservicos.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cliente")
@Api("Cliente Api")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    @ApiOperation("Buscar todos clientes")
    public List<ClienteDTO> buscarTodos(){
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    @ApiOperation("Buscar um cliente por id")
    public ClienteDTO buscarPorId(@PathVariable Long id) throws Exception {
        return service.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Cria um cliente")
    public ClienteDTO criarCliente(@RequestBody @Valid ClienteInputDTO cliente){
        return service.salvarCliente(cliente);
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualiza um cliente completo")
    public ClienteDTO atualizarCliente(@RequestBody Cliente cliente, @PathVariable Long id){
        return service.atualizarCliente(cliente, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Exclui um cliente")
    public void deletarCliente(@PathVariable Long id){
        service.deletarCliente(id);
    }

    @PatchMapping("/{id}/desativar")
    @ApiOperation("Desativa um cliente")
    public ClienteDTO desativarCliente(@PathVariable Long id){
        return service.desativarCliente(id);
    }

    
}
