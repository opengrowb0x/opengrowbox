package persistence.config;


public class GrowboxConstants {
    public static final int DEFAULT_PHOTO_PERIOD = 6;
    public static final long MAX_DAILY_PICTURES_IN_MESSAGE = 5;
    public static final String GROWBOX_HOME_PI = "/opt/growbox-control";

    public static final String GROWBOX_HOME_DEV_LINUX_MODULE = "control/src/test/resources/growbox2";

    public static final String IMAGES_RELATIVE_PATH = "/images";
    public static final String CURRENT_PICTURE_RELATIVE_PATH = IMAGES_RELATIVE_PATH + "/current.jpg";
    public static final String DAILY_PICTURES_RELATIVE_PATH = IMAGES_RELATIVE_PATH + "/daily";
    public static final String GROW_PERIOD_RELATIVE_PATH = "/growPeriods";
    public static final String GROWBOX_DATABASE_RELATIVE_PATH = "/growbox.db";
    public static final String GROWBOX_EMPTY_CONFIG_RELATIVE_PATH = "/config_initial.properties";
    public static final String GROWBOX_CONFIG_RELATIVE_PATH = "/config.properties";
    public static final String GROWBOX_EMPTY_DATABASE_RELATIVE_PATH = "/growbox_initial.db";

    public static String getDbUrl(String homeDirectory) {
        return "jdbc:sqlite:" + homeDirectory + "/growbox.db";
    }


}

