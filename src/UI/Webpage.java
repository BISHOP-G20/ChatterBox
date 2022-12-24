package UI;

import Main.EvidenceListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static Main.GameFrame.EVIDENCE_LISTENER;
import static Main.GameFrame.GAME_DIMENSION;
import static java.awt.Font.PLAIN;

public class Webpage extends JPanel {

    public TextPane textPane;
    public Font textFont;
    public String siteName;

    public final Font finePrint = new Font("Univers Condensed", PLAIN, 10);

    private Image background;
    private JScrollPane scrollPane;
    private String IMAGE_PATH;
    private SearchEngine searchEngine;
    private StyleContext styleContext;
    private AttributeSet attributeSet;
    private Container container;

    private SignUpForm signUpForm = new SignUpForm(this);
    private final TopPanel topPanel = new TopPanel();
    private final JPanel PAGE_PANEL = new JPanel();
    private final GroupLayout PAGE_LAYOUT = new GroupLayout(PAGE_PANEL);
    private final CardLayout CARD_LAYOUT = new CardLayout();

    public Webpage(String imagePath, SearchEngine searchEngine, String siteName){
        this.searchEngine = searchEngine;
        this.siteName = siteName;
        IMAGE_PATH = imagePath;
        getImageBackground();
        setTextPane();
        setScrollPane();
        setPageLayout();
        setName(siteName);
        signUpForm.setSignUpName();
    }

    private void setPageLayout(){
        PAGE_PANEL.setLayout(PAGE_LAYOUT);
        PAGE_LAYOUT.setHorizontalGroup(PAGE_LAYOUT.createSequentialGroup()
                .addGroup(PAGE_LAYOUT.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(topPanel)
                        .addComponent(scrollPane)));
        PAGE_LAYOUT.setVerticalGroup(PAGE_LAYOUT.createSequentialGroup()
                .addGroup(PAGE_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(topPanel))
                .addGroup(PAGE_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(scrollPane)));

        container = this;
        container.setLayout(CARD_LAYOUT);
        container.add(PAGE_PANEL, "page");
        container.add(signUpForm, "sign up");
        changePanel("page");
    }

