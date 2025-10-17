public class persona{
    
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected float peso;
    protected float altura;
    

    @Override
    public String toString() {
    return "Nombre: " + nombre + 
           ", Apellido: " + apellido + 
           ",edad: " + edad +
           ", Peso: " + peso + " kg" + 
           ", Altura: " + altura + " m";
}
    public persona(String nombre, String apellido,int edad, float peso, float altura) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;

        
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public persona(){

    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        this.altura = altura;
    }
    

}