import java.util.*;

public class loto649coll {
    public static HashSet<Integer> generate(int counter){
        final int MAXVALUE = 49;
        Random random = new Random();
        HashSet<Integer> set = new HashSet<Integer>();
        while (set.size() < counter) {
            int number = random.nextInt(MAXVALUE) + 1;
            set.add(number);
        }
        return set;
    }

    public static HashSet<Integer> compare(HashSet<Integer> a, HashSet<Integer> b){
        a.retainAll(b);
        return a;
    }


    public static void main(String[] args) {
        final int MAX_NUMBERS = 6;
        HashSet<Integer> userPick = new HashSet<Integer>();
        HashSet<Integer> systemDraw = new HashSet<Integer>();
        boolean matchFound = false;
        System.out.println("welcome to loto 6/49\n");
        systemDraw = generate(MAX_NUMBERS);
        Object[] array = systemDraw.toArray();
        System.out.println("today's draw is:");
        for (int i = 0; i < systemDraw.size(); i++)
            System.out.print(array[i] + " ");
        int counter=0;
        do {
            userPick = generate(MAX_NUMBERS);
            counter++;
            userPick = compare(userPick, systemDraw);
            int matches = userPick.size();
            switch (matches) {
                case 0: {
                    //System.out.println("LOSER!!! no matches");
                    break;
                }
                case 1: {
                    //System.out.println("1 match");
                    //matchFound=true;
                    break;
                }
                case 2: {
                    //System.out.println("2 matches");
                    //matchFound=true;
                    break;
                }
                case 3: {
                    //System.out.println("3 matches");
                    //matchFound=true;
                    break;
                }
                case 4: {
                    //System.out.println("4 matches");
                    //matchFound=true;
                    break;
                }

                case 5: {
                    System.out.println("congrats! you got 5 matches");
                    System.out.println("...after " + counter +" attempts");
                    matchFound = true;
                    array = userPick.toArray();
                    System.out.print("matching numbers are: ");
                    for (int i = 0; i < userPick.size(); i++)
                        System.out.print(array[i] + " ");
                    break;
                }
                case 6: {
                    //System.out.println("6 matches");
                    //matchFound = true;
                    break;
                }
            }
        } while (!matchFound);

    }

}
