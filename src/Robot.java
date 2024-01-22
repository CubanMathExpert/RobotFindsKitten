public class Robot {
    //Arguments
    private String robotName;
    private Point robotPosition;
    private int keys;
    private boolean hasTeleport;
    private char representation;

    //Constructor
    public Robot(String robotName, Point robotPosition) {
        this.robotName = robotName;
        this.robotPosition = robotPosition;
        this.representation = '#';
    }

    //METHODS
    /**
     * Cherche la représentation du robot sur la grille
     * @return Représentation du robot
     */
    public char getRepresentation() {
        return this.representation;
    }

    //GETTER SETTER POSITION
    /**
     * Retourne la position du Robot
     * @return Point object qui contient (x,y)
     */
    public Point getPosition() {
        return this.robotPosition;
    }
    /**
     * Set nouvelle position (x,y)
     * @param x Nouvelle position x
     * @param y Nouvelle position y
     */
    public void setPosition(int x, int y) {
        Point nextPosition = new Point(x,y);
        this.robotPosition = nextPosition;
    }

    //GETTER SETTER HASTELEPORT
    /**
     * Donne valeur vrai/faux si le robot a le teleporteur sur lui
     * @return true/false
     */
    public  boolean getHasTeleport() {
        return this.hasTeleport;
    }
    /**
     * Attribue nouvelle valeur a variable hasTeleport
     * @param value Nouvelle valeur de hasTeleport
     */
    public void setHasTeleport(boolean value) {
        this.hasTeleport = value;
    }

    //GETTER SETTER KEYS
    /**
     * Set nouvelle valeur pour la quantite de cles du robot
     * @param value nouvelle quantité de cles du robot
     */
    public void setKeysValue(int value) {
        this.keys = value;
    }

    /**
     * Va cherche le nombre de cles du robot
     * @return La quantite de cles du robot
     */
    public int getKeysValue() {
        return this.keys;
    }

    public void afficher() {
        System.out.println(this.representation);
    }
}
