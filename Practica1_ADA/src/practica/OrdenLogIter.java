package practica;

public class OrdenLogIter extends Metodo{
	public OrdenLogIter () {
		super(Metodo.Orden.LOGN);
	}
	@Override
	public int codigo(int n) {
		int res = 0;
		int i = 0;
		while(i < n) {
			i*=2;
			res++;
		}
		return res;
	}
	

}
