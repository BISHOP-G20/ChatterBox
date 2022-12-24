package UI;

import Main.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Font.BOLD;
import static Main.GameFrame.GAME_DIMENSION;
import static Main.GameFrame.GAME_STATE;
import static java.awt.Font.PLAIN;

public class StoryPanel extends JPanel {

    private final GameFrame GAME_FRAME;
    private final JButton NEXT_BUTTON = new JButton("Next");
    private final JLabel TITLE_LABEL = new JLabel("Prologue");
    private final JTextPane TEXT_PANE = new JTextPane();
    private final JScrollPane SCROLL_PANE = new JScrollPane(TEXT_PANE);
    private final Font TITLE_FONT = new Font("Univers Condensed", BOLD, 30);
    private final Font TEXT_FONT = new Font("Courier New", Font.BOLD, 13);
    private final Font BUTTON_FONT = new Font("Arial", PLAIN, 20);
    private final GroupLayout LAYOUT = new GroupLayout(this);

    public StoryPanel(GameFrame GAME_FRAME){
        this.GAME_FRAME = GAME_FRAME;

        setFonts();
        setButton();
        setText();
        setPanelLayout();
    }

    private void setPanelLayout(){
        setLayout(LAYOUT);
        LAYOUT.setAutoCreateGaps(true);
        LAYOUT.setAutoCreateContainerGaps(true);

        LAYOUT.setHorizontalGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(TITLE_LABEL)
                .addComponent(SCROLL_PANE)
                .addComponent(NEXT_BUTTON));
        LAYOUT.setVerticalGroup(LAYOUT.createSequentialGroup()
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(TITLE_LABEL))
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(SCROLL_PANE))
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(NEXT_BUTTON)));
    }

    private void setFonts(){
        TITLE_LABEL.setFont(TITLE_FONT);
        TEXT_PANE.setFont(TEXT_FONT);
        NEXT_BUTTON.setFont(BUTTON_FONT);
    }

    private void setText(){
        SCROLL_PANE.createVerticalScrollBar();
        SCROLL_PANE.setMaximumSize(new Dimension((int)GAME_DIMENSION.getWidth() - 40, (int)GAME_DIMENSION.getHeight() - 50));
        TEXT_PANE.setMargin(new Insets(15, 25, 10, 25));
        TEXT_PANE.setText("The links hit like the locusts in egypt. One day nothing, the next day near a third " +
                "of all chat rooms had been spammed with links. Not one after the other, but pasted and sent " +
                "at odd intervals. In fact, they only popped up when the boards were active. These links lead to " +
                "different websites of seemingly disconnected subjects. In the beginning, the sites were only taken as " +
                "benign. In turn, a portion of users took to exploring the links. While not widely useful, the niche needs " +
                "of some chatters lead to the websites being a helpful resource. But, it was at this point that disaster struck. " +
                "An avid user of a soccer  message board had their savings drained. From what he could tell $62,000 evaporated." +
                " It was not even until two days later that he noticed the receipt in his gmail inbox. At 2:00am the day before last," +
                " a withdrawal was requested by nobody but himself. At least, that is what the email indicated." +
                " In a panic, he called the bank to report the incident. And, in some kafkaesque hell discovered" +
                " that there was nothing he could do. According to the bank, paperwork from the transaction had" +
                " been submitted a week ago. All the requisite credentials had been presented and the withdrawal was final." +
                " The bank shut and locked the door. Of course, this was only the beginning for the victim. Next, he contacted the" +
                " police and reported the incident. Motivated by the scale of the accusations, a case was opened into the transaction." +
                " A week passed before he heard back from the department during which the soccer chat room lit up. The now destitute user" +
                " told all his contacts about the incident. Nothing could explain why this happened. 7 days later, the police responded." +
                " Foul play was not indicated. Moreover, the man he spoke with threatened an IRS investigation into" +
                " him for attempted fraud. The chatter was left with nothing but his belongings. The small group" +
                " that was informed by this kept it to themselves. It was a tragedy no doubt, but only misfortune." +
                " It was a friend going through a hard time, end of story. 3 weeks passed without news. Everybody operated" +
                " normally, some continuing to use the spammed sites. 25 days after the last incident, another occurred." +
                " A different user, a different place, the same chat site. The circumstances were the same. $134,000" +
                " stolen from a savings account. Paperwork submitted. No foul play indicated. The attacks persisted.\n\n" +
                " It was after 11 withdrawals that entire chat communities became aware of the bank account siege. First," +
                " the golf threads were familiar with it. Next, cruise meet up boards and soap opera chats. By the time" +
                " the classical music community was picked through, 28 users had been stolen from. No country appeared to" +
                " be out of bounds either. Though this was not known at the time, the victims covered 13 countries" +
                " in the west and 2 in the east. More and more communities shared in the information allowing the" +
                " story to grow. Some altruistic users even began sending emails to the victims’ banks urging them to" +
                " look more closely into the matter. Still, the massive institutions pugged their ears. All precautions" +
                " had been taken, the victims had no ground to stand on. A year and a half of robbery, then silence." +
                " No more users were attacked. And while no justice came to pass, the messaging platform returned to normalcy." +
                " The shared experience became part of the site's lore and fossilized in history. Until 3 months later" +
                " when a new board is created by user m1key_m0use. ");
    }

    private void setButton(){
        NEXT_BUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GAME_FRAME.setGameState(GAME_STATE);
            }
        });
    }
}
