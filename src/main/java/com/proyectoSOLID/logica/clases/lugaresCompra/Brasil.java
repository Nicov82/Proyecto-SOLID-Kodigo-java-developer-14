package com.proyectoSOLID.logica.clases.lugaresCompra;

public class Brasil extends ExteriorComun {
    public Brasil() {
        this.nombre = " Brasil";
        this.signoMonetario = "R$";
    }

    public double calcularConversionMoneda(double monto) {
        double cotizacionRealOficial = 68.99;
        double montoConvertido= monto * cotizacionRealOficial;
        return montoConvertido;
    }
}
