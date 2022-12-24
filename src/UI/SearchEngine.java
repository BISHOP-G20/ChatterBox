package UI;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;
import java.util.Locale;

import static Main.GameFrame.PROGRESS_MANAGER;
import static Main.GameFrame.EVIDENCE_LISTENER;
import static java.awt.Font.BOLD;
import static java.awt.Font.PLAIN;

public class SearchEngine extends JPanel{

    private int mode;

    private LogoPanel logoPanel;
    private ResultPanel resultPanel;
    private GenericLinkPanel linkPanel;
    private ImageIcon searchIcon;
    private TestimonyPage testimonyPage;
    private SuspectsPage suspectsPage;
    private Container container;

    private final RetirementPage RETIREMENT_PAGE = new RetirementPage(this);
    private final GoldPage GOLD_PAGE = new GoldPage(this);
    private final CbdPage CBD_PAGE = new CbdPage(this);
    private final JTextField SEARCH_BAR = new JTextField();
    private final JButton SEARCH_BUTTON = new JButton();
    private final JPanel RESULTS_PANEL = new JPanel();
    private final JPanel EMPTY_PANEL = new JPanel();
    private final CardLayout CARD_LAYOUT = new CardLayout();
    private final GroupLayout EMPTY_LAYOUT = new GroupLayout(EMPTY_PANEL);
    private final GroupLayout RESULTS_LAYOUT = new GroupLayout(RESULTS_PANEL);
    private final Color UNSELECTED_COLOR = new Color(100, 144, 232);
    private final Color SELECTED_COLOR = new Color(94, 33, 130);
    private final Color SPECIAL_COLOR = new Color(212, 163, 19);
    private final Color OFFWHITE = new Color(247,247,247,255);
    private final Font US_RESULT_FONT = new Font("Univers Condensed", PLAIN, 20);
    private final Font S_RESULT_FONT = new Font("Univers Condensed", BOLD, 20);
    private final URI SEARCH_URI = URI.create("https://www.google.com/search?q=");
    private final Border US_RESULT_BORDER = BorderFactory.createMatteBorder(0,0, 3, 0, UNSELECTED_COLOR);
    private final Border S_RESULT_BORDER = BorderFactory.createMatteBorder(0,0, 3, 0, SELECTED_COLOR);
    private final Border SPECIAL_BORDER = BorderFactory.createMatteBorder(0,0, 3, 0, SPECIAL_COLOR);

    public SearchEngine(){
        instantiateJComponents();
        setIcon();
        setButton();
        setContainer();
        setName("Search Engine");
    }

