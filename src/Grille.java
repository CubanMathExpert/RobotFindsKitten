import javax.sound.sampled.Line;
import javax.sound.sampled.Port;
import java.util.*;

public class Grille {
    //Arguments
    private Case[][] grille;
    private int totalLargeur, totalHauteur;

    //Constructor
    /**
     *
     * @param nbrPiecesX Nombre de "rooms" en x
     * @param nbrPiecesY Nombre de "rooms en y
     * @param largeurPiece Combien de char de largeur par piece
     * @param hauteurPiece Combien de char de longueur par piece
     * @param nbrNonKitten Combien d'éléments non-kitten par piece
     */
    public Grille(int nbrPiecesX, int nbrPiecesY, int largeurPiece, int hauteurPiece, int nbrNonKitten) {
        this.totalLargeur = largeurPiece*nbrPiecesX + nbrPiecesX + 1;
        this.totalHauteur = hauteurPiece*nbrPiecesY + nbrPiecesY + 1;
        this.grille = new Case[totalHauteur][totalLargeur];

        //Creation de la grille et placement des objets fixes
        placeDoorsRooms(largeurPiece,hauteurPiece);
        placeNonKitten(nbrNonKitten);
        placeKeys(largeurPiece,hauteurPiece);
        placeTeleporter();
        placeKitten();



    }

    //METHODS
    /**
     * Retourne une coordonnée de cellule qui ne contient rien
     * @return Point aleatoire vide dans la grille
     */
    public Point randomEmptyCell() {
        //Generate first random numbers
        Random randomLine, randomCol;
        randomCol = new Random();
        randomLine = new Random();
        int randLine,randCol;
        //If we do not land on null Case we keep trying new random values
        do {
            randLine = randomLine.nextInt(totalHauteur);
            randCol = randomCol.nextInt(totalLargeur);
        } while (grille[randLine][randCol] != null);
        Point emptyCell = new Point(randCol, randLine);
        return emptyCell;
    }

    /**
     * Cette methode place l'unique téléporteur quelque part sur la grille
     */
    public void placeKitten() {
        Point telePoint = randomEmptyCell();
        int teleLine,teleCol;
        teleLine = telePoint.getY();
        teleCol = telePoint.getX();
        grille[teleLine][teleCol] = new Kitten();
    }

    /**
     * Cette methode place l'unique téléporteur quelque part sur la grille
     */
    public void placeTeleporter() {
        Point telePoint = randomEmptyCell();
        int teleLine,teleCol;
        teleLine = telePoint.getY();
        teleCol = telePoint.getX();
        grille[teleLine][teleCol] = new Teleporteur();
    }

    /**
     *Cette methode s'occupe de la création des murs et des portes selon les
     * dimensions des pieces
     * @param largeurPiece Largeur de chaque piece
     * @param hauteurPiece Hauteur de chaque piece
     */
    public void placeDoorsRooms(int largeurPiece, int hauteurPiece) {
        for (int line = 0;line < totalHauteur;line++) {
            for (int col = 0;col < totalLargeur;col++) {

                //border walls
                if (line == 0 || line == totalHauteur-1 || col == 0 || col == totalLargeur-1)  {
                    grille[line][col] = new Mur();
                }
                //walls between all y-rooms
                else if (line%(hauteurPiece+1)==0 && line!=0 && line!=totalHauteur-1) {
                    grille[line][col] = new Mur();
                    //Ajouter les porte entre chaque salle verticallement
                    for (int d =largeurPiece/2+1;d < totalLargeur;d+=(largeurPiece+1)) {
                        grille[line][d] = new Porte();
                    }
                }
                //walls between all x-rooms
                else if (col%(largeurPiece+1)==0 && col!=0 && col!=totalLargeur-1) {
                    grille[line][col] = new Mur();
                    //Ajouter les portes entre chaque salle horizontallement
                    for (int d = hauteurPiece/2+1;d < totalHauteur;d+=(hauteurPiece+1)) {
                        grille[d][col] = new Porte();
                    }
                }

            }
        }
    }

    /**
     * Cette methode place les objets NonKitten sur la grille de jeu.
     * @param nbrNonKitten Nombre d'objets NonKitten qui seront sur notre grille
     */
    public void placeNonKitten(int nbrNonKitten) {
        int coll,linee;
        for (int k = 0;k < nbrNonKitten;k++) {
            do {
                Point randPoint = randomEmptyCell();
                coll = randPoint.getX();
                linee = randPoint.getY();
            } while (grille[linee-1][coll-1] != null);
            grille[linee-1][coll-1] = new NonKitten();
        }
    }

    /**
     * Cette methode places une clé dans chaque piece sur une Case aléatoire
     * @param hauteurPiece La hauteur des pieces
     * @param largeurPiece La largeur des pieces
     */
    public void placeKeys(int largeurPiece, int hauteurPiece) {
        Random randLine = new Random();
        Random randCol = new Random();
        int randomX,randomY;
        int keyLine, keyCol;

        for (int line = 1;line < totalHauteur;line+=hauteurPiece+1) {
            for (int col = 1;col < totalLargeur;col+=largeurPiece+1) {
                do {
                    randomX = randCol.nextInt(largeurPiece);
                    randomY = randLine.nextInt(hauteurPiece);
                    keyLine = randomY + line;
                    keyCol = randomX + col;
                } while (grille[keyLine][keyCol] != null);
                grille[keyLine][keyCol] = new Cle();
            }
        }
    }

    /**
     * Indique si c'est possible pour le Robot robot de marcher sur la cellule de coordonnee (x,y)
     * @param robot Robot object pour lequel nous allons tester
     * @param x nouvelle position x
     * @param y nouvelle position y
     * @return Retourne true s'il est possible de se deplacer a cette position
     */
    public boolean deplacementPossible(Robot robot, int x, int y) { //TODO
        return true;
    }

    /**
     * Affiche la grille dans la console a coups de System.out.println(...)
     * @param robot Robot que nous alons afficher
     */
    public void afficher(Robot robot) {
        String result = "";
        for (int line = 0;line < totalHauteur;line++) {
            for (int col = 0;col < totalLargeur;col++) {
                if (this.grille[line][col] != null) {
                    //System.out.println(grille[line][col].getRepresentation());
                    result+=grille[line][col].getRepresentation();
                }
                //Placer le robot
                else if (line == robot.getPosition().getY() && col == robot.getPosition().getX()) {
                    result += robot.getRepresentation();

                }
                //Les Cases vides on des null pointer
                else if (grille[line][col] == null){
                    //System.out.println(' ');
                    result+=' ';
                }
            }
            //Saut de ligne apres avoir print toute une ligne
            //System.out.println("\n");
            result+="\n";
        }
        System.out.println(result);
    }

    /**
     * Lance l'interaction entre le Robot robot et la case de la grille sur laquelle il se trouve
     * @param robot Robot qui fera l'interaction
     */
    public void interagir(Robot robot) {


    }
}
