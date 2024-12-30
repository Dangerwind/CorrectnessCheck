import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestValidator {

    @Test
    public void testStringStart() {
        var schema = new Validator().string();
// Пока не вызван метод required(), null и пустая строка считаются валидным
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
    }
    @Test
    public void testStringRequired() {
        var schema = new Validator().string();
        schema.required();
        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
    }
    @Test
    public void testStringMinLength() {
        var schema = new Validator().string();
        schema.minLength(10);
        assertTrue(schema.isValid("what does the fox say"));
        assertFalse(schema.isValid("what"));
    }
    @Test
    public void testStringContains() {
        var schema = new Validator().string();
        schema.contains("not");
        assertFalse(schema.isValid("what does the fox say"));
        schema.contains("does");
        assertTrue(schema.isValid("what does the fox say"));
    }
    @Test
    public void testStringPriority() {
        var schema = new Validator().string();
        assertTrue(schema.minLength(10).minLength(4).isValid("Hexlet"));
    }

    @Test
    public void testNumbersStart() {
        var schema = new Validator().number();
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(null));
    }

    @Test
    public void testNumbersRequired() {
        var schema = new Validator().number();
        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(10));
    }
    @Test
    public void testNumbersPositive() {
        var schema = new Validator().number();
        schema.positive();
        assertFalse(schema.isValid(-10));
        assertTrue(schema.isValid(10));
        }
    @Test
    public void testNumbersRange() {
        var schema = new Validator().number();
        schema.range(5, 10);
        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
    }


    @Test
    public void testMapStart() {
        var schema = new Validator().map();
        assertTrue(schema.isValid(null));
    }

    @Test
    public void testMapRequired() {
        var schema = new Validator().map();
        schema.required();
        assertFalse(schema.isValid(null)); // false
        assertTrue(schema.isValid(new HashMap<>())); // true

    }
    @Test
    public void testMapSizeof() {
        var schema = new Validator().map();
        var data = new HashMap<String, String>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data)); // true

        schema.sizeof(2);
        assertFalse(schema.isValid(data));  // false

        data.put("key2", "value2");
        assertTrue(schema.isValid(data)); // true
    }

}
