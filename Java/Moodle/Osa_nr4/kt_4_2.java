import java.util.Scanner;
import java.util.Random;

public class kt_4_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        // Mängija sisend, suvaline number ning võidu olemus
        int pakkumine;
        int arv = rand.nextInt(601) - 300;
        boolean voit = false;

        System.out.println("Alustame mängu.");

        for(int i = 0; i < 8; i++) {
            // Mängija pakub numbri
            System.out.println("Sisestage uus arv:");
            pakkumine = scan.nextInt();

            // Kui pakutud number on õige, väljub kordusest näidates, et mängija võitis
            if(pakkumine == arv) {
                voit = true;
                break;
            }
            // Kas arv on suurem või väiksem
            else if(pakkumine > arv) {
                System.out.println("Peidetud arv on vähem.");
            }
            else{
                System.out.println("Peidetud arv on suurem.");
            }
        }

        scan.close();

        // Kui tegu oli võiduga näitab programm seda, teisel juhul näitab kaotust
        if(voit) {
            System.out.printf("Peidetud arv on %d", arv);
        }
        else {
            System.out.printf("Te kaotasite. Peidetud arv oli %d.", arv);
        }
    }
}
