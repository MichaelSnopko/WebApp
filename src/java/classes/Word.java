/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import javax.json.Json;
import javax.json.JsonObject;
/**
 *
 * @author c0638820
 */
public class Word {
    private int wordId;
    private String description;
    private String title;
    private String category;
    
    public Word(){
    
    }

    public Word(int wordId, String description, String title, String category) {
        this.wordId = wordId;
        this.description = description;
        this.title = title;
        this.category = category;
    }
    
    public Word(JsonObject json){
    wordId = json.getInt("wordId", 0);
    description = json.getString("description", "");
    title = json.getString("title", "");
    category = json.getString("category", "");
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getWordId() {
        return wordId;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }
    
    public JsonObject toJson(){
    return Json.createObjectBuilder()
            .add("wordId", wordId)
            .add("description", description)
            .add("title", title)
            .add("category", category)
            .build();  
    }
}
