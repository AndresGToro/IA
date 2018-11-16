package com.example.hp15ay030.opencv;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.WindowManager;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.JavaCameraView;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.android.OpenCVLoader;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class OpenCVCamera extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener{


    private static final String TAG = "OpenCVCamera";
    private CameraBridgeViewBase cameraBridgeViewBase=null;
    private static boolean initOpenCV = false;
    private CascadeClassifier detector = null;

    private Mat gray;


    BaseLoaderCallback mCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case BaseLoaderCallback.SUCCESS:
                {
                    cameraBridgeViewBase.enableView();
                    String path = CascadeHelper.generateXmlPath(this.mAppContext, R.raw.cars);

                    if (path!=null){
                         detector = new CascadeClassifier(path);
                        if (!detector.empty()){
                            Log.i(TAG,"cargar clasificador .xml, archivo:"+path);
                        }
                    }
                    break;
                }
                default:
                {
                    super.onManagerConnected(status);
                    break;
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        cameraBridgeViewBase = new JavaCameraView(this,CameraBridgeViewBase.CAMERA_ID_ANY);
        cameraBridgeViewBase.setVisibility(SurfaceView.VISIBLE);
        cameraBridgeViewBase.setCvCameraViewListener(this);
        cameraBridgeViewBase.enableFpsMeter();
        setContentView(cameraBridgeViewBase);

    }





    public void onResume(){
        super.onResume();

        if(!OpenCVLoader.initDebug()){
            Log.i(TAG,"Internal OpenCV library not found ");
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_4_0,this,mCallback);
        }else
        {
            Log.i(TAG,"Open Library");
            mCallback.onManagerConnected(BaseLoaderCallback.SUCCESS);
        }

    }


    @Override
    protected void onPause() {
        super.onPause();

        if (cameraBridgeViewBase != null)
            cameraBridgeViewBase.disableView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (cameraBridgeViewBase != null)
            cameraBridgeViewBase.disableView();
    }





    @Override
    public void onCameraViewStarted(int width, int height) {
        gray = new Mat();
    }

    @Override
    public void onCameraViewStopped() {
        gray.release();

    }

    @Override
    public Mat onCameraFrame(Mat src) {

        //Core.flip(src, src, 1);

        Imgproc.cvtColor(src, gray, Imgproc.COLOR_BGR2GRAY);
        Imgproc.equalizeHist(gray, gray);

        MatOfRect faces = new MatOfRect();
        if (detector != null && !detector.empty()) {
            detector.detectMultiScale(gray, faces, 1.3, 2, 2, new Size(150, 150), new Size());
        }

        for (Rect rc : faces.toList()) {
            Imgproc.rectangle(src, rc.tl(), rc.br(), new Scalar(0, 0, 255));
        }

        return src;
    }

}
