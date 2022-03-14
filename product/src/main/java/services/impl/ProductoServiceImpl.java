package services.impl;

import model.Estado;
import model.Producto;
import model.dto.ProductoDTO;
import model.views.ProductoUpdateViews;
import model.views.ProductoViews;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.EstadoRepository;
import repository.ProductoRepository;
import services.ProductoService;

import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    private final ModelMapper modelMapper;

    public ProductoServiceImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductoDTO findById(Long id) {
        return modelMapper.map(productoRepository.getById(id), ProductoDTO.class);
    }

    @Override
    public ProductoDTO save(ProductoViews productoViews) {
        Estado estado = estadoRepository.getById(productoViews.getEstado());
        Producto producto = modelMapper.map(productoViews, Producto.class);
        producto.setEstado(estado);
        return modelMapper.map(productoRepository.save(producto), ProductoDTO.class);
    }

    @Override
    public void delete(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public ProductoDTO updatePrice(ProductoUpdateViews productoUpdateViews, Long id) {
        Optional<Producto> existsProducto = productoRepository.findById(id);
        if (existsProducto.isPresent()) {
            Producto producto = productoRepository.getById(id);
            producto.setValorUnidad(productoUpdateViews.getValorUnidad());
            return modelMapper.map(productoRepository.save(producto), ProductoDTO.class);
        } else {
            return null;
        }
    }

}
