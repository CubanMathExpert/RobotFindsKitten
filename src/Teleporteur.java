public class Teleporteur extends Case {
    //Constructor
    public Teleporteur() {
        this.representation = getRandomSymbole();
    }

    /**
     * Verifie si l'interaction est possible entre la robot et le Case
     * @param robot Le robot qui interagit avec la case
     * @return
     */
    @Override
    public boolean interactionPossible(Robot robot) { //TODO
        return true;
    }

    /**
     * Interagit avec la Case
     * @param robot Le robot qui fera l'interaction
     */
    @Override
    public void interagir(Robot robot) { //TODO

    }
}
