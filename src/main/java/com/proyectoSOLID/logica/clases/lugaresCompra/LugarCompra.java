package com.proyectoSOLID.logica.clases.lugaresCompra;

import com.proyectoSOLID.logica.clases.entidades.Compra;
import com.proyectoSOLID.logica.clases.entidades.Producto;
import com.proyectoSOLID.logica.interfaces.lugaresCompra.CalculoCostoCompra;
import com.proyectoSOLID.logica.interfaces.lugaresCompra.CalculoCostoProducto;

public abstract class LugarCompra implements CalculoCostoCompra, CalculoCostoProducto {
    protected String nombre;
    protected String signoMonetario;

    public LugarCompra() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSignoMonetario() {
        return signoMonetario;
    }

    public void setSignoMonetario(String signoMonetario) {
        this.signoMonetario = signoMonetario;
    }

    @Override
    public double calcularCostoCompra(Compra compra){
        double costoCompra=0;
        for(Producto producto:compra.getListaProductos()){
            costoCompra= costoCompra + calcularCostoProducto(producto);
        }
        compra.setPrecioTotalEnPesos(costoCompra);
        return costoCompra;
    }

    @Override
    public double calcularCostoProducto(Producto producto){
        double costoProducto = producto.getPrecio();
        producto.setPrecioEnPesos(costoProducto);
        return costoProducto;
    }
}
