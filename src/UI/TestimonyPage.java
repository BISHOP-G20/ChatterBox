package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static Main.GameFrame.EVIDENCE_LISTENER;
import static Main.GameFrame.GAME_DIMENSION;

import static java.awt.Font.BOLD;

public class TestimonyPage extends JPanel {

    private final String PAGE_URL = "https://hiddentestimonies/page/index.php";
    private final SearchEngine searchEngine;
    private final JTextArea RETURN_AREA = new JTextArea("\t\t\tBack");
    private final JTextPane TEXT_PANE = new JTextPane();
    private final JScrollPane SCROLL_PANE = new JScrollPane(TEXT_PANE);
    private final JLabel TITLE_LABEL = new JLabel("User Testimonies");
    private final GroupLayout LAYOUT = new GroupLayout(this);
    private final Font LABEL_FONT = new Font("Univers Condensed", BOLD, 30);
    private final Font RETURN_FONT = new Font("Univers Condensed", BOLD, 18);
    private final Font TEXT_FONT = new Font("Courier New", Font.BOLD, 13);

    public TestimonyPage(SearchEngine searchEngine){
        this.searchEngine = searchEngine;
        setBackground(Color.DARK_GRAY);
        setTitleLabel();
        setTextPane();
        setScrollPane();
        setTextArea();
        setPanelLayout();
        setName("User Testimonies");
    }

    private void setTitleLabel(){
        TITLE_LABEL.setForeground(Color.WHITE);
        TITLE_LABEL.setFont(LABEL_FONT);
    }

