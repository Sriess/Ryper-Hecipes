package no.hiof.adrian.ryper_hecipes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by adrian on 3/14/2015.
 */
public class Content {

    public static List<Recipe> ITEMS = new ArrayList<Recipe>();



    public static void addNewRecipe(Recipe item){

        RecipeListActivity.recipeAdapter.add(item);
        item.key = RecipeListActivity.recipeAdapter.getPosition(item);
        // Would like to use item.id as index for convenience,
        // make sure there are instances of Recipes present up to
        // and including item.id
//        Recipe blankRecipe = new Recipe();
//        int count = RecipeListActivity.recipeAdapter.getCount();
//        int desiredIndex = RecipeListActivity.recipeAdapter.getItem(count-1).id;
//        for (int i = count; i <= desiredIndex; i++) {
//            RecipeListActivity.recipeAdapter.add(blankRecipe);
//        }

    }

    /**
     * Replace the currently stored recipe with the newly retrieved one
     * @param item
     */
    public static void updateData(Recipe item){
        RecipeListActivity.recipeAdapter.remove(item);
        RecipeListActivity.recipeAdapter.insert(item, item.key);
    }
}
