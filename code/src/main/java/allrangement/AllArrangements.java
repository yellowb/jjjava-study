package allrangement;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 */
public class AllArrangements {

    public List<String> allArrangement(char[] tokens) {

        List<String> arrangements = new LinkedList<>();
        allArrangement(tokens, 0, tokens.length, arrangements);

        return arrangements;
    }

    public void allArrangement(char[] tokens, int start, int end, List<String> rangements) {
        if (start == end - 1) {
            rangements.add(new String(tokens));
        } else {
            for (int i = start; i < end; i++) {
                swap(tokens, start, i);
                allArrangement(tokens, start + 1, end, rangements);
                swap(tokens, start, i);
            }
        }
    }

    /**
     * Swap the char at index i & j
     *
     * @param tokens
     * @param i
     * @param j
     */
    public void swap(char[] tokens, int i, int j) {
        char temp = tokens[i];
        tokens[i] = tokens[j];
        tokens[j] = temp;
    }

    public static void main(String[] args) {
        char[] tokens = "1234".toCharArray();
        List<String> arrangements = new AllArrangements().allArrangement(tokens);
        System.out.println(arrangements);
        System.out.println(arrangements.size());
    }

}
