package av.util;

import java.util.ResourceBundle;

/*
* В данном классе вычитывается информация из database.properties
* Это делается с помощью класса ResourceBundle. Это стандартный механизм java,
* который позволяет вычитать файл.properties по его названию, а далее по ключу (как будто из мапки)
* достать какое-то значение
* */

public class DatabaseConfiguration {
    private static DatabaseConfiguration instance;
    private ResourceBundle resourceBundle;

    private static final String BUNDLE_NAME = "database";
    public static final String DATABASE_DRIVER_NAME = "driverName";
    public static final String DATABASE_URL = "url";
    public static final String DATABASE_LOGIN = "login";
    public static final String DATABASE_PASSWORD = "password";
    public static final String DATABASE_POOL_SIZE = "initialSize";

    public static DatabaseConfiguration getInstance() {
        if (instance == null) {
            instance = new DatabaseConfiguration();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key) {
        return (String) resourceBundle.getObject(key);
    }
}