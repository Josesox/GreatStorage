package pe.edu.upc.greatstorage.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nombre_usuario", nullable = false, length = 30)
    @NotEmpty(message = "No puede dejar este campo vacio")
    private String nombreUsuario;

    @Column(name = "apellido_usuario", nullable = false, length = 60)
    @NotEmpty(message = "No puede dejar este campo vacio")
    private String apellidoUsuario;

    @ManyToOne
    @JoinColumn(name = "id_tipodocumento")
    @NotEmpty(message = "No puede dejar este campo vacio")
    private TipoDocumento tipodocumentoUsuario;

    @Column(name = "numerodocumento_usuario", nullable = false, length = 12)
    @NotEmpty(message = "No puede dejar este campo vacio")
    @Pattern(regexp = "^[0-9]{8,12}", message = "Solamente puede ingresar digitos de 8 hasta 12 caracteres")
    private String numerodocumentoUsuario;

    @Column(name = "username", nullable = false, length = 50)
    @NotEmpty(message = "No puede dejar este campo vacio")
    private String username;

    @Column(name = "password", nullable = false, length = 50)
    @NotEmpty(message = "No puede dejar este campo vacio")
    private String password;

    @Column(name = "telefono_usuario", length = 15, nullable = false)
    @NotEmpty(message = "No puede dejar este campo vacio")
    @Pattern(regexp = "^[0-9]{7,15}", message = "Solamente puede ingresar digitos de 7 hasta 15 caracteres")
    private String telefonoUsuario;

    @Column(name = "email_usuario", length = 50, nullable = false)
    @NotEmpty(message = "No puede dejar este campo vacio")
    @Email(message = "Credencial no permitida para el campo")
    private String emailUsuario;


    public Usuario() {
        super();
    }

    public Usuario(Long idUsuario, String nombreUsuario, String apellidoUsuario, TipoDocumento tipodocumentoUsuario, String numerodocumentoUsuario, String username,
                   String password, String telefonoUsuario, String emailUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.tipodocumentoUsuario = tipodocumentoUsuario;
        this.numerodocumentoUsuario = numerodocumentoUsuario;
        this.username = username;
        this.password = password;
        this.telefonoUsuario = telefonoUsuario;
        this.emailUsuario = emailUsuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public TipoDocumento getTipodocumentoUsuario() {
        return tipodocumentoUsuario;
    }

    public void setTipodocumentoUsuario(TipoDocumento tipodocumentoUsuario) {
        this.tipodocumentoUsuario = tipodocumentoUsuario;
    }

    public String getNumerodocumentoUsuario() {
        return numerodocumentoUsuario;
    }

    public void setNumerodocumentoUsuario(String numerodocumentoUsuario) {
        this.numerodocumentoUsuario = numerodocumentoUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }
}
