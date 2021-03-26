import java.util.Random;

public class kt_6_1 {

    static int[][][] matriksid = new int[3][4][4];
    static int[][] suurimMatriks;
    static Random rand = new Random();

    public static void main(String[] args) {
        
        // Loob matriksid ja väljastab need
        LooMatriksiJada();
        for(int i = 0; i < matriksid.length; i++){
            System.out.printf("%d. matriks\n\n", i + 1);
            ValjastaMatriks(matriksid[i]);
        }

        suurimMatriks = matriksid[0];

        // Leiab suurima summaga matriksi
        for(int i = 0; i < matriksid.length - 1; i++){
            suurimMatriks = SuuremMatriks(matriksid[i], matriksid[i+1]);
        }

        // Vastus
        System.out.printf("\nSuurim matriks elementide summa pooolest on: \n\n");
        ValjastaMatriks(suurimMatriks);

    }

    // Loob matriksid avalikku muutujasse, kus iga arv on suvaline arv 0 - 100
    static void LooMatriksiJada(){
        for(int m = 0; m < matriksid.length; m++){
            for(int i = 0; i < matriksid[m].length; i++){
                for(int j = 0; j < matriksid[m][i].length; j++){
                    matriksid[m][i][j] = rand.nextInt(101);
                }
            }
        }
    }

    // Saab matriksi ning kuvab selle ekraanile
    static void ValjastaMatriks(int[][] n){
        for(int i = 0; i < n.length; i++){
            for(int j = 0; j < n[i].length; j++){
                System.out.printf("%4d", n[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // Saab kaks matriksit ning liidab elemendid kokku. Tagastab suurema matriksi
    static int[][] SuuremMatriks(int[][] a, int[][] b){
        int aSum = 0;
        int bSum = 0;

        for(int k = 0; k < matriksid[0].length; k++){
            for(int l = 0; l < matriksid[0][k].length; l++){
                aSum += a[k][l];
                bSum += b[k][l];
            }
        }

        if(aSum >= bSum){
            return a;
        }
        else{
            return b;
        }
    }
}
