import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.yy.TraverseFolder;

import java.io.FileWriter;

public class Read {
	 private static final String COMMA_DELIMITER = ",";
	 private static final String NEW_LINE_SEPARATOR = "\n";
	 
	
	 
	public static void main(String[] args) {
		
		try {
			TraverseFolder listFilesUtil = new TraverseFolder();

	    	final String directoryWindows ="D:\\v4.3.0.6\\Code\\Tests\\UI\\ToDo";
	    	ArrayList<String>str4 = listFilesUtil.listFolders(directoryWindows);
	    	int i = 0;
	    	for (String temp : str4) {
				System.out.println(temp);
			
			File file = new File(temp);
			FileReader fileReader = new FileReader(file);
			
			String fileName1 = "C:\\Users\\sammy\\Desktop\\tag.csv";
			String fileName2 = "C:\\Users\\sammy\\Desktop\\code.csv";
			FileWriter fileWriter1 = null;
			FileWriter fileWriter2 = null;
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
	        
			while ((line = bufferedReader.readLine()) != null) {
				String str1 = line.trim();
				String pattern =".*LogResultsOutputForMailReport.*";
				String nregex = "((public)|(private)|(protected)) [a-zA-Z_0-9\\<\\>\\,]+ [a-zA-Z_0-9]+\\(.*\\) (throws .*)? \\{";
				if (Pattern.matches(pattern, str1))
				{			
					String word1 = "false";
					String word2 = "LogResultsOutputForMailReport";					
					int pos1 = str1.indexOf(word1);
					int pos2 = str1.indexOf(word2);
		
					if ( pos1 != -1 && pos1-2 >= pos2  ) {
						String str2 = str1.substring( pos2, pos1-2 );
						int comma = str2.indexOf(",");
						String str3 = str2.substring( comma+1 );
						int comma2 = str3.indexOf(",");
						String str = str3.substring(comma2+1);
					
						if (  stringBuffer.toString().trim().replace("\n", "").length() > 120 ) {
							i++;
							// update tag.csv and code.csv
							System.out.println( i+": "+str+" "+ stringBuffer );
							try {
					            fileWriter1 = new FileWriter(fileName1,true);
					                fileWriter1.append( "\"" + str.replace("\"", "\"\"") + "\"" );
					                fileWriter1.append(COMMA_DELIMITER);
					                fileWriter1.append( String.valueOf( i ) );
					                fileWriter1.append(NEW_LINE_SEPARATOR);
					            System.out.println("CSV file was created successfully !!!");
					        } catch (Exception e) {
					            System.out.println("Error in CsvFileWriter !!!");
					            e.printStackTrace();
					        } finally {
					            try {
					                fileWriter1.flush();
					                fileWriter1.close();
					            } catch (IOException e) {
					                System.out.println("Error while flushing/closing fileWriter !!!");
					                e.printStackTrace();
					            }
					        }
							
							// in code i, stringBuffer
							try {
					            fileWriter2 = new FileWriter(fileName2,true);
					                fileWriter2.append(String.valueOf( i ));
					                fileWriter2.append(COMMA_DELIMITER);
					                fileWriter2.append( "\"" + String.valueOf( stringBuffer ).replace("\"", "\"\"") + "\"" );
					                fileWriter2.append(NEW_LINE_SEPARATOR);
					            System.out.println("CSV file was created successfully !!!");
					        } catch (Exception e) {
					            System.out.println("Error in CsvFileWriter !!!");
					            e.printStackTrace();
					        } finally {
					            try {
					                fileWriter2.flush();
					                fileWriter2.close();
					            } catch (IOException e) {
					                System.out.println("Error while flushing/closing fileWriter !!!");
					                e.printStackTrace();
					            }
					        }
							stringBuffer.delete(0, stringBuffer.length());
						}
						else
						{
							// update tag.csv
							System.out.println( i+": "+str );
							try {
					            fileWriter1 = new FileWriter(fileName1,true);
					                fileWriter1.append( "\"" + str.replace("\"", "\"\"") + "\"" );
					                fileWriter1.append(COMMA_DELIMITER);
					                fileWriter1.append( String.valueOf( i ) );
					                fileWriter1.append(NEW_LINE_SEPARATOR);
					         //   System.out.println("CSV file was created successfully !!!");
					        } catch (Exception e) {
					            System.out.println("Error in CsvFileWriter !!!");
					            e.printStackTrace();
					        } finally {
					            try {
					                fileWriter1.flush();
					                fileWriter1.close();
					            } catch (IOException e) {
					                System.out.println("Error while flushing/closing fileWriter !!!");
					                e.printStackTrace();
					            }
					        }
							stringBuffer.delete(0, stringBuffer.length());
						}
					}
					else 
						stringBuffer.delete(0, stringBuffer.length());	
				}
				else 
				{
					
					if ( line.trim().length() >=3  )
						stringBuffer.append( line.trim()+" qwerty " );
					else if ( line.trim().length()>=1 )
						stringBuffer.append( line.trim() );
				}
				
				if ( Pattern.matches(nregex, str1) )
					stringBuffer.delete(0, stringBuffer.length());
				
				
			}
			fileReader.close();
	    	}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}