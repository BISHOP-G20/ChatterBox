package Main;

import Entity.Evidence;
import Entity.Police;
import UI.*;
import Entity.DialogueManager;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.rtf.RTFEditorKit;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.Scanner;

public class GameFrame extends JFrame{

    private Container container;
    private Container chatContainer;
    private JTabbedPane tabbedPane;
    private LoginPage loginPage;
    private NewAccountPage newAccountPage;
    private StoryPanel storyPanel;
    private HomePage homePage;
    private Chatroom[] chatrooms;
    private SearchEngine searchEngine;
    private Settings settings;

    private int gameState;

    public final static int MENU_STATE = 0;
    public final static int NEW_ACCOUNT_STATE = 1;
    public final static int LOGIN_STATE = 2;
    public final static int PROLOGUE_STATE = 3;
    public final static int GAME_STATE = 4;
    public final static Dimension GAME_DIMENSION = new Dimension(800, 620);

    private final File saveFile = new File("SaveFile");
    private final Settings SETTINGS = new Settings(this);
    private final JPanel CHAT_CONTAINER_PANEL = new JPanel();
    private final CardLayout CHAT_LAYOUT = new CardLayout();
    private final CardLayout CARD_LAYOUT = new CardLayout();
    public final static Police POLICE = new Police();
    public final static ProgressManager PROGRESS_MANAGER = new ProgressManager();
    public final static EvidencePage EVIDENCE_PAGE = new EvidencePage();
    public final static EvidenceListener EVIDENCE_LISTENER = new EvidenceListener(EVIDENCE_PAGE);
    private final static DialogueManager  dialogueManager = new DialogueManager();


    public GameFrame(){

        setStartScreens();
        setTabbedPane();
        setLayout();

        setGameState(MENU_STATE);

        this.setTitle("Chatter Box");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
    }

    private void addMouseListener(Chatroom chatroom) {
        for (JTextArea chatTab : chatroom.getChatTabAreas()) {
            chatTab.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    setChatroom(chatTab.getName());
                }
            });
        }
        System.out.println();
    }

    private void setStartScreens() {
        homePage = new HomePage(this);
        newAccountPage = new NewAccountPage(this);
        storyPanel = new StoryPanel(this);
        loginPage = new LoginPage(this);
    }

    private void setTabbedPane() {

        setChatContainer();
        searchEngine = new SearchEngine();

        tabbedPane = new JTabbedPane();
        tabbedPane.add("Messages", CHAT_CONTAINER_PANEL);
        tabbedPane.add("Not Google", searchEngine);
        tabbedPane.add("Evidence", EVIDENCE_PAGE);
        tabbedPane.add("Settings", SETTINGS);
        tabbedPane.setPreferredSize(GAME_DIMENSION);

        this.setVisible(true);
    }

    private void setChatContainer(){
        chatrooms = new Chatroom[4];

        chatrooms[0] = dialogueManager.getCharacters()[0].getDmChat();
        chatrooms[1] = dialogueManager.getCharacters()[1].getDmChat();
        chatrooms[2] = dialogueManager.getCharacters()[2].getDmChat();
        chatrooms[3] = dialogueManager.getGroupChatroom();

        for(Chatroom chatroom: chatrooms){
            addMouseListener(chatroom);
        }

        chatContainer = CHAT_CONTAINER_PANEL;
        chatContainer.setLayout(CHAT_LAYOUT);
        chatContainer.add(chatrooms[0], "IreneDM");
        chatContainer.add(chatrooms[1], "ColinDM");
        chatContainer.add(chatrooms[2], "MikeyDM");
        chatContainer.add(chatrooms[3], "GroupChat");

        setChatroom("GroupChat");
    }

    private void setLayout(){

        container = getContentPane();
        container.setLayout(CARD_LAYOUT);

        container.add(homePage, "menu");
        container.add(newAccountPage, "newAcc");
        container.add(storyPanel, "story");
        container.add(loginPage, "login");
        container.add(tabbedPane, "tabs");
    }

    public void setChatroom(String areaName) {
        switch (areaName){
            case "AlderEYE_007":
                CHAT_LAYOUT.show(chatContainer, "IreneDM");
                break;

            case "Lazarus":
                CHAT_LAYOUT.show(chatContainer, "ColinDM");
                break;

            case "m1key_m0use":
                CHAT_LAYOUT.show(chatContainer, "MikeyDM");
                break;

            case "GroupChat":
                CHAT_LAYOUT.show(chatContainer, "GroupChat");
                break;

            default:
                CHAT_LAYOUT.show(chatContainer, "GroupChat");
                System.out.println("Invalid chat card called!");
                break;
        }
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;

        switch(gameState){
            case MENU_STATE:
                CARD_LAYOUT.show(container, "menu");
                break;

            case NEW_ACCOUNT_STATE:
                CARD_LAYOUT.show(container, "newAcc");
                homePage.stopThread();
                break;

            case LOGIN_STATE:
                CARD_LAYOUT.show(container, "login");
                homePage.stopThread();
                break;

            case PROLOGUE_STATE:
                CARD_LAYOUT.show(container, "story");
                break;

            case GAME_STATE:
                CARD_LAYOUT.show(container, "tabs");
                break;
        }
    }

    public String[] getCredentials(){
        String savedName = "";
        String savedUsername = "";

        try {
            Scanner scnr = new Scanner(saveFile);
            savedName = scnr.nextLine();
            savedUsername = scnr.next();

            scnr.close();
            return new String[]{savedName, savedUsername};
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }

    public void loadGame(){
        try {
            Scanner scnr = new Scanner(saveFile);

            dialogueManager.getPlayer().setName(scnr.next());
            scnr.nextLine();
            dialogueManager.getPlayer().setUsername(scnr.next());
            scnr.nextLine();
            PROGRESS_MANAGER.setGameProgress(scnr.nextInt());
            scnr.nextLine();

            scnr.useDelimiter("\t");
            while(scnr.hasNext()){
                EVIDENCE_PAGE.addEvidence(scnr.next());
            }
            EVIDENCE_PAGE.setEvidenceForm();
            scnr.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void saveGame(){
        try {
            String formattedString = "";

            formattedString+= dialogueManager.getPlayer().getName() + "\n";
            formattedString += dialogueManager.getPlayer().getUsername() + "\n";
            formattedString += PROGRESS_MANAGER.getProgress() + "\n";
            for (Evidence evidence: EVIDENCE_PAGE.getStoredEvidence()) {
                formattedString += evidence + "\t";
            }

            FileWriter fileWriter = new FileWriter(saveFile);
            fileWriter.write(formattedString);
            fileWriter.close();

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public DialogueManager getDialogueManager() {
        return dialogueManager;
    }
}
