package com.jonas.one;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Ayes {

    @Test
    public void a() {
        LocalDate date = LocalDate.now();
        LocalDate date1 = LocalDate.of(2019, 1, 16);
        LocalDate a = date1.plusDays(270L);
        System.out.println(date1);
        System.out.println(a);

        String S = "dadasdasdghyklo";
        String J = "ase";
        char[] c = S.toCharArray();
        Map<Character, Integer> stones = new HashMap<>();
        for (char s : c) {
            if (stones.containsKey(s)) {
                stones.put(s, stones.get(s) + 1);
            } else {
                stones.put(s, 1);
            }
        }
        S.replace(".","[.]");
        int number = 0;
        for(int i = 0;i<S.length();i++){
            String t = S.substring(i,i+1);
            if(J.indexOf(t)!=-1){
                number++;
            }
        }


        System.out.println(number);

    }

}
