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
        String str = "";
        for(int i = 0; i <= cadena.length(); i++){
            for(int j = 1; j <= 3; j++){
                if(i < cadena.length()){
                    str += cadena.toUpperCase().charAt(i);
                    i++;
                }
                else{
                    return str;
                }

            }
            for(int j = 1; j <= 3; j++){
                if(i < cadena.length()){
                    str += cadena.toLowerCase().charAt(i);;
                    i++;
                }
                else{
                    return str;
                }
            }
            i--;
        }
        return str;
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
        for(int i = 0; i < cadena.length(); i++){
             String cadena2 = cadena.substring(i+1);
            if(cadena2.toLowerCase().indexOf(cadena.toLowerCase().charAt(i)) != -1){
            return true;
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
