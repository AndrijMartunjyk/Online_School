package web.dao;

import org.springframework.beans.factory.annotation.Value;

import java.lang.reflect.InvocationTargetException;

public class Driver {
    @Value("${db.driver}")
    private String driver;
    public void driver() {
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException |
                 InvocationTargetException |
                 InstantiationException |
                 IllegalAccessException |
                 NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
