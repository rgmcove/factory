package com.example.factory.client.services.impl;

import com.example.factory.client.model.Cliente;

import com.example.factory.client.model.TipoDocumento;
import com.example.factory.client.model.dto.ClienteDTO;
import com.example.factory.client.model.views.ClienteViews;
import com.example.factory.client.repository.ClienteRepository;
import com.example.factory.client.repository.TipoDocumentoRepository;
import com.example.factory.client.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    private final ModelMapper modelMapper;

    public ClienteServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ClienteDTO findById(Long id) {
        return modelMapper.map(clienteRepository.getById(id), ClienteDTO.class);
    }

    @Override
    public ClienteDTO save(ClienteViews clienteViews) {
        TipoDocumento tipoDocumentoipo = tipoDocumentoRepository.getById(clienteViews.getTipoDocumento());
        Cliente cliente = modelMapper.map(clienteViews, Cliente.class);
        cliente.setTipoDocumento(tipoDocumentoipo);
        return modelMapper.map(clienteRepository.save(cliente), ClienteDTO.class);
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }


}
