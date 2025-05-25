package teatro.modelo;
import java.util.Date;
public class Miembros {
    private String idMiembro,nombre,primerApellido,segundoApellido,genero,email,estadoCuota,idDireccion;
    private Date fechaNacimiento;

    public Miembros(String idMiembro,String nombre,String primerApellido, String segundoApellido,Date fechaNacimiento,
                    String genero,String email, String estadoCuota, String idDireccion){
        this.idMiembro= idMiembro;
        this.nombre=nombre;
        this.primerApellido=primerApellido;
        this.segundoApellido=segundoApellido;
        this.fechaNacimiento=fechaNacimiento;
        this.genero=genero;
        this.email=email;
        this.estadoCuota=estadoCuota;
        this.idDireccion=idDireccion;
    }

    public String getIdMiembro() {
        return idMiembro;
    }
    public void setIdMiembro(String idMiembro) {
        this.idMiembro = idMiembro;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPrimerApellido() {
        return primerApellido;
    }
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
    public String getSegundoApellido() {
        return segundoApellido;
    }
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadoCuota() {
        return estadoCuota;
    }

    public void setEstadoCuota(String estadoCuota) {
        this.estadoCuota = estadoCuota;
    }

    public String getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(String idDireccion) {
        this.idDireccion = idDireccion;
    }
}
