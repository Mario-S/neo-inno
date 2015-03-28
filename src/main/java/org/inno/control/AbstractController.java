package org.inno.control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 *
 * @author spindizzy
 */
abstract class AbstractController implements Initializable{
    private final Context context = Context.Instance;

    protected final Context getContext() {
        return context;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        initialize(new MessageFactory(resources));
    }
    
    protected void initialize(MessageFactory factory){
        
    }
    
    
}
