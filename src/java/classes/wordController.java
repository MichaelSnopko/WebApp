/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import classes.Word;
import classes.DBUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;

/**
 *
 * @author c0638820
 */
@ApplicationScoped
public class wordController {

    private List<Word> words;
    private Word currentWord = new Word();

    //List<String> myArrayList = new ArrayList<String>();
    //String[] myArray = myArrayList.toArray(new String[myArrayList.size()]);
    public wordController() {
        currentWord = new Word(0, "", "", "");
        getDBUtils();
    }

    private void getDBUtils() {

        try {
            words.clear();
            Connection conn = DBUtils.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM words");
            while (rs.next()) {
                Word w = new Word();
                w.setWordId(rs.getInt("wordId"));
                w.setTitle(rs.getString("title"));
                w.setDescription(rs.getString("description"));
                w.setCategory(rs.getString("category"));
                words.add(w);
            }
        } catch (SQLException ex) {
            Logger.getLogger(wordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Word> getAll() {
        return words;
    }

    public JsonArray getAllJson() {
        return null;
    }

    public Word getById(int id) {
        Word result = null;
        for (Word w : words) {
            if (w.getWordId() == id) {
                result = w;
            }
        }
        return null;
    }

    public JsonObject getByIdJson(int id) {
        return getById(id).toJson();
    }

    public JsonArray getBySearchJson() {
        JsonArrayBuilder json = Json.createArrayBuilder();
        for (Word w : words) {
            json.add(w.toJson());
        }
        return json.build();
    }

    public JsonObject addJson(JsonObject json) {
        Word w = new Word(json);
        getDBUtils();
        words.add(w);
        return w.toJson();
    }

    public JsonObject editJson(int id, JsonObject json) {
        return null;
    }

}
