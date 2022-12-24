package UI;

import java.awt.*;

public class CbdPage extends Webpage{

    public CbdPage(SearchEngine searchEngine){
        super("/Resources/CBDWebsiteTemplate.png", searchEngine, "CBD Solutions");
        textPane.setText("\n\n\n\n\n\n\n\n\n\n" +
                "\n" + //top of first white space MAYBE
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" + //bottom of first white space MAYBE
                "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                "\n" + //top of second white space MAYBE
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n\n\n\n\n\n");
        textPane.appendToPane("\n©CBD Solutions Tonem. All Rights Reserved.", finePrint, Color.BLACK);
    }
}