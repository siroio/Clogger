package com.github.siroio.commandlog.clogger.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateGetter {

    public static String now() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return now.format(format);
    }
}
