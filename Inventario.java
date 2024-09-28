import java.util.Scanner;

public class Inventario {
    public static void main(String[] args) {
        // Constantes
        final int MAX_PRODUCTOS = 100;

        // Arrays para almacenar datos de productos
        String[] nombres = new String[MAX_PRODUCTOS];
        int[] cantidades = new int[MAX_PRODUCTOS];
        double[] precios = new double[MAX_PRODUCTOS];
        int numProductos = 5; // Comenzamos con 5 productos iniciales

        // Inicializar los 5 productos iniciales
        nombres[0] = "Sansung Galaxy s21"; cantidades[0] = 20; precios[0] = 1000;
        nombres[1] = "Auriculares"; cantidades[1] = 30; precios[1] = 45;
        nombres[2] = "Iphone 15"; cantidades[2] = 15; precios[2] = 1300;
        nombres[3] = "Cargador"; cantidades[3] = 25; precios[3] = 30;
        nombres[4] = "Protector de pantalla"; cantidades[4] = 35; precios[4] = 5;

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar menú
            System.out.println("\n--- Menú de Inventario ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Modificar cantidad");
            System.out.println("3. Generar reporte");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // saltar

            if (opcion == 1) {
                // Agregar producto
                //la cantidad de producto debe ser menor al maximo establecido
                if (numProductos < MAX_PRODUCTOS) {
                    System.out.print("Ingrese el nombre del producto " + (numProductos + 1) + ": ");//suma 1 al numero de productos para indicar cual es la posicion
                    nombres[numProductos] = scanner.nextLine();//ingresa el nombre del nuevo producto y lo almacena en la posicion correspondiente

                    System.out.print("Ingrese la cantidad en inventario: ");
                    cantidades[numProductos] = scanner.nextInt();//ingresa la cantidad del producto en la posicion que corresponde

                    System.out.print("Ingrese el precio por unidad: ");
                    precios[numProductos] = scanner.nextDouble();//le agrega el precio al producto en la posicion que corresponde
                    scanner.nextLine(); 

                    numProductos++;//le suma a la variable numProductos 1 para que siga con la siguiente posicion
                    System.out.println("Producto agregado exitosamente.");
                } else {
                    System.out.println("No se pueden agregar más productos. Límite alcanzado.");//esto en el caso de que llegue al maximo de productos
                }
            } else if (opcion == 2) {
                // Modificar cantidad
                System.out.print("Ingrese el nombre del producto a modificar: ");
                String nombreBuscado = scanner.nextLine();//ingresar el producto a modificar la cantidad
                boolean encontrado = false;//por defecto es falso

                for (int i = 0; i < numProductos; i++) {
                    //compara el nombre de la posicion con el ingresado, hasta encontrar uno similar
                    if (nombres[i].equalsIgnoreCase(nombreBuscado)) {
                        System.out.print("Ingrese la nueva cantidad: ");
                        cantidades[i] = scanner.nextInt();//modifica la cantidad
                        scanner.nextLine(); 
                        System.out.println("Cantidad modificada exitosamente.");
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("Producto no encontrado.");//si no encuentra el Producto encontrado se mantiene falso, e imprime que no se encontro
                }
            } else if (opcion == 3) {
                // Generar reporte
                System.out.println("\nReporte Final:");
                double valorTotalInventario = 0;

                for (int i = 0; i < numProductos; i++) {
                    double valorTotal = cantidades[i] * precios[i];//mulriplica el valor de cada producto por su cantidad, con cada espacio del vector
                    valorTotalInventario += valorTotal;//suma cada resulda de valo*cantidad en una variable, hasta sumar todo

                    System.out.println("Producto: " + nombres[i] + 
                                       " - Cantidad: " + cantidades[i] + 
                                       " - Precio por unidad: " + precios[i] + 
                                       " - Valor total: " + valorTotal);//imprime el la informacion de cada Producto
                }

                System.out.println("Valor total del inventario: " + valorTotalInventario);//indica el total de todos los productos
            } else if (opcion == 4) {
                System.out.println("Saliendo del programa...");//opcion cuatro, salir del programa
            } else {
                System.out.println("Opción no válida. Por favor, intente de nuevo.");//si indica otro numero a 1,2,3 o 4
            }
        } while (opcion != 4);//hasta que sea 4 el programa no termina

        scanner.close();
}
}