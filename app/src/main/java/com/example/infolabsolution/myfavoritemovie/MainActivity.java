package com.example.infolabsolution.myfavoritemovie;

import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import static com.example.infolabsolution.myfavoritemovie.DataContract.CONTENT_URI;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>, AdapterView.OnClickListener{

    private AdapterFavorite favoriteAdapter;

    private final int LOAD_FAVORITE_ID = 111;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =(ListView)findViewById(R.id.list_movie);
        favoriteAdapter = new AdapterFavorite(this, null, true);
        listView.setAdapter(favoriteAdapter);

        getSupportLoaderManager().initLoader(LOAD_FAVORITE_ID, null, this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getSupportLoaderManager().destroyLoader(LOAD_FAVORITE_ID);
    }

    @Override
    public void onClick(View view) {

    }
    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        favoriteAdapter.swapCursor(data);
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, CONTENT_URI, null, null, null, null);
    }


    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        favoriteAdapter.swapCursor(null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getSupportLoaderManager().restartLoader(LOAD_FAVORITE_ID, null, this);
    }

}