package ProyectoFinal;

import java.util.Scanner;

public class ProyectoFinal {

    // Arreglos para almacenar productos
    static String[] ids = new String[100];
    static String[] nombres = new String[100];
    static String[] categorias = new String[100];
    static double[] precios = new double[100];
    static int[] stocks = new int[100];
    static int productosCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\nSISTEMA DE GESTIÓN DE INVENTARIO: ");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Ver Producto");
            System.out.println("3. Actualizar Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarProducto(scanner);
                    break;
                case 2:
                    verProducto(scanner);
                    break;
                case 3:
                    actualizarProducto(scanner);
                    break;
                case 4:
                    eliminarProducto(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione una opción válida.");
                    break;
            }
        } while (opcion != 5);
        scanner.close();
    }

    public static void agregarProducto(Scanner scanner) {
        System.out.println("\n**** AGREGANDO PRODUCTO ****");
        System.out.print("Ingrese el ID del producto: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la categoria del producto: ");
        String categoria = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese el stock del producto: ");
        int stock = scanner.nextInt();


        ids[productosCount] = id;
        nombres[productosCount] = nombre;
        categorias[productosCount] = categoria;
        precios[productosCount] = precio;
        stocks[productosCount] = stock;
        productosCount++;

        System.out.println("Producto agregado exitosamente.");
        System.out.println("*************************************");
    }

    public static void verProducto(Scanner scanner) {
        if (productosCount == 0) {
            System.out.println("No hay productos en el sistema.");
            System.out.println("*************************************");
        } else {
            System.out.println("\nLista de productos:");
            System.out.println("*************************************");
            for (int i = 0; i < productosCount; i++) {
                System.out.println("ID: " + ids[i]);
                System.out.println("Nombre de Producto: " + nombres[i]);
                System.out.println("Categoría de Producto: " + categorias[i]);
                System.out.println("Precio de Producto: " + precios[i]);
                System.out.println("Stock de Producto: " + stocks[i]);
                System.out.println("*************************************");
            }
        }
    }

    public static void actualizarProducto(Scanner scanner) {
        if (productosCount>=1) {
            verProducto(scanner);
            System.out.print("Ingrese el ID del producto a actualizar: ");
            String id = scanner.nextLine();
            for (int i = 0; i < productosCount; i++) {
                if (ids[i].equals(id)) {
                    System.out.println("Ingrese el nuevo nombre del producto: ");
                    nombres[i] = scanner.nextLine();
                    System.out.println("Ingrese la nueva categoria del producto: ");
                    categorias[i] = scanner.nextLine();
                    System.out.println("Ingrese el nuevo precio del producto: ");
                    precios[i] = scanner.nextDouble();
                    System.out.println("Ingrese el nuevo stock del producto: ");
                    stocks[i] = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("El producto con el ID: " + ids[i] + " fue actualizado exitosamente.");
                    System.out.println("*************************************");
                    return;
                }
            }
            System.out.println("El producto no fue encontrado.");
        } else {
            System.out.println("No hay productos en el sistema.");
        }
    }

    public static void eliminarProducto(Scanner scanner){
        if (productosCount>=1) {
            verProducto(scanner);
            System.out.println("Ingrese el ID del producto a eliminar: ");
            String id = scanner.nextLine();

            for (int i = 0; i < productosCount; i++) {
                if (ids[i].equals(id)) {
                    for (int j = i; j < productosCount - 1; j++) {
                        ids[j] = ids[j + 1];
                        nombres[j] = nombres[j + 1];
                        categorias[j] = categorias[j + 1];
                        precios[j] = precios[j + 1];
                        stocks[j] = stocks[j + 1];
                    }
                    productosCount--;
                    System.out.println("Producto eliminado exitosamente.");
                    return;
                }
            }
            System.out.println("Producto no encontrado");
        } else {
            System.out.println("No hay productos en el sistema.");
        }
    }

}
