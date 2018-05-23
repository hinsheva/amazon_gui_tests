//package test;
//
//import org.openqa.selenium.json.Json;
//
//import java.io.IOException;
//import java.io.StringWriter;
//import java.math.BigDecimal;
//import java.math.MathContext;
//
//public class JsonExample {
//
//    private String str;
//    private BigDecimal number;
//
//    String getStr() {
//        return str;
//    }
//    String setStr(String str) {
//        return this.str = str;
//    }
//    BigDecimal getNumber() {
//        return number;
//    }
//    BigDecimal setNumber(BigDecimal number) {
//        return this.number = number;
//    }
//
//    public static void main(String[] args) throws IOException {
//        final JsonExample example = new JsonExample();
//        example.setStr("Some string");
//        example.setNumber(new BigDecimal(12.33d, MathContext.DECIMAL64));
//        try (final StringWriter writer = new StringWriter()) {
//            Json.createWriter(writer).write(
//                    Json.createObjectBuilder()
//                            .add("str", example.getStr())
//                            .add("number", example.getNumber())
//                            .build()
//            );
//        }
//    }
//}