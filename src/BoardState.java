import java.awt.Graphics;
import java.awt.event.MouseEvent;

public interface BoardState{
	public void paint(Graphics dbg);
	public void update();
	public void keyPressed(int k);
	public void start();
	public void over();
	public void turno1();
	public void turno2();
	public void load();
	public void mouseClicked(MouseEvent e);
}
