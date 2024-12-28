import java.util.ArrayList;
import java.util.List;

public class Laberinto {
	private int[][] laberinto;
	private Posicion entrada, salida;
	private int n; // número de filas y columnas

	public Laberinto(int[][] lab, Posicion ent, Posicion sal) {
		this.laberinto = lab;
		this.entrada = ent;
		this.salida = sal;
		this.n = lab.length;
	}

	public int getNumFilas() {
		return n;
	}

	public int getNumCols() {
		return n;
	}
	
	public int [][] getLaberinto(){
		return laberinto;
	}
	public Posicion getEntrada() {
		return entrada;
	}
	public Posicion getSalida() {
		return salida;
	}
	
	public List<Posicion> encontrarCamino() {
		List<Posicion> lista = new ArrayList<Posicion>();
		lista.add(entrada);
		return (encontrarCamino(lista)) ? lista : null;
	}

	/**
	 * Algoritmo de Vuelta Atrás para encontrar un camino que nos permita
	 * salir del laberinto
	 */
	private boolean encontrarCamino(List<Posicion> sol) {
		boolean encontrado = false;
	    // Obtener la última posición añadida a la solución
	    Posicion actual = sol.get(sol.size() - 1);

	    // Comprobar si hemos llegado a la salida
	    if (esCompleta(sol) == true) {
	        return true;
	    }

	   
	    for (int dir = 1; dir <= 4; dir++) { // Intentar moverse en las cuatro direcciones: Norte, Sur, Este, Oeste
	        Posicion siguientePos = siguiente(actual, dir);
	        
	        
	        if (valida(siguientePos, sol)) {
	            sol.add(siguientePos);  
	            
	            // Llamada recursiva para continuar buscando desde la nueva posición
	            if (encontrarCamino(sol)) {
	                return true;  // Si encontramos un camino, retornar true
	            }
	            
	            sol.remove(sol.size() - 1);  // Retroceder si no se encontró un camino
	        }
	    }
	    
	    return false;  
	}
	/**
	 * Comprueba si una solución es completa.
	 */
	private boolean esCompleta(List<Posicion> sol) {
		//***Completar la implementación****
		boolean completa  = false;
		if(sol.get(sol.size()-1).equals(salida)) {
			completa = true;
		}
		
		return completa;
	}

	/**
	 * Comprueba que la posición dada es una candidata válida para el siguiente paso
	 */
	private boolean valida(Posicion candidata, List<Posicion> sol) {
		//***Completar la implementación****
		boolean val = false;
		if(!esMuro(candidata) && estaEnLaberinto(candidata) && !sol.contains(candidata)) {
			val = true;
		}
		return val;
		
	}

	/**
	 * Devuelve true si en la posición p hay un muro
	 */
	private boolean esMuro(Posicion p) {
		//***Completar la implementación****
		boolean  muro = false;
		if(estaEnLaberinto(p)){
		   if(laberinto[p.getX()][p.getY()] == -1) {
			    muro = true;
		   } 
		}
		
		
		return muro;
	}

	/**
	 * Devuelve true si la posición dada está dentro del laberinto.
	 */
	private boolean estaEnLaberinto(Posicion pos) {
		//***Completar la implementación****
		boolean dentro = false;
		if( 0 <= pos.getX() && pos.getX() < n && 0 <= pos.getY() && pos.getY() < n) {
			dentro = true;
		}
		
		return dentro;
	}

	/**
	 * Dada una posición cartesiana devuelve la siguiente posición en el sentido
	 * indicado. Precondición: actual != null
	 * 
	 * @param actual Posición de partida
	 * @param dir    Sentido en el que hay que desplazarse (1->Norte, 2->Sur,
	 *               3->Este, 4-> Oeste)
	 * @return La nueva posición.
	 */
	private Posicion siguiente(Posicion actual, int dir) {
		int x = actual.getX();
		int y = actual.getY();
		if (dir == 1) {
			x--;
		} else if (dir == 2) {
			x++;
		} else if (dir == 3) {
			y++;
		} else {
			y--;
		}
		return new Posicion(x, y);
	}

}