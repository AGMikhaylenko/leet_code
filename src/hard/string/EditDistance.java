package hard.string;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int lengthOne = word1.length();
        int lengthTwo = word2.length();

        if (lengthOne == 0) {
            return lengthTwo;
        }
        if (lengthTwo == 0) {
            return lengthOne;
        }

        int distance[][] = new int[lengthOne + 1][lengthTwo + 1];

        for (int word1Index = 1; word1Index <= lengthOne; word1Index++) {
            distance[word1Index][0] = word1Index;
        }

        for (int word2Index = 1; word2Index <= lengthTwo; word2Index++) {
            distance[0][word2Index] = word2Index;
        }

        for (int word1Index = 1; word1Index <= lengthOne; word1Index++) {
            for (int word2Index = 1; word2Index <= lengthTwo; word2Index++) {
                if (word2.charAt(word2Index - 1) == word1.charAt(word1Index - 1)) {
                    distance[word1Index][word2Index] = distance[word1Index - 1][word2Index - 1];
                } else {
                    distance[word1Index][word2Index] = Math.min(
                            distance[word1Index - 1][word2Index],
                            Math.min(distance[word1Index][word2Index - 1],
                                    distance[word1Index - 1][word2Index - 1])
                    ) + 1;
                }
            }
        }

        return distance[lengthOne][lengthTwo];
    }
}
