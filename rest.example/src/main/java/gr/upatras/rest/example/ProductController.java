package gr.upatras.rest.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttClient;

@RestController
public class ProductController {
    private MqttClient mqttClient;

    public ProductController() {
        try {
            // Connect to the MQTT broker
            String broker = "tcp://test.mosquitto.org:1883"; // Replace with your MQTT broker URL
            String clientId = MqttClient.generateClientId();
            mqttClient = new MqttClient(broker, clientId);
            mqttClient.connect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String postBody() {
        String topic = "mytopic"; 
        String message = "Hello World";
        try {
            mqttClient.publish(topic, new MqttMessage(message.getBytes()));
            return "Message published: " + message;
        } catch (MqttException e) {
            e.printStackTrace();
            return "Failed to publish message";
        }
    }
}


