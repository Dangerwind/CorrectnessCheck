package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {

    // все возможные ключи (названия) проверок
    public enum nameOfTest {
        REQUIRED, MIN_LENGTH, CONTAINS, POSITIVE, RANGE, SIZEOF
    }

    //  в мэпу закидываем лямбды проверок
    private Map<nameOfTest, Predicate<T>> mapOfTest = new LinkedHashMap<>();

    public void addNewFunc(nameOfTest key, Predicate<T> value) {
        mapOfTest.put(key, value);
    }

    public boolean isValid(Object testData) {
        for(Predicate<T> i : mapOfTest.values()) {
            if (!i.test((T) testData)) {
                return false;
            }
        }
        return true;
    }
}
