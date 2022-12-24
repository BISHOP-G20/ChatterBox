package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static Main.GameFrame.EVIDENCE_LISTENER;
import static Main.GameFrame.GAME_DIMENSION;

public class SuspectsPage extends JPanel{

    private final String PAGE_URL = "https://criminologyCracker/heistof84/suspect.com";

    private final SearchEngine SEARCH_ENGINE;
    private final JPanel TOP_PANEL = new JPanel();
    private final GroupLayout TOP_LAYOUT = new GroupLayout(TOP_PANEL);
    private final JPanel CONTENT_PANEL = new JPanel(); // put title top of this panel
    private final GroupLayout CONTENT_LAYOUT = new GroupLayout(CONTENT_PANEL);
    private final JScrollPane SCROLL_PANE = new JScrollPane(CONTENT_PANEL);
    private final JPanel SUSPECT_PANEL = new JPanel();
    private final GroupLayout SUSPECT_LAYOUT = new GroupLayout(SUSPECT_PANEL);
    private final JPanel TEXT_PANEL = new JPanel();
    private final GroupLayout TEXT_LAYOUT = new GroupLayout(TEXT_PANEL);
    private final GroupLayout LAYOUT = new GroupLayout(this);
    private final JTextArea[] TEXT_AREAS = new JTextArea[3];
    private final ImageIcon[] SUSPECT_PICS = new ImageIcon[5];
    private final ImageIcon BACK_ICON = new ImageIcon(new ImageIcon("src/Resources/BackArrow.png").getImage()
            .getScaledInstance(50,34, Image.SCALE_SMOOTH));
    private final JLabel TITLE_LABEL = new JLabel("The Greatest Heist of 1984");
    private final JLabel BACK_LABEL = new JLabel(BACK_ICON);
    private final JLabel[] PIC_LABELS = new JLabel[5];
    private final JLabel[] SUSPECT_LABELS = {new JLabel("Kevin Poulsen"),
                                            new JLabel("James Moriarty"),
                                            new JLabel("Terry Benedict"),
                                            new JLabel("Juliette Monet"),
                                            new JLabel("Elizabeth Holmes")};
    private final Font TITLE_FONT = new Font("Univers Condensed", Font.BOLD, 30);
    private final Font SUSPECT_FONT = new Font("Calibri", Font.BOLD, 18);
    private final Font TEXT_FONT = new Font("Calibri", Font.PLAIN, 15);

    public SuspectsPage(SearchEngine searchEngine){
        SEARCH_ENGINE = searchEngine;
        setBackLabel();
        setTextAreas();
        setLabels();
        setPanelBackgrounds();
        setScrollPane();
        setPicLabels();
        setLayouts();
        setName("Heist of 1984");
    }

