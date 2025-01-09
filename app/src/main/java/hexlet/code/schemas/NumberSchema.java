package hexlet.code.schemas;

import java.util.Objects;

import static hexlet.code.schemas.BaseSchema.nameOfTest.*;

public class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        addNewFunc(REQUIRED, Objects::nonNull);
        return this;
    }
    public NumberSchema positive() {
        addNewFunc(POSITIVE, (x) -> (x > 0) || (x == null) );
        return this;
    }
    public NumberSchema range(int min, int max) {
        addNewFunc(RANGE, (x) -> ((x >= min) && (x <= max)) || (x == null));
        return this;
    }
}
