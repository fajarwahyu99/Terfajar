package com.example.infolabsolution.myfavoritemovie;

import com.example.infolabsolution.myfavoritemovie.DataContract;
import static com.example.infolabsolution.myfavoritemovie.DataContract.getColumnInt;
import static com.example.infolabsolution.myfavoritemovie.DataContract.getColumnString;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;



public class FavoriteMovie implements Parcelable{
    private int id;
    private String title;
    private String ratings;
    private String release_date;
    private String overview;
    private String banner;
    private String poster;

    public FavoriteMovie(Parcel in) {
        title = in.readString();
        ratings = in.readString();
        release_date = in.readString();
        overview = in.readString();
        banner = in.readString();
        poster = in.readString();
        id= in.readInt();
    }

    public FavoriteMovie(Cursor cursor){
        this.id = getColumnInt(cursor, DataContract.FavoColumn._ID);
        this.title = getColumnString(cursor, DataContract.FavoColumn.MOVIE_TITLE);
        this.overview = getColumnString(cursor, DataContract.FavoColumn.OVERVIEW);
        this.release_date = getColumnString(cursor, DataContract.FavoColumn.RELEASE_DATE);
        this.ratings = getColumnString(cursor, DataContract.FavoColumn.RATING);
        this.banner = getColumnString(cursor, DataContract.FavoColumn.IMAGE_MOVIE);
        this.poster = getColumnString(cursor, DataContract.FavoColumn.POSTER);
    }

    public static final Parcelable.Creator<FavoriteMovie> CREATOR = new Parcelable.Creator<FavoriteMovie>() {
        @Override
        public FavoriteMovie createFromParcel(Parcel in) {
            return new FavoriteMovie(in);
        }

        @Override
        public FavoriteMovie[] newArray(int size) {
            return new FavoriteMovie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel teks, int flags) {
        teks.writeString(title);
        teks.writeString(ratings);
        teks.writeString(release_date);
        teks.writeString(overview);
        teks.writeString(banner);
        teks.writeString(poster);
        teks.writeInt(id);
    }
    public FavoriteMovie() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return ratings;
    }

    public void setRating(String ratings) {
        this.ratings = ratings;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Parcelable.Creator<FavoriteMovie> getCREATOR() {
        return CREATOR;
    }


}
