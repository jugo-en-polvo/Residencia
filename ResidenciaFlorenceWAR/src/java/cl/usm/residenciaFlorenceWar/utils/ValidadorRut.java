package cl.usm.residenciaFlorenceWar.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorRut {

    public static Boolean validarRut(String rut) {
        rut = rut.replace(".", "");
        Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
        Matcher matcher = pattern.matcher(rut);
        if (matcher.matches() == false) {
            return false;
        }
        String[] stringRut = rut.split("-");
        return stringRut[1].toLowerCase().equals(ValidadorRut.dv(stringRut[0]));

    }

    public static String dv(String rut) {
        Integer M = 0, S = 1, T = Integer.parseInt(rut);
        for (; T != 0; T = (int) Math.floor(T /= 10)) {
            S = (S + T % 10 * (9 - M++ % 6)) % 11;
        }
        return (S > 0) ? String.valueOf(S - 1) : "k";
    }
    
    public static String formatearRut(String rut) {
        rut = rut.toUpperCase();
        int cont = 0;
        String format;
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");
        format = "-" + rut.substring(rut.length() - 1);
        for (int i = rut.length() - 2; i >= 0; i--) {
            format = rut.substring(i, i + 1) + format;
            cont++;
            if (cont == 3 && i != 0) {
                format = "." + format;
                cont = 0;
            }
        }
        return format;
    }
}
