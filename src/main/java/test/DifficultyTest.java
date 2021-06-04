package test;

import me.dzikimlecz.game.enums.Difficulty;
import me.dzikimlecz.game.model.GameConfigs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DifficultyTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    // testing parseDifficulty()
    @Test
    void parseDifficulty_value_null_nullPointerException() {
        Exception exception = assertThrows(NullPointerException.class,() -> {
            Difficulty test = Difficulty.parseDifficulty(null);  });
    }
    @Test
    void parseDifficulty_value_empty_illegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            Difficulty test = Difficulty.parseDifficulty("");  });
        String expectedMessage = "No enum constant me.dzikimlecz.game.enums.Difficulty.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void parseDifficulty_value_notAnEnum_illegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            Difficulty test = Difficulty.parseDifficulty("notAnEnum");  });
        String expectedMessage = "No enum constant me.dzikimlecz.game.enums.Difficulty.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void parseDifficulty_value_easy_validEnum() {
        Difficulty test = Difficulty.parseDifficulty("easy");
        assertEquals(Difficulty.EASY, test);
    }
    @Test
    void parseDifficulty_value_EASY_validEnum() {
        Difficulty test = Difficulty.parseDifficulty("EASY");
        assertEquals(Difficulty.EASY, test);
    }
    @Test
    void parseDifficulty_value_eAsY_validEnum() {
        Difficulty test = Difficulty.parseDifficulty("eAsY");
        assertEquals(Difficulty.EASY, test);
    }

    // testing getMinesFactor()

    // needs testing on the default case to reach 100% coverage
    @Test
    void getMinesFactor_enum_easy_15f() {
        Difficulty test = Difficulty.EASY;
        assertEquals(0.15f, test.getMinesFactor());
    }
    @Test
    void getMinesFactor_enum_medium_2f() {
        Difficulty test = Difficulty.MEDIUM;
        assertEquals(0.2f, test.getMinesFactor());
    }
    @Test
    void getMinesFactor_enum_hard_25f() {
        Difficulty test = Difficulty.HARD;
        assertEquals(0.25f, test.getMinesFactor());
    }
    @Test
    void getMinesFactor_enum_extreme_3f() {
        Difficulty test = Difficulty.EXTREME;
        assertEquals(0.3f, test.getMinesFactor());
    }
}