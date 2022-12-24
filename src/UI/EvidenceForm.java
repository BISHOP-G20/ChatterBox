package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Entity.Evidence;

import static java.awt.Font.BOLD;
import static java.awt.Font.PLAIN;
import static Main.GameFrame.POLICE;

public class EvidenceForm extends JPanel {

    private ArrayList<JCheckBox> EVIDENCE_CHECKBOXES = new ArrayList<>();
    private ArrayList<Evidence> STORED_EVIDENCE;
    private ArrayList<JTextArea> EVIDENCE_AREAS;

    private final EvidencePage EVIDENCE_PAGE;
    private final JButton SUBMIT_BUTTON = new JButton("Submit");
    private final JButton BACK_BUTTON = new JButton("Back");
    private final Font BUTTON_FONT = new Font("Arial", PLAIN, 15);
    private final Font TITLE_FONT = new Font("Univers Condensed", BOLD, 30);
    private final Font TEXT_FONT = new Font("Ink Free", Font.BOLD, 15);
    private final JLabel TITLE_LABEL = new JLabel("Police Report");
    private final JPanel FIELD_PANEL = new JPanel();
    private final JScrollPane SCROLL_PANE = new JScrollPane(FIELD_PANEL);
    private final GroupLayout FIELD_LAYOUT = new GroupLayout(FIELD_PANEL);
    private final GroupLayout LAYOUT = new GroupLayout(this);

    public EvidenceForm(EvidencePage evidencePage){
        EVIDENCE_PAGE = evidencePage;
        FIELD_PANEL.setBackground(new Color(242, 227, 138));
    }

    private void setPanelLayout(){
        LAYOUT.setAutoCreateGaps(true);
        LAYOUT.setAutoCreateContainerGaps(true);
        LAYOUT.setHorizontalGroup(LAYOUT.createSequentialGroup()
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(BACK_BUTTON))
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(TITLE_LABEL)
                        .addComponent(SCROLL_PANE))
                        .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(SUBMIT_BUTTON)));
        LAYOUT.setVerticalGroup(LAYOUT.createSequentialGroup()
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(TITLE_LABEL))
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(SCROLL_PANE))
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(BACK_BUTTON)
                         .addComponent(SUBMIT_BUTTON)));

        setLayout(LAYOUT);
    }

    private void setFieldLayout(){
        FIELD_LAYOUT.setAutoCreateGaps(true);
        FIELD_LAYOUT.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup vertSEQ = FIELD_LAYOUT.createSequentialGroup();
        GroupLayout.SequentialGroup horiSEQ = FIELD_LAYOUT.createSequentialGroup();
        GroupLayout.ParallelGroup horiLEADING = FIELD_LAYOUT.createParallelGroup(GroupLayout.Alignment.LEADING);
        GroupLayout.ParallelGroup horiTRAILING = FIELD_LAYOUT.createParallelGroup(GroupLayout.Alignment.TRAILING);

        for (int i = 0; i < EVIDENCE_AREAS.size(); i++) {
            vertSEQ.addGroup(FIELD_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(EVIDENCE_AREAS.get(i))
                    .addComponent(EVIDENCE_CHECKBOXES.get(i)));

            horiLEADING.addComponent(EVIDENCE_AREAS.get(i)).addGap(25, 30, 35);
            horiTRAILING.addComponent(EVIDENCE_CHECKBOXES.get(i)).addGap(25, 30, 35);
            System.out.println(EVIDENCE_AREAS.get(i).getText());
        }
        horiSEQ.addGroup(horiLEADING).addGroup(horiTRAILING);

        FIELD_LAYOUT.setHorizontalGroup(horiSEQ);
        FIELD_LAYOUT.setVerticalGroup(vertSEQ);
        FIELD_PANEL.setLayout(FIELD_LAYOUT);
    }

    private void setButtons(){
        SUBMIT_BUTTON.setFont(BUTTON_FONT);
        SUBMIT_BUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EVIDENCE_PAGE.setResponsePanel(POLICE.submitForm(getCheckedEvidence()));
                EVIDENCE_PAGE.changePanel("response");
            }
        });

        BACK_BUTTON.setFont(BUTTON_FONT);
        BACK_BUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EVIDENCE_PAGE.changePanel("evidence");
            }
        });
    }

    private ArrayList<Evidence> getCheckedEvidence(){
        ArrayList<Evidence> chosenEvidence = new ArrayList();
        for (int i = 0; i < EVIDENCE_CHECKBOXES.size(); i++) {
            if(EVIDENCE_CHECKBOXES.get(i).isSelected()){
                chosenEvidence.add(STORED_EVIDENCE.get(i));
            }
        }
        return chosenEvidence;
    }

    private void setEvidenceList(){
        STORED_EVIDENCE = EVIDENCE_PAGE.getStoredEvidence();
    }

    private void setEvidenceLabels(){
        EVIDENCE_AREAS = new ArrayList<>();
        for(Evidence evidence: EVIDENCE_PAGE.getStoredEvidence()){
            JTextArea newArea = new JTextArea();
            newArea.setText(evidence.toString());
            newArea.setFont(TEXT_FONT);
            newArea.setEditable(false);
            newArea.setBackground(null);
            newArea.setMaximumSize(new Dimension(250, 100));
            newArea.setWrapStyleWord(true);
            newArea.setLineWrap(true);
            EVIDENCE_AREAS.add(newArea);

        }

        for (int i = 0; i < EVIDENCE_AREAS.size(); i++) {
            EVIDENCE_CHECKBOXES.add(new JCheckBox());
        }
    }

    private void setTitleLabel(){
        TITLE_LABEL.setFont(TITLE_FONT);
    }

    public void setForm(){
        setTitleLabel();
        setEvidenceList();
        setEvidenceLabels();
        setButtons();
        setFieldLayout();
        setPanelLayout();
    }
}
