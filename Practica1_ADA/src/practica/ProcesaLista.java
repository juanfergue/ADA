package practica;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ProcesaLista extends Metodo{
	private List<Integer> lista;
	
	public ProcesaLista() {
		super();
		lista = null;
		
	}
	public void setLista(List<Integer> l) {
		lista = l;
	}
		
	public List<Integer> getLista() {
		return lista;
	}
	
	/**
	 * Procesamos todos los elementos de la lista lista.
	 * return El número de elementos procesados en realidad.
	 */
	@Override
	public int codigo(int n) {
		procesaLista(lista);
		return n>lista.size()?n:lista.size();
	}
	
	private void procesaLista(List<Integer> lista) {
		//Completar la implementación del método
		//tiene que ser de orden N
		for(int i = 1; i < lista.size() ; i++) {
			if(lista.get(i).equals(lista.get(i-1))) {
				//lista.remove(i); //tenemos que ver el tamaño de remove para saber que no se pasa de orden N (remove tiene orden N no se puede usar)
				hay que usar add con una lista auxiliar
			}
		}
	}
	

}
