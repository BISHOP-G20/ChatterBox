package UI;

import Entity.DialogueManager;
import Entity.Character;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserProfileSearch extends JPanel {

    private JTextArea searchResult;
    private ImageIcon searchIcon;

    private final Character[] characters;

    private final JButton SEARCH_BUTTON = new JButton(); //change text to icon
    private final JTextField SEARCH_BAR = new JTextField();
    private final GroupLayout LAYOUT = new GroupLayout(this);
    private final Color OFFWHITE =new Color(247,247,247,255);

    public UserProfileSearch(DialogueManager dialogueManager){

        characters = dialogueManager.getCharacters();
        this.setBackground(Color.DARK_GRAY);

        instantiateJComponents();
        setIcon();
        setJComponents();
    }

    private void setJComponents(){
        SEARCH_BUTTON.setBackground(OFFWHITE);
        SEARCH_BUTTON.setIcon(searchIcon);

        LAYOUT.setAutoCreateGaps(true);
        LAYOUT.setAutoCreateContainerGaps(true);

        SEARCH_BAR.setColumns(25);
        SEARCH_BAR.setEditable(true);

        searchResult.setMaximumSize(new Dimension(this.getWidth(), 60));
        searchResult.setOpaque(false);

        LAYOUT.setHorizontalGroup(LAYOUT.createSequentialGroup().addGroup
                (LAYOUT.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(SEARCH_BAR).addComponent(searchResult))
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(SEARCH_BUTTON)));


        LAYOUT.setVerticalGroup(LAYOUT.createSequentialGroup().addGroup
                        (LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(SEARCH_BAR).addComponent(SEARCH_BUTTON))
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment
                .BASELINE).addComponent(searchResult)));

        this.setLayout(LAYOUT);
    }

    private void instantiateJComponents(){
        searchResult = new JTextArea();

        SEARCH_BUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                attemptSearch(SEARCH_BAR.getText());
            }
        });
    }

    private void setIcon(){
        searchIcon = new ImageIcon(new ImageIcon("src/Resources/SearchIcon.png")
                .getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
    }

    private void attemptSearch(String input){
        switch(input){
            case "m1key_m0use #0509", "AlderEYE #2835", "Lazarus #2703":
                searchResult.setText(input + " Status: Active");
                searchResult.setOpaque(true);
                searchResult.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(4,4,4,4, Color.BLACK),
                        BorderFactory.createMatteBorder(0,2, 2, 0, Color.GRAY)));
                this.updateUI();
                break;

            default:
                searchResult.setText("No user found!\nUse format: Username #0000");
                searchResult.setOpaque(true);
                searchResult.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createMatteBorder(4,4,4,4, Color.BLACK),
                        BorderFactory.createMatteBorder(0,2, 2, 0, Color.GRAY)));
                this.updateUI();
                break;
        }
    }
}
