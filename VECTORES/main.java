import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menu menu = new menu();

        // Estructuras independientes por cada opción
        vectores vector = null;
        Matrices matriz = null;
        ListaSimple lista = null;

        boolean salir = false;

        while (!salir) {
            System.out.println("\n" + "=".repeat(40));
            System.out.println("       MENÚ PRINCIPAL");
            System.out.println("=".repeat(40));
            System.out.println("1. Trabajar con Vector");
            System.out.println("2. Trabajar con Matriz");
            System.out.println("3. Trabajar con Lista Simple");
            System.out.println("0. Salir");
            System.out.print("Elija una estructura: ");

            int opcionPrincipal = sc.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    // Submenú: Vector
                    if (vector == null) {
                        System.out.print("Ingrese el tamaño del vector: ");
                        int tamano = sc.nextInt();
                        vector = new vectores(tamano);
                        System.out.println("Vector creado con capacidad de " + tamano + " personas.\n");
                    }
                    submenuVector(vector, menu, sc);
                    break;

                case 2:
                    // Submenú: Matriz
                    if (matriz == null) {
                        System.out.print("Ingrese número de filas: ");
                        int filas = sc.nextInt();
                        System.out.print("Ingrese número de columnas: ");
                        int columnas = sc.nextInt();
                        if (filas > 0 && columnas > 0) {
                            matriz = new Matrices(filas, columnas);
                            System.out.println("Matriz creada: " + filas + "x" + columnas + "\n");
                        } else {
                            System.out.println("Tamaño inválido.\n");
                            break;
                        }
                    }
                    submenuMatriz(matriz, menu, sc);
                    break;

                case 3:
                    // Submenú: Lista Simple
                    if (lista == null) {
                        lista = new ListaSimple();
                        System.out.println("Lista Simple creada.\n");
                    }
                    submenuLista(lista, menu, sc);
                    break;
                case 0:
                    salir = true;
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    
            }
        }

    }

    // ==================== SUBMENÚ VECTOR ====================
    public static void submenuVector(vectores vector, menu menu, Scanner sc) {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- SUBMENÚ: VECTOR ---");
            System.out.println("1. Ingresar persona");
            System.out.println("2. Mostrar personas");
            System.out.println("3. Eliminar persona");
            System.out.println("4. Buscar persona");
            System.out.println("5. Volver al menú principal");
            System.out.print("Elija una opción: ");

            int op = sc.nextInt();

            switch (op) {
                case 1:
                    if (vector.vectorLleno()) {
                        System.out.println("El vector está lleno.");
                    } else {
                        persona p = menu.ingresarPersona();
                        vector.agregarPersona(p);
                        System.out.println("Persona agregada al vector.\n");
                    }
                    break;

                case 2:
                    vector.mostrarVector();
                    break;

                case 3:
                    if (vector.vectorVacio()) {
                        System.out.println("No hay personas para eliminar.");
                    } else {
                        vector.mostrarVector();
                        String nombre = menu.pedirNombre("eliminar");
                        int pos = vector.buscarPersona(nombre);
                        if (pos != -1) {
                            vector.eliminarPersona(pos);
                            System.out.println("Persona eliminada.");
                        } else {
                            System.out.println("Persona no encontrada.");
                        }
                    }
                    break;

                case 4:
                    if (vector.vectorVacio()) {
                        System.out.println("No hay personas para buscar.");
                    } else {
                        String nombre = menu.pedirNombre("buscar");
                        int pos = vector.buscarPersona(nombre);
                        if (pos != -1) {
                            persona p = vector.getVectorPersona()[pos];
                            System.out.println("Encontrado en posición " + pos + ":");
                            menu.mostrarPersona(p);
                        } else {
                            System.out.println("Persona no encontrada.");
                        }
                    }
                    break;

                case 5:
                    volver = true;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    // ==================== SUBMENÚ MATRIZ ====================
    public static void submenuMatriz(Matrices matriz, menu menu, Scanner sc) {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- SUBMENÚ: MATRIZ ---");
            System.out.println("1. Agregar persona");
            System.out.println("2. Mostrar personas");
            System.out.println("3. Eliminar persona");
            System.out.println("4. Buscar persona");
            System.out.println("5. Mostrar diagonal principal");
            System.out.println("6. Mostrar diagonal secundaria");
            System.out.println("7. Mostrar en forma de X");
            System.out.println("8. Calcular promedio de edades (total)");
            System.out.println("9. Promedio de peso (diagonal principal)");
            System.out.println("10. Promedio de altura (diagonal secundaria)");
            System.out.println("11. Volver al menú principal");
            System.out.print("Elija una opción: ");

            int op = sc.nextInt();

            switch (op) {
                case 1:
                    if (matriz.matrizLlena()) {
                        System.out.println("La matriz está llena.");
                    } else {
                        persona p = menu.ingresarPersona();
                        matriz.agregarPersona(p);
                        System.out.println("Persona agregada a la matriz.");
                    }
                    break;

                case 2:
                    mostrarMatriz(matriz, menu);
                    break;

                case 3:
                    if (matriz.matrizVacia()) {
                        System.out.println("La matriz está vacía. No hay personas para eliminar.");
                    } else {
                        String nombre = menu.pedirNombre("eliminar: ");
                        matriz.eliminarPorNombre(nombre);
                    }
                    break;

                case 4:
                    if (matriz.getIndiceFila() == -1) {
                        System.out.println("No hay personas para buscar.");
                    } else {
                        String nombre = menu.pedirNombre("buscar");
                        boolean encontrado = false;
                        for (int i = 0; i <= matriz.getIndiceFila(); i++) {
                            for (int j = 0; j < matriz.getColumnas(); j++) {
                                if (i == matriz.getIndiceFila() && j > matriz.getIndiceColumna())
                                    break;
                                persona p = matriz.getMatrizPersona()[i][j];
                                if (p != null && p.getNombre().equalsIgnoreCase(nombre)) {
                                    System.out.println("Encontrado en [" + i + "][" + j + "]:");
                                    menu.mostrarPersona(p);
                                    encontrado = true;
                                }
                            }
                        }
                        if (!encontrado)
                            System.out.println("Persona no encontrada.");
                    }
                    break;

                case 5:
                    matriz.mostrarDiagonalPrincipal(menu);
                    break;

                case 6:
                    matriz.mostrarDiagonalSecundaria(menu);
                    break;

                case 7:
                    matriz.mostrarEnX(menu);
                    break;

                case 8:
                    double promedioEdadTotal = matriz.calcularPromedioEdadTotal();
                    if (promedioEdadTotal > 0) {
                        System.out.printf("Promedio de edades (total): %.2f años\n", promedioEdadTotal);
                    } else if (matriz.getIndiceFila() != -1) {
                        System.out.println("No hay personas con edad registrada.");
                    }
                    break;

                case 9:
                    double promedioPesoDP = matriz.calcularPromedioPesoDiagonalPrincipal();
                    if (promedioPesoDP > 0) {
                        System.out.printf("Promedio de peso en diagonal principal: %.2f kg\n", promedioPesoDP);
                    } else if (matriz.getFilas() == matriz.getColumnas() && matriz.getIndiceFila() != -1) {
                        System.out.println("No hay personas en la diagonal principal.");
                    }
                    break;

                case 10:
                    double promedioAlturaDS = matriz.calcularPromedioAlturaDiagonalSecundaria();
                    if (promedioAlturaDS > 0) {
                        System.out.printf("Promedio de altura en diagonal secundaria: %.2f m\n", promedioAlturaDS);
                    } else if (matriz.getFilas() == matriz.getColumnas() && matriz.getIndiceFila() != -1) {
                        System.out.println("No hay personas en la diagonal secundaria.");
                    }
                    break;

                case 11:
                    volver = true;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    // ==================== SUBMENÚ LISTA SIMPLE ====================
    public static void submenuLista(ListaSimple lista, menu menu, Scanner sc) {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- SUBMENÚ: LISTA SIMPLE ---");
            System.out.println("1. Agregar persona");
            System.out.println("2. Mostrar personas");
            System.out.println("3. Eliminar persona");
            System.out.println("4. Buscar persona");
            System.out.println("5. Contar personas");
            System.out.println("6. Volver al menú principal");
            System.out.print("Elija una opción: ");

            int op = sc.nextInt();

            switch (op) {
                case 1:
                    persona p = menu.ingresarPersona();
                    lista.agregarpersona(p);
                    System.out.println("Persona agregada a la lista.");
                    break;

                case 2:
                    lista.mostrarlista();
                    break;

                case 3:
                    if (lista.ListaVacia()) {
                        System.out.println("La lista está vacía.");
                    } else {
                        String nombre = menu.pedirNombre("eliminar: ");
                        if (lista.eliminarPersona(nombre)) {
                            System.out.println("Persona '" + nombre + "' eliminada.");
                        } else {
                            System.out.println("No se encontró a la persona '" + nombre + "'.");
                        }
                    }
                    break;

                case 4:
                    if (lista.ListaVacia()) {
                        System.out.println("La lista está vacía.");
                    } else {
                        String nombre = menu.pedirNombre("buscar: ");
                        if (lista.buscarPersona(nombre)) {
                            System.out.println("Persona '" + nombre + "' encontrada en la lista.");
                        } else {
                            System.out.println("Persona '" + nombre + "' no encontrada.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Total de personas en la lista: " + lista.contarnodos());
                    break;

                case 6:
                    volver = true;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    // --- Método auxiliar para mostrar matriz ---
    public static void mostrarMatriz(Matrices matriz, menu menu) {
        persona[][] datos = matriz.getMatrizPersona();
        int ultimaFila = matriz.getIndiceFila();
        int ultimaColumna = matriz.getIndiceColumna();

        System.out.println("\n=== Contenido de la Matriz ===");

        if (ultimaFila == -1 && ultimaColumna == -1) {
            System.out.println("La matriz está vacía.");
        } else {
            for (int i = 0; i <= ultimaFila; i++) {
                for (int j = 0; j < matriz.getColumnas(); j++) {
                    if (i == ultimaFila && j > ultimaColumna)
                        break;
                    if (datos[i][j] != null) {
                        System.out.print("[" + i + "][" + j + "] ");
                        menu.mostrarPersona(datos[i][j]);
                    }
                }
            }
        }
        System.out.println("==============================\n");
    }
}