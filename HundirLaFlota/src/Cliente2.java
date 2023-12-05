import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente2 {

	public static void main(String[] args) {

//		ArrayList<String> letras = new ArrayList();
//		ArrayList<Integer> numero = new ArrayList();
//		Tablero tablero = new Tablero();
//		Barcos b = new Barcos();
//		AnadirBarcos ab = new AnadirBarcos(letras, numero, tablero, b);
//		ab = aniadir(ab, letras, numero);
//		tablero=ab.getTablero();
//		b=ab.getBarcos();
//		tablero.mostrarTablero();
		boolean acabado=false;
		Scanner s= new Scanner(System.in);

		try (Socket socket = new Socket("localhost", 5678);
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());) {
			

			while(!acabado) {
				String turno=dis.readLine();
				System.out.println(turno);
				int sn=dis.read();
	
				if(sn==1) {
					//TURNO CUANDO LE TOCA
					System.out.println("Escribe la letra de la columna que quieres comprobar si hay barco");
					String letra =s.nextLine();
					System.out.println("Escribe el numero de la fila que quieres comprobar si hay barco");
					int num=s.nextInt();
					dos.writeBytes(letra+"\n");
					dos.write(num);
					
					
				}else {
					//CUANDO NO LE TOCA
					
				}
			
				System.out.println(dis.readLine());
			}
				

		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
