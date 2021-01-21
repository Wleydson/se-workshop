package com.wleydsonlemos.apiservicos.api;

import com.wleydsonlemos.apiservicos.model.Cliente;
import com.wleydsonlemos.apiservicos.repository.ClienteRepository;
import com.wleydsonlemos.apiservicos.repository.ServicosRepository;
import com.wleydsonlemos.apiservicos.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> buscarTodos(){
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) throws Exception {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente){
        return service.salvarCliente(cliente);
    }

    @PutMapping("/{id}")
    public Cliente atualizarCliente(@RequestBody Cliente cliente, @PathVariable Long id){
        return service.atualizarCliente(cliente, id);
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id){
        service.deletarCliente(id);
    }

    @PatchMapping("/{id}/desativar")
    public Cliente desativarCliente(@PathVariable Long id){
        return service.desativarCliente(id);
    }

    
}
