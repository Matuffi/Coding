import java.util.Scanner;

public class kt_3_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Kaal, Töödeldud kaal, Planeedi nimetus
        double K, X;
        String P;

        // Küsib kasutajalt sisendit ning standardiseerib selle lowercase'i
        System.out.println("Sisestage kaal kilogrammides:");
        K = scan.nextDouble();
        System.out.println("Sisestage planeet (merkuur, veenus, maa, marss, jupiter, saturn, uraan, neptuun):");
        P = scan.next().toLowerCase();

        scan.close();

        // Planeedi nimetuste järgi otsustab millise koefitsiendiga kaalu korrutab
        switch(P){
            case "merkuur":
                X = K * 0.378;
                break;
            case "veenus":
                X = K * 0.907;
                break;
            case "maa":
                X = K * 1.0;
                break;
            case "marss":
                X = K * 0.377;
                break;
            case "jupiter":
                X = K * 2.364;
                break;
            case "saturn":
                X = K * 1.064;
                break;
            case "uraan":
                X = K * 0.889;
                break;
            case "neptuun":
                X = K * 1.125;
                break;
            default:
                // Kui kasutaja sisend erineb planeetide nimekirjast
                System.out.println("Palun sisestage etteantud planeet.");
                X = 0; // Muidu viskav errori, kuna on võimalik, et väljundis jääb x null
                System.exit(1);
        }

        // Lõppväljund
        System.out.printf("Teie kaal planeedil %s oleks %.2f kilogrammi.", P, X);
    }
}

// "Sisestage kaal kilogrammides:" 
// "Sisestage planeet (merkuur, veenus, maa, marss, jupiter, saturn, uraan, neptuun):"
// "Teie kaal planeedil P oleks X kilogrammi"

// Arvutuse reegel on lihtne: X = kaal korrutatud planeedi kaalu koefitsiendiga.

/*
Merkuur: 0.378
Veenus: 0.907
Maa: 1.0
Marss: 0.377
Jupiter: 2.364
Saturn: 1.064
Uraan: 0.889
Neptuun: 1.125
*/