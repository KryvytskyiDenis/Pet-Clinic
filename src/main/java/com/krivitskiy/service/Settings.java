package com.krivitskiy.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Settings class
 */
public final class Settings {
    private static final Settings INSTANCE = new Settings();

    private final Properties properties = new Properties();

    /**
     * В конструкторе задается properties-файл настроек
     */
    private Settings() {
        try {
            properties.load(new FileInputStream(
                    this.getClass().getClassLoader().getResource("db.properties").getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Получить экземпляр класса
     *
     * @return Экземпляр
     */
    public static synchronized Settings getInstance() {
        return INSTANCE;
    }

    /**
     * Получить значение по ключу из файла настроек db.properties
     *
     * @param key ключ
     * @return value by key
     */
    public String getValue(String key) {
        return this.properties.getProperty(key);
    }
}
