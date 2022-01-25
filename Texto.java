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
 *
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
     *
     * @return true si el texto está completo
     */
    public boolean textoCompleto() {
        return total == palabras.length;
    }

    /**
     *
     * @return el nº de palabras distintas aparecidas en
     * el texto y guardadas en el array
     */
    public int totalPalabras() {
        // int aux = 0;
        // for (int i = 0; i < total; i++) {
            // String palabra = palabras[i].getPalabra();
            // for (int j = i + 1; j < total; j++){
                // if (palabra.equals(palabras[j].getPalabra())){
                    // aux++;
                // }
            // }
        // }
        // return total - aux;//palabras distintas
        return total;
    }

    /**
     * Dada una línea de texto conteniendo diferentes palabras
     * el método extre las palabras y las inserta en el array
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
        if (!textoCompleto()){
            String auxLinea = linea.toUpperCase().trim();
            String delimitadores = "[ .,]+";
            String[] words = auxLinea.split(delimitadores);
            //añadir words a palabras...
            for (int i = 0; i < words.length; i++) {
                if (estaPalabra(words[i]) == -1) { //añadir palabra
                    insertarPalabraEnOrden(words[i]);
                }
                else { //sumar frecuencia de la palabra
                    int pos = estaPalabra(words[i]);
                    palabras[pos].incrementar();
                }
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
        String aux = palabra.toUpperCase();
        int i = 0;
        while (i < total && pos == -1) {
            if (palabras[i].getPalabra().equals(aux)) {
                pos = i;
            }
            else {
                i++;
            }
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
       if (!textoCompleto() && estaPalabra(palabra) == - 1) {
            String auxPalabra = palabra.toUpperCase();
            int i = total - 1;
            //buscar lugar e ir desplazando a la derecha
            while (i >= 0 && palabras[i].getPalabra().compareTo(auxPalabra) > 0 ) {
                palabras[i + 1] = palabras[i];
                i--;
            }
            //insertar en posicion..
            Palabra nueva = new Palabra(auxPalabra);
            palabras[i + 1] = nueva;
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
     *
     *
     */
    public String toString() {
        String resul = "";//StringBuilder
        int col = 0;
        for (int i = 0; i < total; i++) {
            resul += palabras[i].toString();
            col++;
            if (col == 5) {
                resul += "\n";
                col = 0;
            }
        }
        return resul;
    }

    /**
     *  Devuelve la palabra de la posición p
     *  Si p es incorrecto se devuelve null
     *      
     */
    public Palabra getPalabra(int p) {
        if (p >= 0 && p < total) {
            return palabras[p];
        }
        return null;
    }

    
    /**
     *
     * @return un array de cadenas con las palabras del texto
     * capitalizadas de forma alterna
     */
    public String[] capitalizarAlterna() {
       String[] alternado = new String[total];
        for (int i = 0; i < total; i++) {
            alternado[i] = Utilidades.capitalizarAlterna(palabras[i].getPalabra());
        }
        return alternado;
    }

    /**
     *
     * @return un array de cadenas con las palabras que tienen letras
     * repetidas
     */
    public String[] palabrasConLetrasRepetidas() {
        int tam = 0;
        //encontrar la cantidad de palabras con letras repetidas del array
        for (int i = 0; i < total; i++) {
            if (Utilidades.tieneLetrasRepetidas(palabras[i].getPalabra())) {
                tam++;
            }
        }
        String[] pConRepetidas = new String[tam];
        int pos = 0;
        //añadir las palabras al array
        for (int i = 0; i < total; i++) {
            if (Utilidades.tieneLetrasRepetidas(palabras[i].getPalabra())) {
                pConRepetidas[pos] = palabras[i].getPalabra();
                pos++;
            }
        }
        return pConRepetidas;    
    }

     /**
     *
     * @return un array con la frecuencia de palabras de cada longitud
     * La palabra más larga consideraremos de longitud 15
     *
     */
    public int[] calcularFrecuenciaLongitud() {
        //Asumiendo que la palabra debe ser de al menos 1 letra 
        int[] longitudes = new int[15];
        for (int i = 0; i < total; i++) {
            int longitud = palabras[i].getPalabra().length();
            longitudes[longitud - 1]++;
        }
        return longitudes;
    }
    
    /**
     *
     * @param frecuencia se borra del array palabras aquellas de frecuencia
     *                   menor a la proporcionada
     * @return el n de palabras borradas
     */
    public int borrarDeFrecuenciaMenor(int frecuencia) {
        //TODO 
        
        
        
        
        return 0;
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
