package sg.edu.nus.iss.games.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.games.model.Game;
import sg.edu.nus.iss.games.model.Games;
import sg.edu.nus.iss.games.repo.GamesRepo;

@Service
public class GamesService {
    
    @Autowired
    private GamesRepo gamesRepo;

    public List<Game> getAllGames(Integer limit, Integer offset){
        return gamesRepo.getAllGames(limit, offset);
    }

    // listOfAllGames, limit, offset
    public Games getGamesInfo(List<Game> games, Integer limit, Integer offset){
        return Games.createUserClass(games, limit, offset);
    }

    public List<Game> getGamesByRank(Integer limit, Integer offset){
        return gamesRepo.getGamesByRank(limit, offset);
    }

    public Game getGameById(Integer id){
        return gamesRepo.getGameById(id);
    }
}

