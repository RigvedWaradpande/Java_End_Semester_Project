package com.example.demo;

import java.util.InputMismatchException;
import java.util.Scanner;

// Perks class
class Perks {
    private int health;
    private int attack;
    private int stamina;
    private int intelligence;
    private int agility;

    public Perks(int health, int attack, int stamina, int intelligence, int agility) {
        this.health = health;
        this.attack = attack;
        this.stamina = stamina;
        this.intelligence = intelligence;
        this.agility = agility;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getStamina() {
        return stamina;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }
}

// Race class
class Race {
    private String name;
    private Perks racePerks;

    public Race(String name, Perks racePerks) {
        this.name = name;
        this.racePerks = racePerks;
    }

    public String getName() {
        return name;
    }

    public Perks getRacePerks() {
        return racePerks;
    }
}

// Job class extends Race
class Job extends Race {
    private Perks jobPerks;

    public Job(String name, Perks racePerks, Perks jobPerks) {
        super(name, racePerks);
        this.jobPerks = jobPerks;
    }

    public Perks getJobPerks() {
        return jobPerks;
    }
}

class Avatar {
    private Race race;
    private Job job;
    private String name;

    public Avatar(String name, Race race, Job job) {
        this.name = name;
        this.race = race;
        this.job = job;
    }

    public void displayAvatar() {
        System.out.println("Name: " + this.name);
        System.out.println("Race: " + race.getName() + "  Job: " + job.getName());
        System.out.println("Attack Power: " + this.avatarAttack() + "  Health: " + this.avatarHealth());
        System.out.println();
    }

    public int avatarAttack()
    {
        return 2 * (this.race.getRacePerks().getAttack() + this.job.getJobPerks().getAttack());
    }

    public int avatarHealth()
    {
        return 10 * (this.race.getRacePerks().getHealth() + this.job.getJobPerks().getHealth());
    }

    public String getName()
    {
        return this.name;
    }

}

class Fighters {
    private String name;
    private int health;
    private int attack;

    public Fighters(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() { // Added getAttack method
        return attack;
    }

    public void attack(Fighters opponent) {
        opponent.receiveDamage(attack);
    }

    public void receiveDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }
}

class Fight implements Runnable {
    private Fighters character1;
    private Fighters character2;

    public Fight(Fighters character1, Fighters character2) {
        this.character1 = character1;
        this.character2 = character2;
    }

