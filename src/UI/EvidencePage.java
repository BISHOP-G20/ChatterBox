package UI;

import Entity.Evidence;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static Main.GameFrame.GAME_DIMENSION;
import static Main.GameFrame.PROGRESS_MANAGER;
import static java.awt.Font.BOLD;
import static java.awt.Font.PLAIN;

public class EvidencePage extends JPanel {

    private ArrayList<JTextArea> evidenceAreas = new ArrayList<>();
    private ArrayList<Evidence> storedEvidence = new ArrayList();
    private Container container;

    private final PoliceResponsePanel RESPONSE_PANEL = new PoliceResponsePanel();
    public final EvidenceForm EVIDENCE_FORM = new EvidenceForm(this);
    private final JButton REPORT_BUTTON = new JButton("Create Police Report");
    private final JPanel LABEL_PANEL = new JPanel();
    private final JPanel EVIDENCE_PANEL = new JPanel();
    private final JScrollPane SCROLL_PANE = new JScrollPane(LABEL_PANEL);
    private final GroupLayout layout = new GroupLayout(LABEL_PANEL);
    private final GroupLayout EVIDENCE_LAYOUT = new GroupLayout(EVIDENCE_PANEL);
    private final CardLayout CARD_LAYOUT = new CardLayout();
    private final Font TEXT_FONT = new Font("Ink Free", Font.BOLD, 15);
    private final Font BUTTON_FONT = new Font("Arial", PLAIN, 15);

    public EvidencePage(){
        setButton();
        setPanelLayout();
        setLabelLayout();
        setCardLayout();
        LABEL_PANEL.setBackground(new Color(242, 227, 138));
        SCROLL_PANE.setPreferredSize(new Dimension((int)GAME_DIMENSION.getWidth() - 10,(int) GAME_DIMENSION.getHeight() - 70));
    }

