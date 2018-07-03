package com.eagerto.ws;

import java.util.Map;
import java.util.Properties;

import javax.xml.ws.Endpoint;

import com.eagerto.ws.service.TestServiceImpl;

public class Endport {

	public static void main(String[] args) {
		String address = "http://127.0.0.1/webService/server";
		Endpoint endpoint =  Endpoint.create(new TestServiceImpl());
		endpoint.publish(address);
	}
}
