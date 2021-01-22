package com.wleydsonlemos.apiservicos.service;

import com.wleydsonlemos.apiservicos.api.dto.ServicosDTO;
import com.wleydsonlemos.apiservicos.api.dto.ServicosInputDTO;
import com.wleydsonlemos.apiservicos.model.Servicos;
import com.wleydsonlemos.apiservicos.repository.ServicosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicosService {

    @Autowired
    private ServicosRepository repository;

    public List<ServicosDTO> buscarTodos(){
        return repository.findAll().stream().map(x -> convertDTO(x)).collect(Collectors.toList());
    }

    public ServicosDTO buscarPorId(Long id) {
        return convertDTO(buscarServico(id));
    }

    private Servicos buscarServico(Long id) {
        Optional<Servicos> servicos = repository.findById(id);
        if(servicos.isPresent()){
            return servicos.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado");
    }

    public ServicosDTO atualizar(Long id, ServicosInputDTO dto) {
        Servicos servicosBase = buscarServico(id);
        Servicos servicos = convertEntity(dto);
        servicos.setId(servicosBase.getId());

        servicos = repository.save(servicos);
        return convertDTO(servicos);
    }

    public ServicosDTO salvar(ServicosInputDTO dto){
        Servicos servicos = convertEntity(dto);
        return convertDTO(repository.save(servicos));
    }

    public ServicosDTO convertDTO(Servicos servicos){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(servicos, ServicosDTO.class);
    }

    public Servicos convertEntity(ServicosInputDTO dto){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Servicos.class);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}
