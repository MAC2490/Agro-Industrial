package Clases;

public class insumos {

    String insumos_id;
    String name;
    String serial;
    String tipo_insumo;
    String unidada_medida;
    String cantidad;
    String fecha_compra;
    String costo_compra;
    String proveedor;
    String estado;

    // CREAMOS LAS VARIABLE DE DATOS 
    public insumos(String insumos_id, String name, String serial, String tipo_insumo, String unidada_medida, String cantidad, String fecha_compra, String costo_compra, String proveedor, String estado) {
        this.insumos_id = insumos_id;
        this.name = name;
        this.serial = serial;
        this.tipo_insumo = tipo_insumo;
        this.unidada_medida = unidada_medida;
        this.cantidad = cantidad;
        this.fecha_compra = fecha_compra;
        this.costo_compra = costo_compra;
        this.proveedor = proveedor;
        this.estado = estado;
    }
     public insumos(String insumos_id,String name){
         
     }

    public String getInsumos_id() {
        return insumos_id;
    }

    public String getName() {
        return name;
    }

    public String getSerial() {
        return serial;
    }

    public String getTipo_insumo() {
        return tipo_insumo;
    }

    public String getUnidada_medida() {
        return unidada_medida;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public String getCosto_compra() {
        return costo_compra;
    }

    public String getProveedor() {
        return proveedor;
    }

    public String getEstado() {
        return estado;
    }

}
