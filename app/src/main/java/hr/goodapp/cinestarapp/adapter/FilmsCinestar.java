package hr.goodapp.cinestarapp.adapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.graphics.drawable.DrawableWrapper;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import hr.goodapp.cinestarapp.R;

/**
 * Created by User on 7.2.2016..
 */
public class FilmsCinestar extends RecyclerView.Adapter<FilmsCinestar.ViewHolderFilms> {


    public static class ViewHolderFilms extends RecyclerView.ViewHolder {

        CardView cardView;
        RatingBar ratingBar;

        public ViewHolderFilms(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.card_view);
            ratingBar = (RatingBar) itemView.findViewById(R.id.ratingBar);


        }
    }

    @Override
    public ViewHolderFilms onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.films_cinestar,parent,false);

        ViewHolderFilms viewHolderFilms  = new ViewHolderFilms(view);

        LayerDrawable drawable = (LayerDrawable) viewHolderFilms.ratingBar.getProgressDrawable();

        Drawable wrapDrawable = DrawableCompat.wrap(drawable);

        DrawableCompat.setTint(wrapDrawable,parent.getResources().getColor(R.color.cardview_light_background));
        viewHolderFilms.ratingBar.setProgressDrawable(wrapDrawable);
        return viewHolderFilms;
    }

    @Override
    public void onBindViewHolder(ViewHolderFilms holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 7;
    }


}
