class RacingDogBot extends DogBot {
    static int rcount = 0;

    public RacingDogBot(int h, int t, String nm) {
        super(h, t, "Racer " + nm);
    }

    public RacingDogBot(int h, int t) {
        super(h, t, "RacingDogBot" + (++rcount));
    }

    public boolean race() {
        if (tired < 5) {
            hungry += 2;
            tired += 5;
            return true;
        } else
            return false;
    }

    public void rest() {
        hungry += 2;
        tired -= 3;
    }
}