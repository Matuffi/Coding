/*

######  NB! kt_6_2_1.java loob nii "numbrid.txt" ja "pilet.txt" õige vormistusega.  ######

*/


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class kt_6_2 {

    static int piletiSuurus = 5;
    static int numbritePikkus = 40;

    // Võidutingimuste koordinaadid
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
        // Loeme failist mällu
        int[][] pilet = LoePilet();
        int[] numbrid = LoeNumbrid();

/*
        Nurkademäng: võitnud
        Diagonaalidemäng: ei võitnud
        Täismäng: ei võitnud
*/      

        // Kirjutab ekraanile erinevate mängude staatused. Kui mängu funktsioon on tõene jääb väljund algseks, kuid väärtuse väär korral lisab sõna "ei" väljundisse.
        System.out.printf("Nurkademäng: %svõitnud\n", Nurk(pilet, numbrid) ? "" : "ei ");
        System.out.printf("Diagonaalidemäng: %svõitnud\n", Diag(pilet, numbrid) ? "" : "ei ");
        System.out.printf("Täismäng: %svõitnud\n", Tais(pilet, numbrid) ? "" : "ei ");


    }

    // Loeb pileti failist ning teeb sellest matriksi, mille ta tagastab
    public static int[][] LoePilet() throws FileNotFoundException{
        Scanner piletF = new Scanner(new File("pilet.txt"));
        int[][] pilet = new int[piletiSuurus][piletiSuurus];
        int reaIndeks = 0;

        while(piletF.hasNextLine()){
            // Teeb ühe String rea arrayks eemaldades igasuguse tühja koha
            String[] rida = piletF.nextLine().trim().split("\\s+");

            // Kirjutab rea info matriksisse
            for(int i = 0; i < rida.length; i++){
                pilet[reaIndeks][i] = Integer.parseInt(rida[i]);
            }
            reaIndeks++;
        }

        return pilet;
    }

    // Loeb failist numbrid ning väljastab arvu hulga
    public static int[] LoeNumbrid() throws FileNotFoundException{
        Scanner numbridF = new Scanner(new File("numbrid.txt"));

        // Teeb Stringi arrayks ", " kohtadelt
        String[] rida = numbridF.nextLine().split(", ");
        int[] numbrid = new int[rida.length];

        for (int i = 0; i < rida.length; i++) {
            numbrid[i] = Integer.parseInt(rida[i]);
        }

        return numbrid;
    }

    // Nurgamängu kontroll
    public static boolean Nurk(int[][] pil, int[] num){
        boolean vastus = true;
        
        // Loeb alguses paika pandud koordinaadid pileti peal ning vaatab kas "numbrid.txt"'s' on selline arv olemas
        for(int i = 0; i < nurgad.length; i++){
            int x = nurgad[i][0];
            int y = nurgad[i][1];

            // Juhul kui arv puudub väljastab programm negatiivse vastuse
            if(!Contains(num, pil[x][y])){
                vastus = false;
                break;
            }
        }
        return vastus;
    }

    // Diagonaalidemängu kontroll
    public static boolean Diag(int[][] pil, int[] num) {
        boolean vastus = true;
        
        // Vaatab, kas nurkademäng oli edukas ning siis lisab omad koordinaadid kontrolliks
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

    // Agresiivselt kontrollib kõik pileti numbrid ära
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

    // Vaatab, kas number on ette antud arrays sees
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
