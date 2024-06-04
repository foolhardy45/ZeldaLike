package com.example.zeldalike.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Position {
    private IntegerProperty x;
    private IntegerProperty y;

    public Position(int x, int y){
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
    }

    public int getX() {
        return x.get();
    }

    public IntegerProperty xProperty() {
        return x;
    }

    public void setX(int x) {
        this.x.set(x);
    }

    public int getY() {
        return y.get();
    }

    public IntegerProperty yProperty() {
        return y;
    }

    public void setY(int y) {
        this.y.set(y);
    }

    public boolean collisionEntreSprites(Position p){
        int PBasDroite = 31;
        return (this.x.get() + PBasDroite >= p.getX()) && (this.x.get() <= p.getX() + PBasDroite) && (this.y.get() + PBasDroite >= p.getY()) && (this.y.get() <= p.getY()+PBasDroite);
    }
    public boolean surSprites(Position p){
        return (this.x.get()>= p.getX()) && (this.x.get() <= p.getX()) && (this.y.get() >= p.getY()) && (this.y.get() <= p.getY());
    }
}
