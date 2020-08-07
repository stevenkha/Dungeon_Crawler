package com.MainFiles;

import java.util.Scanner;
import java.util.Random;

public class UserInterface {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int progressTracker = 0;
        Hero hero = new Hero();
        Mobs mobs = new Mobs();
        mobs.addMob();
        introText();
        scan.nextLine();

        GAME:
        while (true) {

            //iterate through every mob available within the Mobs class
            for (int i = 0; i < mobs.getMobs().size(); i++) {

                Characters mob = mobs.getMobs().get(i);
                System.out.println("+++++++++++++++++++++++++++++++++++++++");
                System.out.println("\t!" + mob.getName() + " has appeared!");
                System.out.println();

                while (!isDead(mob)) {

                    encounterText(mob, hero);

                    try {
                        int input = Integer.parseInt(scan.nextLine());
                        commands(hero, mob, hero.getWeapon(), mob.getWeapon(), input);
                            if (input == 0) {
                                break GAME;
                            }

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid command");
                        scan.nextLine();
                    }


                    if (isDead(hero)) {
                        System.out.println("You died! Better luck next time!");
                        break GAME;
                    }

                }//while mob loop

                System.out.println();
                System.out.println(mob.getName() + " was defeated!");
                System.out.println("Press enter to continue down the dungeon");
                scan.nextLine();

                //keep track of the progress made through the dungeon to trigger special output
                progressTracker++;

                progressTrackerOutput(progressTracker, hero);

                if (progressTracker == 9) {
                    break GAME;
                }

            }//for loop
        }//while
    }//main

    public static void commands(Characters hero, Characters mob, Weapon heroWeapon, Weapon mobWeapon, int command) {
        switch(command) {
            case 1:
                int heroAttack = hero.attack(heroWeapon);
                int mobAttack = mob.attack(mobWeapon);
                System.out.println("You attack the " + mob.getName() + " for " + heroAttack);
                mob.damaged(heroAttack);
                    if (mob.getHealth() <= 0) {
                        break;
                    }

                    System.out.println("The " + mob.getName() + " attacks back for " + mobAttack);
                    hero.damaged(mobAttack);
                    System.out.println();

                break;
            case 2:
                hero.drinkPotion(1);
                System.out.println();
                if (((Hero) hero).getPotionAmount() > 0 && !((Hero) hero).isHealthMax()) {
                    System.out.println("You used a potion!");
                    System.out.println();
                } else if (((Hero) hero).getPotionAmount() == 0) {
                    System.out.println("You have no potions left\n");
                }
                break;
            case 3:
                mobAttack = mob.attack(mobWeapon);
                System.out.println("You attempt to counter the " + mob.getName() + "'s attack");
                Random rand = new Random();
                int successChance = rand.nextInt(100);
                    if (successChance >= 70) {
                        System.out.println("You successfully counter the " + mob.getName() + ". It takes " + (mobAttack+5) + " damage\n");
                        mob.damaged(mobAttack+5);
                    } else {
                        System.out.println("You fail to counter the incoming attack and take " + mobAttack + " damage\n");
                        hero.damaged(mobAttack);
                    }
                break;
            default:
                System.out.println("Invalid Command");
                System.out.println();
        }
    }

    public static boolean isDead(Characters character) {
        return character.getHealth() <= 0;
    }

    public static void introText() {

        System.out.println("Welcome to the start of the Dungeon!\n");
        System.out.println("Basic Information:");
        System.out.println(">You start with 5 potions that heal for 10 HP");
        System.out.println(">You start with a wooden sword that deals 5-10 damage");
        System.out.println(">You will be able to find chests with loot such as new weapons and potions along the way ");
        System.out.println(">Enemies will become progressively harder as you continue\n");
        System.out.println("Press enter to start");
    }

    public static void encounterText(Characters mob, Hero hero) {

        System.out.println("\t>" + mob.getName() + " HP: " + mob.getHealth());
        System.out.println("\t>" + mob.getName() + " Weapon: " + mob.getWeapon().getWeaponName() + " (" + mob.getWeapon().getMinWeaponDamage() + "-" + mob.getWeapon().getMaxWeaponDamage()+ ")");
        System.out.println();
        System.out.println("\t>Hero HP: " + hero.getHealth());
        System.out.println("\t>Potion Count: " + hero.getPotionAmount());
        System.out.println("\t>Weapon: " + hero.getWeapon().getWeaponName() + " (" + hero.getWeapon().getMinWeaponDamage() + "-" + hero.getWeapon().getMaxWeaponDamage() + ")\n");
        System.out.println("\t>Choose a command");
        System.out.println("\t>1. Attack");
        System.out.println("\t>2. Drink a health Potion");
        System.out.println("\t>3. Counter");
        System.out.println("\t>0. Exit Program");
    }

    public static void progressTrackerOutput(int progressTracker, Hero hero) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        switch(progressTracker){
            case 3:
                System.out.println("You found a chest! Press enter to open");
                scan.nextLine();
                System.out.println("You found an iron sword!");
                hero.getWeapon().nameModifier("Iron Sword");
                hero.getWeapon().damageModifier(20, 10);
                scan.nextLine();
                break;
            case 6:
                System.out.println("You find a safe place to rest and assess your wounds.");
                if (hero.isHealthMax()) {
                    System.out.println("Health already at max");
                    break;
                }
                System.out.println("Healed for 30 HP");
                hero.heal(3);
                scan.nextLine();
                break;
            case 8:
                System.out.println("You found a chest! Press enter to open");
                scan.nextLine();
                int foundPotions = rand.nextInt(5-1) + 1;
                System.out.println("You found " + foundPotions + " potions!");
                hero.setPotionCount(foundPotions);
                scan.nextLine();
                System.out.println("You see a fallen corpse by an ominous door holding a legendary sword");
                scan.nextLine();
                System.out.println("You take the sword from the fallen corpse and prepare for the boss that awaits within");
                hero.getWeapon().nameModifier("Legendary Sword");
                hero.getWeapon().damageModifier(45, 15);
                scan.nextLine();
                break;
            case 9:
                System.out.println("Congratulations! You made it through the dungeon");
                break;
        }
    }

}
