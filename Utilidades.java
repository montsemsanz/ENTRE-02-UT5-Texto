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
        int Amayusculas = 0;
        int Aminisculas = 0;
        String carcater =  "";
        for (int i = 0; i < cadena.length();i++){
            if(Amayusculas < 3) {
                char firstCharacter = cadena.toUpperCase().charAt(i);
                carcater += firstCharacter;
                Aminisculas = 0;
                Amayusculas++;
            }
            else if(Aminisculas < 3){
                char firstCharacter = cadena.toLowerCase().charAt(i);
                carcater += firstCharacter;
                Aminisculas++;
            }
            else {
                Amayusculas = 0;
            }
        }
        return carcater;

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
        boolean valor = false;
        cadena = cadena.toLowerCase();
        for (int i = 0; i < cadena.length();i++){
            int j = i+1;
            while(j < cadena.length()){
                if(cadena.charAt(i) == cadena.charAt(j)){
                    valor = true;  
                }
                j++;
            }
        }
        return valor;
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
