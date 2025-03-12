# Text-Based Adventure Game

This is a university project showcasing object-oriented programming principles, including inheritance, polymorphism, and design patterns, while following Clean Code guidelines.

## Game Overview

The game is an interactive text-based adventure where the player progresses through randomly generated rooms. Each room presents different challenges, including magic spells, math puzzles, dice games, and interactions with NPCs.

## Features

- **Dynamic Room Generation**: Rooms are created using a factory pattern and randomly assigned based on predefined rules.  
- **Player System**: The player is initialized from a CSV file, ensuring valid health points.  
- **Room Types**:  
  - **Magic Room**: Players recite a spell to gain points.  
  - **Ordinary Room**: Contains NPCs (Farmers & Villagers) with unique dialogues.  
  - **Trap Room**: Players solve a math puzzle to avoid damage.  
  - **Tavern**: A dice game with potential health penalties.  
  - **End Room**: Victory is rewarded with a special surprise!  
- **NPC Interaction**: Different character types use polymorphism to generate appropriate dialogues.  
- **Room Linking**: Each room is aware of its neighbor, ensuring structured gameplay.  
- **Survival Mechanic**: Players must maintain health points to continue their journey.  

## Technologies & Concepts Used

- **Java 21**  
- **Object-Oriented Programming (OOP)**  
- **Design Patterns (Factory, Singleton, etc.)**  
- **Clean Code Principles**  

This project demonstrates strong OOP design and structured game logic.
