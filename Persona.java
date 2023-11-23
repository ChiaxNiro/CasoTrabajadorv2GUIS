public class Persona {
    private String nombre;
    private String apellido;
    private String rut;

    public Persona(String nombre, String apellido, String rut) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
    }

    @Override
    public String toString() {
        return "nombre: "+nombre +" "+" apellido: " +apellido +" rut: "+rut;
    }
    public String getRut() {
        return rut;
    }
}
