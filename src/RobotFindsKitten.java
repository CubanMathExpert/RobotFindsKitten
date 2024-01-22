import java.util.Scanner;

public class RobotFindsKitten {
    public static void main(String[] args) {

        Grille testGrille = new Grille(5,2,11,5,30);
        Robot testRobot = new Robot("Joe",testGrille.randomEmptyCell());

        //Welcome message
        System.out.println("\tBienvenue dans RobotFindsKitten\n");
        System.out.println("Super Drungeon Master 3000 Ultra Turbo Edition !\n");

        //Get input in scanner to change position of the robot
        Scanner input = new Scanner(System.in);
        while (true) {
            testGrille.afficher(testRobot);
            String nextIn = input.nextLine();
            System.out.println(nextIn);
        }


    }
}
