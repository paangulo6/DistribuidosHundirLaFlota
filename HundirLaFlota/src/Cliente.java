import java.io.*;
import java.net.*;
import java.util.*;

public class Cliente {

	private int numerobarcos;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Tablero tablero = new Tablero();
		Barcos barcos = new Barcos();
		boolean estabien = false;

		menu();

		ArrayList<String> letras = new ArrayList<String>();
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		AnadirBarcos abarcos = new AnadirBarcos(letras, numeros, tablero, barcos);

		while (estabien == false) {
			letras = new ArrayList();
			numeros = new ArrayList();
			System.out.println("1º barco de 4 casillas");
			for (int i = 0; i <= 3; i++) {
				System.out.println("Introzuca la letra de fila en la que quiere colacar el barco");
				String letra = s.next();
				letras.add(letra);
				System.out.println("Introzuca el numero de  columna en la que quiere colacar el barco");
				int num = s.nextInt();
				numeros.add(num);
			}
			abarcos.setLetras(letras);
			abarcos.setNumeros(numeros);
			estabien = abarcos.aniadir(1);
			if (estabien == false) {
				System.out.println("Barco mal introducido");
			}
		}
		tablero = abarcos.getTablero();
		tablero.mostrarTablero();
		System.out.println("1º barco de 4 casillas introducido correctamente");

		int numbarco = 1;
		while (numbarco <= 2) {
			estabien = false;
			while (estabien == false) {
				letras = new ArrayList();
				numeros = new ArrayList();
				System.out.println(numbarco + "º barco de 3 casillas");
				for (int i = 0; i <= 2; i++) {
					System.out.println("Introzuca la letra de fila en la que quiere colacar el barco");
					String letra = s.next();
					letras.add(letra);
					System.out.println("Introzuca el numero de  columna en la que quiere colacar el barco");
					int num = s.nextInt();
					numeros.add(num);
				}
				abarcos.setLetras(letras);
				abarcos.setNumeros(numeros);
				estabien = abarcos.aniadir(numbarco);
				if (estabien == false) {
					System.out.println("Barco mal introducido");
				}
			}
			tablero = abarcos.getTablero();
			tablero.mostrarTablero();
			System.out.println(numbarco + "º barco de 3 casillas introducido correctamente");
			numbarco++;
		}

		numbarco = 1;
		while (numbarco <= 3) {
			estabien = false;
			while (estabien == false) {
				letras = new ArrayList();
				numeros = new ArrayList();
				System.out.println(numbarco + "º barco de 2 casillas");
				for (int i = 0; i <= 1; i++) {
					System.out.println("Introzuca la letra de fila en la que quiere colacar el barco");
					String letra = s.next();
					letras.add(letra);
					System.out.println("Introzuca el numero de  columna en la que quiere colacar el barco");
					int num = s.nextInt();
					numeros.add(num);
				}
				abarcos.setLetras(letras);
				abarcos.setNumeros(numeros);
				estabien = abarcos.aniadir(numbarco);
				if (estabien == false) {
					System.out.println("Barco mal introducido");
				}
			}
			tablero = abarcos.getTablero();
			tablero.mostrarTablero();
			System.out.println(numbarco + "º barco de 2 casillas introducido correctamente");
			numbarco++;
		}
		numbarco = 1;
		while (numbarco <= 4) {
			estabien = false;
			while (estabien == false) {
				letras = new ArrayList();
				numeros = new ArrayList();
				System.out.println(numbarco + "º barco de 1 casillas");
				System.out.println("Introzuca la letra de fila en la que quiere colacar el barco");
				String letra = s.next();
				letras.add(letra);
				System.out.println("Introzuca el numero de  columna en la que quiere colacar el barco");
				int num = s.nextInt();
				numeros.add(num);
				abarcos.setLetras(letras);
				abarcos.setNumeros(numeros);
				estabien = abarcos.aniadir(numbarco);
				if (estabien == false) {
					System.out.println("Barco mal introducido");
				}
			}
			tablero = abarcos.getTablero();
			tablero.mostrarTablero();
			System.out.println(numbarco + "º barco de 2 casillas introducido correctamente");
			numbarco++;
		}

