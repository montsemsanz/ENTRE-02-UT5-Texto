/**
 * Clase Utilidades 
 * Incluye  métodos estáticos para trabajar con String
 * 
 * @author - Iratxe Remón
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
        String str = "";
        int j = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (j < 3 ) {
                str += cadena.substring(i,i + 1).toUpperCase();
            }
            else {
                str += cadena.substring(i, i + 1).toLowerCase();
                if (j == 5) {
                    j = -1; 
                }
            }
            j++;
        }
        return str;
    }

    /**
     * Dada una cadena devuelve true si hay letras repetidas, false en otro caso
     * Es indiferente mayúsculas o minúsculas
     *
     * Pista!! puedes hacer de forma sencilla este método con ayuda de
     * indexOf y substring
     */
    public static boolean tieneLetrasRepetidas(String cadena) {
        boolean repetida = false;
        
        for (int i = 0; i < cadena.length() - 1; i++) {
            for (int j = i + 1; j < cadena.length(); j++) {
                if (cadena.substring(i, i + 1).equalsIgnoreCase(cadena.substring(j, j + 1))) {
                    repetida = true;
                }
            }
        }

        return repetida;
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
