package gaussjordan1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author marce
 */
public class Arquivo {

    public static double[][] lerEGravarMatriz() {
        int qntdLinha = 0, qntdColuna = 0, lin = 0, col = 0;

        try {
            FileReader arq = new FileReader("matriz.txt");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            String[] split = linha.split(";");
            qntdLinha=Integer.parseInt(split[0]);
            qntdColuna = Integer.parseInt(split[1]);//Pegando a quantidade de vertices
           
            double matriz[][] = Matriz.criaMatriz(qntdLinha, qntdColuna);

            linha = lerArq.readLine();
            for(int i=0;linha != null;i++) {
                for(int j=0;j<qntdColuna; j++){
                    split = linha.split(";");
                    matriz[i][j]=Double.parseDouble(split[j]);
                }
                linha = lerArq.readLine();
            }
            arq.close();
            return matriz;
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
            return null;
        }
    }
    
}
