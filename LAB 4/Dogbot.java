import java.util.Comparator;

class DogBot implements Comparable<DogBot>
{
    protected int hungry,tired;
    private String name;
    private static int count=0;

    public DogBot(int h,int t,String nm)
    {
        hungry=h;
        tired=t;
        name=nm;
    }

    public DogBot(int h, int n)
    {
        this(h,n,"DogBot"+(++count));
    }

    public boolean eat()
    {
        if(hungry>6)
        {
            hungry-=3;
            return true;
        }
        else
            return false;
    }

    public void rest()
    {
        hungry++;
        tired-=2;
    }

    public void play()
    {
        hungry+=2;
        tired+=3;
    }

    public String noise()
    {
        if(hungry>8&&tired<11)
            return "whine ";
        else if(tired>7&&tired>hungry)
            return "snore ";
        else
            return "woof ";
    }

    public String toString()
    {
        return name;
    }

    public int compareTo(DogBot that)
    {
        return this.hungry-that.hungry;
    }

    public static Comparator<DogBot> compare() {
        return new Comparator<DogBot>() {
            @Override
            public int compare(DogBot o1, DogBot o2) {
                return o2.compareTo(o1);
            }
        };
    }
}