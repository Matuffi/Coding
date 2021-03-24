import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;

public class kt_6_2_1 {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("pilet.txt");
        PrintWriter writer = new PrintWriter(fos);
        Random rnd = new Random();

        final int suurus = 5;
        int[] numbriList = new int[suurus * suurus];
        int piletiJarg = 0;
        // debug - int[][] piletiNumbrid = new int[suurus][suurus];

        int[] numbrid = new int[40];

        for(int i = 0; i < suurus; i++){
            for(int j = 0; j < suurus; j++){
                int num;
                do{
                    num = rnd.nextInt(15) + 1 + 15 * j;
                } while(Contains(numbriList, num));
                numbriList[piletiJarg] = num;
                piletiJarg++;
                // debug - piletiNumbrid[i][j] = num;
                writer.printf("%3d", num);
            }
            writer.println();
        }
        writer.close();

        fos = new FileOutputStream("numbrid.txt");
        writer = new PrintWriter(fos);

        for(int i = 0; i < numbrid.length; i++){
            int num;
                do{
                    num = rnd.nextInt(75) + 1;
                } while(Contains(numbrid, num));
                numbrid[i] = num;
                writer.printf("%d", num);
                if(i != 39){
                    writer.printf(", ");
                }
        }

        writer.close();
    }

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
