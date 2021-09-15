package com.mooop.m.j8.etc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

public class WatchServiceApiTest {
	
	final static String TEST_PATH = "/svc/dev/data";
	
	
	private static void tst1() throws Exception{
		
		Path path = Paths.get(TEST_PATH);
		Files.list(path).forEach(p->System.out.println(p.toString()));
		WatchService watchService = path.getFileSystem().newWatchService();
		
		path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
		
		System.out.println("Report any file changed within next 1 minute...");
		
		WatchKey watchKey = watchService.poll(1, TimeUnit.MINUTES);
		if(watchKey != null) {
			watchKey.pollEvents().stream().forEach(event->System.out.println(event.context()));
		}
	}
	
	
	public static void main(String[] args) {
		try {
			tst1();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("========== End =========");
	}

}
