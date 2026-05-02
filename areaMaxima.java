import java.util.*;
import java.io.*;
public class areaMaxima {
    public static void main(String[] args) throws IOException {
        
        record Tupla(int x, int y){}
        ArrayList<Tupla> coordenadas = new ArrayList<>();
        ArrayList<Tupla> grid = new ArrayList<>();
        int altura = 1, largura = 1;
         try {
            BufferedReader br = new BufferedReader(new FileReader("teste.txt"));
            String linha;

            linha = br.readLine();
            String partes[] = linha.split(" ");
            largura = Integer.parseInt(partes[0]);
            altura = Integer.parseInt(partes[1]);
            int qtdBomba = Integer.parseInt(partes[2]);   
            
            while ((linha = br.readLine()) != null) {
                String cord[] = linha.split(" ");
                int coordX = Integer.parseInt(cord[0]);
                int coordY = Integer.parseInt(cord[1]);
                Tupla t = new Tupla(coordX,coordY);
                coordenadas.add(t);            
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

        int gridX = largura / 10;
        int gridY = altura / 10;
/* 
        for (int i=1; i<=largura; i = i+gridX) {
            for (int j = 1; j <= altura; j= j+gridY) {
                 System.out.print("(" + i + "," + j + ") ");
            }
            System.out.println();
        } */

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {

                int xInicio = i * gridX;
                int xFim = (i + 1) * gridX;

                int yInicio = j * gridY;
                int yFim = (j + 1) * gridY;

                boolean temBomba = false;

                // verificar todas as bombas
                for (Tupla t : coordenadas) {
                    if (t.x >= xInicio && t.x < xFim &&
                        t.y >= yInicio && t.y < yFim) {
                        temBomba = true;
                        break;
                    }
                }

                // imprimir matriz
                if (temBomba) {
                    System.out.print("s ");
                } else {
                    System.out.print("n ");
                }
            }
            System.out.println();
        }
        

    }
}