    private void getImageBackground(){
        BufferedImage tempBuffImage;
        int widthScaled;
        int heightScaled;

        try {
            tempBuffImage = ImageIO.read(getClass().getResourceAsStream(IMAGE_PATH));

            widthScaled = (int) (tempBuffImage.getWidth()*(GAME_DIMENSION.getWidth()/tempBuffImage.getWidth())-20);
            heightScaled = (int) (tempBuffImage.getHeight()*(GAME_DIMENSION.getWidth()/tempBuffImage.getWidth()));

            background = tempBuffImage.getScaledInstance(widthScaled, heightScaled, Image.SCALE_SMOOTH);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private void setScrollPane(){
        scrollPane = new JScrollPane(textPane);
        scrollPane.setPreferredSize(new Dimension((int) GAME_DIMENSION.getWidth(), (int) GAME_DIMENSION.getHeight() - 30));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.createVerticalScrollBar();
        scrollPane.setWheelScrollingEnabled(true);
    }

    private void setTextPane(){
        textPane = new TextPane();
        textPane.addMouseListener(EVIDENCE_LISTENER);
    }

    public void changePanel(String panelName){
        CARD_LAYOUT.show(container, panelName);
    }

    public TopPanel getTopPanel() {
        return topPanel;
    }

    public String getSiteName() {
        return siteName;
    }

    public class TextPane extends JTextPane {

        public TextPane(){
            styleContext = StyleContext.getDefaultStyleContext();
            setEditable(false);
            setOpaque(false);
        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(background, 0, 0, null);
            super.paintComponent(g2);
        }

        public void appendToPane(String string, Font font, Color color){

            StyledDocument document = textPane.getStyledDocument();

            attributeSet = styleContext.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);
            attributeSet = styleContext.addAttribute(attributeSet, StyleConstants.FontFamily, font.getFamily());
            attributeSet = styleContext.addAttribute(attributeSet, StyleConstants.FontSize, font.getSize());
            attributeSet = styleContext.addAttribute(attributeSet, StyleConstants.Alignment, StyleConstants.ALIGN_LEFT);

            try {
                document.insertString(document.getLength(), string, attributeSet);
            }
            catch (BadLocationException e){
                e.printStackTrace();
            }
            if(scrollPane.getVerticalScrollBar() != null){
                scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
            }
        }
    }

    public class TopPanel extends JPanel implements Runnable{

        private ImageIcon icon;
        private int frameCounter;
        private int colorIndex;

        private final Thread thread;

        private final Font signUpFont = new Font("Impact",Font.BOLD,23);
        private final Color[] colors = new Color[8];
        private final JLabel iconLabel = new JLabel();
        private final JTextArea signUpArea = new JTextArea("Sign Up Now!");
        private final GroupLayout LAYOUT = new GroupLayout(this);

        public TopPanel(){
            thread = new Thread(this);
            frameCounter = 0;
            colorIndex = 0;

            setIcon();
            setLabels();
            setPreferredSize(new Dimension((int)GAME_DIMENSION.getWidth(), signUpArea.getHeight()));
            setColors();
            setPanelLayout();
        }

        private void setPanelLayout(){
            setLayout(LAYOUT);
            LAYOUT.setHorizontalGroup(LAYOUT.createSequentialGroup()
                    .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(iconLabel))
                    .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(signUpArea)));
            LAYOUT.setVerticalGroup(LAYOUT.createSequentialGroup()
                    .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                         .addComponent(iconLabel)
                         .addComponent(signUpArea)));
        }

        private void setIcon(){
            icon = new ImageIcon(new ImageIcon("src/Resources/BackArrow.png").getImage().getScaledInstance(50,34, Image.SCALE_SMOOTH));
        }

        private void setLabels(){
            iconLabel.setIcon(icon);
            iconLabel.setMinimumSize(new Dimension((int) GAME_DIMENSION.getWidth()/2, iconLabel.getHeight()));
            iconLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    startThread(false);
                    searchEngine.changePanel("result");
                }
            });

            signUpArea.setPreferredSize(new Dimension((int) GAME_DIMENSION.getWidth()/2, signUpArea.getHeight()));
            signUpArea.setFont(signUpFont);
            signUpArea.setBackground(Color.GRAY);
            signUpArea.setEditable(false);
            signUpArea.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if(e.getButton() == MouseEvent.BUTTON1) {
                        changePanel("sign up");
                    }
                    else{
                        EVIDENCE_LISTENER.mouseClicked(e);
                    }
                }
            });
        }

        private void setColors(){
            colors[0] = Color.CYAN;
            colors[1] = Color.BLACK;
            colors[2] = Color.GREEN.darker();
            colors[3] = Color.BLACK;
            colors[4] = Color.YELLOW;
            colors[5] = Color.BLACK;
            colors[6] = Color.RED;
            colors[7] = Color.BLACK;
        }

        private void changeColor(){
            if(frameCounter > 3){
                signUpArea.setForeground(colors[colorIndex]);
                if(colorIndex >= 7){
                    colorIndex = 0;
                }
                else{
                    ++colorIndex;
                }
                frameCounter = 0;
            }
        }

        public void startThread(boolean bool){
            synchronized (this) {
                try {
                    if (bool && thread.getState() == Thread.State.NEW) {
                        thread.start();
                    }
                    else if(bool && thread.getState() == Thread.State.WAITING) {
                        notify();
                    }
                    else if (!bool) {
                        thread.interrupt();
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void run() {
            int frameInterval = 1000000000 / 60;
            Double nextTime = (double) System.nanoTime() + frameInterval;

            while (thread != null) {

                double remainingTime = nextTime - System.nanoTime();
                remainingTime /= 1000000;

                if (remainingTime > 0) {
                    try {
                        Thread.sleep((long) remainingTime);

                    } catch (InterruptedException e) {

                    }
                }
                nextTime += frameInterval;
                changeColor();
                ++frameCounter;
            }
        }
    }
}

