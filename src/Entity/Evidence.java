package Entity;

import javax.swing.*;
import java.awt.*;

public class Evidence {

    String locationName;
    String evidence;

    public Evidence(String evidence, String locationName){
         this.evidence = evidence;
         this.locationName = locationName;
    }

    public String getText(){
        return evidence;
    }

    public String getLocation(){
        return locationName;
    }

    public String toString(){
        return locationName + ": \"" + evidence + "\"";
    }
}
