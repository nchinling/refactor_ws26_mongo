package sg.edu.nus.iss.games.repo;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.games.model.Game;

@Repository
public class GamesRepo {
    
    @Autowired
    MongoTemplate mongoTemplate;
    
    public List<Game> getAllGames(Integer limit, Integer offset){

        //Query class created to form a complex query.
        Query query = new Query();


        Pageable pageable = PageRequest.of(offset, limit);
        query.with(pageable);

        return mongoTemplate.find(query, Document.class, "games")
                            .stream()
                            .map(doc ->
                            Game.create(doc)).toList();
    }

    public List<Game> getGamesByRank(Integer limit, Integer offset){

        //Query class created to form a complex query.
        Query query = new Query();


        Pageable pageable = PageRequest.of(offset, limit);
        query.with(pageable).with(Sort.by(Sort.Direction.ASC, "ranking"));

        return mongoTemplate.find(query, Document.class, "games")
                            .stream()
                            .map(doc ->
                            Game.create(doc)).toList();
    }

    public Game getGameById(Integer id){

        Criteria criteria = Criteria.where("gid").is(id);
        //Query class created to form a complex query.
        Query query = Query.query(criteria);

        //working
        Document result = mongoTemplate.findOne(query, Document.class, "games");
        return Game.create(result);

        //working
        // return mongoTemplate.findOne(query, Game.class, "games");

    }
}
