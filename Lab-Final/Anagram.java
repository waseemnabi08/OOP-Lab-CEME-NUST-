
import java.util.*;

public class Anagram {
   
    public boolean isAnagram(String s, String s2) {
        boolean isAnagram = true;

        int length = s.length();
        int length1 = s2.length();

        if (length != length1) {
            return false;
        } else {
            char[] charArray1 = s.toCharArray();
            char[] charArray2 = s2.toCharArray();

            Arrays.sort(charArray1);
            Arrays.sort(charArray2);

            for (int i = 0; i < length; i++) {
                if (charArray1[i] != charArray2[i]) {
                    isAnagram = false;
                    break;
                }
            }
        }

        return isAnagram;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s = input.nextLine();
        System.out.print("Enter second string: ");
        String s2 = input.nextLine();
        Anagram anagram = new Anagram();
        if (anagram.isAnagram(s, s2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }
    }
}
    
   
    

