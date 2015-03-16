package no.hiof.adrian.ryper_hecipes;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



/**
 * A fragment representing a single Recipe detail screen.
 * This fragment is either contained in a {@link RecipeListActivity}
 * in two-pane mode (on tablets) or a {@link RecipeDetailActivity}
 * on handsets.
 */
public class RecipeDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The content this fragment is presenting.
     */
    private Recipe mItem;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RecipeDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            String str = getArguments().getString(ARG_ITEM_ID);
            // Load the content specified by the fragment
            // arguments.
            mItem = Content.ITEMS.get(Integer.parseInt(str));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recipe_detail, container, false);

        // Show the content as text in a TextView. This is what the user actually sees, and should
        // therefore be improved further
        if (mItem != null) {
            if(mItem.difficulty == 1)
                container.setBackgroundColor(Color.BLUE);
            else if(mItem.difficulty == 3)
                container.setBackgroundColor(Color.RED);
            else container.setBackgroundColor(Color.GREEN);
            String fav = mItem.favorite?"Yes":"No";
            String how = mItem.instructions.length() > 1?mItem.instructions:" Who knows? ";
            ((TextView) rootView.findViewById(R.id.recipe_detail)).setText(mItem.description +"\n"+"Favorite: "+fav+"\n\n"+"How to: "+how);
        }

        return rootView;
    }
}
