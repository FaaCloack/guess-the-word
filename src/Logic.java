import java.awt.event.KeyEvent;

/*En esta clase se tiene todas las operaciones de comparacion del input del 
 *usuario con la palabra elegida a ser adivinada. 
 * */

public class Logic{
	
	private static Logic instance = null;	//para el singleton
	
	private boolean correcto, ganador = false, letraInput, palabraInput;
	private String[] palabras;
	private String palabra, incorrectas, res, actual;
	private char[] charPalabra, respuesta, inputPalabra;
	private char inputLetra;
	private int resSize = 0, size = 0, selec = 2, cuentaPalabra = 0; 
	
	/*Utiliza el patron Singleton*/
	public static Logic getInstance() { 
		if(instance == null){
			instance = new Logic();
	     }
	     return instance;
	 }
	
	private Logic(){ 
		palabras = new String[7]; //crea un arreglo de Strings en donde se guardaran las palabras
		palabras[0]="null";
		palabras[1]="BOTELLA";
		palabras[2]="COMPUTADORA";
		palabras[3]="MAGO";
		palabras[4]="CELULAR";
		palabras[5]="ESCUELA";
		palabras[6]="ZAPATO";

		choosePalabra(); //selecciona la palabra al azar 
		correcto = true; 
		incorrectas = " "; //guarda las letras incorrectas
		charPalabra = palabra.toCharArray(); //pasa la palabra a un arreglo de caracteres para hacer operaciones
		size = palabra.length(); //calcula el tamaño
		respuesta = new char[size];//guardara los caracteres ingresados
		res = new String(respuesta);
		inputPalabra = new char[size];

	}
	
	
	public void choosePalabra(){
		int i = (int)Math.round(Math.random()*6+1); //selecciona la parabra al azar
		palabra = palabras[i];
	}

	
	public void keyPressed(char k){		
		correcto = true; //se inicia el turno como correcto
		
		if(k == KeyEvent.VK_RIGHT){ //selecciona el recuadro "palabra"
			selec = 1;
		}
		
		else if(k == KeyEvent.VK_LEFT){ //selecciona el recuadro  "letra"
			selec = 2;
		}
		
		else if(k == KeyEvent.VK_ENTER){
			
			if(letraInput == true){ //Se cierra el recuadro y hace la revision
				letraInput = false;
			/*Aquí se hace toda la revisión de si es correcta o no la letra*/
				
				correcto = false; //se inicia como falso y en caso de tener una coincidencia con el input se hace verdadero
				
				for (int i = 0; i<size; i++){
					if(inputLetra == respuesta[i]){ //si ya esta la letra no hace nada
						System.out.println("Esa letra ya esta");
						correcto = true;
					}

					else if (inputLetra == charPalabra[i]){
						correcto = true; //si la letra es correcta cambia valor a true e ingresa la letra a la respuesta
						respuesta[i]=inputLetra;
						resSize++;
					}
				}
				if (!correcto){
					incorrectas = incorrectas+inputLetra; //guarda la letra incorrecta en la cadena
				}
				
				res = new String(respuesta);

				if(size == resSize){ //si la palabra es igual activa ganador
					ganador = true;
				}
				
			}
			
			else if(palabraInput == true){ //Se cierra el recuadro y revisa
				int contador = 0;
				palabraInput = false;
				/*Aqui se revisa si es correcta o no la palabra*/
				for(int i = 0; i<size; i++){
					if(inputPalabra[i]!=charPalabra[i]){ //es incorrecto cuando se detecta una letra diferente
						correcto = false;
						break;
					}
					else{
						contador++; //el contador aumentara por cada letra que sea igual
					}
				}
				if(contador == size){ //si se tiene el contador igual es la palabra correcta
					ganador = true;
				}
			}
			
			else if(selec == 1){
				palabraInput = true;
				cuentaPalabra = 0;
				for(int i= 0; i<size; i++){ //se inician los valores a nulo
					inputPalabra[i]=' ';
				}
			}
			else if(selec == 2){
				inputLetra = ' ';
				letraInput = true;				
			}

		}
		
		else if(letraInput == true){
			if(k == KeyEvent.VK_BACK_SPACE){ //para borrar se cambia el valor a nulo
				inputLetra = ' ';
			}
			else{
				inputLetra = k;
			}
		}
		
		else if(palabraInput == true){			
			if(k == KeyEvent.VK_BACK_SPACE){ //para borrar se cambia el valor anterior a nulo 
				if(cuentaPalabra > 0){ //revisa que no sea posible borrar más de lo que existe
					inputPalabra[cuentaPalabra-1] = ' ';
					cuentaPalabra--; //vuelve a la casilla anterior
				}
			}
			else{
				if(cuentaPalabra<size){ //revisa que no exceda el tamaño de la palabra para seguir escribiendo
					inputPalabra[cuentaPalabra] = k;
					cuentaPalabra++;
				}
			}
		}
	}

	
	/*setters y getters*/
	public void setActual(String actual){
		this.actual = actual; 
	}
	
	public String getActual(){
		return actual;
	}
		
	public int getSize(){
		return size;
	}
	
	public char[] getInputPalabra(){
		return inputPalabra;
	}
	
	public char getInputLetra(){
		return inputLetra;
	}
	
	public boolean getLetraInput(){
		return letraInput;
	}
	
	public boolean getPalabraInput(){
		return palabraInput;
	}
	
	public String getRespuesta(){
		return res;
	}
	
	public void setRespuesta(String resp){
		res = resp;
	}
	
	public String getIncorrectas(){
		return incorrectas;
	}
	
	public void setIncorrectas(String in){
		incorrectas = in;
	}
	
	public boolean getGanador(){
		return ganador;
	}
	
	public int getSelec(){
		return selec;
	}
		
	public boolean getCorrecto(){
		return correcto;
	}
	
	public String getPalabra(){ 
		return palabra;
	}
	
	public void setPalabra(String password){
		palabra = password;
	}
	
}