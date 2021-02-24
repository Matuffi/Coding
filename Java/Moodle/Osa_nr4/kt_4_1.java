import java.util.Scanner;

public class kt_4_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Muutujad sisestatud arvu, selle arvu tegurite ja teguri loetelu jaoks
        // Tegurite loetelu kon string, kuna sellisel juhul saab terve loetelu ühe käsuga väljastada, ning meil ei ole vaja kindla indeksi väärtust
        int arv;
        int arvTegureid = 0;
        String tegurid = "";
        
        System.out.println("Sisestage arv:");
        arv = scan.nextInt();

        scan.close();

        // Vaatab igat arvu 1 - n, kas tegu on arvu teguriga. Kui on lisab selle arvu stringi ning suurendab tegurite arvu väärtust
        for(int i = 1; i <= arv; i++) {
            if(arv % i == 0){
                tegurid += "," + i;
                arvTegureid++;
            }
        }

        // Kui tegureid on 2, siis on tegu algarvuga (1 ja arv ise). Teisel juhul väljastab tegurite stringi
        if(arvTegureid == 2) {
            System.out.printf("Arv %d on algarv.", arv);
        }
        else{
            System.out.printf("Arv %d pole algarv ning jagub arvudega: %s", arv, tegurid.substring(1, tegurid.length()));
        }
    }
}
