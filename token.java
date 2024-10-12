//tokenisation is the process of splitting the given sentence

import java.util.Scanner;
import java.util.StringTokenizer;

public class token {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the limit");
        int n = sc.nextInt();
        sc.nextLine(); // to add \n

        System.out.println("enter the " + n + " number(space seperated)");
        String numlist = sc.nextLine();
        StringTokenizer st = new StringTokenizer(numlist, " ");
        int sum = 0;
        while (st.hasMoreTokens()) {
            sum = sum + Integer.parseInt(st.nextToken());
        }
        System.out.println("sum=" + sum);

    }

}
