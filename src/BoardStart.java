import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class BoardStart implements BoardState{
	private Board manager;
	private boolean cambia = true;
	private int contador = 0;
	public BoardStart(Board manager){
		this.manager = manager;
	}
	
	public void paint(Graphics dbg) {
		/*Dibuja la pantalla de inicio*/
		dbg.setColor(Color.magenta);
		dbg.fillRect(0, 0, 800, 600);
		dbg.setColor(Color.white);
		dbg.fillRect(5, 5, 790, 590);
		/*Dibuja los botones*/
		dbg.setColor(Color.black);
		dbg.setFont(new Font("Impact", Font.PLAIN, 50));
		dbg.drawString("Bienvenido a Guess it!", 180, 220);
		dbg.setFont(new Font("Impact", Font.PLAIN, 30));
		dbg.setColor(Color.gray);
		dbg.drawString("Presiona ENTER o da Clic en", 220, 280);
		dbg.setColor(Color.magenta);
		dbg.fillRect(200, 350, 400, 90);
		dbg.setFont(new Font("Impact", Font.PLAIN, 40));

		if(cambia){
			dbg.setColor(Color.white);
			if(contador == 5){
				cambia = false;
				contador = 0;
			}
			contador ++;
		}
		else{
			dbg.setColor(Color.black);
			if(contador == 5){
				cambia = true;
				contador = 0;
			}
			contador ++;
		}

		dbg.drawString("Iniciar", 340, 410);

	}
	

	public void update() {
		
		
	}

	public void keyPressed(int k) {
		if (k==KeyEvent.VK_ENTER){
			load();
		}
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		if(x>=200 && x<=600 && y>=350 && y<=440){
			load();
		}

	}

	public void start() {
		
	}

	public void over() {
				
	}


	public void turno1() {
		
	}

	public void turno2() {
		
	}

	public void load() {
		manager.setState(manager.getLoad());
		
	}
}
