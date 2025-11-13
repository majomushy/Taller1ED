import java.util.Scanner;

public class MenuPrincipal {
    private Scanner sc = new Scanner(System.in);

    // Estructuras de datos (ahora son atributos de la clase)
    private vectores vector = null;
    private Matrices matriz = null;
    private ListaSimple lista = null;
    private ListaDoble listaDoble = null;

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n" + "=".repeat(40));
            System.out.println("       MENÚ PRINCIPAL");
            System.out.println("=".repeat(40));
            System.out.println("1. Trabajar con Vector");
            System.out.println("2. Trabajar con Matriz");
            System.out.println("3. Trabajar con Lista Simple");
            System.out.println("4. Trabajar con Lista Doblemente Enlazada");
            System.out.println("0. Salir");
            System.out.print("Elija una estructura: ");

            int opcionPrincipal = sc.nextInt();

            switch (opcionPrincipal) {
                case 1:
                    if (vector == null) {
                        System.out.print("Ingrese el tamaño del vector: ");
                        int tamano = sc.nextInt();
                        if (tamano > 0) {
                            vector = new vectores(tamano);
                            System.out.println("Vector creado con capacidad de " + tamano + " personas.\n");
                        } else {
                            System.out.println("Tamaño inválido.\n");
                            break;
                        }
                    }
                    submenuVector();
                    break;

                case 2:
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
                    submenuMatriz();
                    break;

                case 3:
                    if (lista == null) {
                        lista = new ListaSimple();
                        System.out.println("Lista Simple creada.\n");
                    }
                    submenuLista();
                    break;
                case 4:
                    if (listaDoble == null) {
                        listaDoble = new ListaDoble();
                        System.out.println("Lista Doblemente Enlazada creada.\n");
                    }
                    submenuListaDoble();
                    break;

                case 0:
                    salir = true;
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        sc.close(); // Buena práctica
    }

    // ==================== SUBMENÚ VECTOR ====================
    private void submenuVector() {
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
                        persona p = ingresarPersona();
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
                        String nombre = pedirNombre("eliminar");
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
                        String nombre = pedirNombre("buscar");
                        int pos = vector.buscarPersona(nombre);
                        if (pos != -1) {
                            persona p = vector.getVectorPersona()[pos];
                            System.out.println("Encontrado en posición " + pos + ":");
                            mostrarPersona(p);
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
    private void submenuMatriz() {
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
                        persona p = ingresarPersona();
                        matriz.agregarPersona(p);
                        System.out.println("Persona agregada a la matriz.");
                    }
                    break;

                case 2:
                    mostrarMatriz();
                    break;

                case 3:
                    if (matriz.matrizVacia()) {
                        System.out.println("La matriz está vacía. No hay personas para eliminar.");
                    } else {
                        String nombre = pedirNombre("eliminar");
                        matriz.eliminarPorNombre(nombre);
                    }
                    break;

                case 4:
                    if (matriz.getIndiceFila() == -1) {
                        System.out.println("No hay personas para buscar.");
                    } else {
                        String nombre = pedirNombre("buscar");
                        boolean encontrado = false;
                        for (int i = 0; i <= matriz.getIndiceFila(); i++) {
                            for (int j = 0; j < matriz.getColumnas(); j++) {
                                if (i == matriz.getIndiceFila() && j > matriz.getIndiceColumna())
                                    break;
                                persona p = matriz.getMatrizPersona()[i][j];
                                if (p != null && p.getNombre().equalsIgnoreCase(nombre)) {
                                    System.out.println("Encontrado en [" + i + "][" + j + "]:");
                                    mostrarPersona(p);
                                    encontrado = true;
                                }
                            }
                        }
                        if (!encontrado)
                            System.out.println("Persona no encontrada.");
                    }
                    break;

                case 5:
                    matriz.mostrarDiagonalPrincipal(this);
                    break;

                case 6:
                    matriz.mostrarDiagonalSecundaria(this);
                    break;

                case 7:
                    matriz.mostrarEnX(this);
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
    private void submenuLista() {
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
                    persona p = ingresarPersona();
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
                        String nombre = pedirNombre("eliminar");
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
                        String nombre = pedirNombre("buscar");
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
    private void submenuListaDoble() {
    boolean volver = false;
    while (!volver) {
        System.out.println("\n--- SUBMENÚ: LISTA DOBLE ---");
        System.out.println("1. Agregar persona");
        System.out.println("2. Mostrar personas (adelante)");
        System.out.println("3. Mostrar personas (atrás)");
        System.out.println("4. Eliminar persona");
        System.out.println("5. Buscar persona");
        System.out.println("6. Contar personas");
        System.out.println("7. Volver al menú principal");
        System.out.print("Elija una opción: ");

        int op = sc.nextInt();

        switch (op) {
            case 1:
                persona p = ingresarPersona();
                listaDoble.agregarPersona(p);
                System.out.println("Persona agregada a la lista doble.");
                break;

            case 2:
                listaDoble.mostrarLista();
                break;

            case 3:
                listaDoble.mostrarInverso();
                break;

            case 4:
                if (listaDoble.listaVacia()) {
                    System.out.println("La lista está vacía.");
                } else {
                    String nombre = pedirNombre("eliminar");
                    if (listaDoble.eliminarPersona(nombre)) {
                        System.out.println("Persona '" + nombre + "' eliminada.");
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                }
                break;

            case 5:
                if (listaDoble.listaVacia()) {
                    System.out.println("La lista está vacía.");
                } else {
                    String nombre = pedirNombre("buscar");
                    if (listaDoble.buscarPersona(nombre)) {
                        System.out.println("Persona '" + nombre + "' encontrada.");
                    } else {
                        System.out.println("Persona no encontrada.");
                    }
                }
                break;

            case 6:
                System.out.println("Total de personas: " + listaDoble.contarNodos());
                break;

            case 7:
                volver = true;
                break;

            default:
                System.out.println("Opción no válida.");
        }
    }
}

    // --- Métodos auxiliares (antes en la clase menu, ahora aquí) ---

    public persona ingresarPersona() {
        sc.nextLine(); // Limpiar buffer
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Ingrese edad: ");
        int edad = sc.nextInt();
        System.out.print("Ingrese peso (kg): ");
        float peso = sc.nextFloat();
        System.out.print("Ingrese altura (m): ");
        float altura = sc.nextFloat();
        return new persona(nombre, apellido, edad, peso, altura);
    }

    public String pedirNombre(String accion) {
        sc.nextLine(); // Limpiar buffer
        System.out.print("Ingrese el nombre a " + accion + ": ");
        return sc.nextLine();
    }

    public void mostrarPersona(persona p) {
        if (p != null) {
            System.out.println("Nombre: " + p.getNombre() +
                    ", Apellido: " + p.getApellido() +
                    ", Edad: " + p.getEdad() + " años" +
                    ", Peso: " + p.getPeso() + " kg" +
                    ", Altura: " + p.getAltura() + " m");
        } else {
            System.out.println("Persona no asignada.");
        }
    }

    private void mostrarMatriz() {
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
                        mostrarPersona(datos[i][j]);
                    }
                }
            }
        }
        System.out.println("==============================\n");
    }
}