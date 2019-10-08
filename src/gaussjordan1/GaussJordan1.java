/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaussjordan1;

/**
 *
 * @author marce
 */
public class GaussJordan1 {
  
    public static Boolean garantePivosNaoNullos(double matriz[][], int qntdLinha, int qntdColuna){
        int tamVet= qntdColuna;
        double auxVet[]= new double[tamVet];
        int troqueiLinha[] = new int[tamVet];
        boolean trocou=false;
 
        for(int k=0; k<qntdLinha; k++)
            if(matriz[k][k]==0){
                trocou=false;
                for(int i=0; i<qntdLinha; i++){
                    if(i!=k &&matriz[i][k]!=0 && troqueiLinha[i]==0){
                        troqueiLinha[k]=1; //para não alterarem a linha já trocada
                        for(int j=0; j<qntdColuna; j++){
                            auxVet[j]=matriz[k][j]; //pegando a linha problemática
                            matriz[k][j]=matriz[i][j];//pegando a linha solucao
                            matriz[i][j]=auxVet[j]; //linha solucao recebendo a problemática  
                        }
                        i=qntdLinha;//se já trocou com essa linha, n precisa procurar outra
                        trocou=true;
                    }
                }
            }
        return trocou;
    }
    
    public static double[][] garantePivosComValorUm(double matriz[][],int qntdLinha, int qntdColuna){
        double dividendo=1;
        for(int k=0; k<qntdLinha; k++)
            if(matriz[k][k]!=1){
                dividendo = matriz[k][k];
                for(int j=0; j<qntdColuna; j++){
                    if(matriz[k][j]/dividendo == -0) matriz[k][j]=0;
                    else matriz[k][j]=matriz[k][j]/dividendo; //linha solucao recebendo a problemática  
                } 
            }
            return matriz;
    }
    
    public static double[][] metodoGaussJordan(double matriz[][],int qntdLinha, int qntdColuna){ 
        for(int k=0; k<qntdLinha; k++){
             double matrizResultado[][] = Matriz.copiaMatriz(matriz, qntdLinha, qntdColuna);
                for(int i=0; i<qntdLinha; i++)
                    if(i!=k && matriz[i][k]!=0){  
                        for(int j=0; j<qntdColuna; j++){     
                            matrizResultado[i][j]= ((matriz[i][k]*matriz[k][j])*-1)+matriz[i][j];;//Li = - pivoColuna*Lpivo+Li
                        }     
                    }  
            System.out.println("Interacao "+k+"");
            Matriz.imprimeMatriz(matrizResultado, qntdLinha, qntdColuna);
            matriz=Matriz.copiaMatriz(matrizResultado, qntdLinha, qntdColuna);
            matriz=garantePivosComValorUm(matriz, qntdLinha, qntdColuna); // se o pivô chegar a mudar o valor...
        }
        return matriz;
    }
    
    public static void main(String[] args) {
        double matriz[][]=Arquivo.lerEGravarMatriz();
        int qndtColuna=matriz[0].length, qndtLinha=matriz.length;
        System.out.println("Matriz Inicial");
        Matriz.imprimeMatriz(matriz, qndtLinha, qndtColuna);
        
        System.out.println("\nMatriz Reorganizada");
        GaussJordan1.garantePivosNaoNullos(matriz, qndtLinha, qndtColuna);
        Matriz.imprimeMatriz(matriz, qndtLinha, qndtColuna);
        
        System.out.println("Matriz com pivôs valor 1");
        GaussJordan1.garantePivosComValorUm(matriz, qndtLinha, qndtColuna);
        Matriz.imprimeMatriz(matriz, qndtLinha, qndtColuna);

        System.out.println("********Gauss Jordan*********\n");
        GaussJordan1.metodoGaussJordan(matriz, qndtLinha, qndtColuna);
        
        
    }
    
}
