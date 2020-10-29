package pe.edu.upc.greatstorage.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "ingreso")
public class Ingreso implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingreso")
    private Long idIngreso;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor proveedor;

    @Column(name = "fecha_ingreso")
    @NotEmpty(message = "No puede dejar este campo vacio")
    @Past(message = "Fecha invalida")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaIngreso;

    @ManyToOne
    @JoinColumn(name = "id_tipocomprobante", nullable = false)
    private TipoComprobante tipocomprobante;

    @Column(name = "numerocomprobante_ingreso", nullable = false, length = 15)
    @NotEmpty(message = "No puede dejar este campo vacio")
    @Pattern(regexp = "^[0-9]{10,15}", message = "Solamente puede ingresar digitos de 10 hasta 15 caracteres")
    private String numerocomprobanteIngreso;

    public Ingreso() {
    }

    public Ingreso(Long idIngreso, Proveedor proveedor, Date fechaIngreso, TipoComprobante tipocomprobante, String numerocomprobanteIngreso) {
        this.idIngreso = idIngreso;
        this.proveedor = proveedor;
        this.fechaIngreso = fechaIngreso;
        this.tipocomprobante = tipocomprobante;
        this.numerocomprobanteIngreso = numerocomprobanteIngreso;
    }

    public Long getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(Long idIngreso) {
        this.idIngreso = idIngreso;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(@NotEmpty(message = "No puede dejar este campo vacio") @Past(message = "Fecha invalida") Date localDate) {
        this.fechaIngreso = localDate;
    }

    public TipoComprobante getTipocomprobante() {
        return tipocomprobante;
    }

    public void setTipocomprobante(TipoComprobante tipocomprobante) {
        this.tipocomprobante = tipocomprobante;
    }

    public String getNumerocomprobanteIngreso() {
        return numerocomprobanteIngreso;
    }

    public void setNumerocomprobanteIngreso(String numerocomprobanteIngreso) {
        this.numerocomprobanteIngreso = numerocomprobanteIngreso;
    }
}

