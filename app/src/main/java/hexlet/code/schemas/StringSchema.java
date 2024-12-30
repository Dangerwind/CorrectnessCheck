package hexlet.code.schemas;

import javax.sound.midi.Soundbank;
import java.util.function.Predicate;

import static hexlet.code.schemas.ShareData.nameOfTest.*;

public class StringSchema extends ShareData{

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
