import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class kt_5_2 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner scan = new Scanner(System.in);

        FileOutputStream fos = new FileOutputStream("M:/Coding/Java/Moodle/Osa_nr5/andmebaas.txt", true);
        PrintWriter writer = new PrintWriter(fos);

        Mangija man = new Mangija();

        System.out.print("Sisestage m2ngija nimi: ");
        man.nimi = scan.nextLine();

        System.out.print("Sisestage m2ngija SteamId: ");
        man.steamId = Integer.parseInt(scan.nextLine());

        System.out.print("Sisestage m2ngija tiimi nimi: ");
        man.tiimiNimi = scan.nextLine();

        System.out.print("Sisestage m2ngija auaste: ");
        man.auaste = scan.nextLine();

        System.out.print("Sisestage m2ngija v6idetud m2ngude arv: ");
        man.voidetudMangud = Integer.parseInt(scan.nextLine());

        System.out.print("Sisestage, mitu tundi on m2ngija CS:GO'd m2nginud: ");
        man.mangitudAeg = Integer.parseInt(scan.nextLine());

        System.out.print("Sisestage, millal m2ngija viimati m2ngis (dd/mm/yyyy): ");
        man.viimatiMangis = scan.nextLine();

        System.out.printf("\nKontrollige andmed yle\n\n%s #%d ; Tiim - %s ; Auaste - %s ; On v6itnud %d m2ngu ; CS:GO'd on m2nginud %d tundi ; Viimati m2ngis %s\n\n\"J\" - sisesta andmebaasi | \"E\" - hylga andmed\n\n", man.nimi, man.steamId, man.tiimiNimi, man.auaste, man.voidetudMangud, man.mangitudAeg, man.viimatiMangis);

        String vastus = scan.next();

        if(vastus.toLowerCase().equals("j")){
            writer.printf("\n%s#%d#%s#%s#%d#%d#%s", man.nimi, man.steamId, man.tiimiNimi, man.auaste, man.voidetudMangud, man.mangitudAeg, man.viimatiMangis);
        }
        else if(vastus.toLowerCase().equals("e")){
        }
       
        writer.close();
        scan.close();

    }

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