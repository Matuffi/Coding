import java.util.Scanner;

public class sisend {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double p, x, k;

        p = scan.nextDouble();
        x = scan.nextDouble();
        k = (100/p) * x;

        scan.close();

        System.out.printf("%f\n", k);
    }
}
