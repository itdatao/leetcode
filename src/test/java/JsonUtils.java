import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 将 JSON 字符串转换为 Java 对象
     *
     * @param json  JSON 字符串
     * @param clazz Java 对象类型
     * @param <T>   Java 对象类型
     * @return Java 对象
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param object Java 对象
     * @return JSON 字符串
     */
    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
