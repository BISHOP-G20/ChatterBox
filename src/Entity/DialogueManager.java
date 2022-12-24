package Entity;

import Main.ProgressManager;
import UI.Chatroom;

import java.awt.*;

import static Main.GameFrame.PROGRESS_MANAGER;

public class DialogueManager {

    private int gameProgress;
    private int dialogueBranchGC;
    private int[] dialogueBranchDM;
    private boolean atTreeTrunkGC;
    private boolean wasAtTrunkGC;
    private boolean[] atTreeTrunkDM;
    private boolean[] wasAtTreeTrunkDM;
    private int[][][][] groupDialogueOrder;
    private Color[] orderedGroupColors;
    private Chatroom groupChatroom;

    private final Character[] characters;
    private final Player player = new Player();

    public DialogueManager(){
        PROGRESS_MANAGER.setDialogueManager(this);
        gameProgress = PROGRESS_MANAGER.getProgress();
        dialogueBranchGC = 3;
        dialogueBranchDM = new int[]{-1,-1,-1};
        atTreeTrunkGC = true;
        wasAtTrunkGC = false;
        atTreeTrunkDM = new boolean[]{true, true, true};
        wasAtTreeTrunkDM = new boolean[]{false, false, false};
        characters = new Character[]{new Irene(player), new Colin(), new Mikey(player)};
        characters[0].createDmChat(this, 0);
        characters[1].createDmChat(this, 1);
        characters[2].createDmChat(this, 2);
        groupChatroom = new Chatroom(this);

        setGroupDialogueOrder();
    }

    public String[] chooseDmDialogueOption(Character dmCharacter, int option){
       int charIndex;

       switch (dmCharacter.getUsername()){
           case "AlderEYE_007":
               charIndex = 0;
               break;

           case "Lazarus":
               charIndex = 1;
               break;

           case "m1key_m0use":
               charIndex = 2;
               break;

           default:
               System.out.println("Invalid username submitted\nSetting target to Irene");
               charIndex = 0;
               break;
       }
        if(dmCharacter.getDmDialogue(gameProgress) == null ){
            return null;
       }
       else if(dmCharacter.getDmDialogue(gameProgress, option, 3) == null) {
            return null;
        }
       else if(wasAtTreeTrunkDM[charIndex] && dmCharacter.getDmDialogue(gameProgress, dialogueBranchDM[charIndex], option) == null){
           return null;
       }
       if(atTreeTrunkDM[charIndex]){
           atTreeTrunkDM[charIndex] = false;
           wasAtTreeTrunkDM[charIndex] = true;
           dialogueBranchDM[charIndex] = option;
           option = 3;
       }
       else if (wasAtTreeTrunkDM[charIndex]){
           wasAtTreeTrunkDM[charIndex] = false;
       }
           return dmCharacter.getDmDialogue(gameProgress, dialogueBranchDM[charIndex], option);
    }

    public String[] chooseGroupDialogueOption(int option){
         int messageTotal;
         String[] orderedMessages;
        int[] charMessagesIndex;

        if(atTreeTrunkGC){
            atTreeTrunkGC = false;
            wasAtTrunkGC = true;
            dialogueBranchGC = option;
            option = 3;
        }
        else if (wasAtTrunkGC){
            wasAtTrunkGC = false;
        }

        messageTotal = groupDialogueOrder[gameProgress][dialogueBranchGC][option].length;
        orderedMessages = new String[messageTotal];
        orderedGroupColors = new Color[messageTotal];
        charMessagesIndex = new int[]{0,0,0};

        for (int i = 0; i < messageTotal; i++) {
            int charNum = groupDialogueOrder[gameProgress][dialogueBranchGC][option][i];
            orderedMessages[i] = characters[charNum].getUsername() + ": "+
                    characters[charNum].getGroupDialogue(gameProgress, dialogueBranchGC,
                    option, charMessagesIndex[charNum]);
            orderedGroupColors[i] = characters[charNum].getChatColor();
            ++charMessagesIndex[charNum];
        }
        if((gameProgress == 0 && option == 2) || (gameProgress == 0 && dialogueBranchGC == 1 && option == 0)){
            PROGRESS_MANAGER.addGameProgress();
        }
        else if((gameProgress == 2 && dialogueBranchGC == 0 && (option == 0 || option == 2)) ||
                (gameProgress == 2 && dialogueBranchGC == 1 && option == 1) ||
                (gameProgress == 2 && dialogueBranchGC == 2 && option == 0)){
            PROGRESS_MANAGER.addGameProgress();
        }
        return orderedMessages;
    }

