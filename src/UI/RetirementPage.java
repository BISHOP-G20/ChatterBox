package UI;

import java.awt.*;

public class RetirementPage extends Webpage{

    public RetirementPage(SearchEngine searchEngine){
        super("/Resources/RetirementWebsiteTemplate.png", searchEngine,"Divyata Advising Group");
        textFont = new Font("Lucida Bright", Font.BOLD, 20);
        textPane.setFont(textFont);

        textPane.setText("\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" + //====================================================== top of first blank space
                "\t\t\t\t\t\tOur team of advisors work to\n" +
                "\t\t\t\t\t\tfind you the perfect assisted\n" +
                "\t\t\t\t\t\tliving community.\n" +
                "\t\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\n" +
                "\t\t\t\t\t\tComplete with medical, financial,\n" +
                "\t\t\t\t\t\tand community specialists, we\n" +
                "\t\t\t\t\t\tGUARANTEE the best advising\n" +
                "\t\t\t\t\t\tavailable!\n" +
                "\n" + //====================================================== bottom of first blank space
                "\n\n\n" +
                "\n" + //====================================================== top of second blank space
                "    We know finding a home that meets all your\n" +
                "    needs can be a challenge. That's why Divyata\n" +
                "    advisors takes care of all the work!\n" +
                "\n" +
                "    Focus on whats most important with Divyata!\n" +
                "\n" + //====================================================== bottom of second blank space
                "\n\n\n\n\n\n\n\n\n\n\n" +
                "\n" + //====================================================== top of third blank space
                "\n" +
                "\n" +
                "\n");
        textPane.appendToPane("\n©Divyata Tonem. All Rights Reserved.", finePrint, Color.BLACK);
    }
}
