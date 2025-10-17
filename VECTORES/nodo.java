public class nodo {
    private persona dato;
    private nodo siguiente;

    public nodo(persona dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public nodo(persona dato, nodo p) {
        this.dato = dato;
        this.siguiente = p;
    }
    

    public persona getDato() {
        return dato;
    }

    public void setDato(persona dato) {
        this.dato = dato;
    }

    public nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodo siguiente) {
        this.siguiente = siguiente;
    }

    
}
