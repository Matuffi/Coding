import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class kt_5_1_copy {
    public static void main(String[] args) throws FileNotFoundException{


        Scanner scan = new Scanner(new File("M:/Coding/Java/Moodle/Osa_nr5/andmebaas.txt"));

        String[][] raamat = new String[1][5];
        int lehekulgedeArv = 1;

        while(scan.hasNext()){
            String[][] ajutineRaamat = new String[lehekulgedeArv][raamat[lehekulgedeArv - 1].length + 1];

            for(int i = 0; i < raamat.length; i++){
                for(int j = 0; j < raamat[i].length; j++){
                    ajutineRaamat[i][j] = raamat[i][j];
                }  
            }
            ajutineRaamat[lehekulgedeArv - 1][ajutineRaamat[lehekulgedeArv - 1].length - 1] = scan.nextLine();

            if(ajutineRaamat[lehekulgedeArv - 1].length == 5){
                lehekulgedeArv++;

                raamat = new String[lehekulgedeArv + 1][ajutineRaamat[lehekulgedeArv - 1].length + 1];

                for(int m = 0; m < ajutineRaamat.length; m++){
                    for(int n = 0; n < ajutineRaamat[m].length; n++){
                        raamat[m][n] = ajutineRaamat[m][n];
                    }  
                }                
            }
            else{
                raamat = ajutineRaamat;
            }
        }

/*
        while(scan.hasNext()){
            String ajutineJarjend[] = new String[andmed.length + 1];
            for(int i = 0; i < andmed.length; i++){
                ajutineJarjend[i] = andmed[i];
            }
            ajutineJarjend[ajutineJarjend.length - 1] = scan.nextLine();
            andmed = ajutineJarjend;
        }

*/

        System.out.println("See andmekogu koosneb mängu Counter Strike Global Offensive'i mängijate taustast. Hoiame mängija nime, SteamID'd, tiimi nime, mängusisest auastet, võidetud mängude arvu, mängule kulutatud aega ning viimase mängusessiooni kuupäeva.");

        while(true){
            break;
        }
    }
}

/*

nimi#SteamId#TiimiNimi#Auaste#VõidetudMängudeArv#MängitudAegTundides#ViimatiMängis

String string = "004-034556";
String[] parts = string.split("-");
String part1 = parts[0]; // 004
String part2 = parts[1]; // 034556

*/
