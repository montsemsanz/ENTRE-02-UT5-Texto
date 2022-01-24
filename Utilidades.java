/**
 * clase Utilidades 
 * incluye  métodos estáticos para trabajar con String
 *
 */
public class Utilidades {

    /**
     * Dada una cadena devuelve una nueva capitalizando los caracteres de
     * tres en tres de forma
     * alterna empezando por mayúscula (mayúscula, minúscula, mayúscula,
     * minúscula, ....) 
     * Ej. si la cadena recibida es "texto" devuelve "TEXto"
     * si la cadena recibida es "zapato" devuelve "ZAPato"
     * si la cadena recibida es "de" devuelve "DE"
     */

    public static String capitalizarAlterna(String cadena) {
        String alterna = "";
        int contador1 = 0;
        int contador2 = 0;

        for(int i = 0; i < cadena.length(); i++) {

            if(contador1 < 3) {
                alterna += cadena.toUpperCase().charAt(i);
                contador1++;
                if(contador2 == 3) {
                    contador2 = 0;
                }
            }
            else {
                if(contador2 < 3){
                    alterna += cadena.toLowerCase().charAt(i);
                    contador2++;
                }
                else{
                    contador1 = 0;
                    alterna += cadena.toUpperCase().charAt(i);
                    contador1++;
                }

            }

        }
        return alterna;
        // String secuencia ="";

        // int contador = 0;
        // for(int i = 0; i < cadena.length(); i++) {
        // if(contador >= 3 && contador < 6 && contador < cadena.length()) {
        // secuencia += cadena.toLowerCase().charAt(i);

        // }
        // else{
        // secuencia += cadena.toUpperCase().charAt(i);

        // }
        // contador++;
        // }

    }
    /**
     * Dada una cadena devuelve true si hay letras repetidas, false en otro caso
     * Es indiferente mayúsculas o minúsculas
     *
     * Pista!! puedes hacer de forma sencilla este método con ayuda de
     * indexOf y substring
     *
     */
    public static boolean tieneLetrasRepetidas(String cadena) {
        cadena = cadena.toLowerCase();
        for(int i = 0; i < cadena.length(); i++) {
            for(int j = i +1; j < cadena.length(); j++) {
                if((cadena.charAt(i) == (cadena.charAt(j)))) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     *
     */
    public static void main(String[] args) {
        String cadena = "zaPaTo";
        System.out.println(cadena + "\tCapitalizada alterna: " +
            Utilidades.capitalizarAlterna(cadena));
        cadena = "pez";
        System.out.println(cadena + "\tCapitalizada alterna: " +
            Utilidades.capitalizarAlterna(cadena));

        cadena = "vaso";
        System.out.println(cadena + "\tCapitalizada alterna: " +
            Utilidades.capitalizarAlterna(cadena));

        cadena = "semana";
        System.out.println(cadena + "\tTiene letras repetidas?: " +
            Utilidades.tieneLetrasRepetidas(cadena));

        cadena = "quebrantos";
        System.out.println(cadena + "\tTiene letras repetidas?: " +
            Utilidades.tieneLetrasRepetidas(cadena));

        cadena = "y";
        System.out.println(cadena + "\tTiene letras repetidas?: " +
            Utilidades.tieneLetrasRepetidas(cadena));

        cadena = "de";
        System.out.println(cadena + "\tTiene letras repetidas?: " +
            Utilidades.tieneLetrasRepetidas(cadena));

    }

}