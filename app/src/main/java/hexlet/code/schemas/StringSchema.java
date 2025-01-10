package hexlet.code.schemas;

import static hexlet.code.schemas.BaseSchema.NameOfTests.REQUIRED;
import static hexlet.code.schemas.BaseSchema.NameOfTests.MIN_LENGTH;
import static hexlet.code.schemas.BaseSchema.NameOfTests.CONTAINS;

//import static hexlet.code.schemas.BaseSchema.nameOfTest.*;

public class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        addNewFunc(REQUIRED, (x) -> (x != null) && (!x.isEmpty()));
        return this;
    }
    public StringSchema minLength(int minLen) {
        addNewFunc(MIN_LENGTH, (x) -> x.toString().length() >= minLen);
        return this;
    }
    public StringSchema contains(String contString) {
        addNewFunc(CONTAINS, (x) -> x.toString().contains(contString));
        return this;
    }
}
