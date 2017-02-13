package us.waybright.legaltasktrackerfx.controllers;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.waybright.legaltasktrackerfx.domain.Account;
import us.waybright.legaltasktrackerfx.domain.Client;
import us.waybright.legaltasktrackerfx.domain.types.PayRateType;
import us.waybright.legaltasktrackerfx.services.HibernateHelper;

/**
 *
 * @author Daniel Waybright
 */
public class FXMLController implements Initializable {
    private final Logger LOG = LoggerFactory.getLogger(FXMLController.class);
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        LOG.info("You clicked me!");
        label.setText("Hello World!");
        
        Client client = new Client("Some Guy", 1, true, "Some", "Other", "Guy");
        Account account = new Account(client, 5, PayRateType.FLAT_RATE.name(), true);
        //client.getAccounts().add(account);
        
        Task<Long> task = new Task<Long>() {
            @Override
            protected Long call() throws Exception {
                try (Session session = HibernateHelper.openSession()) {
                    session.beginTransaction();
                    session.saveOrUpdate(account);
                    session.saveOrUpdate(client);
                    session.getTransaction().commit();
                    session.flush();
                    session.close();
                }
                
                return client.getId();
            }
        };
        
        new Thread(task).start();        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
