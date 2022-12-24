package Entity;

import java.awt.*;

public class Irene extends Character{
    public Irene(Player player){
        this.player = player;

        name = "Irene Alder";
        username = "AlderEYE_007";
        code = "#2835";
        chatColor = new Color(10, 121, 37);

        setGroupDialogue();
        setDmDialogue();
    }

    public void setGroupDialogue() {

        //5 X 3 X 4 X n matrix:
        //0-4 for plot progress, 0-2 for branch, 0-3 for player dialogue options,0-n for messages sent during interaction
        //groupDialogue[n][n][3] = responses to player branch choice
        groupDialogue = new String[6][3][4][];

        //**************************** PROGRESS 0 ******************************************************************


        //  *** BRANCH 0 ***
        //Player option: "Hello!"
        groupDialogue[0][0][3] =  new String[]{};
        groupDialogue[0][0][0] = new String[]{
                "im here"
                ,"how you can help depends on your strengths"
                ,"what are you good at?"};
        groupDialogue[0][0][1] = new String[]{
                "the police are listening to the banks"
                ,"the bank say all the transactions were legit"
                ,"they haven't been any help"};
        groupDialogue[0][0][2] = new String[]{
                "the attacks started june 19th then sporadically continued through october the next year"
                ,"we think the last attack happened sometime in november"
                ,"thats about it though"
                ,"..."
                ,"yes?"
                ,"@m1key_m0use what are you talking about?"};

        //  *** BRANCH 1 ***
        //Player option: "Hey, just joined. How can I help?"
        groupDialogue[0][1][3] = groupDialogue[0][0][0];
        groupDialogue[0][1][0] = new String[]{
                "finding out anything more than what we have would be a start"
                ,"we know the attacks started june 19th then sporadically continued through october the next year"
                ,"and that the last attack happened sometime in november"
                ,"thats about it though"
                ,"..."
                ,"yes?"
                ,"@m1key_m0use what are you talking about?"};
        groupDialogue[0][1][1] = groupDialogue[0][0][1];
        groupDialogue[0][1][2] = groupDialogue[0][0][2];

        //  *** BRANCH 2 ***
        //Player option: "You all actually believe there's a case here?"
        groupDialogue[0][2][3] = groupDialogue[0][0][3];
        groupDialogue[0][2][0] = groupDialogue[0][1][3];
        groupDialogue[0][2][1] = groupDialogue[0][0][1];
        groupDialogue[0][2][2] = groupDialogue[0][0][2];

        //**************************** PROGRESS 1 ******************************************************************

        groupDialogue[1][0][3] = new String[]{
                "a lot actually"
                ,"i didnt think that we were gonna openly share new information but here we go"
                ,"@Lazarus i interviewed the victims that are still active on chatter"
                ,"their testimonies provide a ton of new information which could turn into leads"
                ,"if anybody wants to read them, dm me"};
        groupDialogue[1][0][0] = null;
        groupDialogue[1][0][1] = null;
        groupDialogue[1][0][2] = null;

        groupDialogue[1][1][3] = new String[]{
                "@Lazarus i didnt think that we were gonna openly share new information but here we go"
                ,"i interviewed the victims that are still active on chatter"
                ,"their testimonies provide a ton of new information which could turn into leads"
                ,"if anybody wants to read them, dm me"};
        groupDialogue[1][1][0] = null;
        groupDialogue[1][1][1] = null;
        groupDialogue[1][1][2] = null;

        groupDialogue[1][2][3] = null;
        groupDialogue[1][2][0] = null;
        groupDialogue[1][2][1] = null;
        groupDialogue[1][2][2] = null;

        //**************************** PROGRESS 2 ******************************************************************

        //Player: "I've found a pattern!"
        groupDialogue[2][0][3] = new String[]{
                "interesting"
                ,"yes, what did you find?"};
        groupDialogue[2][0][0] = new String[]{
                "i agree, lets back up"
                ,"saying that all the victims used those links based off of only four testimonies is a stretch"
                ,"but i also think that they are connected to the case somehow"
                ,"that was my conclusion from the testimonies"
                ,"thanks @m1key_m0use i think that talking to your grandmother is a good start"
                ,"@Lazarus looking into the sites is an alright idea"
                ,"ill try and find the actual links"
                ,"@" + player.getUsername() + " why dont you research website related to the topics Lazarus mentioned"
                ,"if anybody needs help, dm me"};
        groupDialogue[2][0][1] = new String[]{
                "youre just wasting everybodys time at this point"
                ,"if youre just going to be annoying well kick you from the gc"};
        groupDialogue[2][0][2] = new String[]{
                "well done"
                ,"i came to the same conclusion"
                ,"a few reasons"
                ,"if nobody else here could come up with anything then theres not much point in working with you"
                ,"dont worry, it was a one time thing"
                ,"next step is to look into those links"
                ,"nobody just happens to have them right?"
                ,"thanks @m1key_m0use, i also think that talking to your grandmother is a good start"
                ,"@Lazarus looking into the sites is an alright idea"
                ,"ill try and find the actual links"
                ,"@" + player.getUsername() + " why dont you research website related to the topics Lazarus mentioned"
                ,"if anybody needs help, dm me"};

        //Player: "Has anybody found anything?"
        groupDialogue[2][1][3] = new String[]{"have you?"};
        groupDialogue[2][1][0] = null;
        groupDialogue[2][1][1] = groupDialogue[2][0][2];
        groupDialogue[2][1][2] = new String[]{
                "hmmm"
                ,"then dont"};

        //Player: "Who else has read the testimonies?"
        groupDialogue[2][2][3] = null;
        groupDialogue[2][2][0] = groupDialogue[2][0][2];
        groupDialogue[2][2][1] = new String[]{
                "excuse me?"
                ,"you clearly have no clue what youre talking about"
                ,"especially coming from a person who has contributed nothing to this investigation"
                ,"if you think you can do a better job then i welcome it"
                ,"but good luck finding anybody who is still active on Chatter and willing to talk"};
        groupDialogue[2][2][2] = new String[]{
                "interesting"
                ,"what should we be spending our time on then?"
                ,"very interesting"};

        //**************************** PROGRESS 4 ******************************************************************
        groupDialogue[4][0][0] = new String[]{
                "is it really?",
                "hes right, i completely missed that myself",
                "well done",
                "i wonder what it means",
                "it could be...",
                "or a code of some sort",
                "i'll look into it",
                "you all keep looking through those websites, theres bound to be something else hidden there"
        };
        groupDialogue[4][0][1] = new String[]{
                "as a matter of fact i havent",
                "ive been stuck since we last spoke",
                "so much so that ive started to search for other leads",
                "what did you find?"
        };
        groupDialogue[4][0][2] = new String[]{
                "hmm",
                "@m1key_m0use me neither",
                "it could be a name, a word, or even a code",
                "ill have to look into it",
                "you all keep looking through those websites, theres bound to be something else hidden there"
        };
        groupDialogue[4][0][3] = new String[]{
                "im impressed",
                "what did you find this time?"
        };

        groupDialogue[4][1][0] = new String[]{
                "unfortunately ive been stuck since we last spoke",
                "in fact its been so bad that ive started looking for other leads",
                "if you have anything to share id be glad to hear it, at least one of us would be making progress"
        };
        groupDialogue[4][1][1] = new String[]{
                "is it really?",
                "hes right, i completely missed that myself",
                "id been stuck for so long i started looking for other leads",
                "well done, youre sharp",
                "i wonder what it means",
                "it could be...",
                "or a code of some sort",
                "i'll look into it",
                "you all keep looking through those websites, theres bound to be something else hidden there"
        };
        groupDialogue[4][1][2] = new String[]{
                "such as...?",
                "youve got nothing, all you do is critique everybody elses work while contributing nothing yourself",
                "@m1key_m0use youre right"
        };
        groupDialogue[4][1][3] = null;

        groupDialogue[4][2][0] = new String[]{"interesting"};
        groupDialogue[4][2][1] = new String[]{
                "is it really?",
                "hes right, i completely missed that myself",
                "id been stuck for so long i started looking for other leads",
                "well done, youre sharp",
                "i wonder what it means",
                "it could be...",
                "or a code of some sort",
                "i'll look into it",
                "you all keep looking through those websites, theres bound to be something else hidden there"
        };
        groupDialogue[4][2][2] = new String[]{
                "again with the time wasting",
                "if you arent adding something to the investigation then keep it to yourself"
        };
        groupDialogue[4][2][3] = new String[]{
                "no clue",
                "whats 'tonem' @" + player.getUsername() + "?"
        };

        //**************************** PROGRESS 5 ******************************************************************

        groupDialogue[5][0][0] = new String[]{
                "yeah @m1key_m0use, that pretty much confirms our suspicions about the links",
                "wow, i really didnt think there would be anything as flagrant as that",
                "ok, you all need to go back to those pages and get a screen shot of those sign-up pages",
                "i want to confirm one more thing before we proceed",
                "when youre finished DM me",
                "no, just DM me"
        };
        groupDialogue[5][0][1] = null;
        groupDialogue[5][0][2] = null;
        groupDialogue[5][0][3] = new String[]{
                "it would be highly irregular",
                "why?"};

        groupDialogue[5][1][0] = new String[]{
                "i have no clue what youre talking about",
                "stop wasting time",
                "keep looking",
                "no",
                "nope",
                "havent found anything",
                "dont know what youre talking about",
                "lets get back to work now"
        };
        groupDialogue[5][1][1] = new String[]{
                "blueberry muffins are ass",
                "banana nut though... lets just say id put a ring on it",
                "i wanna barf after reading that"
        };
        groupDialogue[5][1][2] = groupDialogue[5][0][0];
        groupDialogue[5][1][3] = new String[]{
                "what information?",
                "have you found anything or is this idle chit-chat?"
        };

        groupDialogue[5][2][0] = new String[]{
                "yeah",
                "scaling an image can be tough, especially when the frame size is variable",
                "lets cut George some slack"
        };
        groupDialogue[5][2][1] = groupDialogue[5][0][0];
        groupDialogue[5][2][2] = null;
        groupDialogue[5][2][3] = null;
    }

