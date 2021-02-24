import java.util.Scanner;
// Kasuta Scannerit

public class kt_2_3 {
    public static void main(String[] args) {
        
        // Tekitame uue Scanneri
        Scanner scan = new Scanner(System.in);

        // Reaalarvulised muutujad
        double S, Y, P, T, K; 

        // Omistame kasutaja info muutujatesse ja sulgeme input streami
        System.out.println("Sisestage laenusumma eurodes:");
        S = scan.nextDouble();
        System.out.println("Sisestage laenuperiood aastades:");
        Y = scan.nextDouble();
        System.out.println("Sisestage intressimäär protsentides:");
        P = scan.nextDouble();
        scan.close();

        /* Tegu on algse võrrandiga
            K = (S*(P/100/12)) / (1 - Math.pow((1 + (P/100/12)), (-Y*12)));
            T = K * Y * 12;
        */

        // Kalkuleerime kuumakse ja kogusumma nii nagu oli laenukalkulaatoris https://www.kalkulaator.ee/et/laenukalkulaator
        // Kahe võrrandi erinevus on kuumakse ümardamine
        K = (S*(P/100/12)) / (1 - Math.pow((1 + (P/100/12)), (-Y*12)));
        T = Math.round(K * 100.0) / 100.0 * Y * 12;

        // Väljastame info
        System.out.printf("Laenusummaga %.2f eurot %.2f intressimääraga te peate maksma %.2f eurot kuus %.2f aastat. Ja kokku maksate pangale %.2f eurot.", S, P, K, Y, T);

    }
}
