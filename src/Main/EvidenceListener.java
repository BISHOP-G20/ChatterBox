package Main;

import UI.EvidencePage;
import UI.Webpage.TextPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EvidenceListener extends MouseAdapter {

    private Container container;
    private Component component;
    private Scanner cbScanner;
    private FileWriter fileWriter;
    private String highlightedText;

    private final File CLIP_BOARD = new File("src/clipboard");
    private final JPopupMenu popupMenu = new JPopupMenu("Evidence Menu");
    private final JMenuItem saveEvidence = new JMenuItem("Record Evidence");
    private final JMenuItem copy = new JMenuItem("Copy");
    private final JMenuItem paste = new JMenuItem("Paste");
    private final EvidencePage evidencePage;

    public EvidenceListener(EvidencePage evidencePage){
        this.evidencePage = evidencePage;
        setPopupMenu();
    }
    public void clearClipboard(){
        writeToClipboard("");
    }

    @Override
    public void mouseClicked(MouseEvent e){
        super.mouseClicked(e);
        if(e.getButton() == MouseEvent.BUTTON3){
            component = e.getComponent();
            if(component.getClass() == JLabel.class){
                if(((JLabel)component).getIcon() == null) {
                    highlightedText = ((JLabel) component).getText();
                    if(highlightedText != null && !highlightedText.equals("")){
                        container = (component).getParent();
                        popupMenu.show(component, e.getX(), e.getY());
                    }
                }
            }
            else if(component.getClass() == JTextArea.class){
                highlightedText = ((JTextArea) component).getSelectedText();
                if(highlightedText != null && !highlightedText.equals("")){
                    container = component.getParent();
                    popupMenu.show(component, e.getX(), e.getY());
                }
            }
            else if(component.getClass() == JTextPane.class){
                highlightedText = ((JTextPane)component).getSelectedText();
                if(highlightedText != null && !highlightedText.equals("")){
                    container = component.getParent();
                    popupMenu.show(component, e.getX(), e.getY());
                }
            }
            else if(component.getClass() == JTextField.class){
                highlightedText = ((JTextField)component).getSelectedText();
                container = component.getParent();
                popupMenu.show(component, e.getX(), e.getY());
            }
            else if(component.getClass() == TextPane.class){
                highlightedText = ((TextPane) component).getSelectedText();
                if(highlightedText != null && !highlightedText.equals("")){
                    container = component.getParent();
                    popupMenu.show(component, e.getX(), e.getY());
                }
            }
        }
    }
    private void setPopupMenu(){
        popupMenu.add(saveEvidence);
        popupMenu.add(copy);
        popupMenu.add(paste);

        saveEvidence.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(component.getClass() == JTextField.class){
                    if(highlightedText != null && !highlightedText.equals("")){
                        evidencePage.addEvidence(highlightedText, container);
                    }
                }
                else{
                    evidencePage.addEvidence(highlightedText, container);
                }
            }
        });

        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(component.getClass() == JTextField.class){
                    if(highlightedText != null && !highlightedText.equals("")){
                        writeToClipboard(highlightedText);
                    }
                }
                else {
                    writeToClipboard(highlightedText);
                }
            }
        });

        paste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(component.getClass() == JTextField.class) {
                    try {
                        ((JTextField)component).setText(readFromClipboard().strip());
                    }
                    catch (NullPointerException n){
                        n.printStackTrace();
                    }
                }
            }
        });
    }

    private void writeToClipboard(String text){
        try {
            fileWriter = new FileWriter(CLIP_BOARD);
            fileWriter.write(text);
            fileWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private String readFromClipboard(){
        String returnString = "";
        try {
            cbScanner = new Scanner(CLIP_BOARD);
            while (cbScanner.hasNext()) {
                returnString += cbScanner.next();
            }
            cbScanner.close();
        }
        catch (FileNotFoundException e){
            returnString = "FILE NOT FOUND";
        }
        return  returnString;
    }
}
