import java.util.ArrayList;

public class AnadirBarcos {

	private ArrayList<String> letras;
	private ArrayList<Integer> numeros;
	private Tablero tablero;
	private Barcos barcos;

	public AnadirBarcos(ArrayList<String> letras, ArrayList<Integer> numero, Tablero tablero, Barcos barcos) {
		this.letras = letras;
		this.numeros = numeros;
		this.tablero = tablero;
		this.barcos=barcos;
	}

	public void setLetras(ArrayList<String> letras) {
		this.letras = letras;
	}

	public void setNumeros(ArrayList<Integer> numeros) {
		this.numeros = numeros;
	}

	public Tablero getTablero() {
		return this.tablero;
	}
	
	public Barcos getBarcos() {
		return this.barcos;
	}

	public boolean aniadir(int num) {
		boolean estabien = false;
		Comprobacion c;
		ArrayList<String> posicion = new ArrayList<String>();
		c = new Comprobacion(letras, numeros, tablero);
		estabien = c.comprobar();
		if (estabien) {
			for (int i = 0; i < letras.size(); i++) {
				String clave = letras.get(i) + numeros.get(i);
				posicion.add(clave);
				tablero.tocado(letras.get(i), numeros.get(i));
				
			}
		}
		this.barcos.addBarco(num+"Barco"+letras.size(), posicion);
		return estabien;
	}

}
