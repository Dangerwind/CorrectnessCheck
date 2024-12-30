package hexlet.code.schemas;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class ShareData<T> {

    //  в мэпу закидываем лямбды проверок
    private Map<nameOfTest, Predicate<T>> mapOfTest = new LinkedHashMap<>();

    // все возможные ключи (названия) проверок
    public enum nameOfTest {
        REQUIRED, MIN_LENGTH, CONTAINS
    }

    public void addNewFunc(nameOfTest key, Predicate<T> value) {
        mapOfTest.put(key, value);
    }

    public boolean isValid(String testData) {
        for(Predicate<T> i : mapOfTest.values()) {
            if (!i.test((T) testData)) {
                return false;
            }
        }
        return true;
    }
}
