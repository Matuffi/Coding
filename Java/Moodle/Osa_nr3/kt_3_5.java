import java.util.Scanner;

public class kt_3_5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Päevade arv
        int k;

        // Sisendi saamine
        System.out.println("Sisestage päeva numbri k:");
        k = scan.nextInt();

        scan.close();

        // Kui sisestatud päevade arv ei kuulu ühte aastasse
        if( !(1<=k) || !(k<=365) ){
            System.out.println("Err: Palun sisestada päevade arv vahemikus 1 - 365");            
            System.exit(1);
        }

        // Leiab jäägi, kui jagada etteantud päevad 7'ga. Pühapäevaga jääb jäägiks 0
        switch( k % 7 ){
            case 1:
                System.out.printf("Aasta %d. päev on esmaspäev", k);
                break;
            case 2:
                System.out.printf("Aasta %d. päev on teisipäev", k);
                break;
            case 3:
                System.out.printf("Aasta %d. päev on kolmapäev", k);
                break;
            case 4:
                System.out.printf("Aasta %d. päev on neljapäev", k);
                break;
            case 5:
                System.out.printf("Aasta %d. päev on reede", k);
                break;
            case 6:
                System.out.printf("Aasta %d. päev on laupäev", k);
                break;
            case 0:
                System.out.printf("Aasta %d. päev on pühapäev", k);
                break;
        }
    }
}
