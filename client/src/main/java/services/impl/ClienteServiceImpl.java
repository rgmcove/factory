package services.impl;

import model.Cliente;
import model.TipoDocumento;
import model.dto.ClienteDTO;
import model.views.ClienteViews;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ClienteRepository;
import repository.TipoDocumentoRepository;
import services.ClienteService;

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
