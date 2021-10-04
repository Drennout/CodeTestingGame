import com.app.entities.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

public class LevelTest extends Assertions {
    Level resultLevel;
    File testingFile;

    @BeforeEach
    public void setup(){
        resultLevel = new Level();
        resultLevel.setContent("1. public static void main(String[] args) {\n" +
                "2.        if (a = b)\n" +
                "3.    }\n");
        resultLevel.setAnswer("2. if (a == b)");
        testingFile = new File("game/levels/level1.txt");
    }

    @Test
    public void parseLevelTest(){
        Level testLevel = new Level(testingFile);

        //Checking result answer and testing answer
        assertEquals(resultLevel.getAnswer(), testLevel.getAnswer());

        //Checking result content and testing content
        assertEquals(resultLevel.getContent(), testLevel.getContent());
    }

}
