import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Tablero implements Serializable{

	// El HashMap lo usaremos como tablerero. Tendra 100 casillas una por cada
	// casilla del tablero
	// la clave sera la fila y la columna y un nuemero representado el tablero
	// Por ejemplo A1: 1 A2: 2 A3:3......
	private HashMap<String, Integer> tablero;

	// Pre:
	// Post: inicialoiza un tablero
	public Tablero() {
		tablero = new HashMap<String, Integer>();
		String letra = "A";
		for (int i = 1; i <= 100; i++) {
			if (i == 11) {
				letra = "B";
			} else if (i == 21) {
				letra = "C";
			} else if (i == 31) {
				letra = "D";
			} else if (i == 41) {
				letra = "E";
			} else if (i == 51) {
				letra = "F";
			} else if (i == 61) {
				letra = "G";
			} else if (i == 71) {
				letra = "H";
			} else if (i == 81) {
				letra = "I";
			} else if (i == 91) {
				letra = "J";
			}
			String clave;
			if (i % 10 == 0) {
				clave = letra + 10;
			} else {
				clave = letra + i % 10;
			}
			tablero.put(clave, i);
		}
		

	}

	// Pre: letra tiene que estar comprendida entre A y J y numero tiene que estar
	// comprendido entre 1 y 10
	// Post: remplaza el valor que haya en el hashMap por un 0 indicado que es agua
	public void agua(String letra, int numero) {
		String clave = letra + numero;
		tablero.replace(clave, 0);
	}

	// Pre: letra tiene que estar comprendida entre A y J y numero tiene que estar
	// comprendido entre 1 y 10
	// Post: remplaza el valor que haya en el hashMap por un -1 indicado que es
	// barco
	public void tocado(String letra, int numero) {
		String clave = letra + numero;
		tablero.replace(clave, -1);
	}
	
	

	// Pre: letra tiene que estar comprendida entre A y J y numero tiene que estar
	// comprendido entre 1 y 10
	// Post: devuelve verdad si en esa posicion ya hay un barco y falso en caso
	// contraio
	public boolean hayBraco(String letra, int numero) {
		String clave = letra + numero;
		int n = tablero.get(clave);
		if (n == 0) {
			return false;
		} else if (n == -1) {
			return true;
		} else {
			return false;
		}
	}

	// Pre:letra es una letra comprendida entre A y J
	// Post: devuelve un ArrayList que consta de O ,X y " ", para ayudar a
	// mostrarnos el tablero segun haya barco agua o nada.
	public ArrayList<String> listatablero(String letra) {

		ArrayList<String> fila = new ArrayList();
		for (int i = 1; i <= 10; i++) {
			String clave = letra + i;
			int n = tablero.get(clave);
			if (n == 0) {
				fila.add("O");
			} else if (n == -1) {
				fila.add("X");
			} else {
				fila.add(" ");
			}
		}

		return fila;
	}

	// Pre:
	// Post: muestra el tablero por pantalla
	public void mostrarTablero() {

		ArrayList<String> fila1 = listatablero("A");
		ArrayList<String> fila2 = listatablero("B");
		ArrayList<String> fila3 = listatablero("C");
		ArrayList<String> fila4 = listatablero("D");
		ArrayList<String> fila5 = listatablero("E");
		ArrayList<String> fila6 = listatablero("F");
		ArrayList<String> fila7 = listatablero("G");
		ArrayList<String> fila8 = listatablero("H");
		ArrayList<String> fila9 = listatablero("I");
		ArrayList<String> fila10 = listatablero("J");

		System.out.println("    | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |");
		System.out.println("---------------------------------------------");
		System.out.println("A   | " + fila1.get(0) + " | " + fila1.get(1) + " | " + fila1.get(2) + " | " + fila1.get(3)
				+ " | " + fila1.get(4) + " | " + fila1.get(5) + " | " + fila1.get(6) + " | " + fila1.get(7) + " | "
				+ fila1.get(8) + " | " + fila1.get(9) + " | ");
		System.out.println("---------------------------------------------");
		System.out.println("B   | " + fila2.get(0) + " | " + fila2.get(1) + " | " + fila2.get(2) + " | " + fila2.get(3)
				+ " | " + fila2.get(4) + " | " + fila2.get(5) + " | " + fila2.get(6) + " | " + fila2.get(7) + " | "
				+ fila2.get(8) + " | " + fila2.get(9) + " | ");
		System.out.println("---------------------------------------------");
		System.out.println("C   | " + fila3.get(0) + " | " + fila3.get(1) + " | " + fila3.get(2) + " | " + fila3.get(3)
				+ " | " + fila3.get(4) + " | " + fila3.get(5) + " | " + fila3.get(6) + " | " + fila3.get(7) + " | "
				+ fila3.get(8) + " | " + fila3.get(9) + " | ");
		System.out.println("---------------------------------------------");
		System.out.println("D   | " + fila4.get(0) + " | " + fila4.get(1) + " | " + fila4.get(2) + " | " + fila4.get(3)
				+ " | " + fila4.get(4) + " | " + fila4.get(5) + " | " + fila4.get(6) + " | " + fila4.get(7) + " | "
				+ fila4.get(8) + " | " + fila4.get(9) + " | ");
		System.out.println("---------------------------------------------");
		System.out.println("E   | " + fila5.get(0) + " | " + fila5.get(1) + " | " + fila5.get(2) + " | " + fila5.get(3)
				+ " | " + fila5.get(4) + " | " + fila5.get(5) + " | " + fila5.get(6) + " | " + fila5.get(7) + " | "
				+ fila5.get(8) + " | " + fila5.get(9) + " | ");
		System.out.println("---------------------------------------------");
		System.out.println("F   | " + fila6.get(0) + " | " + fila6.get(1) + " | " + fila6.get(2) + " | " + fila6.get(3)
				+ " | " + fila6.get(4) + " | " + fila6.get(5) + " | " + fila6.get(6) + " | " + fila6.get(7) + " | "
				+ fila6.get(8) + " | " + fila6.get(9) + " | ");
		System.out.println("---------------------------------------------");
		System.out.println("G   | " + fila7.get(0) + " | " + fila7.get(1) + " | " + fila7.get(2) + " | " + fila7.get(3)
				+ " | " + fila7.get(4) + " | " + fila7.get(5) + " | " + fila7.get(6) + " | " + fila7.get(7) + " | "
				+ fila7.get(8) + " | " + fila7.get(9) + " | ");
		System.out.println("---------------------------------------------");
		System.out.println("H   | " + fila8.get(0) + " | " + fila8.get(1) + " | " + fila8.get(2) + " | " + fila8.get(3)
				+ " | " + fila8.get(4) + " | " + fila8.get(5) + " | " + fila8.get(6) + " | " + fila8.get(7) + " | "
				+ fila8.get(8) + " | " + fila8.get(9) + " | ");
		System.out.println("---------------------------------------------");
		System.out.println("I   | " + fila9.get(0) + " | " + fila9.get(1) + " | " + fila9.get(2) + " | " + fila9.get(3)
				+ " | " + fila9.get(4) + " | " + fila9.get(5) + " | " + fila9.get(6) + " | " + fila9.get(7) + " | "
				+ fila9.get(8) + " | " + fila9.get(9) + " | ");
		System.out.println("---------------------------------------------");
		System.out.println("J  | " + fila10.get(0) + " | " + fila10.get(1) + " | " + fila10.get(2) + " | "
				+ fila10.get(3) + " | " + fila10.get(4) + " | " + fila10.get(5) + " | " + fila10.get(6) + " | "
				+ fila10.get(7) + " | " + fila10.get(8) + " | " + fila10.get(9) + " | ");
		System.out.println("---------------------------------------------");

	}
}
