package com.proyectoSOLID.menu;
import com.proyectoSOLID.logica.clases.clasesGestoras.Gestora;

import java.util.Scanner;
//Menú de la aplicación (En un futuro quizás tenga un lindo Front End)
public class MenuPrincipal {
    private static Scanner leer = new Scanner(System.in);

    public static void SaludoBienvenida() {
        System.out.println("Bienvenido a la Calculadora viajera Argentina!");
        System.out.println(" ");
    }

    public static void mostrarMenuPrincipal(Gestora gestora) {
        int opcion=0;
        do {
            if(opcion!=3){
                System.out.println("Por favor, elija una opción: ");
            System.out.println("1) Cargar nueva Compra");
            System.out.println("2) Ver compras anteriores");
            System.out.println("3) Salir");
            System.out.println(" ");
            }

            if (leer.hasNextInt()) {
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                       mostrarMenuComprarArgExterior(gestora);
                        break;
                    case 2:
                        if (gestora.getRegistroDeCompras().getListaCompras().isEmpty()){
                        System.out.println("No hay compras realizadas!");
                        System.out.println(" ");
                        break;
                    }else{
                        gestora.verInfoListaCompras();
                        gestora.calcularPrecioTotalCompras();
                        System.out.println(" ");
                        break;
                        }
                    case 3:
                        System.out.println("¡Hasta luego!");
                        System.out.println(" ");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, elija nuevamente.");
                        System.out.println(" ");
                        break;
                }
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                System.out.println(" ");
                leer.next();
            }
        } while (opcion != 3);
    }

    public static void mostrarMenuComprarArgExterior(Gestora gestora) {
        int opcion=0;

        do {
            System.out.println("Elija según donde haya realizado su compra:");
            System.out.println("1- Argentina");
            System.out.println("2- Brasil");
            System.out.println(" ");

            if (leer.hasNextInt()) {
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        mostrarMenuCompraFreeShopArg(gestora);
                        break;
                    case 2:
                        mostrarMenuCompraFreeShopExterior(gestora);
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, elija nuevamente.");
                        System.out.println(" ");

                        break;
                }
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                leer.next(); // Limpia el buffer del scanner
                System.out.println(" ");
            }
        } while (opcion != 1 && opcion != 2);
    }

    public static void mostrarMenuCompraFreeShopArg(Gestora gestora) {
        int opcion=0;

        do {
            System.out.println("Elija según su compra haya sido realizada o no en un Free shop:");
            System.out.println("1- Sí");
            System.out.println("2- No");
            System.out.println(" ");

            if (leer.hasNextInt()) {
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        gestora.iniciarCompra(gestora.getRegistroLugaresCompra().getListaLugaresCompra().get(1));
                        menuAgregarProducto(gestora);
                        System.out.println(" ");
                        break;
                    case 2:
                        gestora.iniciarCompra(gestora.getRegistroLugaresCompra().getListaLugaresCompra().get(0));
                        menuAgregarProducto(gestora);
                        System.out.println(" ");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, elija nuevamente.");
                        System.out.println(" ");
                        break;
                }
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                System.out.println(" ");
                leer.next(); // Limpia el buffer del scanner
            }
        } while (opcion != 1 && opcion != 2);
    }

    public static void mostrarMenuCompraFreeShopExterior(Gestora gestora) {
        int opcion=0;

        do {
            System.out.println("Elija según su compra haya sido realizada o no en un Free shop:");
            System.out.println("1- Sí");
            System.out.println("2- No");
            System.out.println(" ");

            if (leer.hasNextInt()) {
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        gestora.iniciarCompra(gestora.getRegistroLugaresCompra().getListaLugaresCompra().get(3));
                        menuAgregarProducto(gestora);
                        System.out.println(" ");
                        break;
                    case 2:
                        gestora.iniciarCompra(gestora.getRegistroLugaresCompra().getListaLugaresCompra().get(2));
                        menuAgregarProducto(gestora);
                        System.out.println(" ");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, elija nuevamente.");
                        System.out.println(" ");
                        break;
                }
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                System.out.println(" ");
                leer.next(); // Limpia el buffer del scanner
            }
        } while (opcion != 1 && opcion != 2);
    }

    public static void menuAgregarProducto(Gestora gestora) {
        String nombre;
        double precio;

        do {
            System.out.println("Ingrese el nombre del Producto comprado:");
            if (leer.hasNext()) {
                nombre = leer.next();
                System.out.println(" ");
                break;
            } else {
                System.out.println("Nombre inválido. Por favor, ingrese un texto.");
                System.out.println(" ");
                leer.next(); // Limpia el buffer del scanner
            }
        } while (true);

        do {
            System.out.println("Ingrese el precio del Producto comprado -en la moneda correspondiente al país de la compra -dólar si fue comprado en Free shop!.:");
            System.out.println(" ");

            if (leer.hasNextDouble()) {
                precio = leer.nextDouble();
                break;
            } else {
                System.out.println("Precio inválido. Por favor, ingrese un número.");
                System.out.println(" ");
                leer.next();
            }
        } while (true);

        gestora.agregarProducto(nombre, precio, gestora.getRegistroDeCompras().getListaCompras().get(gestora.getNumeroDeCompra()));
        String respuesta;

        do{
            System.out.println("¿Desea añadir otro producto? (S/N");
            System.out.println(" ");
            respuesta = leer.next();

            switch (respuesta){
                case ("S"):
                    menuAgregarProducto(gestora);
                case("s"):
                    menuAgregarProducto(gestora);
                case "N":
                    gestora.calcularCostoCompra(gestora.getRegistroDeCompras().getListaCompras().get(gestora.getNumeroDeCompra()));
                    gestora.verInfoCompra(gestora.getRegistroDeCompras().getListaCompras().get((gestora.getNumeroDeCompra())));
                    System.out.println(" ");
                    mostrarMenuPrincipal(gestora);
                    break;
                case "n":
                    gestora.calcularCostoCompra(gestora.getRegistroDeCompras().getListaCompras().get(gestora.getNumeroDeCompra()));
                    gestora.verInfoCompra(gestora.getRegistroDeCompras().getListaCompras().get((gestora.getNumeroDeCompra())));
                    System.out.println(" ");
                    mostrarMenuPrincipal(gestora);
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente");
            }
        }while(!respuesta.equalsIgnoreCase("s")&& !respuesta.equalsIgnoreCase("n"));

    }

}

