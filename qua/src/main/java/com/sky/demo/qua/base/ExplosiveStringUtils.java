package com.sky.demo.qua.base;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.sky.demo.qua.annotation.Difficulty;
import com.sky.demo.qua.annotation.Exercise;


import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

/**
 * StringUtils is tend to be explosive, and thus hard to manage. Let's see how we can implement them with the help of
 * guava
 * 
 * @author sy
 */
@Exercise(name = "ExplosiveStringUtils", related = { CharMatcher.class, Splitter.class, Joiner.class }, difficulty = Difficulty.NORMAL)
public abstract class ExplosiveStringUtils {

    private ExplosiveStringUtils() {
    }

    /**
     * Check whether the given String is all numeric characters
     * 
     * @param str the String to check (may be {@code null})
     * @return {@code true} if the String is empty or the characters of it are all numeric
     */
    public static boolean allNumeric(String str) {
        // TODO implement this
        Preconditions.checkNotNull(str);
    	return CharMatcher.DIGIT.matchesAllOf(str);
    }

    /**
     * Check whether the given String is a serial number( formed only by number and hyphen '-')
     * 
     * @param str the String to check (may be {@code null})
     * @return {@code true} if the String is either an serial number or empty
     */
    public static boolean isAnSerialNumber(String str) {
        // TODO implement this
        Preconditions.checkNotNull(str);
        //return CharMatcher.is('-').or(CharMatcher.DIGIT).matchesAllOf(str);
        return CharMatcher.DIGIT.or(CharMatcher.is('-')).matchesAllOf(str);
    }

    /**
     * Check whether the given String contains any whitespace characters.
     * 
     * @param str the String to check (may be {@code null})
     * @return {@code true} if the String is not empty and contains at least 1 whitespace character
     */
    public static boolean containsWhitespace(@Nullable String str) {
        // TODO implement this
        Preconditions.checkNotNull(str);
    	return CharMatcher.WHITESPACE.matchesAnyOf(str);
    }

    /**
     * Trim leading and trailing whitespace from the given String.
     * 
     * @param str the String to check
     * @return the trimmed String
     */
    public static String trimWhitespace(@Nullable String str) {
        // TODO implement this
        Preconditions.checkNotNull(str);
    	return CharMatcher.WHITESPACE.trimFrom(str);
    }

    /**
     * Trim <i>all</i> whitespace from the given String: leading, trailing, and in-between characters.
     * 
     * @param str the String to check
     * @return the trimmed String
     */
    public static String trimAllWhitespace(@Nullable String str) {
        // TODO implement this
        Preconditions.checkNotNull(str);
    	return CharMatcher.WHITESPACE.removeFrom(str);
    }

    /**
     * Trim leading whitespace from the given String.
     * 
     * @param str the String to check
     * @return the trimmed String
     */
    public static String trimLeadingWhitespace(@Nullable String str) {
        // TODO implement this
        Preconditions.checkNotNull(str);
    	return CharMatcher.WHITESPACE.trimLeadingFrom(str);
    }

    /**
     * Trim trailing whitespace from the given String.
     * 
     * @param str the String to check
     * @return the trimmed String
     */
    public static String trimTrailingWhitespace(@Nullable String str) {
        // TODO implement this
        Preconditions.checkNotNull(str);
    	return CharMatcher.WHITESPACE.trimTrailingFrom(str);
    }

    /**
     * Returns an string containing all the ascii and digit chars of the given String
     * 
     * @param str the String to retain from
     * @return a new String retaining all ascii and digit chars from the original one
     */
    public static String retainAllAsciiAndDigit(@Nullable String str) {
        // TODO implement this
    	Preconditions.checkNotNull(str);
    	return CharMatcher.ASCII.or(CharMatcher.DIGIT).retainFrom(str);
    }

    /**
     * <p>
     * Joins the elements of the provided {@code Iterable} into a single String containing the provided elements.
     * </p>
     * 
     * @param iterable the {@code Iterable} of values to join together, may be null
     * @param separator the separator character to use, null treated as ""
     * @return the joined String, {@code null} if null iterable input
     */
    public static <T> String join(Iterable<T> iterable, @Nullable String separator) {
        // TODO implement this
    	Preconditions.checkNotNull(iterable);
    	return Joiner.on(separator).join(iterable);
    }

    /**
     * <p>
     * Joins the elements of the provided {@code Iterable} into a single String containing all the <i>not-null</i>
     * elements provided
     * </p>
     * 
     * @param iterable the {@code Iterable} of values to join together, may be null
     * @param separator the separator character to use, null treated as ""
     * @return the joined String, {@link null} if null iterable input
     */
    public static <T> String joinAndIgnoreNull(Iterable<T> iterable, @Nullable String separator) {
        // TODO implement this
        Preconditions.checkNotNull(iterable);
    	return Joiner.on(separator).skipNulls().join(iterable);
    }

    /**
     * 
     * Collapses all non-ascii characters and trim all the matching characters at the start of end of the result
     * 
     * @param string the String to collapse from
     * @param replacement the String to replace all the non-ascii
     */
    public static String trimAndCollapseAllNonAsciiWith(String string, char replacement) {
        // TODO implement this
        Preconditions.checkNotNull(string);
        Preconditions.checkNotNull(replacement);
    	return CharMatcher.ASCII.negate().trimAndCollapseFrom(string, replacement);
    }

    /**
     * Remove any character in a given String.
     * 
     * @param str the original String
     * @param charsToRemove a set of characters to remove. E.g. "az\n" will delete 'a's, 'z's and new lines.
     * @return the resulting String
     */
    public static String remove(String str, String charsToRemove) {
        // TODO implement this
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(charsToRemove);
    	return CharMatcher.anyOf(charsToRemove).removeFrom(str);
    }

    /**
     * Convert a CSV list into an List of Strings.
     * 
     * @param str the input String
     * @return an array of Strings, or the empty array in case of empty input
     */
    public static List<String> commaDelimitedListToStringList(String str) {
        // TODO implement this
        Preconditions.checkNotNull(str);
    	return Splitter.on(',').splitToList(str);
    }

    /**
     * Converts a Iterable to a CSV String.
     * 
     * @param iterable the Collection to display
     * @return the delimited String
     */
    public static String iterableToCommaDelimitedString(Iterable<?> iterable) {
        // TODO implement this
        Preconditions.checkNotNull(iterable);
    	return Joiner.on(',').join(iterable);
    }

    /**
     * Converts a map to string with ',' as entry separator and ':' as key-value separator E.g key1:value1,key2:value2
     * 
     * @param map the map to convert
     * @return the converted String
     */
    public static String mapToString(Map<?, ?> map) {
        // TODO implement this
        Preconditions.checkNotNull(map);
    	
    	Joiner.MapJoiner mapJoiner = Joiner.on(',').withKeyValueSeparator(":");
    	return mapJoiner.join(map);
    }
}
