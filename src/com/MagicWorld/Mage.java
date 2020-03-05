package com.MagicWorld;


/**
 * Classe des joueurs de type Mage
 *
 * @author Ludovic Gendre
 * @version 1.0
 */
public class Mage extends Joueur {

    /**
     * Vie maximale du joueur mage, donnée lors de la création du joueur
     */
    private int vieMax;

    /**
     * Constructeur du joueur Mage
     *
     * @param numJoueur    numéro du joueur
     * @param force        force du joueur
     * @param agilite      agilité du joueur
     * @param intelligence intelligence du joueur
     */
    public Mage(int numJoueur, int force, int agilite, int intelligence) {
        super(numJoueur, force, agilite, intelligence);
        vieMax = vie;
        type = "Mage ";
        cri = "Tu es un sorcier Harry ! ";
    }

    /**
     * En fonction du choix, effectue les actions propres à la classe du joueur Mage
     * boule de feu ou Soin
     *
     * @param choix choix de l'action
     * @see Rodeur#jouer(int)
     * @see Joueur#jouer(int)
     * @see Guerrier#jouer(int)
     * @return phrase de l'action
     */
    @Override
    protected String jouer(int choix) {
        String phrase = "";
        switch (choix) {
            case 1:
                adversaire.enleverVie(intelligence);
                phrase = phrase + nom + " utilise boule de feu et inflige " + intelligence + " de dégâts\n";
                break;
            case 2:
                //Soin
                phrase = phrase + nom + " utilise Soin et gagne ";
                if ((intelligence * 2) + vie > vieMax) {
                    phrase = phrase + (vieMax - vie) + " de vitalité\n";
                    vie = vieMax;
                } else {
                    phrase = phrase + (intelligence * 2) + " de vitalité\n";
                    vie = vie + (intelligence * 2);
                }
                break;
            default:
                break;
        }
        return phrase;
    }
}
