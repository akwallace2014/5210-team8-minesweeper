package test;

import me.dzikimlecz.game.enums.Theme;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThemeTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    // testing parseTheme()
    @Test
    void parseTheme_theme_light_validEnum() {
        Theme test = Theme.parseTheme("light");
        assertEquals(Theme.LIGHT, test);
    }
    @Test
    void parseTheme_theme_LIGHT_validEnum() {
        Theme test = Theme.parseTheme("LIGHT");
        assertEquals(Theme.LIGHT, test);
    }
    @Test
    void parseTheme_theme_lIghT_validEnum() {
        Theme test = Theme.parseTheme("lIghT");
        assertEquals(Theme.LIGHT, test);
    }
    @Test
    void parseTheme_theme_pinkspacedark_validEnum() {
        Theme test = Theme.parseTheme("pink dark");
        assertEquals(Theme.PINK_DARK, test);
    }
    @Test
    void parseTheme_theme_PINKspaceDARK_validEnum() {
        Theme test = Theme.parseTheme("PINK DARK");
        assertEquals(Theme.PINK_DARK, test);
    }
    @Test
    void parseTheme_theme_pink_dark_validEnum() {
        Theme test = Theme.parseTheme("pink_dark");
        assertEquals(Theme.PINK_DARK, test);
    }
    @Test
    void parseTheme_theme_pink_DARK_validEnum() {
        Theme test = Theme.parseTheme("pink_DARK");
        assertEquals(Theme.PINK_DARK, test);
    }
}