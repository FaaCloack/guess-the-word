import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player {
	public String nombre; 
	public BufferedImage[] imagen;
	public int avatar = 1;
	
	public void setAvatar(int avatar){
		this.avatar = avatar;
	}
	
	public Player(BufferedImage[] imagenes){ //almacena imagen y nombre
		this.imagen = imagenes;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void paintJugador(Graphics dbg){
		dbg.setColor(Color.black);
		dbg.setFont(new Font("Arial", Font.PLAIN, 20)); 
		dbg.drawString("Turno de:", 150, 520);
		dbg.drawString(nombre, 150, 550); //dibuja el jugador en turno
		dbg.drawImage(imagen[avatar], 50, 480, null);
	
	}

}
