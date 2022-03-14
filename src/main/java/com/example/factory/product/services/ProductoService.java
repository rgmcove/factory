package com.example.factory.product.services;


import com.example.factory.product.model.dto.ProductoDTO;
import com.example.factory.product.model.views.ProductoUpdateViews;
import com.example.factory.product.model.views.ProductoViews;

public interface ProductoService {
    ProductoDTO findById(Long id);

    ProductoDTO save(ProductoViews productoViews);

    void delete(Long id);

    ProductoDTO updatePrice(ProductoUpdateViews productoUpdateViews, Long id);
}
