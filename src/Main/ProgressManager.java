package Main;

import Entity.Character;
import Entity.DialogueManager;
import Entity.Evidence;

import java.util.ArrayList;

import static Main.GameFrame.POLICE;

public class ProgressManager {

    private int gameProgress;
    private DialogueManager dialogueManager;

    public ProgressManager(){
        gameProgress = 0;
    }

    public void addGameProgress(){
        ++gameProgress;
        dialogueManager.updateGameProgress();
        for(Character character: dialogueManager.getCharacters()){
            character.getDmChat().setDMButtonText(null);

        }
    }

    public int getProgress() {
        return gameProgress;
    }

    public void checkEvidence(ArrayList<Evidence> evidenceArray) {
        Evidence[] reqEvidenceList;

        switch (gameProgress) {
            default:
                reqEvidenceList = null;
                break;

            case 1:
                reqEvidenceList = POLICE.getEvidenceP2();
                break;

            case 3:
                reqEvidenceList = POLICE.getEvidenceP4();
                break;

            case 4:
                reqEvidenceList = POLICE.getEvidenceP5();
                break;

        }

        if (reqEvidenceList != null){
            boolean hasAllEvidence = true;
            for (Evidence reqEvidence : reqEvidenceList) {
                boolean hasCurrentEvidence = false;
                for (Evidence storedEvidence : evidenceArray) {
                    if (storedEvidence.getLocation().equals(reqEvidence.getLocation()) && storedEvidence.getText().contains(reqEvidence.getText())) {
                        hasCurrentEvidence = true;
                        break;
                    }
                }
                if (!hasCurrentEvidence) {
                    hasAllEvidence = false;
                    break;
                }
            }
            if (hasAllEvidence) {
                addGameProgress();
            }
        }
    }

    public void setGameProgress(int gameProgress){
        this.gameProgress = gameProgress;
    }

    public void setDialogueManager(DialogueManager dialogueManager) {
        this.dialogueManager = dialogueManager;
    }
}
