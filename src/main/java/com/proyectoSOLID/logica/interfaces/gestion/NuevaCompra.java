package com.proyectoSOLID.logica.interfaces.gestion;

import com.proyectoSOLID.logica.clases.lugaresCompra.LugarCompra;

import java.util.List;

public interface NuevaCompra {
    void iniciarCompra(List listaCompras, LugarCompra lugarCompra);
}
