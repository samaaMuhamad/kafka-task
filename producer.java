package kafka;
import java.util.Properties;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.*;

public class producer 
{
public static void main (String args[]) 
{
	Properties props = new Properties();
	props.put("bootstrap.servers", "localhost:9092");
	props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
	props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
	Producer <Integer,String> producer = new KafkaProducer<Integer,String>(props);
	
	for (int i=0; i<1; i++)
	{
		ProducerRecord<Integer,String> producerRecord = new ProducerRecord<Integer,String>("kafkatask",i, "Dear here #" + Integer.toString(i));
		producer.send(producerRecord);
		
	}
	producer.close();
	
	
}


}