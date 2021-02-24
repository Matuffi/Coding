import java.util.Scanner;

public class kt_3_4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Funktsiooni sisend, Funktsiooni väärtus
        int x, F;

        // Sisendi saamine
        System.out.println("Sisestage x väärtus:");
        x = scan.nextInt();

        scan.close();

        // Sobiva vahemiku leidmine
        if(x<=0){
            F = 0;
        }
        else if(x<=7){
            F = x * x;
        }
        else{
            F = 3 * x + 51;
        }

        // Lõppväljund vastusega
        System.out.printf("Funktsiooni F väärtus kohal %d on %d.", x, F);
        
        // System.out.printf("Funktsiooni F väärtus kohal x on %d.", x, F); Ülesandes on vähe informatsiooni vormistuse kohta.
    }
}
