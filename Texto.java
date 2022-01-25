import java.util.Arrays;
import java.util.Scanner;

/**
 * Un objeto de esta clase guarda en un array las diferentes
 * palabras que hay en un texto
 *
 * Cada palabra es un objeto Palabra que guarda la palabra (como String)
 * y su frecuencia de aparición en el texto
 *
 * El array guarda como máximo n palabras distintas
 *
 * @author - Iratxe Remón
 */
public class Texto {

    private Palabra[] palabras;
    private int total;

    /**
     * Constructor
     * Crea el array al tamaño n
     * e inicializa adecuadamente el resto de atributos
     */
    public Texto(int n) {
        palabras = new Palabra[n];
        total = 0;
    }

    /**
     * @return true si el texto está completo
     */
    public boolean textoCompleto() {
        return total == palabras.length;
    }

    /**
     * @return el nº de palabras distintas aparecidas en
     * el texto y guardadas en el array
     */
    public int totalPalabras() {
        return total;
    }

    /**
     * Dada una línea de texto conteniendo diferentes palabras
     * el método extrae las palabras y las inserta en el array
     *
     * Las palabras en la línea están separadas por uno o varios espacios
     * seguidos, o por el punto o por la coma
     * Puede haber espacios al comienzo y final de la línea
     *
     * Ej - "   a single      type.  " contiene tres palabras: a single type
     *      "y un mozo de campo y plaza  "  contiene 7 palabras
     *
     * Antes de insertar una palabra habrá que comprobar que no se
     * ha añadido previamente. 
     * Si ya se ha añadido solo hay que incrementar su frecuencia de
     * aparición 
     * Si no está la palabra y hay sitio en el array para una nueva
     * se inserta de forma que quede ordenada (!!no se ordena, se
     * inserta en orden!!)
     *  
     * Hay que usar como métodos de ayuda estaPalabra() e
     * insertarPalabraEnOrden()
     */
    public void addPalabras(String linea) {
        linea = linea.trim();
        String[] cadena = linea.split("[,\\.\\s]+");

        for (int i = 0; i < cadena.length; i++) {

            if (estaPalabra(cadena[i]) == -1) {
                insertarPalabraEnOrden(cadena[i]); 
            }
            else {
                palabras[estaPalabra(cadena[i])].incrementar();
            }
        }
    }

    /**
     *  dada una palabra devuelve la posición en la que se
     *  encuentra en el array o -1 si no está
     *
     *  Indiferente mayúsculas y minúsculas
     */
    public int estaPalabra(String palabra) {
        int pos = -1;
        int i = 0;
        while (pos == -1 && i < total) {
            if (palabras[i].getPalabra().equalsIgnoreCase(palabra)) {
                pos = i;
            }
            i++;
        }
        return pos;
    }

    /**
     *
     * @param palabra inserta la palabra en el lugar adecuado
     *                de forma que el array palabras quede ordenado
     *                alfabéticamente
     *  Solo hay que insertar en este método, se asume que la palabra
     *                no está y que es posible añadirla
     *
     */
    private void insertarPalabraEnOrden(String palabra) {
        if (estaPalabra(palabra) == -1 && !textoCompleto()) {
            int i = total - 1;
            while (i >= 0 && palabras[i].getPalabra().compareToIgnoreCase(palabra) > 0) {
                palabras[i + 1] = palabras[i];
                i--;
            }
            palabras[i + 1] = new Palabra(palabra);
            total++;
        }
    }

    /**
     * Representación textual del array de palabras
     * Cada palabra y su frecuencia de aparición
     * Se muestran en líneas de 5 en 5 palabras
     * (ver enunciado)
     *
     * De forma eficiente ya que habrá muchas concatenaciones
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < total; i++) {
            sb.append(palabras[i].toString());

            if ((i + 1) % 5 == 0) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /**
     *  Devuelve la palabra de la posición p
     *  Si p es incorrecto se devuelve null    
     */
    public Palabra getPalabra(int p) {
        if (p < 0 || p >= total) {
            return null;
        }
        else{
            return palabras[p];
        }    
    }

    /**
     * @return un array de cadenas con las palabras del texto
     * capitalizadas de forma alterna
     */
    public String[] capitalizarAlterna() {
        String[] capitalizadas = new String[total];

        for (int i = 0; i < total; i++) {
            capitalizadas[i] = Utilidades.capitalizarAlterna(palabras[i].getPalabra());
        }

        return capitalizadas;
    }

    /**
     * @return un array de cadenas con las palabras que tienen letras
     * repetidas
     */
    public String[] palabrasConLetrasRepetidas() {
        String[] repetidas = new String[total];
        int j = 0;

        for (int i = 0; i < total; i++) {
            if (Utilidades.tieneLetrasRepetidas(palabras[i].getPalabra())) {
                repetidas[j] = palabras[i].getPalabra();
                j++;
            }
        }

        return Arrays.copyOf(repetidas, j);    
    }

    /**
     * @return un array con la frecuencia de palabras de cada longitud
     * La palabra más larga consideraremos de longitud 15
     *
     */
    public int[] calcularFrecuenciaLongitud() {
        int[] frec = new int[15];
        
        for (int i = 0; i < total; i++) {
            int longitud = palabras[i].getPalabra().length();    
            frec[longitud - 1]++;
        }
        
        return frec;
    }

    /**
     * @param frecuencia se borra del array palabras aquellas de frecuencia
     *                   menor a la proporcionada
     * @return el n de palabras borradas
     */
    public int borrarDeFrecuenciaMenor(int frecuencia) {
        int suma = 0;
        for (int i = total - 1; i > -1; i--) {
            if (palabras[i].getFrecuencia() < frecuencia) {
                for (int j = i; j < total ; j++) {
                   palabras[j] = palabras[j + 1]; 
                }
                total--;
                suma++;
                
            }
        }
        
        return suma;
    }

    /**
     *  Lee de un fichero un texto formado por una
     *  serie de líneas.
     *  Cada línea contiene varias palabras separadas
     *  por espacios o el . o la ,
     *
     */
    public void leerDeFichero(String nombre) {
        Scanner sc = new Scanner(
                this.getClass().getResourceAsStream(nombre));
        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            this.addPalabras(linea);
        }
        sc.close();
    }
}
