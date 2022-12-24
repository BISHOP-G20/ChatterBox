package UI;

import Main.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Font.PLAIN;

public class Settings extends JPanel {

    private final GameFrame GAME_FRAME;
    private final JButton SAVE_BUTTON = new JButton("Save Game");
    private final Font BUTTON_FONT = new Font("Arial", PLAIN, 20);

    public Settings(GameFrame GAME_FRAME){
        this.GAME_FRAME = GAME_FRAME;

        setButton();
        add(SAVE_BUTTON);
    }

    private void setButton(){
        SAVE_BUTTON.setFont(BUTTON_FONT);
        SAVE_BUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GAME_FRAME.saveGame();
            }
        });
    }
}
