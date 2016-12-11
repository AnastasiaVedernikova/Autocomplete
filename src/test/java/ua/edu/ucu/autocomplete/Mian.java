package ua.edu.ucu.autocomplete;
import ua.edu.ucu.autocomplete.*;
import ua.edu.ucu.tries.*;


import javax.xml.soap.Node;

/**
 * Created by cs.ucu.edu.ua on 09.12.2016.
 */
public class Mian {
    public static void main(String[] args){
        PrefixMatches pm = new PrefixMatches(new RWayTrie());
        pm.load("abc", "abce", "abcd", "abcde", "abcdef");
        System.out.println(pm.wordsWithPrefix("abc",3));
//        RWayTrie rWayTrie = new RWayTrie();
//        rWayTrie.add(new Tuple("abc", 3));
//        rWayTrie.add(new Tuple("abce", 4));
//        rWayTrie.add(new Tuple("abcd", 4));
//        rWayTrie.add(new Tuple("abcde", 5));
//        rWayTrie.add(new Tuple("abcef", 5));
//        System.out.println(rWayTrie.wordsWithPrefix("abc"));

    }

}
