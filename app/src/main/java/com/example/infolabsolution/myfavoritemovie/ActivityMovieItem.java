package com.example.infolabsolution.myfavoritemovie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityMovieItem extends AppCompatActivity {


    @BindView(R.id.overview)
    TextView overview;
    @BindView(R.id.release_date)
    TextView release_note;
    @BindView(R.id.sharebtn)
    Button shareBtn;

    private boolean isFavorite = false;
    private int favorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_item);
        ButterKnife.bind(this);


        final ModelMovie filmMovie = getIntent().getParcelableExtra(BuildConfig.EXTRA_MOVIE);
        release_note.setText(filmMovie.getRelease_date());
        overview.setText(filmMovie.getOverview());
        ImageView imageBanner = (ImageView) findViewById(R.id.img_banner);
        Picasso.with(this).load(filmMovie.getBanner()).into(imageBanner);


        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(android.content.Intent.EXTRA_TEXT, filmMovie.getTitle()+filmMovie.getOverview());
                startActivity(intent);
            }
        });
    }


}
