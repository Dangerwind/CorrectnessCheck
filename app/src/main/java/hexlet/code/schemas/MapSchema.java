package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

import static hexlet.code.schemas.BaseSchema.nameOfTest.*;
public class MapSchema extends BaseSchema<Map>{

    public MapSchema required() {
        addNewFunc(REQUIRED, Objects::nonNull);
        return this;
    }
    public MapSchema sizeof(int mapSize) {
        addNewFunc(SIZEOF, (x) -> x.size() == mapSize);
        return this;
    }

}
