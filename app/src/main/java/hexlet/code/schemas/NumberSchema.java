package hexlet.code.schemas;

import java.util.Objects;

//import static hexlet.code.schemas.BaseSchema.NameOfTests.*;
import static hexlet.code.schemas.BaseSchema.NameOfTests.REQUIRED;
import static hexlet.code.schemas.BaseSchema.NameOfTests.POSITIVE;
import static hexlet.code.schemas.BaseSchema.NameOfTests.RANGE;

public class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        addNewFunc(REQUIRED, Objects::nonNull);
        return this;
    }
    public NumberSchema positive() {
        addNewFunc(POSITIVE, (x) -> (x == null) || (x > 0));
        return this;
    }
    public NumberSchema range(int min, int max) {
        addNewFunc(RANGE, (x) -> ((x == null) || (x >= min) && (x <= max)));
        return this;
    }
}
