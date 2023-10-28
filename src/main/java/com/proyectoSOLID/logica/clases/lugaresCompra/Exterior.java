package com.proyectoSOLID.logica.clases.lugaresCompra;

import com.proyectoSOLID.logica.interfaces.lugaresCompra.CalculoConversionMoneda;
import com.proyectoSOLID.logica.interfaces.lugaresCompra.CalculoImpuestoPais;

public abstract class Exterior extends LugarCompra implements CalculoConversionMoneda, CalculoImpuestoPais { //Esta clase abstracta es clave para en un futuro agregarle países a la calculadora
}
