package Institucion;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author ANAHUEL
 */
public class Lista {

    private Nodo cabeza;
    private Nodo cola;

    /**
     * Permite crear una instancia de la lista enlazada Simple
     */
    public Lista() {
        super();
    }

    public boolean Vacio() {
        if (cabeza == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Permite agregar un elemento poniendolo en el ultimo lugar de la lista
     *
     * @param elemento
     */
    public void agregarElemento(MiembroInstitucion elemento) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setElemento(elemento);

        if (cabeza == null) { // Si la lista esta vacia
            cabeza = nuevoNodo; // La cabeza se convierte en el nuevo nodo
            cola = nuevoNodo; // Y la cola tambien ya que solo hay uno
        } else { // Si la lista no esta vacia
            cola.setSiguiente(nuevoNodo); // El siguiente elemento de la cola sera el nuevo nodo
            cola = nuevoNodo; // Y ahora la cola sera el nuevo nodo
        }
    }

    /**
     * Permite borrar un elemento de la lista
     */
    public boolean borrarElemento(int Micode) {
        Nodo i = cabeza;
        Nodo anterior = null;
        int control = 0;
        while (i != null) { // Recorremos los elementos hasta encontrarlo.
            if (i.getCode() == Micode) {
                control = 1;
                return eliminar(anterior, i);
            } else { //Si no lo encontramos continuamos con el siguiente elemento de la lista
                anterior = i;
                i = i.getSiguiente();
            }
        }
        if (control == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Permite eliminar un nodo dandole el nodo anterior
     *
     * @param anterior
     * @param nodoAEliminar
     * @return
     */
    private boolean eliminar(Nodo anterior, Nodo nodoAEliminar) {
        if (anterior == null) { //Asumimos que esta en la cabeza
            cabeza = cabeza.getSiguiente();
            if (nodoAEliminar.equals(cola)) { //Asumimos que solo hay un elemento en la lista
                cola = null;
            }
            return true;
        } else { // Asumimos que esta en los nodos interiores
            anterior.setSiguiente(nodoAEliminar.getSiguiente());
            return true;
        }
    }

    /**
     * Permite buscar un elemento
     *
     * @param elemento
     * @return
     */
    public ArrayList buscarXcode(int code, ArrayList x) {
        Nodo i = cabeza;
        int control = 0;
        if (cabeza != null) {
            while (i != null) { // Recorremos los elementos hasta encontrarlo.
                if (i.getCode() == code) {
                    control = 1;
                    x = i.mostrar(x);
                    break;
                } else { //Si no lo encontramos continuamos con el siguiente elemento de la lista
                    i = i.getSiguiente();
                }
            }
        }
        if (control == 1) {
            x.remove(0);
            x.add(0, "Encontrado");

        }
        return x;
    }

    public boolean buscaRut(String RUT) {
        Nodo i = cabeza;
        int control = 0;
        if (cabeza != null) {
            while (i != null) { // Recorremos los elementos hasta encontrarlo.
                if (i.getRut().equals(RUT)) {
                    control = 1;
                    break;
                } else { //Si no lo encontramos continuamos con el siguiente elemento de la lista
                    i = i.getSiguiente();
                }
            }
        }
        if (control == 0) {
            return false;
        } else {
            return true;
        }
    }

    public synchronized ArrayList imprimirElementos(ArrayList x) {
        if (cabeza == null) {
            x.add("Lista vacia");
            x.add("*********************");
        }
        for (Nodo i = cabeza; i != null; i = i.getSiguiente()) // Recorremos los elementos
        {
            i.mostrar(x);
        }
        return x;
    }

    // public void mostrarAD(Administrativo x) {
    //    x.Mostrar();
    //}
    public ArrayList VerxAsignatura(int codeAsig, ArrayList x) {
        int control = 0;
        if (cabeza != null) {
            for (Nodo i = cabeza; i != null; i = i.getSiguiente()) // Recorremos los elementos
            {
                if (i.getElemento() instanceof Docente) {
                    if (i.getCodeAsig() == codeAsig) {
                        x.add("***************************************");
                        if (i.getElemento() instanceof DocentePlanta) {
                            x.add("Docente de Planta...........");
                            control = 1;
                        }
                        if (i.getElemento() instanceof DocenteHonorarios) {
                            x.add("Docente a Honorarios");
                            control = 1;
                        }
                        x.add("Tipo Docente...");
                        x = i.mostrar(x);
                    }
                }
            }
            if (control == 0) {
                x.add("Codigo no valido");
            }
        } else {
            // x.add("Listas Docentes vacias");
        }

        return x;

    }

    public File Imprimir(File f) {
        for (Nodo i = cabeza; i != null; i = i.getSiguiente()) // Recorremos los elementos
        {
            f = i.Escribe(f);

        }
        return f;

    }

}
