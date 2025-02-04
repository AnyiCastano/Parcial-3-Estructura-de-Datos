
package parcial.pkg3.estructura.de.datos;

public class Grafo{
    private NodoGrafo primero;
    private NodoGrafo ultimo;

    public Grafo(){
        primero = null;
        ultimo = null;
    }

    public boolean GrafoVacio(){
        return primero == null;
    }

    public boolean existeVertice(Object dato){
        NodoGrafo temporal = primero;
        while (temporal != null){
            if (temporal.dato.toString().equals(dato.toString())){
                return true;
            }
            temporal = temporal.siguiente;
        }
        return false;
    }

    public void NuevaArista(Object origen, Object destino){
        if (existeVertice(origen) && existeVertice(destino)){
            NodoGrafo posicion = primero;
            while (posicion != null && !posicion.dato.equals(origen.toString())){
                posicion = posicion.siguiente;
            }
            if (posicion != null){
                if (posicion.lista == null){
                    posicion.lista = new ListaAdyacencia(); 
                }
                posicion.lista.NuevaAdyacencia(destino);
            }
        }
    }

    public void NuevaArista(Object origen, Object destino, float peso){
        if (existeVertice(origen) && existeVertice(destino)){
            NodoGrafo posicion = primero;
            while (posicion != null && !posicion.dato.equals(origen.toString())){
                posicion = posicion.siguiente;
            }
            if (posicion != null){
                if (posicion.lista == null){
                    posicion.lista = new ListaAdyacencia();
                }
                posicion.lista.NuevaAdyacencia(destino, peso);
            }
        }
    }

    public void NuevoNodo(Object dato){
        if (!existeVertice(dato)){
            NodoGrafo nodo = new NodoGrafo(dato);
            if (GrafoVacio()){
                primero = nodo;
                ultimo = nodo;
            }else{
                if (dato.toString().compareTo(primero.dato.toString()) < 0){
                    nodo.siguiente = primero;
                    primero = nodo;
                }else if (dato.toString().compareTo(ultimo.dato.toString()) > 0){
                    ultimo.siguiente = nodo;
                    ultimo = nodo;
                }else{
                    NodoGrafo temporal = primero;
                    while (temporal.siguiente != null && dato.toString().compareTo(temporal.siguiente.dato.toString()) > 0){
                        temporal = temporal.siguiente;
                    }
                    nodo.siguiente = temporal.siguiente;
                    temporal.siguiente = nodo;
                }
            }
        }
    }

public String toString() {
    String cadena = "";
    NodoGrafo temporal = primero;
    while (temporal != null){
        cadena = cadena + temporal.dato.toString()+" -> "+temporal.lista.toString()+"\n";
        temporal = temporal.siguiente;
        }
    return cadena;
    }
}


