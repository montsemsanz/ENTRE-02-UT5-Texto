import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *  Punto de entrada a la aplicaci�n 
 *
 *
 */
public class AppTexto {
    
    public static void main(String[] args) {
        if (args.length == 1) {
        
            Texto texto = new Texto(Integer.parseInt(args[1]));
            texto.leerDeFichero(args[0]);
            
            System.out.println(texto.toString());
            
            separador();
            
            testCapitalizarAlterna(texto);
            separador();
            
            testPalabrasConLetrasRepetidas(texto);
            separador();
            
            testCalcularFrecuenciaLongitud(texto);
            separador();
            
            testBorrarDeFrecuenciaMenor(texto);
            separador();
            
            testCalcularFrecuenciaLongitud(texto);
            separador();
            
        }
        else {
            System.out.println("Error en n� de argumentos\nSintaxis:java AppTexto <n>");
        }
   
        
        
    }
    
    
    private static void testCapitalizarAlterna(Texto texto) {
        System.out.println("Despu�s de capitalizar las palabras del texto ");
        System.out.println(Arrays.toString(texto.capitalizarAlterna()));
        
    }
    
    private static void testPalabrasConLetrasRepetidas(Texto texto) {
        System.out.println("Palabras en el texto con letras repetidas ");
        System.out.println(Arrays.toString(texto.palabrasConLetrasRepetidas()));
    }
    
    
    private static void testBorrarDeFrecuenciaMenor(Texto texto) {
        int frecuencia = 3;
        System.out.println("\nDespu�s de borrar palabras de frecuencia < "
                + frecuencia);
        int borradas = texto.borrarDeFrecuenciaMenor(frecuencia);
        System.out.println("Se han borrado " + borradas + " palabras");
        System.out.println(texto.toString());
    }
    
    private static void testCalcularFrecuenciaLongitud(Texto texto) {
        System.out.println("Longitudes y frecuencias ");
        int[] frecuencias = texto.calcularFrecuenciaLongitud();
        System.out.print(String.format("%15s", "Longitudes"));
        IntStream.range(0, frecuencias.length).forEach(i -> System.out.print(String.format("%5d", i + 1)));
        System.out.println();
        System.out.print(String.format("%15s", "N� palabras"));
        IntStream.range(0, frecuencias.length).forEach(i -> System.out.print(String.format("%5d", frecuencias[i])));
        System.out.println();
        
    }
    
    private static void separador() {
        System.out.println("\n" +
                "-----------------------------------------------\n");
    }
    
    
}
