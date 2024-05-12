
package saves.faradaycode.components;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import org.firstinspires.ftc.robotcore.external.hardware.camera.BuiltinCameraDirection;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

import java.util.List;

import saves.faradaycode.deviceNames;

//IMPORTANT!!!!!! add your tflite modules to FtcRobotController.assets
public class tFodPipeline implements deviceNames {

    public String webCam = webCamName;
    protected static final boolean USE_WEBCAM = true;
    public TfodProcessor tfod;
    protected VisionPortal visionPortal;
    private static final String BLUE_TFOD_MODEL_ASSET = blueAsset;
    private static final String[] BLUE_LABELS = {
            blueLabel,
    }   ;

    private static final String RED_TFOD_MODEL_ASSET = redAsset;
    private static final String[] RED_LABELS = {
            redLabel,
    }   ;

    public void telemetryTfod() {

        List<Recognition> currentRecognitions = tfod.getRecognitions();
        telemetry.addData("# Objects Detected", currentRecognitions.size());

        // Step through the list of recognitions and display info for each one.
        for (Recognition recognition : currentRecognitions) {
            double x = (recognition.getLeft() + recognition.getRight()) / 2 ;
            double y = (recognition.getTop()  + recognition.getBottom()) / 2 ;

            telemetry.addData(""," ");
            telemetry.addData("Image", "%s (%.0f %% Conf.)", recognition.getLabel(), recognition.getConfidence() * 100);
            telemetry.addData("- Position", "%.0f / %.0f", x, y);
            telemetry.addData("- Size", "%.0f x %.0f", recognition.getWidth(), recognition.getHeight());
        }   // end for() loop

    }   // end method telemetryTfod()*/

    public void initTfod(boolean isBlue) {

        // Create the TensorFlow processor by using a builder.
        if (isBlue) {
            tfod = new TfodProcessor.Builder()
                    .setModelAssetName(BLUE_TFOD_MODEL_ASSET)
                    .setModelLabels(BLUE_LABELS)
                    .build();
        } else {
            tfod = new TfodProcessor.Builder()
                    .setModelAssetName(RED_TFOD_MODEL_ASSET)
                    .setModelLabels(RED_LABELS)
                    .build();
        }

        // Create the vision portal by using a builder.
        VisionPortal.Builder builder = new VisionPortal.Builder();

        // Set the camera (webcam vs. built-in RC phone camera).
        if (USE_WEBCAM) {
            builder.setCamera(hardwareMap.get(WebcamName.class, webCam));
        } else {
            builder.setCamera(BuiltinCameraDirection.BACK);
        }
        builder.addProcessor(tfod);

        visionPortal = builder.build();
    }
    /*
    * List<Recognition> currentRecognitions;
        currentRecognitions = tFod.tfod.getRecognitions();

        if (currentRecognitions.size() != 0) {blahblahblah}*/

}
