package com.yy;

import java.io.FileWriter;
import java.io.IOException;
/*import java.util.ArrayList;
import java.util.List;*/
public class CsvRead {
    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    //CSV file header
    private static final String FILE_HEADER = "id,firstName,lastName,gender,age";
    
    public static void main( String[] args )
    {
    	writeCsvFile( "C:\\Users\\sammy\\Desktop\\ex.csv" );
    }
    
    public static void writeCsvFile(String fileName) {
        Student student1 = new Student(3, "Ahmemwd", "Mohameden", "M", 28);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName,true);
                fileWriter.append("\""+ String.valueOf(student1.getId()) + "\"");
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append("\""+student1.getFirstName() + "\""+"\",hi\"");
                /*fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(student1.getLastName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(student1.getGender());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(student1.getAge()));*/
                fileWriter.append(NEW_LINE_SEPARATOR);
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }

    }

}
