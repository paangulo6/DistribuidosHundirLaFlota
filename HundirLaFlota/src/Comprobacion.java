import java.util.ArrayList;

public class Comprobacion {

	ArrayList<String> letras;
	ArrayList<Integer> numero;
	Tablero t;
	boolean estabien;

	public Comprobacion(ArrayList<String> letras, ArrayList<Integer> numero, Tablero t) {
		this.letras = letras;
		this.numero = numero;
		this.estabien = false;
		this.t=t;
	}
	

	//Pre:
	//Post: devuelve verdad si cumple todas las comprobaciones y falso en caso contrario
	public boolean comprobar() {
		boolean orden = ordenacion();
		boolean letrascomp= letrascomp();
		boolean numcom= numerocomp();
		boolean haybarco= haybarco();
		boolean norepetidos= norepetidos();
		return orden &&  letrascomp &&  numcom && !haybarco  && norepetidos;
	}

	// Metodo para comprobar que las letras que nos pasan estan coprendidas entre A
	// y J
	// pre:
	// POST: devuelve verdad si todas las letras estan comprendidas entre A y J y
	// falso en caso contrario
	public boolean letrascomp() {
		boolean l = true;
		String a = "A";
		String j = "J";
		char letramenor = a.charAt(0);
		char letramayor = j.charAt(0);
		for (String s : this.letras) {
			char letraActual = s.charAt(0);
			if (letraActual > letramayor || letraActual < letramenor) {
				l = false;
			}
		}
		return l;
	}

	
	
	// Metodo para comprobar que los numeros que nos pasan estan coprendidas entre 1 y 10
	// pre:
	// POST: devuelve verdad si todas los numeros estan comprendidas entre 1 y 10 y
	// falso en caso contrario
	public boolean numerocomp() {
		boolean n = true;
		for (int i : this.numero) {
			if (i > 10 || i < 1) {
				n = false;
			}
		}
		return n;
	}

	//Pre:
		//Post: devuelve verdad si NO hay repetidos y falso en caso contario
		public boolean norepetidos() {
			boolean iguales= true;
			boolean diferentes=true;
			//Comprobamos si es la misma letra
			for (int n = 0; n < this.letras.size() - 1; n++) {
				if (!this.letras.get(n).equals(this.letras.get(n + 1))) {
					iguales = false;
				}
			}
			//Si la letra es igual los numeros no tienen que ser iguales
			if (iguales) {
				for (int n = 0; n < this.numero.size() - 1; n++) {
					for(int i=0; i<this.numero.size() - 1; i++) {
						if(i!=n) {
							if(this.numero.get(i)== this.numero.get(n)) {
								diferentes=false;
							}
						}
					}
				}
				
			} else {
				iguales = true;
				// COMPROBACION CUANDO ES EL MISMO NUMERO
				for (int n = 0; n < this.numero.size() - 1; n++) {
					if (this.numero.get(n) != this.numero.get(n + 1)) {
						iguales = false;
					}
				}
				//Si es el mismmo numero las letras tienen que ser diferentes
				if (iguales) {
					for (int n = 0; n < this.letras.size() - 1; n++) {
						for(int i=0; i<this.letras.size() - 1; i++) {
							if(i!=n) {
								if(this.letras.get(i).equals( this.letras.get(n))) {
									diferentes=false;
								}
							}
						}
					}
				}else {
					return false;
				}
			}
			return diferentes;
		}
		
	
	// Metodo para comprobar que el orden de las posiciones esta bien. Por ejemplo:
	// A7 B7 C7 E7: FALSA
	// C4 D4 E4 F4 : VERDADERA
	// I3 I4 I5 I6 : VERDADERA
	// I3 I4 I5 I7: FALSA
	// PRE:
	// POST: devuelve verdad si se cumple alguna de estas condiciones y faslo en
	// caso contrario
	// Condiciones:
	// 1. Si los numeros son iguales las letras tiene que estar ordenadas de menor a
	// mayor (A-B-C-D-E-F-G-H-I-J),
	// no tienen porque empezar por primera letra pero si que tienen que estar
	// seguidas. Por ejemplo: Verdad: C-D-E Falso: C-E-G
	// 2. Si las letras son iguales los numeros tienen que estar ordenados de menor
	// a a mayor (1-2-3-4-5-6-7-8-9-10),
	// no tienen porque empezar por el numero uno pero si tienen que ser seguidos.
	// Por ejemplo: Verdad : 5-6-7-8 Falso: 1-2-4
	public boolean ordenacion() {
		boolean c = true;
		// COMPROBACION CUANDO ES LA MISMA LETRA y EL NUMERO ORDENADO DE MENOR A MAYOR Y
		// SEGUIDO
		for (int n = 0; n < this.letras.size() - 1; n++) {
			if (!this.letras.get(n).equals(this.letras.get(n + 1))) {
				c = false;
			}
		}
		if (c) {
			for (int n = 0; n < this.numero.size() - 1; n++) {
				if (this.numero.get(n) + 1 != this.numero.get(n + 1)) {
					c = false;
				}
			}
		} else {
			c = true;
			// COMPROBACION CUANDO ES EL MISMO NUMERO
			for (int n = 0; n < this.numero.size() - 1; n++) {
				if (this.numero.get(n) != this.numero.get(n + 1)) {
					c = false;
				}
			}
			if (c) {
				for (int n = 0; n < this.letras.size() - 1; n++) {
					char letraActual = this.letras.get(n).charAt(0);
					char letraSiguiente = this.letras.get(n + 1).charAt(0);
					if (letraSiguiente + 1 != letraActual + 2) {
						c = false;
					}
				}
			}
		}
		return c;
	}
	
	//Pre:
	//Post: devuelve verdad si en las posiciones pasadas  hay un barco y falso en caso contrario
	public boolean haybarco() {
		boolean b=false;
		for(int n=0; n<this.letras.size(); n++) {
			if(t.hayBraco(letras.get(n) , numero.get(n))) {
				b=true;
			}
		}
		return b;
	}

}
