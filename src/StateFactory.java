import java.awt.image.BufferedImage;

public class StateFactory {

	public BoardState getBoardState(char selection, Board manager, BufferedImage[] imagenes){		

		switch(selection){ //dependiendo de la seleccion crea el nuevo estado
			case 'D':
				return new BoardTurn2(manager, imagenes);
				
			case 'U':
				return new BoardTurn1(manager, imagenes);
				
			case 'O':					
				return new BoardOver(manager);

			case 'S':
				return new BoardStart(manager);
			
			case 'L':
				return new BoardLoad(manager, imagenes);
			default:
				return null;
		
		}

	}

}
