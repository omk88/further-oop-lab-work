import java.util.*;

class RunDogBots5
{
// Demonstrates generalisation of code

    public static void main(String[] args)
    {
        System.out.println();
        ArrayList<DogBot> dogbots = new ArrayList<DogBot>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a seed: ");
        int seed = input.nextInt();
        Random rand = new Random(seed);
        System.out.print("Enter the number of DogBots you wish to create: ");
        int num = input.nextInt();
        System.out.println();
        for(int i=0; i<num; i++)
        {
            int h = rand.nextInt(9)+1;
            int t = rand.nextInt(9)+1;
            if(rand.nextDouble()<0.2)
                dogbots.add(new RacingDogBot(h,t));
            else
                dogbots.add(new DogBot(h,t));
        }
        ArrayList<DogBot> biggest = (ArrayList<DogBot>) Biggest.listBiggest(dogbots, dogbots.get(0).compare());
        if(biggest.size()==1)
            System.out.println("Most tired DogBot is: "+biggest.get(0));
        else
        {
            System.out.println("Equally most tired DogBots are:  ");
            for(int i=0; i<biggest.size(); i++)
                System.out.println("   "+biggest.get(i));
        }
        System.out.println();
        for(int i=0; i<dogbots.size(); i++)
        {
            DogBot d=dogbots.get(i);
            d.play();
            d.rest();
        }
        System.out.println("After each DogBot plays and rests ...");
        biggest = (ArrayList<DogBot>) Biggest.listBiggest(dogbots, dogbots.get(0).compare());
        if(biggest.size()==1)
            System.out.println("Most tired DogBot is: "+biggest.get(0));
        else
        {
            System.out.println("Equally most tired DogBots are:  ");
            for(int i=0; i<biggest.size(); i++)
                System.out.println("   "+biggest.get(i));
        }
        System.out.println();
    }
}