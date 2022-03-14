package com.example.factory.client.services;

import com.example.factory.client.model.dto.ClienteDTO;
import com.example.factory.client.model.views.ClienteViews;

public interface ClienteService {
    ClienteDTO findById(Long id);

    ClienteDTO save(ClienteViews clienteViews);

    void delete(Long id);
}
