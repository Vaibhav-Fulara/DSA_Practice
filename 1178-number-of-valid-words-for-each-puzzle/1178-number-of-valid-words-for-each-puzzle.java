class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        int puzzlesLen = puzzles.length;
        List<Integer> result = new ArrayList<>(puzzlesLen);
        if (puzzlesLen == 0 || words.length == 0) {
            for (int i = 0; i < puzzlesLen; i++) {
                result.add(0);
            }
            return result;
        }

        HashMap<Integer, Integer> wordMaskCountMap = new HashMap<>();
        for (String word : words) {
            int wordMask = getMask(word, 0);
            wordMaskCountMap.put(wordMask, wordMaskCountMap.getOrDefault(wordMask, 0) + 1);
        }

        for (String puzzle : puzzles) {
            int puzzleMask = getMask(puzzle, 1);
            int firstCharMask = 1 << (puzzle.charAt(0) - 'a');
            int subsetMask = puzzleMask;
            int count = wordMaskCountMap.getOrDefault(firstCharMask, 0);

            while (subsetMask != 0) {
                count += wordMaskCountMap.getOrDefault(subsetMask | firstCharMask, 0);
                subsetMask = (subsetMask - 1) & puzzleMask;
            }

            result.add(count);
        }

        return result;
    }
    
    private static int getMask(String s, int start) {
        int mask = 0;
        for (int i = start; i < s.length(); i++) {
            mask |= 1 << (s.charAt(i) - 'a');
        }
        return mask;
    }
}