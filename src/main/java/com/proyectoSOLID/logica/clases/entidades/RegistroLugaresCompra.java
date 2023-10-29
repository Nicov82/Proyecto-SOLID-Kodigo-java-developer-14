package com.proyectoSOLID.logica.clases.entidades;

import com.proyectoSOLID.logica.clases.lugaresCompra.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Creamos esta clase para mover acá los Lugares de Compra y quitarle a la Fachada la responsabilidad de crearlos.
//En lugar de eso, la fachada simplemente tendrá como atributo esta clase.
public class RegistroLugaresCompra {

    private static RegistroLugaresCompra instancia;
    private List<LugarCompra> listaLugaresCompra;

    private RegistroLugaresCompra() {
        this.listaLugaresCompra = new ArrayList<>(Arrays.asList(
                new ArgentinaComun(),
                new ArgentinaFreeShop(),
                new Brasil(),
                new ExteriorFreeShop("Brasil")
        ));
    }

    public static RegistroLugaresCompra getInstance(){
        if(instancia==null){
            instancia = new RegistroLugaresCompra();
        }
        return instancia;
    }

    public static RegistroLugaresCompra getInstancia() {
        return instancia;
    }

    public static void setInstancia(RegistroLugaresCompra instancia) {
        RegistroLugaresCompra.instancia = instancia;
    }

    public List<LugarCompra> getListaLugaresCompra() {
        return listaLugaresCompra;
    }

    public void setListaLugaresCompra(List<LugarCompra> listaLugaresCompra) {
        this.listaLugaresCompra = listaLugaresCompra;
    }
}
