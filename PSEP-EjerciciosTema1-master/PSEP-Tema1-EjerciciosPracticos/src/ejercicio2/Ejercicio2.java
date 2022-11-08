package ejercicio2;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.concurrent.TimeUnit;

/**
 * Enunciado:
		 *
		 * Crea una clase que lance los siguientes procesos y que sincronice la ejecución entre ellos:ç
		 *
		 *      - Proceso 1: Debe abrir la aplicación bloc de notas. El usuario debe escribir en él una serie de líneas. Cuando termine de escribir,
		 *        guardará el fichero y cerrará el bloc de notas. El fichero a guardar debe llamarse numLineas.txt y guardarse en la carpeta C:\ejercicio2.
		 *
		 *      - Proceso 2: Debe lanzar una clase Java que se llamará CuentaLineas.java.
		 *        La clase CuentaLineas.java debe leer de la entrada estándar una serie de líneas (no sabemos cuántas) y devolver el número de líneas que ha leído.
		 *        El proceso 2 debe redireccionar la entrada estándar de forma que ésta sea el fichero numLineas.txt creado por el Proceso 1. La salida estándar
		 *        y la de error del Proceso 2 deben redirigirse hacia las del proceso padre (es decir, la consola).
		 *        El Proceso 2 debe esperar a que el Proceso 1 termine para así poder leer del fichero, pero si el Proceso 1 tarda más de 30 segundos en terminar,
		 *        se debe de terminar la ejecución del proceso, mostrando el mensaje de error correspondiente.
 */
public class Ejercicio2 {

	public static void main(String[] args) {
		// Comandos que se van a usar
		String comando1 = "notepad C:\\ejercicio2\\numLineas.txt";
		String comando2 = "java ejercicio2.CuentaLineas";
		
		// Proceso1: Se encarga de abrir el bloc de notas
		// Le indicamos la ruta que nos dice el ejercicio: C:\ejercicio2\numLineas.txt
		ProcessBuilder pb1 = new ProcessBuilder(comando1.split(" "));
		pb1.inheritIO(); // Heredamos tanto la entrada como la salida estándar del padre

		// Proceso 2: Lanza la clase CuentaLineas.java
		ProcessBuilder pb2 = new ProcessBuilder(comando2.split(" "));
		
		pb2.directory(new File("bin")); // Ponemos como directorio la ruta en la que se encuentra la clase
		System.out.println(pb2.directory().getAbsolutePath());
		pb2.redirectInput(new File("C:\\ejercicio2\\numLineas.txt")); // Redireccionamos la entrada estándar al fichero a leer
		
		// Redireccionamos la salida estándar y la de error a la consola
		pb2.redirectOutput(Redirect.INHERIT); 
		pb2.redirectError(Redirect.INHERIT);
		
		try {
			Process p1 = pb1.start();
			boolean finished = p1.waitFor(30, TimeUnit.SECONDS);
			if (finished) {
				Process p2 = pb2.start();
				int p2retorno = p2.waitFor();
				
				// Compruebo cómo ha terminado el proceso 2 y escribo un mensaje en consecuencia
				if (p2retorno == 0) {
					System.out.println("El proceso \"" + comando2 + "\" ha finalizado correctamente");
				} else {
					System.out.println(
							"El proceso \"" + comando2 + "\" ha terminado con el siguiente código de error: " + p2retorno);
				}
			} else {
				// Si tarda más de 30 segundos matamos el proceso
				p1.destroy();
				// Si devuelve false el método waitFor significa que no lo hemos esperado
				System.out.println("Has tardado más de 30 segundos en escribir.\nTerminamos el proceso");
			}
			// Tomamos el valor con el que ha terminado el proceso 1
			int p1retorno = p1.exitValue();
			
			// Compruebo cómo ha terminado el proceso 1 y escribo un mensaje en consecuencia
			if (p1retorno == 0) {
				System.out.println("El proceso \"" + comando1 + "\" ha finalizado correctamente");
			} else {
				System.out.println(
						"El proceso \"" + comando1 + "\" ha terminado con el siguiente código de error: " + p1retorno);
			}
		} catch (IOException e) {
			System.err.println("Error durante ejecución del proceso");
			System.err.println("Información detallada");
			System.err.println("---------------------");
			e.printStackTrace();
			System.err.println("---------------------");
			// Indicamos que la ejecución termina con error 1
			System.exit(1);
		} catch (InterruptedException e) {
			System.err.println("Proceso interrumpido");
			// Indicamos que la ejecución termina con error 2
			System.exit(2);
		}
	}

}
