package UI;

import Main.GameFrame;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Main.GameFrame.*;
import static java.awt.Font.PLAIN;

public class HomePage extends JPanel {

    private ContentPanel contentPanel;

    private final GameFrame gameFrame;

    private final JPanel BUTTON_PANEL = new JPanel();
    private final JButton newProfileButton = new JButton("Create Account");
    private final JButton loginButton = new JButton("Login");
    private final JButton exitButton = new JButton("Exit");
    private final GroupLayout LAYOUT = new GroupLayout(this);
    private final GroupLayout BUTTON_LAYOUT = new GroupLayout(BUTTON_PANEL);
    private final Font BUTTON_FONT = new Font("Arial", PLAIN, 20);

    public HomePage(GameFrame gameFrame){

        this.gameFrame = gameFrame;
        this.setPreferredSize(GAME_DIMENSION);

         contentPanel = new ContentPanel();
         setButtons();
         setPageLayout();
    }

    public void stopThread(){
        contentPanel.stopThread();
    }

    private void setPageLayout(){

        BUTTON_PANEL.setLayout(BUTTON_LAYOUT);
        BUTTON_LAYOUT.setAutoCreateContainerGaps(true);
        BUTTON_LAYOUT.setHorizontalGroup(BUTTON_LAYOUT.createSequentialGroup()
                .addGroup(BUTTON_LAYOUT.createParallelGroup(GroupLayout.Alignment.LEADING)
                         .addComponent(newProfileButton)).addPreferredGap(newProfileButton, loginButton,
                        LayoutStyle.ComponentPlacement.RELATED, 50, 100)
                .addGroup(BUTTON_LAYOUT.createParallelGroup(GroupLayout.Alignment.CENTER)
                         .addComponent(loginButton)).addPreferredGap(newProfileButton, loginButton,
                        LayoutStyle.ComponentPlacement.RELATED, 50, 100)
                .addGroup(BUTTON_LAYOUT.createParallelGroup(GroupLayout.Alignment.TRAILING)
                          .addComponent(exitButton)).addPreferredGap(loginButton, exitButton,
                        LayoutStyle.ComponentPlacement.RELATED, 50, 100));
        BUTTON_LAYOUT.setVerticalGroup(BUTTON_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(newProfileButton)
                        .addComponent(loginButton)
                        .addComponent(exitButton));

        LAYOUT.setAutoCreateGaps(true);
        LAYOUT.setAutoCreateContainerGaps(true);
        LAYOUT.setHorizontalGroup(LAYOUT.createSequentialGroup()
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(contentPanel)
                        .addComponent(BUTTON_PANEL)));
        LAYOUT.setVerticalGroup(LAYOUT.createSequentialGroup()
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(contentPanel))
                .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(BUTTON_PANEL)));

        setLayout(LAYOUT);
    }

    private void setButtons(){

        newProfileButton.setFont(BUTTON_FONT);
        loginButton.setFont(BUTTON_FONT);
        exitButton.setFont(BUTTON_FONT);

        newProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.setGameState(NEW_ACCOUNT_STATE);
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.setGameState(LOGIN_STATE);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private class ContentPanel extends JPanel implements Runnable{

        private final Thread thread = new Thread(this);
        private final Font TITLE_FONT = new Font("Ravie", PLAIN, 30);
        private final Dimension CONTENT_DIM = new Dimension((int)GAME_DIMENSION.getWidth(),
                (int)(GAME_DIMENSION.getHeight()*.65));
        private final Border CONTENT_BORDER = BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(
                        5,5,5,5, Color.GRAY.brighter()),
                BorderFactory.createMatteBorder(
                        3,3,3,3, Color.GRAY));
        private final Color[] TITLE_COLORS = {new Color(83, 87, 189), new Color(10, 250, 30),
                Color.DARK_GRAY, new Color(237, 7, 203), new Color(143, 231, 255)};

        private Integer[][] titleLocations;
        private int frameCount;
        private int currentTLocation;
        private int currentColor;


        private ContentPanel(){
            this.setBorder(CONTENT_BORDER);
            this.setMaximumSize(CONTENT_DIM);

            frameCount = 0;
            currentTLocation = 0;
            currentColor = 3;

            thread.start();
        }

        private void setGraphics(Graphics2D g2){

            titleLocations = new Integer[7][7];

            titleLocations[0][0] = ((int) (this.getWidth() * .4)) -
                    ((int) (g2.getFontMetrics().getStringBounds("Chatter Box", g2).getWidth()));
            titleLocations[0][1] = (this.getHeight()/2) -
                    ((int) g2.getFontMetrics().getStringBounds("Chatter Box", g2).getHeight() / 2);

            titleLocations[1][0] = titleLocations[0][0] + 40;
            titleLocations[1][1] = titleLocations[0][1] + 60;

            titleLocations[2][0] = titleLocations[0][0] + 10;
            titleLocations[2][1] = titleLocations[0][1] - 40;

            titleLocations[3][0] = titleLocations[0][0] - 20;
            titleLocations[3][1] = titleLocations[0][1] - 30;

            titleLocations[4][0] = titleLocations[0][0] - 60;
            titleLocations[4][1] = titleLocations[0][1] + 80;

            titleLocations[5][0] = titleLocations[0][0] + 80;
            titleLocations[5][1] = titleLocations[0][1] + 30;

            titleLocations[6][0] = titleLocations[0][0] - 90;
            titleLocations[6][1] = titleLocations[0][0] - 90;
        }

        public void stopThread(){
            thread.interrupt();
        }

        private void draw(Graphics2D g2){

            if(titleLocations == null){
                setGraphics(g2);
            }

            g2.setColor(Color.YELLOW);
            g2.fillRect(0,0, this.getWidth(), this.getHeight());
            g2.setFont(TITLE_FONT);
            g2.setColor(TITLE_COLORS[currentColor]);
            g2.drawString("Chatter Box", titleLocations[currentTLocation][0], titleLocations[currentTLocation][1]);

            if(frameCount >= 20){
                frameCount = 0;
                if(currentTLocation < 6){
                    ++currentTLocation;
                }
                else{
                    currentTLocation = 0;
                }
                if(currentColor < 3){
                    ++currentColor;
                }
                else{
                    currentColor = 0;
                }
            }
            else{
                ++frameCount;
            }
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;
            draw(g2);
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

                repaint();
                nextTime += frameInterval;
            }
        }
    }
}
