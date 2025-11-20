package uy.growbox.apimodel.utilities;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.jpeg.JpegDirectory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Logger;

public class MetadataExtractor {

    private static final Logger log = Logger.getLogger(MetadataExtractor.class.getSimpleName());

    public static LocalDate extractDateFromMetadata(File sourceImage) {
        final JpegDirectory directory;
        try {
            directory = extractMetadata(sourceImage);
            Date date = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
            if (date != null) {
                return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            }
        } catch (IOException | ImageProcessingException e) {
            log.warning(" exception unable to determine date from exif data. falling back to file creation. " + e.getMessage());
            return getFileCreationDate(sourceImage.toPath());
        }
        return null;
    }

    private static LocalDate getFileCreationDate(Path file) {
        try {
            BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
            log.info("creationTime: " + attr.creationTime());
            return LocalDate.from(attr.creationTime().toInstant());
        } catch (IOException e) {
            log.warning("unable to determine file creation date.");
        }
        return null;
    }

    public static int extractImageWidth(ExifSubIFDDirectory directory) throws MetadataException {
        return directory.getInt(ExifSubIFDDirectory.TAG_EXIF_IMAGE_WIDTH);
    }

    public static int extractImageHeight(ExifSubIFDDirectory directory) throws MetadataException {
        return directory.getInt(ExifSubIFDDirectory.TAG_EXIF_IMAGE_HEIGHT);
    }

    public static JpegDirectory extractMetadata(File sourceImage) throws ImageProcessingException, IOException {
        Metadata metadata;
        try {
            metadata = ImageMetadataReader.readMetadata(sourceImage);
            return (JpegDirectory) metadata.getDirectories().iterator().next();

        } catch (IOException e) {
            log.warning("Could not extract exif data. Skipping extraction: "
                    + e.getMessage());
            throw e;
        }
    }


    public static byte[] getImageBytes(File imgPath) {
        try {
            if (imgPath != null && imgPath.exists()) {
                return Files.readAllBytes(imgPath.toPath());
            }
        } catch (IOException e) {
            log.warning("Could not get image bytes. Skipping extraction: "
                    + e.getMessage());
        }
        return null;
    }
}