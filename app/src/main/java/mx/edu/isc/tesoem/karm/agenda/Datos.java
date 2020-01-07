package mx.edu.isc.tesoem.karm.agenda;

public class Datos {
    private String Nombre;
    private String Telefono;
    private String Correo;
    private String Direccion;

    public Datos(String nombre, String telefono, String direccion, String correo) {
        Nombre = nombre;
        Telefono= telefono;
        Direccion = direccion;
        Correo = correo;

    }

    public Datos() {

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion= direccion;
    }
}


