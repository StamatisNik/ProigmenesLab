package gr.upatras.rest.example;

import org.eclipse.paho.client.mqttv3.*;

public class MqttSubscriber {
    public static void main(String[] args) {
        String broker = "tcp://test.mosquitto.org:1883";
        String clientId = "client";
        String topic = "mytopic";

        try {
            MqttClient client = new MqttClient(broker, clientId);
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    System.out.println("Connection lost");
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    System.out.println("Received message: " + new String(message.getPayload()));
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    // Not used in this example
                }
            });

            client.connect();
            client.subscribe(topic);

            // Continuously receive messages
            while (true) {
                // Delay for 1 second
                Thread.sleep(1000);
            }
        } catch (MqttException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}