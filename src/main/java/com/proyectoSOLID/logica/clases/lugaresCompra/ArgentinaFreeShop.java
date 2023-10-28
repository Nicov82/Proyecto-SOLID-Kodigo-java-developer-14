package com.proyectoSOLID.logica.clases.lugaresCompra;

import com.proyectoSOLID.logica.clases.entidades.Producto;
import com.proyectoSOLID.logica.interfaces.lugaresCompra.CalculoConversionMoneda;

public class ArgentinaFreeShop extends Argentina implements CalculoConversionMoneda {


    public ArgentinaFreeShop() {
        this.nombre = " Free shop Argentina";
        this.signoMonetario = "USD $";
    }



    @Override
    public double calcularCostoProducto(Producto producto) {
        double costoProducto;
        costoProducto = calcularConversionMoneda(producto.getPrecio());
        producto.setPrecioEnPesos(costoProducto);
        return costoProducto;
    }

    @Override
    public double calcularConversionMoneda(double monto) {
        double cotizacionDolarOficial = 365.5; //Se calcula la conversión de dóñar a peso. El índice puede modificarse si cambiara la cotización
        double montoConvertido= monto * cotizacionDolarOficial;
        return montoConvertido;
    }




}
