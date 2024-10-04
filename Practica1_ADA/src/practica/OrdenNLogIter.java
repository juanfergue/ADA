package practica;

public class OrdenNLogIter extends Metodo{
	public OrdenNLogIter() {
		super(Metodo.Orden.NLOGN);
	}
	@Override
	public int codigo(int n) {
		int aux = 0;
		int j = 0;
		for(int i = 0; i < n; i++) {
			
			while(j<n) {
				j*=2;
				aux++;
			}
		}
		return aux;
	}
	

}
