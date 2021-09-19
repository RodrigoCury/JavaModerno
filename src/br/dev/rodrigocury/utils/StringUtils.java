package br.dev.rodrigocury.utils;

public class StringUtils {
    public static String capitalize(String string){
        String toReturn = "";
        String[] strings = string.trim().split("( )+");
        for (int i = 0; i < strings.length ; i++) {
            String space = i == 0 ? "" : " ";
            toReturn = toReturn.concat(space + strings[i].substring(0,1).toUpperCase() + strings[i].substring(1).toLowerCase());
        }
        return toReturn;
    }
}