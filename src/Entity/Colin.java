package Entity;

import java.awt.*;

public class Colin extends Character{
    public Colin(){
        name = "Colin Sullivan";
        username = "Lazarus";
        code = "#2703";
        chatColor = new Color(119, 25, 155);

        setGroupDialogue();
        setDmDialogue();
    }

    public void setGroupDialogue() {

        //5 X 3 X 4 X n matrix:
        //0-4 for plot progress, 0-2 for branch, 0-3 for player dialogue options,0-n for messages sent during interaction
        //groupDialogue[n][n][3] = responses to player branch choice
        groupDialogue = new String[6][3][4][];

        //  *** BRANCH 0 ***
        //Player option: "Hello!"
        groupDialogue[0][0][3] =  new String[]{};
        groupDialogue[0][0][0] = new String[]{};
        groupDialogue[0][0][1] = new String[]{
                "We havent been able to show them anything substantial either"
                ,"Between Alder and me there isnt enough info"
                ,"Basically no point in going to them until the entire case can be laid out"};
        groupDialogue[0][0][2] = new String[]{
                "Nothing much tbh"
                ,"Actually i might have just found something important"
                ,"I did a little research on the victims and they appear to only come from 3 topic boards"
                ,"- golf, soap operas, and cruises"
                ,"She couldnt help us talk to other victims could she?"};


        // *** Branch 1 ***
        //Player option: "Hey, just joined. How can I help?"
        groupDialogue[0][1][3] = groupDialogue[0][0][3];
        groupDialogue[0][1][0] = new String[]{
                "Actually i might have just found something important"
                ,"I did a little research on the victims and they appear to only come from 3 topic boards"
                ,"- golf, soap operas, and cruises"
                ,"She couldnt help us talk to other victims could she?"};
        groupDialogue[0][1][1] = groupDialogue[0][0][1];
        groupDialogue[0][1][2] = groupDialogue[0][0][2];


        // *** Branch 2 ***
        //Player option: "You all actually believe there's a case here?"
        groupDialogue[0][2][3] = groupDialogue[0][0][3];
        groupDialogue[0][2][0] = groupDialogue[0][0][0];
        groupDialogue[0][2][1] = groupDialogue[0][0][1];
        groupDialogue[0][2][2] = groupDialogue[0][0][2];

        //**************************** PROGRESS 1 ******************************************************************

        groupDialogue[1][0][3] = new String[]{};
        groupDialogue[1][0][0] = new String[]{};
        groupDialogue[1][0][1] = new String[]{};
        groupDialogue[1][0][2] = new String[]{};

        groupDialogue[1][1][3] = new String[]{
                "Finding anything has been super difficult so good luck"
                ,"Lmk if you want any help tho"};
        groupDialogue[1][1][0] = new String[]{};
        groupDialogue[1][1][1] = new String[]{};
        groupDialogue[1][1][2] = new String[]{};

        groupDialogue[1][2][3] = new String[]{
                "Idk what to make of it either"};
        groupDialogue[1][2][0] = new String[]{};
        groupDialogue[1][2][1] = new String[]{};
        groupDialogue[1][2][2] = new String[]{};

        //**************************** PROGRESS 2 ******************************************************************

        //Player: "I've found a pattern!"
        groupDialogue[2][0][3] = new String[]{
                "Seriously?"};
        groupDialogue[2][0][0] = new String[]{
                "What?"
                ,"Theres no way you can prove that"
                ,"Sounds like a guess to me"
                ,"I vaguely remember the links, i think one lead to a movie torrenting website and the other was a jewelry website"
                ,"there could have been others but those are the only ones i remember"
                ,"we should start by researching those types of sites"
                ,"Me too"};
        groupDialogue[2][0][1] = null;
        groupDialogue[2][0][2] = new String[]{
                "Why didnt you say anything then?"
                ,"If you arent working together than theres no point in working with you either"
                ,"What are the other reasons?"
                ,"@AlderEYE_007 what are the other reasons?"
                ,"Im not moving on until AlderEYE_007 explains themself"
                ,"Fine then"
                ,"I vaguely remember the links, i think one lead to a movie torrenting website and the other was a jewelry website"
                ,"there could have been others but those are the only ones i remember"
                ,"we should start by researching those types of sites"
                ,"Me too"};

        //Player: "Has anybody found anything?"
        groupDialogue[2][1][3] = new String[]{
                "Im also coming up dry"
                ,"Maybe this whole thing is over our heads"};
        groupDialogue[2][1][0] = new String[]{"Bummer!"};
        groupDialogue[2][1][1] = groupDialogue[2][0][2];
        groupDialogue[2][1][2] = new String[]{
                "?"
                ,"Why not?"
                ,"The point of this group is to share information and get to the bottom of this"
                ,"If youre in the group you gotta share what you have"
                ,"@AlderEYE_007 what? why?"
                ,"Whats the point if we arent sharing information?"
                ,"@AlderEYE_007 are you keeping something too?"};

        //Player: "Who else has read the testimonies?"
        groupDialogue[2][2][3] = new String[]{
                "I havent"
                ,"I doubt theres anything helpful in there"
                ,"Witness testimonies are always inaccurate at best"};
        groupDialogue[2][2][0] = groupDialogue[2][0][2];
        groupDialogue[2][2][1] = new String[]{
                "I wasnt going to say anything but i agree"
                ,"Some of the questions were leading and in general AlderEYE cut off a bunch of potential leads"
                ,"This is another reason i dont think the testimonies are that important"};
        groupDialogue[2][2][2] = new String[]{
                "Not at all"
                ,"Testimonies dont provide any concrete evidence, they only contextualize it after its already been found"
                ,"Plus its all coming from anonymous Chatter users"
                ,"They have no reason to tell the truth"
                ,"@AlderEYE_007 doesnt even know if the users are real victims of the attacks"
                ,"Analyzing the interviews is a total waste of time"
                ,"I think we should be contacting the victim's banks to get information on the victim accounts"
                ,"That would be solid evidence to go off of"};

        //**************************** PROGRESS 4 ******************************************************************
        groupDialogue[4][0][0] = null;
        groupDialogue[4][0][1] = new String[]{"Nice"};
        groupDialogue[4][0][2] = null;
        groupDialogue[4][0][3] = new String[]{
                "You gotta be kidding me"
        };

        groupDialogue[4][1][0] = new String[]{"Shocker"};
        groupDialogue[4][1][1] = null;
        groupDialogue[4][1][2] = new String[]{
                "Really",
                "I said from the start that those testimonies were a waste of time and now it looks like theyve lead us to a dead end",
                "We should drop the website thing and look for something of actual substance",
                "Thats BULLSHIT",
                "Ive done just as much as anybody else here",
                "Remember who discovered the Chatter boards that were targeted?",
                "If you want to call me out then call me out, but at least be right",
                "Otherwise just shut up ffs",
                "Whatever"
        };
        groupDialogue[4][1][3] = new String[]{
                "Im not sure there is one",
                "We should probably move on"
        };

        groupDialogue[4][2][0] = new String[]{
                "Of course i dont, otherwise i would have said something"
                ,"How would i know what 'tonem' is?"
                ,"Why are you asking me?"
        };
        groupDialogue[4][2][1] = null;
        groupDialogue[4][2][2] = null;
        groupDialogue[4][2][3] = null;

        //**************************** PROGRESS 5 ******************************************************************

        groupDialogue[5][0][0] = null;
        groupDialogue[5][0][1] = null;
        groupDialogue[5][0][2] = null;
        groupDialogue[5][0][3] = null;

        groupDialogue[5][1][0] = new String[]{
                "@AlderEYE_007 has new information?"};
        groupDialogue[5][1][1] = new String[]{
                "@AlderEYE_007 has new information?",
                "Gotta love the sugar chunks",
                "One time i baked a batch of brownies with the sugar chunks inside",
                "They were the greatest things ive ever tasted",
                "Baked on the outside but soft on the inside",
                "It was like eating sandy mud",
                "Go to hell @AlderEYE_007"};
        groupDialogue[5][1][2] = null;
        groupDialogue[5][1][3] = null;

        groupDialogue[5][2][0] = new String[]{
                "Who?",
                "What?"
        };
        groupDialogue[5][2][1] = null;
        groupDialogue[5][2][2] = null;
        groupDialogue[5][2][3] = new String[]{
                "Oh what?",
                "Is this the 'tonem' thing again?"
        };
    }

