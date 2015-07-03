package org.inno.control;

import org.inno.context.Context;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author spindizzy
 */
abstract class AbstractController implements Initializable{
    @Autowired
    private Context context;
    
    private final Logger logger;

    AbstractController() {
        this.logger = LoggerFactory.getLogger(getClass());
    }

    protected final Context getContext() {
        return context;
    }

    protected final Logger getLogger() {
        return logger;
    }
    
    @PostConstruct
    protected void afterPropertiesSet() {
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        initialize(new MessageFactory(resources));
    }
    
    abstract void initialize(MessageFactory factory);
    
    
}
