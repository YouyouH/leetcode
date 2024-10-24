import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class GsonTest {
    public static void main(String[] args) {
        System.out.println(new GsonBuilder()
                .registerTypeAdapter(Class.class, new ClassTypeAdapter()).setPrettyPrinting().create().toJson(new GsonTest().new Dummy("nameValue", String.class)));


//        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(new GsonTest().new Dummy("nameValue", String.class)));
    }

    private static class ClassTypeAdapter extends TypeAdapter<Class> {
        @Override
        public void write(JsonWriter out, Class value) throws IOException {
            out.value(value.getName());
        }

        @Override
        public Class read(JsonReader in) throws IOException {
            throw new UnsupportedOperationException(
                    "Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }
    }

    private class Dummy {
//        private String name;
        private Class clazz;

        public Dummy(String nameValue, Class clazz) {
//            this.name = nameValue;
            this.clazz = String.class;
        }
    }
}


