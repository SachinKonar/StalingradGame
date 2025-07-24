public class Soldier {
    private boolean frostbiteMode;
    private int speed;
    private int weaponLevel;
    private boolean hasHorse;
    private String[] birthdayWishes;

    public Soldier(boolean frostbiteMode) {
        this.frostbiteMode = frostbiteMode;
        this.speed = frostbiteMode ? 8 : 4;
        this.weaponLevel = frostbiteMode ? 3 : 1;
        this.hasHorse = false;
    }

    public void rankUp(String newRank) {
        if (newRank.equals("Marshal")) {
            hasHorse = true;
        }
    }

    public void setBirthdayWishes(String[] wishes) {
        this.birthdayWishes = wishes;
    }

    public boolean isMaterialistic() {
        for (String wish : birthdayWishes) {
            if (wish.matches("(?i).*(watch|car|gold|money|cigar|weapon|gun).*")) {
                return true;
            }
        }
        return false;
    }
}
