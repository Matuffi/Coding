import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class kt_6_2 {

    static int piletiSuurus = 5;
    static int numbritePikkus = 40;

    static int[][] nurgad = {
        {0,0},
        {0,4},
        {4,0},
        {4,4}
    };
    static int[][] ristid = {
        {1,1},
        {1,3},
        {2,2},
        {3,1},
        {3,3}
    };

    
    public static void main(String[] args) throws FileNotFoundException{
        int[][] pilet = LoePilet();
        int[] numbrid = LoeNumbrid();
        String voit;

/*
        Nurkademäng: võitnud
        Diagonaalidemäng: ei võitnud
        Täismäng: ei võitnud
*/
        voit = Nurk(pilet, numbrid) ? "" : "ei ";
        System.out.printf("Nurkademäng: %svõitnud\n", voit);

        voit = Rist(pilet, numbrid) ? "" : "ei ";
        System.out.printf("Diagonaalidemäng: %svõitnud\n", voit);

        voit = Tais(pilet, numbrid) ? "" : "ei ";
        System.out.printf("Täismäng: %svõitnud\n", voit);


    }

    public static int[][] LoePilet() throws FileNotFoundException{
        Scanner piletF = new Scanner(new File("pilet.txt"));
        int[][] pilet = new int[piletiSuurus][piletiSuurus];
        int reaIndeks = 0;

        while(piletF.hasNextLine()){
            String[] rida = piletF.nextLine().trim().split("\\s+");

            for(int i = 0; i < rida.length; i++){
                pilet[reaIndeks][i] = Integer.parseInt(rida[i]);
            }
            reaIndeks++;
        }

        return pilet;
    }

    public static int[] LoeNumbrid() throws FileNotFoundException{
        Scanner numbridF = new Scanner(new File("numbrid.txt"));
        String[] rida = numbridF.nextLine().split(", ");
        int[] numbrid = new int[rida.length];

        for (int i = 0; i < rida.length; i++) {
            numbrid[i] = Integer.parseInt(rida[i]);
        }

        return numbrid;
    }

    public static boolean Nurk(int[][] pil, int[] num){
        boolean vastus = true;
        
        for(int i = 0; i < nurgad.length; i++){
            int x = nurgad[i][0];
            int y = nurgad[i][1];

            if(!Contains(num, pil[x][y])){
                vastus = false;
                break;
            }
        }
        return vastus;
    }

    public static boolean Rist(int[][] pil, int[] num) {
        boolean vastus = true;
        
        if(Nurk(pil, num)){
            for(int i = 0; i < ristid.length; i++){
                int x = ristid[i][0];
                int y = ristid[i][1];
    
                if(!Contains(num, pil[x][y])){
                    vastus = false;
                    break;
                }
            }
        }
        else{
            vastus = false;
        }
        return vastus;
    }

    public static boolean Tais(int[][] pil, int[] num) {
        boolean vastus = true;

        outerloop:
        for (int i = 0; i < pil.length; i++) {
            for (int j = 0; j < pil[i].length; j++) {
                if(!Contains(num, pil[i][j])){
                    vastus = false;
                    break outerloop;
                }
            }
        }

        return vastus;
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
