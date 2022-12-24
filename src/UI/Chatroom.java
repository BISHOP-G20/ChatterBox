package UI;

import Entity.DialogueManager;
import Entity.Character;
import Entity.Player;
import Main.EvidenceListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Main.GameFrame.GAME_DIMENSION;
import static Main.GameFrame.EVIDENCE_PAGE;

public class Chatroom extends JPanel implements Runnable{

    private int frameCounter;
    private int optionInt;
    private int dialogueAddIndex;
    private boolean sendMessages;
    private boolean isDmChat;
    private String[] dmDialogue;
    private String[] groupDialogue;
    private Color[] groupDialogueColors;

    private JTextPane messagePane;
    private JScrollPane scrollPane;
    private JButton[] messageButtons;
    private JLabel chatLabel;
    private JTextArea[] chatTabArea;
    private ActionListener[] buttonActions;

    private StyleContext styleContext;
    private AttributeSet attributeSet;
    private Character dmCharacter;

    private final DialogueManager dialogueManager;
    private final Player player;
    private final Character[] characters;
    private final Thread thread;

    private final static EvidenceListener EVIDENCE_LISTENER = new EvidenceListener(EVIDENCE_PAGE);
    private final JPanel LABEL_PANEL =  new JPanel();
    private final JPanel CHAT_PANEL = new JPanel();
    private final Font CHAT_FONT = new Font("Helvetica", Font.BOLD, 13);
    private final Font LABEL_FONT = new Font("Arial", Font.BOLD, 30);
    private final Font USERNAME_FONT = new Font("Arial", Font.BOLD, 14);
    private final Dimension MESSAGE_LABEL_DIM = new Dimension(250, 40);
    private final Dimension CHAT_DIM = new Dimension((int)(GAME_DIMENSION.getWidth()*.75) - 40,
            (int)(GAME_DIMENSION.getHeight() * .65));
    private final Dimension LABEL_DIM;
    private final Color CHAT_COLOR = new Color(143, 231, 255);
    private final GroupLayout THIS_LAYOUT = new GroupLayout(this);
    private final GroupLayout LABEL_LAYOUT = new GroupLayout(LABEL_PANEL);
    private final GroupLayout CHAT_LAYOUT = new GroupLayout(CHAT_PANEL);
    private final Border chatBoarder = BorderFactory.createCompoundBorder(
                                        BorderFactory.createMatteBorder(
                                                5,5,5,5, Color.GRAY.brighter()),
                                        BorderFactory.createMatteBorder(
                                                3,3,3,3, Color.GRAY));

    public Chatroom(DialogueManager dialogueManager){
        this.dialogueManager = dialogueManager;
        player = dialogueManager.getPlayer();
        characters = dialogueManager.getCharacters();
        sendMessages = false;
        isDmChat = false;
        thread = new Thread(this);

        instantiateComponents(null);
        LABEL_DIM = new Dimension(chatTabArea[2].getWidth() + 10, chatTabArea[2].getHeight());

        setChatLabels();
        setChatPanel(null);
        setPanels();
        setName("GroupChat");
        messagePane.addMouseListener(EVIDENCE_LISTENER);
    }

    public Chatroom(DialogueManager dialogueManager, int charIndex){
        this.dialogueManager = dialogueManager;
        player = dialogueManager.getPlayer();
        characters = dialogueManager.getCharacters();
        dmCharacter = characters[charIndex];
        sendMessages = false;
        isDmChat = true;
        thread = new Thread(this);

        instantiateComponents(charIndex);
        LABEL_DIM = new Dimension(chatTabArea[2].getWidth() + 10, chatTabArea[2].getHeight());

        setChatLabels();
        setChatPanel(dmCharacter);
        setPanels();
        setName(dmCharacter.getUsername());
        messagePane.addMouseListener(EVIDENCE_LISTENER);
    }

