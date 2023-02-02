package online_school.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    private static final String EMAIL_PATTERN = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
    private static final String PHONE_NUMBER_PATTERN = "^\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";
    private static final String FIRST_OR_LAST_NAME_PATTERN = "^[А-ЯІЇЄа-яіїєa-z]+$";
    private static final String NAME_PATTERN = "^(\\S+\\s){0,3}\\S+$";
    private static final String DESCRIPTION_PATTERN = "^(\\S+\\s){2,19}\\S+$";
    public static final Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
    public static final Pattern phoneNumberPattern = Pattern.compile(PHONE_NUMBER_PATTERN);
    public static final Pattern firstOrLastNamePattern = Pattern.compile(FIRST_OR_LAST_NAME_PATTERN, Pattern.CASE_INSENSITIVE);
    public static final Pattern descriptionPattern = Pattern.compile(DESCRIPTION_PATTERN, Pattern.CASE_INSENSITIVE);
    public static final Pattern namePattern = Pattern.compile(NAME_PATTERN, Pattern.CASE_INSENSITIVE);


    public static boolean makeValidate(final String string, Pattern pattern) {
        Log.debug(RegularExpression.class.getName(), "method-> \"makeValidate\"");
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
