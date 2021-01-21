package com.wleydsonlemos.apiservicos.service;

import com.wleydsonlemos.apiservicos.api.dto.ClienteDTO;
import com.wleydsonlemos.apiservicos.api.dto.ClienteInputDTO;
import com.wleydsonlemos.apiservicos.model.Cliente;
import com.wleydsonlemos.apiservicos.repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public List<ClienteDTO> buscarTodos() {
        return clienteRepository.findAll().stream().map(x -> convertDTO(x)).collect(Collectors.toList());
    }

    public ClienteDTO buscarPorId(Long id) throws Exception {
        Cliente cliente = buscarCliente(id);
        if (cliente != null)
            return convertDTO(cliente);

        throw new Exception();
    }

    public ClienteDTO salvarCliente(ClienteInputDTO clienteInputDTO) {
        Cliente cliente = convertEntity(clienteInputDTO);
        return convertDTO(clienteRepository.save(cliente));
    }

    public ClienteDTO atualizarCliente(Cliente cliente, Long id) {
        Cliente clienteBase = buscarCliente(id);
        cliente.setId(clienteBase.getId());
        cliente = clienteRepository.save(cliente);
        return convertDTO(cliente);
    }

    public ClienteDTO desativarCliente(Long id) {
        Cliente cliente = buscarCliente(id);
        cliente.setAtivo(false);

        return convertDTO(clienteRepository.save(cliente));
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

    public ClienteDTO convertDTO(Cliente cliente){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(cliente, ClienteDTO.class);
    }

    public Cliente convertEntity(ClienteInputDTO dto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Cliente.class);
    }
}
