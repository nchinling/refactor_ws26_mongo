package sg.edu.nus.iss.games.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Games {
    
    private Integer offset;
    private Integer limit;
    private Integer total;
    private LocalDate timestamp;
    
    private List<Game> games = new ArrayList<Game>();

    public Games() {
    }

    
    public Games(Integer offset, Integer limit, Integer total, LocalDate timestamp, List<Game> games) {
        this.offset = offset;
        this.limit = limit;
        this.total = total;
        this.timestamp = timestamp;
        this.games = games;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    @Override
    public String toString() {
        return "Games [offset=" + offset + ", limit=" + limit + ", total=" + total + ", timestamp=" + timestamp
                + ", games=" + games + "]";
    }

    public static Games createUserClass(List<Game> gameslist, Integer limit, Integer offset){

        Games games = new Games();
        games.setGames(gameslist);
        games.setLimit(limit);
        games.setOffset(offset);
        games.setTotal(gameslist.size());
        games.setTimestamp(LocalDate.now());

        return games;
    }

    public static JsonObject createJsonObject(Games games){

        return Json.createObjectBuilder()
            .add("List of games", games.toJson())
            .build();
    }

    private JsonObject toJson(){
        return Json.createObjectBuilder()
        .add("games", getGames().toString())
        .add("offset", getOffset())
        .add("limit", getLimit())
        .add("total", getTotal())
        .add("timestamp", getTimestamp().toString())
        .build();
    }

    

    


}
