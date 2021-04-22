import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class kt_5_2 {
    public static void main(String[] args) throws FileNotFoundException{
        
        // Kasutaja sisend ning faili kirjutamine
        Scanner scan = new Scanner(System.in);
        FileOutputStream fos = new FileOutputStream("andmebaas.txt", true);
        PrintWriter writer = new PrintWriter(fos);

        // Mängija objekt
        Mangija man = new Mangija();

        // Küsib kasutajalt infot
        System.out.print("Sisestage mängija nimi: ");
        man.nimi = scan.nextLine();

        System.out.print("Sisestage mängija SteamId: ");
        man.steamId = Integer.parseInt(scan.nextLine());

        System.out.print("Sisestage mängija tiimi nimi: ");
        man.tiimiNimi = scan.nextLine();

        System.out.print("Sisestage mängija auaste: ");
        man.auaste = scan.nextLine();

        System.out.print("Sisestage mängija v6idetud mängude arv: ");
        man.voidetudMangud = Integer.parseInt(scan.nextLine());

        System.out.print("Sisestage, mitu tundi on mängija CS:GO'd mänginud: ");
        man.mangitudAeg = Integer.parseInt(scan.nextLine());

        System.out.print("Sisestage, millal mängija viimati mängis (dd/mm/yyyy): ");
        man.viimatiMangis = scan.nextLine();

        // Kontroll ennem faili kirjutamist
        System.out.printf("\nKontrollige andmed yle\n\n%s #%d ; Tiim - %s ; Auaste - %s ; On v6itnud %d mängu ; CS:GO'd on mänginud %d tundi ; Viimati mängis %s\n\n\"J\" - sisesta andmebaasi | \"E\" - hylga andmed\n\n", man.nimi, man.steamId, man.tiimiNimi, man.auaste, man.voidetudMangud, man.mangitudAeg, man.viimatiMangis);

        String vastus = scan.next();

        // Kirjutab info faili vormistatult
        if(vastus.toLowerCase().equals("j")){
            writer.printf("\n%s#%d#%s#%s#%d#%d#%s", man.nimi, man.steamId, man.tiimiNimi, man.auaste, man.voidetudMangud, man.mangitudAeg, man.viimatiMangis);
        }
        // Niikuinii väljutakse programmist
        else if(vastus.toLowerCase().equals("e")){
            // ?
        }
       
        // Sulgeb sisend ja väljundvoo
        writer.close();
        scan.close();

    }

    // Muutujatega objekt
    public static class Mangija {
        String nimi;
        int steamId;
        String tiimiNimi;
        String auaste;
        int voidetudMangud;
        int mangitudAeg;
        String viimatiMangis;
    }
}