package com.springbootpractices.tcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.ip.tcp.TcpReceivingChannelAdapter;
import org.springframework.integration.ip.tcp.connection.AbstractServerConnectionFactory;
import org.springframework.integration.ip.tcp.connection.TcpNetServerConnectionFactory;
import org.springframework.integration.transformer.ObjectToStringTransformer;
import org.springframework.messaging.MessageChannel;

import javax.net.SocketFactory;
import java.net.Socket;

@SpringBootApplication
public class TcpApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = SpringApplication.run(TcpApplication.class, args);
		Socket socket = SocketFactory.getDefault().createSocket("localhost", 9999);

		long timeStarted = System.currentTimeMillis();
		long currentTime;

		do {
			System.out.println("-----");
			currentTime = System.currentTimeMillis();
			String message = "Hello";
			System.out.println("Sending: " + message);
			socket.getOutputStream().write((message + "\r\n").getBytes());
			Thread.sleep(1000);
		} while (currentTime < timeStarted + 6000);

		socket.close();
		context.close();
	}

	@Bean
	public TcpNetServerConnectionFactory connectionFactory() {
		return new TcpNetServerConnectionFactory(9999);
	}

	@Bean
	public TcpReceivingChannelAdapter inbound(AbstractServerConnectionFactory connectionFactory) {
		TcpReceivingChannelAdapter adapter = new TcpReceivingChannelAdapter();
		adapter.setConnectionFactory(connectionFactory);
		adapter.setOutputChannel(tcpIn());
		return adapter;
	}

	@Bean
	public MessageChannel tcpIn() {
		return new DirectChannel();
	}

	@Transformer(inputChannel = "tcpIn", outputChannel = "tcpOut")
	@Bean
	public ObjectToStringTransformer transformer() {
		return new ObjectToStringTransformer();
	}

	@ServiceActivator(inputChannel = "tcpOut")
	public void service(String in) {
		System.out.println("Received: " + in);
	}

}
