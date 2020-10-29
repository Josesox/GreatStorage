package pe.edu.upc.greatstorage.model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "detalleingreso")
public class DetalleIngreso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalleingreso")
    private Long idDetalleingreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ingreso", nullable = false)
    private Ingreso ingreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = false)
    @NotEmpty(message = "No puede dejar este campo vacio")
    private Producto producto;

    @Column(name = "stock", nullable = false)
    @NotEmpty(message = "No puede dejar este campo vacio")
    @Pattern(regexp = "^\\d", message = "Solamente puede ingresar numeros enteros")
    @Min(value = 0, message = "Stock no permitido")
    private int stock;

    @Column(name = "precio_compra", nullable = false)
    @NotEmpty(message = "No puede dejar este campo vacio")
    @Pattern(regexp = "^[0-9]*\\.[0-9]{2}$", message = "No cumple con el standard del dato: *.##")
    @DecimalMin(value = "0.01", message = "Precio Compra no permitido")
    private BigDecimal precioCompra;

    @Column(name = "precio_venta", nullable = false)
    @NotEmpty(message = "No puede dejar este campo vacio")
    @Pattern(regexp = "^[0-9]*\\.[0-9]{2}$", message = "No cumple con el standard del dato: *.##")
    @DecimalMin(value = "0.01", message = "Precio Venta no permitido")
    private BigDecimal precioVenta;

    public DetalleIngreso() {
        super();
    }

    public DetalleIngreso(Long idDetalleingreso, Ingreso ingreso, Producto producto, int stock, BigDecimal precioCompra, BigDecimal precioVenta) {
        this.idDetalleingreso = idDetalleingreso;
        this.ingreso = ingreso;
        this.producto = producto;
        this.stock = stock;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
    }

    public Long getIdDetalleingreso() {
        return idDetalleingreso;
    }

    public void setIdDetalleingreso(Long idDetalleingreso) {
        this.idDetalleingreso = idDetalleingreso;
    }

    public Ingreso getIngreso() {
        return ingreso;
    }

    public void setIngreso(Ingreso ingreso) {
        this.ingreso = ingreso;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(BigDecimal precioCompra) {
        this.precioCompra = precioCompra;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }
}
