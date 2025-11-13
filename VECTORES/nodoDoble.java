public class nodoDoble {
    private persona dato;
    private nodoDoble siguiente;
    private nodoDoble anterior;

    public nodoDoble(persona dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    // Getters y setters
    public persona getDato() {
        return dato;
    }

    public void setDato(persona dato) {
        this.dato = dato;
    }

    public nodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public nodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(nodoDoble anterior) {
        this.anterior = anterior;
    }
}