package com.umesh.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.umesh.constants.Constants;
import com.umesh.exception.FileReadException;

public class FileReaderImpl implements FilerReader{

	public List<String> readFile() {
		List<String> lines = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(Constants.INPUT_FILE_PATH))) {

			lines = stream.collect(Collectors.toList());

		} catch (IOException e) {
			
			throw new FileReadException(e.getClass().getCanonicalName() + " " +  e.getLocalizedMessage());
		}
		
		return lines;
	}

	
}
