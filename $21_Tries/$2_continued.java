package $21_Tries;

public class $2_continued {
    static class Node {
        Node children[] = new Node[26];
        int freq;

        Node(int freq) {
            for (int i=0; i<26; i++) {
                children[i] = null;
            }
            this.freq = freq;
        }
    }

    public static Node root = new Node(-1);

    public static void insert(String word) {
        Node curr = root;
        for (int level=0; level<word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node(1);
            } else {
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
    }

    public static String findPrefix(String key) {
        Node curr = root;
        StringBuilder sb = new StringBuilder("");
        for (int level=0; level<key.length(); level++) {
            int id = key.charAt(level) - 'a';
            sb.append(key.charAt(level));
            if (curr.children[id].freq == 1) {
                break;
            }
            curr = curr.children[id];
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // String words[] = {"zebra", "dog", "duck", "dove"};
        String words[] = {"animal", "buffalo", "cat", "dog", "elephant"};
        for (int i=0; i<words.length; i++) {
            insert(words[i]);
        }
        for (int i=0; i<words.length; i++) {
            System.out.print(findPrefix(words[i])+"  ");
        }
    }
}
