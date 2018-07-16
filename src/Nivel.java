import java.util.ArrayList;
import java.util.Arrays;

public class Nivel {
    private String Name = "Default";
    private ArrayList<Object> Grados = new ArrayList<>();

    // SETTERS AND GETTERS


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public ArrayList<Object> getGrados() {
        return Grados;
    }

    public void setGrados(ArrayList<Object> grados) {
        Grados = grados;
    }

    //CONSTRUCTOR
    public Nivel (String nombre){
        this.Name= nombre;
    }

    @Override
    public String toString() {
        return "" +
                " Nombre del Nivel= " + Name +
                "\n"+
                " Grados= " + Arrays.toString(Grados.toArray()) +
                "\n"+
                "";


    }


}

