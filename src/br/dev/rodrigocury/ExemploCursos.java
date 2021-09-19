package br.dev.rodrigocury;

import java.util.*;
import java.util.stream.Collectors;

public class ExemploCursos {

    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Python", 123));
        cursos.add(new Curso("JavaScript", 450));
        cursos.add(new Curso("TypeScript", 1000));
        cursos.add(new Curso("C", 69));
        cursos.add(new Curso("Java", 12));

        cursos.sort(Comparator.comparing(Curso::getAlunos));

        cursos.forEach(System.out::println);

        System.out.println(cursos.stream().filter(c -> c.getAlunos() > 150).count());
        System.out.println(cursos.stream().mapToInt(Curso::getAlunos).sum());

        Optional<Curso> optionalCurso = cursos.stream().filter(ExemploCursos::filtra).findAny();

        System.out.println(optionalCurso.orElse(null));

        cursos.stream().collect(Collectors.toMap(Curso::getNome, Curso::getAlunos)).forEach((s , i) -> {
            System.out.println(String.format("Curso %s têm %d alunos", s, i));
        });

        optionalCurso.ifPresent(System.out::println);
    }

    static boolean filtra(Curso c){
        return c.getAlunos() > 1000;
    }
}

class Curso{
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }

    @Override
    public String toString(){
        return this.getNome();
    }
}
