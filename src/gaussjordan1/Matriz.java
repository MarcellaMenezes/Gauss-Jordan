package gaussjordan1;

/**
 *
 * @author marce
 */
public class Matriz {
    
    public static double[][] criaMatriz(int lin, int col) {

        double matriz[][] = new double[lin][col];//criando a matriz
        for (int i = 0; i < lin; i++) {
            for (int j = 0; j < col; j++) {
                matriz[i][j] = 0;
            }
        }
        return matriz;
    }

    public static void imprimeMatriz(double matriz[][], int lin, int col) {
        for (int i = 0; i < lin; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("  %.4f ", matriz[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static double[][] copiaMatriz(double matriz[][], int lin, int col){
        double matrizCopia[][] = criaMatriz(lin, col);
        for (int i = 0; i < lin; i++) {
            for (int j = 0; j < col; j++) {
                matrizCopia[i][j]=matriz[i][j];
            }
        }
        return matrizCopia;
    }

}

