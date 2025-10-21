import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.MetadataException;
import com.drew.metadata.jpeg.JpegDirectory;
import org.junit.Test;
import uy.growbox.apimodel.Message;
import uy.growbox.apimodel.messages.OutputMessage;
import uy.growbox.apimodel.messages.StatusMessage;
import uy.growbox.apimodel.utilities.MetadataExtractor;
import uy.growbox.apimodel.valuetypes.GrowPeriodBean;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MessageTest {
    final static GrowPeriodBean growPeriodBean = new GrowPeriodBean(1, "test_grow", 2, 10, 10, 5, 8,
            2, null, 10, 2, 2, 10, Message.GrowPeriodState.FINISHED.toString());

    @Test
    public void verifyStatusMessageToJson() {
        final StatusMessage statusMessage = new StatusMessage(growPeriodBean, 1, 10,
                "30", "90", "5", "0", true, true, false,
                Message.GrowPeriodState.GROWING, "vegetation", false);

        String json = statusMessage.toJson();
        System.out.println(json);
        System.out.println(statusMessage);
        StatusMessage fromJson = (StatusMessage) Message.fromJson(json, StatusMessage.class);
        assertEquals(statusMessage.humidity, fromJson.humidity);
    }

    @Test
    public void verifyOutputMessage() {

        String json = "{\n" +
                "                                                                                                      \"inputOutputId\": \"lights\",\n" +
                "                                                                                                      \"state\": true,\n" +
                "                                                                                                      \"type\": \"OUTPUT_MESSAGE\"\n" +
                "                                                                                                    }";
        System.out.println(json);
        OutputMessage fromJson = (OutputMessage) Message.fromJson(json, OutputMessage.class);
        assertTrue(fromJson.state);
    }


    @Test
    public void verifyStatusMessageWithNullFan2ToJson() {
        final StatusMessage statusMessage = new StatusMessage(growPeriodBean, 1, 10,
                "30", "90", "5", "0", true, true, false,
                Message.GrowPeriodState.GROWING, "vegetation", null);

        String json = statusMessage.toJson();
        System.out.println(json);
        System.out.println(statusMessage);
        StatusMessage fromJson = (StatusMessage) Message.fromJson(json, StatusMessage.class);
        assertEquals(statusMessage.humidity, fromJson.humidity);
    }


    @Test
    public void verifyPictureWidthMetadataExtractor() throws ImageProcessingException, IOException, MetadataException {
        final String file = getClass().getResource("/pi_cam_v1.jpg").getFile();
        final JpegDirectory metadata = MetadataExtractor.extractMetadata(new File(file));
        System.out.println(metadata.getName());
        final int imageWidth = metadata.getImageWidth();
        final int imageHeight = metadata.getImageHeight();
        System.out.println("v1 image width " + imageWidth);
        assertEquals(2592, imageWidth);
        assertEquals(1944, imageHeight);
    }

    //TODO add hq camera test and image


    @Test
    public void verifyV2CameraPictureWidthMetadataExtractor() throws ImageProcessingException, IOException, MetadataException {

        final String file = getClass().getResource("/pi_cam_v2.jpg").getFile();
        final JpegDirectory metadata = MetadataExtractor.extractMetadata(new File(file));
        System.out.println(metadata.getName());
        final int imageWidth = metadata.getImageWidth();
        final int imageHeight = metadata.getImageHeight();
        System.out.println("v1 image width " + imageWidth);
        assertEquals(3280, imageWidth);
        assertEquals(2464, imageHeight);
    }


}
