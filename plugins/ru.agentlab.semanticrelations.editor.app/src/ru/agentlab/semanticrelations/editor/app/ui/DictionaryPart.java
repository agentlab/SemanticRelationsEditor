package ru.agentlab.semanticrelations.editor.app.ui;

import javax.annotation.PostConstruct;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class DictionaryPart {

    @PostConstruct
    void initUI(BorderPane pane) {
    	try {
			Button EnterButton = new Button();
			TextArea textbox = new TextArea();
			EnterButton.setText("Send Data");


			EnterButton.setOnAction((event) -> {
				String tmp = textbox.getText();
				Helper.handleButton(tmp);
			});

			textbox.setMaxWidth(500);
			textbox.setMaxHeight(100);
			textbox.setWrapText(true);
			textbox.setText("testing, this is my testing application");
			pane.setLeft(EnterButton);
			pane.setCenter(textbox);
		}
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
