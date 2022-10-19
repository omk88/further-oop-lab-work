import java.util.*;

public class Ex8 {
    public static ArrayList<Clearance> raiseClearance(ArrayList<Clearance> clearances, String pname) {
        ArrayList<Clearance> arrlst = new ArrayList<>();
        for (int i=0; i<clearances.size(); i++) {
            if ((clearances.get(i).name == pname) && !(clearances.get(i).highLevel)) {
                HighClearance newClearance = new HighClearance(pname);
                arrlst.add(newClearance);
            } else arrlst.add(clearances.get(i));
        }
        return arrlst;
    }
}