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
        int total = cadena.length();
        String cap = "";
        int posMin = 0;
        for(int i = 0; i <= total; i++)  {
            for(int j = 0; j <= 2 && posMin < cadena.length();j++)   {
                if(i % 2 == 0)   {
                    cap += cadena.valueOf(cadena.charAt(posMin)).toUpperCase();
                    posMin++;
                    total--;
                }
                else    {
                    cap += cadena.valueOf(cadena.charAt(posMin)).toLowerCase();
                    posMin++;
                }
            }
        }
        return cap;
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
        // Pasamos a Mayusculas
        cadena = cadena.toUpperCase();
        for(int k = 0; k < cadena.length(); k++)   {
            for(int l = 0; l < cadena.length(); l++)    {
                if((k != l) && (cadena.charAt(k) == cadena.charAt(l)))    {
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
