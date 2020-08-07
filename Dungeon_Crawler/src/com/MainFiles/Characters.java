package com.MainFiles;

public class Characters {

    private final String name;
    private int health;
    private final Weapon weapon;

    public Characters(String name, int health, Weapon weapon) {

        this.name = name;
        this.health = health;
        this.weapon = weapon;

    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public int attack(Weapon weapon) {
        return weapon.getWeaponDamage();
    }

    public void damaged(int damage) {
        this.health -= damage;
    }

    public void drinkPotion(int amount) {
        if (this.health == 100) {
            System.out.println("Health already at max");
        } else if (this.health + 10 > 100) {
            this.health = 100;
        } else {
            this.health += (10 * amount);
        }
    }


}
