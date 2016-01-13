package com.androidbegin.parseimageupload;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by Max on 11.01.2016.
 */
public class FileCache {

    private File caheDir;

    public FileCache(Context context) {
        if (android.os.Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
            caheDir = new File(android.os.Environment.getExternalStorageDirectory(),
                    "ParseImageUpload");
        else {
            caheDir = context.getCacheDir();
        }
        if (!caheDir.exists())
            caheDir.mkdirs();
    }

    public File getFile(String url) {
        String filename = String.valueOf(url.hashCode());
        File file = new File(caheDir, filename);
        return file;
    }

    public void clear() {
        File[] files = caheDir.listFiles();
        if (files == null)
            return;
        for (File f: files)
            f.delete();
    }


}