    private void setLayouts(){
        TEXT_PANEL.setLayout(TEXT_LAYOUT);
        TEXT_LAYOUT.setAutoCreateGaps(true);
        TEXT_LAYOUT.setAutoCreateContainerGaps(true);
        TEXT_LAYOUT.setHorizontalGroup(TEXT_LAYOUT.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(TEXT_AREAS[0])
                        .addComponent(TEXT_AREAS[1])
                        .addComponent(TEXT_AREAS[2]));
        TEXT_LAYOUT.setVerticalGroup(TEXT_LAYOUT.createSequentialGroup()
                        .addGroup(TEXT_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(TEXT_AREAS[0]))
                        .addGroup(TEXT_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(TEXT_AREAS[1]))
                        .addGroup(TEXT_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(TEXT_AREAS[2])));

        SUSPECT_PANEL.setLayout(SUSPECT_LAYOUT);
        SUSPECT_LAYOUT.setAutoCreateGaps(true);
        SUSPECT_LAYOUT.setAutoCreateContainerGaps(true);
        SUSPECT_LAYOUT.setHorizontalGroup(SUSPECT_LAYOUT.createSequentialGroup()
                .addGroup(SUSPECT_LAYOUT.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(PIC_LABELS[0])
                        .addComponent(PIC_LABELS[1])
                        .addComponent(PIC_LABELS[2])
                        .addComponent(PIC_LABELS[3])
                        .addComponent(PIC_LABELS[4]))
                .addGroup(SUSPECT_LAYOUT.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(SUSPECT_LABELS[0])
                        .addComponent(SUSPECT_LABELS[1])
                        .addComponent(SUSPECT_LABELS[2])
                        .addComponent(SUSPECT_LABELS[3])
                        .addComponent(SUSPECT_LABELS[4])));
        SUSPECT_LAYOUT.setVerticalGroup(SUSPECT_LAYOUT.createSequentialGroup()
                        .addGroup(SUSPECT_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(PIC_LABELS[0])
                                .addComponent(SUSPECT_LABELS[0]))
                        .addGroup(SUSPECT_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(PIC_LABELS[1])
                                .addComponent(SUSPECT_LABELS[1]))
                        .addGroup(SUSPECT_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(PIC_LABELS[2])
                                .addComponent(SUSPECT_LABELS[2]))
                        .addGroup(SUSPECT_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(PIC_LABELS[3])
                                .addComponent(SUSPECT_LABELS[3]))
                        .addGroup(SUSPECT_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(PIC_LABELS[4])
                                .addComponent(SUSPECT_LABELS[4])));


        TOP_PANEL.setLayout(TOP_LAYOUT);
        TOP_LAYOUT.setHorizontalGroup(TOP_LAYOUT.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(BACK_LABEL));
        TOP_LAYOUT.setVerticalGroup(TOP_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(BACK_LABEL));

        CONTENT_PANEL.setLayout(CONTENT_LAYOUT);
        CONTENT_LAYOUT.setAutoCreateGaps(true);
        CONTENT_LAYOUT.setHorizontalGroup(CONTENT_LAYOUT.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(TITLE_LABEL)
                        .addComponent(TEXT_PANEL)
                        .addComponent(SUSPECT_PANEL));
        CONTENT_LAYOUT.setVerticalGroup(CONTENT_LAYOUT.createSequentialGroup()
                .addGroup(CONTENT_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(TITLE_LABEL))
                .addGroup(CONTENT_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(TEXT_PANEL))
                .addGroup(CONTENT_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(SUSPECT_PANEL)));

        setLayout(LAYOUT);
        LAYOUT.setHorizontalGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(TOP_PANEL)
                .addComponent(SCROLL_PANE));
        LAYOUT.setVerticalGroup(LAYOUT.createSequentialGroup().addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(TOP_PANEL))
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(SCROLL_PANE)));
    }

    private void setPicLabels(){
        for (int i = 0; i < SUSPECT_PICS.length; i++) {
            SUSPECT_PICS[i] = new ImageIcon(new ImageIcon("src/Resources/suspect_" + (i + 1) + ".png").getImage()
                    .getScaledInstance(125, 170, Image.SCALE_SMOOTH));
            PIC_LABELS[i] = new JLabel(SUSPECT_PICS[i]);
        }
    }

    private void setScrollPane(){
        SCROLL_PANE.setPreferredSize(new Dimension((int)GAME_DIMENSION.getWidth(), (int)GAME_DIMENSION.getHeight() - 30));
        SCROLL_PANE.createVerticalScrollBar();
    }

    private void setPanelBackgrounds(){
        setBackground(Color.BLACK);
        CONTENT_PANEL.setBackground(Color.BLACK);
        SUSPECT_PANEL.setBackground(Color.BLACK);
        TEXT_PANEL.setBackground(Color.BLACK);

    }

    private void setLabels(){
        TITLE_LABEL.setFont(TITLE_FONT);
        TITLE_LABEL.setForeground(Color.WHITE);
        TITLE_LABEL.setBackground(Color.BLACK);
        TITLE_LABEL.addMouseListener(EVIDENCE_LISTENER);
        for (int i = 0; i < SUSPECT_LABELS.length; i++) {
            SUSPECT_LABELS[i].setFont(SUSPECT_FONT);
            SUSPECT_LABELS[i].setForeground(Color.WHITE);
            SUSPECT_LABELS[i].setBackground(Color.BLACK);
            SUSPECT_LABELS[i].addMouseListener(EVIDENCE_LISTENER);
        }
    }

    private void setTextAreas(){
        for (int i = 0; i < TEXT_AREAS.length; i++) {
            TEXT_AREAS[i] = new JTextArea();
            TEXT_AREAS[i].setFont(TEXT_FONT);
            TEXT_AREAS[i].setMargin(new Insets(50, 20, 0, 20));
            TEXT_AREAS[i].setForeground(Color.WHITE);
            TEXT_AREAS[i].setBackground(Color.BLACK);
            TEXT_AREAS[i].setEditable(false);
            TEXT_AREAS[i].setWrapStyleWord(true);
            TEXT_AREAS[i].setLineWrap(true);
            TEXT_AREAS[i].addMouseListener(EVIDENCE_LISTENER);
        }

        TEXT_AREAS[0].setText("In 1984 a littering of seemingly disconnected bank heists peppered the U.S. Without" +
                "warning, five separate accounts, all at different banks, were emptied." +
                "The attacks were cautious and clever, not even arousing response from the banks or the police. And to the creation" +
                "of this website, the events have still not been investigated. But How could such"+
                "a thing happen? And if the police did not investigate, how could there be a case? I will answer both questions in" +
                "the following article. During which I will also argue that the facts of this case point to the victims being framed" +
                "by the criminal(s). Lastly, I will present a list of former convicts who I believe are top suspects and deserve to be" +
                "investigated by the police.");
        TEXT_AREAS[1].setText("First, the facts of the case:\n" +
                "1. In 1984 seven bank accounts were emptied of their balances within the" +
                "time span of one month\n" +
                "2. Two of the accounts were checking accounts\n" +
                "3. The owners of the checking accounts successfully submitted" +
                "credit card theft claims, and were fully reimbursed\n" +
                "4. The owners of the emptied savings accounts unsuccessfully claimed foul play and full reimbursement\n" +
                "5. The banks received completed fund transfer requests for the five savings accounts\n\n" +
                "These facts immediately demonstrate a systematic manner of attack which developed with each heist." +
                "Each instance shares the characteristic that all funds were withdrawn from the account at once. For the first" +
                " two robberies, the peculiarity of events breaks the standard MO of credit card thievery. The average credit" +
                " card/number thief begins by making a series of small purchases with the card to verify three things: card operation," +
                " existence of a balance, and geographical proximity where card activity will not be flagged for location alone. These" +
                " characteristics of credit theft are important because the robberies of the seven accounts in 1984 share none of them. " +
                " The reason for this is that the heists were performed entirely online. The banks traced the fund withdrawals to PayPal" +
                " accounts under the victims' respective names. The registration details of the PayPal accounts pointed to registration" +
                " by the individuals claiming foul play; however, it was the IP addresses from which the accounts were registered that" +
                " left the police at a loss. Because the IPs originated from the location of the individuals' residences all the evidence" +
                " supported that the victims were still in ownership of the funds. Were the heists to be committed in person, the banks" +
                " would have video evidence of a person who is no the owner of the account attempting to make a withdrawal. Nevertheless," +
                "this was not the case. The internet medium created an environment in which the robber could manipulate all crime scene " +
                "evidence. Furthermore, the criminal was able to modify the residual evidence to frame the rightful owners of the accounts." +
                "However, the perfected methodology required testing and failure first. As such, the first two attempts resulted in seized funds" +
                "and the restoration of credit accounts. In these cases, the attacker made two major mistakes. First, the regular use of credit" +
                " cards makes them far more vulnerable to theft. In turn, the required information to make a claim are far less extensive than" +
                "in other circumstances. Secondly, the PayPal accounts to which the funds were transferred were associated with foreign IP" +
                " addresses and registered under fake names. The consequence was a successful seizure of funds but no conviction of a bad actor." +
                "The next five attempts were performed far more tactically, leaving no indication of crime. The basis of my belief that these " +
                "crimes were committed by the same person or group of persons lies in the timeline and method of attack. The obvious pattern" +
                "justifies suspicion of systematic crime.\n");
        TEXT_AREAS[2].setText("Finally, I will present five individuals who match the MO of the 1984 crimes. " +
                "Kevin Poulsen impressed investigators at 17 when he overtook the telephone lines of a LA Radio " +
                "station. After running for several years as a fugitive, he was arrested and sentenced five years in prison with an additional " +
                "three year internet ban. It has been eight years since his release and five years since his internet ban has been lifted. Presently " +
                "he works as an editor for a news site targeted toward hackers. It is suspect that an individual with so much technical talent " +
                "left it behind for a position as a writer. His LA Radio stunt caught the attention of LA the moment it happened. Perhaps he " +
                "has moved on to fraud with a bit more tact and vigilance.\nJames Moriarty is an infamous hacker based in London, England. He has been charged with " +
                "several cyber-crimes in the past including, identity theft, the sale of company secrets, and intrusion of government" +
                " computer networks. In total, Moriarty has spent 15 years in jail. These years were interspersed with years of lawful behavior." +
                "Currently, he has been out on probation since leaving prison in 1988.\n Terry Benedict is hailed for his grandiose casino heists" +
                " which have landed him in prison for over 30 years. His last exploit included cashing out hacked slot machines at the Monte" +
                " Carlo while other members of his criminal organization distracted authorities by planting a series of mock time-bombs" +
                "throughout the rest of the hotel. As Terry Benedict always assumed a more hands off role, his technical expertise has" +
                "made him a suspect of many other cyber-crimes for which nobody has been convicted. I believe Terry has substituted his" +
                " showmanship for subtlety, becoming more cautious in his later years. Terry Benedict has been out on probation for 11 years" +
                " with an unblemished record.\n Juliet Monet, much like all" +
                "the suspects in this list, has kept her personal information out of the internet's grasp. What is known is that in 1979 " +
                "she was convicted of propagating fraudulent pharmaceutical websites for a cut of the scammed profits. That is to say " +
                "while not being the only actor involved in the crime, she was the only one identified and charged. The prosecution resulted " +
                "in a seizure of her profits and a fine for aiding and abetting. During her trial she presented a clear lack of remorse and " +
                "indicated her capabilities were beyond her participation in the pharma scam. She paid her fine and continued to study Web-app " +
                "development at Carnegie Mellon.\n The last person on my suspect list is Elizabeth Holmes. Notorious" +
                " for her fraudulent biotech company. She used marketing and facade to convince investors to give her millions. For her crime" +
                " she was sentenced to 15 years in prison. Similar to the others on this list, she is also now out on probation. Given the " +
                "sophistication of her Theranos ruse, it is clear she is capable of high level criminal activity. Out on probation and broke" +
                " ELizabeth has the motives to make a quick buck and is clearly willing to do so through criminal activity. I suspect she has" +
                " used her notoriety to found a new criminal organization with a far less public scheme.");
    }

    private void setBackLabel(){
        BACK_LABEL.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SEARCH_ENGINE.changePanel("empty");
            }
        });
    }

    public String getPageURL(){
        return PAGE_URL;
    }
}
