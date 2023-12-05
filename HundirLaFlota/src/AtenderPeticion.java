import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class AtenderPeticion extends Thread {

	
	private ArrayList<DataInputStream> dis= new ArrayList<DataInputStream>();
	private ArrayList<DataOutputStream> dos= new ArrayList<DataOutputStream>();
	private Tablero t1;
	private Barcos b1;
	private Tablero t2;
	private Barcos b2;
	
	public AtenderPeticion(ArrayList<DataInputStream> dis , ArrayList<DataOutputStream> dos, Tablero t1, Barcos b1,Tablero t2, Barcos b2 ) {
		this.dis=dis;
		this.dos=dos;
		this.t1=t1;
		this.b1=b1;
		this.t2=t2;
		this.b2=b2;
	}
	
	
	public void run() {
		int n1=0;	//Turno
		int n2=1;	// Turno del oponente
		int contador=3;
		boolean acabar=false;
	
		
		while(!acabar) {
			
			if(contador==4) {
				//Turno del jugador2
				n1=1;	
				n2=0;
				contador=3;
			}else  {
				//Turno del jugador1
				n1=0;	
				n2=1;	
				contador=4;
			}
			try {
			
				dos.get(n1).writeBytes("Es tu turno \n");
				dos.get(n1).write(1);
				dos.get(n1).flush();
				dos.get(n2).writeBytes("Turno del oponente \n");
				dos.get(n1).write(2);
				dos.get(n2).flush();
				
				String letra= dis.get(n1).readLine();
				int numero= dis.get(n1).read();
				
				boolean haybarco= t2.hayBraco(letra, numero);
				
				if(haybarco==true) {
					dos.get(n1).writeBytes("TOCADO \n");
					dos.get(n2).writeBytes("TOCADO \n");
					String clave=letra+numero;
					if(contador==4) {
						System.out.println(b1.eliminarBarco(clave));
					}else {
						System.out.println(b2.eliminarBarco(clave));
					}
				}else {
					dos.get(n1).writeBytes("AGUA \n");
					dos.get(n2).writeBytes("AGUA \n");
				}
				

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
	}
	
}
