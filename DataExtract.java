import java.util.regex.Pattern;

public class DataExtract{
	
	public static void main( String[] args )
	{
	//	getScript("FunctionLibrary").callFunction("LogResultsOutputForMailReport","{{gStrScenarioOutputFilePath}}","
		// tag that we want
		// ","","PASSED",false);
		//or
		//","","FAILED",false);
		String content = "This is a tutorial Website!";
		String patternString = ".*tutorial.*";
		boolean isMatch = Pattern.matches(patternString, content);
		System.out.println("The text contains 'tutorial'? " + isMatch);
		//public returntype name (int i, int b) throws Exception {
		//public void run() throws Exception {
		String str1 = "testToDoFunctionality();";
		String str = "getScript(\"FunctionLibrary\").callFunction(\"LogResultsOutputForMailReport\",\"{{gStrScenarioOutputFilePath}}\",\"To Verify ToDo element is created successfully\",\"\",\"PASSED\",false);";
       // String pattern =".*LogResultsOutputForMailReport.*";
        final String pattern = "\\}\\}\", \"(.*)\",\"\"";
        String nregex = "((public)|(private)|(protected)) [a-zA-Z_0-9\\<\\>\\,]+ [a-zA-Z_0-9]+\\(.*\\) (throws .*)? \\{";
       // word1("word2").word3( "word4","{{word5}}", "sentence6","","word7"|"word8", word9 )       
        if (Pattern.matches(nregex, str1))
        {
        	System.out.println("ok"); 
        }
        else
        {
        	System.out.println("not ok");
        }
	}
}