    private void searchGoogle(String query) {
        query = query.toLowerCase(Locale.ROOT);

        if(query.contains(testimonyPage.getPageURL().toLowerCase(Locale.ROOT))){
            changePanel("testimony");
        }
        else if(query.equals(suspectsPage.getPageURL().toLowerCase(Locale.ROOT))){
            changePanel("suspects");
        }
        else {
            try {
                Document doc = Jsoup.connect(SEARCH_URI + query).get();

                Object[] allResultsAsObject = doc.getElementsByTag("h3").toArray();
                String[] resultTitles = new String[5];

                int resultCounter = 0;
                mode = 0;

                if (query.contains("gold") || query.contains("saudi") || query.contains("prince") || query.contains("united") || query.contains("invest")) {
                    resultTitles[0] = GOLD_PAGE.getSiteName();
                    mode = 1;
                    resultCounter++;
                    getGoogleLinks(allResultsAsObject, resultTitles, resultCounter);
                } else if (query.contains("cbd") || query.contains("joint") || query.contains("pain") || query.contains("relief") || query.contains("oil")
                        || query.contains("arthritis") || query.contains("osteoarthritis") || query.contains("marijuana") || query.contains("weed")) {
                    resultTitles[0] = CBD_PAGE.getSiteName();
                    mode = 2;
                    resultCounter++;
                    getGoogleLinks(allResultsAsObject, resultTitles, resultCounter);
                } else if (query.contains("retire") || query.contains("assist") || query.contains("living") || query.contains("advise")
                        || query.contains("advisor") || query.contains("Divyata")) {
                    resultTitles[0] = RETIREMENT_PAGE.getSiteName();
                    mode = 3;
                    resultCounter++;
                    getGoogleLinks(allResultsAsObject, resultTitles, resultCounter);
                } else if (query.contains("tonem")) {
                    mode = 4;
                    resultTitles[0] = GOLD_PAGE.getSiteName();
                    resultTitles[1] = CBD_PAGE.getSiteName();
                    resultTitles[2] = RETIREMENT_PAGE.getSiteName();
                    resultCounter = 3;
                    getGoogleLinks(allResultsAsObject, resultTitles, resultCounter);
                }
                else{
                    getGoogleLinks(allResultsAsObject, resultTitles, resultCounter);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void getGoogleLinks(Object[] allResultsAsObject, String[] resultTitles, int resultCounter){

        int resultIterator = 0;

        while (resultCounter < 5) {
            String currentResult;

            try {
                currentResult =
                        allResultsAsObject[resultIterator].toString().substring(
                                allResultsAsObject[resultIterator].toString().indexOf("\">") + 2,
                                allResultsAsObject[resultIterator].toString().indexOf("</"));
            }
            catch (NullPointerException e){
                for(int i = 0; i < resultTitles.length; ++i){
                    if(resultTitles[i] == null){
                        resultTitles[i] = "ERROR";
                    }
                }
                e.printStackTrace();
                break;
            }

            if(!currentResult.contains("\"") && !currentResult.contains("\\") && !currentResult.contains("/")
                    && !currentResult.contains("<") && !currentResult.contains(">")){
                resultTitles[resultCounter] = currentResult;
                ++resultCounter;
            }
            ++resultIterator;
        }
        resultPanel.setResultText(resultTitles, mode);
        SEARCH_BAR.setMaximumSize(new Dimension(350, 20));
        changePanel("result");
    }

    private void defineEmptyLayout(){
        EMPTY_LAYOUT.setAutoCreateGaps(true);
        EMPTY_LAYOUT.setAutoCreateContainerGaps(true);

        EMPTY_LAYOUT.setHorizontalGroup(EMPTY_LAYOUT.createSequentialGroup()
                .addGroup(EMPTY_LAYOUT.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(logoPanel)
                        .addComponent(SEARCH_BAR))
                .addGroup(EMPTY_LAYOUT.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(SEARCH_BUTTON)));
        EMPTY_LAYOUT.setVerticalGroup(EMPTY_LAYOUT.createSequentialGroup()
                .addGroup(EMPTY_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(logoPanel))
                .addGroup(EMPTY_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(SEARCH_BAR).addComponent(SEARCH_BUTTON)));
        EMPTY_PANEL.setBackground(OFFWHITE);
        EMPTY_PANEL.setLayout(EMPTY_LAYOUT);
    }

    private void defineResultLayout(){
        RESULTS_LAYOUT.setAutoCreateGaps(true);
        RESULTS_LAYOUT.setAutoCreateContainerGaps(true);

        RESULTS_LAYOUT.setHorizontalGroup(RESULTS_LAYOUT.createSequentialGroup()
                .addGroup(RESULTS_LAYOUT.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(logoPanel)
                        .addComponent(SEARCH_BAR)
                        .addComponent(resultPanel))
                .addGroup(RESULTS_LAYOUT.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(SEARCH_BUTTON)));

        RESULTS_LAYOUT.setVerticalGroup(RESULTS_LAYOUT.createSequentialGroup()
                .addGroup(RESULTS_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(logoPanel))
                .addGroup(RESULTS_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(SEARCH_BAR).addComponent(SEARCH_BUTTON))
                .addGroup(RESULTS_LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(resultPanel)));
        RESULTS_PANEL.setBackground(OFFWHITE);
        RESULTS_PANEL.setLayout(RESULTS_LAYOUT);
    }

    private void setContainer(){
        container = this;
        container.setLayout(CARD_LAYOUT);
        container.add(RESULTS_PANEL, "result");
        container.add(linkPanel, "link");
        container.add(EMPTY_PANEL, "empty");
        container.add(GOLD_PAGE, "gold");
        container.add(CBD_PAGE, "cbd");
        container.add(RETIREMENT_PAGE, "retire");
        container.add(testimonyPage, "testimony");
        container.add(suspectsPage, "suspects");
        changePanel("result");
    }

    private void instantiateJComponents(){
        logoPanel = new LogoPanel();
        resultPanel = new ResultPanel(this);
        linkPanel = new GenericLinkPanel(this);
        testimonyPage = new TestimonyPage(this);
        suspectsPage = new SuspectsPage(this);

        SEARCH_BAR.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    getSearchedText();
                }
            }
        });
        SEARCH_BAR.addMouseListener(EVIDENCE_LISTENER);
    }

