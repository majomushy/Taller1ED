public class main {
    public static void main(String[] args) {
        menu menu = new menu();
        vectores vector = null;  // No creado hasta que el usuario lo elija
        boolean salir = false;

        while (!salir) {
            int opcion = menu.mostrarMenu();

            switch (opcion) {
                case 1: // Crear vector
                    int tamano = menu.pedirTamano();
                    vector = new vectores(tamano);
                    System.out.println("Vector creado con capacidad de " + tamano + " personas.");
                    break;

                case 2: // Ingresar persona
                    if (vector == null) {
                        System.out.println("Primero debe crear el vector.");
                    } else if (vector.vectorLleno()) {
                        System.out.println("El vector está lleno. No se pueden agregar más personas.");
                    } else {
                        persona p = menu.ingresarPersona();
                        vector.agregarPersona(p);
                        System.out.println("Persona agregada con éxito.");
                    }
                    break;

                case 3: // Mostrar personas
                    if (vector == null) {
                        System.out.println("Primero debe crear el vector.");
                    } else {
                        vector.mostrarVector();
                    }
                    break;

                case 4: // Eliminar persona
                    if (vector == null || vector.vectorVacio()) {
                        System.out.println("No hay personas para eliminar.");
                    } else {
                        vector.mostrarVector();
                        int pos = menu.pedirPosicion();
                        vector.eliminarPersona(pos);
                        System.out.println("Persona eliminada (si la posición era válida).");
                    }
                    break;

                case 5: // Buscar persona
                    if (vector == null || vector.vectorVacio()) {
                        System.out.println("No hay personas para buscar.");
                    } else {
                        String nombre = menu.pedirNombre();
                        int pos = vector.buscarPersona(nombre);
                        if (pos != -1) {
                            persona encontrada = vector.getVectorPersona()[pos];
                            System.out.println("Persona encontrada en posición " + pos + ":");
                            System.out.println("Nombre: " + encontrada.getNombre() +
                                               ", Apellido: " + encontrada.getApellido() +
                                               ", Peso: " + encontrada.getPeso() +
                                               ", Altura: " + encontrada.getAltura());
                        } else {
                            System.out.println("Persona no encontrada.");
                        }
                    }
                    break;

                case 0: // Salir
                    salir = true;
                    System.out.println("¡Programa finalizado!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}