
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

public class Nivel {
    private String Name;
    private CopyOnWriteArrayList<Grado> Grados = new CopyOnWriteArrayList<Grado>();
    // SETTERS AND GETTERS


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public CopyOnWriteArrayList<Grado> getGrados() {
        return Grados;
    }

    public void setGrados(CopyOnWriteArrayList<Grado> grados) {
        Grados = grados;
    }

    public void addGrado(Grado grado){
        this.Grados.add(grado);
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

