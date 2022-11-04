package arifjehoh.open.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ServiceTest {

    @Test
    void reverseString() {
        String[][] texts = {{"rice", "ecir"}, {"snake", "ekans"}, {"pop", "pop"}, {"123", "321"},};
        for (String[] text : texts) {
            Assertions.assertEquals(text[0], Service.reverseString(text[1]));
        }
    }
}