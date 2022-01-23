/**
 * Representa a una palabra y su frecuencia de aparición
 * en un texto
 *
 */
public class Palabra {
    
    private String palabra;
    private int frecuencia;
    
    /**
     * Constructor de la clase Palabra
     */
    public Palabra(String palabra) {
        this.palabra = palabra.toUpperCase();
        frecuencia = 1;
    }
    
    /**
     * Accesor para la palabra
     */
    public String getPalabra() {
        return palabra;
    }
    
    /**
     * Accesor para la frecuencia
     */
    public int getFrecuencia() {
        return frecuencia;
    }
    
    /**
     * Incrementar la frecuencia
     */
    public void incrementar() {
        frecuencia++;
    }
    
    public void setPalabra(String palabra){
        this.palabra = palabra;
    }
    
    /**
     * Representación textual de la palabra
     */
    
    public String toString() {
        return String.format("%15s", palabra + " (" + frecuencia + ")");
    }
    
    public static void main(String[] args) {
        Palabra palabra = new Palabra("pan");
        System.out.println(palabra.toString());
        palabra.incrementar();
        System.out.println(palabra.toString());
        
    }
}
