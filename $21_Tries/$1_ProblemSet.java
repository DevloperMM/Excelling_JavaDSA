package $21_Tries;

public class $1_ProblemSet {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
            for (int i=0; i<26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int level=0; level<word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }

        curr.eow = true;
    }
    
    public static boolean search(String key) {
        Node curr = root;
        for (int level=0; level<key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }

        return curr.eow == true;
    }

    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }

        for (int i=1; i<=key.length(); i++) {
            String firstPart = key.substring(0, i);
            String secPart = key.substring(i);
            if (search(firstPart) && wordBreak(secPart)) {
                return true;
            }
        }

        return false;
    }

    public static boolean startsWith(String prefix) {
        Node curr = root;
        for (int i=0; i<prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static int countTrie(Node root) {
        if (root == null) {
            return 0;
        }

        int count = 0;
        for (int i=0; i<26; i++) {
            if (root.children[i] != null) {
                count += countTrie(root.children[i]);
            }
        }

        return count + 1;
    }

    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }

        for (int i=0; i<26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                temp.append((char)(i+'a'));
                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        // String words[] = {"the", "answer", "there", "their", "any", "thee"};
        // String words[] = {"i", "like", "sam", "samsung", "mobile", "ice",};
        // String words[] = {"app", "apple", "man", "mango", "woman"};
        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};

        //Q-1
        for (int i=0; i<words.length; i++) {
            insert(words[i]);
        }

        //Q-2
        // System.out.println((search("there")));
        // System.out.println(search("ask"));

        //Q-3
        // String key = "ilikesamsung";
        // System.out.println(wordBreak(key));

        //Q-4
        // System.out.println(startsWith("app"));
        // System.out.println(startsWith("moon"));

        //Q-5
        // String str = "apple";
        // for (int i=0; i<str.length(); i++) {
        //     String suffix = str.substring(i);
        //     insert(suffix);
        // }
        // System.out.println(countTrie(root));

        //Q-6
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
        
    }
}