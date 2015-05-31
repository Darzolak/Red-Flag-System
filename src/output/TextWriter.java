package output;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import model.Flag;

public class TextWriter extends OutputWriter {

	private static Path pathToFile;
	
	public TextWriter(String pPathToFile) {
		pathToFile = Paths.get(pPathToFile);
	}

    public static void appendToTextFile(String content) {
    	try(BufferedWriter writer = Files.newBufferedWriter(pathToFile,StandardOpenOption.APPEND)) { 
    	        writer.write(content);
    	} catch (IOException e) {
    	        e.printStackTrace();
    	}
    }

	@Override
	public void update(Flag flag) {
		String content = "";
		content += flag.getTimeCreated() + ";" + flag.getClass().getSimpleName() + ";" + flag.getPriority() 
				+ ";" + flag.getRequester().getName() + "\n";
		appendToTextFile(content);
	}

}
