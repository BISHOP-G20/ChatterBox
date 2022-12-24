package Entity;

import java.awt.*;

public class Mikey extends Character{

    public Mikey(Player player){
        this.player = player;
        name = "Micheal 'mikey' Lee";
        username = "m1key_m0use";
        code = "#0509";
        chatColor = Color.BLUE;

        setGroupDialogue();
        setDmDialogue();
    }

    public void setGroupDialogue(){

        //5 X 3 X 4 X n matrix:
        //0-4 for plot progress, 0-2 for branch, 0-3 for player dialogue options,0-n for messages sent during interaction
        //groupDialogue[n][n][3] = responses to player branch choice
        groupDialogue = new String[6][3][4][];


        //  *** BRANCH 0 ***
        //Player option: "Hello!"
        groupDialogue[0][0][3] =  new String[]{
                "Hey there!",
                "Welcome to the Group!",
                "If you have any questions about our investigation, I'm sure one of us can answer it."};
        groupDialogue[0][0][0] = new String[]{
                "AlderEYE_007 generally keeps us organized so I bet she'd know how to help"
                ,"@AlderEYE_007 you online?"};
        groupDialogue[0][0][1] = new String[]{};
        groupDialogue[0][0][2] = new String[]{
                "We've got a start for sure!"
                ,"@AlderEYE says 'we' like she wasn't the one who tracked down that info alone."
                ,"SOAP OPERAS?"
                ,"That's the one my g'ma was on."
                ,"My grandmother was a victim of the attacks."
                ,"That's why I'm here."
                ,"Probably not, she only talked to those friends through chatter."
                ,"And, most of the victims stopped using the site."};


        // *** BRANCH 1 ***
        //Player option: "Hey, just joined. How can I help?"
        groupDialogue[0][1][3] = new String[]{
                "Welcome to the Group!"
                ,"AlderEYE_007 generally keeps us organized so I bet she'd know how to help"
                ,"@AlderEYE_007 you online?"};
        groupDialogue[0][1][0] = new String[]{
                "@AlderEYE says 'we' like she wasn't the one who tracked down that info alone."
                ,"SOAP OPERAS?"
                ,"That's the one MY g'ma was on."
                ,"My grandmother was a victim of the attacks."
                ,"That's why I'm here."
                ,"Probably not, she only talked to those friends through chatter."
                ,"And, most of the victims stopped using the site."};
        groupDialogue[0][1][1] = groupDialogue[0][0][1];
        groupDialogue[0][1][2] = groupDialogue[0][0][2];


        // *** BRANCH 2 ***
        //Player option: "You all actually believe there's a case here?"
        groupDialogue[0][2][3] = new String[]{
                "Hey there!"
                ,"At this point, we know for a fact that there's something more going on here"
                ,"Between the three of us, the evidence is overwhelming"};
        groupDialogue[0][2][0] = groupDialogue[0][0][0];
        groupDialogue[0][2][1] = groupDialogue[0][0][1];
        groupDialogue[0][2][2] = groupDialogue[0][0][2];

        //**************************** PROGRESS 1 ******************************************************************

        groupDialogue[1][0][3] = new String[]{};
        groupDialogue[1][0][0] = new String[]{};
        groupDialogue[1][0][1] = new String[]{};
        groupDialogue[1][0][2] = new String[]{};

        groupDialogue[1][1][3] = new String[]{};
        groupDialogue[1][1][0] = new String[]{};
        groupDialogue[1][1][1] = new String[]{};
        groupDialogue[1][1][2] = new String[]{};

        groupDialogue[1][2][3] = new String[]{
                "Weird..."};
        groupDialogue[1][2][0] = new String[]{};
        groupDialogue[1][2][1] = new String[]{};
        groupDialogue[1][2][2] = new String[]{};

        //**************************** PROGRESS 2 ******************************************************************

        //Player: "I've found a pattern!"
        groupDialogue[2][0][3] = new String[]{
                "No way! That's awesome!",
                "What did you find?"};
        groupDialogue[2][0][0] = new String[]{
                "Really!?"
                ,"Great, a lead!"
                ,"Lets start looking into those websites then."
                ,"I can ask my grandmother and see if she can help with the links. She was definitely on Chatter two years ago."
                ,"Me three!"};
        groupDialogue[2][0][1] = new String[]{
                "Aw man. You got my hopes up!"};
        groupDialogue[2][0][2] = new String[]{
                "Ok, lets calm down"
                ,"@Lazarus AlderEYE has a point, we haven't contributed anything yet."
                ,"And while I also am not a fan of withholding, AlderEYE has no reason to let us leech onto her investigation for no reason."
                ,"But, now that we know that that is not the case lets keep up the momentum."
                ,"@AlderEYE_007 I can ask my grandmother and see if she can help with the links. She was definitely on Chatter two years ago."
                ,"Me three!"};

        //Player: "Has anybody found anything?"
        groupDialogue[2][1][3] = new String[]{"Nothing to report just yet!"};
        groupDialogue[2][1][0] = new String[]{"Looks like we're all struggling."};
        groupDialogue[2][1][1] = groupDialogue[2][0][2];
        groupDialogue[2][1][2] = null;

        //Player: "Who else has read the testimonies?"
        groupDialogue[2][2][3] = new String[]{
                "@" + player.getUsername() + " I have!"
                ,"Lots of interesting details in there!"
                ,"Isn't @southTREEArnold such a character?"
                ,"Anyway, did you find anything?"};
        groupDialogue[2][2][0] = groupDialogue[2][0][2];
        groupDialogue[2][2][1] = new String[]{
                "@" + player.getUsername() + " that was uncalled for."
                ,"AlderEYE_007 is a great investigator and has done all they can to get to the bottom of this."
                ,"There's no reason to come after them. I think the interviews could have hardly been conducted better!"};
        groupDialogue[2][2][2] = new String[]{
                "It's a good idea, but the banks wouldn't cooperate, would they?"
                ,"I mean, isn't going to the banks the same thing as going to the police?"
                ,"@AlderEYE_007 it is?"};

        //**************************** PROGRESS 4 ******************************************************************
        groupDialogue[4][0][0] = new String[]{
                "You found another clue already?!",
                "Gees @" + player.getUsername() + ", you gotta be pretty sharp to notice that!"
                ,"Could it be a word or a name?"
        };
        groupDialogue[4][0][1] = null;
        groupDialogue[4][0][2] = new String[]{
                "'tonem'? I've never heard of that in my life!",
                "Yes ma'am!"
        };
        groupDialogue[4][0][3] = new String[]{
                "Again!?!"
                ,"Thats awesome! You're on a roll!"
        };

        groupDialogue[4][1][0] = new String[]{
                "Me too, to be honest."
        };
        groupDialogue[4][1][1] = new String[]{
                "You found another clue already?!"
                ,"Gees @" + player.getUsername() + ", you gotta be pretty sharp to notice that!"
                ,"Could it be a word or a name?"
                ,"Yes ma'am!"
        };;
        groupDialogue[4][1][2] = new String[]{
                "HEY",
                "EVERYBODY NEEDS TO CALM DOWN",
                "I get that we're all frustrated. We have good reason to be. But, taking it out on each other is only going to" +
                        " impede us further.",
                "Everybody is doing their best. There is no need to go for anybody's throat. OK?"
        };
        groupDialogue[4][1][3] = new String[]{
                "Not me. I'm stuck."
        };

        groupDialogue[4][2][0] = null;
        groupDialogue[4][2][1] = new String[]{
                "You found another clue already?!"
                ,"Gees @" + player.getUsername() + ", you gotta be pretty sharp to notice that!"
                ,"Could it be a word or a name?"
                ,"Yes ma'am!"
        };
        groupDialogue[4][2][2] = new String[]{
                "Ok...?"
        };
        groupDialogue[4][2][3] = new String[]{
                "'tonem'? I've no idea",
                "Any ideas @AlderEYE_007?"};

        //**************************** PROGRESS 5 ******************************************************************

        groupDialogue[5][0][0] = new String[]{
                "Seriously??",
                "That gotta evidence, right @AlderEYE_007?",
                "I mean what good reason could there be for that?",
                "You don't want to use the GC?",
                "Why?"};
        groupDialogue[5][0][1] = new String[]{"Alright then."};
        groupDialogue[5][0][2] = null;
        groupDialogue[5][0][3] = new String[]{"Umm... Yes."};

        groupDialogue[5][1][0] = new String[]{
                "Oh, yeah!",
                "@AlderEYE_007 you totally said the same thing to me.",
                "What did you find?"
        };
        groupDialogue[5][1][1] = new String[]{
                "I just got a blueberry muffin!",
                "Its the kind with the big sugar grains sprinkled on top.",
                "Omfg it's so good!",
                "I could die right here and I'd be happy."
        };
        groupDialogue[5][1][2] = groupDialogue[5][0][0];
        groupDialogue[5][1][3] = null;

        groupDialogue[5][2][0] = new String[]{
                "I doubt that has anything to do with the case",
                "Whoever made them was probably just in a rush and didn't scale the images properly.",
                "Making a website is difficult, especially under a time constraint.",
                "I'm sure they tried their best, right @AlderEYE_007?",
                "Agreed!"
        };
        groupDialogue[5][2][1] = groupDialogue[5][0][0];
        groupDialogue[5][2][2] = null;
        groupDialogue[5][2][3] = new String[]{
                "Another clue?!",
                "What did you find!?"};
    }

