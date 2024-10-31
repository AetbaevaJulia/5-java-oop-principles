package com.example.task01;

import java.util.HashMap;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private final String Name;
    private ImportanceLevel Level;
    private static final HashMap<String, Logger> HM = new HashMap<>();

    public Logger(String name, ImportanceLevel level) {
        Name = name;
        Level = level;
        HM.put(Name, this);
    }
    public Logger(String name) {
        Name = name;
        Level = ImportanceLevel.ERROR;
        HM.put(Name, this);
    }

    public String getName() {
        return Name;
    }

    public void setLevel(ImportanceLevel level) {
        Level = level;
    }

    public ImportanceLevel getLevel() {
        return Level;
    }

    public static Logger getLogger(String name){
        if (HM.get(name) == null) {
            HM.put(name, new Logger(name));
        }
        return HM.get(name);
    }

    public void log(ImportanceLevel level, String text){
        if (Level.ordinal() <= level.ordinal()) {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
            String message = MessageFormat.format("[{0}] {1} {2} - {3}", level, date, Name, text);
            System.out.println(message);
        }
    }

    public void log(ImportanceLevel level, String template, Object...args){
        if (Level.ordinal() <= level.ordinal()){
            System.out.println(MessageFormat.format(template, args));
        }
    }

    public void debug(String text){
        log(ImportanceLevel.DEBUG, text);
    }
    public void debug(String template, Object... args){
        log(ImportanceLevel.DEBUG, template, args);
    }

    public void info(String text){
        log(ImportanceLevel.INFO, text);
    }
    public void info(String template, Object... args){
        log(ImportanceLevel.INFO, template, args);
    }

    public void warning(String text){
        log(ImportanceLevel.WARNING, text);
    }
    public void warning(String template, Object... args){
        log(ImportanceLevel.WARNING, template, args);
    }

    public void error(String text){
        log(ImportanceLevel.ERROR, text);
    }
    public void error(String template, Object... args){
        log(ImportanceLevel.ERROR, template, args);
    }
}