    private void setLabelLayout(){

        int maxSetIndex = 0;

        LABEL_PANEL.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup horizontalSEQ = layout.createSequentialGroup();
        GroupLayout.SequentialGroup verticalSEQ = layout.createSequentialGroup();

        GroupLayout.ParallelGroup horiLEADING = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        GroupLayout.ParallelGroup horiTRAILING = layout.createParallelGroup(GroupLayout.Alignment.TRAILING);

        if(evidenceAreas.size() >= 2){
            for (int i = 0; i < evidenceAreas.size()/2; i++) {
                verticalSEQ.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(evidenceAreas.get(i*2))
                        .addComponent(evidenceAreas.get((i*2)+1)));

                horiLEADING.addComponent(evidenceAreas.get(i * 2)).addGap(70, 100, 110);
                horiTRAILING.addComponent(evidenceAreas.get((i * 2) + 1)).addGap(70, 100, 110);

                maxSetIndex += 2;
            }
        }
        if(maxSetIndex < evidenceAreas.size()){
                verticalSEQ.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(evidenceAreas.get(maxSetIndex)));
                horiLEADING.addComponent(evidenceAreas.get(maxSetIndex));
        }
        horizontalSEQ.addGroup(horiLEADING).addGroup(horiTRAILING);

        layout.setHorizontalGroup(horizontalSEQ);
        layout.setVerticalGroup(verticalSEQ);
    }

    private void setPanelLayout(){
        EVIDENCE_PANEL.setLayout(EVIDENCE_LAYOUT);
        EVIDENCE_LAYOUT.setAutoCreateGaps(true);
        EVIDENCE_LAYOUT.setAutoCreateContainerGaps(true);
        EVIDENCE_LAYOUT.setHorizontalGroup(EVIDENCE_LAYOUT.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(SCROLL_PANE)
                .addComponent(REPORT_BUTTON));
        EVIDENCE_LAYOUT.setVerticalGroup(EVIDENCE_LAYOUT.createSequentialGroup()
                .addGroup(EVIDENCE_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(SCROLL_PANE)).addGroup(EVIDENCE_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(REPORT_BUTTON)));
    }

    private void setCardLayout(){
        container = this;
        container.setLayout(CARD_LAYOUT);
        container.add(EVIDENCE_PANEL, "evidence");
        container.add(EVIDENCE_FORM, "form");
        container.add(RESPONSE_PANEL, "response");
        CARD_LAYOUT.show(container,"evidence");
    }

    private void setButton(){
        REPORT_BUTTON.setFont(BUTTON_FONT);
        REPORT_BUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EVIDENCE_FORM.setForm();
                CARD_LAYOUT.show(container, "form");
            }
        });
    }

    private void checkForProgress(){
        PROGRESS_MANAGER.checkEvidence(storedEvidence);
    }

    public void addEvidence(String evidence){
        String location = evidence.substring(0,evidence.indexOf(":"));
        String text = evidence.substring(evidence.indexOf("\"") + 1, evidence.length() - 1);
        storedEvidence.add(new Evidence(text, location));

        evidenceAreas.add(new JTextArea());
        evidenceAreas.get(evidenceAreas.size()-1).setText(storedEvidence.get(storedEvidence.size()-1).toString());
        updatePage();
    }

    public void addEvidence(String text, Container container){
        Container parent = container;
        do{
            parent = parent.getParent();
            System.out.println(parent.getClass().getName());
            if(parent.getClass().getName().contains("UI")){
                break;
            }
        }
        while(parent.getParent() != null);

        storedEvidence.add(new Evidence(text, parent.getName()));
        evidenceAreas.add(new JTextArea());
        evidenceAreas.get(evidenceAreas.size()-1).setText(storedEvidence.get(storedEvidence.size()-1).toString());
        checkForProgress();
        updatePage();
        EVIDENCE_FORM.setForm();
    }

    public void updatePage(){
        for(JTextArea evidence: evidenceAreas){
            evidence.setFont(TEXT_FONT);
            evidence.setEditable(false);
            evidence.setBackground(null);
            evidence.setMaximumSize(new Dimension(250, 100));
            evidence.setWrapStyleWord(true);
            evidence.setLineWrap(true);
        }
        setLabelLayout();
    }

    public void setEvidenceForm(){
        EVIDENCE_FORM.setForm();
    }

    public void changePanel(String panelName){
        CARD_LAYOUT.show(container, panelName);
    }

    public ArrayList<Evidence> getStoredEvidence(){
        return storedEvidence;
    }

    public void setResponsePanel(String[] response){
        RESPONSE_PANEL.setResponsePanel(response);
    }

    private class PoliceResponsePanel extends JPanel{

        private final JTextArea RESPONSE_AREA = new JTextArea();
        private final JButton BUTTON = new JButton();
        private final JLabel TITLE_LABEL = new JLabel();
        private final Font TITLE_FONT = new Font("Univers Condensed", BOLD, 30);
        private final Font TEXT_FONT = new Font("Courier New", Font.BOLD, 13);
        private final Color SUCCESS_COLOR = new Color(46, 168, 30);
        private final Color FAIL_COLOR = new Color(112, 22, 28);
        private final Color INCOMPLETE_COLOR = new Color(91, 92, 91);
        private final GroupLayout LAYOUT = new GroupLayout(this);

        private PoliceResponsePanel(){
            setPanelLayout();
            setDefaults();
        }

        private void setDefaults(){
            TITLE_LABEL.setFont(TITLE_FONT);
            RESPONSE_AREA.setFont(TEXT_FONT);
            RESPONSE_AREA.setPreferredSize(new Dimension((int)GAME_DIMENSION.getWidth() - 50, (int)GAME_DIMENSION.getHeight() - 100));
            RESPONSE_AREA.setLineWrap(true);
            RESPONSE_AREA.setWrapStyleWord(true);
            RESPONSE_AREA.setBackground(null);
            BUTTON.setFont(BUTTON_FONT);
        }

        private void setPanelLayout(){
            LAYOUT.setAutoCreateGaps(true);
            LAYOUT.setAutoCreateContainerGaps(true);

            LAYOUT.setHorizontalGroup(LAYOUT.createSequentialGroup()
                    .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.CENTER)
                            .addComponent(TITLE_LABEL)
                            .addComponent(RESPONSE_AREA)
                            .addComponent(BUTTON)));
            LAYOUT.setVerticalGroup(LAYOUT.createSequentialGroup()
                    .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(TITLE_LABEL))
                    .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(RESPONSE_AREA))
                    .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(BUTTON)));
            setLayout(LAYOUT);
        }

        private void setTitle(String responseType){
            switch (responseType){
                case "s":
                    TITLE_LABEL.setText("Success");
                    TITLE_LABEL.setForeground(SUCCESS_COLOR);
                    break;

                case "f":
                    TITLE_LABEL.setText("Failure");
                    TITLE_LABEL.setForeground(FAIL_COLOR);
                    break;

                case "i":
                    TITLE_LABEL.setText("Incomplete Form");
                    TITLE_LABEL.setForeground(INCOMPLETE_COLOR);
                    break;
            }
        }

        private void setResponseArea(String response){
            RESPONSE_AREA.setText(response);
        }

        private void setButton(String responseType){
            switch (responseType){
                case "s":
                    BUTTON.setText("Exit");
                    BUTTON.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            System.exit(0);
                        }
                    });
                    break;

                case "i","f":
                    BUTTON.setText("Back");
                    BUTTON.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            changePanel("evidence");
                        }
                    });
                    break;
            }
        }

        private void setResponsePanel(String[] response){
            setTitle(response[1]);
            setResponseArea(response[0]);
            setButton(response[1]);
        }
    }
}
