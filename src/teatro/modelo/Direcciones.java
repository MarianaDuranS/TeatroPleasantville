package teatro.modelo;

public class Direcciones {
    private String idDireccion,numeroCasa,calle,colonia,ciudad,estado,codigoPostal,telefono;

    public Direcciones(String idDireccion,String numeroCasa,String calle,String colonia,
                       String ciudad,String estado,String codigoPostal,String telefono){
      this.idDireccion=idDireccion;
      this.numeroCasa=numeroCasa;
      this.calle=calle;
      this.colonia=colonia;
      this.ciudad=ciudad;
      this.estado=estado;
      this.codigoPostal=codigoPostal;
      this.telefono=telefono;
    }

    public String getIdDireccion(){
        return idDireccion;
    }
    public  void setIdDireccion(String idDireccion){
        this.idDireccion=idDireccion;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }
    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
