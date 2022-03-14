package model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "factura")
@Data
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura", nullable = false)
    private Long id;

    @Column(name = "cajero", nullable = false, length = 100)
    private String cajero;

    @Column(name = "caja", nullable = false, length = 15)
    private String caja;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "valor_total", nullable = false, precision = 10)
    private BigDecimal valorTotal;

    @ManyToMany
    @JoinTable(name = "factura_producto",
            joinColumns = @JoinColumn(name = "id_factura"),
            inverseJoinColumns = @JoinColumn(name = "id_producto"))
    private Set<Producto> productos = new LinkedHashSet<>();
}