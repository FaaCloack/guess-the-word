import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class BoardOver implements BoardState{
	private Board manager;
	
	public BoardOver(Board manager){
		this.manager = manager;
	}

	public void paint(Graphics dbg) {
		/*Dibuja la pantalla final*/
		dbg.setColor(Color.magenta);
		dbg.fillRect(0, 0, 800, 600);
		dbg.setColor(Color.white);
		dbg.fillRect(5, 5, 790, 590);
		dbg.setColor(Color.black);
		dbg.setFont(new Font("Impact", Font.PLAIN, 40)); //imprime felicitacion
		dbg.drawString("¡ Felicidades al ganador !", 220, 200);
		dbg.setFont(new Font("Impact", Font.PLAIN, 35));
		dbg.setFont(new Font("Impact", Font.PLAIN, 35));
		
		dbg.setColor(Color.magenta);
		dbg.drawString(Logic.getInstance().getActual(), 330, 250); //nombre de el ganador
		dbg.setColor(Color.black);
		dbg.drawString("La palabra adivinada fue:", 210, 380);
		dbg.drawString(Logic.getInstance().getPalabra(), 210, 440); //palabra adivinada
	}

	public void keyPressed(int k) { //si el usuario presiona ENTER el juego termina
		if (k==KeyEvent.VK_ENTER){
			System.exit(0);
		}
	}

	public void update() {
		
	}

	public void mouseClicked(MouseEvent e) {
		
		
	}

	/*Metodos para cambiar de estado*/

	public void over() {
		//no hace nada porque ya esta en ese estado
	}
	public void turno1() {
		//no puede pasar a ese estado
	}
	public void turno2() {
		//no puede pasar a ese estado
	}
	public void load() {
		//no puede pasar a ese estado
	}
	public void start() {
		//no puede pasar a ese estado
		manager.setState(manager.getStart());
	}

}
