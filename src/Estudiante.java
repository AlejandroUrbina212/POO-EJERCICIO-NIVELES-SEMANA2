
public class Estudiante {
    private String Name_Estudiante = "";
    private Integer Codigo_Estudiante = 0;

    //GETTERS AND SETTERS


    public String getName_Estudiante() {
        return Name_Estudiante;
    }

    public void setName_Estudiante(String name_Estudiante) {
        Name_Estudiante = name_Estudiante;
    }

    public Integer getCodigo_Estudiante() {
        return Codigo_Estudiante;
    }

    public void setCodigo_Estudiante(Integer codigo_Estudiante) {
        Codigo_Estudiante = codigo_Estudiante;
    }

    //CONSTRUCTOR
    public Estudiante(String name_Estudiante, Integer codigo_Estudiante ){
        this.Name_Estudiante = name_Estudiante;
        this.Codigo_Estudiante = codigo_Estudiante;
    }
    // Imprimir
    @Override
    public String toString() {

        return "" +
                "\n"+
                " Nombre del Estudiante= " + Name_Estudiante + "," +
                " Código = " + Codigo_Estudiante + ","+
                "\n"+
                "";


    }


}
