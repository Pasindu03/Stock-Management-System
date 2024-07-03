package org.example.sms.regex;

import java.util.regex.Pattern;

public class Regex {
    private static Regex regex;

    private final Pattern namePattern;
    private final Pattern emailPattern;

    private Regex(){
        namePattern = Pattern.compile("");
        emailPattern = Pattern.compile("");
    }

    public static Regex getInstance(){return (regex == null ) ? regex = new Regex() : regex;}

    public Pattern getPattern(Types types){
        switch (types){
            case NAME :
                return namePattern;
            case EMAIL:
                return emailPattern;
        }
        return null;
    }
}
