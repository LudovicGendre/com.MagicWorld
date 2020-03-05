package com.MagicWorld;

/**
 * Classe des joueurs de type Guerrier
 *
 * @author Ludovic Gendre
 * @version 1.0
 */
public class Guerrier extends Joueur {

    /**
     * Constructeur du joueur Guerrier
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
    protected Guerrier(int numJoueur, int force, int agilite, int intelligence) {
        super(numJoueur, force, agilite, intelligence);
        type = "Guerrier ";
        cri = "Je vais t'étripper ! ";
    }

    /**
     * En fonction du choix, effectue les actions propres à la classe du joueur Guerrier
     * Coup d'épée ou Coup de rage
     *
     * @param choix
     *      choix de l'action
     * @see Mage#jouer(int)
     * @see Joueur#jouer(int)
     * @see Rodeur#jouer(int)
     * @return phrase de l'action
     */
    @Override
    protected String jouer(int choix) {
        String phrase = "";
        switch (choix) {
            case 1:
                adversaire.enleverVie(power);
                phrase = phrase + nom + " utilise Coup d'épée et inflige " + power + " de dégâts\n";
                break;
            case 2:
                adversaire.enleverVie((power * 2));
                vie = vie - power / 2;
                phrase = phrase + nom + " utilise Coup de rage, inflige " + (power * 2) + " de dégâts et perd " + (power / 2) + " de vitalité\n";
                break;
            default:
                break;
        }
        if (vie > 0) {
            return phrase;
        } else {
            return "Le " + nom + " n'a plus de vie, il a perdu !";
        }

    }
}