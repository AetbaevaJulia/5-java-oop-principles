package com.example.task03;

/**
 * Класс, в котором собраны методы для работы с {@link TimeUnit}
 */
public class TimeUnitUtils {
    public static Milliseconds toMillis(Seconds seconds) {
        return new Milliseconds(seconds.toMillis());
    }
    public static Milliseconds toMillis(Minutes min) {
        return new Milliseconds(min.toMillis());
    }
    public static Milliseconds toMillis(Hours h) {
        return new Milliseconds(h.toMillis());
    }

    public static Seconds toSeconds(Milliseconds millis) {
        return new Seconds(millis.toSeconds());
    }
    public static Seconds toSeconds(Minutes min) {
        return new Seconds(min.toSeconds());
    }
    public static Seconds toSeconds(Hours h) {
        return new Seconds(h.toSeconds());
    }

    public static Minutes toMinutes(Milliseconds millis) {
        return new Minutes(millis.toMinutes());
    }
    public static Minutes toMinutes(Seconds s) {
        return new Minutes(s.toMinutes());
    }
    public static Minutes toMinutes(Hours h) {
        return new Minutes(h.toMinutes());
    }

    public static Hours toHours(Milliseconds milliseconds) {
        return new Hours(milliseconds.getHours());
    }
    public static Hours toHours(Seconds s) {
        return new Hours(s.getHours());
    }
    public static Hours toHours(Minutes min) {
        return new Hours(min.getHours());
    }
}
