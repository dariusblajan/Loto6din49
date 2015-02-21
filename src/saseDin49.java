import java.util.*;
import java.io.*;

public class saseDin49 {

    public static boolean isThere(int[] a, int x, int index){
        boolean b = false;
        for (int i = 0; i < index; i++) {
            if (x == a[i]) {
                b = true;
                break;
            }
        }
        return b;
    }

    public static void generate(int[] genArr) {
        int i = 0;
        while (i < 6) {
            Random r = new Random();
            int x = r.nextInt(50);
            genArr[i]=x;
            if ((genArr[i] >= 1) && (genArr[i] <= 49) && (!isThere(genArr, genArr[i], i))) {
                i=i+1;};
        }
    }

    private static int verify(int[] a, int[] b) {
        int match = 0;
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++) {
                if (a[i] == b[j]) match++;
            }
        return match;
    }

    public static void main(String[] args) {

        int contor = 0;
        int countLoser=0;

        int matches=0;
        do {
            int[] a = {0, 0, 0, 0, 0, 0};
            int[] g = {0, 0, 0, 0, 0, 0};
            generate(a);
            generate(g);

            matches = verify(a, g);
            switch (matches)

            {
                case 0: {
                    System.out.println("LOSER!!! no matches");
                    countLoser++;
                    break;
                }
                case 1: {
                    System.out.println("1 match");
                    break;
                }
                case 2: {
                    System.out.println("2 matches");
                    break;
                }
                case 3: {
                    System.out.println("3 matches");
                    break;
                }
                case 4: {
                    System.out.println("4 matches");
                    break;
                }

                case 5: {
                    System.out.println("5 matches");
                    break;
                }
                case 6: {
                    System.out.println("6 matches");
                    break;
                }
            }
            contor++;
        } while (matches < 6);
        System.out.println("dupa "+contor+" incercari");

    }



}
