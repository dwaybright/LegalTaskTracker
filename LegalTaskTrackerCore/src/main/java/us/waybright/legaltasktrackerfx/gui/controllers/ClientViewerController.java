package us.waybright.legaltasktrackerfx.gui.controllers;

import com.google.inject.Inject;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import us.waybright.legaltasktrackerfx.gui.StageManager;
import us.waybright.legaltasktrackerfx.domain.Client;
import us.waybright.legaltasktrackerfx.util.HibernateHelper;

/**
 * FXML Controller class
 *
 * @author Daniel Waybright
 */
public class ClientViewerController implements Initializable {
    private static final Logger LOG = LoggerFactory.getLogger(ClientViewerController.class);
    private StageManager stageManager;
    
    // Display Client
    @FXML private TextField displayName;
    @FXML private TextField clientNumber;
    @FXML private CheckBox activeCheckBox;
    @FXML private TextField firstName;
    @FXML private TextField middleName;
    @FXML private TextField lastName;
    private Client selectedClient;
    
    @FXML private ListView<Client> clientList;
    @FXML private CheckBox showNonActiveClientsCheckbox;
    @FXML private Button viewAccounts;
    @FXML private Button saveClientButton;
    @FXML private Label clientNumberErrorLabel;
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showNonActiveClientsCheckbox.setSelected(false);
        
        runTaskToFillClientList(true);
        
        clientList.getSelectionModel().selectedItemProperty().addListener(
            (ObservableValue<? extends Client> observable, Client oldValue, Client newValue) -> {
                selectedClient = newValue;
                displayName.setText(newValue.getDisplayName());
                clientNumber.setText(String.valueOf(newValue.getClientNumber()));
                firstName.setText(newValue.getFirstName());
                middleName.setText(newValue.getMiddleName());
                lastName.setText(newValue.getLastName());
                activeCheckBox.setSelected(newValue.isActive());
            }
        );
    }
    
    private void runTaskToFillClientList(final boolean showActiveOnly) {
        Task<List<Client>> getClientListTask = new Task<List<Client>>() {
            @Override
            protected List<Client> call() throws Exception {
                List<Client> clients = null;
                
                try {
                    Query query = HibernateHelper.getSession().createQuery("select c from Client c where c.active = :show");
                    query.setParameter("show", showActiveOnly);                    
                    clients = query.getResultList();
                    LOG.info("Found " + clients.size() + " clients with active = " + showActiveOnly + ".");
                } catch (Exception ex) {
                    LOG.error("Error loading Client list", ex);
                }
                
                return clients;
            }
        };
        
        getClientListTask.setOnSucceeded((WorkerStateEvent event) -> {
            clientList.setItems(FXCollections.observableList(getClientListTask.getValue()));            
        });
        
        new Thread(getClientListTask).start();
    }
    
    @FXML
    private void handleClientCheckBox(ActionEvent event) {
        runTaskToFillClientList(!showNonActiveClientsCheckbox.isSelected());
    }
    
    @FXML
    private void activeCheckBoxChanged(ActionEvent event) {
        if(selectedClient != null ) {
            selectedClient.setActive(activeCheckBox.isSelected());
        }
    }
    
    @FXML
    private void handleSaveClientButton(ActionEvent event) {
        if(selectedClient != null) {
            try {
                selectedClient.setClientNumber(Integer.parseInt(clientNumber.getText()));
                clientNumberErrorLabel.setVisible(false);
            } catch (NumberFormatException nfe) {
                clientNumber.setText(String.valueOf(selectedClient.getClientNumber()));
                clientNumberErrorLabel.setVisible(true);
                return;
            }
            
            selectedClient.setDisplayName(displayName.getText());
            selectedClient.setActive(activeCheckBox.isSelected());
            selectedClient.setFirstName(firstName.getText());
            selectedClient.setMiddleName(middleName.getText());
            selectedClient.setLastName(lastName.getText());
            
            saveClient(selectedClient);
        }
    }
    
    private void saveClient(final Client client) {
        Task<Void> saveClientTask = new Task<Void>() {
            @Override
            protected Void call() throws Exception {                
                try {
                    Session session = HibernateHelper.getSession();
                    session.beginTransaction();
                    session.saveOrUpdate(client);
                    session.getTransaction().commit();
                    session.flush();
                } catch (HibernateException ex) {
                    LOG.error("Error saving client", ex);
                }
                
                return null;
            }
        };
        
        saveClientTask.setOnSucceeded((WorkerStateEvent saveClientTaskEvent) -> {
            runTaskToFillClientList(showNonActiveClientsCheckbox.isSelected());           
        });
        
        new Thread(saveClientTask).start();
    }
    
    @Inject
    public void setStageManager(StageManager stageManager) {
        this.stageManager = stageManager;
    }
}
