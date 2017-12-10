package allrangement;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 */
public class AllRangement {

    public List<String> allRangement(char[] tokens) {

        List<String> rangements = new LinkedList<>();
        allRangement(tokens, 0, tokens.length, rangements);

        return rangements;
    }

    public void allRangement(char[] tokens, int start, int end, List<String> rangements) {
        if (start == end - 1) {
            rangements.add(new String(tokens));
        } else {
            for (int i = start; i < end; i++) {
                swap(tokens, start, i);
                allRangement(tokens, start + 1, end, rangements);
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
        List<String> rangements = new AllRangement().allRangement(tokens);
        System.out.println(rangements);
        System.out.println(rangements.size());
    }

}
