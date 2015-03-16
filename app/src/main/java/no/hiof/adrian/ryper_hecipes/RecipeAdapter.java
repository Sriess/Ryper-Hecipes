package no.hiof.adrian.ryper_hecipes;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by adrian on 3/16/2015.
 */
public class RecipeAdapter extends ArrayAdapter<Recipe> {
    private final Activity context;
    private final List<Recipe> values;

    public RecipeAdapter(Activity context, List<Recipe> recipes){
        super(context, R.layout.recipe_rowlayout, recipes);
        this.context = context;
        this.values = recipes;
    }

    static class ViewHolder {
        public TextView text;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View rowView = convertView;
        //reuse views to avoid unnecessary calls to findViewById()
        if(rowView == null){
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.recipe_rowlayout, null);

            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.text = (TextView) rowView.findViewById(R.id.text1);
            rowView.setTag(viewHolder);
        }

        // fill with data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.text.setText(values.get(position).name);

        // Set star icon for all favorites
        if(values.get(position).favorite) {
            holder.text.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_star, 0);
        }
        else {
            holder.text.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }

        return rowView;
    }
}
