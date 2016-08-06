/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad;

import java.util.Scanner;

/**
 *
 * @author LDA10
 */
public class producto {

    private String[][] inventario = new String[10][3]; //DataBase
    private String[][] VentaT = new String[10][3];
    ;
    private String nombre;
    private String cantidad;
    private String valor;
    int w, x, y;
    double Ventas;

    public void AgregarProducto() {

        Scanner lector;
        lector = new Scanner(System.in);

        if (inventario[x][0] == null) {

            System.out.println("Producto N-" + (x + 1));
            System.out.print("Ingrese nombre del producto: ");
            nombre = lector.next();
            inventario[x][0] = nombre;
            System.out.print("Ingrese la cantidad: ");
            cantidad = lector.next();
            inventario[x][1] = cantidad;
            System.out.print("Ingrese su precio: ");
            valor = lector.next();
            inventario[x][2] = valor;
        }
        x++;
        if (x == 9 && inventario[x][0] != null) {
            System.out.print("Inventario lleno");
        }
    }

    public void BuscarProducto() {

        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto que desea buscar: ");
        String nom = lector.next();
        int z = 0;
        for (int f = 0; f < x; f++) {

            String inv = inventario[f][0];

            if (inv.equals(nom)) {
                System.out.println("Nombre: " + inventario[f][0] + "  Cantidad: " + inventario[f][1] + "  Valor: " + inventario[f][2]);
                z = 1;
            }
        }
        if (z == 0) {
            System.err.println("El producto " + nom + " no fue encontrado");
        }

    }

    public void EliminarProducto() {

        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto que desea eliminar: ");
        String nom = lector.next();
        int z = 0;
        for (int f = 0; f < x; f++) {
            String inv = inventario[f][0];

            if (inv.equals(nom)) {
                for (int fi = f; fi < x; fi++) {
                    inventario[fi][0] = inventario[fi + 1][0];
                    inventario[fi][1] = inventario[fi + 1][1];
                    inventario[fi][2] = inventario[fi + 1][2];
                }
                x--;
                z = 1;
                System.err.println("El producto fue eliminado");
            }
        }
        if (z == 0) {
            System.err.println("El producto " + nom + " no fue encontrado");
        }

    }

    public void MostrarInventario() {
        for (int f = 0; f < x; f++) {

            System.out.println("Nombre: " + inventario[f][0]);
            System.out.println("Cantidad: " + inventario[f][1]);
            System.out.println("$ " + inventario[f][2]);

            System.out.println();
        }
    }

    public void RealizarVentas() {

        Scanner lector = new Scanner(System.in);
        System.out.print("Ingrese el nombre del producto que se va a vender: ");
        String nom = lector.next();
        int z = 0;
        for (int f = 0; f < x; f++) {

            String inv = inventario[f][0];

            if (inv.equals(nom)) {
                System.out.print("Cuantidad de unidades ha vender: ");
                int cantP = lector.nextInt();
                int cantA = Integer.parseInt(inventario[f][1]);

                if (cantA >= cantP) {
                    inventario[f][1] = Integer.toString((cantA - cantP));
                    double va = Double.parseDouble(inventario[f][2]);
                    System.out.println("Venta Exitosa");
                    Ventas += (cantP * va);
                    double T = cantP * va;
                    String t = String.valueOf(T);
                    VentaT[f][0] = inventario[f][0];
                    VentaT[f][1] = Integer.toString(cantP);
                    VentaT[f][2] = t;
                    y++;

                } else {
                    System.err.println("Solo hay " + cantA + " unidades disponibles");
                }
                z = 1;

            }
        }
        if (z == 0) {
            System.err.println("El producto " + nom + " no fue encontrado");
        }

    }

    public void GananciaTotal() {

        for (int f = 0; f < x; f++) {

            System.out.println("Nombre: " + VentaT[f][0]);
            System.out.println("Cantidad: " + VentaT[f][1]);
            System.out.println("Valor total: " + VentaT[f][2] + "$");

            System.out.println();
        }
        double VentaTotal = Ventas;
        System.out.println("La venta total de la empresa fue por la suma de: " + VentaTotal + " $");

    }

}
