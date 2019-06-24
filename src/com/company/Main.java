package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner((System.in));
        String[] cuvinte={"ponei","maimuta","constanta","cotropitor","pasune","armata"};
        boolean jocActiv=true;
        String reluareJoc;

        while (jocActiv) {
            int x=new Random().nextInt(cuvinte.length);
            String str=cuvinte[x];
            String toGuess=str.replaceAll("[a-zA-Z]","-");
            StringBuilder sb= new StringBuilder(toGuess);
            String[][] omulet= new String[3][3];

            for(int j=0; j<omulet.length;j++){
                for(int k=0; k<omulet.length;k++){
                    omulet[j][k]=" ";
                }
            }

            int count=0;
            System.out.println("Ghiciti cuvantul sau o sa fiti spanzurat!");
            System.out.println("Pentru fiecare cuvant aveti 6 incercari!");

            do {
                char c = input.nextLine().charAt(0);
                boolean flag = false;

                for (int i = 0; i < str.length(); i++) {
                    if (c == str.charAt(i)) {
                        flag = true;
                        sb.setCharAt(i, c);
                    }
                }

                if (!flag) {
                    count++;
                    if (count == 1) omulet[0][1] = "o";
                    if (count == 2) omulet[1][1] = "|";
                    if (count == 3) omulet[1][0] = "/";
                    if (count == 4) omulet[1][2] = "\\";
                    if (count == 5) omulet[2][0] = "/";
                    if (count == 6) omulet[2][2] = "\\";
                    if (count > 6) {
                        System.out.println("Nu ati ghicit si ati fost spanzurat, cuvantul era: " + str);
                        break;
                    }
                }

                System.out.println(sb);

                for (int j = 0; j < omulet.length; j++) {
                    for (int k = 0; k < omulet.length; k++) {
                        System.out.print(omulet[j][k]);
                    }
                    System.out.println();
                }

            } while (sb.toString().contains("-"));

            System.out.println("Doriti sa mai incercati inca un joc? Tastati da sau nu:");

            do {
                reluareJoc = input.nextLine();
            }while (!((reluareJoc.equals("da")) || (reluareJoc.equals("nu"))));

            if(reluareJoc.equalsIgnoreCase("da")){
                System.out.println("Aveti curaj!");
            }

            if(reluareJoc.equalsIgnoreCase("nu")) {
                jocActiv =false;
                System.out.println("Ne mai jucam si data viitoare!");
            }

            System.out.println("Ati gresit de "+count+" ori.");

        }
    }
}
