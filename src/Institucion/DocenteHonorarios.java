package Institucion;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author ANAHUEL
 */
public class DocenteHonorarios extends Docente {

    public DocenteHonorarios(String nombre, String rut, int edad, float sueldo, int code_asig) {
        super(nombre, rut, edad, sueldo, code_asig);
        // TODO Auto-generated constructor stub
    }

    public DocenteHonorarios(DocenteHonorarios x) {
        super(x.getNombre(), x.getRut(), x.getEdad(), x.getSueldo(), x.getCode_asig());

    }

    @Override
    public ArrayList Mostrar(ArrayList x) {
        x.add("Codigo Miembro Institucional =" + getMiCodigo());
        x.add("Nombre = " + getNombre());
        x.add("R.U.T  = " + getRut());
        x.add("Edad   = " + getEdad());
        x.add("Sueldo por hora = " + getSueldo());
        x.add("Codigo Asignatura = " + getCode_asig());
        x.add("******************************");
        return x;
    }

    @Override
    public File Escribir(File f) {
        try {
            String textoAnterior = obtieneContenidoArchivo(f);
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.print(textoAnterior);
            wr.println("Codigo Miembro Institucional =" + getMiCodigo());
            wr.println("Nombre = " + getNombre());
            wr.println("R.U.T  = " + getRut());
            wr.println("Edad   = " + getEdad());
            wr.println("Sueldo por hora = " + getSueldo());
            wr.println("Codigo Asignatura = " + getCode_asig());
            wr.println("**************************");
            wr.close();
            bw.close();
        } catch (IOException e) {
        };
        return f;
    }
}
