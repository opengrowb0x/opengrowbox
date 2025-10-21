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

    private static Logger log = Logger.getLogger(MetadataExtractor.class.getSimpleName());

    public static LocalDate extractDateFromMetadata(File sourceImage) {
		final JpegDirectory directory;
		try {
			directory = extractMetadata(sourceImage);
			Date date = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
			if (date != null) {
				LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				return localDate;
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
            final JpegDirectory jpegDirectory = (JpegDirectory) metadata.getDirectories().iterator().next();
            return jpegDirectory;

        } catch (IOException e) {
            log.warning("Could not extract exif data. Skipping extraction: "
                    + e.getMessage());
            throw e;
        }
    }


    public static byte[] getImageBytes(File imgPath) {
        try {
            if (imgPath != null && imgPath.exists()) {
                final byte[] imageBytes = Files.readAllBytes(imgPath.toPath());
                return imageBytes;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}