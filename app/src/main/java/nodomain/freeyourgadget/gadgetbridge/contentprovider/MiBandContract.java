package nodomain.freeyourgadget.gadgetbridge.contentprovider;

import android.net.Uri;

import nodomain.freeyourgadget.gadgetbridge.entities.MiBandActivitySampleDao;

public final class MiBandContract {
    public static final String AUTHORITY = "com.getmiband.android.provider";
    public static final Uri URI = Uri.parse("content://" + AUTHORITY + "/miBand");
    public static final String TIMESTAMP = MiBandActivitySampleDao.Properties.Timestamp.columnName;
    public static final String DEVICE_ID = MiBandActivitySampleDao.Properties.DeviceId.columnName;
    public static final String USER_ID = MiBandActivitySampleDao.Properties.UserId.columnName;
    public static final String RAW_INTENSITY = MiBandActivitySampleDao.Properties.RawIntensity.columnName;
    public static final String RAW_KIND = MiBandActivitySampleDao.Properties.RawKind.columnName;
    public static final String STEPS = MiBandActivitySampleDao.Properties.Steps.columnName;
    public static final String HEART_RATE = MiBandActivitySampleDao.Properties.HeartRate.columnName;
}