    private void startThread(boolean bool){
        synchronized (this) {
            try {
                if (bool && thread.getState() == Thread.State.NEW) {
                    thread.start();
                }
                else if(bool && thread.getState() == Thread.State.WAITING) {
                    notify();
                }
                else if (!bool) {
                     thread.interrupt();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void setChatLabels(){
        LABEL_PANEL.setBackground(Color.DARK_GRAY);

        LABEL_LAYOUT.setAutoCreateGaps(true);
        LABEL_LAYOUT.setAutoCreateContainerGaps(true);

        LABEL_LAYOUT.setHorizontalGroup(LABEL_LAYOUT.createSequentialGroup()
                .addGroup(LABEL_LAYOUT.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(chatTabArea[0])
                        .addComponent(chatTabArea[1])
                        .addComponent(chatTabArea[2])));

        LABEL_LAYOUT.setVerticalGroup(LABEL_LAYOUT.createSequentialGroup()
                .addGroup(LABEL_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(chatTabArea[0]))
                .addGroup(LABEL_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(chatTabArea[1]))
                .addGroup(LABEL_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(chatTabArea[2])));

        LABEL_PANEL.setLayout(LABEL_LAYOUT);
    }

    private void setChatPanel(Character dmCharacter){

        CHAT_PANEL.setBackground(CHAT_COLOR);

        CHAT_LAYOUT.setAutoCreateGaps(true);
        CHAT_LAYOUT.setAutoCreateContainerGaps(true);

        messagePane.setMargin(new Insets(5, 5, 5, 5));
        messagePane.setEditable(false);

        scrollPane.setBorder(chatBoarder);
        scrollPane.createVerticalScrollBar();
        scrollPane.setWheelScrollingEnabled(true);
        scrollPane.setPreferredSize(CHAT_DIM);
        scrollPane.setMaximumSize(CHAT_DIM);

        if(isDmChat) {
            chatLabel.setText(dmCharacter.getUsername());
            setDMButtonText(null);
        }
        else{
            chatLabel.setText("Group Messages");
            setGroupButtonText(null);
        }

        chatLabel.setForeground(Color.WHITE);
        chatLabel.setPreferredSize(MESSAGE_LABEL_DIM);

        CHAT_LAYOUT.setHorizontalGroup(CHAT_LAYOUT.createSequentialGroup()
                .addGroup(CHAT_LAYOUT.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(chatLabel)
                        .addComponent(scrollPane)
                        .addComponent(messageButtons[0])
                        .addComponent(messageButtons[1])
                        .addComponent(messageButtons[2])));

        CHAT_LAYOUT.setVerticalGroup(CHAT_LAYOUT.createSequentialGroup()
                .addGroup(CHAT_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(chatLabel))
                .addGroup(CHAT_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(scrollPane))
                .addGroup(CHAT_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(messageButtons[0]))
                .addGroup(CHAT_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(messageButtons[1]))
                .addGroup(CHAT_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(messageButtons[2])));

        CHAT_PANEL.setLayout(CHAT_LAYOUT);
    }

    private void setPanels(){
        setBackground(Color.DARK_GRAY);

        THIS_LAYOUT.setHorizontalGroup(THIS_LAYOUT.createSequentialGroup()
                .addGroup(THIS_LAYOUT.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(LABEL_PANEL))
                .addGroup(THIS_LAYOUT.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(CHAT_PANEL)));

        THIS_LAYOUT.setVerticalGroup(THIS_LAYOUT.createSequentialGroup()
                .addGroup(THIS_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(LABEL_PANEL)
                        .addComponent(CHAT_PANEL)));

        setLayout(THIS_LAYOUT);
    }

    public void setDMButtonText(Integer optionInt){
        String[] options = dialogueManager.getDmButtonText(dmCharacter.getUsername(), optionInt);
        for (int i = 0; i < 3; i++) {
            messageButtons[i].setText("\t " + options[i] + "\t ");
        }
    }

    public void setGroupButtonText(Integer optionInt){
        String[] options = dialogueManager.getGroupButtonText(optionInt);
        for (int i = 0; i < 3; i++) {
            messageButtons[i].setText("\t " + options[i] + "\t ");
        }
    }

    private void respondToPlayer(int option){

        if(isDmChat){
            if (dmDialogue == null){
                dialogueAddIndex = 0;
                dmDialogue = dialogueManager.chooseDmDialogueOption(dmCharacter, option);
            }
            if (dmDialogue != null) {
                if (frameCounter > 60 && dialogueAddIndex < dmDialogue.length) {
                    appendToPane(dmDialogue[dialogueAddIndex] + "\n", dmCharacter.getChatColor());
                    ++dialogueAddIndex;
                    frameCounter = 0;
                } else if (dialogueAddIndex >= dmDialogue.length) {
                    setDMButtonText(option);
                    sendMessages = false;
                    frameCounter = 0;
                    dialogueAddIndex = 0;
                    startThread(false);
                }
            }
            else{
                sendMessages = false;
                frameCounter = 0;
                dialogueAddIndex = 0;
            }
        }
        else {
            if (groupDialogue == null && groupDialogueColors == null) {
                dialogueAddIndex = 0;
                groupDialogue = dialogueManager.chooseGroupDialogueOption(option);
                groupDialogueColors = dialogueManager.getOrderedGroupColors();
            }

            if (frameCounter > 60 && dialogueAddIndex < groupDialogue.length) {
                appendToPane(groupDialogue[dialogueAddIndex] + "\n", groupDialogueColors[dialogueAddIndex]);
                ++dialogueAddIndex;
                frameCounter = 0;
            } else if (dialogueAddIndex >= groupDialogue.length) {
                setGroupButtonText(option);
                sendMessages = false;
                frameCounter = 0;
                dialogueAddIndex = 0;
                startThread(false);
            }
        }
    }

    private void instantiateComponents(Integer charIndex){
        messagePane = new JTextPane();
        scrollPane = new JScrollPane(messagePane);
        chatLabel = new JLabel();
        chatTabArea = new JTextArea[3];
        messageButtons = new JButton[3];
        buttonActions = new ActionListener[3];

        styleContext = StyleContext.getDefaultStyleContext();

        messagePane.setFont(CHAT_FONT);

        for (int i = 0; i < 3; i++) {
            messageButtons[i] = new JButton();
            chatTabArea[i] = new JTextArea();

            if(charIndex != null && charIndex == i){
                chatTabArea[i].setText("\n   GroupChat");
            }
            else {
                chatTabArea[i].setText("\n   " + characters[i].getUsername());
            }
            chatTabArea[i].setName(chatTabArea[i].getText().strip());
            chatTabArea[i].setBackground(Color.GRAY);
            chatTabArea[i].setMaximumSize(LABEL_DIM);
            chatTabArea[i].setEditable(false);
            chatTabArea[i].setFont(USERNAME_FONT);
            chatTabArea[i].setForeground(Color.WHITE);
            chatTabArea[i].setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createMatteBorder(4,4,4,4, Color.BLACK),
                    BorderFactory.createMatteBorder(0,2, 2, 0, Color.DARK_GRAY)));
        }

        chatLabel.setFont(LABEL_FONT);

                buttonActions[0] = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(!messageButtons[0].getText().strip().equals("")) {
                            if (!sendMessages) {
                                appendToPane(player.getUsername() + ": " + messageButtons[0].getText().strip() + "\n", Color.BLACK);
                                optionInt = 0;
                                if(isDmChat){
                                    dmDialogue = null;
                                }
                                else {
                                    groupDialogue = null;
                                    groupDialogueColors = null;
                                }
                                startThread(true);
                                sendMessages = true;
                            }
                        }
                    }
                };

        buttonActions[1] = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!messageButtons[1].getText().strip().equals("")){
                    if (!sendMessages){
                        appendToPane(player.getUsername() + ": " + messageButtons[1].getText().strip() + "\n", Color.BLACK);
                    optionInt = 1;
                    if(isDmChat){
                        dmDialogue = null;
                    }
                    else {
                        groupDialogue = null;
                        groupDialogueColors = null;
                    }
                    startThread(true);
                    sendMessages = true;
                    }
                }
            }
        };

        buttonActions[2] = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!messageButtons[2].getText().strip().equals("")) {
                    if (!sendMessages) {
                        appendToPane(player.getUsername() + ": " + messageButtons[2].getText().strip() + "\n", Color.BLACK);
                        optionInt = 2;
                        if(isDmChat){
                            dmDialogue = null;
                        }
                        else {
                            groupDialogue = null;
                            groupDialogueColors = null;
                        }
                        startThread(true);
                        sendMessages = true;
                    }
                }
            }
        };
        for (int i = 0; i < 3; i++) {
            messageButtons[i].addActionListener(buttonActions[i]);
        }
    }

    private void appendToPane(String string, Color color){

        StyledDocument document = messagePane.getStyledDocument();

        attributeSet = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);
        attributeSet = styleContext.addAttribute(attributeSet, StyleConstants.Alignment, StyleConstants.ALIGN_LEFT);

        try {
            document.insertString(document.getLength(), string, attributeSet);
        }
        catch (BadLocationException e){
            e.printStackTrace();
        }
        if(scrollPane.getVerticalScrollBar() != null){
            scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
        }
    }

    public JTextArea[] getChatTabAreas(){
        return chatTabArea;
    }

    public JTextPane getMessagePane(){
        return messagePane;
    }

    @Override
    public void run() {
        int frameInterval = 1000000000 / 60;
        Double nextTime = (double) System.nanoTime() + frameInterval;

        while (thread != null) {

            double remainingTime = nextTime - System.nanoTime();
            remainingTime /= 1000000;

            if (remainingTime > 0) {
                try {
                    Thread.sleep((long) remainingTime);

                } catch (InterruptedException e) {

                }
            }
            nextTime += frameInterval;
            if(sendMessages){
                respondToPlayer(optionInt);
                ++frameCounter;
            }
        }
    }
}