package kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class consumer {
	public static void main (String args[]) 
	{
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id", "test-group");
		props.put("enable.auto.commit", "true");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		
		KafkaConsumer <String,String> consumer = new KafkaConsumer <String,String>(props);
		consumer.subscribe(Arrays.asList("kafkatask"));
		
		while (true)
		{
			ConsumerRecords<String, String> records= consumer.poll(0); //real time, el zero de btll3 immediately y3ny ama ndkhll 7aga hattl3 fe nfs el l7za
			for (ConsumerRecord<String, String> record: records )
			{
				System.out.println( record.value());
			}
		}	
	}
}
