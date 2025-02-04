
package parcial.pkg3.estructura.de.datos;

public class Arco {
    Object destino;
    float peso;
    Arco siguiente;
    
    public Arco (Object d){
    destino = d;
    siguiente = null;   
    }

    public Arco (Object d, float p){
    destino = d;
    peso = p;
    siguiente = null;
    }    
}
