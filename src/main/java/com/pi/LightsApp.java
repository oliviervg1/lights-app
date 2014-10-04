package com.pi;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.namespace.QName;

import automation.api.AbstractApp;
import automation.api.components.NsLookupService;

public class LightsApp extends AbstractApp {

    @Override
    public void onStartup() {
        try {
            String deviceIp = NsLookupService.findDeviceIp("house-lights");
            connectToRemoteDevice(
                "http://" + deviceIp + ":8080/lights-companion-1.0.0/SocketController?wsdl",
                new QName("http://relay.pi.com/", "SocketControllerService")
            );
        } catch (IOException e) {}
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