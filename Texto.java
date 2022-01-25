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
        linea = linea.trim();
        Palabra pal = new Palabra(linea);
        if(estaPalabra(linea) == -1 || total < palabras.length){
            if(total == 0){

                palabras[0] = pal;

            }else{
                insertarPalabraEnOrden(linea);
            }
        }
        total++;
    }

    /**
     *  dada una palabra devuelve la posición en la que se
     *  encuentra en el array o -1 si no está
     *
     *  Indiferente mayúsculas y minúsculas
     */
    public int estaPalabra(String palabra) {
        int posicion = -1;

        for(int i = 0; i <= total - 1; i++){
            if(palabras[i].getPalabra().equals(palabra)){
                posicion = i;

            }

        }
        return posicion;
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
        Palabra pal = new Palabra(palabra);
        for(int i = 0; i <= total - 1; i++){
            if(palabras[i].getPalabra().compareTo(palabra) > 0){
                for(int j = total - 1; j >= i; j++){

                    palabras[j + 1] = palabras[j];  

                }
                palabras[i] = pal;
                total++;

            }

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
        StringBuilder strb = new StringBuilder();

        for(int i = 0; i <= total - 1; i++){

            strb.append(palabras[i].toString()).append("\t");

        }

        return strb.toString();
    }

    /**
     *  Devuelve la palabra de la posición p
     *  Si p es incorrecto se devuelve null
     *      
     */
    public Palabra getPalabra(int p) {

        if(p < 0 || p > total){
            System.out.println("La posicion es incorrecta");
            return null;            
        }

        return palabras[p];
    }

    /**
     *
     * @return un array de cadenas con las palabras del texto
     * capitalizadas de forma alterna
     */
    public String[] capitalizarAlterna() {
        String[] capitalizados = new String[total];

        for(int i = 0; i <= total - 1; i++){
            capitalizados[i] = Utilidades.capitalizarAlterna(palabras[i].getPalabra());

        }        

        return capitalizados;

    }

    /**
     *
     * @return un array de cadenas con las palabras que tienen letras
     * repetidas
     */
    public String[] palabrasConLetrasRepetidas() {

        String[] repetidos = new String[total];

        for(int i = 0; i <= total - 1; i++){
            if(Utilidades.tieneLetrasRepetidas(palabras[i].getPalabra())){
                repetidos[i] = palabras[i].getPalabra();
            }

        }        

        return repetidos;   
    }

    /**
     *
     * @return un array con la frecuencia de palabras de cada longitud
     * La palabra más larga consideraremos de longitud 15
     *
     */
    public int[] calcularFrecuenciaLongitud() {
        int[] frecuencia = new int[total];
        for(int i = 0; i <= total - 1; i++){

            frecuencia[i] = palabras[i].getFrecuencia();

        }

        return null;
    }

    /**
     *
     * @param frecuencia se borra del array palabras aquellas de frecuencia
     *                   menor a la proporcionada
     * @return el n de palabras borradas
     */
    public int borrarDeFrecuenciaMenor(int frecuencia) {
        int borradas = 0;

        for(int i = 0; i <= total - 1; i++){
            if(palabras[i].getFrecuencia() < frecuencia){

                palabras[i - 1] = palabras[i];

            }
            borradas++;
            total--;

        }
        return borradas;
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