    public void updateGameProgress(){
        gameProgress = PROGRESS_MANAGER.getProgress();
        dialogueBranchGC = 3;
        atTreeTrunkGC = true;
        groupChatroom.setGroupButtonText(null);
        for (int i = 0; i < 3; i++) {
            dialogueBranchDM[i] = -1;
            atTreeTrunkDM[i] = true;
            wasAtTreeTrunkDM[i] = false;
        }
    }

    public Color[] getOrderedGroupColors(){
        return orderedGroupColors;
    }

    public String[] getGroupButtonText(Integer optionInt){

        int gameProgress = PROGRESS_MANAGER.getProgress();
        String[] options;

        if(optionInt == null){
            options = player.getGroupDialogue(gameProgress, dialogueBranchGC);
        }
        else{
            options = player.getGroupDialogue(gameProgress, dialogueBranchGC, optionInt, this);
        }
        if(options == null){
            options = new String[]{"","",""};
        }

        return options;
    }

    public String[] getDmButtonText(String charUsername, Integer option){
        String[] options;
        int charIndex;
        int gameProgress = PROGRESS_MANAGER.getProgress();

        switch (charUsername){
            case "AlderEYE_007":
                charIndex = 0;
                break;

            case "Lazarus":
                charIndex = 1;
                break;

            case "m1key_m0use":
                charIndex = 2;
                break;

            default:
                System.out.println("Invalid username submitted\nSetting target to Irene");
                charIndex = 0;
                break;
        }
        if(option == null) {
            options = player.getDmDialogue(charUsername, gameProgress, dialogueBranchDM[charIndex]);
        }
        else{
            options = player.getDmDialogue(charUsername, gameProgress, dialogueBranchDM[charIndex], option, this);
        }

        if(options == null){
            options = new String[]{"","",""};
        }

        return options;
    }

    public void overrideDialogueBranchDM(int charIndex, int dialogueBranchDM){
        this.dialogueBranchDM[charIndex] = dialogueBranchDM;
        if(dialogueBranchDM == 3){
            atTreeTrunkDM[charIndex] = true;
            wasAtTreeTrunkDM[charIndex] = false;
        }
    }

    public void overrideDialogueBranchGC(int dialogueBranchGC){
        this.dialogueBranchGC = dialogueBranchGC;
        if(dialogueBranchGC == 3){
            atTreeTrunkGC = true;
            wasAtTrunkGC = false;
        }
    }

    public Chatroom getGroupChatroom(){
        return groupChatroom;
    }