		System.out.println("Has introducido correctamnete tus barcos");
		System.out.println("Tu tablero queda:");
		tablero.mostrarTablero();
		barcos=abarcos.getBarcos();
		System.out.println("Empezamos a jugar.");
		System.out.println("Tu tablero saldra el primero y el de tu contricante el segundo");
		System.out.println("Cuando tu contrincante diga una posicion y no haya tocado agua en tu tablero aparecera O (agua)");
		System.out.println("Cuando tu contrincante diga una posicion  y toque uno de tus barcos aparecera una H");
		System.out.println("Cuando tu contricante te hunda un barco saldra que te ha hundidio el barco y el barco que te haya hundido");
		System.out.println("El jugador 1 empieza la partida.");
		
		
		
		try(Socket socket= new Socket("localhosr", 5678);
				DataInputStream dis= new DataInputStream(socket.getInputStream());
				DataOutputStream dos= new DataOutputStream(socket.getOutputStream());
				){
			ObjectOutputStream oos= new ObjectOutputStream(socket.getOutputStream());
			
			String jugador= dis.readLine();
			System.out.println(jugador);
			boolean acabado=false;
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void menu() {
		System.out.println("Juego de HUNDIR LA FLOTA ");
		System.out.println("El juego consiste en hundir los barcos de tus oponentes.");
		System.out.println("El primero que hunda los barcos del otro gana la partida");
		System.out.println("PREPARACION");
		System.out.println(
				"Cada jugador cuenta con dos cuadriculas 10x10, la primera es la tuya y la segunda la de tu ribal");
		System.out.println("Debes colocar 10 barcos de diferentes tamaños en posiciones horizontales y verticales");
		System.out.println("Los barcos son a colocar son: ");
		System.out.println("            1 barco de 4 casillas");
		System.out.println("            2 barco de 3 casillas");
		System.out.println("            3 barco de 2 casillas");
		System.out.println("            3 barco de 1 casillas");
		System.out.println("En total 20 casillas");
		System.out.println("Normas para colocar los barcos: ");
		System.out.println("            1. Los barcos pueden estar al borde de la cuadricula");
		System.out.println(
				"            2. Los barcos no pueden superponerse, es decir si uno de tus barcos esta en la 1 A otro de tus barcos no puede estar en la 1 A. ");
		System.out.println(
				"            3. Los barcos pueden estar al lado, no hace falta que haya ninguna separacion entre ellos. ");
		System.out.println(
				"            4. Los barcos pueden estar en posicion vertical o horizontal, nunca de forma inclinada ");
		System.out.println("            5. Una vez colocados tus barcos no puedes cambiarlos.");
		System.out.println("En la cuadricula de tu rival se pondra 0 si es agua y x si es barco ");
		System.out.println("Desarollo: ");
		System.out.println("El jugador 1 elige una coordenada y el juego automaticamente le dira una respuesta:");
		System.out.println("			- AGUA: si no hay barco");
		System.out.println("            - TOCADO: si ha coincidico un barco");
		System.out.println(
				"            - HUNDIDO: si es un barco de solo un cuadrado o el ulrimo recuadro sin tocar de un barco tocado anteriorente");
		System.out.println(
				"Al jugador 2 se le mostrara la coordenada elegida por el jugador 1 y si ha tocado, hundidio barco o si ha tcoado agua ");
		System.out.println("Primero: Introducir coordenadas de los barcos");
		System.out.println(
				"Para introducir las coordenadas de los barcos tienes que introducir primero la letra y luego el numero");
		System.out.println("Tienes que introducilos de menor a mayor.");
		System.out.println("Por ejemplo A1 va antes que B1 o que A7.");
		System.out.println("Primero: Introducir coordenadas de los barcos");
	}

}
