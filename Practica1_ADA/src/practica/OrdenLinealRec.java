package practica;

public class OrdenLinealRec extends Metodo{
	public OrdenLinealRec() {
		super(Metodo.Orden.N);
	}
	@Override
	public int codigo(int n) {
		int aux = 0;
		
		if(n<=1) {
			aux++;
		}else {
			aux += codigo(n/2);
			aux += codigo(n/2); //T(n) = 2T(n/2) + 2 es de Orden N
		}
		
		return aux;
	}

}
