package finalRobot_Robin_Bodineau;


/**
 * La classe abstraite RobotG représente un robot dans un environnement 2D.
 *
 * @author Group11
 * @version 31/10/23
 */
abstract class RobotG {
    // Position du robot
    private int x;
    private int y;

    // Direction du robot 
    private int direction;
    private CanvasRobot virtualBox;

    // Couleur du robot 
    private Colour colour;
    private String name;

    /**
     * Constructeur de la classe RobotG.
     *
     * @param nameRobot Le nom du robot.
     * @param dir La direction initiale du robot (0, 1, 2, ou 3).
     * @param x La position initiale en abscisse (x).
     * @param y La position initiale en ordonnée (y).
     */
    public RobotG(String nameRobot, int dir, int x, int y) {
        this.name = nameRobot;
        this.direction = dir;
        this.x = x;
        this.y = y;
        this.virtualBox = new CanvasRobot("RED");
        virtualBox.drawRobot(x, y);
    }

    /**
     * Accesseur de la direction du robot.
     *
     * @return La valeur de la direction (0, 1, 2, ou 3).
     */
    public int getDirection() {
        return direction;
    }

    /**
     * Modifie la direction du robot.
     *
     * @param newDirection La nouvelle direction du robot.
     */
    public void setDirection(int newDirection) {
        direction = newDirection;
    }

    /**
     * Fait avancer le robot dans sa direction actuelle.
     */
    public void avancer() {
        if (deplacement() == false) {
            switch (direction) {
                case 0: x++; break;
                case 1: y++; break;
                case 2: x--; break;
                case 3: y--;
            }
        } else {
            switch (direction) {
                case 0: x = 0; break;
                case 1: y = 0; break;
                case 2: x = 11; break;
                case 3: y = 11;
            }
        }
        virtualBox.drawRobot(x, y);
    }

    /**
     * La méthode movePossibleCanva permet de vérifier si un déplacement dans une direction donnée est possible sur le canevas.
     *
     * @param direction La direction du déplacement (0 pour droite, 1 pour bas, 2 pour gauche, 3 pour haut).
     * @return true si le déplacement est possible dans la direction donnée, sinon false.
     */
    public boolean movePossibleCanva(int direction) {
        if (direction == 1) {
            if (y++ <= 11) {
                return true;
            }
        } else if (direction == 3) {
        if (y-- >= 0) {
            return true;
        }
        } else if (direction == 0) {
        if ((x++ <= 11)) {
            return true;
        } else return false;
        } else if (direction == 2) {
        if (x-- >= 0) {
            return true;
        }
        }
        return false;
    }

    /**
     * La méthode getNextXPosition calcule la prochaine position en abscisse (x) en fonction de la direction du robot.
     *
     * @param dep Le nombre de pas pour le déplacement.
     * @return La prochaine position en abscisse (x) après le déplacement.
     */
    public int getNextXPosition(int dep) {
        if (direction == 3) {
            return x;
        } else if (direction == 1) {
            return x;
        } else if (direction == 0) {
            return (x + dep);
        } else {
            return (x - dep);
        }
    }

    /**
     * La méthode getNextYPosition calcule la prochaine position en ordonnée (y) en fonction de la direction du robot.
     *
     * @param dep Le nombre de pas pour le déplacement.
     * @return La prochaine position en ordonnée (y) après le déplacement.
     */
    public int getNextYPosition(int dep) {
        if (direction == 2) {
            return y;
         } else if (direction == 0) {
            return y;
        } else if (direction == 1) {
            return (y + dep);
        } else {
            return (y - dep);
        }
    }

    /**
     * La méthode deplacement vérifie si le déplacement d'une unité dans la direction actuelle est possible en tenant compte des limites du canevas.
     *
     * @return true si le déplacement d'une unité est impossible (hors du canevas), sinon false.
    */
    public boolean deplacement() {
        if (getNextXPosition(1) < 0 || getNextXPosition(1) > 11 || getNextYPosition(1) < 0 || getNextYPosition(1) > 11) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Fait avancer le robot un certain nombre de fois pour tester.
     */
    public void testAvancer() {
        for (int i = 0; i < 100; i++) {
            avancer();
            Canvas.wait(200);
        }
    }

    /**
     * Récupère la position en abscisse (x) du robot.
     *
     * @return La position en abscisse.
     */
    public int getPositionX() {
        return x;
    }

    /**
     * Récupère la position en ordonnée (y) du robot.
     *
     * @return La position en ordonnée.
     */
    public int getPositionY() {
        return y;
    }

    /**
     * Définit la couleur du robot.
     *
     * @param color La couleur du robot (par nom : "RED", "GREEN", etc.).
     */
    public void setColour(String color) {
        switch (color.toUpperCase()) {
            case "RED": colour = Colour.RED; break;
            case "BLACK": colour = Colour.BLACK; break;
            case "BLUE": colour = Colour.BLUE; break;
            case "YELLOW": colour = Colour.YELLOW; break;
            case "GREEN": colour = Colour.GREEN; break;
            case "MAGENTA": colour = Colour.MAGENTA; break;
            case "WHITE": colour = Colour.WHITE; break;
            case "PURPLE": colour = Colour.RED; break;
            default: colour = Colour.BLACK; break;
        }
    }

    /**
     * Récupère la couleur du robot.
     *
     * @return La couleur du robot.
     */
    public String getColor() {
        return colour.toString();
    }
}


