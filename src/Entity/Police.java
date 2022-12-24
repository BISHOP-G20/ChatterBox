package Entity;

import UI.EvidencePage;

import java.util.ArrayList;

public class Police {

    final String[] successResponse = {"Congratulations! We have opened a case into the report you filed and have concluded there is reason for " +
            "prosecution. On February 8th, Juliette Monet will be extradited to the United States and stand trial the following week on the 15th." +
            " Should the jury find the defendant guilty, the relevant banks will reimburse the victims of the robbery in full. The Local Police" +
            " Department thanks you for you hard work in investigating a case which had long ago been closed. The case will not be closed until" +
            " a conviction has been made. The true outcome of this ordeal will only become clear after trial. Nevertheless, as the Chief of Police" +
            " I would like to thank you on behalf of my department and the victims for standing up for justice. Justice which would otherwise" +
            " have been thwarted by the powers of evil. Thank you kind citizen.\n\n- Chief of Police Craig Gregerson", "s"};
    final String[] failResponse = {"The form you have submitted contains unsubstantial evidence and will not result in the prosecution of any " +
            "suspected persons. For the Police Department to prosecute on the basis of a Police Report, the form must contain evidence which" +
            " illustrates the complete method of crime. In addition, the name of a prime suspect must be included. We will accept form resubmissions" +
            " at any time.\n\n- Chief of Police Craig Gregerson", "f"};
    final String[] incompleteFormResponse = {"The form you have submitted is incomplete. The evidence that was submitted is insufficient and thus" +
            " does not warrant the attention of the Police Department. If you would like to try again, please include more evidence of the" +
            " crime you are reporting. If the report contains sufficient evidence the Police Department will notify you of the new case status.\n\n" +
            "- Chief of Police Craig Gregerson", "i"};
    final Evidence[] requiredEvidence = {
            new Evidence("flooded with those links", "User Testimonies"),
            new Evidence("link spam", "User Testimonies"),
            new Evidence("links continued to circulate", "User Testimonies"),
            new Evidence("Tonem","Saudi Princes United Gold"),
            new Evidence("Tonem","CBD Solutions"),
            new Evidence("Tonem","Divyata Advising Group"),
            new Evidence("","Saudi Princes United Gold Sign Up"),
            new Evidence("", "CBD Solutions Sign Up"),
            new Evidence("", "Divyata Advising Group Sign Up"),
            new Evidence("Juliette Monet", "Heist of 1984")};


    public Police() {

    }

    public String[] submitForm(ArrayList<Evidence> evidence){
        if(evidence.size() >= requiredEvidence.length){
            boolean hasAllEvidence = true;
            for (Evidence reqEvidence : requiredEvidence) {
                boolean hasCurrentEvidence = false;
                for (Evidence inputEvidence : evidence) {
                    System.out.println("Checking: \n" + inputEvidence + "\n Against \n" + reqEvidence);
                    if (inputEvidence.getLocation().equals(reqEvidence.getLocation()) && inputEvidence.getText().contains(reqEvidence.getText())) {
                        hasCurrentEvidence = true;
                        System.out.println("Evidence Matches");
                        break;
                    }
                }
                if (!hasCurrentEvidence) {
                    hasAllEvidence = false;
                    break;
                }
            }
            if (hasAllEvidence) {
                System.out.println(successResponse);
                return successResponse;
            }
        }
        else if(evidence.size() < requiredEvidence.length){
            System.out.println(incompleteFormResponse);
            return incompleteFormResponse;
        }
        System.out.println(failResponse);
        return failResponse;
    }

    public Evidence[] getEvidenceP2(){
        return new Evidence[]{requiredEvidence[0], requiredEvidence[1], requiredEvidence[2]};
    }

    public Evidence[] getEvidenceP4(){
        return new Evidence[]{requiredEvidence[3], requiredEvidence[4], requiredEvidence[5]};
    }

    public Evidence[] getEvidenceP5(){
        return  new Evidence[]{requiredEvidence[6], requiredEvidence[7], requiredEvidence[8]};
    }

}
