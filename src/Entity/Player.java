package Entity;

import java.util.Random;

public class Player {

    private String name;
    private String username;
    private String code = "#";

    private String[][][] groupDialogue;
    private String[][][] ireneDM;
    private String[][][] colinDM;
    private String[][][] mikeyDM;

    public Player(){

        setGroupDialogue();
        setIreneDM();
        setColinDM();
        setMikeyDM();
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setCode(){
        Random rand = new Random();

        int numCode = rand.nextInt(9999);
        code += numCode;
    }

    public String getUsername() {
        return username;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    private void setGroupDialogue() {

        // 5 X 3 X 3 X 3 matrix:
        // 0-4 for plot progress,  0-2 for branch, 0-2 for message options


        groupDialogue = new String[7][4][3];

        //**************************** PROGRESS 0 ******************************************************************

        //Mikey: If you have any questions about our investigation, I'm sure one of us can answer it
        groupDialogue[0][0][0] = "What can I do to help?";
        groupDialogue[0][0][1] = "Are the police involved?";
        groupDialogue[0][0][2] = "Have you actually uncovered anything?";

        //Irene: what are you good at?
        groupDialogue[0][1][0] = "I've never failed to overcome any challenge. Now, how can I help?";
        groupDialogue[0][1][1] = "As a PI I have a strong investigative instinct. I could help contact the police.";
        groupDialogue[0][1][2] = "I can do anything. What can you show me?";

        //Mikey: Between the three of us, the evidence is overwhelming
        groupDialogue[0][2][0] = "Hope you're right. How can I help?";
        groupDialogue[0][2][1] = "You think you can find out more than the police?";
        groupDialogue[0][2][2] = "What evidence?";

        //[0][3][n] is starting (tree trunk) options
        groupDialogue[0][3][0] = "Hello!";
        groupDialogue[0][3][1] = "Hey, just joined. How can I help?";
        groupDialogue[0][3][2] = "You all actually believe there's a case here?";

        //**************************** PROGRESS 1 ******************************************************************

        groupDialogue[1][0][0] = "";
        groupDialogue[1][0][1] = "";
        groupDialogue[1][0][2] = "";

        groupDialogue[1][1][0] = "";
        groupDialogue[1][1][1] = "";
        groupDialogue[1][1][2] = "";

        groupDialogue[1][2][0] = null;
        groupDialogue[1][2][1] = null;
        groupDialogue[1][2][2] = null;

        //[1][3][n] is starting (tree trunk) options
        groupDialogue[1][3][0] = "Those groups seem significant. What do they all have in common?";
        groupDialogue[1][3][1] = "Weird. Hopefully we can find something more important.";
        groupDialogue[1][3][2] = "Hmm...";

        //**************************** PROGRESS 2 ******************************************************************

        groupDialogue[2][0][0] = "I think they all used those links during the spam.";
        groupDialogue[2][0][1] = "Just kidding!";
        groupDialogue[2][0][2] = "The link spam. That's the thing that connects them!";

        groupDialogue[2][1][0] = "Nope.";
        groupDialogue[2][1][1] = "I think the link spam is what connects them.";
        groupDialogue[2][1][2] = "I'm not sure I want to say just yet.";

        groupDialogue[2][2][0] = "Yes, I think the link spam is what connects them.";
        groupDialogue[2][2][1] = "Yes, looks like @AlderEYE_007 is a pretty bad interviewer.";
        groupDialogue[2][2][2] = "Not yet. @Lazarus you really think they aren't worth reading?";

        groupDialogue[2][3][0] = "I've found a pattern!";
        groupDialogue[2][3][1] = "Has anybody found anything?";
        groupDialogue[2][3][2] = "Who else has read the testimonies?";

        //**************************** PROGRESS 3 ******************************************************************

        groupDialogue[3] = new String[][]{null, null ,null, null};

        //**************************** PROGRESS 4 ******************************************************************

        groupDialogue[4][0][0] = "The word 'tonem' is appended to the copyright at the bottom of each website.";
        groupDialogue[4][0][1] = "I'll share after you @AlderEYE_007. I'm sure you've beaten me to the punch once again.";
        groupDialogue[4][0][2] = "Well... I don't know what it means but the clue is 'tonem'.";

        groupDialogue[4][1][0] = "That's a shame. I'm surprised you don't have anything @AlderEYE_007.";
        groupDialogue[4][1][1] = "Well I did! The word 'tonem' is appended to the copyright at the bottom of each website.";
        groupDialogue[4][1][2] = "@Lazarus really?";

        groupDialogue[4][2][0] = "@Lazarus do you know what it means?";
        groupDialogue[4][2][1] = "It a word I found attached to the copyright at the bottom of each website.";
        groupDialogue[4][2][2] = "Its nothing. Nevermind!";

        groupDialogue[4][3][0] = "I may have found something...";
        groupDialogue[4][3][1] = "Has anybody found a connection between the websites?";
        groupDialogue[4][3][2] = "Does the word 'tonem' mean anything to you guys?";

        //**************************** PROGRESS 5 ******************************************************************

        groupDialogue[5][0][0] = "Each website has a sign-up page. And each page asks for an SSN.";
        groupDialogue[5][0][1] = "No reason.";
        groupDialogue[5][0][2] = "@Lazarus what do you think?";

        groupDialogue[5][1][0] = "You said you were confirming a new lead when we DMed. That information.";
        groupDialogue[5][1][1] = "Just idle chit-chat. What's going on guys?";
        groupDialogue[5][1][2] = "The sign-up pages attached to each site require an SSN. Isn't that weird?";

        groupDialogue[5][2][0] = "All the websites are kind of blurry. Isn't that strange?";
        groupDialogue[5][2][1] = "Each website has a sign-up page, right? And each page asks for an SSN.";
        groupDialogue[5][2][2] = "@Lazarus did you notice the sign-up pages?";

        groupDialogue[5][3][0] = "Its weird for a website to ask for your full SSN, right?";
        groupDialogue[5][3][1] = "@AlderEYE_007 have you verified that information you found?";
        groupDialogue[5][3][2] = "Ok, something weird is definitely going on with those websites...";

        //**************************** PROGRESS 6 ******************************************************************

        groupDialogue[6] = new String[][]{null, null ,null, null};

    }

    private void setIreneDM(){

        ireneDM = new String[7][4][3];

        ireneDM[0] = new String[][]{null, null ,null, null};

        ireneDM[1][0][0] = "You investigate so professionally. How did you learn to do that?";
        ireneDM[1][0][1] = "What should I do to help the investigation?";
        ireneDM[1][0][2] = "I'm all set to chase down leads, where should I start?";

        ireneDM[1][1][0] = "Yes.";
        ireneDM[1][1][1] = "No.";
        ireneDM[1][1][2] = "I just don't get it. Why are the testimonies important? What do you think is in them?";

        ireneDM[1][2][0] = "Thanks! I'll let you know when I find something.";
        ireneDM[1][2][1] = "What do you think is in them?";
        ireneDM[1][2][2] = "You seem to really know what you're doing. How did you learn to investigate?";

        ireneDM[1][3][0] = "Hi again, you seem to really know what you're doing. Mind giving me some pointers?";
        ireneDM[1][3][1] = "Hey";
        ireneDM[1][3][2] = "Hi, could you send me the testimonies?";

        ireneDM[2] = new String[][]{null, null ,null, null};

        ireneDM[3][0][0] = "Do you not think @m1key_m0use and @Lazarus can help?";
        ireneDM[3][0][1] = "Me too! Have you found the actual links?";
        ireneDM[3][0][2] = "Why was what @Lazarus said about the testimonies interesting?";

        ireneDM[3][1][0] = "Thanks! I'll get right on looking into those!";
        ireneDM[3][1][1] = "Wasted my time? That seems harsh. They probably just made a mistake.";
        ireneDM[3][1][2] = "CBD, gold, and an advisor group? Those seem pretty random..";

        ireneDM[3][2][0] = ireneDM[3][0][2];
        ireneDM[3][2][1] = "I'll get right on it!";
        ireneDM[3][2][2] = ireneDM[3][1][2];

        ireneDM[3][3][0] = "@Lazarus seems really annoyed, right?";
        ireneDM[3][3][1] = "I've been researching those topics @Lazarus brought up, but haven't found anything.";
        ireneDM[3][3][2] = "Have you found the actual links?";

        ireneDM[4][0][0] = "Ok... I guess I'll keep looking then.";
        ireneDM[4][0][1] = "What would be incriminating?";
        ireneDM[4][0][2] = "I'm starting to think @Lazarus is up to something...";

        ireneDM[4][1][0] = "Ok... I guess I'll keep looking then.";
        ireneDM[4][1][1] = "Are you an investigator in the real world?";
        ireneDM[4][1][2] = "@Lazarus is being really weird. Whats up with that?";

        ireneDM[4][2][0] = "I'm glad @m1key_m0use was there to calm everything down.";
        ireneDM[4][2][1] = "I think @Lazarus is up to something...";
        ireneDM[4][2][2] = "Anyway, have you found anything else yet?";

        ireneDM[4][3][0] = "Are you sure I should be looking around the websites still?";
        ireneDM[4][3][1] = "Have you found anything else yet?";
        ireneDM[4][3][2] = "@Lazarus is being really weird. Whats up with that?";

        ireneDM[5] = new String[][]{null, null, null, null};

        ireneDM[6][0][0] = "I don't know what to tell you. They're there and I took the screenshots.";
        ireneDM[6][0][1] = "I'm just messing with you. They're down for me too. What's going on?";
        ireneDM[6][0][2] = "What do you mean they're down for you?";

        ireneDM[6][1][0] = "So what now?";
        ireneDM[6][1][1] = "Could it be that Lazarus is behind all of this?";
        ireneDM[6][1][2] = "Wow, ok. Then can you tell me whats going on with that new info now? ";

        ireneDM[6][2][0] = "Yes! Of course I want to solve the case! Send the link!";
        ireneDM[6][2][1] = "How could the sites have gone down right after we talked about them in the GC?";
        ireneDM[6][2][2] = "Could it be that Lazarus is behind all of this?";

        ireneDM[6][3][0] = "Ok, I took screen shots of the sign-up pages. What now?";
        ireneDM[6][3][1] = "The sites are down! Whats going on?";
        ireneDM[6][3][2] = "Can you tell me whats going on with the new info now?";
    }

    private void setColinDM() {
        colinDM = new String[7][4][3];

        colinDM[0] = new String[][]{null, null, null, null};

        colinDM[1][0][0] = "";
        colinDM[1][0][1] = "";
        colinDM[1][0][2] = "";

        colinDM[1][1][0] = "I'll just keep trying then, I guess. Thanks for the advice!";
        colinDM[1][1][1] = "Thanks for the help. Where did you learn how to investigate?";
        colinDM[1][1][2] = "My instincts are telling me to look into the testimonies.\nDo you think they could be important?";

        colinDM[1][2][0] = "I see. You must be really talented to have found anything then.";
        colinDM[1][2][1] = "That's not too helpful. Isn't there any direction you can give me?";
        colinDM[1][2][2] = "Ok. I'll keep trying on my own then.";

        colinDM[1][3][0] = "Hey!";
        colinDM[1][3][1] = "Hey, you seem like a good investigator. Could you give me some tips?";
        colinDM[1][3][2] = "Hi, could you help me get started? I'm totally lost.";

        colinDM[2] = new String[][]{null, null ,null, null};

        colinDM[3][0][0] = "I'm looking, but struggling to find anything that looks suspicious.";
        colinDM[3][0][1] = "Actually, @AlderEYE_007 said she found the website names and was sending them to everybody.\n" +
                            "Have you checked your DMs with her?";
        colinDM[3][0][2] = "I think I can figure out what is important to investigate on my own, thanks.";

        colinDM[3][1][0] = "";
        colinDM[3][1][1] = "";
        colinDM[3][1][2] = "";

        colinDM[3][2][0] = "I understand what you mean about assumptions, but I think you have\n" +
                "to look into guesses at the beginning. Do you disagree?";
        colinDM[3][2][1] = "I hear you. Have you found anything yet?";
        colinDM[3][2][2] = "That makes sense. Its cool that you're helping to look even though you disagree with the premise.";

        colinDM[3][3][0] = "Hi, thanks for the tip off on the website topics. Have you found anything yet?";
        colinDM[3][3][1] = "Hey, that was pretty awkward with @AlderEYE_007. Is everything ok now?";
        colinDM[3][3][2] = "Hey, just want to let you know that I think your skepticism about the testimonies makes sense.";

        colinDM[4] = new String[][]{null, null, null, null};
        colinDM[5] = new String[][]{null, null, null, null};
        colinDM[6] = new String[][]{null,null,null,null};
    }

    private void setMikeyDM() {
        mikeyDM = new String[7][4][3];

        mikeyDM[0] = new String[][]{null, null, null, null};

        mikeyDM[1][0][0] = "Have you found any clues yet?";
        mikeyDM[1][0][1] = "I'm sorry about your grandmother. Does she have any information that might help?";
        mikeyDM[1][0][2] = "I'm interested in the topic boards that were attacked. Soap Operas, Cruises, and Golf... Why them?";

        mikeyDM[1][1][0] = "When was her account drained?";
        mikeyDM[1][1][1] = "It sounds like you two are close.";
        mikeyDM[1][1][2] = "What do you do for a living?";

        mikeyDM[1][2][0] = "Good so far. I got the testimonies from AlderEYE_007. I think theres definitely something helpful in there.";
        mikeyDM[1][2][1] = "Not great. I don't really know where to start.";
        mikeyDM[1][2][2] = "Its going. What about you?";

        mikeyDM[1][3][0] = "Hey, thanks for welcoming me into the group! I think together we can get to the bottom of this.";
        mikeyDM[1][3][1] = "Hi, I'm sorry to hear that your grandmother was one of the victims.";
        mikeyDM[1][3][2] = "Hey!";

        mikeyDM[2] = new String[][]{null, null, null, null};

        mikeyDM[3][0][0] = "Assisted living community? Like a retirement home?";
        mikeyDM[3][0][1] = "That's great! I'll look into it right now!";
        mikeyDM[3][0][2] = "Interesting. Feel free not to answer but was she looking for herself?";

        mikeyDM[3][1][0] = "Her?";
        mikeyDM[3][1][1] = "Same here. Did you DM with Lazarus at all?";
        mikeyDM[3][1][2] = "Have you asked your grandmother about the links yet?";

        mikeyDM[3][2][0] = mikeyDM[3][0][0];
        mikeyDM[3][2][1] = mikeyDM[3][0][1];
        mikeyDM[3][2][2] = mikeyDM[3][0][2];

        mikeyDM[3][3][0] = "Did you talk to your grandmother?";
        mikeyDM[3][3][1] = "@Lazarus seemed pretty annoyed, right?";
        mikeyDM[3][3][2] = "Found anything yet?";

        mikeyDM[4][0][0] = "Do you think one of them will leave the group?";
        mikeyDM[4][0][1] = "Why do you feel the need to always be helping others?";
        mikeyDM[4][0][2] = "Do you get the sense that something more is going on with Lazarus?";

        mikeyDM[4][1][0] = "You do contribute, you helped find one of the links!";
        mikeyDM[4][1][1] = "Yeah, you aren't very good at this.";
        mikeyDM[4][1][2] = "Even if you don't track down leads, your help with @Lazarus and @AlderEYE_007 is huge!";

        mikeyDM[4][2][0] = mikeyDM[4][1][0];
        mikeyDM[4][2][1] = mikeyDM[4][1][1];
        mikeyDM[4][2][2] = mikeyDM[4][1][2];

        mikeyDM[4][3][0] = "Thanks for mediating @Lazarus and @AlderEYE_007. Things were getting out of hand, fast.";
        mikeyDM[4][3][1] = "Have you found anything else on the websites?";
        mikeyDM[4][3][2] = "Hey";

        mikeyDM[5] = new String[][]{null, null, null, null};
        mikeyDM[6] = new String[][]{null,null,null,null};
    }

    public String[] getGroupDialogue(int progress, int branch){
        return groupDialogue[progress][branch];
    }

    public String[] getGroupDialogue(int progress, int branch, int option, DialogueManager dialogueManager){
        if((progress == 0 && branch == 2 && option == 0) ||
                (progress == 0 && branch == 0 && option == 0 && !dialogueManager.getWasAtTreeTrunkGC())){
            dialogueManager.overrideDialogueBranchGC(1);
            return groupDialogue[0][1];
        }
        else if(progress == 1 && branch == 2 && option == 2){
            dialogueManager.overrideDialogueBranchGC(3);
            return groupDialogue[1][3];
        }
        return getGroupDialogue(progress, branch);
    }

    public String[] getDmDialogue(String charUsername, int progress, int branch){
        if(branch == -1){
            branch = 3;
        }

        switch(charUsername){
            case "AlderEYE_007":
                return ireneDM[progress][branch];

            case "Lazarus":
                return colinDM[progress][branch];

            case "m1key_m0use":
                return mikeyDM[progress][branch];

            default:
                System.out.println("player.getDmDialogue(): invalid charName passed, setting target to irene");
                return ireneDM[progress][branch];
        }
    }

    public String[] getDmDialogue(String charUsername, int progress, int branch, int option, DialogueManager dialogueManager){
        if(charUsername.equals("AlderEYE_007") && progress == 1 && branch == 0 && option == 2){
            dialogueManager.overrideDialogueBranchDM(0, 1);
            return ireneDM[progress][1];
        }
        return getDmDialogue(charUsername, progress, branch);
    }
}
