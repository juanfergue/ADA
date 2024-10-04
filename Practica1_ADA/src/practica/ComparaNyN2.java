package practica;

public class ComparaNyN2 {
	public static void main(String[] a) {
		int [] tam = {1, 5, 10, 50, 100, 500, 1000};
		//long [] tiempoN = Complejidad.medirTiempos(new OrdenLinealRec(), tam);
		//long [] tiempoN2 = Complejidad.medirTiempos(new OrdenCuadradoIter(), tam);
		long [] tiempoN = Complejidad.medirTiemposRobusto(new OrdenLinealRec(), tam, 10); // este metodo hace lo mismo que el de antes pero lo repite el num de veces que queremos y con eso coje los tiempos mas bajos
		long [] tiempoN2 = Complejidad.medirTiemposRobusto(new OrdenCuadradoIter(), tam, 10);
		
		System.out.println("Tamaño de entrada \t TiemposN \t TiemposN2");
		for(int i = 0 ; i < tam.length; i++) {
			System.out.println(tam[i] + "\t\t\t " + tiempoN[i] + "\t\t" + tiempoN2[i]);
		}
	}
}	
