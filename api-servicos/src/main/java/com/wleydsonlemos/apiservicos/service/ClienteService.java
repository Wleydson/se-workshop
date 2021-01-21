package com.wleydsonlemos.apiservicos.service;

import com.wleydsonlemos.apiservicos.model.Cliente;
import com.wleydsonlemos.apiservicos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) throws Exception {
        Cliente cliente = buscarCliente(id);
        if (cliente != null)
            return cliente;

        throw new Exception();
    }

    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizarCliente(Cliente cliente, Long id) {
        Cliente clienteBase = buscarCliente(id);
        cliente.setId(clienteBase.getId());
        cliente = clienteRepository.save(cliente);
        return cliente;
    }

    public Cliente desativarCliente(Long id) {
        Cliente cliente = buscarCliente(id);
        cliente.setAtivo(false);

        return clienteRepository.save(cliente);
    }

    public void deletarCliente(Long id) {
        Cliente cliente = buscarCliente(id);
        clienteRepository.delete(cliente);
    }

    private Cliente buscarCliente(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);

        if(cliente.isPresent()){
            return cliente.get();
        }
        return null;
    }

}
