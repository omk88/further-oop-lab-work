import java.util.ArrayList;

public class Ex6 {
    public static String peopleClearance (ArrayList<Clearance> clearances) {
        String txt = "";
        for (int i=0; i<clearances.size(); i++) {
            try {
                if (clearances.get(i) instanceof HighClearance) {
                    txt = txt + " " + clearances.get(i);
                }
            } catch (NullPointerException e) { return ("Error"); }
        }
        return txt;
    }
}
