import java.util.ArrayList;
import java.util.Scanner;

public class Pruebas {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		Tablero t = new Tablero();
		// PRUEBAS PARA VER SI EL TABLERO SE VEIA BIEN
		t.agua("C", 7);
		t.agua("F", 3);
		t.agua("J", 5);
		t.agua("A", 9);
		t.tocado("C", 1);
		t.tocado("A", 9);
		t.tocado("B", 3);
		t.tocado("B", 4);
		t.tocado("D", 2);
		// t.mostrarTablero();


//		//PRUEBA PARA COMPROBAR LAS COORDENADAS CON LA CLASE COMPROBACIÓN
		while(true) {
			ArrayList<String> letras= new ArrayList();
			ArrayList<Integer> numero= new ArrayList();
			for(int i=0; i<=2; i++) {
				System.out.println("Introzuca la letra de fila en la que quiere colacar el barco");
				String letra= s.next();
				letras.add(letra);
				System.out.println("Introzuca el numero de  columna en la que quiere colacar el barco");
				int num= s.nextInt();
				numero.add(num);
			}
			Comprobacion c= new Comprobacion(letras, numero, t);
			System.out.println(c.comprobar());
			
		}

	}

	
}
