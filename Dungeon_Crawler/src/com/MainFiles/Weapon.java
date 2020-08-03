package com.MainFiles;
import java.util.Random;

public class Weapon {

    private String weaponName;
    private int maxWeaponDamage;
    private int minWeaponDamage;

    public Weapon(String weaponName, int maxWeaponDamage, int minWeaponDamage) {
        this.weaponName = weaponName;
        this.maxWeaponDamage = maxWeaponDamage;
        this.minWeaponDamage = minWeaponDamage;
    }

    public String getWeaponName() {
        return this.weaponName;
    }

    public int getMinWeaponDamage() {
        return this.minWeaponDamage;
    }

    public int getMaxWeaponDamage() {
        return this.maxWeaponDamage;
    }

    public int getWeaponDamage() {
        int attackScale = (int) (Math.random() * (this.maxWeaponDamage - this.minWeaponDamage)) + this.minWeaponDamage;
        return attackScale;
    }

    public void nameModifier(String newWeaponName) {
        this.weaponName = newWeaponName;
    }

    public void damageModifier(int newMaxDamage, int newMinDamage) {
        this.maxWeaponDamage = newMaxDamage;
        this.minWeaponDamage = newMinDamage;
    }
}
