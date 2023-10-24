package com.proyectoSOLID.logica.clases.entidades;

import com.proyectoSOLID.logica.clases.entidades.Compra;

//Clase que almacena datos de los productos

public class Producto {
    private String nombre;
    private double precio;

    private double precioEnPesos;
   private Compra compra; //Esto lo hice para facilitarme poner el signo monetario en el toString ()



    public Producto(String nombre, double precio, Compra compra) {
        this.nombre = nombre;
        this.precio = precio;
        this.compra = compra;
    }

    public double getPrecioEnPesos() {
        return precioEnPesos;
    }

    public void setPrecioEnPesos(double precioEnPesos) {
        this.precioEnPesos = precioEnPesos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    @Override
    public String toString() {
        return "Producto - " +
                nombre +
                ", precio=" + this.compra.getLugarCompra().getSignoMonetario()+ precio +
                ", precio convertido: ARS$"+this.getPrecioEnPesos();
    }


}
