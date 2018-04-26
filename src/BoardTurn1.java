import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class BoardTurn1 implements BoardState{
	private Board manager;
	private BufferedImage[] images;
	private Player jugador1;
	
	public BoardTurn1(Board manager, BufferedImage[] images){		
		this.images = images;
		this.manager = manager;
		jugador1 = new Player(images);
		jugador1.setNombre("Jugador 1");
		jugador1.setAvatar(1);
	}
	
	public void update() {//si hay un ganador entonces va al estado final
		if(Logic.getInstance().getGanador()){
			Logic.getInstance().setActual(jugador1.getNombre()); //asigna el nombre a la variable actual
			over();
		}
	}

	public void keyPressed(int k) {
		Logic.getInstance().keyPressed((char)k);
		boolean correcto = true;
		correcto = Logic.getInstance().getCorrecto(); //cada que ingresa una letra revisa si fue correcta
		if(!correcto){
			System.out.println("cambio de turno");
			turno2();
		}
		
	}
	
	public void mouseClicked(MouseEvent e) {
			
	}
	

	public void paint(Graphics dbg) {
		dbg.drawImage(images[0], 0, 0, null);//dibuja el fondo
		dbg.setColor(Color.black);
		dbg.setFont(new Font("Century Gothic", Font.PLAIN, 50)); 
		dbg.drawString(Logic.getInstance().getRespuesta(), 200, 245); //dibuja la respuesta, las letras adivinadas
		dbg.setFont(new Font("Impact", Font.PLAIN, 25)); 
		dbg.drawString("Incorrectas: " + Logic.getInstance().getIncorrectas(), 130, 100); //dibuja el String de palabras incorrectas
		dbg.setFont(new Font("Impact", Font.PLAIN, 40)); 
		
		/*Para dibujar la seleccion palabra o letra*/
		
		if(Logic.getInstance().getSelec() == 1){ 
			dbg.setColor(Color.yellow); //si se selecciona, cambia el color a amarillo
		}
		dbg.drawString("PALABRA", 600, 550);
		dbg.setColor(Color.black);		
		if(Logic.getInstance().getSelec() == 2){
			dbg.setColor(Color.yellow);
		}
		dbg.drawString("LETRA", 360, 550);
		
		/*Para dibujar Recuadro de Letra*/
		if(Logic.getInstance().getLetraInput() == true){
			dbg.setColor(Color.black);
			dbg.fillRect(220, 120, 360, 260);
			dbg.setColor(Color.white);
			dbg.fillRect(225, 125, 350, 250);
			dbg.setColor(Color.black);
			dbg.setFont(new Font("Impact", Font.PLAIN, 25)); 
			dbg.drawString("Ingresa la letra", 250, 190);
			dbg.drawString("Tu letra es: " + " " + Logic.getInstance().getInputLetra(), 250, 240);	
			dbg.drawString("Presiona ENTER", 250, 290);
		}
		
		/*Para dibujar Recuadro de Palabra*/
		if(Logic.getInstance().getPalabraInput() == true){
			dbg.setColor(Color.black);
			dbg.fillRect(220, 120, 360, 260);
			dbg.setColor(Color.white);
			dbg.fillRect(225, 125, 350, 250);
			dbg.setColor(Color.black);
			dbg.setFont(new Font("Impact", Font.PLAIN, 25)); 
			dbg.drawString("Ingresa la palabra", 250, 190);
			dbg.drawString("Tu palabra es: ", 250, 240);
			dbg.drawChars(Logic.getInstance().getInputPalabra(), 0, Logic.getInstance().getSize(), 400, 240);	
			dbg.drawString("Presiona ENTER", 250, 290);
		}
		
		jugador1.paintJugador(dbg);
	}
	
	
	
	/*Metodos de Estados*/
	
	public void start() {
		
	}

	public void over() {
		manager.setState(manager.getOver());
		
	}

	public void turno1() {
		
	}
	
	public void turno2() {
		manager.setState(manager.getTruno2());
	}

	public void load() {
		
	}



}
