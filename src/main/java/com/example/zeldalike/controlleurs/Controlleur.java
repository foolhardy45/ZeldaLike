package com.example.zeldalike.controlleurs;

import com.example.zeldalike.modele.Arme.Poing;
import com.example.zeldalike.modele.Arme.gun.Gun;
import com.example.zeldalike.modele.Arme.gun.Munition;
import com.example.zeldalike.modele.*;
import com.example.zeldalike.vues.InventaireVue;
import com.example.zeldalike.vues.JoueurVue;
import com.example.zeldalike.vues.TerrrainVue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class Controlleur implements Initializable {

    private final Set<String> pressedKeys = new HashSet<>();
    @FXML
    private HBox info_joueur;
    @FXML
    private HBox coeurBox;
    @FXML
    private Label nbArgent;
    @FXML
    private TilePane terrain_affichage;

    @FXML
    private TilePane inventairepane;
    @FXML
    private TilePane inventaireobjets;
    private InventaireVue inv;

    @FXML
    private Pane carte_interaction;
    private long lastTime;
    private JoueurVue joueurVue;
    private Environnement env;
    private Timeline gameLoop;
    private int temps_gameloop;
    private boolean cooldown = true;
    private boolean inventaire_ouvert = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.env = new Environnement(2048, 4096);
        TerrrainVue terrrainVue = new TerrrainVue(terrain_affichage, carte_interaction, this.env.getTerrain(), this.env.getJ1());
        terrain_affichage.setOnKeyPressed(this::onKeyPressed);
        terrain_affichage.setOnKeyReleased(this::onKeyReleased);
        terrain_affichage.setFocusTraversable(true);
        terrrainVue.creeMap();
        joueurVue = new JoueurVue(this.env.getJ1(), this.env.getJ1().getArme());

        info_joueur.getChildren().add(joueurVue.getCoeurN1());
        info_joueur.getChildren().add(joueurVue.getCoeurN2());
        info_joueur.getChildren().add(joueurVue.getCoeurN3());

        carte_interaction.getChildren().add(joueurVue.getMac());
        carte_interaction.getChildren().add(joueurVue.getArmeView());


        this.env.getJ1().directionProperty().addListener(((observable, oldValue, newValue) -> {
            if (this.env.getJ1().getArme() instanceof Poing) {
                switch ((int) newValue) {
                    case 8:
                        System.out.println("haut");
                        this.joueurVue.getMac().setImage(this.joueurVue.getSpriteUp());
                        System.out.println(this.joueurVue.getMac().getImage());

                        break;
                    case 2:
                        System.out.println("bas");
                        this.joueurVue.getMac().setImage(this.joueurVue.getSpriteDown());
                        System.out.println(this.joueurVue.getMac().getImage());
                        break;
                    case 4:
                        System.out.println("gauche");
                        this.joueurVue.getMac().setImage(this.joueurVue.getSpriteLeft());
                        System.out.println(this.joueurVue.getMac().getImage());
                        break;
                    case 6:
                        System.out.println("droite");
                        this.joueurVue.getMac().setImage(this.joueurVue.getSpriteRight());
                        System.out.println(this.joueurVue.getMac().getImage());
                        break;
                }
            } else if (this.env.getJ1().getArme() instanceof Gun) {
                switch ((int) newValue) {
                    case 8:
                        this.joueurVue.getMac().setImage(this.joueurVue.getSpriteGunUp());
                        System.out.println();
                        break;
                    case 2:
                        this.joueurVue.getMac().setImage(this.joueurVue.getSpriteGunDown());
                        break;
                    case 4:
                        this.joueurVue.getMac().setImage(this.joueurVue.getSpriteGunLeft());
                        break;
                    case 6:
                        this.joueurVue.getMac().setImage(this.joueurVue.getSpriteGunRight());

                }
            }
        }));
        MonObservateurEnnemis observateurlisteennemi = new MonObservateurEnnemis(carte_interaction);
        MonObservateurMunition observateurMunition = new MonObservateurMunition(carte_interaction);
        this.env.getEnnemis().addListener(observateurlisteennemi);
        this.env.getJ1().getMunitionObservableList().addListener(observateurMunition);
        Citron ennemipuissant = new Citron(new Position(20, 20), this.env);
        Macarena maca = new Macarena(new Position(30, 30), this.env);
        //this.env.ajouterEnnemis(ennemipuissant);
        //this.env.ajouterEnnemis(maca);
        BusinessMan man = new BusinessMan(new Position(640, 640), this.env);
        this.env.ajouterEnnemis(man);
        MonObservateurObjet observateurlisteobjet = new MonObservateurObjet(carte_interaction);
        this.env.getObjet().addListener(observateurlisteobjet);
        Position PP1 = new Position(0, 0);
        Position PP2 = new Position(0, 0);
        Munition p1 = new Munition(PP1, this.env.getJ1(), 0);
        Munition p2 = new Munition(PP2, this.env.getJ1(), 0);
        this.env.ajouterObjet(p1);
        this.env.ajouterObjet(new PotionVitale(new Position(510, 510)));
        this.env.ajouterObjet(new PotionVitale(new Position(128, 128)));
        this.env.ajouterObjet(new PotionVitale(new Position(256, 0)));

        this.env.ajouterObjet(new ChaussuresHydrophobes(new Position(200, 5)));
        this.env.ajouterObjet(p2);
        System.out.println(p1.getIdObjet() + "muni 1");
        System.out.println(p2.getIdObjet() + "muni 2");

        //this.env.getJ1().getSac().ajoutInventaire(new PotionVitale(new Position(5, 5)));
        //this.env.getJ1().getSac().ajoutInventaire(new PotionVitale(new Position(5, 5)));
        //this.env.getJ1().getSac().ajoutInventaire(new Cle(new Position(0, 0)));
        this.inventairepane.setVisible(false);
        this.inv = new InventaireVue(inventairepane, inventaireobjets, env.getJ1().getSac());


        System.out.println(this.env.getJ1().getSac().toString());


        terrain_affichage.requestFocus();

        initAnimation();
        gameLoop.play();
    }

    private void onKeyPressed(KeyEvent event) {
        pressedKeys.add(event.getCode().toString());
        handleMovement();
    }

    private void onKeyReleased(KeyEvent event) {
        pressedKeys.remove(event.getCode().toString());
        this.env.getJ1().ajouterDirection(0);
        handleMovement();
    }


    private void handleMovement() {
        boolean movingUp = pressedKeys.contains("UP");
        boolean movingDown = pressedKeys.contains("DOWN");
        boolean movingLeft = pressedKeys.contains("LEFT");
        boolean movingRight = pressedKeys.contains("RIGHT");
        boolean interact = pressedKeys.contains("E");
        boolean attaque = pressedKeys.contains("X");
        boolean inventaire = pressedKeys.contains("A");

        if (!this.inventaire_ouvert) {
            if (movingRight && movingLeft || movingDown && movingUp) {
                this.env.getJ1().ajouterDirection(5);
            } else if (movingUp && movingRight) {
                this.env.getJ1().ajouterDirection(9);
            } else if (movingUp && movingLeft) {
                this.env.getJ1().ajouterDirection(7);
            } else if (movingDown && movingLeft) {
                this.env.getJ1().ajouterDirection(1);
            } else if (movingDown && movingRight) {
                this.env.getJ1().ajouterDirection(3);
            } else if (movingUp) {
                this.env.getJ1().ajouterDirection(8);
            } else if (movingRight) {
                this.env.getJ1().ajouterDirection(6);
            } else if (movingDown) {
                this.env.getJ1().ajouterDirection(2);
            } else if (movingLeft) {
                this.env.getJ1().ajouterDirection(4);
            }
            if (attaque && cooldown) {
                this.env.getJ1().ajouterDirection(5);
                this.joueurVue.afficherArmeView();
                this.env.getJ1().attaquer();
                cooldown = false;
            } else if (interact) {
                this.env.getJ1().setInteraction(true);
            }
        } else {
            if (movingUp) {
                this.inv.deplacerSelect(8);
            } else if (movingRight) {
                this.inv.deplacerSelect(6);
            } else if (movingDown) {
                this.inv.deplacerSelect(2);
            } else if (movingLeft) {
                this.inv.deplacerSelect(4);
            }
            else if (interact) {
                this.inv.utiliserObjetSelect();
            }
        }
        if (inventaire) {
            pressedKeys.remove("A");
            //lanceMenuPause();
            inventaire_ouvert = this.inv.ouvrirInventaire();
        }

    }


    private void initAnimation() {
        gameLoop = new Timeline();
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        temps_gameloop = 0;
        lastTime = System.currentTimeMillis();

        KeyFrame kf = new KeyFrame(
                Duration.seconds(0.017),
                ev -> {
                    long currentTime = System.currentTimeMillis();
                    lastTime = currentTime;

                    if (!inventaire_ouvert) {
                        this.env.unTour();

                        if (this.joueurVue.isVisible()) {
                            if (temps_gameloop % 30 == 0) {
                                this.joueurVue.getArmeView().setVisible(false);
                                cooldown = true;
                            }
                        }
                        if (this.joueurVue.isVisible()) { // Si le joueur fait une attaque alors pendant qu"elle que seconde l'arme s'affichera
                            if (temps_gameloop % 30 == 0) {
                                this.joueurVue.getArmeView().setVisible(false);
                                cooldown = true;
                            }
                        }
                    }
                    temps_gameloop++;
                }
        );

        gameLoop.getKeyFrames().add(kf);
    }
}
