import java.util.Scanner;
// Kasutab Scannerit

public class kt_2_1{
    public static void main(String[] args) {

        // Tekitab uue Scanneri nimega scan
        Scanner scan = new Scanner(System.in);

        // Tekitab reaalarvu muutujad
        double P, K, H, T, M;

        // Küsib kasutajalt sisendit
        System.out.println("Teekonna pikkus: ");
        P = scan.nextDouble();
        System.out.println("Tarbitud kütuse kogus: ");
        K = scan.nextDouble();
        System.out.println("Kütuse liitri hind: ");
        H = scan.nextDouble();

        // Sulgeb input streami
        scan.close();

        // Arvutab kütusekulu ja maksma minevat summat
        T = K / (P / 100);
        M = K * H;

        // Väljastab andmed
        System.out.printf("Olete sõitnud %.2f kilomeetrit ning kulutanud %.2f liitrit kütust. Teie auto kütusekulu oli %.2f liitrit 100 kilomeetri kohta. Sõidu maksumus oli %.2f eurot", P, K, T, M);
    }
}
