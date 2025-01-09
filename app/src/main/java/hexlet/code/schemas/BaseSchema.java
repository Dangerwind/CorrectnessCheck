package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {

    // все возможные ключи проверок
    public enum nameOfTest {
        REQUIRED, MIN_LENGTH, CONTAINS, POSITIVE, RANGE, SIZEOF, SHAPE
    }

    //
    private Map<nameOfTest, Predicate<T>> mapOfTest = new LinkedHashMap<>();

    //  в мэпу закидываем лямбды проверок
    public void addNewFunc(nameOfTest key, Predicate<T> value) {
        mapOfTest.put(key, value);
    }

    // проходим по всей мэпе, дергаем все лямбды с тестовым параметром
    public boolean isValid(T testData) {
        for(Predicate<T> i : mapOfTest.values()) {
            if (!i.test(testData)) {
                return false;
            }
        }
        return true;
    }
}
