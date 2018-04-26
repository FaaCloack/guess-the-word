import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Board {
		private BoardState current;
		private BoardState turno1;
		private BoardState turno2;
		private BoardState start;
		private BoardState over;
		private BoardState load;
		private String passWord;
		private BufferedImage[] imagenes;
		private StateFactory stateFactory;
		
		public Board(){
			
			passWord = Logic.getInstance().getPalabra();
			imagenes = new BufferedImage[5];
			stateFactory = new StateFactory();

			
			/*Crea los estados a partir del StateFactory*/
			load = stateFactory.getBoardState('L', this, imagenes);
			over = stateFactory.getBoardState('O', this, imagenes);
			start = stateFactory.getBoardState('S', this, imagenes);
			turno1 = stateFactory.getBoardState('U', this, imagenes);
			turno2 = stateFactory.getBoardState('D', this, imagenes);

					
			current = start; //inicia en el estado Start
			
			System.out.println(passWord);
		}
		
		
		public void paint(Graphics dgb) {
			current.paint(dgb);
		}

		public void keyPressed(int keyCode) {
			current.keyPressed(keyCode);
		}
		
		public void update() {
			current.update();
		}


		public void mouseClicked(MouseEvent e) {
			current.mouseClicked(e);
			
		}
	
		/*Setters y Getters*/
		public BoardState getStart(){
			return start;
		}
		
		public BoardState getOver(){
			return over;
		}
		
		public BoardState getTurno1(){
			return turno1;
		}
		
		public BoardState getTruno2(){
			return turno2;
		}
		
		public BoardState getLoad(){
			return load;
		}
		
		public void setState(BoardState s) {
			current = s;
		}
		
		public String getPassword(){
			return passWord;
		}
		


}
