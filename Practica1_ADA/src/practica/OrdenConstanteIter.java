package practica;

public class OrdenConstanteIter extends Metodo{
	public OrdenConstanteIter() {
		super(Metodo.Orden.CTE);
	}
	@Override
	public int codigo(int n) {
		int aux = 0;
		return aux++;
	}
	

}
