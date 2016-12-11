package ua.edu.ucu.autocomplete;

import ua.edu.ucu.tries.Queue;
import ua.edu.ucu.tries.Trie;
import ua.edu.ucu.tries.Tuple;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class PrefixMatches {

    private Trie trie;

    public PrefixMatches(Trie trie) {
        this.trie = trie;

    }

    public int load(String... strings) {
        for (String t: strings){
            if (t.length()>2){
                this.trie.add(new Tuple(t,t.length()));
            }
        }
        return this.size();
    }

    public boolean contains(String word) {

        return this.trie.contains(word);
    }

    public boolean delete(String word) {

        return this.trie.delete(word);
    }

    public Iterable<String> wordsWithPrefix(String pref) {
        String[] m = new String[((Queue<String>)this.trie.wordsWithPrefix(pref)).size()];

        if (pref.length()>=2){

            return (Queue<String>)this.trie.wordsWithPrefix(pref);
        }
        System.out.println("pref should be longer than 2");
        return null;
    }

    public Iterable<String> wordsWithPrefix(String pref, int k) {
        Queue<String> my= new Queue<>();
        if (pref.length()>2){
            k = pref.length()+k-1;
            for (String i: ((Queue<String>)this.trie.words())){
                if  (i.length()<=k){
                    my.enqueue(i);
                }
            }
        }else if (pref.length() == 2) {
            k = 3;
            for (String i : ((Queue<String>) this.trie.words())) {
                if (i.length() >= k) {
                    my.enqueue(i);
                }
            }
        }
        return my;
    }

    public int size() {
        return this.trie.size();
    }
}
