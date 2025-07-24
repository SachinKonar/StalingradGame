import java.util.Random;

public class GameEngine {

    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public void startIntro() {
        clearScreen();
        displayFramedStalingradFact();

        slowPrint("Initializing game environment...", 50);
        sleep(1000);

        clearScreen();
        renderStalingradLogoInRed(); // ⬅ Corrected and colored logo

        sleep(1000);
        System.out.println("\n\n[ Press Enter to Begin ]");

        try {
            System.in.read();
        } catch (Exception ignored) {}

        clearScreen();
        System.out.println("Launching Game...");
        // You could now print: "Stalingrad, Winter 1942"
        sleep(1000);
        System.out.println("Stalingrad, Winter 1942\n");
    }

    private void renderStalingradLogoInRed() {
        fadeInText(ANSI_RED + "███████╗████████╗ █████╗ ██╗      ██╗███╗   ██╗ ██████╗  █████╗ ██████╗ " + ANSI_RESET, 60);
        fadeInText(ANSI_RED + "██╔════╝╚══██╔══╝██╔══██╗██║      ██║████╗  ██║██╔════╝ ██╔══██╗██╔══██╗" + ANSI_RESET, 60);
        fadeInText(ANSI_RED + "███████╗   ██║   ███████║██║      ██║██╔██╗ ██║██║  ███╗███████║██████╔╝" + ANSI_RESET, 60);
        fadeInText(ANSI_RED + "╚════██║   ██║   ██╔══██║██║      ██║██║╚██╗██║██║   ██║██╔══██║██╔═══╝ " + ANSI_RESET, 60);
        fadeInText(ANSI_RED + "███████║   ██║   ██║  ██║███████╗ ██║██║ ╚████║╚██████╔╝██║  ██║██║     " + ANSI_RESET, 60);
        fadeInText(ANSI_RED + "╚══════╝   ╚═╝   ╚═╝  ╚═╝╚══════╝ ╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚═╝  ╚═╝╚═╝     " + ANSI_RESET, 60);
    }

    private void slowPrint(String text, int delayMillis) {
        for (char ch : text.toCharArray()) {
            System.out.print(ch);
            sleep(delayMillis);
        }
        System.out.println();
    }

    private void fadeInText(String line, int stepDelay) {
        for (int i = 0; i <= line.length(); i++) {
            System.out.print("\r" + line.substring(0, i));
            sleep(stepDelay);
        }
        System.out.println();
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {}
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void displayFramedStalingradFact() {
        String[] facts = {
            "❄️ In the winter of 1942, some German soldiers resorted to cutting off their frostbitten fingers with knives—without anesthesia—to avoid infection or amputation by military medics.",
            "🩸 Entire buildings in Stalingrad were reduced to piles of frozen corpses. Some Soviet snipers used stacked bodies as cover to kill more invaders.",
            "🪖 Many German soldiers froze to death while still gripping their rifles — their fingers stiffened so hard they had to be broken off to retrieve weapons.",
            "⚠️ Rats and lice were so common in the trenches that some men reported feeling bugs crawling inside their ears while trying to sleep during artillery fire.",
            "🔥 Some German units were issued flame-throwers not to fight tanks — but to thaw out the bodies of their own dead before burial."
        };

        String[] preambles = {
            "🎙️ This is not just a game. This is a memory.\n\nWhat happened in Stalingrad was not 'strategy'. It was suffering.",
            "📜 The brutality of war doesn’t end with borders or time. It bleeds across generations. And it always begins with the dehumanization of the other.",
            "👁️ War does not care about your politics. It only consumes. And it always makes the innocent suffer — especially women and children.",
            "🧷 In every war — from Stalingrad to today — the worst violence is often hidden: the looting, the hunger, the silence of raped women, the shame of survivors.",
            "🕊️ This game shows pain not to glorify it, but to remind you: what is happening to civilians in places like Gaza — or Ukraine — is not new. And never okay."
        };

        Random random = new Random();
        String selectedFact = facts[random.nextInt(facts.length)];
        String selectedPreamble = preambles[random.nextInt(preambles.length)];

        clearScreen();
        System.out.println("\n🌍 WHY THIS GAME EXISTS\n");
        slowPrint(selectedPreamble, 40);
        sleep(2000);

        System.out.println("\n\n🕯️  HISTORICAL SNAPSHOT: THE BATTLE OF STALINGRAD  🕯️\n");
        slowPrint(selectedFact, 40);
        sleep(3000);
        System.out.println("\n");
    }
}
