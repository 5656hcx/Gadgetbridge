package nodomain.freeyourgadget.gadgetbridge.contentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import nodomain.freeyourgadget.gadgetbridge.GBApplication;
import nodomain.freeyourgadget.gadgetbridge.database.DBOpenHelper;
import nodomain.freeyourgadget.gadgetbridge.entities.MiBandActivitySampleDao;

public class MiBandContentProvider extends ContentProvider {

    private DBOpenHelper dbOpenHelper;

    private static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(MiBandContract.AUTHORITY, "miBand", 1);
    }

    @Override
    public boolean onCreate() {
        dbOpenHelper = new DBOpenHelper(getContext(), GBApplication.DATABASE_NAME, null);
        return true;
    }

    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        if (uriMatcher.match(uri) == 1) {
            SQLiteDatabase database = dbOpenHelper.getReadableDatabase();
            return database.query(MiBandActivitySampleDao.TABLENAME,
                    projection, selection, selectionArgs, null, null, sortOrder);
        }
        return null;
    }

    @Override
    public String getType(@NonNull Uri uri) {
        if (uri.getLastPathSegment() == null)
            return "vnd.android.cursor.item/vnd." + MiBandContract.AUTHORITY + ".miBand";
        else
            return "vnd.android.cursor.dir/vnd." + MiBandContract.AUTHORITY + ".miBand";
    }

    @Override
    public Uri insert(@NonNull Uri uri, ContentValues values) {
        if (uriMatcher.match(uri) == 1) {
            SQLiteDatabase database = dbOpenHelper.getWritableDatabase();
            long rowId = database.insert(MiBandActivitySampleDao.TABLENAME, null, values);
            database.close();
            return ContentUris.withAppendedId(uri, rowId);
        }
        return ContentUris.withAppendedId(uri, -1);
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int delete(@NonNull Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
