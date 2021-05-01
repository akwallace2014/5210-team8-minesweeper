package test;

import me.dzikimlecz.game.model.GameProperties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GamePropertiesTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    // testing register()
    @Test
    void register_key_object_existsInMap() {
        GameProperties test = new GameProperties();
        test.register("key", "object");
        assertEquals("object", test.get("key"));
    }
    @Test
    void register_key_empty_existsInMap() {
        GameProperties test = new GameProperties();
        test.register("", "object");
        assertEquals("object", test.get(""));
    }
    @Test
    void register_key_preexisting_noOverwrite() {
        GameProperties test = new GameProperties();
        test.register("key", "object1");
        test.register("key", "object2");
        assertEquals("object1", test.get("key"));
    }

    // testing get()
    @Test
    void get_key_null_null() {
        GameProperties test = new GameProperties();
        assertEquals(null, test.get(null));
    }
    @Test
    void get_key_nonexistent_null() {
        GameProperties test = new GameProperties();
        assertEquals(null, test.get("key"));
    }
    @Test
    void get_key_exists_object() {
        GameProperties test = new GameProperties();
        test.register("key", "object");
        assertEquals("object", test.get("key"));
    }

    // testing isEmpty()
    @Test
    void isEmpty_gameProperties_empty_true() {
        GameProperties test = new GameProperties();
        assertTrue(test.isEmpty());
    }
    @Test
    void isEmpty_gameProperties_notEmpty_false() {
        GameProperties test = new GameProperties();
        test.register("key", "object");
        assertFalse(test.isEmpty());
    }
}