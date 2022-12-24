package UI;

import Entity.DialogueManager;
import Entity.Character;

import javax.swing.*;
import java.awt.*;

import static Main.GameFrame.GAME_DIMENSION;

public class UserProfilePage extends JPanel {

    private final Character[] characters;
    private final Dimension dimension;

    public UserProfilePage(DialogueManager dialogueManager){
        characters = dialogueManager.getCharacters();
        dimension = new Dimension((int)(GAME_DIMENSION.getWidth()*.85) - 10, (int)GAME_DIMENSION.getHeight());

        setPanel();
    }

    public void setPanel(){
        this.setBackground(new Color(143, 231, 255));
        this.setPreferredSize(dimension);
    }
}
