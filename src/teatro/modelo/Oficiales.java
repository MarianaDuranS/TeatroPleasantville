package teatro.modelo;
import java.util.Date;
public class Oficiales {
    private String idOficial,idMiembro,cargo;
    private Date fechaInicio,fechaFin;

    public Oficiales(String idOficial,String idMiembro,String cargo,Date fechaInicio, Date fechaFin){
        this.idOficial=idOficial;
        this.idMiembro=idMiembro;
        this.cargo=cargo;
        this.fechaInicio=fechaInicio;
        this.fechaFin=fechaFin;
    }

    public String getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(String idMiembro) {
        this.idMiembro = idMiembro;
    }

    public String getIdOficial() {
        return idOficial;
    }

    public void setIdOficial(String idOficial) {
        this.idOficial = idOficial;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}
