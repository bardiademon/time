package com.bardiademon.time;

import java.time.Duration;

/**
 * @author @bardiademon
 */
public final class BTime {
    private Duration duration = Duration.ZERO;
    private static final char PATTERN_DAY = 'd', PATTERN_HOUR = 'h', PATTERN_MIN = 'm', PATTERN_SEC = 's';

    public BTime() {
    }

    public static BTime ofZero() {
        return new BTime();
    }

    public static BTime ofSeconds(final long seconds) {
        return new BTime().plusSeconds(seconds);
    }

    public static BTime ofMinutes(final long minutes) {
        return new BTime().plusMinutes(minutes);
    }

    public static BTime ofHours(final long hours) {
        return new BTime().plusHours(hours);
    }

    public static BTime ofDays(final long days) {
        return new BTime().plusDays(days);
    }

    public BTime plusSeconds() {
        return plusSeconds(1);
    }

    public BTime minusSeconds() {
        return minusSeconds(1);
    }

    public BTime plusSeconds(final long sec) {
        duration = duration.plusSeconds(sec);
        return this;
    }

    public BTime minusSeconds(final long sec) {
        if (sec < 0) {
            throw new RuntimeException("Invalid minute");
        } else if (sec == 0) {
            return this;
        } else if (sec >= duration.getSeconds()) {
            duration = Duration.ZERO;
        } else {
            duration = duration.minusSeconds(sec);
        }
        return this;
    }

    public BTime plusMinutes(final long minute) {
        if (minute < 0) {
            throw new RuntimeException("Invalid minute");
        } else if (minute == 0) {
            return this;
        }
        duration = duration.plusMinutes(minute);
        return this;
    }

    public BTime minusMinutes(final long minute) {
        if (minute < 0) {
            throw new RuntimeException("Invalid minute");
        } else if (minute == 0) {
            return this;
        }
        duration = duration.minusMinutes(minute);
        return this;
    }

    public BTime plusHours(final long hour) {
        if (hour < 0) {
            throw new RuntimeException("Invalid hour");
        } else if (hour == 0) {
            return this;
        }
        duration = duration.plusHours(hour);
        return this;
    }

    public BTime minusHours(final long hour) {
        if (hour < 0) {
            throw new RuntimeException("Invalid hour");
        } else if (hour == 0) {
            return this;
        }
        duration = duration.minusHours(hour);
        return this;
    }

    public BTime plusDays(final long day) {
        if (day < 0) {
            throw new RuntimeException("Invalid day");
        } else if (day == 0) {
            return this;
        }
        duration = duration.plusDays(day);
        return this;
    }

    public BTime minusDays(final long day) {
        if (day < 0) {
            throw new RuntimeException("Invalid day");
        } else if (day == 0) {
            return this;
        }
        duration = duration.minusDays(day);
        return this;
    }

    public void setZero() {
        this.duration = Duration.ZERO;
    }

    public long getSeconds() {
        return duration.getSeconds();
    }

    public long getMinutes() {
        return duration.toMinutes();
    }

    public long getHours() {
        return duration.toHours();
    }

    public long getDays() {
        return duration.toDays();
    }


    @Override
    public String toString() {
        return format("hh:mm:ss");
    }

    public String format(final String pattern) {

        final BTime time = new BTime();
        time.plusSeconds(getSeconds());

        // day , hour , min , sec
        long d = 0, h = 0, m = 0, s = 0;

        if (pattern.contains(String.valueOf(PATTERN_DAY))) {
            d = time.getDays();
            if (d > 0) {
                time.minusDays(d);
            }
        }

        if (pattern.contains(String.valueOf(PATTERN_HOUR))) {
            h = time.getHours();
            if (h > 0) {
                time.minusHours(h);
            }
        }

        if (pattern.contains(String.valueOf(PATTERN_MIN))) {
            m = time.getMinutes();
            if (m > 0) {
                time.minusMinutes(m);
            }
        }
        if (pattern.contains(String.valueOf(PATTERN_SEC))) {
            s = time.getSeconds();
        }

        final StringBuilder result = new StringBuilder();

        final char[] patternCharArray = pattern.toCharArray();
        boolean twoPattern = false;
        for (int i = 0, len = patternCharArray.length; i < len; i++) {
            final char patterChar = patternCharArray[i];
            if (patterChar == PATTERN_DAY) {
                twoPattern = (i + 1 < len) && patternCharArray[i + 1] == PATTERN_DAY;
                result.append(toStringOnePattern(d, twoPattern));
            } else if (patterChar == PATTERN_HOUR) {
                twoPattern = (i + 1 < len) && patternCharArray[i + 1] == PATTERN_HOUR;
                result.append(toStringOnePattern(h, twoPattern));
            } else if (patterChar == PATTERN_MIN) {
                twoPattern = (i + 1 < len) && patternCharArray[i + 1] == PATTERN_MIN;
                result.append(toStringOnePattern(m, twoPattern));
            } else if (patterChar == PATTERN_SEC) {
                twoPattern = (i + 1 < len) && patternCharArray[i + 1] == PATTERN_SEC;
                result.append(toStringOnePattern(s, twoPattern));
            } else {
                result.append(patterChar);
            }

            if (twoPattern) {
                i++;
                twoPattern = false;
            }
        }

        return result.toString();
    }

    private String toStringOnePattern(final long dhms, boolean zero) {
        if (dhms >= 10 || !zero) return String.valueOf(dhms);
        else return "0" + dhms;
    }
}
