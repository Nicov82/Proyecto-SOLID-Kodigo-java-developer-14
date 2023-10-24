package com.proyectoSOLID.logica.clases.lugaresCompra;
import com.proyectoSOLID.logica.clases.entidades.Producto;
import com.proyectoSOLID.logica.interfaces.lugaresCompra.CalculoRetencion;

public abstract class ExteriorComun extends Exterior implements CalculoRetencion{

    @Override
    public double calcularCostoProducto(Producto producto) {

        double costoProducto;
        costoProducto = calcularConversionMoneda(producto.getPrecio());
        costoProducto = costoProducto + calcularImpuestoPais(costoProducto) + calcularRetencion(costoProducto);
        producto.setPrecioEnPesos(costoProducto);
        return costoProducto;
    }

    @Override
    public double calcularImpuestoPais(double monto) {
        double tasaImpuestoPais = 0.3; //Se calcula el impuesto país. El índice podría cambiar si cambiara la tasa.
        double  impuestoPais = monto*tasaImpuestoPais;
        return impuestoPais;
    }

    @Override
    public double calcularRetencion(double monto) {
        double tasaRetencion = 0.45; //Se calcula el impuesto país. El índice podría cambiar si cambiara la tasa.
        double retencion = monto*tasaRetencion;
        return retencion;
    }

}
