package Institucion;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author ANAHUEL
 */
public class Nodo {

    private MiembroInstitucion Elemento;
    private Nodo siguiente;

    /**
     * Permite crear una instancia del Nodo
     */
    public Nodo() {
        super();
    }

    /**
     * Permite obtener el valor que almacena el Nodo
     *
     * @return
     */
    public Object getElemento() {
        return Elemento;
    }

    /**
     * Permite asignar el valor que almacena el nodo
     *
     * @param elemento
     */
    public void setElemento(MiembroInstitucion elemento) {
        this.Elemento = elemento;
    }

    /**
     * Permite obtener el siguiente nodo
     *
     * @return
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * Permite asignar el siguiente Nodo
     *
     * @param siguiente
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public ArrayList mostrar(ArrayList x) {
        Elemento.Mostrar(x);
        return x;
    }

    public int getCode() {
        return Elemento.getMiCodigo();
    }

    public int getCodeAsig() {
        return Elemento.getCode_asig();
    }

    public File Escribe(File f) {
        Elemento.Escribir(f);
        return f;
    }

    public String getRut() {
        return Elemento.getRut();
    }
}
