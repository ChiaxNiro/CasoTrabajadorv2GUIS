public class Trabajador extends Persona implements  IArchivo{
    private String isapre;
    private String afp;

    public String getIsapre() {
        return isapre;
    }

    public void setIsapre(String isapre) {
        this.isapre = isapre;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

    public Trabajador(String nombre, String apellido, String rut, String isapre, String afp) {
        super(nombre, apellido, rut);
        this.isapre = isapre;
        this.afp = afp;
    }

    @Override
    public void abrirFuenteDatos() {
        System.out.println("Abriendo la fuente de datos...");

    }
    @Override
    public void leerDatos() {
        System.out.println("Leyendo datos del trabajador: "+ super.toString()+" isapre: "+isapre+" afp: "+afp);
    }

    @Override
    public void cerrarFuenteDatos() {
        System.out.println("Cerrando la fuente de datos...");

    }

    @Override
    public String toString() {
        return super.toString() + " isapre: "+isapre+" afp: "+afp;
    }

}
