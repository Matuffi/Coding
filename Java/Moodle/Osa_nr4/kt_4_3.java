import java.util.Scanner;

public class kt_4_3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Tagasiraha väärtus, iga rahatähe lisamisel veel maksta jäärud raha väärtus ning iga kasutatud rahatähe arv
        int summa, jargi;
        int kakskymmend = 0;
        int kymme = 0;
        int viis = 0;
        int kaks = 0;
        int yks = 0;
        // Kas raha on täpselt ja rahatähti jagub
        boolean tapne = true;
        boolean piisav = true;

        System.out.println("Sisestage summa, mida ostja saab tagasi");
        summa = scan.nextInt();

        scan.close();

        jargi = summa;

        // Kestab niikaua kuniks kõik raha on tagasi antud
        while(jargi > 0){
            // Vaatab igat rahatähte alates suuremast, et tagasiraha oleks vähima arvuga rahatähtedega
            // Kui rahatäht on liiga suur tagasiandmiseks, või kõik sellised rahatähed on kasutatud, minnakse järgmise väiksema rahatähe juurde
            if(jargi - 20 >= 0 && kakskymmend < 1) {
                jargi -= 20;
                kakskymmend++;
            }
            else if(jargi - 10 >= 0 && kymme < 2) {
                jargi -= 10;
                kymme++;
            }
            else if(jargi - 5 >= 0 && viis < 3) {
                jargi -= 5;
                viis++;
            }
            else if(jargi - 2 >= 0 && kaks < 1) {
                jargi -= 2;
                kaks++;
            }
            else if(jargi - 1 >= 0 && yks < 1) {
                jargi -= 1;
                yks++;
            }
            // Kui kõik rahatähed on ära kasutatud, kuid raha on veel maksta - järelikult ei ole rahatähti piisavalt
            else if(kakskymmend == 1 && kymme == 2 && viis == 3 && kaks == 1 && yks == 1){
                piisav = false;
                break;
            }
            // Kui aga Rahatähti on veel alles, kuid rohkem maksta ilma yle minemiseta ei saa - järelikult pole piisavalt täpselt rahatähti
            else {
                tapne = false;
                break;
            }
        }

        // Kontrollib, kas maksmisega oli probleeme, sellisel juhul ütleb vea ette. Õnnestumise korral aga väljastab kõik kasutatud rahatähed
        if(!tapne) {
            System.out.println("Pole võimalik anda täpne raha tagasi.");
        }
        else if(!piisav) {
            System.out.println("Kassas pole piisavalt raha.");
        }
        else {
            System.out.printf("Tagasi tuleb anda:\n");

            if(kakskymmend > 0) {
                System.out.printf("20-eurosed: %d tk\n", kakskymmend);
            }
            if(kymme > 0) {
                System.out.printf("10-eurosed: %d tk\n", kymme);
            }
            if(viis > 0) {
                System.out.printf("5-eurosed: %d tk\n", viis);
            }
            if(kaks > 0) {
                System.out.printf("2-eurosed: %d tk\n", kaks);
            }
            if(yks > 0) {
                System.out.printf("1-eurosed: %d tk\n", yks);
            }
        }
    }
}
