package ua.edu.ucu.tries;

import java.util.InputMismatchException;

public final class Tuple {
    public final String term;
    public final int weight;

    public Tuple(String term, int weight) {
        if (term.length() == weight) {
            this.term = term;
            this.weight = weight;
        }else{
            throw new InputMismatchException("please try again");
        }
    }  
}