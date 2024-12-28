import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	
	
	/**
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

	
	/**
	 * Devuelve la calidad de la solución indicada
	 */
	private int calidad(List<Posicion> sol) {
		//***Completar la implementación****
		return sol.size()-1;
	}

	public List<Posicion> encontrarCaminoMasCortoBB() {
    ColaPrioridad c = new ColaPrioridad(); // Creamos la estructura de datos

    List<Posicion> solInicial = new ArrayList<>();
    solInicial.add(entrada);
    Estado inicial = new Estado(solInicial, funcionCota(solInicial)); // Creamos el estado inicial

    c.insertar(inicial); // Insertamos el estado inicial en la cola

    List<Posicion> mejor = null; // Mejor solución encontrada hasta el momento
    int cotaMejor = Integer.MAX_VALUE; // Infinito

        while (!c.estaVacia()) {
            Estado e = c.extraer(); // Extraemos el estado más prometedor de la cola
            List<Posicion> sol = e.getSolucion();
    
            if (esCompleta(sol)) { // Comprobamos si la solución es completa
                if (calidad(sol) < cotaMejor) { // Comprobamos si es mejor que la mejor solución encontrada
                    mejor = sol;
                    cotaMejor = calidad(sol);
                }
            } else if (e.getCota() < cotaMejor) { // Comprobamos si la cota es mejor que la mejor solución encontrada
                // Generamos los posibles estados hijos
                for (int dir = 1; dir <= 4; dir++) {
                    Posicion candidata = siguiente(sol.get(sol.size() - 1), dir);
                    if (valida(candidata, sol)) {
                        List<Posicion> solHijo = new ArrayList<>(sol);
                        solHijo.add(candidata);
                        Estado hijo = new Estado(solHijo, funcionCota(solHijo));
                        c.insertar(hijo); // Insertamos el estado hijo en la cola
                    }
                }
            }
        }
    
        return mejor;
    }
    
    // Clase Estado para representar un estado en la cola de prioridad
    private class Estado implements Comparable<Estado> {
        private List<Posicion> solucion;
        private int cota;
    
        public Estado(List<Posicion> solucion, int cota) {
            this.solucion = solucion;
            this.cota = cota;
        }
    
        public List<Posicion> getSolucion() {
            return solucion;
        }
    
        public int getCota() {
            return cota;
        }
    
        @Override
        public int compareTo(Estado otro) {
            return Integer.compare(this.cota, otro.cota);
        }
    }
    
    // Clase ColaPrioridad para manejar la cola de prioridad
    private class ColaPrioridad {
        private List<Estado> cola = new ArrayList<>();
    
        public void insertar(Estado estado) {
            cola.add(estado);
            cola.sort(Comparator.naturalOrder());
        }
    
        public Estado extraer() {
            return cola.remove(0);
        }
    
        public boolean estaVacia() {
            return cola.isEmpty();
        }
    }
    private int funcionCota(List<Posicion> sol) {
        Posicion actual = sol.get(sol.size() - 1);
        int distanciaManhattan = Math.abs(actual.getX() - salida.getX()) + Math.abs(actual.getY() - salida.getY());
        return sol.size() - 1 + distanciaManhattan;
    }

}
