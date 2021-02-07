package br.com.curso.springmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URLUtil {

    public static String decodeParam(String txt){
        try {
            return URLDecoder.decode(txt, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static Date converDate(String txtDate, Date defaultDate){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return sdf.parse(txtDate);
        } catch (ParseException e) {
            return defaultDate;
        }
    }
}
