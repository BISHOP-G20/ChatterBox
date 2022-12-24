package UI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Main.GameFrame.EVIDENCE_LISTENER;
import static java.awt.Font.PLAIN;

    public class SignUpForm extends JPanel {

        private String siteName;

        private final Webpage webpage;
        private final JLabel[] LABELS = new JLabel[8];
        private final JTextField[] TEXT_FIELDS = new JTextField[7];
        private final JButton SUBMIT_BUTTON = new JButton("Submit");
        private final JButton BACK_BUTTON = new JButton("Back");
        private final Color BACKGROUND_COLOR = new Color(140, 168, 232);
        private final JPanel TITLE_PANEL = new JPanel();
        private final JPanel FIELD_PANEL = new JPanel();
        private final JPanel BUTTON_PANEL = new JPanel();
        private final Border BORDER = BorderFactory.createMatteBorder(1,1,1,1, BACKGROUND_COLOR);
        private final Font TITLE_FONT = new Font("Impact", Font.BOLD, 30);
        private final Font BUTTON_FONT = new Font("Arial", PLAIN, 15);
        private final GroupLayout LAYOUT = new GroupLayout(this);
        private final GroupLayout TITLE_LAYOUT = new GroupLayout(TITLE_PANEL);
        private final GroupLayout FIELD_LAYOUT = new GroupLayout(FIELD_PANEL);
        private final GroupLayout BUTTON_LAYOUT = new GroupLayout(BUTTON_PANEL);

        public SignUpForm(Webpage webpage){
            this.webpage = webpage;
            setJComponents();
            setPanelLayout();
        }

        private void setPanelLayout(){
            TITLE_PANEL.setLayout(TITLE_LAYOUT);
            TITLE_LAYOUT.setAutoCreateGaps(true);
            TITLE_LAYOUT.setAutoCreateContainerGaps(true);
            TITLE_LAYOUT.setHorizontalGroup(TITLE_LAYOUT.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(LABELS[0]));
            TITLE_LAYOUT.setVerticalGroup(TITLE_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(LABELS[0]));

            FIELD_PANEL.setLayout(FIELD_LAYOUT);
            FIELD_LAYOUT.setAutoCreateGaps(true);
            FIELD_LAYOUT.setAutoCreateContainerGaps(true);
            FIELD_LAYOUT.setHorizontalGroup(FIELD_LAYOUT.createSequentialGroup()
                    .addGroup(FIELD_LAYOUT.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(LABELS[1])
                            .addComponent(LABELS[2])
                            .addComponent(LABELS[3])
                            .addComponent(LABELS[4])
                            .addComponent(LABELS[5])
                            .addComponent(LABELS[6])
                            .addComponent(LABELS[7]))
                    .addGroup(FIELD_LAYOUT.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(TEXT_FIELDS[0])
                            .addComponent(TEXT_FIELDS[1])
                            .addComponent(TEXT_FIELDS[2])
                            .addComponent(TEXT_FIELDS[3])
                            .addComponent(TEXT_FIELDS[4])
                            .addComponent(TEXT_FIELDS[5])
                            .addComponent(TEXT_FIELDS[6])));
            FIELD_LAYOUT.setVerticalGroup(FIELD_LAYOUT.createSequentialGroup()
                    .addGroup(FIELD_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(LABELS[1])
                            .addComponent(TEXT_FIELDS[0]))
                    .addGroup(FIELD_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(LABELS[2])
                            .addComponent(TEXT_FIELDS[1]))
                    .addGroup(FIELD_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(LABELS[3])
                            .addComponent(TEXT_FIELDS[2]))
                    .addGroup(FIELD_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(LABELS[4])
                            .addComponent(TEXT_FIELDS[3]))
                    .addGroup(FIELD_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(LABELS[5])
                            .addComponent(TEXT_FIELDS[4]))
                    .addGroup(FIELD_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(LABELS[6])
                            .addComponent(TEXT_FIELDS[5]))
                    .addGroup(FIELD_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(LABELS[7])
                            .addComponent(TEXT_FIELDS[6])));

            BUTTON_PANEL.setLayout(BUTTON_LAYOUT);
            BUTTON_LAYOUT.setAutoCreateGaps(true);
            BUTTON_LAYOUT.setAutoCreateContainerGaps(true);
            BUTTON_LAYOUT.setHorizontalGroup(BUTTON_LAYOUT.createSequentialGroup()
                    .addGroup(BUTTON_LAYOUT.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(BACK_BUTTON))
                    .addGroup(BUTTON_LAYOUT.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(SUBMIT_BUTTON)));
            BUTTON_LAYOUT.setVerticalGroup(BUTTON_LAYOUT.createSequentialGroup()
                    .addGroup(BUTTON_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(BACK_BUTTON)
                            .addComponent(SUBMIT_BUTTON)));

            setLayout(LAYOUT);
            LAYOUT.setAutoCreateGaps(true);
            LAYOUT.setAutoCreateContainerGaps(true);
            LAYOUT.setHorizontalGroup(LAYOUT.createSequentialGroup()
                    .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(TITLE_PANEL)
                            .addComponent(FIELD_PANEL)
                            .addComponent(BUTTON_PANEL)));
            LAYOUT.setVerticalGroup(LAYOUT.createSequentialGroup()
                    .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(TITLE_PANEL))
                    .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(FIELD_PANEL))
                    .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(BUTTON_PANEL)));
        }

        private void setJComponents(){
            for (int i = 0; i < LABELS.length; i++) {
                LABELS[i] = new JLabel();
                LABELS[i].addMouseListener(EVIDENCE_LISTENER);
            }
            for (int i = 0; i < TEXT_FIELDS.length; i++) {
                TEXT_FIELDS[i] = new JTextField();
                TEXT_FIELDS[i].setEditable(false);
                TEXT_FIELDS[i].setColumns(20);
                TEXT_FIELDS[i].addMouseListener(EVIDENCE_LISTENER);
            }

            LABELS[0].setText(siteName);
            LABELS[0].setFont(TITLE_FONT);

            LABELS[1].setText("Full Name:");
            LABELS[2].setText("Age:");
            LABELS[3].setText("Email:");
            LABELS[4].setText("Billing Address:");
            LABELS[5].setText("Card Number:");
            LABELS[6].setText("Security Code:");
            LABELS[7].setText("SSN:");

            setBackground(BACKGROUND_COLOR);
            TITLE_PANEL.setBackground(BACKGROUND_COLOR);
            TITLE_PANEL.setBorder(BORDER);
            FIELD_PANEL.setBorder(BORDER);
            BUTTON_PANEL.setBackground(BACKGROUND_COLOR);
            BUTTON_PANEL.setBorder(BORDER);

            SUBMIT_BUTTON.setFont(BUTTON_FONT);
            BACK_BUTTON.setFont(BUTTON_FONT);

            BACK_BUTTON.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    webpage.changePanel("page");
                }
            });
        }

        public void setSignUpName(){
            setName(webpage.getName() + " Sign Up");
        }
    }

