package com.MainFiles;

public class Hero extends Characters {

    private int potionCount;

    public Hero() {
        super("Hero", 100, new Weapon("Wooden Sword", 10, 5));
        this.potionCount = 5;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public int getHealth() {
        return super.getHealth();
    }

    @Override
    public int attack(Weapon weapon) {
        return super.attack(weapon);
    }

    @Override
    public void damaged(int damage) {
        super.damaged(damage);
    }

    @Override
    public void drinkPotion(int amount) {
        if (!isHealthMax()) {
            this.potionCount--;
        }

        super.drinkPotion(amount);
    }

    public boolean isHealthMax() {
        return super.getHealth() == 100;
    }

    public int getPotionAmount() {
        return this.potionCount;
    }

    public void setPotionCount(int amount) {
        this.potionCount += amount;
    }

    public void heal(int amount) {
        super.drinkPotion(amount);
    }

}
