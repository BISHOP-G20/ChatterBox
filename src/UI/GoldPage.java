package UI;

import java.awt.*;


public class GoldPage extends Webpage{

    private final Font LABEL_FONT = new Font("Univers Condensed", Font.BOLD, 20);

    public GoldPage(SearchEngine searchEngine){
        super("/Resources/GoldWebsiteTemplate.png", searchEngine, "Saudi Princes United Gold");
        textFont = new Font("Univers Condensed", Font.PLAIN, 15);

        textPane.setFont(LABEL_FONT);
        textPane.setMargin(new Insets(0, 30, 0, 30));
        textPane.setText("\n" +
                "\n" + //===================================================================== top of border space
                "\n" +
                "\n" +
                "\t\t\t\tHome\t\tIndexes\tAbout Us\n" +
                "\n" + //===================================================================== bottom of border space
                "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                "\n" + //===================================================================== top of second blank space
                "\n");
        String pageBottom =
                "\n" +
                "\n" +
                "Make your savings WORK for YOU! Gold is the monetary standard of the world, and its for a reason. " +
                "No matter what the state of inflation is, gold ALWAYS holds value. 99% of investors above the" +
                "age of 50 maintain a majority gold portfolio. And, since 2010 the value of gold has increased" +
                "by 113%. That is an annual yield of nearly 10% I think! Math is hard, but the decision to invest" +
                "in gold is EASY!" +
                "\n\n\n\n\n\n\n" +
                "On average, gold commodity holders earn $1.5 million each year. That's a lot of money, and you" +
                "look poor. I mean honestly, you look really poor. When was the last time you got yourself" +
                "some Air Jordan 2 OGs? Never? Well, nobody is surprised! Look at you, running the torn-up white" +
                "2007 Vans. Invest in gold, take a shower, and stop looking so broke!" +
                "\n\n\n\n\n\n";
        textPane.appendToPane(pageBottom, textFont, Color.WHITE);
        textPane.appendToPane("\n©Saudi Princes United Gold Tonem. All Rights Reserved.", finePrint, Color.BLACK);
    }
}