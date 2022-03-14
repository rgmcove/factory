package com.example.factory.product.services.impl;

import com.example.factory.product.model.Estado;
import com.example.factory.product.model.Producto;
import com.example.factory.product.model.dto.ProductoDTO;
import com.example.factory.product.model.views.ProductoUpdateViews;
import com.example.factory.product.model.views.ProductoViews;
import com.example.factory.product.repository.EstadoRepository;
import com.example.factory.product.repository.ProductoRepository;
import com.example.factory.product.services.ProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
