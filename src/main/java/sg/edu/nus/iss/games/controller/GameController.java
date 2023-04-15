package sg.edu.nus.iss.games.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.JsonObject;
import sg.edu.nus.iss.games.model.Game;
import sg.edu.nus.iss.games.model.Games;
import sg.edu.nus.iss.games.service.GamesService;

@RestController
public class GameController {
    
    @Autowired 
    private GamesService gamesService;

    @GetMapping(path= "/games")
    public ResponseEntity<String> getAllGames(@RequestParam(defaultValue="25") Integer limit,
                                              @RequestParam(defaultValue = "0") Integer offset){
        
        List<Game> listOfAllGames = gamesService.getAllGames(limit, offset);
        Games games = gamesService.getGamesInfo(listOfAllGames, limit, offset);

        JsonObject result = Games.createJsonObject(games);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result.toString());
                                               
    }

    @GetMapping(path= "/games/rank")
    public ResponseEntity<String> getGamesByRank(@RequestParam(defaultValue="25") Integer limit,
                                              @RequestParam(defaultValue = "0") Integer offset){
        
        List<Game> listOfAllGames = gamesService.getGamesByRank(limit, offset);
        Games games = gamesService.getGamesInfo(listOfAllGames, limit, offset);

        JsonObject result = Games.createJsonObject(games);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result.toString());
                                               
    }

    @GetMapping(path= "/games/{id}")
    public ResponseEntity<String> getGameId(@PathVariable Integer id){
        
        Game game = gamesService.getGameById(id);
      
        JsonObject result = Game.createJsonObject(game);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result.toString());
                                               
    }

}
