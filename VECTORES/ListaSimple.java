public class ListaSimple {
    private nodo P,U,Q,T;

    public ListaSimple(){
        this.P = null;
        this.Q = null;
        this.U = null;
        this.T = null;
        
    }
    public ListaSimple (persona persona){
        nodo nuevo = new nodo(persona);
        this.P = nuevo;
        this.U = nuevo;
        this.Q = null;
        this.T = null;
    }   

    public nodo getP() {
        return P;
    }

    public void setP(nodo p) {
        P = p;
    }

    public nodo getU() {
        return U;
    }

    public void setU(nodo u) {
        U = u;
    }

    public nodo getQ() {
        return Q;
    }

    public void setQ(nodo q) {
        Q = q;
    }

    public nodo getT() {
        return T;
    }

    public void setT(nodo t) {
        T = t;
    }

    public boolean ListaVacia(){
        if (this.P == null)
            return true;
        else
            return false;
    } 
    
    public void agregarpersona(persona persona){
        nodo nuevo = new nodo(persona);
        if (ListaVacia()){
            this.P = nuevo;
            this.U = nuevo;
        } else {
            this.U.setSiguiente(nuevo);
            this.U = nuevo;
        }
    }
    public void mostrarlista(){
        if (!ListaVacia()){
            this.Q = this.P;
            while (this.Q != null){
                System.out.println(this.Q.getDato().toString());
                this.Q = this.Q.getSiguiente();
            }
        } else {
            System.out.println("La lista esta vacia");  
        }
    }
    public int contarnodos(){
        int contador = 0;
        if (!ListaVacia()){
            this.Q = this.P;
            while (this.Q != null){
                contador++;
                this.Q = this.Q.getSiguiente();
            }
        } 
        return contador;
    }
// Buscar persona por nombre (devuelve true si la encuentra)
public boolean buscarPersona(String nombre) {
    if (ListaVacia()) {
        return false;
    }
    nodo actual = this.P;
    while (actual != null) {
        if (actual.getDato().getNombre().equalsIgnoreCase(nombre)) {
            return true;
        }
        actual = actual.getSiguiente();
    }
    return false;
}

// Eliminar la PRIMERA persona con ese nombre
public boolean eliminarPersona(String nombre) {
    if (ListaVacia()) {
        return false;
    }

    // Caso 1: La persona a eliminar está en la cabeza (P)
    if (this.P.getDato().getNombre().equalsIgnoreCase(nombre)) {
        this.P = this.P.getSiguiente();
        if (this.P == null) {
            this.U = null; // Lista queda vacía
        }
        return true;
    }

    // Caso 2: Buscar en el resto de la lista
    nodo anterior = this.P;
    nodo actual = this.P.getSiguiente();

    while (actual != null) {
        if (actual.getDato().getNombre().equalsIgnoreCase(nombre)) {
            anterior.setSiguiente(actual.getSiguiente());
            if (actual == this.U) {
                this.U = anterior; // Actualizar último si se elimina el último nodo
            }
            return true;
        }
        anterior = actual;
        actual = actual.getSiguiente();
    }

    return false; // No encontrada
}

   
}

