
/*

######   See programm on kt_6_2.java alamprogramm, mis loob programmi tööks vajalikud andmebaasid suvaliste arvudega korrektse vormistusega.    ######

*/


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;

public class kt_6_2_1 {
    public static void main(String[] args) throws FileNotFoundException {
        
        // Kasutatud numbrite list
        final int suurus = 5;
        int[] numbriList = new int[suurus * suurus];
        // Palju numbreid on olemas
        int numbriJarg = 0;
        // debug - int[][] piletiNumbrid = new int[suurus][suurus];

        // Loto numbrite array
        int[] numbrid = new int[40];


        // ###### PILETI LOOMINE ######
        FileOutputStream fos = new FileOutputStream("pilet.txt");
        PrintWriter writer = new PrintWriter(fos);
        Random rnd = new Random();

        // Loob matriksisse numbrid ning kirjutab faili
        for(int i = 0; i < suurus; i++){
            for(int j = 0; j < suurus; j++){
                int num;
                // 1. Loob uue suvalise numbri arvestades, mis reas number asub
                // 2. Kontrollib, kas number on eelnevalt kasutatud | Jah - Loob uue numbri; Ei - Läheb koodiga edasi
                // 3. Kirjutab numbri faili
                do{
                    num = rnd.nextInt(15) + 1 + 15 * j;
                } while(Contains(numbriList, num));

                numbriList[numbriJarg] = num;
                numbriJarg++;
                // debug - piletiNumbrid[i][j] = num;
                writer.printf("%3d", num);
            }

            writer.println();
        }
        writer.close();

        // ###### NUMBRITE LOOMINE ######
        fos = new FileOutputStream("numbrid.txt");
        writer = new PrintWriter(fos);

        for(int i = 0; i < numbrid.length; i++){
            int num;
            // 1. Loob uue suvalise numbri
            // 2. Kontrollib, kas number on eelnevalt kasutatud | Jah - Loob uue numbri; Ei - Läheb koodiga edasi
            // 3. Kirjutab numbri faili
            do{
                num = rnd.nextInt(75) + 1;
            } while(Contains(numbrid, num));

            numbrid[i] = num;
            writer.printf("%d", num);
            // Et ta viimase numbri taha ei kirjutaks ", "
            if(i != numbrid.length - 1){
                writer.printf(", ");
            }
        }

        writer.close();
    }

    // Kontrollib, kas number on mingis arrays sees
    public static boolean Contains(int[] array, int num){
        boolean result = false;

        for(int i:array){
            if(num == i){
                result = true;
                break;
            }
        }
        return result;
    }
}
