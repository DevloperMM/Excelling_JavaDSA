package $19_HashingMaps;

import java.util.ArrayList;
import java.util.LinkedList;

public class $3_implementation {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> buckets[]; // N = buckets.length

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i=0; i<N; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldbuck[] = buckets;
            N = 2*N;
            buckets = new LinkedList[N];
            for (int i=0; i<buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i=0; i<oldbuck.length; i++) {
                LinkedList<Node> ll = oldbuck[i];
                for (int j=0; j<ll.size(); j++) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int SearchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];

            for (int i=0; i<ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return i;
                }
            }

            return -1;
        }

        public void put(K key, V value) {

            int bi = hashFunction(key); //0 to N-1
            int di = SearchInLL(key, bi); //validIdx or -1

            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double) n/N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key); //0 to N-1
            int di = SearchInLL(key, bi); //valid_idx or -1

            if (di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key); //0 to N-1
            int di = SearchInLL(key, bi); //validIdx or -1

            if (di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key); //0 to N-1
            int di = SearchInLL(key, bi); //validIdx or -1

            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();

            for (int i=0; i<buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public int size() {
            return n;
        }

        public boolean isEmpty() {
            return n == 0;
        }

    }
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        System.out.println(hm.isEmpty());

        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Nepal", 5);
        hm.put("Bhutan", 1);

        System.out.println(hm.isEmpty());

        ArrayList<String> keys = hm.keySet();
        for (String k : keys) {
            System.out.println("key = " + k + ", value = " + hm.get(k));
        }

        System.out.println(hm.size());

        System.out.println(hm.remove("China"));
        ArrayList<String> keysUpdated = hm.keySet();
        System.out.println(keysUpdated);

        System.out.println(hm.containsKey("India"));

        System.out.println(hm.get("India"));
        System.out.println(hm.get("China"));
    }
}
