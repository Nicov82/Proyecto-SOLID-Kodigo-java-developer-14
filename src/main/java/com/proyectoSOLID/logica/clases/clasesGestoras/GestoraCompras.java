package com.proyectoSOLID.logica.clases.clasesGestoras;

import com.proyectoSOLID.logica.clases.entidades.Compra;
import com.proyectoSOLID.logica.clases.entidades.Producto;
import com.proyectoSOLID.logica.clases.herramientasParaGestora.Calculadora;
import com.proyectoSOLID.logica.clases.lugaresCompra.LugarCompra;
import com.proyectoSOLID.logica.interfaces.gestion.AltaProducto;
import com.proyectoSOLID.logica.interfaces.gestion.CalculoPrecioTotalCompras;
import com.proyectoSOLID.logica.interfaces.gestion.NuevaCompra;
import com.proyectoSOLID.logica.interfaces.lugaresCompra.CalculoCostoCompra;

import java.util.List;
//Clase que centraliza los métodos de gestión de compras de la aplicación.
public class GestoraCompras implements NuevaCompra, AltaProducto, CalculoCostoCompra, CalculoPrecioTotalCompras {
    private Calculadora calculadora = new Calculadora();

    @Override
    public void iniciarCompra(List listaCompras, LugarCompra lugarCompra) {
        Compra nuevaCompra = new Compra(lugarCompra);
        listaCompras.add(nuevaCompra);
    }
    @Override
    public void agregarProducto(String nombre, double precio, Compra compra) {
        Producto nuevoProducto = new Producto(nombre, precio, compra);
        compra.setPrecioTotal(compra.getPrecioTotal()+nuevoProducto.getPrecio());
        compra.getListaProductos().add(nuevoProducto);
    }
    @Override
    public double calcularCostoCompra(Compra compra) {
        double costoCompra;
       costoCompra = calculadora.calcularCostoCompra(compra);
       return costoCompra;
    }

    @Override
    public void calcularPrecioTotalCompras(List<Compra> listaDeCompras) {
        double precioTotalCompras=0;
        for(Compra compra:listaDeCompras){
            precioTotalCompras = precioTotalCompras + compra.getPrecioTotalEnPesos();
        }
        System.out.println("Precio Total Compras: ARS$"+precioTotalCompras);
    }

}