    @Override
    public void setDmDialogue() {
        dmDialogue = new String[7][3][4][];

        dmDialogue[0] = new String[][][]{null,null,null,null};

        dmDialogue[1][0][0] = null;
        dmDialogue[1][0][1] = null;
        dmDialogue[1][0][2] = null;
        //Player: Hey!
        dmDialogue[1][0][3] = null;

        dmDialogue[1][1][0] = new String[]{
                "Good luck finding anything"
                ,"It wont be easy"};
        dmDialogue[1][1][1] = new String[]{
                "For me it comes naturally"
                ,"The cases ive read about in the news all have had obvious conclusions in my opinion"
                ,"I dont think true investigators need to be taught"};
        dmDialogue[1][1][2] = new String[]{
                "They could be but i doubt they are"
                ,"All the victims have already spoken to the police and if they" +
                " said anything important it would already have been looked into"
                ,"Imo its a dead end and a waste of time"};
        //Player: Hey, you seem like a good investigator. Could you give me some tips?
        dmDialogue[1][1][3] = new String[]{
                "Follow your instincts"
                ,"The best way to get better at it is to do it"
                ,"If youre trying and failing, youre getting better"
                ,"Just keep trying"};

        dmDialogue[1][2][0] = new String[]{
                "Investigating just comes naturally to some people"
                ,"All i did was follow my instincts"
                ,"If you keep searching, im sure youll come up with something"};
        dmDialogue[1][2][1] = new String[]{
                "Not really"
                ,"Me and aldereye found things because we followed our own suspicions"
                ,"Its different points of view and ideas that will solve this case"
                ,"Itll be best if you just search on your own and look for things that we havent thought of yet"};
        dmDialogue[1][2][2] = null;
        //Player: Hi, could you help me get started? I'm totally lost.
        dmDialogue[1][2][3] = new String[]{
                "If i knew what to do the case would already be solved"
                ,"Just follow your instincts and look into what you think is important"
                ,"Something may or may not come from it"
                ,"But thats investigating"};

        dmDialogue[2][0][0] = null;
        dmDialogue[2][0][1] = null;
        dmDialogue[2][0][2] = null;
        dmDialogue[2][0][3] = new String[]{
                "Im still looking into the topics i mentioned"
                ,"Because we have no exact links there is a lot to look through"
                ,"I hope youre also looking into those topics"
                ,"Its the only helpful thing any of us can do right now"};

        dmDialogue[2][1][0] = null;
        dmDialogue[2][1][1] = null;
        dmDialogue[2][1][2] = null;
        dmDialogue[2][1][3] = null;

        dmDialogue[2][2][0] = null;
        dmDialogue[2][2][1] = null;
        dmDialogue[2][2][2] = new String[]{
                "I'd rather hit a dead-end sooner than later"
                ,"That way we can move on and look at something actually significant"
                ,"You could help by researching those topics i mentioned"
                ,"Thats the best thing we can do right now"};
        dmDialogue[2][2][3] = new String[]{
                "It just seems like AlderEYE is entirely overconfident in all the assumptions theyre making"
                ,"Ill help look into the links but if it ends up being dead-end dont say i didnt warn you"};

        dmDialogue[3] = null;
        dmDialogue[4] = null;
        dmDialogue[5] = null;
        dmDialogue[6] = null;
    }
}
