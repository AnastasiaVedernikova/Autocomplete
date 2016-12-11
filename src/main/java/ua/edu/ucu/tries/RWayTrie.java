package ua.edu.ucu.tries;

import ua.edu.ucu.*;

/**
 * Created by cs.ucu.edu.ua on 10.12.2016.
 */
public class RWayTrie implements Trie
{
    private static int R = 256; // radix
    private Node root; // root of trie
    private static class Node
    {
        private int val;
        private Node[] next = new Node[R];
    }
    private int get(String key)
    {
        Node x = get(root, key, 0);
        if (x == null) return 0;
        return x.val;
    }
    private Node get(Node x, String key, int d)
    { // Return value associated with key in the subtrie rooted at x.
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d); // Use dth key char to identify subtrie.
        return get(x.next[c], key, d+1);
    }
    private void put(String key, int val)
    { root = put(root, key, val, 0); }
    private Node put(Node x, String key, int val, int d)
    { // Change value associated with key if in subtrie rooted at x.
        if (x == null) x = new Node();
        if (d == key.length()) { x.val = val; return x; }
        char c = key.charAt(d); // Use dth key char to identify subtrie.
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }
    @Override
    public Iterable<String> words()
    { return wordsWithPrefix(""); }

    public Iterable<String> wordsWithPrefix(String pre)
    {
        Queue<String> q = new Queue<String>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }
    private void collect(Node x, String pre,
                         Queue<String> q)
    {
        if (x == null) return;
        if (x.val != 0) q.enqueue(pre);
        for (char c = 0; c < R; c++)
            collect(x.next[c], pre + c, q);
    }
    @Override
    public int size(){
        return ((Queue<String>)this.words()).size();

    }
    @Override
    public boolean contains(String word){
        boolean a = false;
        for (String i:(Queue<String>)this.words()){
            if (i.equals(word)){
                a = true;
            }
        }
        return a;
    }

    @Override
    public boolean delete(String key)
    {   if (this.contains(key)){
            root = delete(root, key, 0);
            return true;
    }else{
        return false;
    }
    }

    private Node delete(Node x, String key, int d)
    {
        if (x == null) return null;
        if (d == key.length())
            x.val = 0;
        else
        {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        }
        if (x.val != 0) return x;
        for (char c = 0; c < R; c++)
            if (x.next[c] != null) return x;
        return null;
    }
    @Override
    public void add(Tuple t){
        this.put(t.term, t.weight);
    }


}
