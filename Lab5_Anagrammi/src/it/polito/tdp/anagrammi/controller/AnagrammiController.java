/**
 * Sample Skeleton for 'Anagrammi.fxml' Controller Class
 */

package it.polito.tdp.anagrammi.controller;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.lab05.model.Model;
import it.polito.tdp.lab05.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtInput"
    private TextField txtInput; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnagrammi"
    private Button btnAnagrammi; // Value injected by FXMLLoader

    @FXML // fx:id="txtOutputCorretto"
    private TextArea txtOutputCorretto; // Value injected by FXMLLoader

    @FXML // fx:id="txtOutputErrato"
    private TextArea txtOutputErrato; // Value injected by FXMLLoader

    @FXML // fx:id="btnReset"
    private Button btnReset; // Value injected by FXMLLoader

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
        String parola = txtInput.getText();
        if(parola.equals("")) {
        	txtOutputErrato.appendText("Devi inserire una parola!!!!");
        }
        else {
        	List<Parola> parole = this.model.soluzione(parola);
        	Set<String> giuste = new HashSet<String>();
        	Set<String> errate = new HashSet<String>();
        	for(Parola p : parole) {
        		if(this.model.isCorrect(p.getNome()) == true) {
        			giuste.add(p.getNome());
        		}
        		else {
        			errate.add(p.getNome());
        		}
        	}
        	for(String s : giuste) {
        		this.txtOutputCorretto.appendText(s + "\n");
        	}
        	for(String s : errate) {
        		this.txtOutputErrato.appendText(s + "\n");
        	}
        }
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtInput.clear();
    	txtOutputCorretto.clear();
    	txtOutputErrato.clear();

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnAnagrammi != null : "fx:id=\"btnAnagrammi\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtOutputCorretto != null : "fx:id=\"txtOutputCorretto\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtOutputErrato != null : "fx:id=\"txtOutputErrato\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
    
    
    public void setModel(Model model) {
    	this.model=model;
    }
}
