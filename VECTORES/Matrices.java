public class Matrices {
    private int filas;
    private int columnas;
    private int indiceFila;
    private int indiceColumna;
    private persona[][] matrizPersona;

    public Matrices(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.indiceFila = -1;
        this.indiceColumna = -1;
        this.matrizPersona = new persona[filas][columnas];
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getIndiceFila() {
        return indiceFila;
    }

    public void setIndiceFila(int indiceFila) {
        this.indiceFila = indiceFila;
    }

    public int getIndiceColumna() {
        return indiceColumna;
    }

    public void setIndiceColumna(int indiceColumna) {
        this.indiceColumna = indiceColumna;
    }

    public persona[][] getMatrizPersona() {
        return matrizPersona;
    }

    public void setMatrizPersona(persona[][] matrizPersona) {
        this.matrizPersona = matrizPersona;
    }

    public boolean matrizVacia() {
        if (this.indiceFila == -1 && this.indiceColumna == -1)
            return true;
        else
            return false;
    }

    public boolean matrizLlena() {
        if (this.indiceFila == this.filas - 1 && this.indiceColumna == this.columnas - 1)
            return true;
        else
            return false;
    }

    // Elimina la PRIMERA persona encontrada con el nombre dado
    public void eliminarPorNombre(String nombre) {
        if (this.indiceFila == -1) {
            System.out.println("La matriz está vacía.");
            return;
        }

        for (int i = 0; i <= this.indiceFila; i++) {
            int limiteColumna = (i == this.indiceFila) ? this.indiceColumna : this.columnas - 1;
            for (int j = 0; j <= limiteColumna; j++) {
                persona p = this.matrizPersona[i][j];
                if (p != null && p.getNombre().equalsIgnoreCase(nombre)) {
                    // Eliminar la persona
                    this.matrizPersona[i][j] = null;
                    System.out.println("Persona '" + nombre + "' eliminada de la posición [" + i + "][" + j + "].");

                    // Si eliminamos el último elemento insertado, actualizamos los índices
                    if (i == this.indiceFila && j == this.indiceColumna) {
                        if (this.indiceColumna == 0) {
                            if (this.indiceFila > 0) {
                                this.indiceFila--;
                                this.indiceColumna = this.columnas - 1;
                            } else {
                                this.indiceFila = -1;
                                this.indiceColumna = -1;
                            }
                        } else {
                            this.indiceColumna--;
                        }
                    }

                    return; // Sale después de eliminar la primera coincidencia
                }
            }
        }

        System.out.println("No se encontró ninguna persona con el nombre: " + nombre);
    }

    public void agregarPersona(persona p) {
        if (matrizLlena()) {
            System.out.println("Matriz llena, no se puede agregar mas personas");
            return;
        }

        if (indiceFila == -1 && indiceColumna == -1) {
            indiceFila = 0;
            indiceColumna = 0;
        } else {
            if (indiceColumna < columnas - 1) {
                indiceColumna++;
            } else {
                indiceFila++;
                indiceColumna = 0;
            }
        }

        matrizPersona[indiceFila][indiceColumna] = p;
    }

    public boolean eliminarPersona(int fila, int columna) {
        // Validar que la posición esté dentro de los límites de la matriz
        if (fila < 0 || fila >= this.filas || columna < 0 || columna >= this.columnas) {
            System.out.println("Error: Posición fuera de los límites de la matriz.");
            return false;
        }

        // Verificar si hay una persona en esa posición
        if (this.matrizPersona[fila][columna] == null) {
            System.out.println("No hay ninguna persona en la posición [" + fila + "][" + columna + "].");
            return false;
        }

        // Eliminar la persona (poner null)
        this.matrizPersona[fila][columna] = null;
        System.out.println("Persona eliminada de la posición [" + fila + "][" + columna + "].");

        // Opcional: si eliminaste el último elemento insertado, actualizamos los
        // índices
        if (fila == this.indiceFila && columna == this.indiceColumna) {
            // Retroceder al elemento anterior
            if (this.indiceColumna == 0) {
                if (this.indiceFila > 0) {
                    this.indiceFila--;
                    this.indiceColumna = this.columnas - 1;
                } else {
                    // Matriz queda vacía
                    this.indiceFila = -1;
                    this.indiceColumna = -1;
                }
            } else {
                this.indiceColumna--;
            }
        }

        return true;
    }

    // Mostrar solo la diagonal principal
    public void mostrarDiagonalPrincipal(menu menu) {
        if (this.filas != this.columnas) {
            System.out.println("La diagonal principal solo se muestra en matrices cuadradas.");
            return;
        }
        if (this.indiceFila == -1) {
            System.out.println("La matriz está vacía.");
            return;
        }

        System.out.println("\n=== DIAGONAL PRINCIPAL ===");
        for (int i = 0; i < this.filas; i++) {
            persona p = this.matrizPersona[i][i]; // [0][0], [1][1], [2][2], ...
            if (p != null) {
                System.out.print("[" + i + "," + i + "] ");
                menu.mostrarPersona(p);
            } else {
                System.out.println("[" + i + "," + i + "] Vacío");
            }
        }
        System.out.println("=========================\n");
    }

    // Mostrar solo la diagonal secundaria
    public void mostrarDiagonalSecundaria(menu menu) {
        if (this.filas != this.columnas) {
            System.out.println("La diagonal secundaria solo se muestra en matrices cuadradas.");
            return;
        }
        if (this.indiceFila == -1) {
            System.out.println("La matriz está vacía.");
            return;
        }

        System.out.println("\n=== DIAGONAL SECUNDARIA ===");
        for (int i = 0; i < this.filas; i++) {
            int j = this.filas - 1 - i; // [0][n-1], [1][n-2], [2][n-3], ...
            persona p = this.matrizPersona[i][j];
            if (p != null) {
                System.out.print("[" + i + "," + j + "] ");
                menu.mostrarPersona(p);
            } else {
                System.out.println("[" + i + "," + j + "] Vacío");
            }
        }
        System.out.println("===========================\n");
    }

    // Mostrar ambas (la "X")
    public void mostrarEnX(menu menu) {
        if (this.filas != this.columnas) {
            System.out.println("La forma 'X' solo está disponible para matrices cuadradas.");
            return;
        }
        if (this.indiceFila == -1) {
            System.out.println("La matriz está vacía.");
            return;
        }

        System.out.println("\n=== FORMA DE X (AMBAS DIAGONALES) ===");
        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < this.columnas; j++) {
                boolean enPrincipal = (i == j);
                boolean enSecundaria = (i + j == this.filas - 1);

                if (enPrincipal || enSecundaria) {
                    persona p = this.matrizPersona[i][j];
                    if (p != null) {
                        System.out.print("[" + i + "," + j + "] ");
                        menu.mostrarPersona(p);
                    } else {
                        System.out.println("[" + i + "," + j + "] Vacío");
                    }
                }
            }
        }
        System.out.println("====================================\n");
    }

    // 1. Promedio de EDAD de TODAS las personas en la matriz
    public double calcularPromedioEdadTotal() {
        if (this.indiceFila == -1) {
            System.out.println("La matriz está vacía.");
            return 0.0;
        }

        int sumaEdad = 0;
        int contador = 0;

        for (int i = 0; i <= this.indiceFila; i++) {
            int limiteColumna = (i == this.indiceFila) ? this.indiceColumna : this.columnas - 1;
            for (int j = 0; j <= limiteColumna; j++) {
                persona p = this.matrizPersona[i][j];
                if (p != null) {
                    sumaEdad += p.getEdad();
                    contador++;
                }
            }
        }

        return (contador == 0) ? 0.0 : (double) sumaEdad / contador;
    }

    // 2. Promedio de PESO solo en la DIAGONAL PRINCIPAL (solo si es cuadrada)
    public double calcularPromedioPesoDiagonalPrincipal() {
        if (this.filas != this.columnas) {
            System.out.println("La diagonal principal solo existe en matrices cuadradas.");
            return 0.0;
        }
        if (this.indiceFila == -1) {
            System.out.println("La matriz está vacía.");
            return 0.0;
        }

        double sumaPeso = 0.0;
        int contador = 0;

        for (int i = 0; i < this.filas; i++) {
            persona p = this.matrizPersona[i][i];
            if (p != null) {
                sumaPeso += p.getPeso();
                contador++;
            }
        }

        return (contador == 0) ? 0.0 : sumaPeso / contador;
    }

    // 3. Promedio de ALTURA solo en la DIAGONAL SECUNDARIA (solo si es cuadrada)
    public double calcularPromedioAlturaDiagonalSecundaria() {
        if (this.filas != this.columnas) {
            System.out.println("La diagonal secundaria solo existe en matrices cuadradas.");
            return 0.0;
        }
        if (this.indiceFila == -1) {
            System.out.println("La matriz está vacía.");
            return 0.0;
        }

        double sumaAltura = 0.0;
        int contador = 0;

        for (int i = 0; i < this.filas; i++) {
            int j = this.filas - 1 - i;
            persona p = this.matrizPersona[i][j];
            if (p != null) {
                sumaAltura += p.getAltura();
                contador++;
            }
        }

        return (contador == 0) ? 0.0 : sumaAltura / contador;
    }

}
