package com.example.g1c2movil.utils;

import static com.example.g1c2movil.utils.Constants.AUTHORITY_FILE_PROVIDER;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.ResponseBody;

public class FileHelper {

    public static Uri saveFile(ResponseBody body, String filename, Context context) {
        //TODO - Should be processed in another thread
        File imagesFolder = new File(context.getCacheDir(), "g1c2Docs");

        Uri uri = null;

        try {
            imagesFolder.mkdirs();
            File file = new File(imagesFolder, filename);
            OutputStream stream = new FileOutputStream(file);

            byte[] fileReader = new byte[4096];
            InputStream inputStream = body.byteStream();

            long fileSize = body.contentLength();
            long fileSizeDownloaded = 0;

            while (true) {
                int read = inputStream.read(fileReader);

                if (read == -1) {
                    break;
                }

                stream.write(fileReader, 0, read);

                fileSizeDownloaded += read;
                Log.d("FileHelper", "file download: " + fileSizeDownloaded + " of " + fileSize);
            }

            stream.flush();
            stream.close();
            inputStream.close();
            uri = FileProvider.getUriForFile(context, AUTHORITY_FILE_PROVIDER, file);
        } catch (IOException e) {
            Log.d(
                    "FilePRovider",
                    "IOException while trying to write file: " + e.getMessage()
            );
        }
        return uri;
    }
}
