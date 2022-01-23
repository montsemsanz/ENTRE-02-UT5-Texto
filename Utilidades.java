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
        int a = 3;
        int x = 0;
        String alternada = "";
        for(int i = 0; i < cadena.length(); i = i + 3){
            if(a > cadena.length()){
                a = cadena.length();
                if(x % 2 == 0){
                    alternada += cadena.substring(i, a).toUpperCase();
                }
                else{
                    alternada += cadena.substring(i, a).toLowerCase();
                }
                i = cadena.length();
            }
            else{
                if(x % 2 == 0){
                    alternada += cadena.substring(i, a).toUpperCase();
                    x++;
                }
                else{
                    alternada += cadena.substring(i, a).toLowerCase();
                    x++;
                }
                a = a + 3;
            }
        }
        return alternada;
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
        //TODO
        
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
