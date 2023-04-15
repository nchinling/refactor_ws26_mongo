package sg.edu.nus.iss.games.model;

import org.bson.Document;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Game {
    
    private Integer gid;
    private String name;
    private Integer year;
    private Integer ranking;
    private Integer userRated;
    private String url;
    private String image;
    
    public Game() {
    }

    public Game(Integer gid, String name, Integer year, Integer ranking, Integer userRated, String url, String image) {
        this.gid = gid;
        this.name = name;
        this.year = year;
        this.ranking = ranking;
        this.userRated = userRated;
        this.url = url;
        this.image = image;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getUserRated() {
        return userRated;
    }

    public void setUserRated(Integer userRated) {
        this.userRated = userRated;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Game [gid=" + gid + ", name=" + name + ", year=" + year + ", ranking=" + ranking + ", userRated="
                + userRated + ", url=" + url + ", image=" + image + "]";
    }

   
    public static Game create(Document doc){
        
        Game game = new Game();
        game.setGid(doc.getInteger("gid"));
        game.setName(doc.getString("name"));
        game.setYear(doc.getInteger("year"));
        game.setRanking(doc.getInteger("ranking"));
        game.setUserRated(doc.getInteger("users_rated"));
        game.setUrl(doc.getString("url"));
        game.setImage(doc.getString("image"));

        return game;
    }

    public static JsonObject createJsonObject(Game game){

        return Json.createObjectBuilder()
            .add("Game", game.toJson())
            .build();
    }

    private JsonObject toJson(){
        return Json.createObjectBuilder()
        .add("game_id", getGid())
        .add("name", getName())
        .add("year", getYear())
        .add("ranking", getRanking())
        .add("users_rated", getUserRated() == null? 0:getUserRated())
        .add("url", getUrl())
        .add("thumbnail", getImage())
        // .add("timestamp", getTimestamp().toString())a
        .build();
    }

}
