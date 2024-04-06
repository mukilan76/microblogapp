package com.Microblog.microblog.utils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimeAgoConverter {

    public static String convertToTimeAgo(LocalDateTime timestamp) {
        LocalDateTime now = LocalDateTime.now();
        long years = timestamp.until(now, ChronoUnit.YEARS);
        long months = timestamp.until(now, ChronoUnit.MONTHS);
        long weeks = timestamp.until(now, ChronoUnit.WEEKS);
        long days = timestamp.until(now, ChronoUnit.DAYS);
        long hours = timestamp.until(now, ChronoUnit.HOURS);
        long minutes = timestamp.until(now, ChronoUnit.MINUTES);
        long seconds = timestamp.until(now, ChronoUnit.SECONDS);

        if (years > 0) {
            return years + " years ago";
        } else if (months > 0) {
            return months + " months ago";
        } else if (weeks > 0) {
            return weeks + " weeks ago";
        } else if (days > 0) {
            return days + " days ago";
        } else if (hours > 0) {
            return hours + " hours ago";
        } else if (minutes > 0) {
            return minutes + " minutes ago";
        } else {
            return seconds + " seconds ago";
        }
    }

    public static void main(String[] args) {
        // Parse the given timestamp string
        LocalDateTime timestamp = LocalDateTime.parse("2024-04-01T23:23:26.276596");

        // Convert to "time ago" format
        String timeAgo = convertToTimeAgo(timestamp);
        System.out.println(timeAgo);  // Output: "2 years ago" (assuming the current date is after 2026-04-01)
    }
}
