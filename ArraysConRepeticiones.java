public class ArraysConRepeticiones {

	//Precondición: hay un elemento repetido=> v.length >= 2
	public static int encuentraElem(int [] v) {
		return encuentraElem(v,0,v.length-1);
	}
	
	private static int encuentraElem(int [] v, int izq, int der) {
		int res = 0; 
		
        if(der-izq == 1){
            res = v[izq];
        }else{
            int medio = (der + izq)/2;
		    int prim = v[izq];
            if(medio-izq == v[medio]-prim){//comprobamos que concuerde la coordenada con el numero ya que estan ordenados
               if(medio+1 <= der && v[medio] == v[medio+1]){
                   res = v[medio];
               }else{
    	           res = encuentraElem(v, medio+1, der);
    	       }
    	    }else{
    	        if(medio-1 >= izq && v[medio] == v[medio-1]){
    	            res = v[medio];
    	        }else{
    	            res = encuentraElem(v, izq, medio-1);
    	        }
    	    }
		}
	    
		
	    return res;
	}
	
}
