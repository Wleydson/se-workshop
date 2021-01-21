package com.wleydsonlemos.apiservicos.api;

import com.wleydsonlemos.apiservicos.api.dto.ClienteDTO;
import com.wleydsonlemos.apiservicos.api.dto.ClienteInputDTO;
import com.wleydsonlemos.apiservicos.model.Cliente;
import com.wleydsonlemos.apiservicos.repository.ClienteRepository;
import com.wleydsonlemos.apiservicos.repository.ServicosRepository;
import com.wleydsonlemos.apiservicos.service.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<ClienteDTO> buscarTodos(){
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public ClienteDTO buscarPorId(@PathVariable Long id) throws Exception {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ClienteDTO criarCliente(@RequestBody @Valid ClienteInputDTO cliente){
        return service.salvarCliente(cliente);
    }

    @PutMapping("/{id}")
    public ClienteDTO atualizarCliente(@RequestBody Cliente cliente, @PathVariable Long id){
        return service.atualizarCliente(cliente, id);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id){
        service.deletarCliente(id);
    }

    @PatchMapping("/{id}/desativar")
    public ClienteDTO desativarCliente(@PathVariable Long id){
        return service.desativarCliente(id);
    }

    
}