    private void setButton(){
        SEARCH_BUTTON.setIcon(searchIcon);
        SEARCH_BUTTON.setBackground(OFFWHITE);
        SEARCH_BUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getSearchedText();
            }
        });
    }

    private void setIcon(){
        searchIcon = new ImageIcon(new ImageIcon("src/Resources/SearchIcon.png")
                .getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH));
    }

    private void getSearchedText(){
        String input = SEARCH_BAR.getText();
        if(input.length() != 0) {
            searchGoogle(input);
        }
    }

    public void changePanel(String panelName){
        if(panelName.equals("empty")){
            defineEmptyLayout();
        }
        else if(panelName.equals("result")){
            defineResultLayout();
        }
        CARD_LAYOUT.show(container, panelName);
    }

    private class LogoPanel extends JPanel{

        private ImageIcon logo;
        private final Dimension PANEL_DIM = new Dimension(250, 145);//TEMP VALUES
                                                    // GET LENGTH/WIDTH AS PNG VALUE DIVIDEND
                                                    //OR MAYBE DONT, IT LOOKS FINE AS IS

        private LogoPanel(){
            setLogo();
            this.setMaximumSize(PANEL_DIM);
        }

        private void setLogo(){
            logo = new ImageIcon(new ImageIcon("src/Resources/SearchLogo.png").getImage()
                    .getScaledInstance(PANEL_DIM.width, PANEL_DIM.height, Image.SCALE_SMOOTH));
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);

            logo.paintIcon(this, g, 0, 0);
        }
    }

    private class ResultPanel extends JPanel{

        private int mode;
        private JLabel[] resultLabels = new JLabel[5];

        private final Dimension PANEL_DIM = new Dimension(780,300);
        private final GroupLayout LAYOUT = new GroupLayout(this);
        private final SearchEngine searchEngine;

        private ResultPanel(SearchEngine searchEngine){
            this.searchEngine = searchEngine;
            instantiateJComponents();
            setLayout();
            setBackground(OFFWHITE);
            setPreferredSize(PANEL_DIM);
        }

        private void instantiateJComponents(){
            for (int i = 0; i < resultLabels.length; ++i) {
                resultLabels[i] = new JLabel("");
            }

            resultLabels[0].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if(e.getButton() == MouseEvent.BUTTON1) {
                        if ((mode == 1 || mode == 4) && PROGRESS_MANAGER.getProgress() < 5) {
                            GOLD_PAGE.getTopPanel().startThread(true);
                            searchEngine.changePanel("gold");
                        } else if (mode == 2 && PROGRESS_MANAGER.getProgress() < 5) {
                            CBD_PAGE.getTopPanel().startThread(true);
                            searchEngine.changePanel("cbd");
                        } else if (mode == 3 && PROGRESS_MANAGER.getProgress() < 5) {
                            RETIREMENT_PAGE.getTopPanel().startThread(true);
                            searchEngine.changePanel("retire");
                        } else if ((mode == 1 || mode == 2 || mode == 3 || mode == 4) && PROGRESS_MANAGER.getProgress() == 5){
                            PROGRESS_MANAGER.addGameProgress();
                            resultLabels[0].setForeground(SELECTED_COLOR);
                            resultLabels[0].setBorder(S_RESULT_BORDER);
                            resultLabels[0].setFont(S_RESULT_FONT);
                            searchEngine.changePanel("link");
                        }
                        else {
                            resultLabels[0].setForeground(SELECTED_COLOR);
                            resultLabels[0].setBorder(S_RESULT_BORDER);
                            resultLabels[0].setFont(S_RESULT_FONT);
                            searchEngine.changePanel("link");
                        }
                    }
                    else{
                        EVIDENCE_LISTENER.mouseClicked(e);
                    }
                }
            });

            resultLabels[1].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(e.getButton() == MouseEvent.BUTTON1) {
                        if (mode == 4 && PROGRESS_MANAGER.getProgress() < 5) {
                            CBD_PAGE.getTopPanel().startThread(true);
                            searchEngine.changePanel("cbd");
                        }
                        else if(mode == 4 && PROGRESS_MANAGER.getProgress() == 5){
                            PROGRESS_MANAGER.addGameProgress();
                            resultLabels[0].setForeground(SELECTED_COLOR);
                            resultLabels[0].setBorder(S_RESULT_BORDER);
                            resultLabels[0].setFont(S_RESULT_FONT);
                            searchEngine.changePanel("link");
                        }
                        else {
                            super.mouseClicked(e);
                            resultLabels[1].setForeground(SELECTED_COLOR);
                            resultLabels[1].setBorder(S_RESULT_BORDER);
                            resultLabels[1].setFont(S_RESULT_FONT);
                            searchEngine.changePanel("link");
                        }
                    }
                    else{
                        EVIDENCE_LISTENER.mouseClicked(e);
                    }
                }
            });

            resultLabels[2].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if(e.getButton() == MouseEvent.BUTTON1) {
                        if (mode == 4 && PROGRESS_MANAGER.getProgress() < 5) {
                            RETIREMENT_PAGE.getTopPanel().startThread(true);
                            searchEngine.changePanel("retire");
                        }
                        else if(mode == 4 && PROGRESS_MANAGER.getProgress() == 5){
                            PROGRESS_MANAGER.addGameProgress();
                            resultLabels[0].setForeground(SELECTED_COLOR);
                            resultLabels[0].setBorder(S_RESULT_BORDER);
                            resultLabels[0].setFont(S_RESULT_FONT);
                            searchEngine.changePanel("link");
                        }
                        else {
                            resultLabels[2].setForeground(SELECTED_COLOR);
                            resultLabels[2].setBorder(S_RESULT_BORDER);
                            resultLabels[2].setFont(S_RESULT_FONT);
                            searchEngine.changePanel("link");
                        }
                    }
                    else{
                        EVIDENCE_LISTENER.mouseClicked(e);
                    }
                }
            });

            resultLabels[3].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if(e.getButton() == MouseEvent.BUTTON1) {
                        resultLabels[3].setForeground(SELECTED_COLOR);
                        resultLabels[3].setBorder(S_RESULT_BORDER);
                        resultLabels[3].setFont(S_RESULT_FONT);
                        searchEngine.changePanel("link");
                    }
                    else{
                        EVIDENCE_LISTENER.mouseClicked(e);
                    }
                }
            });

            resultLabels[4].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if(e.getButton() == MouseEvent.BUTTON1) {
                        resultLabels[4].setForeground(SELECTED_COLOR);
                        resultLabels[4].setBorder(S_RESULT_BORDER);
                        resultLabels[4].setFont(S_RESULT_FONT);
                        searchEngine.changePanel("link");
                    }
                    else{
                        EVIDENCE_LISTENER.mouseClicked(e);
                    }
                }
            });
        }

        private void setLayout(){
            LAYOUT.setAutoCreateGaps(true);
            LAYOUT.setAutoCreateContainerGaps(true);

            LAYOUT.setHorizontalGroup(LAYOUT.createSequentialGroup()
                    .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(resultLabels[0])
                            .addComponent(resultLabels[1])
                            .addComponent(resultLabels[2])
                            .addComponent(resultLabels[3])
                            .addComponent(resultLabels[4])));

            LAYOUT.setVerticalGroup(LAYOUT.createSequentialGroup()
                    .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(resultLabels[0]))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED,35,35)
                    .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(resultLabels[1]))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED,35,35)
                    .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(resultLabels[2]))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED,35,35)
                    .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(resultLabels[3]))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED,35,35)
                    .addGroup(LAYOUT.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(resultLabels[4]))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED,35,35));

            setLayout(LAYOUT);
        }

        private void setResultText(String[] titles, int mode){
            this.mode = mode;
            switch (mode) {
                case 0:
                    for (int i = 0; i < resultLabels.length; i++) {
                        resultLabels[i].setText(titles[i]);
                        resultLabels[i].setForeground(UNSELECTED_COLOR);
                        resultLabels[i].setBorder(US_RESULT_BORDER);
                        resultLabels[i].setFont(US_RESULT_FONT);
                    }
                    break;

                case 1,2,3:
                    for (int i = 0; i < resultLabels.length; i++) {
                        resultLabels[i].setText(titles[i]);
                        resultLabels[i].setForeground(UNSELECTED_COLOR);
                        resultLabels[i].setBorder(US_RESULT_BORDER);
                        resultLabels[i].setFont(US_RESULT_FONT);
                    }
                    resultLabels[0].setForeground(SPECIAL_COLOR);
                    resultLabels[0].setBorder(SPECIAL_BORDER);
                    break;

                case 4:
                    for (int i = 0; i < 3; i++) {
                        resultLabels[i].setText(titles[i]);
                        resultLabels[i].setForeground(SPECIAL_COLOR);
                        resultLabels[i].setBorder(SPECIAL_BORDER);
                    }
                    resultLabels[3].setText(titles[3]);
                    resultLabels[3].setForeground(UNSELECTED_COLOR);
                    resultLabels[3].setBorder(US_RESULT_BORDER);
                    resultLabels[3].setFont(US_RESULT_FONT);

                    resultLabels[4].setText(titles[4]);
                    resultLabels[4].setForeground(UNSELECTED_COLOR);
                    resultLabels[4].setBorder(US_RESULT_BORDER);
                    resultLabels[4].setFont(US_RESULT_FONT);
            }
        }
    }

    private class GenericLinkPanel extends JPanel{

        private final JLabel ERROR_LABEL = new JLabel("ERROR: Page not relevant");
        private final JLabel DIRECTION_LABEL = new JLabel("Click anywhere to return to search engine");
        private final SearchEngine SEARCH_ENGINE;

        private GenericLinkPanel(SearchEngine searchEngine){
            SEARCH_ENGINE = searchEngine;
            setMinimumSize(new Dimension(600, 400));
            setLabel();
            setBackground(OFFWHITE);
            add(ERROR_LABEL, BorderLayout.NORTH);
            add(DIRECTION_LABEL, BorderLayout.SOUTH);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if(e.getButton() != MouseEvent.BUTTON3){
                        searchEngine.changePanel("result");
                    }
                }
            });
        }

        private void setLabel(){
            ERROR_LABEL.setFont(new Font("Univers Condensed", BOLD, 50));
            DIRECTION_LABEL.setFont(new Font("Univers Condensed", PLAIN, 35));
            ERROR_LABEL.setBackground(OFFWHITE);
            DIRECTION_LABEL.setBackground(OFFWHITE);
            ERROR_LABEL.addMouseListener(EVIDENCE_LISTENER);
            DIRECTION_LABEL.addMouseListener(EVIDENCE_LISTENER);
        }
    }
}
