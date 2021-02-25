import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class kt_5_1 {
    public static void main(String[] args) throws FileNotFoundException{


        Scanner file = new Scanner(new File("andmebaas.txt"));

        String[][] raamat = new String[1][5], ajutineRaamat;

        int a = 0;

        while(file.hasNext()){
            
            raamat[raamat.length - 1][a] = file.nextLine();
            a++;

            if(a == 5){
                a = 0;

                ajutineRaamat = new String[raamat.length + 1][5];

                for(int i = 0; i < raamat.length; i++){
                    for(int j = 0; j < 5; j++){
                        ajutineRaamat[i][j] = raamat[i][j];
                    }
                }
                raamat = ajutineRaamat;
            }
        }

        

        int lehekuljeIndeks = 0;
        Scanner scan = new Scanner(System.in);
        String kask;

        while(true){

            System.out.printf("\n\n\n\n\n\n\n\nSee andmekogu koosneb m2ngu Counter Strike Global Offensive'i m2ngijate taustast. Hoiame m2ngija nime, SteamID'd, tiimi nime, m2ngusisest auastet, v6idetud m2ngude arvu, m2ngule kulutatud aega ning viimase m2ngusessiooni kuup2eva.\n\nLehekylg %d/%d\n\n", lehekuljeIndeks + 1, raamat.length);

            for(int n = 0; n < 5; n++){

                if(raamat[lehekuljeIndeks][n] == null){
                    System.out.printf("%d.\n", lehekuljeIndeks * 5 + n + 1);
                }
                else{
                    Mangija man = new Mangija(raamat[lehekuljeIndeks][n]);

                    System.out.printf("%d. %s #%d ; Tiim - %s ; Auaste - %s ; On v6itnud %d m2ngu ; CS:GO'd on m2nginud %d tundi ; Viimati m2ngis %s\n", lehekuljeIndeks * 5 + n + 1, man.nimi, man.steamId, man.tiimiNimi, man.auaste, man.voidetudMangud, man.mangitudAeg, man.viimatiMangis);
                }
            }

            System.out.printf("\nJ2rgmine - \"J\" ; Eelmine - \"E\" ; V2lju - \"V\"\n");

            kask = scan.next();

            if(kask.toLowerCase().equals("j") && lehekuljeIndeks + 1 < raamat.length){
                lehekuljeIndeks++;
            }
            else if(kask.toLowerCase().equals("e") && lehekuljeIndeks > 0){
                lehekuljeIndeks--;
            }
            else if(kask.toLowerCase().equals("v")){
                break;
            }
        }

        scan.close();
        scan.close();
    }

    public static class Mangija {
        String nimi;
        int steamId;
        String tiimiNimi;
        String auaste;
        int voidetudMangud;
        int mangitudAeg;
        String viimatiMangis;

        public Mangija(){
        }

        public Mangija(String info){
            String[] infoArr = info.split("#");

            this.nimi = infoArr[0];
            this.steamId = Integer.valueOf(infoArr[1]);
            this.tiimiNimi = infoArr[2];
            this.auaste = infoArr[3];
            this.voidetudMangud = Integer.valueOf(infoArr[4]);
            this.mangitudAeg = Integer.valueOf(infoArr[5]);
            this.viimatiMangis = infoArr[6];
        }       
    }
}

/*

1. Juan sii - #6391038; Tiim - puudub; Global Elite; On v6itnud 531 m2ngu; CS:GO'd on m2nginud 600 tundi; Viimati m2ngis 25/02/2021

nimi#SteamId#TiimiNimi#Auaste#V6idetudM2ngudeArv#M2ngitudAegTundides#ViimatiM2ngis

String string = "004-034556";
String[] parts = string.split("-");
String part1 = parts[0]; // 004
String part2 = parts[1]; // 034556

*/
