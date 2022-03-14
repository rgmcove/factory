package services;

import model.dto.ClienteDTO;
import model.views.ClienteViews;

public interface ClienteService {
    ClienteDTO findById(Long id);

    ClienteDTO save(ClienteViews clienteViews);

    void delete(Long id);
}