    @Override
    public void run() {
        if (character1.getHealth() == character2.getHealth() && character1.getAttack() == character2.getAttack()) {
            System.out.println("It's a draw! Both fighters have equal strength.");
            return; // Exit the fight loop
        }
        while (character1.getHealth() > 0 && character2.getHealth() > 0) {

            try {
                Thread.sleep(1000); // Introduce a delay of 1000 milliseconds (1 second)
                System.out.println("Attack in process...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Character 1 attacks Character 2
            character1.attack(character2);
            printStatus();

            // Check if Character 2 is defeated
            if (character2.getHealth() <= 0) {
                System.out.println(character2.getName() + " is defeated!");
                break;
            }

            try {
                Thread.sleep(1000); // Introduce a delay of 1000 milliseconds (1 second)
                System.out.println("Attack in process...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Character 2 attacks Character 1
            character2.attack(character1);
            printStatus();

            // Check if Character 1 is defeated
            if (character1.getHealth() <= 0) {
                System.out.println(character1.getName() + " is defeated!");
                break;
            }


        }

        // Determine the winner
        if (character1.getHealth() > 0) {
            System.out.println(character1.getName() + " wins!");
        } else {
            System.out.println(character2.getName() + " wins!");
        }
    }

    private void printStatus() {
        System.out.println(character1.getName() + " health: " + character1.getHealth());
        System.out.println(character2.getName() + " health: " + character2.getHealth());
        System.out.println("------------");
    }
}


public class Avatargame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define races and jobs with their respective perks
        Race[] races = {
                new Race("Human", new Perks(2, 2, 1, 3, 2)),
                new Race("Giants", new Perks(4, 3, 1, 1, 1)),
                new Race("Goblins", new Perks(1, 1, 3, 2, 3)),
                new Race("Dwarfs", new Perks(2, 1, 2, 3, 2)),
                new Race("Vampires", new Perks(2, 3, 1, 2, 2))
        };

        Job[] jobs = {
                new Job("Rogue", races[2].getRacePerks(), new Perks(1, 1, 2, 3, 3)),
                new Job("Knight", races[1].getRacePerks(), new Perks(2, 2, 2, 2, 2)),
                new Job("Mage", races[4].getRacePerks(), new Perks(1, 2, 4, 1, 2)),
                new Job("Healer", races[0].getRacePerks(), new Perks(4, 1, 2, 1, 1)),
                new Job("Monk", races[3].getRacePerks(), new Perks(2, 2, 1, 3, 2))
        };

        // Create two avatars
        System.out.println("Create Avatar 1");
        Avatar avatar1 = createAvatar(scanner, races, jobs);

        System.out.println("Create Avatar 2");
        Avatar avatar2 = createAvatar(scanner, races, jobs);

        // Display avatars
        System.out.println("Avatar 1:");
        avatar1.displayAvatar();
        System.out.println("Avatar 2:");
        avatar2.displayAvatar();

        // Fight!
        Fighters avatar_1 = new Fighters(avatar1.getName(), avatar1.avatarHealth(), avatar1.avatarAttack());
        Fighters avatar_2 = new Fighters(avatar2.getName(), avatar2.avatarHealth(), avatar2.avatarAttack());
        if(avatar1.avatarAttack() == avatar2.avatarAttack() && avatar1.avatarHealth() == avatar2.avatarHealth())
        {
            System.out.println("Characters have the same stats, battle is be a draw.");
        }
        else
        {
            Fight battle = new Fight(avatar_1, avatar_2);

            Thread battleThread = new Thread(battle);

            System.out.println("Battle Start!");
            System.out.println("------------");
            battleThread.start();


        }
        scanner.close();
    }

    private static Avatar createAvatar(Scanner scanner, Race[] races, Job[] jobs) {
        System.out.println("Choose Avatar name:");
        String name = scanner.next();

        System.out.println("Choose a race(1 to 5):");
        for (int i = 0; i < races.length; i++) {
            System.out.println((i + 1) + ". " + races[i].getName());
        }

        int selectedRaceIndex = -1;
        boolean validRaceSelection = false;
        while (!validRaceSelection) {
            try {
                selectedRaceIndex = scanner.nextInt() - 1;

                if (selectedRaceIndex >= 0 && selectedRaceIndex < races.length) {
                    validRaceSelection = true;
                } else {
                    System.out.println("Invalid race selection. Please choose a valid race.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        System.out.println("Choose a job(1 to 5):");
        for (int i = 0; i < jobs.length; i++) {
            System.out.println((i + 1) + ". " + jobs[i].getName());
        }

        int selectedJobIndex = -1;
        boolean validJobSelection = false;
        while (!validJobSelection) {
            try {
                selectedJobIndex = scanner.nextInt() - 1;

                if (selectedJobIndex >= 0 && selectedJobIndex < jobs.length) {
                    validJobSelection = true;
                } else {
                    System.out.println("Invalid job selection. Please choose a valid job.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        // Compute final perks
        Race selectedRace = races[selectedRaceIndex];
        Job selectedJob = jobs[selectedJobIndex];

        selectedRace.getRacePerks().setHealth((int)(0.4 * selectedRace.getRacePerks().getHealth() + 0.1 * selectedRace.getRacePerks().getIntelligence() + 0.3 * selectedRace.getRacePerks().getAgility() + 0.2 * selectedRace.getRacePerks().getStamina()));
        selectedRace.getRacePerks().setAttack((int)(0.3 * selectedRace.getRacePerks().getAttack() + 0.3 * selectedRace.getRacePerks().getIntelligence() + 0.2 * selectedRace.getRacePerks().getAgility() + 0.2 * selectedRace.getRacePerks().getStamina()));

        selectedJob.getJobPerks().setHealth((int)(0.4 * selectedJob.getJobPerks().getHealth() + 0.1 * selectedJob.getJobPerks().getIntelligence() + 0.3 * selectedJob.getJobPerks().getAgility() + 0.2 * selectedJob.getJobPerks().getStamina()));
        selectedJob.getJobPerks().setAttack((int)(0.3 * selectedJob.getJobPerks().getAttack() + 0.3 * selectedJob.getJobPerks().getIntelligence() + 0.2 * selectedJob.getJobPerks().getAgility() + 0.2 * selectedJob.getJobPerks().getStamina()));

        return new Avatar(name, selectedRace, selectedJob);
    }
}