    private void setTextPane(){
        TEXT_PANE.setEditable(false);
        TEXT_PANE.setForeground(Color.WHITE);
        TEXT_PANE.setBackground(Color.DARK_GRAY);
        TEXT_PANE.setFont(TEXT_FONT);
        TEXT_PANE.setMargin(new Insets(15,10,15,10));
        TEXT_PANE.addMouseListener(EVIDENCE_LISTENER);
        TEXT_PANE.setText("\t\t\t\tUser: BahamaMama985\n\n\n" +
                "AlderEYE_007: I appreciate your willingness to tell me about your experience\n\n" +
                "BahamaMama985: Are you kidding? Not even the police will listen to what I have to say. I should be thanking you.\n\n" +
                "AlderEYE_007: Well, don't just yet. Could you start by telling me about when you were attacked\n\n" +
                "BahamaMama985: My savings account was drained August 5th, a few months after the first reported attack\n" +
                "I went to an ATM to make a deposit on the 8th\n" +
                "Whenever I deposit money into one of my accounts I always get a receipt with the amount deposited and" +
                " the account total on it\n" +
                "That day both amounts were the same\n" +
                "I then went to one of my bank's locations to talk to a teller\n" +
                "She was very confused about what I told her because full paperwork for the account withdrawal" +
                " had been submitted over a week before the funds were transferred\n" +
                "I kept telling her that I had never sent in any paperwork but she didn't believe me\n" +
                "She told me that if I was telling the truth I could go to the police and report an identity theft\n" +
                "Of course I tried that immediately and the PD said they'd open an investigation\n" +
                "A bit over a month later they called me and said they found no evidence of theft\n" +
                "The officer I spoke to was empathetic but said the department couldn't do anything without proof\n\n" +
                "AlderEYE_007: Is that the full extent of your interactions with the bank and the police?\n\n" +
                "BahamaMama985: Pretty much\n" +
                "I've resubmitted requests for investigation to both every week since it all happened but after" +
                "the 3rd time I haven't gotten any responses\n\n" +
                "AlderEYE_007: Has anything else happened that you believe is related to those events? For example, has" +
                " anybody contacted you claiming to be the attacker or have any of your accounts had activity that" +
                "wasn't you?\n\n" +
                "BahamaMama985: I had to reset my email password shortly after finding out about my empty savings account\n" +
                "I'm certain that the attacker stole my email to get some of the information required by the bank for" +
                "for large fund transfers\n" +
                "I told the police that too but they said that hacking an email account is incredibly difficult" +
                "and that its much more likely that I just forgot my last password\n\n" +
                "AlderEYE_007: Does your email have two-factor?\n\n" +
                "BahamaMama985: I don't know what that is\n\n" +
                "AlderEYE_007: Its become apparent that the users who were attacked all have some 'behavioral', for" +
                " lack of a better word, commonalities\n" +
                "In that vein, which Chatter topic boards do you use?\n\n" +
                "BahamaMama985: Mediterranean Cooking, Cat Therapy, Cruises, and Bluegrass\n\n" +
                "AlderEYE_007: The Cruises board is one of the three primary communities affected by the attacks\n" +
                "I've looked around all three boards but I'm sure you can give me a better feel for the community" +
                "as an active member\n" +
                "What can you tell me about the community?\n\n" +
                "BahamaMama985: Actually I think your look at the board probably gave you all the important information\n" +
                "The conversations generally consist of people talking about their latest trips, reviewing different " +
                "cruise lines, and occasionally planning meetups when a few users find out they'll be on the same boat\n\n" +
                "AlderEYE_007: Have you ever been to one of those meetups?\n\n" +
                "BahamaMama985: I've never been on a cruise\n" +
                "My interest in the board was more to daydream about one day taking one to the caribbean or somewhere" +
                "tropical\n" +
                "There isn't much reason to waste time daydreaming about that anymore though\n\n" +
                "AlderEYE_007: So your interaction with the Cruises community was entirely confined to the topic board?\n\n" +
                "BahamaMama985: Yes\n\n" +
                "AlderEYE_007: Is there anything else you can tell me about he board? Anything strange, interesting, or beyond" +
                "the topic of cruises?\n\n" +
                "BahamaMama985: Unfortunately there really is nothing beneath the surface\n" +
                "Beyond the topic of cruises, the board got flooded with those links two years or however long ago\n" +
                "Of course so did the other topic communities I'm a part of and pretty much every community on Chatter\n\n" +
                "AlderEYE_007: Right\n" +
                "Do you ever shop online or access medical records through a website portal?\n\n" +
                "BahamaMama985: All the time\n" +
                "If I can get something done at home then I'll do it at home\n\n" +
                "AlderEYE_007: Which sites do you shop on?\n\n" +
                "BahamaMama985: Mostly Amazon along with the rest of the world but I've also used a bunch of other sites too\n" +
                "Theres no way I could list them all\n" +
                "I mean I've used a handful for onetime purchases over the years and I don't remember them all\n\n" +
                "AlderEYE_007: Is there anything else you want to mention that you haven't yet?\n\n" +
                "BahamaMama985: No\n\n" +
                "AlderEYE_007: Ok, thanks again for your help\n\n" +
                "BahamaMama985: Thank YOU. Good luck with your investigation!\n\n\n\n" +
                "\t\t\t\tUser: southTREEArnold\n\n\n" +
                "AlderEYE_007: Could you start by telling me about when you were attacked\n\n" +
                "southTREEArnold: My bank called me saying that my fund transfer request had been been finalized" +
                "and executed\n" +
                "I asked 'whatn hell are you talkin about?' and the teller just repeated what he had said before\n" +
                "I told him I hadn't made any request and that if any funds were transferred I'd sue em\n" +
                "That's when I got in touch with the police\n" +
                "Course they were no help 'all the paperwork is legitimate' they said even though I didn't" +
                "fill out jack\n" +
                "All my savings is gone now and it doesn't seem like anybody is able to help\n\n" +
                "AlderEYE_007: When did all that happen?\n\n" +
                "southTREEArnold: Mid-February\n" +
                "Maybe the 13th\n" +
                "I don't recall the exact date\n" +
                "The 13th would be fitting though\n\n" +
                "AlderEYE_007: But you found out that the account had been drained the day it happened?\n\n" +
                "southTREEArnold: Yep\n\n" +
                "AlderEYE_007: Do you know when the form for the fund transfer was submitted?\n\n" +
                "southTREEArnold: Didn't ask\n" +
                "After I told the teller man I'd sue I called the cops immediately\n" +
                "That first call was the only time I talked to the bank\n\n" +
                "AlderEYE_007: How much communication did you have with the police?\n\n" +
                "southTREEArnold: Not much\n" +
                "Like I said, I called in hot after talkin with the teller and told them to start an investigation" +
                "immediately\n" +
                "They weren't too pleased with the way I was talkin to them but they said they'd look into it anyway\n" +
                "Awhile later, month or two maybe, they called back sayin not only that the trail was cold but that" +
                "I should be careful to not start an IRS investigation into myself\n" +
                "And I'll tell you what, if I was hot with the teller I nearly scorched the station the way I was" +
                "with the police\n" +
                "Told em they'd get sued too, and real quick, for what they were doing to me\n" +
                "Course now I can't afford a lawyer\n\n" +
                "AdlerEYE_007: While looking into these attacks its become clear that certain topic boards were targeted" +
                "significantly more than others. Which Chatter communities are you a part of?\n\n" +
                "southTREEArnold: Fishing, The Tea Party, Jonny Cash, Investing, Golf, and College NCAA Football\n" +
                "But I'm not on em all the same amount or that much at all to begin with\n\n" +
                "AlderEYE_007: The Golf board is one of the communities that the attack hit the hardest." +
                "What can you tell me about the board?\n\n" +
                "southTREEArnold: What ya see is what ya get with Golf\n" +
                "Most people just talk bout the PGA Tour and who they got for it\n" +
                "Ya also get some nerdy folk talkin bout the latest and greatest clubs and their weight balance or whatever\n" +
                "I don't really get into all that I mostly just talk about The King\n\n" +
                "AlderEYE_007: Who is 'The King'?\n\n" +
                "southTREEArnold: I'm gonna do my best not to take offense to that\n" +
                "The King is Mr. Arnold Palmer the greatest golfer to ever live\n\n" +
                "AlderEYE_007: I see. Have you ever had contact with anybody in the Golf board community outside of the Chatter board?\n\n" +
                "southTREEArnold: Like I said, I don't use the site that much to begin with\n" +
                "If I'm on Chatter at all, its only on the topic boards\n\n" +
                "AlderEYE_007: Has anything strange or interesting ever happened on the Golf board? Anything beyond" +
                "the subject of golf that is?\n\n" +
                "southTREEArnold: Nothin except that damn link spam scam that happened all that time ago\n" +
                "But I don't mean to mislead, that crap got sprayed over all the boards I'm on\n\n" +
                "AlderEYE_007: I knew about the link spam but I've never heard anybody say that they lead to scams." +
                "Honestly, I don't know anybody who actually clicked on them. What were the links to? What was the scam?\n\n" +
                "southTREEArnold: Well I must be the dullest tool in the shed to have tried it then.\n" +
                "From what I know, not all the links were the same. The one I followed had been circulating the Investing" +
                "board for awhile\n" +
                "I didn't use it until I saw some people talkin bout it in on the Golf board\n" +
                "The link sent ya to a gold investment site where you could buy gold coins\n" +
                "With all I was readin on the Investment board and then the Golf board after that, seemed like a good idea" +
                "to try investing a little money for later\n" +
                "I bought $1000 worth of gold on that ponzi scheme crook site and to this day they haven't sent me squat\n" +
                "I get $1000 stolen and then a year later my entire savings gets taken too\n" +
                "Ain't that a bitch?\n" +
                "From now on my money goes in the mattress and stays there, I don't care what those bank scumbags say\n\n" +
                "AlderEYE_007: This information is fascinating. Thank you for your time.\n\n\n\n" +
                "\t\t\t\tUser: HighCsSailor\n\n\n" +
                "HighCsSailor: Is this @BahamaMama985's friend?\n\n" +
                "AlderEYE_007: Hello. Yes I spoke to her a few days ago. Can I help you?\n\n" +
                "HighCsSailor: Actually I was hoping to help you! @BahamaMama985 DMed me after you two spoke. She told me" +
                "you were looking into the bank account attacks and were talking to the victims.\n" +
                "My personal savings was stolen at the end of last October. I can answer any questions you have" +
                "if you are interested.\n\n" +
                "AlderEYE_007: I am very interested and will thank @BahamaMama985 for the referral.\n" +
                "Before we get into the attack, could you tell me how you know @BahamaMama985? It is important for the" +
                "validation of her testimony.\n\n" +
                "HighCsSailor: She and I spoke on the Cruises topic board on a few occasions. Our longest conversation was" +
                "in reference to the attacks. I hope my answer isn't causing trouble for anybody!\n\n" +
                "AlderEYE_007: Was the DM about my investigation the only time you two spoke outside of the topic board?\n\n" +
                "HighCsSailor: Yes. Do we have conflicting stories?\n\n" +
                "AlderEYE_007: I thought you might, but what you just said is consistent with @BahamaMama985's testimony\n" +
                "But don't worry about what the other victims have said. You will only be helpful by telling the truth\n" +
                "Now, what can you tell me about the attack?\n\n" +
                "HighCsSailor: My savings was stolen on the 27th of October. I found out when my bank notified me that" +
                "my request for a fund transfer had been executed. After pleading with the teller, I was directed to the" +
                "police as the bank said their hands were tied. An officer assisted me in creating a report. He told me" +
                "that the department would absolutely be opening an investigation into the matter. A little over a month" +
                "later, the same officer called me and said the department had found no evidence to support my claims." +
                "I spoke with him for awhile, probing for some course of action which might lead to continuing the " +
                "investigation. But he made it clear that this was the end of the road. That is the entirety of the" +
                "event.\n\n" +
                "AlderEYE_007: You seem less bruised by the event than the other victims I've spoken to. Especially given" +
                "how recently this all happened.\n\n" +
                "HighCsSailor: I am upset. The financial impact is not one I was prepared for. However, the effect" +
                "of the attack was greatly limited by the good fortune that I was targeted rather than my wife." +
                "The bulk of our money is in an account under her name with safeguards such that even she cannot" +
                "pull out all of our savings at once.\n\n" +
                "AlderEYE_007: That is very fortunate. Moving on, it sounds as though you received a thorough brief" +
                "about the circumstances of the transfer from the bank, is that correct?\n\n" +
                "HighCsSailor: Yes, when the bank called to confirm the transfer we ended up speaking for over an hour.\n\n" +
                "AlderEYE_007: Do you know when the fund transfer forms were submitted?\n\n" +
                "HighCsSailor: Yes, the forms were submitted a week and a half before the transfer date. 11 days before.\n\n" +
                "AlderEYE_007: Do you know to what account the funds were transferred?\n\n" +
                "HighCsSailor: They were transferred to a PayPal account and then immediately moved again to another savings account" +
                "at a different bank. Then transferred again and again. The funds ping-ponged around so much that that" +
                "the police said they could not trace it to a final destination.\n\n" +
                "AlderEYE_007: And the police didn't find that suspicious enough to keep the case open?\n\n" +
                "HighCsSailor: The officer told me that while suspicious, the transfers amounted to a dead end. Nothing could" +
                "be done about it.\n\n" +
                "AlderEYE_007: @BahamaMama985 gave me a general overview of the Cruises topic board, so this is my last question." +
                "Do you recall links being spammed on lots of different topic boards a little more than two years ago?\n\n" +
                "HighCsSailor: I joined Chatter last September, so I'm afraid I was not around for that.\n\n" +
                "AlderEYE_007: Thank you for your time.\n\n\n\n" +
                "\t\t\t\tUser: ignacia1_montoya2\n\n\n" +
                "AlderEYE_007: Could you start by telling me about when you were attacked\n\n" +
                "ignacia1_montoya2: June 29th last year at 3:20pm I called my bank to withdrawal funds from my savings account.\n" +
                "The teller told me my savings was empty.\n" +
                "I asked why and she informed me the entire account balance had been withdrawn the day prior.\n" +
                "I called the police and filed a report claiming identity theft\n" +
                "Two months later the police called me to report no indication of theft or bank fraud.\n\n" +
                "I contacted seven different police bodies and received the same response.\n\n" +
                "AlderEYE_007: Was that the full extent of your contact with the police and the bank?\n\n" +
                "ignacia1_montoya2: Yes.\n\n" +
                "AlderEYE_007: You said the account was emptied on the 28th, do you know when the fund transfer documents were submitted?\n\n" +
                "ignacia1_montoya2: Of course I know. I know everything there is to know about my case.\n" +
                "The papers were submitted on the 16th. Complete with my signatures, my birth certificate, and my social security number\n\n" +
                "AlderEYE_007: How far were the police able to trace the fund transfers after being removed from your savings?" +
                "I assume they did lose the trail at some point.\n\n" +
                "ignacia1_montoya2: You are correct.\n" +
                "Six transfers could be traced before they hit a wall.\n" +
                "The funds traveled as follows:\n" +
                "1. A PayPal account registered under a fake name using a privately owned VPN.\n" +
                "2. A local Orange County Union Bank registered under a woman who died five years prior.\n" +
                "3. A Taiwanese bank denied to provide the information requested by the police.\n" +
                "4. Sveriges Riksbank, the central bank in Sweden. They did not disclose the owner of the account. But, they did report where the" +
                "funds were transferred next." +
                "5. The account balance was segmented into 18 non-uniform quantities, converted into the Monero crypt" +
                "ocurrency, and sent into 18 separate crypo-wallets.\n" +
                "6. All crypto-assets then disappeared from the wallets with no transfer indicated.\n" +
                "The police informed me that the assets were likely moved into a cold wallet on a hard drive. And thus taken offline" +
                "entirely. That is where the trail ended.\n\n" +
                "AlderEYE_007: It have become evident that certain Chatter topic boards were targeted by the attacks far more than others." +
                "Which Chatter communities are you a member of?\n\n" +
                "ignacia1_montoya2: Soap Operas.\n\n" +
                "AlderEYE_007: Is that the only one?\n\n" +
                "ignacia1_montoya2: That is what I said.\n\n" +
                "AlderEYE_007: What can you tell me about the Soap Opera board?\n\n" +
                "ignacia1_montoya2: It is a community of older women who talk about soap operas.\n" +
                "What did you expect.\n\n" +
                "AlderEYE_007: Have you ever been contacted by another Chatter user individually?\n\n" +
                "ignacia1_montoya2: No.\n" +
                "Don't you think that if I had then that would be the first person I notified the police of?" +
                "Do you think I'm stupid? Do you think I lost everything and just swallowed it? I have done everything" +
                "in my power to get that money back. To get my livelihood back. The attack destroyed what little bit is left" +
                "of me and my husband's lives. We have been forced to live with our daughter AND to rely on her finances." +
                "She has changed her career path entirely just to make enough money to get by. And theres nothing I can" +
                "do about it. My husband and I are too physically impaired to perform any task other than typing from a" +
                " lounge chair. The day I found out my savings had been stolen I was about to put down the deposit to reserve" +
                "a space at an assisted living community for us. We were one day away from ensuring continuous independence" +
                "from our daughter. Now her life is ruined because of us. And our lives are ruined because the police are" +
                "too lazy to get off of their asses and try a little harder. I'm sick of these pointless interviews which" +
                " result in nothing but the most obvious and laughable conclusions. If you're going to play detective" +
                " you need to either get a bit more serious or stop wasting my time.\n\n" +
                "AlderEYE_007: I apologise for offending you. That was not my intent with my questions. I cannot imagine the" +
                "strain that has been put upon your family. And, I hope that this disaster will be resolved and savings will be" +
                "reimbursed. If you are willing to continue, I only have a few more questions.\n\n" +
                "ignacia1_montoya2: I am wiling for now.\n\n" +
                "AlderEYE_007: Were you on Chatter at the time website links were spammed in nearly every topic board on the platform?\n\n" +
                "ignacia1_montoya2: Yes. In fact, after the initial surge, the links continued to circulate the soap board for many months.\n\n" +
                "AlderEYE_007: Did you ever use any of the links?\n\n" +
                "ignacia1_montoya2: No.\n" +
                "But my husband did.\n" +
                "He told me they lead to websites providing various goods and services. One of which he thought could help us find a" +
                "retirement home.\n" +
                "I believe he signed up to contact an advisor who would suggest communities based on our finances and medical needs.\n" +
                "Unsurprisingly nothing ever came of it.\n\n" +
                "AlderEYE_007: What kind of information did the site require to sign up?\n\n" +
                "ignacia1_montoya2: I don't know.\n" +
                "My husband handled it all.\n" +
                "I didn't even know he had tried the site until after he had signed up.\n" +
                "He told me he just wanted to get in contact with an advisor to discuss their services and costs.\n" +
                "I image all the website needed was his email address\n\n" +
                "AlderEYE_007: Thank you for your time.\n\n\n");
    }

