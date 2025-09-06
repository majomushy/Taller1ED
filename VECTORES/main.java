public class main {
    public static void main(String[] args) {
        menu menu = new menu();
        vectores vector = null;  
        boolean salir = false;

        while (!salir) {
            int opcion = menu.mostrarMenu();

            switch (opcion) {
                case 1: 
                    int tamano = menu.pedirTamano();
                    vector = new vectores(tamano);
                    System.out.println("Vector creado con capacidad de " + tamano + " personas.");
                    break;

                case 2: 
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

                case 3: 
                    if (vector == null) {
                        System.out.println("Primero debe crear el vector.");
                    } else {
                        vector.mostrarVector();
                    }
                    break;

                case 4: 
                    if (vector == null || vector.vectorVacio()) {
                        System.out.println("No hay personas para eliminar.");
                    } else {
                        vector.mostrarVector();
                        String nombre = menu.pedirNombre("eliminar");
                        int pos = vector.buscarPersona(nombre);
                    if (pos != -1) {
                    
                        vector.eliminarPersona(pos);
                        System.out.println("Persona eliminada.");
                     }
                    }
                    break;

                case 5: 
                    if (vector == null || vector.vectorVacio()) {
                        System.out.println("No hay personas para buscar.");
                    } else {
                        String nombre = menu.pedirNombre("buscar");
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

                case 0: 
                    salir = true;
                    System.out.println("¡Programa finalizado!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}