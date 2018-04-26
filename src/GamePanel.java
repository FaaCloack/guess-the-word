import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class GamePanel extends JPanel implements Runnable, KeyListener, MouseListener{
	private static final long serialVersionUID = 1L;
	private static final int PWIDTH = 800;
	private static final int PHEIGHT = 600;
	private Thread animator;
	private Board manager;
	private boolean running = false;
	private Graphics dbg;
	private Image dbImage;
	
	public GamePanel(){
		setBackground(Color.white);
		setPreferredSize(new Dimension(PWIDTH, PHEIGHT));
		setFocusable(true);
		manager = new Board();
		addKeyListener(this);
		addMouseListener(this);
	}
	
	public void addNotify(){
		super.addNotify();
		start();
	}
	
	public void start(){
		if (animator == null || !running){
			animator = new Thread(this);      
			animator.start();    
		} 
	}
	
	public void stop(){
		running = false;
	}
	
	public void run() {
		running = true;
		 
		while(running){
			update();
			render();
			paintScreen();
			
			try{
				Thread.sleep(70); //se deja a una velocidad no muy rapida
			}
			catch(InterruptedException ex){}
		}
		System.exit(0);
	}
	
	public void update(){
		manager.update();
	}
	
	public void render(){
		if(dbImage == null){ //doble buffer, si no hay imagen crea una
			dbImage = createImage(PWIDTH, PHEIGHT);
			if(dbImage == null){
				System.out.println("dbImage is null");
				return;
			}else{
				dbg = dbImage.getGraphics(); 
			}
			dbg.setColor(Color.black);  
			dbg.fillRect (0, 0, PWIDTH, PHEIGHT); 
		}
		manager.paint(dbg);
	}
	
	public void paintComponent(Graphics g){  
		super.paintComponent(g);  
		if (dbImage != null)    
			g.drawImage(dbImage, 0, 0, null); //pinta la imagen
	} 
	
	public void paintScreen(){
		Graphics g;  
		try{    
			g = this.getGraphics();  // obtiene los graficos  
			if ((g != null) && (dbImage != null))      
				g.drawImage(dbImage, 0, 0, null);    
			Toolkit.getDefaultToolkit().sync();  // sincroniza display   
			g.dispose();  
			}catch (Exception e){ 
				System.out.println("Graphics context error: " + e);  
			} 	
	}
	/*Metodos de teclas y mouse*/
	public void keyPressed(KeyEvent e) {
		manager.keyPressed(e.getKeyCode()); //manda a llamar a los metodos del estado en el contexto
	}

	public void keyReleased(KeyEvent arg0) {
		
	}

	public void keyTyped(KeyEvent arg0) {
	
	}

	public void mouseClicked(MouseEvent e) {
		manager.mouseClicked(e);
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseReleased(MouseEvent e) {
		
	}
	
	/*Main del Juego*/
	public static void main(String[] args){
		JFrame principal = new JFrame("Guess It!");
		principal.setContentPane(new GamePanel());
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		principal.setVisible(true);
		principal.setLayout(new BorderLayout());
		principal.setResizable(true);	
		principal.pack();	
		principal.setLocationRelativeTo(null);
	}

}

