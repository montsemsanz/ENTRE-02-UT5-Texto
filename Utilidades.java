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
        String aux = "";
        String str = "";
        int mayus = 1;
        if(cadena.length() < 4){

            str = cadena.toUpperCase();
        }
        else{
            for(int i = 0; i <= cadena.length() - 1; i += 3){
                if(i + 3 >= cadena.length()){
                    aux = cadena.substring(i,cadena.length());
                    str += aux;
                    return str;
                }

                aux += cadena.substring(i, i + 3);
                if(mayus % 2 != 0){
                    aux = aux.toUpperCase();

                }
                else{
                    aux = aux.toLowerCase();
                
                }
                mayus++;
                str += aux;

            }
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
        boolean repetidos = false;

        int x = 1;

        while(x <= cadena.length()){

            String aux1 = cadena.substring(x - 1, x);

            for(int i = 1; i <= cadena.length() - 1; i++){
                if(x == i){

                    i++;            

                }
                String aux2 = cadena.substring(i - 1,i);
                if(aux1.equals(aux2)){

                    repetidos = true;

                }

            }
            x++;
        }

        return repetidos;
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
