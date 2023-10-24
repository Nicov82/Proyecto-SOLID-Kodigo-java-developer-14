package com.proyectoSOLID.logica.clases.main;

import com.proyectoSOLID.logica.clases.lugaresCompra.*;
import com.proyectoSOLID.logica.clases.entidades.*;
import com.proyectoSOLID.logica.clases.herramientasParaGestora.*;
import com.proyectoSOLID.logica.clases.clasesGestoras.*;

import com.proyectoSOLID.menu.MenuPrincipal;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        Gestora gestora = new Gestora();
    MenuPrincipal.mostrarMenuPrincipal(gestora);

    }
}