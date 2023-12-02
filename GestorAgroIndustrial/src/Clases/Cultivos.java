
package Clases;


public class Cultivos {
    
    private String id_cultivo;
    private String nombre;
    private String descripcion;
    private String tiempo_cosecha;
    private String estado;
    private String id_finca;

    // Constructor
    public Cultivos(String id_cultivo, String nombre, String descripcion, String tiempo_cosecha, String estado, String id_finca) {
        this.id_cultivo = id_cultivo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tiempo_cosecha = tiempo_cosecha;
        this.estado = estado;
        this.id_finca = id_finca;
    }

    public String getId_cultivo() {
        return id_cultivo;
    }

    public void setId_cultivo(String id_cultivo) {
        this.id_cultivo = id_cultivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTiempo_cosecha() {
        return tiempo_cosecha;
    }

    public void setTiempo_cosecha(String tiempo_cosecha) {
        this.tiempo_cosecha = tiempo_cosecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getId_finca() {
        return id_finca;
    }

    public void setId_finca(String id_finca) {
        this.id_finca = id_finca;
    }
    
}
