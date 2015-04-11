package org.inno.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author spindizzy
 */
abstract class AbstractController implements Initializable{
    private final Context context = Context.Instance;
    
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

    @Override
    public void initialize(URL location, ResourceBundle resources){
        initialize(new MessageFactory(resources));
    }
    
    abstract void initialize(MessageFactory factory);
    
    
}
