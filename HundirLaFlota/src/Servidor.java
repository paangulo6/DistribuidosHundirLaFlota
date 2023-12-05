import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
	
	public static void main(String[] args) {
		
		//Jugador1
		ArrayList<String> letras = new ArrayList();
		ArrayList<Integer> numero = new ArrayList();
		Tablero tablero1 = new Tablero();
		Barcos b1 = new Barcos();
		AnadirBarcos ab1 = new AnadirBarcos(letras, numero, tablero1, b1);
		ab1 = aniadir(ab1, letras, numero);
		tablero1=ab1.getTablero();
		b1=ab1.getBarcos();
		
		//Jugador2
		letras = new ArrayList();
		numero = new ArrayList();
		Tablero tablero2 = new Tablero();
		Barcos b2 = new Barcos();
		AnadirBarcos ab2 = new AnadirBarcos(letras, numero, tablero2, b2);
		ab2 = aniadir(ab2, letras, numero);
		tablero2=ab2.getTablero();
		b2=ab2.getBarcos();
		
		
		boolean acabado= false;
		int numjugadores=0;
		ArrayList<DataOutputStream> listdos = new ArrayList<DataOutputStream>();
		ArrayList<DataInputStream> listdis = new ArrayList<DataInputStream>();
		
		try(ServerSocket server= new ServerSocket(5678)){
			while(true){
				Socket cliente= server.accept();
				DataInputStream dis= new DataInputStream(cliente.getInputStream());
				listdis.add(dis);
				DataOutputStream dos= new DataOutputStream(cliente.getOutputStream());
				listdos.add(dos);
				numjugadores++;
				
				if(numjugadores==2) {
					AtenderPeticion ap= new AtenderPeticion(listdis, listdos, tablero1, b1 , tablero2 , b2);
					ap.run();
				}
			
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
			
	
	public static AnadirBarcos aniadir(AnadirBarcos ab, ArrayList<String> letras, ArrayList<Integer> numero) {
		// 1BARCO4
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("A");
		letras.add("B");
		letras.add("C");
		letras.add("D");
		numero.add(1);
		numero.add(1);
		numero.add(1);
		numero.add(1);
		ab.setLetras(letras);
		ab.setNumeros(numero);
		ab.aniadir(1);
		// 1BARCO3
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("H");
		letras.add("H");
		letras.add("H");
		numero.add(1);
		numero.add(2);
		numero.add(3);
		ab.setLetras(letras);
		ab.setNumeros(numero);
		ab.aniadir(1);
		// 2BARCO3
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("F");
		letras.add("F");
		letras.add("F");
		numero.add(6);
		numero.add(7);
		numero.add(8);
		ab.setLetras(letras);
		ab.setNumeros(numero);
		ab.aniadir(2);
		// 1BARCO2
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("C");
		letras.add("C");
		numero.add(6);
		numero.add(7);
		ab.setLetras(letras);
		ab.setNumeros(numero);
		ab.aniadir(1);
		// 2BARCO2
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("H");
		letras.add("H");
		numero.add(9);
		numero.add(10);
		ab.setLetras(letras);
		ab.setNumeros(numero);
		ab.aniadir(2);
		// 3BARCO2
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("A");
		letras.add("B");
		numero.add(10);
		numero.add(10);
		ab.setLetras(letras);
		ab.setNumeros(numero);
		ab.aniadir(3);
		// 1BARCO1
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("H");
		numero.add(4);
		ab.setLetras(letras);
		ab.setNumeros(numero);
		ab.aniadir(1);
		// 2BARCO1
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("J");
		numero.add(4);
		ab.setLetras(letras);
		ab.setNumeros(numero);
		ab.aniadir(2);
		// 3BARCO1
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("D");
		numero.add(3);
		ab.setLetras(letras);
		ab.setNumeros(numero);
		ab.aniadir(3);
		// 4BARCO1
		letras = new ArrayList();
		numero = new ArrayList();
		letras.add("I");
		numero.add(7);
		ab.setLetras(letras);
		ab.setNumeros(numero);
		ab.aniadir(4);
		return ab;
	}

}
