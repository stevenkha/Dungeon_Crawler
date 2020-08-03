package com.MainFiles;
import java.util.List;
import java.util.ArrayList;

public class Mobs {

    private List<Characters> mobs;

    public Mobs() {
        this.mobs = new ArrayList<>();
    }

    public void addMob() {
        this.mobs.add(new Characters("Slime", 10, new Weapon("None", 1, 0)));
        this.mobs.add(new Characters("Skeleton", 15, new Weapon("Stone Sword", 10, 2)));
        this.mobs.add(new Characters("Goblin", 20, new Weapon("Small Club", 10, 5)));
        this.mobs.add(new Characters("Giant Spider", 25, new Weapon("Steel Legs", 25, 5)));
        this.mobs.add(new Characters("Ogre", 35, new Weapon("Big Club", 25, 10)));
        this.mobs.add(new Characters("Zombie", 20, new Weapon("None", 10, 5)));
        this.mobs.add(new Characters("Orc", 20, new Weapon("Steel Axe", 20, 10)));
        this.mobs.add(new Characters("Taylor the Monkey", 35, new Weapon("Fists Of Fury", 30, 5)));
        this.mobs.add(new Characters("Justin the beholder", 100, new Weapon("Staff of misery", 40, 10)));
    }

    public List<Characters> getMobs() {
        return this.mobs;
    }

}
