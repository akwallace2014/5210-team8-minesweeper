package test;

import me.dzikimlecz.game.enums.Difficulty;
import me.dzikimlecz.game.enums.Theme;
import me.dzikimlecz.game.model.GameConfigs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameConfigsTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    // testing getCSS()
    @Test
    void getCSS_theme_null_illegalStateException() {
        Exception exception = assertThrows(IllegalStateException.class,() -> {
            GameConfigs test = new GameConfigs();
            test.getCSS();
        });
        String expectedMessage = "No value corresponding to \"theme\" key";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void getCSS_theme_light_lightCSS() {
        GameConfigs test = new GameConfigs();
        test.register("theme", Theme.LIGHT);
        assertEquals("styles/themes/Light.css", test.getCSS());
    }
    @Test
    void getCSS_theme_pinkDark_pinkDarkCSS() {
        // to make sure that hyphen placement works correctly
        GameConfigs test = new GameConfigs();
        test.register("theme", Theme.PINK_DARK);
        assertEquals("styles/themes/Pink-Dark.css", test.getCSS());
    }

    // testing register()

    // testing the reservedKey "theme"
    @Test
    void register_themeValue_wrongValue_illegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            GameConfigs test = new GameConfigs();
            test.register("theme", "wrongObject");
        });
        String expectedMessage = "\"theme\" key must correspond to instance of Theme value. " +
                "(Passed: class java.lang.String)";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void register_theme_light_returnLight() {
        GameConfigs test = new GameConfigs();
        test.register("theme", Theme.LIGHT);
        assertEquals(Theme.LIGHT, test.get("theme"));
    }

    // testing the reservedKey "difficulty"
    @Test
    void register_difficultyValue_wrongValue_illegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class,() -> {
            GameConfigs test = new GameConfigs();
            test.register("difficulty", "wrongObject");
        });
        String expectedMessage = "\"difficulty\" key must correspond to instance of Difficulty value. " +
                "(Passed: class java.lang.String)";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void register_difficulty_easy_returnEasy() {
        GameConfigs test = new GameConfigs();
        test.register("difficulty", Difficulty.EASY);
        assertEquals(Difficulty.EASY, test.get("difficulty"));
    }

    // other register tests
    @Test
    void register_key_nonReservedKey_returnValue() {
        GameConfigs test = new GameConfigs();
        test.register("key", "value");
        assertEquals("value", test.get("key"));
    }
    @Test
    void register_key_repeatedKey_returnValue() {
        GameConfigs test = new GameConfigs();
        test.register("theme", Theme.LIGHT);
        test.register("theme", Theme.DARK);
        assertEquals(Theme.LIGHT, test.get("theme"));
    }

    // testing get()
    @Test
    void get_key_null_IllegalStateException() {
        Exception exception = assertThrows(IllegalStateException.class,() -> {
            GameConfigs test = new GameConfigs();
            test.get("key");
        });
        String expectedMessage = "No value corresponding to \"key\" key";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void get_key_value_returnValue() {
        GameConfigs test = new GameConfigs();
        test.register("key", "value");
        assertEquals("value", test.get("key"));
    }

    // testing getDifficulty()
    @Test
    void getDifficulty_difficulty_easy_returnEasy() {
        GameConfigs test = new GameConfigs();
        test.register("difficulty", Difficulty.EASY);
        assertEquals(Difficulty.EASY, test.getDifficulty());
    }
    @Test
    void getDifficulty_difficulty_null_IllegalStateException() {
        Exception exception = assertThrows(IllegalStateException.class,() -> {
            GameConfigs test = new GameConfigs();
            test.getDifficulty();
        });
        String expectedMessage = "No value corresponding to \"difficulty\" key";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    // testing isEmpty()
    @Test
    void isEmpty_gameProperties_empty_true() {
        GameConfigs test = new GameConfigs();
        assertTrue(test.isEmpty());
    }
    @Test
    void isEmpty_gameProperties_notEmpty_false() {
        GameConfigs test = new GameConfigs();
        test.register("key", "value");
        assertFalse(test.isEmpty());
    }
}