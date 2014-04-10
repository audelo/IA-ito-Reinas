/**
 * @(#)Reinas.java
 *
 *
 * @author moloa.agustin
 * @version 1.00 2014/4/8
 */


public class Reinas{
    private int[] tab;
    private int num;
     int[][] tablero = new int[8][8];

    public Reinas(int num){
        tab=new int[num];
        this.num=num;
    }
    
  
   //metodo general de backtracking
    public boolean  Reinas(int n){
        int i=0;
        boolean fin=false;
        while(i<num && !fin){
            if(n<num)
            	tab[n]=i;//inicia con 0 y la guarda como posicion valida de la primer reina.
            if (!hayAtaque(n)){//verifica si la nueva posicion a tomar es valida
                if(n<num) {
                   	fin=Reinas(n+1);
                }
                else fin=true;
            }
            i++;
        }
        return fin;
    }

//metodo que verififica si no hay conflicto entre las reinas 
    public boolean hayAtaque(int i){
        boolean fin=false;
        if (i==0) {
        	fin=false;
        }
        else{
            i--;
            int n=i;
            int incremento=1;
            while (n>0) {//entra en un cilo a comprobar que las columnas no se repitan
                n--;
                if (tab[n]==tab[i] || tab[n]==tab[i]-incremento || tab[n]==tab[i]+incremento) 
                	fin=true;
                incremento++;
            }
        }
        return fin;
    }    
    	
   
   
   //metodo para mostrar la matriz con las reinas
   public void pintaTablero() {
          	
         for(int i=0; i<8; i++) {//se llena el tablero con el arreglo donde se guardaron
         						//las columnas de las posiciones de las reinas
         						
          	 	tablero[i][tab[i]]=i+1;
          	 
          	 }         	
          	
        for(int i=0; i<8; i++) {
        	
            for(int j=0; j<8; j++) { //se recorre el tablero para pintarlo
                             	System.out.printf("%2d|",tablero[i][j]);
            }
            System.out.println();
            for(int j=0; j<8; j++){
            	 System.out.print("---");}
            System.out.println();
        }
    }
     
      
    public static void main(String[] args) {
    Reinas p= new Reinas(8);//se crea un objeto de Reinas pasando como parametro el numero del orden de la matriz
	p.Reinas(0);//inicia reinas en la pos 0
    p.pintaTablero();//se pinta el tablero
    
    
    }
    
}