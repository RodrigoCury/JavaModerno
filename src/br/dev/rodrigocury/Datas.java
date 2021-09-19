package br.dev.rodrigocury;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Datas {

    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();

        System.out.println(hoje);

        LocalDate olimpiadas = LocalDate.of(2016, Month.JUNE, 5);

        int haQuantosAnos = hoje.getYear() - olimpiadas.getYear();

        System.out.println(haQuantosAnos);

        Period period = Period.between(olimpiadas, hoje);
        System.out.println(period.getDays());

        LocalDate proximaOlimipada = olimpiadas.plusYears(4);

        DateTimeFormatter formatador  = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println(formatador.format(proximaOlimipada));
        System.out.println("Errou Otário COVID");
        System.out.println(formatador.format(proximaOlimipada.plusYears(1)));
        System.out.println("Agr sim");
    }
}
