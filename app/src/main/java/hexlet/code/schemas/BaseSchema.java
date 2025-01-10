package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    // все возможные ключи проверок
    public enum NameOfTests {
        REQUIRED, MIN_LENGTH, CONTAINS, POSITIVE, RANGE, SIZEOF, SHAPE
    }

    //
    private final Map<NameOfTests, Predicate<T>> mapOfTest = new LinkedHashMap<>();

    //  в мэпу закидываем лямбды проверок
    public void addNewFunc(NameOfTests key, Predicate<T> value) {
        mapOfTest.put(key, value);
    }

    // проходим по всей мэпе, дергаем все лямбды с тестовым параметром
    public boolean isValid(T testData) {
        for (Predicate<T> i : mapOfTest.values()) {
            if (!i.test(testData)) {
                return false;
            }
        }
        return true;
    }
}
