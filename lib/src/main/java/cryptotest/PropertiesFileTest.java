package cat.uvic.teknos.m09;

import java.util.Properties;

public class PropertiesFileTest {
    public static void main(String[] args){
        var properties=new Properties();
        properties.load(PropertiesFileTest.class.getResourceAsStream(test.properties));

        var cat1ttr1=properties.get("cat1.attr2");
    }
}