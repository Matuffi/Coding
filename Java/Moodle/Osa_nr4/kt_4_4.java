import java.util.Random;

public class kt_4_4 {
    public static void main(String[] args) {
        Random rand = new Random();
        
        // 2D matrix; rea aritmeetilise keskmise jada; Aritmeetiliste keskmiste vahehoidja; konverter double'iks, et saada komatäpsus; suurima väärtuse indeks vastuse jadas
        int[][] jada = new int[10][10];
        double[] vastus = new double[10];
        int keskmine;
        double keskDouble;
        int suurimIndeks = 0;

        // Iga rida
        for(int i = 0; i < 10; i++){
            keskmine = 0;
            keskDouble = 0;

            // Rea number
            System.out.printf("%2d. | ", i+1);

            // Iga väärtus reas
            for(int j = 0; j < 10; j++){
                // Genereerib; lisab aritmeetilise keskmise summasse ((a+b+...+i)/n); Numbri väljastamine
                jada[i][j] = rand.nextInt(100);
                keskmine += jada[i][j];
                System.out.printf("%2d ", jada[i][j]);
            }
            // Keskmine tuleb double'ks muuta, sest numbrid genereerisime int'iks, kuid aritmeetiline keskmine võib tulla komakohaga
            keskDouble = keskmine;
            // (a+b+...+i)/n kuna meil ühes reas on 10 numbrit, siis n on alati 10
            vastus[i] = keskDouble/10;
            // Väljastab vastuse
            System.out.printf("| %.1f\n", vastus[i]);

            // Kui selle rea aritmeetiline keskmine oli eelmistest ridadest suurem märgitakse selle rea indeks mällu
            // Kuid kahe sama aritmeetilise keskmise korral jääb suurimaks ees pool olev keskmine
            if(vastus[suurimIndeks] < vastus[i]){
                suurimIndeks = i;
            }
        }

        // Suurima keskmise indeksit kasutab
        System.out.printf("\nElementide suurim aritmeetiline keskmine on reas nr. %d", suurimIndeks+1);
    }
}

// 10. | 34 77 46 83 78 45  1 27 33 23 | 44.7
// Elementide suurim aritmeetiline keskmine on reas nr. 9