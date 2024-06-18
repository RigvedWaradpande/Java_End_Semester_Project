# CharacterCreator-inator Game
This is the source code for the avatar game built as the end semester project for OOP Lab.

# Introduction
The CharacterCreator is a Java-based application that seamlessly integrates Object-Oriented Programming (OOP) principles and Java FX to offer a comprehensive set of features for this character creator application.

Our game invites players to immerse themselves in a captivating Java-based RPG adventure. In this fantastical world brimming with magic, excitement, and peril, players are empowered to shape their destiny by choosing from a diverse array of Character Races and Job titles. This extensive selection ensures that each player's journey is unique, offering a truly immersive experience.

In this dynamic RPG landscape, the integration of OOP principles ensures that the game's architecture is robust, scalable, and easily extensible. The use of Java FX enhances the visual appeal of the CharacterCreator, providing a user-friendly interface that complements the depth of character customization offered by the underlying OOP design.

# Methodology
### Encapsulation
The CharacterCreator leverages encapsulation, encapsulating various character attributes, such as health, attack, stamina, intelligence, and agility, within the underlying classes like Perks, Race, Job, and Avatar. This encapsulation ensures that the internal details of character creation are well-organised and controlled.

### Inheritance
The usage of inheritance is evident in the Race and Job classes, with the Job class extending the Race class. This hierarchical structure allows for the creation of diverse job titles while inheriting the core characteristics of the corresponding race, fostering code reuse and extensibility.

### Polymorphism
The Fighters class exhibits polymorphism, enabling different types of fighters to engage in battles interchangeably through the attack and receiveDamage methods. This flexibility in handling various fighter types enhances the dynamic nature of the game.

### Abstraction
The Avatar class abstracts the complexities of character representation, providing a clean interface for displaying character details and calculating essential attributes like attack and health. This abstraction allows players to interact with their avatars without delving into the underlying implementation.

### Multithreading
The game implements multithreading during combat. It waits on one thread while the other combatant is attacking.

# Tech Stack
We have used 100% Java to implement the game. Part of the UI is implemented in JavaSwing and the combat is implemented in JavaFX.
