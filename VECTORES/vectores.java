public class vectores{
    private int max;
    private int indice;
    private persona[] vectorPersona;

    public vectores(int max) {
        this.max = max;
        this.indice=-1;
        this.vectorPersona=new persona[max];
    }

    public int getMax() {
        return max;
    }

    public int getIndice() {
        return indice;
    }

    public persona[] getVectorPersona() {
        return vectorPersona;
    }
    public boolean vectorVacio() {
        if (this.indice == -1) 
            return true;
         else 
            return false;
    }
    public boolean vectorLleno() {
        if (this.indice == this.max - 1) 
            return true;
         else 
            return false;
    }

    public void agregarPersona(persona p) {
        if (!vectorLleno()) {
            this.indice++;
            this.vectorPersona[this.indice] = p;
        } else {
            System.out.println("El vector esta lleno");
        }
    }

    public void mostrarVector() {
        if (!vectorVacio()) {
            for (int i = 0; i <= this.indice; i++) {
                System.out.println("Nombre: " + this.vectorPersona[i].getNombre() + 
                                   ", Apellido: " + this.vectorPersona[i].getApellido() + 
                                   ", Peso: " + this.vectorPersona[i].getPeso() + 
                                   ", Altura: " + this.vectorPersona[i].getAltura());
            }
        } else {
            System.out.println("El vector esta vacio");
        }
    }

    public void eliminarPersona(int posicion) {
        if (!vectorVacio() && posicion >= 0 && posicion <= this.indice) {
            for (int i = posicion; i < this.indice; i++) {
                this.vectorPersona[i] = this.vectorPersona[i + 1];
            }
            this.vectorPersona[this.indice] = null;
            this.indice--;
        } else {
            System.out.println("Posicion invalida o vector vacio");
        }
    }
    public int buscarPersona(String nombre) {
        if (!vectorVacio()) {
            int i = 0;
            boolean encontrado = false;
            while ( i <= this.indice && !encontrado) {
                if (this.vectorPersona[i].getNombre().equalsIgnoreCase(nombre)) {
                    encontrado = true;
                    return i;
                } else {
                    i++;
                }
            }

            if (!encontrado) {
                System.out.println("No se encontro a la persona");
            }
        }
        return -1; // No encontrado
    }
    
}