
package doc_examples.lambda_java_example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.print( "Введите путь к файлу: " );
        
        Scanner sc = new Scanner(System.in);
		String FilePath = sc.nextLine();		  
		//System.out.println(FilePath);
	    sc.close();
	      
    }
}
