import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class kt_5_1 {
    public static void main(String[] args) throws FileNotFoundException{

        /*
            NB!  *need on hilisemad märkused*

            Oleksin võinud kasutada mingisugust objekti array'd nagu "Mangija[]", kuhu salvestan iga rea andmebaasist. 
            Väljastuseks oleksin sellisel jugul kasutada saanud for loopi, mille tulemusel tuleks Mangija[] indesid alates 'leheküljeIndeks*5 - 5' kuni 'leheküljeIndeks*5'.
            
            Kirjutamise hetkel aga unustasin objekti kasutuse ära ning mõtlesin, et selline lahendus on ka huvitav, kasutades 2D arrayd kataloogina.
             Seepärast näeb hetkene objektide kasutus imelik välja.

        */

        // Avab faili ning loob kaks array'd. Array iseloomustab raamatut Array[{Lehekülg}][{Lehel olev rida}]. Loob muutuja a, mis loeb lehekülgede arvu.
        Scanner file = new Scanner(new File("andmebaas.txt"));
        String[][] raamat = new String[1][5], ajutineRaamat;
        int a = 0;

        // LeheküljeIndeks näitab hetkel kuvatavat lehekülge. Loome ka kasutaja sisendivoo ning selle jaoks ka muutuja
        int lehekuljeIndeks = 0;
        Scanner scan = new Scanner(System.in);
        String kask;

        // Kui failis on veel teksti
        while(file.hasNext()){
            
            // Kirjutab raamatu array viimasele lehele viimasele reale failist rea ning suurendab ridade muutujat
            raamat[raamat.length - 1][a] = file.nextLine();
            a++;

            // Kui ridu on viis ehk üks lehekülg on täis
            // Järgmine loogika võimaldab lisada kuipalju tahes lehekülgi
            if(a == 5){
                a = 0;

                // Teeb ajutise raamatu array, mis on päris raamatust lehekülje võrra suurem
                ajutineRaamat = new String[raamat.length + 1][5];

                // Tõstab päris raamatust iga lehekülje info ajutisse
                for(int i = 0; i < raamat.length; i++){
                    for(int j = 0; j < 5; j++){
                        ajutineRaamat[i][j] = raamat[i][j];
                    }
                }

                // Asendab päris raamatu ajutisega
                // Tulemuseks tegi raamatule 1 lehekülje juurde
                raamat = ajutineRaamat;
            }
        }

        
        // Kasutaja võib lõpmata kaua lehekülgi vahetada
        while(true){

            // Andmekogu info
            System.out.printf("\n\n\n\n\n\n\n\nSee andmekogu koosneb m2ngu Counter Strike Global Offensive'i m2ngijate taustast. Hoiame m2ngija nime, SteamID'd, tiimi nime, m2ngusisest auastet, v6idetud m2ngude arvu, m2ngule kulutatud aega ning viimase m2ngusessiooni kuup2eva.\n\nLehekylg %d/%d\n\n", lehekuljeIndeks + 1, raamat.length);

            // Kirjutab lehekülje 5 rida leheküljeIndeksit jälgides (default 0)
            for(int n = 0; n < 5; n++){

                // Kui reas puudub tekst, siis kirjutab tühja rea
                if(raamat[lehekuljeIndeks][n] == null){
                    System.out.printf("%d.\n", lehekuljeIndeks * 5 + n + 1);
                }
                // Annab rea stringi uuele Mangija objektile, mis automaatselt täidab oma muutujad stringi järgi ning väljastab ühe rea ekraanile koos järjekorranumbriga
                else{
                    Mangija man = new Mangija(raamat[lehekuljeIndeks][n]);

                    System.out.printf("%d. %s #%d ; Tiim - %s ; Auaste - %s ; On v6itnud %d m2ngu ; CS:GO'd on m2nginud %d tundi ; Viimati m2ngis %s\n", lehekuljeIndeks * 5 + n + 1, man.nimi, man.steamId, man.tiimiNimi, man.auaste, man.voidetudMangud, man.mangitudAeg, man.viimatiMangis);
                }
            }

            // Kasutaja sisendi võimalused
            System.out.printf("\nJ2rgmine - \"J\" ; Eelmine - \"E\" ; V2lju - \"V\"\n");

            kask = scan.next();

            // Lehekülg edasi
            if(kask.toLowerCase().equals("j") && lehekuljeIndeks + 1 < raamat.length){
                lehekuljeIndeks++;
            }
            // Lehekülg tagasi
            else if(kask.toLowerCase().equals("e") && lehekuljeIndeks > 0){
                lehekuljeIndeks--;
            }
            // Väljub kordusest
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

        // Constructor
        public Mangija(){
        }

        public Mangija(String info){
            // Teeb stringi arrayks ning annab muutujatele väärtused
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
