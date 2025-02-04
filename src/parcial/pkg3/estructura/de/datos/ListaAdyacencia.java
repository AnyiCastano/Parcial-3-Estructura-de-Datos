
package parcial.pkg3.estructura.de.datos;

public class ListaAdyacencia {
    private Arco primero;
    private Arco ultimo;

    public ListaAdyacencia (){
        primero = null;
        ultimo = null;
    }
    
    public boolean ListaVacia (){
        return primero == null;
    }
    
    public void NuevaAdyacencia (Object destino){
        if (!adyacente (destino)){
            Arco nodo = new Arco (destino);
            Insertar (nodo,destino);
        }
    }
    
    public void NuevaAdyacencia (Object destino, float peso){
        if (!adyacente (destino)){
            Arco nodo = new Arco (destino,peso);
            Insertar (nodo,destino);
        }
    }
    
    private void Insertar (Arco nodo, Object destino){
        if (ListaVacia()){
           primero = nodo;
           ultimo = nodo;
        }else{
            if(destino.toString().compareTo(primero.destino.toString())<=0){
                nodo.siguiente = primero;
                primero = nodo;
            }else{
                if(destino.toString().compareTo(ultimo.destino.toString())>=0){
                    ultimo.siguiente = nodo;
                    ultimo = nodo;
                }else{
                    Arco posicion = primero;
                    while (destino.toString().compareTo(posicion.destino.toString())>0){
                        posicion = posicion.siguiente;
                    }
                    nodo.siguiente = posicion.siguiente;
                    posicion.siguiente = nodo;
                }
            } 
        }
    }
    
    private Arco EncuentraPosicion (Object dato){
        Arco actual = primero;
        while (actual != null && !dato.toString().equals(actual.destino.toString())){
        actual = actual.siguiente;
        }
        return actual;
    }
    
    private Arco EncuentraPosicionAnteriorDato(Object dato){
        if (ListaVacia() || primero.destino.equals(dato)){
            return null; 
        }
            Arco actual = primero;
            while (actual.siguiente != null && !actual.siguiente.destino.equals(dato)){
                actual = actual.siguiente;
            }
            return actual.siguiente != null ? actual : null; 
    }
    
    private void EliminaPrincipio (){
        if (!ListaVacia()) {
            primero = primero.siguiente;
            if (primero == null) {
                ultimo = null;
            }
        }
    }
    
    private void EliminaFinal(){
        if (!ListaVacia()) {
            if (primero == ultimo){
                primero = null;
                ultimo = null;
            } else{
                Arco actual = primero;
                while (actual.siguiente != ultimo){
                    actual = actual.siguiente;
                }
                actual.siguiente = null;
                ultimo = actual;
            }
        }
    }
    
    private void EliminarEnMedio (Object dato, Arco pActual){
        if (pActual == null || pActual.siguiente == null) return;
        pActual.siguiente = pActual.siguiente.siguiente;
        if (pActual.siguiente == null){
            ultimo = pActual;
        }
    }
    
    public void QuitarAdyacencia (Object dato){
        if (ListaVacia()) return;
        if (primero.destino.equals(dato)){
            EliminaPrincipio();
        }else{
            Arco anterior = EncuentraPosicionAnteriorDato(dato);
            if (anterior != null){
                EliminarEnMedio(dato, anterior);
            }
        }
    }
            
    public boolean adyacente (Object dato){
        Arco actual;
        boolean encontrado;
        encontrado = false;
        actual = primero;
        while(actual != null &&!dato.toString().equals(actual.destino.toString())){
            actual = actual.siguiente;
        }
        if (actual != null){
            encontrado = true;
        }
        return encontrado;
    }
    
    public String toString(){
        String cadena = "";
        Arco temporal = primero;
        while (temporal != null){
            cadena = cadena + temporal.destino.toString()+ ";";
            temporal = temporal.siguiente;
        }
        return cadena;
    }
}
