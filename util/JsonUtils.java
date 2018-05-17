import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ser.StdSerializerProvider;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by thanatos on 2018/5/17.
 * <p>
 * Json工具类
 */
public class JsonUtils {
    private final static ObjectMapper objectMapper;

    private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);

    static {
        StdSerializerProvider sp = new StdSerializerProvider();
        objectMapper = new ObjectMapper(null, sp, null);
    }

    private JsonUtils() {
    }

    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    /**
     * Java对象转Json字符串
     */
    public static String toJson(Object object) {
        String jsonString = "";
        try {
            jsonString = objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            log.warn("json error:" + e.getMessage());
        }
        return jsonString;
    }

    /**
     * Json字符串转Java对象
     */
    public static Object json2Object(String jsonString, Class<?> c) {

        if (jsonString == null || "".equals(jsonString)) {
            return "";
        } else {
            try {
                return objectMapper.readValue(jsonString, c);
            } catch (Exception e) {
                log.warn("json error:" + e.getMessage());
            }

        }
        return "";
    }

    /**
     * JSON串转换为Java泛型对象，可以是各种类型。
     *
     * @param <T>
     * @param jsonString JSON字符串
     * @param tr         TypeReference,例如: new TypeReference< List<FamousUser> >(){}
     * @return List对象列表
     */
    @SuppressWarnings("unchecked")
    public static <T> T json2GenericObject(String jsonString, TypeReference<T> tr) {

        if (jsonString == null || "".equals(jsonString)) {
            return null;
        } else {
            try {
                return (T) objectMapper.readValue(jsonString, tr);
            } catch (Exception e) {
                log.warn("json error:" + e.getMessage());
            }
        }
        return null;
    }

}
