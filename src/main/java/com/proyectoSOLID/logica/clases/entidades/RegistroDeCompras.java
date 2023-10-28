package com.proyectoSOLID.logica.clases.entidades;

import com.proyectoSOLID.logica.interfaces.gestion.CalculoPrecioTotalCompras;

import java.util.ArrayList;
import java.util.List;

//Clase para llevar registro de compras en una entidad aparte.
public class RegistroDeCompras {
    private List<Compra> listaCompras;

    public RegistroDeCompras() {
        this.listaCompras = new ArrayList<>();
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }


}
