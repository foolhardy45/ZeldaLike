package com.example.zeldalike.modele;

import com.example.zeldalike.modele.Arme.Arme;
import com.example.zeldalike.modele.Arme.Poing;
import com.example.zeldalike.modele.Arme.gun.Gun;
import com.example.zeldalike.modele.Arme.gun.Munition;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventaire {
    private final Joueur j;
    private ArrayList<ObjetRecuperables> articles;
    private ArrayList<Arme> armespossedees;


    public Inventaire(Joueur j) {
        this.j = j;
        this.articles = new ArrayList<>();
        this.armespossedees = new ArrayList<>();
        this.articles.addFirst(new Munition(new Position(0, 0)));
    }


    public ArrayList<ObjetRecuperables> getListePotion() {
        ArrayList<ObjetRecuperables> liste = new ArrayList<>();
        for (ObjetRecuperables obj : this.articles) {
            if (obj instanceof PotionVitale) {
                liste.add(obj);
            }
        }
        return liste;
    }

    public ArrayList<ObjetRecuperables> getListeCle() {
        ArrayList<ObjetRecuperables> liste = new ArrayList<>();
        for (ObjetRecuperables obj : this.articles) {
            if (obj instanceof Cle) {
                liste.add(obj);
            }
        }
        return liste;
    }

    public int getQuantiteMunition() {
        int quantite = 0;
        for (ObjetRecuperables obj : this.articles) {
            if (obj instanceof Munition) {
                quantite++;
            }
        }
        return quantite - 1;
    }

    public ObjetRecuperables getUneMunition() {
        boolean obtenu = false;
        ObjetRecuperables munition = null;
        int i = 0;
        while (!obtenu && i < this.articles.size()) {
            munition = this.articles.get(i);
            if (munition instanceof Munition) {
                obtenu = true;
            }
            i++;
        }
        return munition;
    }


    public ArrayList<Munition> getListeMunition() {
        ArrayList<Munition> liste = new ArrayList<>();
        for (int i = 1; i < this.articles.size(); i++) {
            //for (ObjetRecuperables obj : this.articles) {
            ObjetRecuperables obj = this.articles.get(i);
            if (obj instanceof Munition) {
                liste.add((Munition) obj);
            }
        }
        return liste;
    }

    public ObjetRecuperables getUneCle() {
        ArrayList<ObjetRecuperables> liste = getListeCle();
        if (!liste.isEmpty()) {
            return liste.get(0);
        }
        return null;
    }


    public ObjetRecuperables getUnePotion() {
        ArrayList<ObjetRecuperables> liste = getListePotion();
        if (!liste.isEmpty()) {
            return liste.get(0);
        }
        return null;
    }

    public int getQuantitePotion() {
        return getListePotion().size();
    }

    public int getQuantiteCle() {
        return getListeCle().size();
    }

    public HashMap<ObjetRecuperables, Integer> getQuantiteTout() {
        HashMap<ObjetRecuperables, Integer> quantites = new HashMap<>();
        ObjetRecuperables objet;
        if (getQuantitePotion() > 0) {
            quantites.put(getUnePotion(), getQuantitePotion());
        }
        if (getQuantiteCle() > 0) {
            quantites.put(getUneCle(), getQuantiteCle());
        }
        if (getQuantiteMunition() > 0) {
            quantites.put(getUneMunition(), getQuantiteMunition());
        }
        return quantites;
    }


 /*   public int indiceInventaire(ObjetRecuperables obj) {
        boolean present = false;
        int i = 0;
        if (this.articles.size() > 0) {
            while (!present && i < this.articles.size()) {
                present = this.articles.get(i).getObj().deMemeType(obj);
                i++;
            }
            i--;
            if (this.articles.get(i).getObj().deMemeType(obj)) {
                return i;
            }
        }
        return -1;
    }*/

    public void ajoutInventaire(ObjetRecuperables obj) {
        obj.setP(new Position(0, 0));
        System.out.println(this);
        this.articles.add(obj);
        System.out.println();
        System.out.println(this);
    }

    public void retireInventaire(ObjetRecuperables obj) {
        if (this.articles.contains(obj)) {
            this.articles.remove(obj);
        }
    }

    public void utiliserPotion() {
        if (this.getQuantitePotion() > 0) {
            PotionVitale potion = (PotionVitale) getUnePotion();
            this.j.recevoirSoins(potion.getPouvoir());
            this.retireInventaire(potion);
        }
    }


    @Override
    public String toString() {
        HashMap<ObjetRecuperables, Integer> tout = getQuantiteTout();
        String texte = "";
        for (ObjetRecuperables o : tout.keySet()) {
            texte += o + " : " + tout.get(o) + "\n";
        }
        for (Arme o : this.armespossedees) {
            texte += o + " : " + tout.get(o) + "\n";
        }
        return texte;
    }

    public void ajouterArme(Arme objet) {
        this.armespossedees.add(objet);
    }

    public Arme ArmeDansInventaire(int numeroArme) {
        Arme retour = null;
        switch (numeroArme) {
            case 1:
                for (Arme a : this.armespossedees) {//poing
                    if (a instanceof Poing) {
                        retour = a;
                    }
                }
                break;
            case 2:
                for (Arme a : this.armespossedees) {//gun
                    if (a instanceof Gun) {
                        retour = a;
                    }
                }
                break;
            case 3:
                //katana
        }
        return retour;
    }

    public ArrayList<Arme> getArmespossedees() {
        return armespossedees;
    }

    public Arme remplacerArme(Arme a, int numeroArme) {
        Arme ar = ArmeDansInventaire(numeroArme);
        this.armespossedees.add(a);
        System.out.println("arme remplacee");
        this.armespossedees.remove(ar);
        return ar;
    }

    public Joueur getJ() {
        return j;
    }
}
