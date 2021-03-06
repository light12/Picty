package fr.pictycompany.picty;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.MediaStore;

import java.util.ArrayList;

public class CursorPhotos extends AsyncTask<Void, Void, Boolean> {

    private Cursor mCursor;
    private ContentResolver mContent;
    private ArrayList<String> itemList;

    CursorPhotos(ContentResolver content){
        mContent = content;
    }

    @Override
    protected void onPreExecute(){

    }

    @Override
    protected Boolean doInBackground(Void... arg0) {
        mCursor = mContent.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
        mCursor.moveToFirst();
        while (!mCursor.isAfterLast()) {
            itemList.add(mCursor.getString(mCursor.getColumnIndex(MediaStore.Images.Media.DATA)));
            mCursor.moveToNext();
        }
        mCursor.close();
        return true;

    }

    @Override
    protected void onPostExecute(Boolean result){

    }
}
