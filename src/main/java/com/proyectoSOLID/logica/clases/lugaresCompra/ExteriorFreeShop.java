package com.proyectoSOLID.logica.clases.lugaresCompra;

import com.proyectoSOLID.logica.clases.entidades.Producto;

public class ExteriorFreeShop extends Exterior{ //La ventaja es que en cualquier FreeShop del exterior el cálculo es el mismo (la jerarquia de clases no es la más intuitiva, pero funciona mejor así)

    public ExteriorFreeShop(String nombre) {
        super();
        this.nombre = " Free Shop" + nombre;
        this.signoMonetario ="USD $";
    }

    public double calcularCostoProducto(Producto producto) {

        double costoProducto;
        costoProducto = calcularConversionMoneda(producto.getPrecio());
        costoProducto = costoProducto + calcularImpuestoPais(costoProducto);
        producto.setPrecioEnPesos(costoProducto);
        return costoProducto;
    }
    public double calcularConversionMoneda(double monto) {
        double cotizacionDolarOficial = 365.5; //Se calcula la conversión de dóñar a peso. El índice puede modificarse si cambiara la cotización
        double montoConvertido= monto * cotizacionDolarOficial;
        return montoConvertido;
    }
    @Override
    public double calcularImpuestoPais(double monto) {
        double tasaImpuestoPais = 0.3; //Se calcula el impuesto país. El índice podría cambiar si cambiara la tasa.
        double  impuestoPais = monto*tasaImpuestoPais;
        return impuestoPais;
    }

}
