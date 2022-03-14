package services;

import model.dto.ProductoDTO;
import model.views.ProductoUpdateViews;
import model.views.ProductoViews;

public interface ProductoService {
    ProductoDTO findById(Long id);

    ProductoDTO save(ProductoViews productoViews);

    void delete(Long id);

    ProductoDTO updatePrice(ProductoUpdateViews productoUpdateViews, Long id);
}
