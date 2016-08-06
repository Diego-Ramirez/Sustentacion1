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
public class Principal {

    public static void main(String[] args) {

        int n;
        producto p = new producto();
        do {
            Scanner lector = new Scanner(System.in);
            System.out.println("-----------------------------------------     MENU     -------------------------------------------");
            System.out.println("|1.Agregar 2.Buscar 3.Eliminar 4.Mostrar Inventario 5.Realizar Ventas 6.Mostrar Ganancias 7.Salir|");
            System.out.println("--------------------------------------------------------------------------------------------------");
            n = lector.nextInt();
            switch (n) {
                case 1:
                    p.AgregarProducto();

                    break;
                case 2:
                    p.BuscarProducto();
                    break;
                case 3:
                    p.EliminarProducto();
                    break;
                case 4:
                    p.MostrarInventario();
                    break;
                case 5:
                    p.RealizarVentas();
                    break;
                case 6:
                    p.GananciaTotal();
                    break;
                case 7:
                    System.err.println("Se ha salido del Programa");
                    break;
                default:
                    System.err.println("Ingrese una opcion valida");
            }

        } while (n != 7);
    }

}
