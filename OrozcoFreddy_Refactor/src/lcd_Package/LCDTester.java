package lcd_Package;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LCDTester {

	// String que guarda la cadena que finaliza la interacción
	static final String CADENA_FINAL = "0,0";

	
	
	/**
	 * Constructor que permite el ingreso de datos por parte del usuario
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Establece los segmentos de cada numero
		List<String> listaComando = new ArrayList<>();

		String comando;
		int espacioDig;

		// Instancia de la clase ImpresorLCD
		ImpresorLCD impresorLCD = new ImpresorLCD();

		try {

			Scanner lector = new Scanner(System.in);

			System.out.print("Espacio entre Digitos (0 a 5): ");
			comando = lector.next();

			if (impresorLCD.isNumeric(comando)) {
				espacioDig = Integer.parseInt(comando);

				// se valida que el espaciado este entre 0 y 5
				if (espacioDig < 0 || espacioDig > 5) {
					throw new IllegalArgumentException("El espacio entre " + "digitos debe estar entre 0 y 5");
				}

			} else {
				throw new IllegalArgumentException("Cadena " + comando + " no es un entero");
			}

			//Bloque de codigo ciclico hasta que se ingresa la cadena final 0,0
			do {
				System.out.print("Entrada: ");
				comando = lector.next();
				if (!comando.equalsIgnoreCase(CADENA_FINAL)) {
					listaComando.add(comando);
				}
			} while (!comando.equalsIgnoreCase(CADENA_FINAL));

			
			Iterator<String> iterator = listaComando.iterator();
			while (iterator.hasNext()) {

				try {
					impresorLCD.procesar(iterator.next(), espacioDig);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error: " + e.getMessage());
				}

			} // While();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error: " + e.getMessage());
		}
	}// main();

}// CLASS
