package doc_examples.lambda_java_example;

import java.util.Scanner;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.io.IOException;
import java.util.*;
import java.nio.file.NoSuchFileException;

public class App 
{
	private static ArrayList <Character> open = new ArrayList<Character>();
	private static ArrayList <Character> close = new ArrayList<Character>();
	
	public static void main( String[] args ) throws IOException
    {
        //считывание содержимого файла
		System.out.print( "Введите путь к файлу: " );      
        Scanner sc = new Scanner(System.in);
		String FilePath = sc.nextLine();		  
	    sc.close();	
	    List<String> lines = new ArrayList<String>();
	    try 
	    {
	    	lines = Files.readAllLines(Paths.get(FilePath.trim()), Charset.defaultCharset());
	    }
	    catch (NoSuchFileException ex) {
	    	System.out.println("invalid file path");
	    	return;}
	    
	    //заполнениe open&close скобками
	    open.add('{'); open.add('('); open.add('[');    
	    close.add('}'); close.add(')'); close.add(']');
	        
	    int result = 0, correct = 1;
	    
	    if (!lines.isEmpty()) 
	    {
	    	
        //обработка всех строк	    
	    for (String x:lines)
        {
	    	//проверка строки x в отдельном методе    	
	    	result = checkString(x);
	        if (result == 0) 
	        {	        	
	        	System.out.println("incorrect");
	        	correct = 0;
	        	break;
	        }	        
        }
	    
	    if (correct == 1)        	
        	System.out.println("correct");	 
	    }   
	    else
	    	System.out.println("the file is empty");	
    }
    
	// проверка 1 строки
    private static int checkString(String x)
    {
    	char[] chars = x.toCharArray();  	
    	ArrayList <Character> mas = new ArrayList<Character>();
    	
    	for (int i = 0; i< x.length(); i++) 
    	{
    		if (open.contains(chars[i]))
    			mas.add(chars[i]);
    		if (close.contains(chars[i]))
    		{
    			//проверка правильности расстановки скобок   			
    			if (!mas.isEmpty()) 
    			{			
    				char last = mas.get(mas.size()-1);
    				if (open.indexOf(last) == close.indexOf(chars[i]))
    				{
    					mas.remove((Character)last); 
    					continue;
    				}
    				if (open.indexOf(last) != close.indexOf(chars[i]))
    					return 0;
    			} 
    			else return 0;
    		}  		
    	} 			
    	if (mas.isEmpty())  return 1; else return 0; 	
    }
}

