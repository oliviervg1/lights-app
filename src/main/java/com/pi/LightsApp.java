package com.pi;

import java.io.File;
import java.util.HashMap;

import javax.xml.namespace.QName;

import automation.api.AbstractApp;

public class LightsApp extends AbstractApp {
		
	private static final long serialVersionUID = 5065555879144052501L;

	@Override
	public void onStartup() {
		connectToRemoteDevice("http://192.168.0.9:8080/lights-companion-1.0.0/SocketController?wsdl", new QName("http://relay.pi.com/", "SocketControllerService"));
	}
	
	public void turnOn() throws NoSuchMethodException  {
		if (isDeviceAvailable()) {
			device.invokeMethod("powerOn");
		}
	}
	
	public void turnOff() throws NoSuchMethodException {
		if (isDeviceAvailable()) {
			device.invokeMethod("powerOff");
		}
	}
	
	@Override
	public String getState() throws NoSuchMethodException {
		String state = "Device unavailable";
		if (isDeviceAvailable()) {
			state = "Power is currently " + (String) device.invokeMethod("getState") + "!";
		}
		return state;
	}
	
	@Override
	public String homeTile() throws NoSuchMethodException {
		String state = "Device unavailable";
		if (isDeviceAvailable()) {
			state = "Power is currently " + (String) device.invokeMethod("getState") + "!";
		}
		return state;
	}

	@Override
	public HashMap<String, Object> getModels() {
		return new HashMap<String,Object>();
	}

	@Override
	public void uploadFile(String fileName, File fileData) {}
}