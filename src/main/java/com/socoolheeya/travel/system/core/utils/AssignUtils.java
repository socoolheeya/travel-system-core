package com.socoolheeya.travel.system.core.utils;


import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * The Class AssignUtils.
 *
 * @author vmavromatis
 */
public final class AssignUtils {

    /** The Constant UTF8. */
    public static final Charset UTF8 = StandardCharsets.UTF_8;

    /** The Constant DEFAULT_DATE_FORMAT. */
    public static final String DEFAULT_DATE_FORMAT = "yyyyMMdd";

    /** The Constant DEFAULT_DATE_FORMATTER. */
    public static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);

    /** The Constant DEFAULT_TIME_FORMAT. */
    public static final String DEFAULT_TIME_FORMAT = "HHmm";

    /** The Constant DEFAULT_TIME_FORMATTER. */
    public static final DateTimeFormatter DEFAULT_TIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT);

    /** The Constant DEFAULT_DATE_TIME_FORMAT. */
    public static final String DEFAULT_DATE_TIME_FORMAT = DEFAULT_DATE_FORMAT + " " + DEFAULT_TIME_FORMAT;

    /** The Constant DEFAULT_DATE_TIME_FORMATTER. */
    public static final DateTimeFormatter DEFAULT_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT);

    /** The Constant REST_FORMATTER. */
    public static final DateTimeFormatter REST_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /** The Constant ACE_DATE_FORMAT. */
    public static final String ACE_DATE_FORMAT = "dd/MM/yyyy";

    /** The Constant ACE_TIME_FORMAT. */
    public static final String ACE_TIME_FORMAT = "HH:mm";

    /** The Constant ACE_DATE_TIME_FORMAT. */
    public static final DateTimeFormatter ACE_DATE_TIME_FORMAT = DateTimeFormatter.ofPattern(ACE_DATE_FORMAT + " " + ACE_TIME_FORMAT);
    private static final int HOUR_SECONDS = 3600;
    private static final int PRICE_NUMBER_OF_DECIMALS = 2;
    private static final int PERCENTAGE_NUMBER_OF_DECIMALS = 2;

    /** The Constant COMMA_SEPARATOR. */
    public static final String COMMA_SEPARATOR = ",";

    private AssignUtils() {
    }

    /**
     * Gets the timestamp.
     *
     * @param datetime the datetime
     * @return the timestamp
     */
    public static Timestamp getTimestamp(final LocalDateTime datetime) {
        return datetime != null ? Timestamp.valueOf(datetime) : null;
    }

    /**
     * Gets the timestamp.
     *
     * @param date the date
     * @return the timestamp
     */
    public static Timestamp getTimestamp(final LocalDate date) {
        return date != null ? Timestamp.valueOf(date.atStartOfDay()) : null;
    }

    /**
     * Gets the timestamp.
     *
     * @param date the date
     * @return the timestamp
     */
    public static Timestamp getTimestamp(final ZonedDateTime date) {
        return date != null ? Timestamp.from(date.toInstant()) : null;
    }

    /**
     * Gets the local date.
     *
     * @param date the date
     * @return the local date
     */
    public static LocalDate getLocalDate(final Date date) {
        return date != null ? date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
    }

    /**
     * Gets the local time.
     *
     * @param timestamp the timestamp
     * @return the local time
     */
    public static LocalTime getLocalTime(final Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime().toLocalTime() : null;
    }

    /**
     * Gets the zoned date time.
     *
     * @param timestamp the timestamp
     * @return the zoned date time
     */
    public static ZonedDateTime getZonedDateTime(final Timestamp timestamp) {
        return timestamp != null ? ZonedDateTime.ofInstant(timestamp.toInstant(), ZoneId.systemDefault()) : null;
    }

    /**
     * Gets the date.
     *
     * @param localDateTime the local date time
     * @return the date
     */
    public static Date getDate(final LocalDateTime localDateTime) {
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    /**
     * Gets the date.
     *
     * @param localDate the local date
     * @return the date
     */
    public static Date getDate(final LocalDate localDate) {
        Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    /**
     * Gets the local date time.
     *
     * @param timestamp the timestamp
     * @return the local date time
     */
    public static LocalDateTime getLocalDateTime(final Timestamp timestamp) {
        // empty method
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }

    /**
     * Gets the local date time.
     *
     * @param date the date
     * @return the local date time
     */
    public static LocalDateTime getLocalDateTime(Date date) {
        Instant instant = Instant.ofEpochMilli(date.getTime());
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    /**
     * Gets the local date.
     *
     * @param date the date
     * @return the local date
     */
    public static LocalDate getLocalDate(final String date) {
        return getLocalDate(date, DEFAULT_DATE_FORMATTER);
    }

    /**
     * Gets the local date.
     *
     * @param date the date
     * @param formatter the formatter
     * @return the local date
     */
    public static LocalDate getLocalDate(final String date, final DateTimeFormatter formatter) {
        return date != null ? LocalDate.parse(date, formatter) : null;
    }

    /**
     * Gets the local date time.
     *
     * @param date the date
     * @return the local date time
     */
    public static LocalDateTime getLocalDateTime(final String date) {
        return getLocalDateTime(date, DEFAULT_TIME_FORMATTER);
    }

    /**
     * Gets the local time formatted.
     *
     * @param date the date
     * @return the local time formatted
     */
    public static String getLocalTimeFormatted(final LocalTime date) {
        return DEFAULT_TIME_FORMATTER.format(date);
    }

    /**
     * Gets the local date time.
     *
     * @param date the date
     * @param formatter the formatter
     * @return the local date time
     */
    public static LocalDateTime getLocalDateTime(final String date, final DateTimeFormatter formatter) {
        return date != null ? LocalDateTime.parse(date, formatter) : null;
    }

    /**
     * Gets the local date time.
     *
     * @param date the date
     * @return the local date time
     */
    public static LocalDateTime getLocalDateTime(final LocalDate date) {
        return getLocalDateTime(getTimestamp(date));
    }

    /**
     * Gets the hour difference.
     *
     * @param zoneOffset the zone offset
     * @return the hour difference
     */
    public static BigInteger getHourDifference(final ZoneOffset zoneOffset) {
        return zoneOffset != null ? BigInteger.valueOf((long) zoneOffset.get(ChronoField.OFFSET_SECONDS) / HOUR_SECONDS) : null;
    }

    /**
     * Gets the time.
     *
     * @param time the time
     * @param formatter the formatter
     * @return the time
     */
    public static LocalTime getTime(final String time, final DateTimeFormatter formatter) {
        return time != null ? LocalTime.parse(time, formatter) : null;
    }

    /**
     * Gets the string.
     *
     * @param time the time
     * @param formatter the formatter
     * @return the string
     */
    public static String getString(final LocalTime time, final DateTimeFormatter formatter) {
        return time != null ? time.format(formatter) : null;
    }

    /**
     * Gets the string.
     *
     * @param date the date
     * @param formatter the formatter
     * @return the string
     */
    public static String getString(final LocalDate date, final DateTimeFormatter formatter) {
        return date != null ? date.format(formatter) : null;
    }

    /**
     * Gets the string.
     *
     * @param dateTime the date time
     * @param formatter the formatter
     * @return the string
     */
    public static String getString(final LocalDateTime dateTime, final DateTimeFormatter formatter) {
        return dateTime != null ? dateTime.format(formatter) : null;
    }

    /**
     * Gets the string.
     *
     * @param time the time
     * @return the string
     */
    public static String getString(final LocalDate time) {
        return getString(time, DEFAULT_DATE_FORMATTER);
    }

    /**
     * Gets the zone offset.
     *
     * @param hourDifference the hour difference
     * @return the zone offset
     */
    public static ZoneOffset getZoneOffset(final BigDecimal hourDifference) {
        int auxValue = 0;
        if (hourDifference != null) {
            auxValue = hourDifference.intValue();
        }
        return ZoneOffset.ofHours(auxValue);
    }

    /**
     * Gets the string.
     *
     * @param number the number
     * @return the string
     */
    public static String getString(final Integer number) {
        return number != null ? number.toString() : null;
    }

    /**
     * Gets the string.
     *
     * @param number the number
     * @return the string
     */
    public static String getString(final Float number) {
        return number != null ? number.toString() : null;
    }

    /**
     * Gets the string.
     *
     * @param number the number
     * @return the string
     */
    public static String getString(final Double number) {
        return number != null ? number.toString() : null;
    }

    /**
     * Safe integer.
     *
     * @param number the number
     * @return the integer
     */
    public static Integer safeInteger(final BigDecimal number) {
        Integer result = null;
        if (number != null) {
            result = number.intValue();
        }
        return result;
    }

    /**
     * Safe integer.
     *
     * @param number the number
     * @return the integer
     */
    public static Integer safeInteger(final String number) {
        Integer result = null;
        if (StringUtils.hasText(number)) {
            result = Integer.parseInt(number);
        }
        return result;
    }

    /**
     * Safe big decimal.
     *
     * @param number the number
     * @param newScale the new scale
     * @return the big decimal
     */
    public static BigDecimal safeBigDecimal(final String number, final int newScale) {
        BigDecimal result = null;
        if (StringUtils.hasText(number)) {
            result = new BigDecimal(number, MathContext.DECIMAL64).setScale(newScale, RoundingMode.HALF_EVEN);
        }
        return result;
    }

    /**
     * Safe double.
     *
     * @param number the number
     * @return the double
     */
    public static Double safeDouble(final String number) {
        Double result = null;
        if (StringUtils.hasText(number)) {
            result = Double.parseDouble(number);
        }
        return result;
    }

    /**
     * Safe short.
     *
     * @param number the number
     * @return the short
     */
    public static Short safeShort(final String number) {
        Short result = null;
        if (StringUtils.hasText(number)) {
            result = Short.parseShort(number);
        }
        return result;
    }

    /**
     * Safe short with BigDecimal
     *
     * @param number the number
     * @return the short
     */
    public static Short safeShort(final BigDecimal number) {
        Short result = null;
        if (number != null) {
            result = number.shortValue();
        }
        return result;
    }

    /**
     * Safe collection.
     *
     * @param collection the collection
     * @return empty collection when given collection is null. Otherwise the given collection.
     */
    public static <T> Collection<T> safeCollection(Collection<T> collection) {
        return collection == null ? Collections.emptyList() : collection;
    }

    /**
     * Gets the big decimal for price tag.
     *
     * @param amount the amount
     * @return the big decimal for price tag
     */
    public static BigDecimal getBigDecimalForPriceTag(final Double amount) {
        if (amount == null) {
            return null;
        }
        return BigDecimal.valueOf(amount).setScale(PRICE_NUMBER_OF_DECIMALS, RoundingMode.HALF_EVEN);
    }

    /**
     * Gets the big decimal for percentage tag.
     *
     * @param amount the amount
     * @return the big decimal for percentage tag
     */
    public static BigDecimal getBigDecimalForPercentageTag(String amount) {
        return safeBigDecimal(amount, PERCENTAGE_NUMBER_OF_DECIMALS);
    }

    /**
     * Gets the big decimal for percentage tag.
     *
     * @param amount the amount
     * @return the big decimal for percentage tag
     */
    public static BigDecimal getBigDecimalForPercentageTag(Double amount) {
        if (amount == null) {
            return null;
        }
        return BigDecimal.valueOf(amount).setScale(PERCENTAGE_NUMBER_OF_DECIMALS, RoundingMode.HALF_EVEN);
    }

    /**
     * Gets the big decimal for percentage tag.
     *
     * @param amount the amount
     * @return the big decimal for percentage tag
     */
    public static BigDecimal getBigDecimalForPercentageTag(BigDecimal amount) {
        if (amount == null) {
            return null;
        }
        return amount.setScale(PERCENTAGE_NUMBER_OF_DECIMALS, RoundingMode.HALF_EVEN);
    }

    /**
     * Gets the big decimal for price tag.
     *
     * @param amount the amount
     * @return the big decimal for price tag
     */
    public static BigDecimal getBigDecimalForPriceTag(BigDecimal amount) {
        if (amount == null) {
            return null;
        }
        return amount.setScale(PRICE_NUMBER_OF_DECIMALS, RoundingMode.HALF_EVEN);
    }

    /**
     * Gets the big decimal for price tag.
     *
     * @param amount the amount
     * @return the big decimal for price tag
     */
    public static BigDecimal getBigDecimalForPriceTag(String amount) {
        return safeBigDecimal(amount, PRICE_NUMBER_OF_DECIMALS);
    }

    /**
     * Gets the big decimal for price tag.
     *
     * @param amount the amount
     * @return the big decimal for price tag
     */
    public static BigDecimal getBigDecimalForPriceTag(float amount) {
        return getBigDecimalForPriceTag(BigDecimal.valueOf(amount));
    }

    /**
     * Gets the big decimal for percentage tag.
     *
     * @param amount the amount
     * @return the big decimal for percentage tag
     */
    public static BigDecimal getBigDecimalForPercentageTag(float amount) {
        return getBigDecimalForPercentageTag(BigDecimal.valueOf(amount));
    }

    /**
     * Truncate a String to the given length with no warnings
     * or error raised if it is bigger.
     *
     * @param value String to be truncated
     * @param length Maximum length of string
     * @return Returns value if value is null or value.length() is less or equal to than length, otherwise a String representing
     *         value truncated to length.
     */
    public static String truncate(String value, int length) {
        String truncatedString = "";
        if (value != null && value.length() > length) {
            truncatedString = value.substring(0, length);
        }
        return truncatedString;
    }

    /**
     * Checks if is empty.
     *
     * @param collection the collection
     * @return true, if is empty
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * Checks if is not empty.
     *
     * @param collection the collection
     * @return true, if is not empty
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }
}
