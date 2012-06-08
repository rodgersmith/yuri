package com.hmstn.orca.Utility;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    public static <T extends Enum<T>> T findEnumValue(Class<T> enumClass, String value) throws Exception {
        return findEnumValue(enumClass, value, null);
    }

    // Convert a string value into the enumeration value
    // If the value is a number, the ordinal value will be returned
    public static <T extends Enum<T>> T findEnumValue(Class<T> enumClass, String value, T defaultValue) throws Exception {
        if (isDigits(value)) {
            return findEnumValue(enumClass, Integer.parseInt(value), defaultValue);
        }
        T result = Enum.valueOf(enumClass, value);
        if (result != null) return result;
        if (defaultValue == null) {
            throw new Exception("Enumeration " + enumClass.getSimpleName() + " does not have ordinal value " + value);
        }
        return defaultValue;
    }

    public static <T extends Enum<T>> T findEnumValue(Class<T> enumClass, Integer index) throws Exception {
        return findEnumValue(enumClass, index, null);
    }

    // Convert an integer value into the enumeration value
    // If the enumeration uses indexes, they will be used
    // Otherwise, the ordinal will be used
    public static <T extends Enum<T>> T findEnumValue(Class<T> enumClass, Integer index, T defaultValue) throws Exception {
        Method method = enumClass.getEnumConstants()[0].getClass().getMethod("index");
        for (T enumValue : enumClass.getEnumConstants()) {
            if (method == null) {
                if (index.equals(enumValue.ordinal())) {
                    return enumValue;
                }
            } else {
                if (index.equals(method.invoke(enumValue))) {
                    return enumValue;
                }
            }
        }
        if (defaultValue == null) {
            throw new Exception("Enumeration " + enumClass.getSimpleName() + " does not have ordinal value " + index);
        } else {
            return defaultValue;
        }
    }

    public static String ifEmpty(String value, String emptyValue) {
        if (value == null || value.trim().length() == 0) {
            return emptyValue;
        } else {
            return value;
        }
    }

    public static Object unsafeFindEnumValue(Class<?> enumClass, String value, Object defaultValue) throws Exception {
        if (isDigits(value)) {
            return unsafeFindEnumValue(enumClass, Integer.parseInt(value), defaultValue);
        }
        Method method = enumClass.getEnumConstants()[0].getClass().getMethod("name");
        for (Object enumValue : enumClass.getEnumConstants()) {
            if (value.equals(method.invoke(enumValue))) {
                return enumValue;
            }
        }
        if (defaultValue == null) {
            throw new Exception("Enumeration " + enumClass.getSimpleName() + " does not have ordinal value " + value);
        }
        return defaultValue;
    }

    public static Object unsafeFindEnumValue(Class<?> enumClass, Integer index, Object defaultValue) throws Exception {
        Class<?> valueClass = enumClass.getEnumConstants()[0].getClass();
        Method method = valueClass.getMethod("index");
        if (method == null) method = valueClass.getMethod("ordinal");
        for (Object enumValue : enumClass.getEnumConstants()) {
            if (index.equals(method.invoke(enumValue))) {
                return enumValue;
            }
        }
        if (defaultValue == null) {
            throw new Exception("Enumeration " + enumClass.getSimpleName() + " does not have ordinal value " + index);
        } else {
            return defaultValue;
        }
    }

