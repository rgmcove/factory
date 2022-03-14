package repository;

import model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository1 extends JpaRepository<Producto, Long> {
}