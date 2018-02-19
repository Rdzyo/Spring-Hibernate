package com.luv2code.spring.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private String filename = "D:\\Java projects\\Practice-Activity-5\\src\\com\\luv2code\\spring\\practice\\fortune-file";
	private List<String> theFortunes;
	
	private Random myRandom = new Random();
	
	public FileFortuneService() {
		
		File theFile = new File(filename);
		
		System.out.println("Reading fortunes from file: " + theFile);
		System.out.println("File exists: " + theFile.exists());
		
		theFortunes = new ArrayList<String>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			
			String tempLine;
			
			while((tempLine = br.readLine()) != null) {
				theFortunes.add(tempLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(theFortunes.size()); 
		
		String theFortune = theFortunes.get(index);
		
		return theFortune;
	}

}
