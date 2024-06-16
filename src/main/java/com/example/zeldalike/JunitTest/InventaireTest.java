package com.example.zeldalike.JunitTest;
import com.example.zeldalike.modele.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
public class InventaireTest {

    @Test
    public void testGetlistePotion(){
        Position p = new Position(0,0);
        Environnement env = new Environnement(100,100);
        Joueur joueur = new Joueur(10,new Position(0,0),env,env.getTerrain());
        Inventaire sac = new Inventaire(joueur);

        PotionVitale cle1 = new PotionVitale(p);
        PotionVitale cle2 = new PotionVitale(p);
        PotionVitale cle3 = new PotionVitale(p);

        joueur.getSac().ajoutInventaire(cle1);
        joueur.getSac().ajoutInventaire(cle2);

        ArrayList<ObjetRecuperables> listePotion = joueur.getSac().getListePotion();

        assertEquals(2,listePotion.size());
        assertTrue(listePotion.contains(cle1));
        assertTrue(listePotion.contains(cle2));
        assertFalse(listePotion.contains(cle3));


    }


}
