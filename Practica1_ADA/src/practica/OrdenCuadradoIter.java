package practica;

public class OrdenCuadradoIter extends Metodo{
	public OrdenCuadradoIter() {
		super(Metodo.Orden.N2);
	}
	@Override
	public int codigo(int n) {
		int res = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				res++; //tenemos un coste de N2
			}
		}
		
		return res;
	}

}
