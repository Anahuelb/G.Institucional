/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Institucion;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author ANAHUEL
 */
public class DocentePlanta extends Docente {

    public DocentePlanta(String nombre, String rut, int edad, float sueldo, int code_asig, int code_carrera) {
        super(nombre, rut, edad, sueldo, code_asig);
        this.setCode_carrera(code_carrera);
    }

    public int getCode_carrera() {
        return code_carrera;
    }

    public void setCode_carrera(int code_carrera) {
        this.code_carrera = code_carrera;
    }
    private int code_carrera;

    @Override
    public ArrayList Mostrar(ArrayList x) {
        x.add("Codigo Miembro Institucional =" + getMiCodigo());
        x.add("Nombre = " + getNombre());
        x.add("R.U.T  = " + getRut());
        x.add("Edad   = " + getEdad());
        x.add("Sueldo = " + getSueldo());
        x.add("Codigo Asignatura = " + getCode_asig());
        x.add("Codigo Carrera = " + getCode_carrera());
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
            wr.println("Sueldo = " + getSueldo());
            wr.println("Codigo Asignatura = " + getCode_asig());
            wr.println("Codigo Carrera = " + getCode_carrera());
            wr.println("**************************");
            wr.close();
            bw.close();
        } catch (IOException e) {
        };
        return f;
    }
}
