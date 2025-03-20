import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class pangram {
    
    public static void main(String[] args){
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}; 
    

    String alphabet = "abcdefghijklmnopqrstuvwxyz";

        try {
            Scanner txt = new Scanner(new File("/Users/theo/Downloads/THEOCODE/words.txt"));
    

            ArrayList<String> al = new ArrayList<String>();

            while(txt.hasNextLine()){
                String word = txt.nextLine();
                al.add(word);
            } 

            Scanner in = new Scanner(System.in);

            System.out.println("Enter letters: ");

            String letters = in.nextLine();

            String remaining = alphabet;
            for(int i = 0; i < letters.length(); i++){
                remaining = remaining.replace(Character.toString(letters.charAt(i)), "");
            }

            ArrayList<String> al2 = new ArrayList<String>();

            for(int i = 0; i < al.size(); i++){
                if(al.get(i).contains(Character.toString(letters.charAt(0))) && al.get(i).contains(Character.toString(letters.charAt(1))) && al.get(i).contains(Character.toString(letters.charAt(2))) && al.get(i).contains(Character.toString(letters.charAt(3))) && al.get(i).contains(Character.toString(letters.charAt(4))) && al.get(i).contains(Character.toString(letters.charAt(5))) && al.get(i).contains(Character.toString(letters.charAt(6)))){
                    al2.add(al.get(i));
                }
            }

            ArrayList<String> al3 = new ArrayList<String>();

            for(int i = 0; i < al2.size(); i++){
                if(!(al2.get(i).contains(Character.toString(remaining.charAt(0))) || al2.get(i).contains(Character.toString(remaining.charAt(1))) || al2.get(i).contains(Character.toString(remaining.charAt(2))) || al2.get(i).contains(Character.toString(remaining.charAt(3))) || al2.get(i).contains(Character.toString(remaining.charAt(4))) || al2.get(i).contains(Character.toString(remaining.charAt(5))) || al2.get(i).contains(Character.toString(remaining.charAt(6))) || al2.get(i).contains(Character.toString(remaining.charAt(7))) || al2.get(i).contains(Character.toString(remaining.charAt(8))) || al2.get(i).contains(Character.toString(remaining.charAt(9))) || al2.get(i).contains(Character.toString(remaining.charAt(10))) || al2.get(i).contains(Character.toString(remaining.charAt(11))) || al2.get(i).contains(Character.toString(remaining.charAt(12))) || al2.get(i).contains(Character.toString(remaining.charAt(13))) || al2.get(i).contains(Character.toString(remaining.charAt(14))) || al2.get(i).contains(Character.toString(remaining.charAt(15))) || al2.get(i).contains(Character.toString(remaining.charAt(16))) || al2.get(i).contains(Character.toString(remaining.charAt(17))) || al2.get(i).contains(Character.toString(remaining.charAt(18))))){
                    al3.add(al2.get(i));
                }
            }

            for(int i = 0; i < al3.size(); i++){
                System.out.println(al3.get(i));
            }


            in.close();
            txt.close();


        } catch(FileNotFoundException e){
            System.out.println("file not found");
        }
    }
}
