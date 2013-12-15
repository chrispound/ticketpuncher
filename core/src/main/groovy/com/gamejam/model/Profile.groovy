package com.gamejam.model

import com.badlogic.gdx.utils.Json
import com.badlogic.gdx.utils.OrderedMap

/**
 * Created by Chris on 12/15/13.
 */

public class Profile implements Serializable {
    private int currentLevelId;
    private int credits;
    private ArrayList<Integer> highScores;

    public Profile() {
        highScores = new ArrayList<Integer>();
    }

    /**
     * Retrieves the high scores for each level (Level-ID -> High score).
     */
    public Map<Integer, Integer> getHighScores() {
        return highScores;
    }

    /**
     * Compare all high scores. insert and move the rest down.
     */
    public boolean notifyScore(int score) {
        for (int f = 0; f < highScores.size(); f++) {
            if (score > highScores.get(f)) {
                highScores.add(f, score)
                highScores.remove(highScores.size() - 1)
                return true
            }
        }
        return false;
    }

    /**
     * Retrieves the amount of credits the player has.
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Retrieves the amount of credits as text.
     */
    public String getCreditsAsText() {
        return TextUtils.creditStyle(credits);
    }

    // Serializable implementation

    @SuppressWarnings("unchecked")
    @Override
    public void read(
            Json json,
            OrderedMap<String, Object> jsonData) {
        // read the some basic properties
//        credits = json.readValue("credits", Integer.class, jsonData);

        // libgdx handles the keys of JSON formatted HashMaps as Strings, but we
        // want it to be an integer instead (levelId)
        ArrayList<Integer> highScores = json.readValue("highScores", ArrayList.class,
                Integer.class, jsonData);
        this.highScores = highScores

    }

    @Override
    public void write(
            Json json) {
//        json.writeValue("credits", credits);
        json.writeValue("highScores", highScores);
    }
}
