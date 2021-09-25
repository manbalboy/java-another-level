import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.Car;
import dto.User;

import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("main");


        ObjectMapper objectMapper = new ObjectMapper();


        User user = new User();
        user.setName("홍길동");
        user.setAge(10);

        Car car1 = new Car();
        car1.setCarNumer("11가 너너너너");
        car1.setName("소나타");
        car1.setType("타입");

        Car car2 = new Car();
        car2.setCarNumer("11가 가가가가");
        car2.setName("소나타A");
        car2.setType("타입B");

        List<Car> cars = Arrays.asList(car1, car2);

        user.setCars(cars);
        System.out.println(user);

        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);


        JsonNode jsonNode = objectMapper.readTree(json);

        String _name = jsonNode.get("name").asText();
        Integer _age = jsonNode.get("age").asInt();

        System.out.println(_name + " ::: " + _age);


        JsonNode carsNode = jsonNode.get("cars");
        ArrayNode arrayNode = (ArrayNode) carsNode;

        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {
        });
        System.out.println(_cars);


        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name", "훈");
        objectNode.put("age", 32);

        System.out.println(objectNode.toPrettyString());
    }
}
