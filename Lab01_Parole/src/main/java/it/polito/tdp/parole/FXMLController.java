package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancella;
    
    @FXML
    private TextField txtPrestazioni;

    @FXML
    void doInsert(ActionEvent event) {
    	
    	long startTime = System.nanoTime();
    	
    	if(!txtParola.getText().equals("")) {
    		String parola = txtParola.getText();
    		elenco.addParola(parola);
    		//txtResult.setText(elenco.getElenco().toString());
    		//List<String> lista = new LinkedList<String>(elenco.getElenco());
    		txtResult.setText(stampa(elenco.getElenco()));
    		
    	}
    	
    	long estimatedTime = System.nanoTime() - startTime;
    	txtPrestazioni.setText(""+estimatedTime/1000);
    }

    @FXML
    void doReset(ActionEvent event) {
    	long startTime = System.nanoTime();
    	if(elenco.getElenco().size()!=0) {
    		elenco.reset();
    		txtParola.clear();
    		txtResult.clear();
    	}
    		
    	long estimatedTime = System.nanoTime() - startTime;
    	txtPrestazioni.setText(""+estimatedTime/1000);
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	long startTime = System.nanoTime();
    	//String p = txtParola.getText();
    	String p = txtResult.getSelectedText();
    	if(!p.equals("")) {
    		elenco.cancella(p);
    		if(elenco.getElenco().size()!=0) {
    			//txtResult.setText(elenco.getElenco().toString());
    			txtResult.setText(stampa(elenco.getElenco()));
    		}
    		else
    			txtResult.clear();
    	}
    	long estimatedTime = System.nanoTime() - startTime;
    	txtPrestazioni.setText(""+estimatedTime/1000);
    }
    
    String stampa(List<String> lista) {
    	String stringa ="";
    	for(String s : lista) {
    		if(stringa!="")
    			stringa+="\n";
    		stringa+=s;
    	}
    	return stringa;
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtPrestazioni != null : "fx:id=\"txtPrestazioni\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
