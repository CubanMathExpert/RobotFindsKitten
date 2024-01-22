public class Porte extends Case {

    private boolean isOpen;
    //Constructor
    public Porte() {
        this.representation = '!';
        this.isOpen = false;
    }

    /**
     * Check si le robot peut interagir avec une porte. Celui-ci
     * peut seulement le faire s'il est en possession d'une cle.
     * @param robot Le robot qui interagirait avec la case
     * @return false si le robot a 0 cles, sinon retourne true.
     */
    @Override
    public boolean interactionPossible(Robot robot) {
        if (robot.getKeysValue()!=0) {
            return true;
        }
        return false;
    }

    @Override
    public void interagir(Robot robot) {

    }

    /**
     * Method qui va rendre la porte "ouverte" une fois que celle-ci
     * est débaré par le joueur. (Elle le restera pour le reste de la partie)
     */
    public void openDoor() {
        this.isOpen = true;
    }
}
