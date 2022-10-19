public class Clearance
{
    String name;
    String SECRET="some secret data";
    boolean highLevel;
    private boolean authorized;
    public Clearance(String pname, boolean l)
    {
        highLevel = l;
        if (highLevel) authorized=true; else authorized=false;
    }
    public boolean isHighLevel(){
        return highLevel;
    }
    public boolean isAuthorized(){
        return authorized;
    }
    public String getName(){
        return name;
    }
    public String getSecret(){
        if (authorized) return SECRET; else return "non-authorized";
    }
    public void setSecret(String sec){
        if (authorized) SECRET=sec;
    }

    public interface SecretAct{
        public String noDisclosure();
    }
    public interface National{
        public String passport();
    }
}

class LowClearance extends Clearance {

    public LowClearance(String pname) {
        super(pname, false);
        super.name = pname;
    }
}

class HighClearance extends Clearance {

    private String logs = "the secret so far";

    public HighClearance(String pname) {
        super(pname, true);
        super.name = pname;
    }

    public void setSecret(String sec) {
        super.setSecret(sec);
        logs = logs+" "+sec;
    }
}

class TopClearance extends Clearance implements Clearance.National, Clearance.SecretAct {
    public TopClearance(String pname) {
        super(pname, true);
        super.name = pname;
    }

    @Override
    public String noDisclosure() {
        return "*".repeat(SECRET.length());
    }

    @Override
    public String passport() {
        return (super.getName()).substring(0,2);
    }
}

interface ClearanceInterface {
    public boolean isHighLevel();

    public boolean isAuthorized();

    public String getName();

    public String getSecret();

    public void setSecret(String sec);
}

class HighClear implements ClearanceInterface {

    private String name;
    private String SECRET="some secret data";
    private boolean highLevel;
    private boolean authorized;

    public HighClear (String pname, boolean l) {
        highLevel = l;
        if (highLevel) authorized=true; else authorized=false;
    }

    @Override
    public boolean isHighLevel() {
        return highLevel;
    }

    @Override
    public boolean isAuthorized() {
        return authorized;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSecret() {
        if (authorized) return SECRET; else return "non-authorized";
    }

    @Override
    public void setSecret(String sec) {
        if (authorized) SECRET=sec;
    }
}

