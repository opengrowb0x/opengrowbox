package uy.growbox.apimodel;

import com.google.gson.*;

import java.text.SimpleDateFormat;

public class Message {
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public static final SimpleDateFormat simpleDateTimeFormat = new SimpleDateFormat(DATE_TIME_PATTERN);

    public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);


// Android version
//    public static class AndroidByteArrayToBase64TypeAdapter implements JsonSerializer<byte[]>, JsonDeserializer<byte[]> {
//        @Override
//        public byte[] deserialize(JsonElement jsonElement, java.lang.reflect.Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
//            return android.util.Base64.decode(jsonElement.getAsString(), 0);
//        }
//
//        @Override
//        public JsonElement serialize(byte[] bytes, java.lang.reflect.Type type, JsonSerializationContext jsonSerializationContext) {
//            try {
//                Class androidBase64Encoder = Class.forName("android.util.Base64");
//                return new JsonPrimitive(android.util.Base64.encodeToString(bytes, 0));
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//    }

    public static class JavaByteArrayToBase64TypeAdapter implements JsonSerializer<byte[]>, JsonDeserializer<byte[]> {
        @Override
        public byte[] deserialize(JsonElement jsonElement, java.lang.reflect.Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return java.util.Base64.getDecoder().decode(jsonElement.getAsString());
        }

        @Override
        public JsonElement serialize(byte[] bytes, java.lang.reflect.Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(java.util.Base64.getEncoder().encodeToString(bytes));
        }
    }

    protected static final Gson GSON = new GsonBuilder()
//            .registerTypeHierarchyAdapter(byte[].class, findBase64Implementation())
            .setPrettyPrinting()
            .create();

    private static JsonSerializer findBase64Implementation() {
        Class<?> javaFound = null;
        try {
            javaFound = Class.forName("java.util.Base64");
            return new JavaByteArrayToBase64TypeAdapter();
        } catch (Exception e) {
            e.printStackTrace();
            //FIXME return new AndroidByteArrayToBase64TypeAdapter();
            return new JavaByteArrayToBase64TypeAdapter();
        }
    }

    public enum Type {
        // BI-DIRECTIONAL
        OUTPUT_MESSAGE,
        PICTURE_MESSAGE,
        PORT_DATA_MESSAGE,
        DAILY_PICTURES_MESSAGE,
        GROW_PERIODS,
        TEXT_MESSAGE,
        DAILY_DATA_MESSAGE,

        //SERVER TO CLIENT
        STATUS_MESSAGE, //status message will be sent from IoT device to clients

        //CLIENT TO SERVER
        CONTROL_COMMAND,
        TAKE_PICTURE_MESSAGE,
        STREAM_VIDEO_MESSAGE,
        READ_INPUT,
        START_GROWING,
        MOVE_CAMERA,
        FINISH_GROWING,
        UPDATE_GROW_PERIOD,
        UPDATE_CONFIG;
    }

    public final Type type;

    public final String message;

    public Message(Type type) {
        this.type = type;
        this.message = null;
    }

    public Message(Type type, String message) {
        this.type = type;
        this.message = message;
    }

    public String toJson() {
        return GSON.toJson(this, this.getClass());
    }

    public static Message fromJson(String json) {
        return GSON.fromJson(json, Message.class);
    }

    public static Message fromJson(String json, java.lang.reflect.Type type) {
        return GSON.fromJson(json, type);
    }

    public enum GrowPeriodState {
            GROWING,
            FINISHED,
            PAUSED
        }

    public boolean retainMessage() {
        return Type.STATUS_MESSAGE == type;
    }
}
