package UI;

import Entity.DialogueManager;
import Entity.Player;
import Main.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Main.GameFrame.*;

public class NewAccountPage extends JPanel {

    private final GameFrame gameFrame;
    private final DialogueManager dialogueManager;
    private final Player player;

    private final JPanel TITLE_PANEL = new JPanel();
    private final JPanel FIELD_PANEL = new JPanel();
    private final JPanel BUTTON_PANEL = new JPanel();
    private final JLabel TITLE = new JLabel("New Account");
    private final JLabel[] INPUT_INFO = new JLabel[2];
    private final JTextField[] INPUT_FIELDS = new JTextField[2];
    private final JButton SUBMIT_BUTTON = new JButton("Submit");
    private final Font LABEL_FONT = new Font("Arial", Font.BOLD, 15);
    private final Font TITLE_FONT = new Font("Ravie", Font.PLAIN, 30);
    private final Font INPUT_FONT = new Font("Arial", Font.PLAIN, 12);
    private final GroupLayout LAYOUT = new GroupLayout(this);
    private final GroupLayout TITLE_LAYOUT = new GroupLayout(TITLE_PANEL);
    private final GroupLayout FIELD_LAYOUT = new GroupLayout(FIELD_PANEL);
    private final GroupLayout BUTTON_LAYOUT = new GroupLayout(BUTTON_PANEL);

    public NewAccountPage(GameFrame gameFrame){

        this.gameFrame = gameFrame;
        this.setPreferredSize(GAME_DIMENSION);

        dialogueManager = gameFrame.getDialogueManager();
        player = dialogueManager.getPlayer();

        setComponents();
        setLayout();
    }

    private void setLayout(){
        TITLE_PANEL.setLayout(TITLE_LAYOUT);
        TITLE_LAYOUT.setAutoCreateGaps(true);
        TITLE_LAYOUT.setAutoCreateContainerGaps(true);
        TITLE_LAYOUT.setHorizontalGroup(TITLE_LAYOUT.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(TITLE));
        TITLE_LAYOUT.setVerticalGroup(TITLE_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(TITLE));

        FIELD_PANEL.setLayout(FIELD_LAYOUT);
        FIELD_LAYOUT.setAutoCreateGaps(true);
        FIELD_LAYOUT.setAutoCreateContainerGaps(true);
        FIELD_LAYOUT.setHorizontalGroup(FIELD_LAYOUT.createSequentialGroup()
                .addGroup(FIELD_LAYOUT.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(INPUT_INFO[0])
                                .addComponent(INPUT_INFO[1]))
                .addGroup(FIELD_LAYOUT.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(INPUT_FIELDS[0])
                                .addComponent(INPUT_FIELDS[1])));
        FIELD_LAYOUT.setVerticalGroup(FIELD_LAYOUT.createSequentialGroup()
                .addGroup(FIELD_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(INPUT_INFO[0])
                                .addComponent(INPUT_FIELDS[0]))
                        .addGroup(FIELD_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(INPUT_INFO[1])
                                .addComponent(INPUT_FIELDS[1])));

        BUTTON_PANEL.setLayout(BUTTON_LAYOUT);
        BUTTON_LAYOUT.setAutoCreateGaps(true);
        BUTTON_LAYOUT.setAutoCreateContainerGaps(true);
        BUTTON_LAYOUT.setHorizontalGroup(BUTTON_LAYOUT.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(SUBMIT_BUTTON));
        BUTTON_LAYOUT.setVerticalGroup(BUTTON_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(SUBMIT_BUTTON));


        LAYOUT.setAutoCreateGaps(true);
        LAYOUT.setAutoCreateContainerGaps(true);
        LAYOUT.setHorizontalGroup(LAYOUT.createSequentialGroup()
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(TITLE_PANEL)
                        .addComponent(FIELD_PANEL)
                        .addComponent(BUTTON_PANEL)));
        LAYOUT.setVerticalGroup(LAYOUT.createSequentialGroup()
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(TITLE_PANEL))
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(FIELD_PANEL))
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(BUTTON_PANEL)));

        setLayout(LAYOUT);
    }

    private void setComponents(){

        TITLE.setFont(TITLE_FONT);
        SUBMIT_BUTTON.setFont(LABEL_FONT);


        for (int i = 0; i < 2; i++) {
            INPUT_FIELDS[i] = new JTextField(25);
            INPUT_INFO[i] = new JLabel();

            INPUT_FIELDS[i].setFont(INPUT_FONT);
            INPUT_INFO[i].setFont(LABEL_FONT);
        }

        INPUT_INFO[0].setText("Full Name:");
        INPUT_INFO[1].setText("Username:");

        SUBMIT_BUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setName(INPUT_FIELDS[0].getText().strip());
                player.setUsername(INPUT_FIELDS[1].getText().strip());
                player.setCode();
                gameFrame.setGameState(PROLOGUE_STATE);
            }
        });
    }
}
