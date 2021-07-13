package nl.experis.characters;

import nl.experis.attributes.PrimaryAttributes;
import nl.experis.attributes.SecondaryAttributes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    public void createCharacter_newCharacter_levelOne() {
        // Arrange
        Mage mageSean = new Mage("Sean");
        int expected = 1;

        // Act
        int actual = mageSean.getLevel();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void gainLevel_gainOneLevel_two() {
        // Arrange
        Mage mageSean = new Mage("Sean");
        int expected = 2;

        // Act
        mageSean.levelUp(1);
        int actual = mageSean.getLevel();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void gainLevel_gainZeroLevels_IllegalArgumentException() {
        // Arrange
        Mage mageSean = new Mage("Sean");

        // Act && Assert
        assertThrows(IllegalArgumentException.class, () -> mageSean.levelUp(0));
    }

    @Test
    public void createCharacter_newMage_correctDefaultValues() {
        // Arrange
        Mage mageSean = new Mage("Sean");
        PrimaryAttributes expected = new PrimaryAttributes(5, 1, 1, 8);

        // Act
        PrimaryAttributes actual = mageSean.getBasePrimaryAttributes();

        // Assert
        assertTrue(expected.equals(actual));
    }

    @Test
    public void createCharacter_newRanger_correctDefaultValues() {
        // Arrange
        Ranger rangerSean = new Ranger("Sean");
        PrimaryAttributes expected = new PrimaryAttributes(8, 1, 7, 1);

        // Act
        PrimaryAttributes actual = rangerSean.getBasePrimaryAttributes();

        // Assert
        assertTrue(expected.equals(actual));
    }

    @Test
    public void createCharacter_newRogue_correctDefaultValues() {
        // Arrange
        Rogue rogueSean = new Rogue("Sean");
        PrimaryAttributes expected = new PrimaryAttributes(8, 2, 6, 1);

        // Act
        PrimaryAttributes actual = rogueSean.getBasePrimaryAttributes();

        // Assert
        assertTrue(expected.equals(actual));
    }

    @Test
    public void createCharacter_newWarrior_correctDefaultValues() {
        // Arrange
        Warrior warriorSean = new Warrior("Sean");
        PrimaryAttributes expected = new PrimaryAttributes(10, 5, 2, 1);

        // Act
        PrimaryAttributes actual = warriorSean.getBasePrimaryAttributes();

        // Assert
        assertTrue(expected.equals(actual));
    }

    @Test
    public void levelUp_mage_correctPrimaryAttributes() {
        // Arrange
        Mage mageSean = new Mage("Sean");
        PrimaryAttributes expected = new PrimaryAttributes(8, 2, 2, 13);

        // Act
        mageSean.levelUp(1);
        PrimaryAttributes actual = mageSean.getBasePrimaryAttributes();

        // Assert
        assertTrue(expected.equals(actual));
    }

    @Test
    public void levelUp_ranger_correctPrimaryAttributes() {
        // Arrange
        Ranger rangerSean = new Ranger("Sean");
        PrimaryAttributes expected = new PrimaryAttributes(10, 2, 12, 2);

        // Act
        rangerSean.levelUp(1);
        PrimaryAttributes actual = rangerSean.getBasePrimaryAttributes();

        // Assert
        assertTrue(expected.equals(actual));
    }

    @Test
    public void levelUp_rogue_correctPrimaryAttributes() {
        // Arrange
        Rogue rogueSean = new Rogue("Sean");
        PrimaryAttributes expected = new PrimaryAttributes(11, 3, 10, 2);

        // Act
        rogueSean.levelUp(1);
        PrimaryAttributes actual = rogueSean.getBasePrimaryAttributes();

        // Assert
        assertTrue(expected.equals(actual));
    }

    @Test
    public void levelUp_warrior_correctPrimaryAttributes() {
        // Arrange
        Warrior warriorSean = new Warrior("Sean");
        PrimaryAttributes expected = new PrimaryAttributes(15, 8, 4, 2);

        // Act
        warriorSean.levelUp(1);
        PrimaryAttributes actual = warriorSean.getBasePrimaryAttributes();

        // Assert
        assertTrue(expected.equals(actual));
    }

    @Test
    public void levelUp_warrior_correctSecondaryAttributes() {
        // Arrange
        Warrior warriorSean = new Warrior("Sean");
        SecondaryAttributes expected = new SecondaryAttributes(150, 12, 2);

        // Act
        warriorSean.levelUp(1);
        SecondaryAttributes actual = warriorSean.getSecondaryAttributes();

        // Assert
        assertTrue(expected.equals(actual));
    }
}