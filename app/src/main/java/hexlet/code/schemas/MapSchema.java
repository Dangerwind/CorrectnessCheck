package hexlet.code.schemas;


import java.util.Map;
import java.util.Objects;

import static hexlet.code.schemas.BaseSchema.NameOfTests.REQUIRED;
import static hexlet.code.schemas.BaseSchema.NameOfTests.SIZEOF;
import static hexlet.code.schemas.BaseSchema.NameOfTests.SHAPE;
//import static hexlet.code.schemas.BaseSchema.nameOfTest.*;

public class MapSchema extends BaseSchema<Map> {

    public MapSchema required() {
        addNewFunc(REQUIRED, Objects::nonNull);
        return this;
    }
    public MapSchema sizeof(int mapSize) {
        addNewFunc(SIZEOF, (x) -> x.size() == mapSize);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> mapShape) {
       // закидываем лямбду в которой метод в котором проверяем все правила по каждому String'у
        addNewFunc(SHAPE, (x) -> mapShapeTest(x, mapShape));
        return this;
    }
    private boolean mapShapeTest(Map<String, BaseSchema<String>> paramMap, Map<String, BaseSchema<String>> mapShape) {
        if (paramMap  == null) {
            return true;
        }

        for (var itr : mapShape.entrySet()) {
            var key = itr.getKey();  // получили ключ по которому потом получим строку для проверки
            var value = itr.getValue(); // и набор правил который накидали в shape
            //
            var testString = (String) ((Object) paramMap.get(key)); // получили строку, которую проверяем

            if (!value.isValid(testString)) {
                return false;
            }
        }
        return true;
    }

}
