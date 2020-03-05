package com.MagicWorld;
/**
 * classe Joueur
 *
 * @author Ludovic Gendre
 * @version 1.0
 */
public abstract class Joueur {

    protected String nom, cri, type;
    protected int niveau, vie, power, agilite, intelligence;
    protected Joueur adversaire;

    /**
     * Constructeur de Joueur
     *
     * @param numJoueur
     *          numéro du joueur
     * @param force
     *          force du joueur
     * @param agilite
     *          agilité du joueur
     * @param intelligence
     *          intelligence du joueur
     */
    Joueur(int numJoueur, int force, int agilite, int intelligence) {
        nom = "Joueur " + numJoueur;
        niveau = force + agilite + intelligence;
        this.power = force;
        this.agilite = agilite;
        this.intelligence = intelligence;
        vie = niveau * 5;
    }

    /**
     * début du tour du joueur. Vérifie qu'il a encore de la vie pour jouer sinon fin du jeu
     */
    public void activeJoueur() {
        int choix;
        if (vie > 0) {
            do {
                choix = com.MagicWorld.Main.demande(nom + " (" + vie + " vitalité), veuillez choisir votre action (1 : attaque Basique, 2 : MEGA POWER attaque !)", 1, 2);
                if (choix != 1 && choix != 2) System.out.println("Entrez une valeur correcte !");
            } while (choix != 1 && choix != 2);

            System.out.println(this.jouer(choix));
            if (vie <= 0) return;
            this.adversaire.activeJoueur();
        } else {
            System.out.println("Le " + nom + " à perdu !");
        }
    }

    /**
     * pour enlever des points de vie à l'adversaire
     * @param pointsAEnlever
     *          nombre de points de vie à enlever à l'adversaire
     */
    protected void enleverVie(int pointsAEnlever) {
        vie = vie - pointsAEnlever;
    }

    /**
     * En fonction du choix, effectue les actions propres à la classe du joueur
     *
     * @param choix
     *      choix de l'action
     * @see Mage#jouer(int)
     * @see Guerrier#jouer(int)
     * @see Rodeur#jouer(int)
     * @return résultat de l'attaque
     */
    protected abstract String jouer(int choix);

    /**
     * désigne l'adversaire du joueur
     * @param adversaire
     *      Joueur à désigner comme adversaire
     */
    public void setAdversaire(Joueur adversaire) {
        this.adversaire = adversaire;
    }

    /**
     * retourne la description du joueur
     * @return phrase de description
     */
    public String toString() {
        return nom + " : " + "\n" + "Classe : " + type + "\n" + "Niveau : " + niveau + "\n" +  "Point de vie : " + vie + "\n" + "Force : " + power +"\n" + "Intelligence :" + intelligence + "\n" + "Agilité : " + agilite + "\n";
    }

}


