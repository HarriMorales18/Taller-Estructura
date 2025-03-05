package main;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del vector: ");
        int size = scanner.nextInt();
        VectorOperations vectorOps = new VectorOperations(size);

        int choice;
        do {
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Inserción");
            System.out.println("2. Eliminación");
            System.out.println("3. Búsqueda");
            System.out.println("4. Ordenamiento");
            System.out.println("5. Modificación");
            System.out.println("6. Recorrido");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    menuInsercion(scanner, vectorOps);
                    break;
                case 2:
                    menuEliminacion(scanner, vectorOps);
                    break;
                case 3:
                    menuBusqueda(scanner, vectorOps);
                    break;
                case 4:
                    menuOrdenamiento(scanner, vectorOps);
                    break;
                case 5:
                    menuModificacion(scanner, vectorOps);
                    break;
                case 6:
                    vectorOps.recorrido();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void menuInsercion(Scanner scanner, VectorOperations vectorOps) {
        System.out.println("\nMenú de inserción:");
        System.out.println("1. Insertar al inicio");
        System.out.println("2. Insertar al final");
        System.out.println("3. Insertar en posición");
        System.out.println("4. Insertar antes de posición");
        System.out.println("5. Insertar después de posición");
        System.out.print("Ingrese su opción: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Ingrese el valor a insertar: ");
                int value = scanner.nextInt();
                vectorOps.insertInicio(value);
                break;
            case 2:
                System.out.print("Ingrese el valor a insertar: ");
                value = scanner.nextInt();
                vectorOps.insertFinal(value);
                break;
            case 3:
                System.out.print("Ingrese el valor a insertar: ");
                value = scanner.nextInt();
                System.out.print("Ingrese la posición: ");
                int position = scanner.nextInt();
                vectorOps.insertPosicion(value, position);
                break;
            case 4:
                System.out.print("Ingrese el valor a insertar: ");
                value = scanner.nextInt();
                System.out.print("Ingrese la posición: ");
                position = scanner.nextInt();
                vectorOps.insertAntes(value, position);
                break;
            case 5:
                System.out.print("Ingrese el valor a insertar: ");
                value = scanner.nextInt();
                System.out.print("Ingrese la posición: ");
                position = scanner.nextInt();
                vectorOps.insertDespues(value, position);
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private static void menuEliminacion(Scanner scanner, VectorOperations vectorOps) {
        System.out.println("\nMenú de eliminación:");
        System.out.println("1. Eliminar al inicio");
        System.out.println("2. Eliminar al final");
        System.out.println("3. Eliminar en posición");
        System.out.println("4. Eliminar antes de posición");
        System.out.println("5. Eliminar después de posición");
        System.out.println("6. Eliminar dato");
        System.out.println("7. Eliminar repeticiones de dato");
        System.out.print("Ingrese su opción: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                vectorOps.deleteInicio();
                break;
            case 2:
                vectorOps.deleteFinal();
                break;
            case 3:
                System.out.print("Ingrese la posición: ");
                int position = scanner.nextInt();
                vectorOps.deletePosicion(position);
                break;
            case 4:
                System.out.print("Ingrese la posición: ");
                position = scanner.nextInt();
                vectorOps.deleteAntes(position);
                break;
            case 5:
                System.out.print("Ingrese la posición: ");
                position = scanner.nextInt();
                vectorOps.deleteDespues(position);
                break;
            case 6:
                System.out.print("Ingrese el valor a eliminar: ");
                int value = scanner.nextInt();
                vectorOps.deleteDato(value);
                break;
            case 7:
                System.out.print("Ingrese el valor a eliminar: ");
                value = scanner.nextInt();
                vectorOps.deleteRepeticiones(value);
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private static void menuBusqueda(Scanner scanner, VectorOperations vectorOps) {
        System.out.println("\nMenú de búsqueda:");
        System.out.println("1. Verificar existencia de dato");
        System.out.println("2. Contar repeticiones de dato");
        System.out.println("3. Buscar dato en vector ordenado (búsqueda binaria)");
        System.out.print("Ingrese su opción: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Ingrese el valor a buscar: ");
                int value = scanner.nextInt();
                System.out.println("El dato existe: " + vectorOps.existeDato(value));
                break;
            case 2:
                System.out.print("Ingrese el valor a buscar: ");
                value = scanner.nextInt();
                System.out.println("Repeticiones del dato: " + vectorOps.contarRepeticiones(value));
                break;
            case 3:
                System.out.print("Ingrese el valor a buscar: ");
                value = scanner.nextInt();
                System.out.println("Posición del dato (búsqueda binaria): " + vectorOps.buscarBinario(value));
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private static void menuOrdenamiento(Scanner scanner, VectorOperations vectorOps) {
        System.out.println("\nMenú de ordenamiento:");
        System.out.println("1. Intercambio directo (Bubble Sort)");
        System.out.println("2. Selección");
        System.out.println("3. Inserción");
        System.out.println("4. Quicksort");
        System.out.print("Ingrese su opción: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                vectorOps.intercambioDirecto();
                break;
            case 2:
                vectorOps.seleccion();
                break;
            case 3:
                vectorOps.insercion();
                break;
            case 4:
                vectorOps.quicksort();
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private static void menuModificacion(Scanner scanner, VectorOperations vectorOps) {
        System.out.println("\nMenú de modificación:");
        System.out.println("1. Modificar por valor");
        System.out.println("2. Modificar por posición");
        System.out.print("Ingrese su opción: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Ingrese el valor a modificar: ");
                int oldValue = scanner.nextInt();
                System.out.print("Ingrese el nuevo valor: ");
                int newValue = scanner.nextInt();
                vectorOps.modificarValor(oldValue, newValue);
                break;
            case 2:
                System.out.println("Ingrese la posicion a modificar");
                int posicion = scanner.nextInt();
                System.out.println("Ingrese el nuevo valor");
                newValue = scanner.nextInt();
                vectorOps.modificarPosicion(posicion, newValue);
            }
        }
    }