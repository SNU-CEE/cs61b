public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

//    public boolean isPalindrome(String word) {
//        if (word == null) {
//            return false;
//        }
//        if (word.length() <= 1) {
//            return true;
//        }
//        Deque<Character> word_deque = wordToDeque(word);
//        String reverse_word = new StringBuilder(word).reverse().toString();
//        Deque<Character> reversed_word_deque = wordToDeque(reverse_word);
//        for (int i = 0; i < word_deque.size(); i++) {
//            if (!(word_deque.get(i).equals(reversed_word_deque.get(i)))) {
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean isPalindrome(String word) {
        OffByN offBy0 =new OffByN(0);
        return isPalindrome(wordToDeque(word),offBy0);
    }

    private boolean isPalindrome(Deque<Character> characterDeque,CharacterComparator cc) {
//        OffByN offByN = (OffByN) cc;
        if (characterDeque.size() <= 1) return true;
        Character first = characterDeque.removeFirst();
        Character last = characterDeque.removeLast();

        return cc.equalChars(first,last) && isPalindrome(characterDeque,cc);
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        return isPalindrome(wordToDeque(word),cc);
    }


}
