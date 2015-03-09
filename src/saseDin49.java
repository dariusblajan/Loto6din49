import java.util.*;
import java.io.*;

public class saseDin49 {

    public static final int MAXVALUE = 49;

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
            Random r = new Random();//genereaza un nr random
            int x = r.nextInt(MAXVALUE+1);//converteste la int
            genArr[i]=x;//se pune in array
            //vefific daca nr exista in sir pana la index i, exclusiv
            if ((genArr[i] >= 1) && (genArr[i] <= MAXVALUE) && (!isThere(genArr, genArr[i], i))) {
                i=i+1;};
        }
    }

    private static int verify(int[] a, int[] b) {//procedura pentru verificarea "biletului"
        int match = 0;
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++) {
                if (a[i] == b[j]) match++;
            }
        return match;
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        double counter = 0;
        int matches=0;
        System.out.println("Welcome to loto 6/49");
        System.out.print("no of matches wanted: ");
        int wanted=read.nextInt();
        long startTime= System.currentTimeMillis();
        int[] systemDraw = {0, 0, 0, 0, 0, 0};
        int[] userPick = {0, 0, 0, 0, 0, 0};
        generate(systemDraw);
        do {
            generate(userPick);
            matches = verify(systemDraw, userPick);
            switch (matches)
            {
                case 0: {
                    System.out.println("LOSER!!! no matches");
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
            counter++;

        } while (matches < wanted);
        long endTime= System.currentTimeMillis();
        float diff=(float)(endTime-startTime)/1000;
        System.out.println("dupa "+counter+" incercari si "+diff+" secunde");
        System.out.println("...si ar costa cam "+counter*5+" lei");
    }
}
