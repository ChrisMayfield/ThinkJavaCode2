/**
 * Application that runs a cellular automaton.
 */
public class Main2 {

    /**
     * Creates an automaton and runs it.
     * 
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        String title = "Langton's Ant";
        Automaton game = new Langton(61, 61);
        Main.runSimulation(title, game, 1);
    }

}
