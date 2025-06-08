package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public final class DateUtils {
    private static final DateTimeFormatter STANDARD_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("MMM d yyyy, h:mm a");

    public static String toStandardTime(LocalDateTime date){
        return date.format(STANDARD_DATE_TIME_FORMATTER);
    }

    public static String timeSince(LocalDateTime date) {
        LocalDateTime now = LocalDateTime.now();

        long seconds = ChronoUnit.SECONDS.between(date, now);
        if (seconds < 60) {
            return "Just now";
        }

        long minutes = ChronoUnit.MINUTES.between(date, now);
        if (minutes < 60) {
            return minutes + " minute" + (minutes != 1 ? "s" : "") + " ago";
        }

        long hours = ChronoUnit.HOURS.between(date, now);
        if (hours < 24) {
            return hours + " hour" + (hours != 1 ? "s" : "") + " ago";
        }

        long days = ChronoUnit.DAYS.between(date, now);
        if (days < 7) {
            return days + " day" + (days != 1 ? "s" : "") + " ago";
        }

        long weeks = days / 7;
        if (weeks < 4) {
            return weeks + " week" + (weeks != 1 ? "s" : "") + " ago";
        }

        long months = weeks / 4;
        if (months < 12) {
            return months + " month" + (months != 1 ? "s" : "") + " ago";
        }

        long years = months / 12;
        return years + " year" + (years != 1 ? "s" : "") + " ago";
}

}
