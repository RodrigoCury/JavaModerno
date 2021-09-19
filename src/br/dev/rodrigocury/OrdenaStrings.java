package br.dev.rodrigocury;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

    public static void main(String[] args) {
        List<String> palavras = new ArrayList<>();

        palavras.add("Shakira");
        palavras.add("Ao");
        palavras.add("Oa");
//        Collections.sort(palavras, new ComparadorPorTamanho());
//        palavras.sort(new ComparadorPorTamanho());
        palavras.sort((s1, s2) -> {
            return s1.length() - s2.length();
        });

        System.out.println(palavras);

        palavras.forEach(new ImprimeNaLinha());
        palavras.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        palavras.forEach(s -> System.out.println(s));
        palavras.forEach(System.out::println);
    }
}

class ComparadorPorTamanho implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return  o1.length() - o2.length();
    }
}

class ImprimeNaLinha implements Consumer<String>{
    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}
