package com.isograd.exercise;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class ExerciseCheck {
	
	private static final int noExercise = 2;
	
	private static final Path basePath = Paths.get("C:/Users/j.lelong/Documents/Perso/dev/battledev/files");
	private static final Path exoPath = basePath.resolve("exo" + noExercise);
	
	@Test
	public void checkOne() throws Exception {
		int noTest = 1;
		check(getInputFile(noTest), getOutputFile(noTest));
	}
	
	@Test
	public void checkAll() throws Exception {
		Path inputFile;
		for (int noTest=1; Files.exists(inputFile = getInputFile(noTest)); noTest++) {
			check(inputFile, getOutputFile(noTest));
		}
	}
	

	private void check(Path inputFile, Path expectedFile) throws Exception {
		InputStream is = Files.newInputStream(inputFile);
		System.setIn(is);
		
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		PrintStream os = new PrintStream(result);
		System.setOut(os);
		
		IsoContest.main(new String[0]);
		
		String resultString = result.toString(Charset.defaultCharset().name());
		List<String> resultLines = Arrays.asList(resultString.split("\\r?\\n"));
		
		List<String> expectedLines = Files.readAllLines(expectedFile);
		
		Assert.assertEquals(expectedLines, resultLines);
	}

	private Path getInputFile(int noTest) {
		return exoPath.resolve("input" + noTest + ".txt");
	}
	
	private Path getOutputFile(int noTest) {
		return exoPath.resolve("output" + noTest + ".txt");
	}

}
