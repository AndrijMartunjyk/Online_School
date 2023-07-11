package my_web.utils;

import java.lang.reflect.InvocationTargetException;

public class Driver {

    public void driver() {
        try {
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException |
                 InvocationTargetException |
                 InstantiationException |
                 IllegalAccessException |
                 NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
