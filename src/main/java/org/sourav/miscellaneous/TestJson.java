package org.sourav.miscellaneous;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestJson {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("Sourav", "vmware");
        map.put("Raghu", "morgan");
        map.put("Santosh", "tcs");
        map.put("Ayan", "sapient");
        map.put("Sumar", "hcl");
        map.put("Mayank", "intuit");
        map.put("Mampi", "google");
        map.put("Jhumpi", "microsoft");
        map.put("Tumpi", "walmart");



        /*SampleMap<Map<String, String>> sampleMap = new SampleMap<>();
        sampleMap.add(map);*/


        String jsonInput = "{\"Sourav\": \"value1\" , \"raghu\": \"value2\", \"Santosh\": \"value3\", \"Tumpi\": \"value4\", \"Jhumpi\": \"value5\"}";
        TypeReference<HashMap<String, String>> typeRef
            = new TypeReference<HashMap<String, String>>() {};
        Map<String, String> map1 = mapper.readValue(jsonInput, typeRef);

        System.out.println("After ....");
        map1.forEach((k, v) -> {
            System.out.println(k + " : "+v);
        });
    }

}
