package com.snailvoyager.springbootnavermap.util;

import java.util.regex.Pattern;

public class EscapeSequence {
    private final static Pattern ESCAPE_PATTERN = Pattern.compile("\n|\r|\t|\b|\\\\");

    public static String removeEscapeSequences(String str) {
        return str.replace("\r", "")
                .replace("\n", "")
                .replace("\t", "")
                .replace("\b", "")
                .replace("\\", "")
                .replace("\"", "\\\"")
                .trim();
    }

    public static String removeEscapeSequencesByPattern(String str) {
        return ESCAPE_PATTERN.matcher(str).replaceAll("")
                .replace("\"", "\\\"");
    }
}