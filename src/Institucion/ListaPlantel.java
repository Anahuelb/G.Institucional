package Institucion;

import java.io.*;
import java.util.ArrayList;

/**
 * @author ANAHUEL
 */
public class ListaPlantel {
    /*
     * Listas
     */

    Lista AD = new Lista();//Administrativos
    Lista AL = new Lista();//Alumnado
    Lista DP = new Lista();//docentes de planta
    Lista DH = new Lista();//docentes a Honorarios

    public void addAdministrativo(String nombre, String rut, int edad, float sueldo) {
        AD.agregarElemento(new Administrativo(nombre, rut, edad, sueldo));
    }

    public void addDocentePlanta(String nombre, String rut, int edad, float sueldo, int code_asig, int code_carrera) {
        DP.agregarElemento(new DocentePlanta(nombre, rut, edad, sueldo, code_asig, code_carrera));
    }

    public void addDocenteHonorarios(String nombre, String rut, int edad, float sueldo, int code_asig) {
        DH.agregarElemento(new DocenteHonorarios(nombre, rut, edad, sueldo, code_asig));
    }

    public void addAlumno(String nombre, String rut, int edad, int CodCarrera) {
        AL.agregarElemento(new Alumno(nombre, rut, edad, CodCarrera));
    }

    public ArrayList MostrarLista(int tipo, ArrayList x) {
        switch (tipo) {
            case 1:
                x.add("Administrativos...");
                x = AD.imprimirElementos(x);
                break;
            case 2:
                x.add("Docentes de Planta...");
                x = DP.imprimirElementos(x);
                break;
            case 3:
                x.add("Docentes a honorarios...");
                x = DH.imprimirElementos(x);
                break;
            case 4:
                x.add("Alumnado......");
                x = AL.imprimirElementos(x);
                break;
            default:
                x.add("Tipo no valido");
        }
        return x;
    }

    public ArrayList Listar(ArrayList x) {
        for (int i = 1; i < 5; i++) {
            MostrarLista(i, x);
        }
        return x;
    }

    public boolean verificaRut(String RUT) {
        boolean control = false;//se piensa que no hay otro rut igual
        if (AD.buscaRut(RUT)) {
            control = true;
        }
        if (DP.buscaRut(RUT)) {
            control = true;
        }
        if (DH.buscaRut(RUT)) {
            control = true;
        }
        if (AL.buscaRut(RUT)) {
            control = true;
        }
        return control;
    }

    public ArrayList BuscaxCodigo(int Code, ArrayList x) {
        x.add(0, "");
        x = AD.buscarXcode(Code, x);
        x = DP.buscarXcode(Code, x);
        x = DH.buscarXcode(Code, x);
        x = AL.buscarXcode(Code, x);
        if (x.get(0).equals("")) {
            x.remove(0);
            x.add("Codigo no valido");
        }
        return x;

    }

    public boolean BorrarXcodigo(int Codigo) {
        int control = 0;
        if (AD.borrarElemento(Codigo)) {
            control = 1;
        } else if (AL.borrarElemento(Codigo)) {
            control = 1;
        } else if (DH.borrarElemento(Codigo)) {
            control = 1;
        } else if (DP.borrarElemento(Codigo)) {
            control = 1;
        }
        if (control == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void GuardarFile() {
        String directorio = System.getProperty("user.dir");
        File f;
        f = new File(directorio + "/" + "LISTA MIEMBROS INSTITUCION by JxSoft.txt");
        try {
            FileWriter w = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            wr.write("*************************");//escribimos en el archivo
            wr.close();
            bw.close();
            if (AD.Vacio() == false) {
                f = AD.Imprimir(f);
            }
            if (DP.Vacio() == false) {
                f = DP.Imprimir(f);
            }
            if (DH.Vacio() == false) {
                f = DH.Imprimir(f);
            }
            if (AL.Vacio() == false) {
                f = AL.Imprimir(f);
            }

            wr.close();
            bw.close();
        } catch (IOException e) {
        }

    }

    public ArrayList BuscarxAsig(int CodigoA, ArrayList x) {
        x.add(0, "");
        x = DP.VerxAsignatura(CodigoA, x);
        x = DH.VerxAsignatura(CodigoA, x);
        if (x.get(0).equals("")) {
            x.add(0, "Lista Docentes Vacia");
        }
        return x;
    }
}
