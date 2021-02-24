import java.util.Scanner;
// Kasutab Scannerit

public class kt_2_2 {
    public static void main(String[] args) {

        // Tekitab uue Scanneri nimega scan
        Scanner scan = new Scanner(System.in);
        
        // Tekitab reaalarvulised muutujad
        double B, T, N;

        // Küsib kasutajalt sisendit
        System.out.println("Mis on teie brutopalk eurodes?");
        B = scan.nextDouble();

        // Sulgeb input streami
        scan.close();

        // Kontrollib, et brutopalk oleks miinimumpalgast suurem
        if(B >= 450){

            // Teeb vajalikud arvutused
            T = B * (1+0.33+0.008);
            N = (B*(1-0.016-0.02)-180) * (1-0.20) + 180;

            // Väljastab info
            System.out.printf("Kui töötaja brutopalk on %.2f eurot, siis tööandja maksab %.2f eurot ja töötaja saab kätte puhtalt %.2f eurot.", B, T, N);
        }
        // Kui brutopalk on miinimumpalgast suurem
        else{

            System.out.println("Sisestatud brutopalk ei sobi, kuna aastal 2017 oli miinimumpalk 480 eurot.");
        }
    }
}
