package com.example.zeldalike.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Position {
    private final IntegerProperty x;
    private final IntegerProperty y;

    public Position(int x, int y) {
        this.x = new SimpleIntegerProperty(x);
        this.y = new SimpleIntegerProperty(y);
    }

    public int getX() {
        return x.get();
    }

    public void setX(int x) {
        this.x.set(x);
    }

    public IntegerProperty xProperty() {
        return x;
    }

    public int getY() {
        return y.get();
    }

    public void setY(int y) {
        this.y.set(y);
    }

    public IntegerProperty yProperty() {
        return y;
    }

    public boolean collisionEntreSprites(Position p){
        int PBasDroite = 31;
        return (this.x.get() + PBasDroite >= p.getX()) && (this.x.get() <= p.getX() + PBasDroite) && (this.y.get() + PBasDroite >= p.getY()) && (this.y.get() <= p.getY()+PBasDroite);
    }
    public boolean surSprites(Position p){
        return (this.x.get()>= p.getX()) && (this.x.get() <= p.getX()) && (this.y.get() >= p.getY()) && (this.y.get() <= p.getY());
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
