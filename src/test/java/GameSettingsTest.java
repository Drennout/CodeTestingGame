import com.app.game.GameSettings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

public class GameSettingsTest extends Assertions {
    String result;
    File testingFile;

    @BeforeEach
    public void setup(){
        result = "Rule\n" +
                "\n" +
                "Your task is to find an error in the code.\n" +
                "Whoever finds the first gets a score.\n" +
                "\n" +
                "In order to answer, enter your personal number set earlier.\n" +
                "After you have entered the number, enter the correct answer\n" +
                "by entering the line number first and then entering the correct line.\n" +
                "For example, the error looks like this :\n" +
                "4. if(a = b)\n" +
                "Then the correct answer will look like this:\n" +
                "4. if(a == b)\n";

        testingFile = new File("game/rules/rule1.txt");
    }

    @Test
    public void outputRuleTest(){
        GameSettings test = new GameSettings(0, 0, testingFile);

        assertEquals(result, test.outputRule());
    }
}
