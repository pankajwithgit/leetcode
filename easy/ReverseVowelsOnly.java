import java.util.ArrayList;
import java.util.List;

class ReverseVowelsOnly {
    public String reverseVowels(String s) {
        if(s == null) return null;
        if(s.isEmpty()) return "";
        
        char[] arr = s.toCharArray();
        
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right) {
            if(isVowel(arr[left])) {
                if(isVowel(arr[right])) {
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                    right--;
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }
        return new String(arr);
    }
    
    private boolean isVowel(char c) {
        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        return vowels.contains(Character.valueOf(c));
    }

    public static void main(String[] args) {
      ReverseVowelsOnly obj = new ReverseVowelsOnly();
      String strToTest = "hello";

      String output = obj.reverseVowels(strToTest);
      System.out.println(output);
    }
}
