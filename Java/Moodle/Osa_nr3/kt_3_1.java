import java.util.Scanner;

public class kt_3_1{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Raadius, Küle pikkus, Ringi pindala, Ruudu pindala
        double R, K, Sr, Sk;

        // Küsime kasutajalt sisendid
        System.out.println("Sisestage ringi raadius:");
        R = scan.nextDouble();
        System.out.println("Sisestage ruudu külje pikkus:");
        K = scan.nextDouble();

        scan.close();

        // Arvutab ringi ja ruudu pindala
        Sr = R * R * Math.PI;
        Sk = K * K;

        System.out.printf("Ringi pindala on %.2f. Ruudu pindala on %.2f. ", Sr, Sk);

        // Otsustab, kumma kujundi pindala on suurem
        if(Sk > Sr){
            System.out.println("Ruudu pindala on suurim.");
        }
        else{
            System.out.println("Ringi pindala on suurim.");
        }
    }
}