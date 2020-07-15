package sample04;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements Outputter {
	private String filePath, fileName;
	public FileOutputter() {
		System.out.println("2. FileOutputter 생성자");
	}
	
	public void setFilePath(String filePath) {
		System.out.println("3. filePath setter 생성");
		this.filePath = filePath;
	}

	public void setFileName(String fileName) {
		System.out.println("4. fileName setter 생성");
		this.fileName = fileName;
	}

	@Override
	public void output(String message) {
		System.out.println("8. output()");
		try {
			FileWriter fileWriter = new FileWriter(filePath+fileName);
			fileWriter.write(message);
			fileWriter.close();  //닫아주지 않으면 파일안에 값이 제대로 들어가지 않음
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
