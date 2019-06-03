package org.resset.HashTableDemo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InputHelper {
    private static InputHelper ourInstance = new InputHelper();

    public StringProperty addKey = new SimpleStringProperty();
    public StringProperty addValue = new SimpleStringProperty();
    public StringProperty searchKey = new SimpleStringProperty();
    public StringProperty removeKey = new SimpleStringProperty();

    public StringProperty infoField = new SimpleStringProperty();
    public StringProperty statusField = new SimpleStringProperty();

    public static InputHelper getInstance() {
        return ourInstance;
    }

    private InputHelper() {

    }

    public static String appendText(String text, String message) {
        return text + "\n" + message;
    }
}
