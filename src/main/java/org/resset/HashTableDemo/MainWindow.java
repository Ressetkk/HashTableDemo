package org.resset.HashTableDemo;


import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainWindow {
    public TextArea infoTextArea;
    public TextArea tableViewArea;

    public TextField addKey;
    public TextField addValue;
    public TextField searchKey;
    public TextField removeKey;

    public Button searchButton;
    public Button addButton;
    public Button removeButton;

    private HashTable<String, String> table;
    public MainWindow() {
        table = new HashTable<>();
    }
    public void initialize() {
        addKey.textProperty().bindBidirectional(InputHelper.getInstance().addKey);
        addValue.textProperty().bindBidirectional(InputHelper.getInstance().addValue);
        searchKey.textProperty().bindBidirectional(InputHelper.getInstance().searchKey);
        removeKey.textProperty().bindBidirectional(InputHelper.getInstance().removeKey);
        infoTextArea.textProperty().bindBidirectional(InputHelper.getInstance().infoField);
        tableViewArea.textProperty().bindBidirectional(InputHelper.getInstance().statusField);
    }

    public void addNewKey() {
        // basic sanitization since we don't need fancy stuff here.
        if ((addKey.getText() == null) || (addValue.getText() == null)) {
            infoTextArea.setText("Key and Value field can't be null!");
        } else {
            infoTextArea.setText("Invoked add function for key : value " + addKey.getText() + " : " + addValue.getText());

            table.add(addKey.getText(), addValue.getText());

            addKey.setText(null);
            addValue.setText(null);
            tableViewArea.setText(table.returnHashTable());
        }
    }

    public void searchForKey() {
        if ((searchKey.getText() == null)) {
            infoTextArea.setText("Search Key field can't be null!");
        } else {
            infoTextArea.setText("Invoked search function for key " + searchKey.getText());
            table.get(searchKey.getText());
            tableViewArea.setText(table.returnHashTable());
        }
    }

    public void removeSelectedKey() {
        if ((removeKey.getText() == null)) {
            infoTextArea.setText("Remove Key field can't be null!");
        } else {
            infoTextArea.setText("Invoked remove function for key " + removeKey.getText());
            table.remove(removeKey.getText());
            tableViewArea.setText(table.returnHashTable());
        }
    }

}
