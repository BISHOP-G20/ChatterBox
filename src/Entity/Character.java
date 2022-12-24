package Entity;

import UI.Chatroom;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Character {
    String name;
    String username;
    String code;
    String[][][][] groupDialogue;
    String[][][][] dmDialogue;
    int loreProgress;

    Player player;

    BufferedImage profilePic;
    Color chatColor;
    Chatroom dmChat;



    public Character(){
        loreProgress = 0;
    }

    public void createDmChat(DialogueManager dialogueManager, int charIndex){
        dmChat = new Chatroom(dialogueManager, charIndex);
    }

    public abstract void setGroupDialogue();
    public abstract void setDmDialogue();

    public void addLoreProgress(){
        ++loreProgress;
    }

    public String getGroupDialogue(int progress, int branch, int option, int messageIndex){
        return groupDialogue[progress][branch][option][messageIndex];
    }

    public Color getChatColor() {
        return chatColor;
    }

    public String getName() {
        return name;
    }

    public String getUsername(){
        return username;
    }

    public String getCode() {
        return code;
    }

    public String[] getDmDialogue(int progress, int branch, int option) {
        return dmDialogue[progress][branch][option];
    }

    public String[][][] getDmDialogue(int progress){
        return dmDialogue[progress];
    }

    public Chatroom getDmChat() {
        return dmChat;
    }
}
