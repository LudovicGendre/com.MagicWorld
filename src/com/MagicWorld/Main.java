package com.MagicWorld;

import javax.swing.*;
import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * classe principale du jeu MagiWord
 *
 * @author Ludovic Gendre
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        /**
         * @JFrame: Fenetre Windows
         * JFrame fenetre = new JFrame();

        //Définit un titre pour notre fenêtre
        fenetre.setTitle("Magic World");
        //Définit sa taille : 400 pixels de large et 100 pixels de haut
        fenetre.setSize(1000, 600);
        //Nous demandons maintenant à notre objet de se positionner au centre
        fenetre.setLocationRelativeTo(null);
        //Termine le processus lorsqu'on clique sur la croix rouge
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Et enfin, la rendre visible
        fenetre.setVisible(true);
         */
        int numJoueur = 1;
        Joueur joueur1 = creerJoueur(numJoueur);// création du premier joueur
        System.out.println(joueur1.toString());
        numJoueur++;
        Joueur joueur2 = creerJoueur(numJoueur);//création du second joueur
        System.out.println(joueur2.toString());
        joueur1.setAdversaire(joueur2);
        joueur2.setAdversaire(joueur1);
        joueur1.activeJoueur();//début du jeu

    }


    /**
     * Retourne un joueur en le créant grace aux caractéristiques rentrés au clavier
     *
     * @param numJoueur numéro du joueur
     * @return Joueur créé grace au caractéristiques données au clavier
     */
    private static Joueur creerJoueur(int numJoueur) {
        Joueur j;
        int type, niveau, force, agilite, intelligence;
        System.out.println("===============================================================================");
        System.out.println("                                 MAGIC WORLD");
        System.out.println("===============================================================================");
        System.out.println("\nCréation du personnage du Joueur " + numJoueur);
        type = demande("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)", 1, 3);
        do {
            niveau = demande("Niveau du personnage ?", 1);
            force = demande("Force du personnage ?", 0);
            agilite = demande("Agilité du personnage ?", 0);
            intelligence = demande("Intelligence du personnage ?", 0);
            if (force + agilite + intelligence != niveau) {
                System.out.println("Attention le total force + agilité + intelligence doit être égal au niveau du joueur.");
            }
        } while (force + agilite + intelligence != niveau);
        switch (type) {
            case 1:
                j = new Guerrier(numJoueur, force, agilite, intelligence);
                break;
            case 2:
                j = new Rodeur(numJoueur, force, agilite, intelligence);
                break;
            case 3:
                j = new Mage(numJoueur, force, agilite, intelligence);
                break;
            default:
                j = new Mage(numJoueur, force, agilite, intelligence);
                break;
        }
        return j;
    }


    /**
     * Effectue une demande et retourne la réponse numérique
     *
     * @param str la demande à faire
     * @param min valeur minimale du choix
     * @return le choix fait par l'utilisateur
     */
    public static int demande(String str, int min) {
        int choix;
        boolean choixCorrect;
        Scanner sc = new Scanner(System.in);
        do {
            choix = 0;
            System.out.println(str);
            try {
                choixCorrect = true;
                choix = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next();
                choixCorrect = false;
            }
            if (choixCorrect) {
                if (!(choix >= min)) choixCorrect = false;
            }
        } while (!choixCorrect);
        return choix;
    }


    /**
     * Effectue une demande et retourne la réponse
     *
     * @param str la demande à faire
     * @param min valeur minimale du choix
     * @param max valeur maximale du choix
     * @return le choix fait par l'utilisateur
     */
    public static int demande(String str, int min, int max) {
        int choix;
        do {
            choix = demande(str, min);
        } while (choix > max);
        return choix;
    }
}

    /**
     * Class fenetre Window
     *
    public class Panneau extends JPanel {
        public void paintComponent(Graphics g){
            g.drawString("Erreur Système, contactez un administrateur ", 10, 20);
        }
    }
}
     */