package com.rms.service;

import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.springframework.stereotype.Service;

import com.rms.vo.ServerDetailsVO;

@Service("serverService")
public class ServerService {
	
	public ServerDetailsVO getServerDetails() throws IOException {
		ServerDetailsVO serverDetailsVO = new ServerDetailsVO();
		
		Manifest manifest = new Manifest();
		manifest.read(Thread.currentThread().getContextClassLoader().getResourceAsStream("META-INF/MANIFEST.MF"));
		Attributes attributes = manifest.getMainAttributes();
		
		String version = attributes.getValue("Implementation-Version");
		serverDetailsVO.setServerVersion(version != null ?version:"Version missing");
		return serverDetailsVO;
	}
}
