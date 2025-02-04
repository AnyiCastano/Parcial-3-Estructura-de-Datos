
package parcial.pkg3.estructura.de.datos;

public class NodoGrafo {
    Object dato;
    ListaAdyacencia lista;
    NodoGrafo siguiente;
    
    public NodoGrafo(Object x){
        dato = x;
        lista = new ListaAdyacencia ();
        siguiente = null;
    }
    
}
