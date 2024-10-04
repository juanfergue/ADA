package practica;

import java.util.Random;

public class DosCasos extends Metodo{
	public DosCasos() {
		super(Metodo.Orden.CTE, Metodo.Orden.N); //Invoca al constructor de la clase principal (Metodo)
	}
	@Override
	public int codigo(int n) { 
		int aux = 0;
		Random r = new Random();
		if(r.nextBoolean()) { //si boolean sale true entra en el if con coste 1 sino en el else coste N
			aux++;
		}else { //else es el coste lineal 
			for(int i = 0; i < n; i++) {
				aux++; //ya que el coste va a depender de n cuanto mayor n mayor aux
			}
		}
		return aux;
	}
	
}
