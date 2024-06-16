package com.example.zeldalike.JunitTest;

import com.example.zeldalike.modele.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PersonnageTest {
    @Test
    public final void distanceEntreDeuxPersonnages() {
        Environnement env = new Environnement(100, 100);
        Citron citron = new Citron(new Position(0, 0), env);
        Joueur joueur = new Joueur(10, new Position(0, 0), env, env.getTerrain());

        Personnage personnage = new Citron(new Position(0, 0), env);
        // Test de la distance lorsque les personnages sont au même endroit
        int distance = personnage.distanceEntreDeuxPersonnages(citron, joueur);
        assertEquals(0, distance);


        // Test de la distance avec des coordonnées négatives
        Joueur joueurNegatif = new Joueur(10, new Position(-3, -4), env, env.getTerrain());
        distance = personnage.distanceEntreDeuxPersonnages(citron, joueurNegatif);
        assertEquals(5, distance);
    }

    @Test
    public final void testGetEnnemisProches() {
        Environnement env = new Environnement(100, 100);
        Joueur joueur = new Joueur(10, new Position(5, 5), env, env.getTerrain());

        // Créer des ennemis
        Citron ennemi1 = new Citron(new Position(10, 10), env); // distance = 7
        Citron ennemi2 = new Citron(new Position(30, 40), env); // distance = 50
        Citron ennemi3 = new Citron(new Position(60, 60), env); // distance = 77
        Citron ennemi4 = new Citron(new Position(20, 20), env); // distance = 21

        env.getEnnemis().add(ennemi1);
        env.getEnnemis().add(ennemi2);
        env.getEnnemis().add(ennemi3);
        env.getEnnemis().add(ennemi4);

        ArrayList<Personnage> ennemisProches = joueur.getEnnemisProches();

        //Assertions
        assertTrue(ennemisProches.contains(ennemi1));
        assertTrue(ennemisProches.contains(ennemi2));
        assertFalse(ennemisProches.contains(ennemi3));
        assertTrue(ennemisProches.contains(ennemi4));
        assertEquals(3, ennemisProches.size());
    }

    @Test
    public final void testGetBouds() {
        Environnement env = new Environnement(100, 100);
        Joueur joueur = new Joueur(10, new Position(5, 5), env, env.getTerrain());
        Citron ennemi1 = new Citron(new Position(5, 5), env);
        Citron ennemi2 = new Citron(new Position(30, 40), env);

        assertTrue(joueur.collidesWith(ennemi1));
        assertFalse(joueur.collidesWith(ennemi2));
    }


}