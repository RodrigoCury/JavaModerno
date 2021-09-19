package br.dev.rodrigocury;

import br.dev.rodrigocury.utils.StringUtils;

public class Aula implements Comparable<Aula>{
    private String titulo;
    private int tempo;
    private int numeroDaAula = -1;

    public Aula(String titulo, int tempo){
        this.titulo = StringUtils.capitalize(titulo);
        this.tempo = tempo;
    }

    public int getTempo() {
        return tempo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getNumeroDaAula() {
        return numeroDaAula;
    }

    public void setNumeroDaAula(int numeroDaAula) {
        this.numeroDaAula = numeroDaAula;
    }

    @Override
    public String toString(){
        return String.format("Aula: %s - duração: %dmin; #%d", this.titulo, this.tempo, this.numeroDaAula);
    }

    @Override
    public int compareTo(Aula outraAula) {
        return Integer.compare(this.numeroDaAula, outraAula.numeroDaAula);
    }
}
