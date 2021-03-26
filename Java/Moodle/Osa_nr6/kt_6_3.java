import java.util.Scanner;

public class kt_6_3 {
    
    static int maxBinPikkus = 32;


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String sisend;

        // Lõpmatu kordus kuniks kasutaja lahkub
        while(true){
            // Valikud
            System.out.printf("\n\"D\" - kahendsüsteemist kümnendsüsteemi (2->10)\n\"B\" - kümnendsüsteemist kahendsüsteemi (10->2)\n\"E\" - välu programmist\n\n - ");

            sisend = scan.nextLine().toUpperCase();

            // Kontrollib valikut
            if(sisend.equals("D")){
                System.out.printf("\nSisestage palun binaarkood: \n");
                String bin = scan.nextLine();
                // Etteantud string muudetakse binaari arrayks ning sisestatakse binaar - täisarv teisendajasse
                System.out.printf("\nVastus - %d\n", BinaryToDecimal(StringToBinary(bin)));
            }
            else if(sisend.equals("B")){
                System.out.printf("\nSisestage palun arv: \n");
                int num = Integer.parseInt(scan.nextLine());
                // Number läheb täisarv - binaar teisendajasse ning binaar array muudetakse Stringiks
                System.out.printf("\nVastus - %s\n", BinaryToString(DecimalToBinary(num)));
            }
            else if(sisend.equals("E")){
                break;
            }
        }
        
        scan.close();

    }
    
    // Binaar - täisaerv teisendus
    public static int BinaryToDecimal(int[] bin) {
        
        int loppVaartus = 0;
        
        // Liidab kahe astmed
        for(int i = 0; i < bin.length; i++){
            loppVaartus += bin[i] * Math.pow(2, i);
        }
        
        return loppVaartus;
        
    }

    // Täisarv - binaar teisendus
    public static int[] DecimalToBinary(int dec) {
        
        int[] binaar = new int[maxBinPikkus];
        int[] valjaBin;
        int indeks = 0;
        
        // Arvu jagamisel 2'ga tekkinud jääk läheb binaari arraysse
        while(dec > 0){
            binaar[indeks++] = dec % 2;
            dec /= 2;
        }
        
        // Tehakse väljundiks binaari järg minimaalselt suurusega ning väljastab selle
        valjaBin = new int[indeks];
        
        for(int i = 0; i < indeks; i++){
            valjaBin[i] = binaar[i];
        }
        
        return valjaBin;
        
    }
    
    // Tekst - binaar teisendus
    public static int[] StringToBinary(String str) {
        
        int[] loppVaartus = new int[str.length()];
        String[] strArr = str.split("");
        
        // Pöörab Stringist tulnud array ümber, kuna Stringis on LSB charArr lõpus, aga programmis on alguses
        for(int i = 0; i < strArr.length; i++){
            loppVaartus[i] = Integer.parseInt(strArr[strArr.length - i - 1]);
        }
    
        return loppVaartus;
    
    }
    
    // Binaar - tekst teisendus
    public static String BinaryToString(int[] bin) {
        
        String loppString = "";
        
        // Liidab binaar array tagantpoolt Stringi, et Stringi 1. bit oleks MSB
        for(int i = bin.length; i > 0; i--){
            loppString += bin[i - 1];
        }
        
        return loppString;
        
    }
    
}
