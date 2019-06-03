package org.resset.HashTableDemo;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.*;

public class MainWindow {
    public TextArea infoTextArea;
    public TextArea tableViewArea;

    public TextField addKey;
    public TextField addValue;
    public TextField searchKey;
    public TextField removeKey;
    public TextField capacityValue;

    public Button searchButton;
    public Button addButton;
    public Button removeButton;

    public RadioButton rb1;
    public RadioButton rb2;
    public RadioButton rb3;

    final ToggleGroup toggleGroup;

    private HashTable<String, String> table;
    public MainWindow() {
        table = new HashTable<>(10, "linear");
        toggleGroup = new ToggleGroup();

    }
    public void initialize() {
        addKey.textProperty().bindBidirectional(InputHelper.getInstance().addKey);
        addValue.textProperty().bindBidirectional(InputHelper.getInstance().addValue);
        searchKey.textProperty().bindBidirectional(InputHelper.getInstance().searchKey);
        removeKey.textProperty().bindBidirectional(InputHelper.getInstance().removeKey);
        infoTextArea.textProperty().bindBidirectional(InputHelper.getInstance().infoField);
        tableViewArea.textProperty().bindBidirectional(InputHelper.getInstance().statusField);
        capacityValue.textProperty().setValue(Integer.toString(table.getCapacity()));
        rb1.setToggleGroup(toggleGroup);
        rb1.setUserData("linear");

        rb2.setToggleGroup(toggleGroup);
        rb2.setUserData("quadratic");

        rb3.setToggleGroup(toggleGroup);
        rb3.setUserData("double");


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
            searchKey.setText(null);
            tableViewArea.setText(table.returnHashTable());
        }
    }

    public void removeSelectedKey() {
        if ((removeKey.getText() == null)) {
            infoTextArea.setText("Remove Key field can't be null!");
        } else {
            infoTextArea.setText("Invoked remove function for key " + removeKey.getText());
            table.remove(removeKey.getText());
            removeKey.setText(null);
            tableViewArea.setText(table.returnHashTable());
        }
    }
    public void updateTable() {
        int capacity = Integer.parseInt(capacityValue.getText());
        table = new HashTable<>(capacity, toggleGroup.getSelectedToggle().getUserData().toString());
        infoTextArea.setText("Created new Hash Table with updated values!");
    }
}
