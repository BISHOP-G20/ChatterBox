package UI;

import Entity.DialogueManager;

import javax.swing.*;
import java.awt.*;

public class UserProfile extends JPanel {

    private UserProfilePage page;
    private UserProfileSearch search;

    private final GroupLayout LAYOUT = new GroupLayout(this);

    public UserProfile(DialogueManager dialogueManager){
        page = new UserProfilePage(dialogueManager);
        search = new UserProfileSearch(dialogueManager);

        LAYOUT.setHorizontalGroup(LAYOUT.createSequentialGroup().addGroup
                        (LAYOUT.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(search))
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(page)));


        LAYOUT.setVerticalGroup(LAYOUT.createSequentialGroup().addGroup
                        (LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(search).addComponent(page)));

        this.setBackground(Color.DARK_GRAY);
        this.setLayout(LAYOUT);
    }

}
