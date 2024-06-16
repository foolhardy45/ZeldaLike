package com.example.zeldalike.modele;

public class BossSamurai extends Boss{
    public BossSamurai(Position p, Environnement env){
        super(50, 0, 0, p, env, 10);
    }


    @Override
    public void personnageTouche(Personnage p) {
        this.verifiephase();
    }

    public void faireuneattaque(){
        switch (this.getPhase()){
            case 1: lanceprojectile();
                System.out.println("hiyaa");
            break;
            case 2: bombechapeau();
                System.out.println("grenade lancée");
            break;
        }
    }




    public void lanceprojectile(){
    //lance une lame dans la direction du joueur
        this.getEnv().ajouterEnnemis(new ProjectileBoss(new Position(this.getP().getX(), this.getP().getY()), this.getEnv()));
    }

    public void bombechapeau(){
        //ombre de chapeau apparait sur la map, puis explose
    }

    @Override
    public void compétence() {
        //mange
    }

    @Override
    public void désacCompétence() {
        //ne mange plus
    }
}
