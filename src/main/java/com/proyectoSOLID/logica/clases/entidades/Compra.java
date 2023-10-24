package com.proyectoSOLID.logica.clases.entidades;

import com.proyectoSOLID.logica.clases.lugaresCompra.LugarCompra;

import java.util.ArrayList;
import java.util.List;

//Clase que almacena datos de las compras.
    public class Compra { //La responsabilidad de este clase es dar los atributos y constructor para las compras.
        private static int contadorCompras = 0;
        private List<Producto> listaProductos;
        private String nombre;

        private double precioTotal;

        private double PrecioTotalEnPesos;
        public LugarCompra getLugarCompra() {
            return lugarCompra;
        }

        public void setLugarCompra(LugarCompra lugarCompra) {
            this.lugarCompra = lugarCompra;
        }

        private LugarCompra lugarCompra;

        public double getPrecioTotal() {
            return precioTotal;
        }

        public void setPrecioTotal(double precioTotal) {
            this.precioTotal = precioTotal;
        }

        public double getPrecioTotalEnPesos() {
            return PrecioTotalEnPesos;
        }

        public void setPrecioTotalEnPesos(double precioTotalEnPesos) {
            this.PrecioTotalEnPesos = precioTotalEnPesos;
        }

        public Compra(LugarCompra lugarCompra) {
            contadorCompras++;
            this.nombre = "Compra " + contadorCompras;
            listaProductos = new ArrayList<Producto>();
            this.lugarCompra = lugarCompra;
        }

        public List<Producto> getListaProductos() {
            return listaProductos;
        }

        public void setListaProductos(List<Producto> listaProductos) {
            this.listaProductos = listaProductos;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        @Override
        public String toString() {
            return nombre +
                    " - Lugar: "+lugarCompra.getNombre() +
                    " - Precio: "+ lugarCompra.getSignoMonetario()+precioTotal+
                    " - Precio convertido: ARS$"+ PrecioTotalEnPesos;
        }
    }
