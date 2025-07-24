import java.util.*;

public class StalingradGame {

    static final List<String> VALID_NAMES = Arrays.asList("Conrad", "Erich", "Lubeck", "Werner", "Lieber");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your soldier's name (type one): Conrad, Erich, Lubeck, Werner, Lieber");

        String name;
        while (true) {
            name = scanner.nextLine().trim();
            if (VALID_NAMES.contains(capitalize(name))) break;
            System.out.println("Invalid name. Choose again:");
        }

        System.out.println("\nChoose your game mode:");
        System.out.println("1. ❄️ Frostbite Mode");
        System.out.println("   - Graphic content: Character has no fingers, bone exposed, blood visible");
        System.out.println("   - Faster movement");
        System.out.println("   - Access to better weapons");
        System.out.println("\n2. 🪖 Regular Mode");
        System.out.println("   - Slower movement");
        System.out.println("   - Limited weapons");
        System.out.println("   - Full-bodied character, no graphic injury visuals");
        System.out.println("\nEnter your choice (1 or 2):");

        int modeChoice;
        while (true) {
            try {
                modeChoice = Integer.parseInt(scanner.nextLine().trim());
                if (modeChoice == 1 || modeChoice == 2) break;
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid input. Enter 1 or 2:");
        }

        boolean frostbiteMode = modeChoice == 1;
        renderModeIntro(frostbiteMode);

        System.out.println("\nYou may choose winter accessories: gloves, scarf, hat, boots, etc.");
        System.out.println("Each accessory adds comfort... but costs you 10 health points.");
        System.out.println("You start with 100 health. Max accessories allowed: 9");
        System.out.print("How many accessories do you want? ");

        int accessories;
        while (true) {
            try {
                accessories = Integer.parseInt(scanner.nextLine().trim());
                if (accessories >= 0 && accessories <= 9) break;
            } catch (NumberFormatException ignored) {}
            System.out.println("Invalid input. Enter a number from 0 to 9:");
        }

        int health = 100 - (accessories * 10);
        Player player = new Player(capitalize(name), frostbiteMode, accessories, health);

        System.out.println("\n==== CHARACTER LOADED ====");
        System.out.println("Name: " + player.name);
        System.out.println("Mode: " + (frostbiteMode ? "Frostbite" : "Regular"));
        System.out.println("Accessories: " + player.accessories);
        System.out.println("Health: " + player.health + " HP");
        System.out.println("==========================");
    }

    static void renderModeIntro(boolean frostbite) {
        if (frostbite) {
            System.out.println("\n⚠️ WARNING: GRAPHIC CONTENT ⚠️");
            sleep(500);
            System.out.println("LOADING FROSTBITE MODE...");
            sleep(1000);
            System.out.println("\n\n      ☠️ CHARACTER IMAGE ☠️");
            System.out.println("    ┌──────────────┐");
            System.out.println("    │  ☃  - No Gloves  │");
            System.out.println("    │  ☠  Fingers Missing │");
            System.out.println("    │  🩸 Bone Exposed     │");
            System.out.println("    └──────────────┘");
            System.out.println("   Blood drips into the snow...");
        } else {
            System.out.println("\nLOADING REGULAR MODE...");
            sleep(1000);
            System.out.println("\n\n     🪖 CHARACTER IMAGE");
            System.out.println("    ┌──────────────┐");
            System.out.println("    │  🧍 Full Body       │");
            System.out.println("    │  🧤 Gloves on       │");
            System.out.println("    │  🪖 Helmet & Boots │");
            System.out.println("    └──────────────┘");
            System.out.println("   Cold, tired, but intact.");
        }
    }

    static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }

    static String capitalize(String name) {
        return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
    }
}

class Player {
    String name;
    boolean frostbiteMode;
    int accessories;
    int health;

    Player(String name, boolean frostbiteMode, int accessories, int health) {
        this.name = name;
        this.frostbiteMode = frostbiteMode;
        this.accessories = accessories;
        this.health = health;
    }
}
