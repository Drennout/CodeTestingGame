import com.app.entities.Player;
import com.app.game.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest extends Assertions {
    List<Player> resultPlayers;
    int current_id;
    String resultOfGame;

    @BeforeEach
    public void setup(){
        resultPlayers = new ArrayList<>();
        resultPlayers.add(new Player(1, "p1", 1));
        resultPlayers.add(new Player(2, "p2", 0));
        current_id = 1;
        resultOfGame = "Выиграл игрок p1 со счетом 1:0";
    }

    @Test
    public void addScoreTest(){
        Game game = new Game();
        List<Player> testPlayers = new ArrayList<>();
        testPlayers.add(new Player(1, "p1", 0));
        testPlayers.add(new Player(2, "p2", 0));

        game.addScore(current_id, testPlayers);

        assertEquals(testPlayers.get(0).getScore(), resultPlayers.get(0).getScore());
        assertEquals(testPlayers.get(1).getScore(), resultPlayers.get(1).getScore());
    }

    @Test
    public void resultOfGameTest(){
        Game game = new Game();
        game.setPlayers(resultPlayers);

        assertEquals(game.resultsOfGame(), resultOfGame);
    }
}
