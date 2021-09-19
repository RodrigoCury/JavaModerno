package br.dev.rodrigocury;

import br.dev.rodrigocury.utils.StringUtils;

import java.util.*;

public class Curso {
    private int tempoTotal;
    private String nome;
    private String instrutor;
    private List<Aula> aulas = new LinkedList<>();
    private Set<Aluno> alunos = new HashSet<>();
    private Map<Integer, Aluno> matriculaParaAlunos = new HashMap<>();

    public Curso(String nome, String instrutor) {
        this.nome = StringUtils.capitalize(nome);
        this.instrutor = StringUtils.capitalize(instrutor);
    }

    public String getNome() {
        return nome;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public List<Aula> getAulas() {
        return Collections.unmodifiableList(this.aulas);
    }

    public Set<Aluno> getAlunos() { return Collections.unmodifiableSet(this.alunos); }

    public void add(Aula aula) {
        aula.setNumeroDaAula(this.aulas.size() + 1);
        this.aulas.add(aula);
        this.tempoTotal += aula.getTempo();
    }

    public void add(Aluno aluno) {
        this.alunos.add(aluno);
        aluno.matriculaNoCurso(this);
        matriculaParaAlunos.put(aluno.getNumeroMatricula(), aluno);
    }

    public void add(Aula... aulas) {
        List.of(aulas).forEach(this::add);

    }

    public void add(Aluno... alunos) {
        List.of(alunos).forEach(this::add);
    }

    public int getTotalAulas() {
        return this.aulas.size();
    }

    public int getTotalAlunos() {
        return this.alunos.size();
    }

    public int getTempoTotal() {
        return this.tempoTotal;
    }

    public boolean estaMatriculado(Aluno aluno){
        return  this.alunos.contains(aluno);
    }

    public boolean temAAula(Aula aula){
        return this.aulas.contains(aula);
    }

    @Override
    public String toString() {
        String toPrint = String.format("Curso: %s - instrutor: %s \nAulas:\n", this.nome, this.instrutor);
        for (Aula aula :
                this.aulas) {
            toPrint = toPrint.concat(aula.toString() + "\n");
        }
        return toPrint;
    }

    public Aluno buscaMatriculado(int nMatricula) {
        return matriculaParaAlunos.get(nMatricula);
//        for (Aluno aluno: alunos){
//            if (aluno.getNumeroMatricula() == nMatricula)
//                return aluno;
//        }
//        throw new NoSuchElementException();
    }
}
