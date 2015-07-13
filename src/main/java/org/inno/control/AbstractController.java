package org.inno.control;

import org.inno.context.LookupProvider;
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
    private LookupProvider lookupProvider;
    
    private final Logger logger;

    AbstractController() {
        this.logger = LoggerFactory.getLogger(getClass());
    }

    protected final LookupProvider getLookupProvider() {
        return lookupProvider;
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