    @Override
    public void setDmDialogue() {
        dmDialogue = new String[7][3][4][];

        dmDialogue[0] = new String[][][]{null,null,null,null};

        dmDialogue[1][0][0] = new String[]{
                "Unfortunately, I'm stuck on AlderEYE's testimonies."
                ,"There's a clue somewhere in them, but I can't seem to find it."
                ,"To be honest, I'm pretty frustrated with myself. But, I'm not going to quit anytime soon. No way!"
                ,"AlderEYE_007 and Lazarus have been helpful though. I've been picking up strategies from them."
                ,"The big thing seems to be patterns."
                ,"Like: what is the same between all of the testimonies, ya know?"};
        dmDialogue[1][0][1] = new String[]{
                "Thanks. Its been really tough because she can't support herself anymore"
                ,"I've been helping her out since it happened, but on my salary alone we're barely making ends meet"
                ,"No, she does know any more than anybody else."
                ,"It happened just like the other testimonies say. No warning or sign of robbery."
                ,"It's all so frustrating."};
        dmDialogue[1][0][2] = new String[]{
                "There's definitely something significant about those three, but I can't piece it together myself."
                ,"I only know what my grandmother told me about the Soap Opera board." +
                " And from what I can tell, its activity is just like all the others."
                ,"Maybe there is something more in the testimonies?"};
        //Player: Hey, thanks for welcoming me into the group! I think together we can get to the bottom of this.
        dmDialogue[1][0][3] = new String[]{
                "Of course! And, I know we can."
                ,"One small clue could break open the whole investigation! We just need to find it."};

        dmDialogue[1][1][0] = new String[]{
                "May 9th"
                ,"The date is burnt into my memory. Well, both of our memories."
                ,"It happened just like the other testimonies say. No warning or sign of robbery."
                ,"I've already been over everything with AlderEYE and Lazarus of course. There isn't much to tell though."
                ,"I just wish the police did something more. I mean, she's in her 80s, retired, and has no history" +
                " of erratic financial decisions. She was right in the middle of finding an assisted living community."
                ,"HOW CAN THEY NOT BE SUSPICIOUS OF THE CIRCUMSTANCES???"
                ,"It's all so frustrating."};
        dmDialogue[1][1][1] = new String[]{
                "We've become very close since I moved in with her."
                ,"There was a long time I didn't get to see her. She moved away when I was in middle school."
                ,"Now we're making for lost time I suppose. She needs a lot of help around the house," +
                " and I'm glad I can be there for her."
                ,"I think some people might get tired helping as much as she needs. Between getting medications," +
                " helping her up and down the stairs, and general house care, it can be a lot."
                ,"But, I love her. And, its not all the time."};
        dmDialogue[1][1][2] = new String[]{
                "I give tours to disabled guests and a big theme park."
                ,"Its the most rewarding work. I feel so lucky that I got hired for it!"};
        //Player: Hi, I'm sorry to hear that your grandmother was one of the victims.
        dmDialogue[1][1][3] = new String[]{
                "Thanks. Its been really tough because she can't support herself anymore"
                ,"I've been helping her out since it happened, but on my salary alone we're barely making ends meet"
                ,"If we can prove that what happened was an attack, the bank will have to cover the lost funds."
                ,"We might even be able to put the sicko who did this behind bars."
                ,"Nothing can justify ruining innocent lives like the attacker did. It's pure evil."};

        dmDialogue[1][2][0] = new String[]{
                "Me too! But I haven't found anything yet."
                ,"This is my first time trying to investigate anything, so I don't have any of the skills."
                ,"AlderEYE_007 and Lazarus are really smart though. I've been picking up strategies from them."
                ,"The big thing seems to be patterns."
                ,"Like: what is the same between all of the testimonies, ya know?"};
        dmDialogue[1][2][1] = new String[]{
                "Getting started is hard. I've been struggling with the same thing because I'm so new to investigating."
                ,"I think all we can do right now is go through the testimonies and try to find a clue"
                ,"I mean, unless you come up with some other kind of research which would help"
                ,"But, if you're ever really lost you can talk to AlderEYE or Lazarus. They've always been there to help me out"};
        dmDialogue[1][2][2] = new String[]{
                "I'm stuck on AlderEYE's testimonies."
                ,"There's a clue somewhere in them, but I can't seem to find it."
                ,"To be honest, I'm pretty frustrated with myself. But, I'm not going to quit anytime soon. No way!"};
        //Player: Hey
        dmDialogue[1][2][3] = new String[]{
                "Hello!"
                ,"Hows your research going?"};

        dmDialogue[2] = null;

        //Player: "Did you talk to your grandmother?"
        dmDialogue[3][0][0] = new String[]{
                "Exactly!"
                ,"Except she said the site wasn't for one specific home, but for getting an advisor." +
                "The advisor helps find a community that fits your specific needs."
                ,"I thought it sounded like a great idea, but she said no advisor ever gotten in touch after she signed up."};
        dmDialogue[3][0][1] = new String[]{
                "Awesome!"
                ,"I'll keep looking into those sites Lazarus was talking about."};
        dmDialogue[3][0][2] = new String[]{
                "Oh, I don't mind answering."
                ,"Yes, she was. Shes in her 80s and can't really take care of herself anymore."
                ,"I'd been taking care of her, but she didn't want to be a burden on my life. So she told me she was shopping around."
                ,"That was all before the attacks though. Now theres no way she could afford to move to such a place."
                ,"Its really a shame. Not because I have to take care of her. I really don't mind. But, I think she would" +
                " be happier at a retirement home. She could be with more people her age and socialize. She could also get the" +
                " proper care she needs for her Osteoarthritis."
                ,"I truly am sorry for her."};
        dmDialogue[3][0][3] = new String[]{
                "I did."
                ,"She says that one of the links lead to a website for finding assisted living communities."
                ,"She says that that's the only one she ever clicked on and that she can't remember the exact name."
                ,"I've already DMed AlderEYE and Lazarus about it."
                ,"We're really making progress on this thing!"};

        dmDialogue[3][1][0] = new String[]{
                "Oh, right!"
                ,"AlderEYE_007 is a her"
                ,"We've been DMing a little bit on the side."
                ,"Mostly just her giving me advice on what to look at next and how to 'think critically' about data."
                ,"Shes incredibly smart. If anybody is going to solve this case, its going to be her."};
        dmDialogue[3][1][1] = new String[]{
                "I did a little."
                ,"Lazarus just wants everybody to share what they have so we can keep moving."
                ,"They said they were ok, but I think they're still annoyed with AlderEYE."
                ,"If you ask me, I don't think Lazarus trusts AlderEYE."};
        dmDialogue[3][1][2] = new String[]{
                "I have!"
                ,"She says that one of the links lead to a website for finding assisted living communities."
                ,"She says that that's the only one she ever clicked on and that she can't remember the exact name."
                ,"I've already DMed AlderEYE and Lazarus about it."
                ,"We're really making progress on this thing!"};
        dmDialogue[3][1][3] = new String[]{
                "Yeah, but I can understand the sentiment."
                ,"I think Lazarus got a little too aggressive."
                ,"Still, I also wonder what AlderEYE's reasoning was for not telling us what she found."
                ,"I mean, the reasons other than the one she mentioned."
                ,"I don't know. I always appreciate communication, but at the end of the day I still trust her."};

        dmDialogue[3][2][0] = dmDialogue[3][0][0];
        dmDialogue[3][2][1] = dmDialogue[3][0][1];
        dmDialogue[3][2][2] = dmDialogue[3][0][2];
        dmDialogue[3][2][3] = new String[]{
                "I have! I asked my grandmother about the links."
                ,"She says that one of them leads to a website for finding assisted living communities."
                ,"She says that that's the only one she ever clicked on and that she can't remember the exact name."
                ,"I've already DMed AlderEYE and Lazarus about it."
                ,"We're really making progress on this thing!"};

        dmDialogue[4][0][0] = new String[]{
                "I really hope not. We need both of them if we're ever going to solve this thing.",
                "Their interactions are getting more heated, which is making me worried.",
                "But, I don't know. I'm just going to keep trying my best to keep everybody on good terms with one another."
        };
        dmDialogue[4][0][1] = new String[]{
                "I couldn't tell you.",
                "I've sort of always been like this. Since I was young at least.",
                "For me, helping others is just what feels best and most natural.",
                "In many ways its informed the course of my life. From friends to hobbies to my job.",
                "My mom says kindness is in my nature. That seems pretty strong to me, but I do like helping people."
        };
        dmDialogue[4][0][2] = new String[]{
                "I have no idea. They do seem extra tense.",
                "Perhaps they have something going on in the real world.",
                "Everybody is going through their own struggle.",
                "I don't think we'll ever know all that's going on. But if Lazarus is struggling with something, I hope they get through it soon.",
                "For their own sake, of course."
        };
        dmDialogue[4][0][3] = new String[]{
                "Oh, of course!",
                "Yeah, they were getting out of hand. I get being frustrated but Lazarus was really pushing it.",
                "I just want us to be successful, but its becoming harder to ensure that."
        };

        dmDialogue[4][1][0] = new String[]{
                "I guess so.",
                "But still, I'm just not very good at this.",
                "Nothing like you and AlderEYE. You two are world class!",
                "A real Sherlock and Watson dynamic duo!"
        };
        dmDialogue[4][1][1] = new String[]{
                "I know.",
                "I just want to help my grandma out. She deserves better than what shes got.",
                "Whats happened to her is just criminal (no pun intended).",
                "I can't give up until somethings been done for her. I just can't."
        };
        dmDialogue[4][1][2] = new String[]{
                "Well, things were getting out of hand. I get being frustrated but Lazarus was really pushing it.",
                "I just want us to be successful, but its becoming harder to ensure that.",
                "I'm glad you think the mediation helping though."
        };
        dmDialogue[4][1][3] = new String[]{
                "No. I've just been scrolling up and down the pages over and over again.",
                "My scroll bar is acting like a pogo stick.",
                "Its so frustrating not to be able to give the group more. I feel like dead weight."
        };

        dmDialogue[4][2][0] = dmDialogue[4][1][0];
        dmDialogue[4][2][1] = dmDialogue[4][1][1];
        dmDialogue[4][2][2] = dmDialogue[4][1][2];
        dmDialogue[4][2][3] = new String[]{
                "Hey, how are ya?",
                "I know I've already said it, but you've really been crushing this investigation!",
                "I thought AlderEYE was the best there is but you're at least as good as she is!",
                "Hopefully, I can contribute more to our research soon. I'm afraid my investigative instinct isn't as strong as yours."
        };

        dmDialogue[5] = null;

        dmDialogue[6][0][0] = null;
        dmDialogue[6][0][1] = null;
        dmDialogue[6][0][2] = null;
        dmDialogue[6][0][3] = null;

        dmDialogue[6][1][0] = null;
        dmDialogue[6][1][1] = null;
        dmDialogue[6][1][2] = null;
        dmDialogue[6][1][3] = null;

        dmDialogue[6][2][0] = null;
        dmDialogue[6][2][1] = null;
        dmDialogue[6][2][2] = null;
        dmDialogue[6][2][3] = null;
    }
}