//    public static <T, U> void removeFromList(List<T> list, U compareValue, ICompareObjects<T, U> comparer) throws Exception {
//        for (int index = 0; index < list.size(); ) {
//            if (!comparer.compare(list.get(index), compareValue)) {
//                index++;
//            } else {
//                list.remove(index);
//            }
//        }
//    }

    public static DateTime parseDateTime(String value) throws Exception {
        Boolean isParsed = false;
        DateTime result = null;
        String[] patterns = {
                "yyyy-MM-dd HH:mm:ss",
                "yyyy-MM-dd HH:mm:ss a",
                "yyyy-MM-dd",
                "MM/dd/yyyy HH:mm:ss a",
                "MM/dd/yyyy HH:mm:ss",
                "MM/dd/yyyy"
        };
        for (Integer index = 0; index < patterns.length && !isParsed; index++) {
            try {
                DateTimeFormatter parser = DateTimeFormat.forPattern(patterns[index]);

                result = parser.parseDateTime(value);
                isParsed = true;
            } catch (Exception ex) {
                isParsed = false;
            }
        }
        if (!isParsed) {
            result = DateTime.parse(value);
        }
        return result;
    }

    static public String makeString(Integer value) {
        if (value == null) {
            return "";
        } else {
            return value.toString();
        }
    }

    static public String makePhone(String areaCode, String subscriber) {
        String result = "";
        if (subscriber != null && subscriber.length() > 0) {
            subscriber = numberOnly(subscriber);
            result = trimString(areaCode);
            if (result.length() > 0) result = "(" + result + ") ";
            subscriber = "0000000".substring(0, 7 - subscriber.length()) + subscriber;
            result += subscriber.substring(0, 3) + "-" + subscriber.substring(3);
        }
        return result;
    }

    static public Boolean isDigits(String value) {
        if (value == null || value.length() == 0) {
            return false;
        }
        for (Character c : value.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    static public String numberOnly(String source) {
        StringBuilder buffer = new StringBuilder();
        if (source != null) {
            for (Integer index = 0; index < source.length(); index++) {
                if (Character.isDigit(source.charAt(index)) || source.charAt(index) == '-' || source.charAt(index) == '.') {
                    buffer.append(source.charAt(index));
                }
            }
        }
        if (buffer.length() == 0) buffer.append("0");
        return buffer.toString();
    }


    static public Boolean toBoolean(String value) {
        if (value == null) return false;
        value = value.trim();
        return value.equalsIgnoreCase("true")
                || value.equalsIgnoreCase("yes")
                || value.equalsIgnoreCase("y")
                || toInteger(value) > 0;
    }

    static public <T extends Enum> Integer toInteger(T value) throws Exception {
        Method method = value.getClass().getMethod("index");
        if (method != null) {
            return (Integer) method.invoke(value);
        }
        return value.ordinal();

    }

    static public Integer toInteger(Integer value) {
        return value == null ? 0 : value;
    }

    static public Integer toInteger(String value) {
        return Integer.parseInt(numberOnly(value));
    }

    static public Boolean isEmpty(String value) {
        return value == null || value.length() == 0;
    }

    static public Boolean isAllUpper(String value) {
        Boolean retval = false;
        if (value != null && value.length() > 0) {
            retval = true;
            for (char test : value.toCharArray()) {
                if (Character.isLowerCase(test)) {
                    retval = false;
                    break;
                }
            }
        }
        return retval;
    }

    static public String trimString(String value) {
        if (value == null) value = "";
        return value.trim();
    }

    static public String toUpper(String value) {
        if (value == null) return "";
        return value.toUpperCase();
    }


    public static Boolean convertToBoolean(String value) {
        return value != null && value.trim().toUpperCase().equals("Y");
    }

    public static Boolean convertToBoolean(Integer value) {
        return value != null && !value.equals(0);
    }

    public static Integer ConvertBooleanToInteger(Boolean value) {
        if (value == null) return null;
        if (value.equals(true)) {
            return 1;
        } else {
            return 0;
        }
    }

    public static Integer makeTime(DateTime value) {
        if (value == null) return null;
        return Integer.parseInt(value.toString("HHmm"));
    }

    public static Boolean isValidDate(DateTime value) {
        return value != null && value.getYear() > 1;
    }

    public static DateTime toDateTime(DateTime value) {
        return value != null && value.getYear() > 1 ? value : new DateTime(0);
    }

    public static DateTime toDateTime(DateTime datePart, DateTime timePart) {
        DateTime result = makeDateTime(datePart, timePart);
        if (result == null) result = new DateTime(0);
        return result;
    }


    public static DateTime toDateTime(DateTime value, Integer timePart, String format) {
        DateTime result = makeDateTime(value, timePart, format);
        if (result == null) result = new DateTime(0);
        return result;
    }

    public static DateTime toDateTime(DateTime value, BigDecimal timePart, String format) {
        if (value == null) return new DateTime(0);
        if (timePart == null) return value;
        return toDateTime(value, timePart.intValue(), format);
    }

    public static String toDateString(DateTime value) {
        return isValidDate(value) ? value.toString(ISODateTimeFormat.basicDate()) : "";
    }

    public static String toDateTimeString(DateTime value) {
        return isValidDate(value) ? value.toString(ISODateTimeFormat.dateTime()) : "";
    }

    public static DateTime makeDateTime(DateTime datePart, DateTime timePart) {
        DateTime result = null;
        if (isValidDate(datePart)) {
            if (timePart == null) {
                result = datePart.withTime(0, 0, 0, 0);
            } else {
                Integer hour = timePart.getHourOfDay();
                Integer minute = timePart.getMinuteOfHour();
                Integer second = timePart.getSecondOfMinute();
                try {
                    result = datePart.withTime(hour, minute, second, 0);
                } catch (Exception ex) {
                    System.out.println("Datepart=" + datePart + ", Timepart=" + timePart);
                    ex.printStackTrace();
                    result = datePart;
                }
            }
        }
        return result;
    }

    /**
     * Convert date and time to a datetime
     * The format flag can be "M" for minutes (HHMM format) or
     * "S" for seconds "HHMMSS" format
     *
     * @param datePart
     * @param timePart
     * @param format
     * @return
     */
    public static DateTime makeDateTime(DateTime datePart, Integer timePart, String format) {
        DateTime result = null;
        if (isValidDate(datePart)) {
            if (timePart == null) {
                result = datePart.withTime(0, 0, 0, 0);
            } else {
                Integer parts = timePart;
                Integer second = 0;
                if (format.equalsIgnoreCase("S")) {
                    second = parts % 100;
                    parts = parts / 100;
                }
                Integer minute = parts % 100;
                parts = parts / 100;
                Integer hour = parts;
                if (hour > 24) {
                    System.out.println("WARNING:  Time hour is greater than 24: " + timePart);
                } else {
                    hour = hour % 24;
                }
                result = datePart.withTime(hour, minute, second, 0);
            }
        }
        return result;
    }

    public static DateTime makeDateTime(Integer date, Integer time, String format) {
        DateTime result = null;
        if (date == null) return null;
        Integer day = date % 100;
        date = date / 100;
        Integer month = date % 100;
        date = date / 100;
        Integer year = date;
        year = year < 39 ? 2000 + year : 1900 + year;
        return makeDateTime(new DateTime(year, month, day, 0, 0, 0), time, format);
    }

    // Convert database time to UTC
    public static DateTime databaseToUtc(DateTime timestamp) {
        DateTime result = null;
        if (isValidDate(timestamp)) {
            result = timestamp.toDateTime(DateTimeZone.UTC);
        }
        return result;
    }

    public static DateTime databaseToUtc(DateTime datePart, DateTime timePart) {
        DateTime result = makeDateTime(datePart, timePart);
        if (result != null) {
            result = result.toDateTime(DateTimeZone.UTC);
        }
        return result;
    }

    public static DateTime databaseToUtc(DateTime datePart, Integer timePart, String format) {
        DateTime result = makeDateTime(datePart, timePart, format);
        if (result != null) {
            result = result.toDateTime(DateTimeZone.UTC);
        }
        return result;
    }

    public static DateTime databaseToUtc(Integer datePart, Integer timePart, String format) {
        DateTime result = makeDateTime(datePart, timePart, format);
        if (result != null) {
            result = result.toDateTime(DateTimeZone.UTC);
        }
        return result;
    }

    public static DateTime databaseToUtc(DateTime datePart, String timePart, String format) {
        Integer processedTimePart = null;

        if (timePart != null) {
            timePart = timePart.replace(":", "");
            processedTimePart = Integer.parseInt(timePart.substring(0, 4));
        }

        DateTime result = makeDateTime(datePart, processedTimePart, format);
        if (result != null) {
            result = result.toDateTime(DateTimeZone.UTC);
        }

        return result;
    }

    public static BigDecimal toDecimal(String sDecimal) {
        return new BigDecimal(numberOnly(sDecimal));
    }

    public static BigDecimal toDecimal(BigDecimal value) {
        if (value == null) return new BigDecimal(0);
        return value;
    }

//    public static String ageFormatter(DateTime dateOfBirth) {
//        if (isValidDate(dateOfBirth)) {
//            DateDifference dateDiff = new DateDifference();
//            return dateDiff.returnFormattedAge(dateOfBirth, new DateTime());
//        }
//        return "";
//    }

    /// <summary>
    /// Strip of trailing zero after the decimal point
    /// If no valid zeros after the decimal point, remove the decimal point
    /// </summary>
    /// <param name="value"></param>
    /// <returns></returns>
    public static String stripPostDecimalZero(String value) {
        if (value != null && value.indexOf('.') >= 0) {
            Integer index = value.length() - 1;
            while (value.charAt(index) == '0') {
                index--;
            }
            if (value.charAt(index) == '.') {
                index--;
            }
            // If no more trailing zeros, remove the decimal point
            value = value.substring(0, index + 1);
        }
        return value;
    }

    public static String joinStrings(String separator, String... args) {
        StringBuilder value = new StringBuilder();
        for (String str : args) {
            if (str != null) {
                str = str.trim();
                if (str.length() > 0) {
                    if (value.length() > 0) value.append(separator);
                    value.append(str);
                }
            }
        }
        return value.toString();
    }

    public static String joinStrings(String separator, List<String> args) {
        StringBuilder value = new StringBuilder();
        for (String str : args) {
            if (str != null) {
                str = str.trim();
                if (str.length() > 0) {
                    if (value.length() > 0) value.append(separator);
                    value.append(str);
                }
            }
        }
        return value.toString();
    }

    public static String joinAllStrings(String separator, String... args) {
        StringBuilder value = new StringBuilder();
        for (String str : args) {
            if (value.length() > 0) value.append(separator);
            value.append(trimString(str));
        }
        return value.toString();
    }

    public static String joinAllStrings(String separator, List<String> args) {
        StringBuilder value = new StringBuilder();
        for (String str : args) {
            if (value.length() > 0) value.append(separator);
            value.append(trimString(str));
        }
        return value.toString();
    }

    public static String joinIntegers(String separator, List<Integer> args) {

        //Return null if the List is empty
        if(args==null || args.size()==0)
            return null;

        String value = "";
        for (Integer val : args) {
            if (value.length() > 0) {
                value += separator;
            }
            value += val.toString();
        }
        return value ;
    }

//    public static String[] SplitName(String name) {
//        return Name.splitName(name);
//    }

    public static Boolean isNullOrEmpty(String param) {
        return param == null || param.trim().length() == 0;
    }

    public static <T> T ifNull(T test, T... defaultValue) {
        if (test != null) return test;
        for (T def : defaultValue) {
            if (def != null) return def;
        }
        return null;
    }

    public static String ifNullOrEmpty(String test, String... defaultValue) {
        if (!isNullOrEmpty(test)) return test;
        for (String def : defaultValue) {
            if (!isNullOrEmpty(def)) return def;
        }
        return null;
    }

    public static Integer compareDates(DateTime d1, DateTime d2) {
        if (d1 == null && d2 == null) return 0;
        if (d1 == null) return -1;
        if (d2 == null) return 1;
        return d1.compareTo(d2);
    }

    @SuppressWarnings("unchecked")
    public static <T> T unsafeCast(Object o) {
        return (T) o;
    }

    public static Date getSqlDateInFormat(DateTime dt, SimpleDateFormat format) throws Exception {
        return dt != null ? new Date((format.parse(dt.toString())).getTime()) : null;
    }

//    public static <T> List<T> searchIn(List<T> list, IMatcher<T> m) throws Exception {
//        List<T> r = new ArrayList<T>();
//        for (T t : list) {
//            if (m.matches(t)) {
//                r.add(t);
//            }
//        }
//        return r;
//    }

    public static Integer getDecimalPosition(String str) {
        if (!isNullOrEmpty(str)) {
            String[] comp = str.split("\\.");
            if (comp.length == 2) {
                int index = str.indexOf(".");
                return index < 0 ? 0 : (str.length() - 1 - index);
            }
        }
        return 0;
    }

    public static Boolean isDecimal(String str) {
        String value = trimString(str);
        int count = 0;
        if (!isNullOrEmpty(value)) {
            for (Character c : value.toCharArray()) {
                if (Character.isDigit(c) || c == '.') {
                    count++;
                }
            }
            if (count == value.length()) {
                return value.split("\\.").length <= 2;
            }
        }
        return false;
    }

    public static String convertObjectToJSON(Object obj) throws JsonGenerationException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    public static Boolean liesWithinDates(DateTime startDateTime, DateTime endDateTime, DateTime value) {
        return (value.isAfter(startDateTime) || value.compareTo(startDateTime) ==0 )
                &&
                value.isBefore(endDateTime) || value.compareTo(endDateTime) ==0;
    }

    public static <T> List<T> searchIn( List<T> list , IMatcher<T> m ) throws Exception {
        Boolean match = false;
        List<T> r = new ArrayList<T>();
        for( T t : list ) {
            match = m.matches( t );
            if (match)
                r.add( t );

        }
        return r;
    }
}

