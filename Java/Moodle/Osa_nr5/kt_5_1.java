import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class kt_5_1 {
    public static void main(String[] args) throws FileNotFoundException{


        Scanner scan = new Scanner(new File("M:/Coding/Java/Moodle/Osa_nr5/andmebaas.txt"));

        String[][] raamat = new String[0][0];
        int lehekülgedeArv = 1;

        while(scan.hasNext()){
            String[][] ajutineRaamat = new String[lehekülgedeArv][raamat[lehekülgedeArv - 1].length + 1];

            for(int i = 0; i < raamat.length; i++){
                for(int j = 0; j < raamat[i].length; j++){
                    ajutineRaamat[i][j] = raamat[i][j];
                }  
            }
            ajutineRaamat[lehekülgedeArv - 1][ajutineRaamat[lehekülgedeArv - 1].length - 1] = scan.nextLine();
            raamat = ajutineRaamat;

            if(raamat[lehekülgedeArv - 1].length == 5){
                lehekülgedeArv++;
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
