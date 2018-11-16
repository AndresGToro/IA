package com.example.hp15ay030.opencv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.JavaCameraView;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class BordesActivity extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener2{

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

        cameraBridgeViewBase = new JavaCameraView(this, CameraBridgeViewBase.CAMERA_ID_ANY);
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
    public void onCameraViewStarted(int width, int height) {

    }

    @Override
    public void onCameraViewStopped() {

    }


    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {

        Mat src = inputFrame.gray(); // convertir a escala de grises
        Mat cannyEdges = new Mat();  // objeto para almacenar el resultado

        // aplicar el algoritmo canny para detectar los bordes
        Imgproc.Canny(src, cannyEdges, 10, 100);

        // devolver el objeto Mat procesado
        return cannyEdges;
    }
}
