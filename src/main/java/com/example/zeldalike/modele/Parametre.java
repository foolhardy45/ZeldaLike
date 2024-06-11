package com.example.zeldalike.modele;

public class Parametre {
    public static int distance(Position p1, Position p2) {
        int super_x;
        int super_y;
        int distance;

        super_x = (p1.getX() - p2.getX()) * (p1.getX() - p2.getX());
        super_y = (p1.getY() - p2.getY()) * (p1.getY() - p2.getY());
        distance = (int) Math.sqrt(super_x + super_y);
        return distance;
    }
}
