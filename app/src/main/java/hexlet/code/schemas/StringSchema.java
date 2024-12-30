package hexlet.code.schemas;

import static hexlet.code.schemas.BaseSchema.nameOfTest.*;

public class StringSchema extends BaseSchema {

    public StringSchema required() {
        addNewFunc(REQUIRED, (x) -> (x != null) && (!x.equals("")));
        return this;
    }
    public StringSchema minLength(int imnLen) {
            addNewFunc(MIN_LENGTH, (x) -> x.toString().length() >= imnLen);
        return this;
    }
    public StringSchema contains(String contString) {
        addNewFunc(CONTAINS, (x) -> x.toString().contains(contString));
        return this;
    }
}
