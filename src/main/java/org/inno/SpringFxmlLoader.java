package org.inno;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import org.inno.context.AppConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author spindizzy
 */
public class SpringFxmlLoader {

    private final ApplicationContext context;

    public SpringFxmlLoader() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    public <T> T load(URL url, ResourceBundle bundle) {

        try (InputStream fxmlStream = url.openStream()) {
            FXMLLoader loader = new FXMLLoader();
            
            loader.setLocation(url);
            loader.setResources(bundle);
            
            loader.setControllerFactory((Class<?> clazz) -> {
                return context.getBean(clazz);
            });
            
            return loader.load(fxmlStream);
        } catch (IOException exc) {
            throw new IllegalArgumentException(exc);
        }
    }

}