    public Character[] getCharacters() {
        return characters;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean getWasAtTreeTrunkGC(){
        return wasAtTrunkGC;
    }

    public boolean getWasAtTreeTrunkDM(int charIndex) {
        return wasAtTreeTrunkDM[charIndex];
    }

    private void setGroupDialogueOrder(){

        // 5 X 3 X 4 X n matrix, 0-4 for progress, 0-2 for branch, 0-3 for dialogue option, 0-n list size populated
        // with ints 0-2 for order of character responses
        // 0: Irene, 1: Colin, 2: Mikey
        groupDialogueOrder = new int[6][3][4][];

        groupDialogueOrder[0][0][3] = new int[]{2,2,2};
        groupDialogueOrder[0][0][0] = new int[]{2,2,0,0,0};
        groupDialogueOrder[0][0][1] = new int[]{0,0,0,1,1,1};
        groupDialogueOrder[0][0][2] = new int[]{1,2,0,0,0,2,1,0,0,1,1,2,2,0,2,2,1,2,2};

        groupDialogueOrder[0][1][3] = groupDialogueOrder[0][0][0];
        groupDialogueOrder[0][1][0] = new int[]{0,0,0,0,2,1,0,0,1,1,2,2,0,2,2,1,2,2};
        groupDialogueOrder[0][1][1] = groupDialogueOrder[0][0][1];
        groupDialogueOrder[0][1][2] = groupDialogueOrder[0][0][2];

        groupDialogueOrder[0][2][3] = new int[]{2,2,2};
        groupDialogueOrder[0][2][0] = new int[]{2,2,0,0,0};
        groupDialogueOrder[0][2][1] = groupDialogueOrder[0][0][1];
        groupDialogueOrder[0][2][2] = groupDialogueOrder[0][0][2];

        groupDialogueOrder[1][0][3] = new int[]{0,0,0,0,0};
        groupDialogueOrder[1][0][0] = new int[]{};
        groupDialogueOrder[1][0][1] = new int[]{};
        groupDialogueOrder[1][0][2] = new int[]{};

        groupDialogueOrder[1][1][3] = new int[]{1,1,0,0,0,0};
        groupDialogueOrder[1][1][0] = new int[]{};
        groupDialogueOrder[1][1][1] = new int[]{};
        groupDialogueOrder[1][1][2] = new int[]{};

        groupDialogueOrder[1][2][3] = new int[]{1,2};
        groupDialogueOrder[1][2][0] = new int[]{};
        groupDialogueOrder[1][2][1] = new int[]{};
        groupDialogueOrder[1][2][2] = new int[]{};

        groupDialogueOrder[2][0][3] = new int[]{1,2,2,0,0};
        groupDialogueOrder[2][0][0] = new int[]{2,1,1,1,0,0,0,0,2,2,2,1,1,1,0,0,0,0,0,1,2};
        groupDialogueOrder[2][0][1] = new int[]{2,0,0};
        groupDialogueOrder[2][0][2] = new int[]{0,0,1,0,0,1,1,0,1,0,1,2,2,2,2,2,0,1,1,1,1,0,0,0,0,0,1,2};

        groupDialogueOrder[2][1][3] = new int[]{2,1,1,0};
        groupDialogueOrder[2][1][0] = new int[]{2,1};
        groupDialogueOrder[2][1][1] = groupDialogueOrder[2][0][2];
        groupDialogueOrder[2][1][2] = new int[]{1,1,1,1,0,0,1,1,1};

        groupDialogueOrder[2][2][3] = new int[]{1,1,1,2,2,2,2};
        groupDialogueOrder[2][2][0] = groupDialogueOrder[2][0][2];
        groupDialogueOrder[2][2][1] = new int[]{0,0,0,2,2,2,1,1,1,0,0};
        groupDialogueOrder[2][2][2] = new int[]{1,1,1,1,1,1,0,0,1,1,2,2,0,2};

        groupDialogueOrder[4][0][3] = new int[]{2,2,1,0,0};
        groupDialogueOrder[4][0][0] = new int[]{2,0,2,0,0,0,2,0,0,0,0};
        groupDialogueOrder[4][0][1] = new int[]{1,0,0,0,0};
        groupDialogueOrder[4][0][2] = new int[]{2,0,0,0,0,0,2};

        groupDialogueOrder[4][1][3] = new int[]{2,1,1};
        groupDialogueOrder[4][1][0] = new int[]{2,0,1,0,0};
        groupDialogueOrder[4][1][1] = new int[]{2,0,2,0,0,0,0,2,0,0,0,0,2};
        groupDialogueOrder[4][1][2] = new int[]{1,1,1,0,0,1,1,1,1,1,2,2,2,2,0,1};

        groupDialogueOrder[4][2][3] = new int[]{2,2,0,0};
        groupDialogueOrder[4][2][0] = new int[]{1,1,1,0};
        groupDialogueOrder[4][2][1] = new int[]{2,0,2,0,0,0,0,2,0,0,0,0,2};
        groupDialogueOrder[4][2][2] = new int[]{2,0,0};

        groupDialogueOrder[5][0][3] = new int[]{2,0,0};
        groupDialogueOrder[5][0][0] = new int[]{2,2,0,0,0,0,0,2,0,2};
        groupDialogueOrder[5][0][1] = new int[]{2};
        groupDialogueOrder[5][0][2] = new int[]{};

        groupDialogueOrder[5][1][3] = new int[]{0,0};
        groupDialogueOrder[5][1][0] = new int[]{0,0,0,2,2,1,2,0,0,0,0,0};
        groupDialogueOrder[5][1][1] = new int[]{2,1,2,2,2,0,0,1,1,1,1,1,0,1};
        groupDialogueOrder[5][1][2] = groupDialogueOrder[5][0][0];

        groupDialogueOrder[5][2][3] = new int[]{1,1,2,2};
        groupDialogueOrder[5][2][0] = new int[]{2,2,2,2,0,0,0,1,2,1};
        groupDialogueOrder[5][2][1] = groupDialogueOrder[5][0][0];
        groupDialogueOrder[5][2][2] = new int[]{};
    }
}
