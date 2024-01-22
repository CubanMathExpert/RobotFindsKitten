public class Mur extends Case {
    //Constructor
    public Mur() {
        this.representation = '%';
    }

    //??????
    @Override
    public boolean interactionPossible(Robot robot) {
        return false;
    }

    @Override
    public void interagir(Robot robot) {
        System.out.println("Maybe you're blind.");
    }
}
