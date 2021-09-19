package br.dev.rodrigocury;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Aluno {

     private String nome;
     private int numeroMatricula;
     private Set<Curso> cursosMatriculados = new HashSet<>();

    public Aluno(String nome, int numeroMatricula) {
        if (nome == null)
            throw new NullPointerException();
        this.nome = nome;
        this.numeroMatricula = numeroMatricula;
    }

    public void matriculaNoCurso(Curso curso){
        cursosMatriculados.add(curso);
    }

    public void desmatriculaNoCurso(Curso curso){
        cursosMatriculados.remove(curso);
    }

    public Set<Curso> getCursosMatriculados() {
        return Collections.unmodifiableSet(cursosMatriculados);
    }

    public int getTotalCursosMatriculados(){
        return cursosMatriculados.size();
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", numeroMatricula=" + numeroMatricula +
                '}';
    }

    @Override
    public boolean equals(Object o){
        try {
            Aluno outroAluno = (Aluno) o;
            return this.nome.equals(outroAluno.nome);
        } catch (ClassCastException e){
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
