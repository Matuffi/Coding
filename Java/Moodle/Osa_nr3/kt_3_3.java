import java.util.Scanner;

public class kt_3_3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Päevad, Sõidud, 1 pileti hind, Päeva pileti hind, Kuukaardi hind
        int P, S;
        double Y, D, K;

        // Saab kasutajalt andmed
        System.out.println("Sisestage päevade arv:");
        P = scan.nextInt();
        System.out.println("Sisestage sõitude arv:");
        S = scan.nextInt();
        System.out.println("Sisestage ühekordse pileti hind:");
        Y = scan.nextDouble();
        System.out.println("Sisestage päeva pileti hind:");
        D = scan.nextDouble();
        System.out.println("Sisestage kuukaardi hind:");
        K = scan.nextDouble();

        scan.close();

        // Päevade arv ei kuulu 1 kuu sisse
        if(1 > P || 30 < P){           
            System.out.println("Error: Sisestage päevade arv vahemikus 1 - 30");
            System.exit(1);
        }

        // Esialgne väljund ilma lõppvastuseta
        System.out.printf("Turist viibib linnas %d päeva ja teeb %d bussisõitu. \nPiletite hinnad:\nÜhekordne pilet: %.2f \nPäevapilet: %.2f \nKuukaart: %.2f.\nÜhekordsete piletite hind kokku: %.2f\nPäevapiletite hind kokku: %.2f\n========================================\n", P, S, Y, D, K, S * Y, P * D);
        
        // Soodsaima võimaluse arvutamine ning väljastamine
        if(S*Y < P*D && S*Y < K){
            System.out.printf("Soodsaim variant on %d ühekordset piletit.", S);
        }
        else if(P*D <  S*Y && P*D < K){
            System.out.printf("Soodsaim variant on %d päeva piletit.", P);
        }
        else{
            System.out.printf("Soodsaim variant on kuukaart.");
        }
    }
}



/* 
"Sisestage päevade arv:" ja sisestada päevade arv järgmisel real.
"Sisestage sõitude arv:" ja sisestada sõitude arv järgmisel real.
"Sisestage ühekordse pileti hind:" ja sisestada ühekordse pileti hind järgmisel real.
"Sisestage päeva pileti hind:" ja sisestada päeva pileti hind järgmisel real.
"Sisestage kuukaardi hind:" ja sisestada kuukaardi hind järgmisel real.
*/