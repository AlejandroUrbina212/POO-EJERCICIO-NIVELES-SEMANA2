import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    private static String getMenu() {
        return "Menu:\n" +
                "\t1. Agregar Nivel\n" +
                "\t2. Agregar Grado\n" +
                "\t3. Agregar Estudiante\n" +
                "\t4. Ver Grados en un nivel especificado\n" +
                "\t5. Ver Asignaciones en un grado\n" +
                "\t6. Salir\n";
    }


    public static void main(String[] args) {
        CopyOnWriteArrayList<Nivel> Niveles = new CopyOnWriteArrayList<>();
        boolean wantsToContinue = true;
        do {
            System.out.println(getMenu());
            System.out.print("Ingrese una opcion del menú: ");
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();

            if (option == 1) {
                System.out.print("Ingrese un nombre para el nivel: ");
                Scanner NOMBRE_NIVEL = new Scanner(System.in);
                String NOMBRENIVEL1 = NOMBRE_NIVEL.next();
                if (Niveles.size()>0){
                    for (Nivel s : Niveles) { //itera sobre la lista y verifica si el nombre del nivel a crear existe
                        String nombre_a_verificar = s.getName();
                        if (!nombre_a_verificar.equals(NOMBRENIVEL1)) {
                            Nivel newlevel = new Nivel(NOMBRENIVEL1);
                            Niveles.add(newlevel);
                            System.out.println("Se ha agregado su Nivel");
                            System.out.println("los Niveles registrados son : ");
                            System.out.println(Niveles);
                        } else {
                            System.out.println("El Nombre de Ese nivel ya está registrado");
                        }
                    }
                }else{
                    Nivel newlevel = new Nivel(NOMBRENIVEL1);
                    Niveles.add(newlevel);
                    System.out.println("Se ha agregado su Nivel");
                    System.out.println("los Niveles registrados son : ");
                    System.out.println(Niveles);
                }

            } else if (option == 2) {

                System.out.print("Ingrese un nombre para el nivel: "); //Solicita el nombre del nivel en el que desea agregar el grado
                Scanner NOMBRE_NIVEL_ESPECIFICADO = new Scanner(System.in);
                String NOMBRENIVEL1_ESPECIFICADO = NOMBRE_NIVEL_ESPECIFICADO.next();

                if (Niveles.size()>0){
                    for (Nivel s : Niveles) {
                        String OBTENER_NOMBRE = s.getName();

                        if (OBTENER_NOMBRE.equals(NOMBRENIVEL1_ESPECIFICADO)) {
                            System.out.println("Se encuentra en el nivel: \n" + s);
                            System.out.print("Ingrese un nombre de grado para guardar: ");   //verifica si el nombre del nivel existe, si existe:
                            Scanner NOMBRE_GRADO_A_GUARDAR = new Scanner(System.in); //solicitud del grado que desea guardar
                            String STRING_NOMBRE_GRADO_A_GUARDAR = NOMBRE_GRADO_A_GUARDAR.next();
                            if (s.getGrados().size()>0){
                            for (Grado a : s.getGrados()) { //itera sobre los grados de dicho nivel (s.getGrados) y verifica si ya existe el grado
                                String grado_a_evaluar = a.getName_Grado();

                                if (!grado_a_evaluar.equals(STRING_NOMBRE_GRADO_A_GUARDAR)) {
                                    Grado newgrado = new Grado(STRING_NOMBRE_GRADO_A_GUARDAR); //si el grado no existe, lo guarda en el arraylist
                                    s.addGrado(newgrado);
                                    System.out.println("Se ha agregado el grado, el estado actual del nivel es: ");
                                    System.out.println(s.getGrados());

                                } else {
                                    System.out.println("El grado que ingresó ya está guardado");
                                }
                            }
                            }else{
                                System.out.println("Se ha agregado el grado: " + STRING_NOMBRE_GRADO_A_GUARDAR);
                                Grado newgrado = new Grado(STRING_NOMBRE_GRADO_A_GUARDAR);
                                s.addGrado(newgrado);
                                System.out.println("Se ha agregado el grado, el estado actual del nivel es: ");
                                System.out.println(s.getGrados());

                            }

                        }
                    }
                } else{
                    System.out.println("Actualmente se encuentra vacía la lista de Niveles");
                }
            } else if (option == 3) {

                System.out.print("Ingrese un nivel: ");
                Scanner NOMBRE_NIVEL_ESPECIFICADO_ESTUDIANTE = new Scanner(System.in); //se ingresa el nombre del grado en el que quiere guardar al alumno
                String NOMBRENIVEL1_ESPECIFICADO_ESTUDIANTE = NOMBRE_NIVEL_ESPECIFICADO_ESTUDIANTE.next();
                if (Niveles.size()>0){
                    for (Nivel s : Niveles) { //Itera sobre los niveles para ver si si existe el nivel especificado.
                        String nombre_a_verificar = s.getName();
                        if (nombre_a_verificar.equals(NOMBRENIVEL1_ESPECIFICADO_ESTUDIANTE)) {
                            System.out.println("Se encuentra en el nivel: \n" + s);
                            //
                            System.out.print("Ingrese el grado en el que asignará al alumno: ");
                            Scanner NOMBRE_GRADO_A_ASIGNAR = new Scanner(System.in);
                            String STRING_NOMBRE_GRADO_A_ASIGNAR = NOMBRE_GRADO_A_ASIGNAR.next();  //Solicita el nombre del grado al que se desea asignar el alumno
                            if (s.getGrados().size()>0){
                                for (Grado a : s.getGrados()) { //itera sobre el array de nombres  verifica si ya existe, si existe solicita datos del estudiante
                                    String grado_a_evaluar = a.getName_Grado();
                                    if (grado_a_evaluar.equals(STRING_NOMBRE_GRADO_A_ASIGNAR)) {
                                        //ingreso de datos estudiante
                                        System.out.print("Ingrese el código del alumno: "); //Se solicita el codigo del alumno
                                        Scanner codigo_alumno = new Scanner(System.in);
                                        Integer integer_codigo_alumno = codigo_alumno.nextInt();
                                        if(a.getStudents().size()>0){
                                            for (Estudiante b: a.getStudents()){ //se verifica si el alumno existe con ese código y si no existe, se solicita el nombre
                                                int codigo_a_evaluar= b.getCodigo_Estudiante();
                                                System.out.println(codigo_a_evaluar);
                                                if (codigo_a_evaluar==(integer_codigo_alumno)){
                                                    System.out.println("El alumno ya existe con el código: "+integer_codigo_alumno);


                                                }else{
                                                    System.out.print("Ingrese el nombre del alumno: ");
                                                    Scanner nombre_alumno = new Scanner(System.in);
                                                    String string_nombre_alumno = nombre_alumno.next();
                                                    Estudiante newEstudiante = new Estudiante(string_nombre_alumno, integer_codigo_alumno);
                                                    a.addStudent(newEstudiante);
                                                    System.out.println("Se ha agregado al Alumno: \n" + b);
                                                    System.out.println("El estado actual del nivel es : \n" + s);
                                                }

                                            }
                                        } else {
                                            System.out.print("Ingrese el nombre del alumno: ");
                                            Scanner nombre_alumno = new Scanner(System.in);
                                            String string_nombre_alumno = nombre_alumno.next();
                                            Estudiante newEstudiante = new Estudiante(string_nombre_alumno, integer_codigo_alumno);
                                            a.addStudent(newEstudiante);
                                            System.out.println("Se ha agregado al Alumno: \n" + newEstudiante);
                                            System.out.println("El estado actual del nivel es : \n" + s);
                                        }
                                    }
                                }

                            } else {
                                System.out.println("La Lista de grados está vacía.");
                            }

                        } else {
                            System.out.println("El nivel especificado no existe.");

                        }
                    }
                } else{System.out.println("Actualmente no se encuentran Niveles establecidos");}
            } else if (option==4) {
                System.out.print("Ingrese el nivel que desea visualizar");
                Scanner NOMBRE_NIVEL_VISUALIZAR = new Scanner(System.in);
                String STRING_NOMBRE_NIVEL_VISUALIZAR = NOMBRE_NIVEL_VISUALIZAR.next();
                for (Nivel s : Niveles) { //Se itera sobre el nombre de los niveles hasta que se encuentre el nivel especificado
                    String nombre_a_verificar = s.getName();
                    if (nombre_a_verificar.equals(STRING_NOMBRE_NIVEL_VISUALIZAR)) {
                        System.out.println("Se muestra el sumario de los grados y sus respectivos Estudiantes: ");
                        System.out.println(s); //Se muestra el nivel si se encontró
                    }else{
                        System.out.println("El nivel especificado no existe.");
                    }
                }
            }else if (option==5){
                for (Nivel s : Niveles) { //Iteración sobre los niveles
                    for (Grado a : s.getGrados()) { //Iteración sobre los grados
                        System.out.print("Ingrese El grado del que quiere ver los alumnos: ");
                        Scanner NOMBRE_GRADO_A_BUSCAR = new Scanner(System.in);
                        String STRING_NOMBRE_GRADO_A_BUSCAR = NOMBRE_GRADO_A_BUSCAR.next();
                        String nombre_a_verificar = a.getName_Grado();
                        if (nombre_a_verificar.equals(STRING_NOMBRE_GRADO_A_BUSCAR)){ //verificar si el grado especificado existe
                            System.out.println(a.getStudents()); //Mostrar todos los estudiantes
                        }else{
                            System.out.println("No existe el grado especificado");
                        }
                    }
                }
            }else if (option==6){
                wantsToContinue=false;
            }
        }while (wantsToContinue) ;
    }
}