    public void setDmDialogue() {

        dmDialogue = new String[7][3][4][];

        dmDialogue[0] = new String[][][]{null,null,null,null};

        dmDialogue[1][0][0] = new String[]{
                "im 3 years into studying criminology at uni"
                ,"but ive been obsessed with this stuff since i was a kid"
                ,"so most of my practical understanding is from running my own investigations in prep school"};
        dmDialogue[1][0][1] = new String[]{
                "look through the testimony document and find a pattern"
                ,"ive been combing through it all but it would be best to have more eyes looking for clues"
                ,"ill send it to you now"
                ,"https://HiddenTestimonies/Page/index.php"
                ,"paste it in the Chatter search engine"};
        dmDialogue[1][0][2] = new String[]{
                "the testimonies are the only lead we have right now"
                ,"after we find something in them there will be more to look into"
                ,"do you want the link to the testimonies?"};
        //Player: Hi again, you seem to really know what you're doing. Mind giving me some pointers?
        dmDialogue[1][0][3] = new String[]{
                "honestly im a complete amateur but i try to always review the facts"
                ,"chase down every lead"
                ,"and not contaminate the evidence"
                ,"its basic stuff but its helped me so far"};

        dmDialogue[1][1][0] = new String[]{
                "https://HiddenTestimonies/Page/index.php"
                ,"thats a link to a compilation of all my chat logs with the victims"
                ,"paste it in the Chatter search engine"
                ,"ive been combing through it all but it would be best to have more eyes looking for clues"
                ,"our next lead is somewhere in it. im certain."};
        dmDialogue[1][1][1] = new String[]{
                "ok"
                ,"what is it then?"};
        dmDialogue[1][1][2] = new String[]{
                "im surprised its not obvious"
                ,"i mean are you sure you can help us?"
                ,"the testimonies are all different accounts of the same thing"
                ,"or at least we believe they are"
                ,"so first we can either confirm or disprove this whole investigation by analyzing the stories told"
                ,"then if the testimonies confirm our theory we can look for other similarities in the accounts"
                ,"if we find even one similarity then thats a new lead which could unravel the entire mystery"
                ,"thats whats i KNOW is in the testimonies"};
        //Player: Hey
        dmDialogue[1][1][3] = new String[]{
                "hi"
                ,"do you want the testimonies?"};

        dmDialogue[1][2][0] = new String[]{
                "k"
                ,"make sure to send it in the group chat"};
        dmDialogue[1][2][1] = new String[]{
                "im surprised its not obvious"
                ,"the testimonies are all different accounts of the same thing"
                ,"or at least we believe they are"
                ,"so first we can either confirm or disprove this whole investigation by analyzing the stories told"
                ,"then if the testimonies confirm our theory we can look for other similarities in the accounts"
                ,"if we find even one similarity then thats a new lead which could unravel the entire mystery"
                ,"these accounts are essential"};
        dmDialogue[1][2][2] = new String[]{
                "ive been obsessed with mysteries since i was a kid"
                ,"most of my free time was spent following local ongoing cases"
                ,"now im at uni studying criminology"
                ,"investigating crimes is my whole life"};
        //Player: Hi, could you send me the testimonies?
        dmDialogue[1][2][3] = dmDialogue[1][1][0];

        dmDialogue[2][0][0] = null;
        dmDialogue[2][0][1] = null;
        dmDialogue[2][0][2] = null;
        dmDialogue[2][0][3] = null;
        dmDialogue[2][1][0] = null;
        dmDialogue[2][1][1] = null;
        dmDialogue[2][1][2] = null;
        dmDialogue[2][1][3] = null;
        dmDialogue[2][2][0] = null;
        dmDialogue[2][2][1] = null;
        dmDialogue[2][2][2] = null;
        dmDialogue[2][2][3] = null;

        //Player: "@Lazarus seems really annoyed, right?"
        dmDialogue[3][0][0] = new String[]{
                "i wont say they arent abel to, but from what ive seen so far i doubt they will"
                ,"@m1key_m0use is nice and keeps the group moving but doesnt seem like a good critical thinker"
                ,"@Lazarus is quick to critique but never adds much of substance themself"
                ,"like i said, im not counting them out but youre the only one who has come up with anything"};
        dmDialogue[3][0][1] = new String[]{
                "ive found the names of the websites"
                ,"not the actual links themselves"
                ,"still if you look them up, the sites should be the top result"
                ,"the company names are Divyata Advisor Group, CBD Solutions, and Saudi Princes United Gold"
                ,"those there are the only sites the links lead to"
                ,"looks like @Lazarus was way off"
                ,"look around the websites and ill dm the others the site names"};
        dmDialogue[3][0][2] = new String[]{
                "you seem to be a bit sharper than @m1key_m0use so ill tell you"
                ,"any investigator or even any competent non-investigator knows that interviewing relevant parties at the beginning of an investigation" +
                "is vital to finding leads"
                ,"only going off of evidence from the get-go can cause major elements of a case to be overlooked"
                ,"not only that, but the testimonies i recorded have a clear pattern between them all"
                ,"im not sure if @Lazarus is a bad investigator"
                ,"wants to be the smartest in the group"
                ,"or something else"
                ,"but from now on, ill be reading their messages more closely"};
        dmDialogue[3][0][3] = new String[]{
                "it doesnt seem like they appreciate being out of the loop"
                ,"to be fair, i dont either"
                ,"anyway, im glad you also noticed the urls mentioned in all the testimonies"
                ,"i think together well solve this case"};

        dmDialogue[3][1][0] = new String[]{
                "good",
                "if you find anything, say so in the group chat"};
        dmDialogue[3][1][1] = new String[]{
                "maybe"
                ,"regardless of the cause, chasing down a false lead is a waste of time"
                ,"perhaps you dont value your own time enough to see things that way"};
        dmDialogue[3][1][2] = new String[]{
                "they do appear that way"
                ,"i suspect that they are supposed to"
                ,"but remember, they were all mass spammed across the entire platform together"
                ,"they must hold something in common other than that event"
                ,"im sure of it"};
        dmDialogue[3][1][3] = new String[]{
                "you havent found anything because what Lazarus told us was wrong"
                ,"ive found the websites and none of them are for torrenting or jewelry"
                ,"the site names are Divyata Advisor Group, CBD Solutions, and Saudi Princes United Gold"
                ,"if you search them they should come right up"
                ,"sorry Lazarus wasted your time"};

        dmDialogue[3][2][0] = dmDialogue[3][0][2];
        dmDialogue[3][2][1] = dmDialogue[3][1][0];
        dmDialogue[3][2][2] = dmDialogue[3][1][2];
        dmDialogue[3][2][3] = dmDialogue[3][0][1];

        dmDialogue[4][0][0] = null;
        dmDialogue[4][0][1] = new String[]{
                "anything that connects the websites directly to the crime",
                "terms of service that extend beyond whats legal or reasonable",
                "copyright infringement",
                "false advertising",
                "requests for banking information or social security information",
                "like the stuff that would allow somebody to be able to get into another person's bank account",
                "affiliation with a known criminal organization",
                "just use your imagination",
                "if it seems suspicious, record it"
        };
        dmDialogue[4][0][2] = new String[]{
                "its funny how aligned our instincts are sometimes",
                "ive begun to have the same suspicion",
                "its certainly too soon to tell though",
                "trying to guess what theyre up to or why would be too much of a leap at this point",
                "but if there really is something more going on with Lazarus, theyll reveal themselves soon enough"
        };
        dmDialogue[4][0][3] = new String[]{
                "you can never be 100% sure of anything, but i think theres a good chance something else incriminating is there",
                "look at everything",
                "the fine print",
                "any tabs on website",
                "links that lead to other places",
                "make sure you know the websites top to bottom before moving on"
        };

        dmDialogue[4][1][0] = null;
        dmDialogue[4][1][1] = new String[]{
                "im studying to become one",
                "currently i intern at a local police department under a detective",
                "im so close to my dream i can almost touch it",
                "maybe if i can solve this case theyll let me on to their current investigations and ill be made" +
                        "detective right out of university",
                "i hope they will at least"
        };
        dmDialogue[4][1][2] = new String[]{
                "no clue",
                "i get being frustrated with a lack of progress but with Lazarus it seems to be something more than that",
                "i dont know",
                "im keeping an eye on them though"};
        dmDialogue[4][1][3] = new String[]{
                "i may have",
                "i need to verify that its legitimate before sending it",
                "just keep looking around those websites"
        };

        dmDialogue[4][2][0] = new String[]{
                "i am as well",
                "hes a good mediator",
                "were lucky to have him keeping the group together"
        };
        dmDialogue[4][2][1] = new String[]{
                "its funny how aligned our instincts are sometimes",
                "ive begun to have the same suspicion",
                "its certainly too soon to tell though",
                "trying to guess what theyre up to or why would be too much of a leap at this point",
                "but if there really is something more going on with Lazarus, theyll reveal themselves soon enough"
        };
        dmDialogue[4][2][2] = dmDialogue[4][1][3];
        dmDialogue[4][2][3] = new String[]{
                "no clue",
                "i get being frustrated with a lack of progress but with Lazarus it seems to be something more than that",
                "i dont know",
                "im keeping an eye on them though"
        };

        dmDialogue[5] = null;

        dmDialogue[6][0][0] = new String[]{
                "oh lord",
                "George must have messed up the code",
                "you arent supposed to be able to reach the websites anymore",
                "its this whole thing that brings about the climax of this entire narrative",
                "well just sit tight im sure hell fix it eventually"
        };
        dmDialogue[6][0][1] = new String[]{
                "oh good",
                "i was really confused for a second there",
                "i mean mikey said that they were down and i cant see them so that wouldve been really weird",
                "anyway, whats happened is that ive forced Lazarus to reveal themself",
                "notice that right after you mentioned the smoking gun on those sign-up pages the sites go down?",
                "theres no way thats a coincidence",
                "Lazarus has been trying to direct us away from those websites from the start and now that" +
                        " we know they are involved in the robberies, they go down",
                "Lazarus is trying to stop us from solving this case, i dont know why, but im certain hes involved" +
                        " in the whole thing somehow",
                "were in the final act @" + player.getUsername(),
                "https://criminologyCracker/heistof84/suspect.com",
                "thats a link to a site detailing a string of bank robberies that happened awhile ago",
                "its a long story but ive talked to the woman who created the page and its all legit",
                "she and i are certain that one of the suspects she refers to on her page is our criminal",
                "if you want to close this case, figure out which suspect did this and submit a police report"

        };
        dmDialogue[6][0][2] = new String[]{
                "i cant access them",
                "theyre offline",
                "removed",
                "theyve been taken 'down'"
        };
        dmDialogue[6][0][3] = new String[]{
                "you did?",
                "...",
                "really?",
                "how? theyre all down for me"
        };

        dmDialogue[6][1][0] = new String[]{
                "remember that information i was trying to confirm?",
                "well basically i found a website that details run of bank heists that went down a while ago",
                "the method of crime described fits what was in the testimonies EXACTLY",
                "the page seemed too good to be true so i got in touch with the woman who created it",
                "after she verified everything on the website i filled her in on our investigation",
                "she agrees what happened then and the attacks a few months ago must be related",
                "on the page she even includes a list of top suspects for her investigation. our criminal has to be among them",
                "if you want to try solving this whole thing heres the link",
                "https://criminologyCracker/heistof84/suspect.com",
                "when youve figured it out submit a police report and all the important evidence we've found up until now",
                "good luck"
        };
        dmDialogue[6][1][1] = new String[]{
                "theres no way",
                "whoever pulled this off is smart enough to get far away and not implicate themselves directly",
                "by taking down the websites right after our conversation about the SSN request, Lazarus basically implicated themself",
                "also i know for a fact that Lazarus isnt capable of putting something like this together",
                "when the group was first started Lazarus and i DMed a little",
                "i was curious about their investigative capabilities",
                "it quickly became obvious that Lazarus, above all, is a poser",
                "they like to come off as the smartest in the room but in actuality barely know anything",
                "its not Lazarus, no shot"
        };
        dmDialogue[6][1][2] = new String[]{
                "yes, i can tell you now",
                "i found a website that details run of bank heists that went down a while ago",
                "the method of crime described fits what was in the testimonies EXACTLY",
                "the page seemed too good to be true so i got in touch with the woman who created it",
                "after she verified everything on the website i filled her in on our investigation",
                "she agrees what happened then and the attacks a few months ago must be related",
                "on the page she even includes a list of top suspects for her investigation. our criminal has to be among them",
                "if you want to try solving this whole thing heres the link",
                "https://criminologyCracker/heistof84/suspect.com",
                "when youve figured it out submit a police report and all the important evidence we've found up until now",
                "good luck"
        };
        dmDialogue[6][1][3] = new String[]{
                "whats happened is that weve forced Lazarus to reveal themself",
                "notice that right after you mentioned the smoking gun on those sign-up pages the sites go down?",
                "theres no way thats a coincidence",
                "Lazarus has been trying to direct us away from those websites from the start and now that" +
                        " we know they are involved in the robberies, they go down",
                "Lazarus is trying to stop us from solving this case, i dont know why, but im certain hes involved" +
                        " in the whole thing somehow"
        };

        dmDialogue[6][2][0] = new String[]{
                "https://criminologyCracker/heistof84/suspect.com",
                "submit all your evidence, including the name of the criminal, when youve figured it out",
                "good luck"
        };
        dmDialogue[6][2][1] = dmDialogue[6][1][3];
        dmDialogue[6][2][2] = new String[]{
                "theres no way",
                "whoever pulled this off is smart enough to get far away and not implicate themselves directly",
                "by taking down the websites right after our conversation about the SSN request, Lazarus basically implicated themself",
                "also i know for a fact that Lazarus isnt capable of putting something like this together",
                "when the group was first started Lazarus and i DMed a little",
                "i was curious about their investigative capabilities",
                "it quickly became obvious that Lazarus, above all, is a poser",
                "they like to come off as the smartest in the room but in actuality barely know anything",
                "its not Lazarus, no shot"
        };
        dmDialogue[6][2][3] = new String[]{
                "yes now i can tell you",
                "ive found a website that details run of bank heists that went down a while ago",
                "the method of crime described fits what was in the testimonies EXACTLY",
                "the page seemed too good to be true so i got in touch with the woman who created it",
                "after she verified everything on the website i filled her in on our investigation",
                "she agrees what happened then and the attacks a few months ago must be related",
                "on the page she even includes a list of top suspects for her investigation. our criminal has to be among them",
                "if you want to try solving this whole thing, i can send you the link"
        };
    }
}
