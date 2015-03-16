package no.hiof.adrian.ryper_hecipes;

import android.media.Image;

/**
 * Created by adrian on 3/14/2015.
 */
public class Recipe {

    public int id;
    public String name;
    public String description;
    public String instructions;
    public Boolean favorite;
    public int difficulty;
    private String created_at;
    private String updated_at;
    private BasicPhotoInfo photo;
    public int key;
//    public enum difficulty {One, Two, Three};

    public Recipe(String name, int difficulty) {
        this.name = name;
        this.difficulty = difficulty;
    }

    /**
     *
     * @param id
     * @param name
     * @param description
     * @param instructions
     * @param favorite
     * @param difficulty
     * @param created_at
     * @param updated_at
     * @param url
     * @param thumbUrl
     */
    public Recipe(int id, String name, String description, String instructions, Boolean favorite, int difficulty, String created_at, String updated_at, String url, String thumbUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.instructions = instructions;
        this.favorite = favorite;
        this.difficulty = difficulty;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.photo = new BasicPhotoInfo(url, thumbUrl);
    }

    /**
     *  With no external sources to rely on, the standard Recipe is whatever we believe it is
     */
    public Recipe() {
        this.name = "Creativity";
        this.difficulty = 3;
        this.description = "The most interesting result comes from within, from what we can create when our source of inspiration is our own creativity";
        this.instructions = "Figure something out";
    }

    @Override
    public String toString(){
        return this.name;
    }
}