    private void setScrollPane(){
        SCROLL_PANE.createVerticalScrollBar();
        SCROLL_PANE.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        SCROLL_PANE.setMaximumSize(new Dimension((int) GAME_DIMENSION.getWidth()-10,
                (int) GAME_DIMENSION.getHeight() - 50 - RETURN_AREA.getHeight()));
    }

    private void setTextArea(){
        RETURN_AREA.setEditable(false);
        RETURN_AREA.setFont(RETURN_FONT);
        RETURN_AREA.setForeground(Color.WHITE);
        RETURN_AREA.setBackground(Color.DARK_GRAY);
        RETURN_AREA.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                searchEngine.changePanel("empty");
            }
        });
    }

    private void setPanelLayout(){
        setLayout(LAYOUT);

        LAYOUT.setAutoCreateGaps(true);
        LAYOUT.setHorizontalGroup(LAYOUT.createSequentialGroup()
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(TITLE_LABEL)
                        .addComponent(SCROLL_PANE)
                        .addComponent(RETURN_AREA)));
        LAYOUT.setVerticalGroup(LAYOUT.createSequentialGroup()
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(TITLE_LABEL))
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(SCROLL_PANE))
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(RETURN_AREA)));
    }

    public String getPageURL(){
        return PAGE_URL;
    }
}
