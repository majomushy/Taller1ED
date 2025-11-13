public class ListaDoble {
    private nodoDoble primero;
    private nodoDoble ultimo;

    public ListaDoble() {
        this.primero = null;
        this.ultimo = null;
    }

    public boolean listaVacia() {
        return this.primero == null;
    }

    // Agregar al FINAL (como en tu lista simple)
    public void agregarPersona(persona p) {
        nodoDoble nuevo = new nodoDoble(p);
        if (listaVacia()) {
            this.primero = nuevo;
            this.ultimo = nuevo;
        } else {
            nuevo.setAnterior(this.ultimo);
            this.ultimo.setSiguiente(nuevo);
            this.ultimo = nuevo;
        }
    }

    // Mostrar de inicio a fin
    public void mostrarLista() {
        if (listaVacia()) {
            System.out.println("La lista doble está vacía.");
            return;
        }
        nodoDoble actual = this.primero;
        int indice = 0;
        while (actual != null) {
            System.out.println("[" + indice + "] " + actual.getDato().toString());
            actual = actual.getSiguiente();
            indice++;
        }
    }

    // Mostrar de fin a inicio (extra: aprovecha el doble enlace)
    public void mostrarInverso() {
        if (listaVacia()) {
            System.out.println("La lista doble está vacía.");
            return;
        }
        nodoDoble actual = this.ultimo;
        int indice = contarNodos() - 1;
        while (actual != null) {
            System.out.println("[" + indice + "] " + actual.getDato().toString());
            actual = actual.getAnterior();
            indice--;
        }
    }

    public int contarNodos() {
        int contador = 0;
        nodoDoble actual = this.primero;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    // Buscar por nombre (devuelve true si existe)
    public boolean buscarPersona(String nombre) {
        nodoDoble actual = this.primero;
        while (actual != null) {
            if (actual.getDato().getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    // Eliminar la PRIMERA ocurrencia por nombre
    public boolean eliminarPersona(String nombre) {
        if (listaVacia()) return false;

        nodoDoble actual = this.primero;

        // Caso 1: eliminar el primer nodo
        if (actual.getDato().getNombre().equalsIgnoreCase(nombre)) {
            if (this.primero == this.ultimo) {
                this.primero = null;
                this.ultimo = null;
            } else {
                this.primero = this.primero.getSiguiente();
                this.primero.setAnterior(null);
            }
            return true;
        }

        // Caso 2: buscar en el resto
        while (actual != null && !actual.getDato().getNombre().equalsIgnoreCase(nombre)) {
            actual = actual.getSiguiente();
        }

        if (actual == null) return false; // No encontrada

        // Caso 3: eliminar nodo intermedio o último
        if (actual == this.ultimo) {
            this.ultimo = actual.getAnterior();
            this.ultimo.setSiguiente(null);
        } else {
            // Nodo intermedio
            actual.getAnterior().setSiguiente(actual.getSiguiente());
            actual.getSiguiente().setAnterior(actual.getAnterior());
        }

        return true;
    }
}