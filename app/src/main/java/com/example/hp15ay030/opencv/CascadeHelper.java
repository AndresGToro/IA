package com.example.hp15ay030.opencv;

import android.content.Context;
import java.io.FileOutputStream;

import java.io.File;
import java.io.InputStream;

public class CascadeHelper {

    public static String generateXmlPath(Context ctx, int id) {
        try {

            InputStream is = ctx.getResources().openRawResource(id);

            File cascadeDir = ctx.getDir("cascade", Context.MODE_PRIVATE);
            File mCascadeFile = new File(cascadeDir, "cascade.xml");
            FileOutputStream os = new FileOutputStream(mCascadeFile);

            byte[] buffer = new byte[4096];
            int bytesRead = 0;

            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }

            is.close();
            os.close();

            return mCascadeFile.getAbsolutePath();

        } catch (Exception e) {
            return null;
        }
    }
}
