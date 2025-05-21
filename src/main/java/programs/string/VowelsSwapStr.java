package programs.string;

public class VowelsSwapStr {


    public static void main(String[] args) {
        String input = "tiehayo";

        System.out.println("Original String: " + input);
        System.out.println("Modified String: " + swapVowels(input));
    }

    private static String swapVowels(String input) {
        int start = 0;
        int end = input.length() - 1;
        char[] list = input.toCharArray();
        while (start < end) {
            // start and end at got vowel
            if ((list[start] == 'a' || list[start] == 'e' || list[start] == 'i'
                    || list[start] == 'o' || list[start] == 'u') &&
                    (list[end] == 'a' || list[end] == 'e' || list[end] == 'i'
                            || list[end] == 'o' || list[end] == 'u')) {
                char temp = list[start];
                list[start] = list[end];
                list[end] = temp;
                start++;
                end--;
            } else if (!(list[start] == 'a' || list[start] == 'e' || list[start] == 'i'
                    || list[start] == 'o' || list[start] == 'u')) {
                start++;
            } else if (!(list[end] == 'a' || list[end] == 'e' || list[end] == 'i'
                    || list[end] == 'o' || list[end] == 'u')) {
                end--;
            }

        }
        return new String(list);
    }
}
