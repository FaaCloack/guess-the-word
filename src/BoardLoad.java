import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BoardLoad implements BoardState{
	private Board manager;
	private int contador = 50, cuenta = 6, posY = 425, tama = 50;
	private BufferedImage fondo;
	private BufferedImage j1;
	private BufferedImage j2;
	
	public BoardLoad(Board manager, BufferedImage[] imagenes){
		this.manager = manager;
		ImageLoader loader = new ImageLoader(); //para cargar las imagenes
		try{
			fondo = loader.loadImage("/imagenes/fondo-tablero4.png");
			j1 = loader.loadImage("imagenes/avaJ1.png");
			j2 = loader.loadImage("imagenes/avaJ2.png");
		}catch(IOException e){
			e.printStackTrace();
		}
		/*Asigna las imagenes al arreglo de Imagenes*/
		imagenes[0] = fondo;
		imagenes[1] = j1;
		imagenes[2] = j2;
	}

	public void paint(Graphics dbg) {

		dbg.setColor(Color.black);
		dbg.fillRect(0, 0, 800, 600);
		dbg.setColor(Color.white);
		dbg.setFont(new Font("Arial", Font.PLAIN, 40));
		dbg.drawString("El juego iniciará en ... ", 230, 100);
		dbg.setFont(new Font("Arial", Font.PLAIN, 30));
		dbg.drawString("Utiliza las flechas para hacer tu selección", 130, 550);
		dbg.setColor(Color.white);
		dbg.fillRect(250, 180, 300, 300);
		dbg.setColor(Color.gray);
		dbg.fillRect(255, 185, 290, 290);
		dbg.setColor(Color.magenta);
		dbg.fillRect(255, posY, 290, tama); 

		if(contador>=1){
			dbg.setColor(Color.black);
			if(contador%10 == 0){ //utiliza un contador para cambiar de numero mostrado
				cuenta--;
				posY = posY-45; //cambia la posicion y tamaño del rectangulo magenta
				tama = tama +45;
			}
			contador --;
		}else{
			System.out.println("Turno 1");
			turno1();
		}
		
		dbg.setFont(new Font("Impact", Font.PLAIN, 100));
		dbg.drawString(""+cuenta, 370, 370);
		
	}

	public void update() {
		
	}

	public void keyPressed(int k) {
		
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void start() {
		//no es posble pasar a ese estado
		
	}

	public void over() {
		//no es posible pasar a ese estado desde el actual
		
	}

	public void turno1() {
		manager.setState(manager.getTurno1());
		
	}

	public void turno2() {
		//no es posible pasar a ese estadp
		
	}

	public void load() {
		//esta en ese estado
		
	}

}
