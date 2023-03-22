package util;

import java.util.Scanner;

public class ReplaceBrackets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        input = input.replaceAll("\\[", "{");
        input = input.replaceAll("]", "}");
        input = input.replaceAll("\"", "\'");

        System.out.println(input);

        in.close();
    }
}
