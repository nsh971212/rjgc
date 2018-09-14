/**
 * 
 */
/**
 * @author 聂适涵
 *
 */
package wc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class nsh
{
	public static void main (String[] args) throws IOException
	{
		String command=null;
		String path=null;
		System.out.println("输入命令:");
	    Scanner scan= new Scanner(System.in);
	    if (scan.hasNext()) 
			{
                command= scan.next();
            }
	    if (command.equals("-c") || command.equals("-w") || command.equals("-l") || command.equals("-a") || command.equals("-all") ) 
	    {
                if (scan.hasNextLine()) 
                {
                    path=scan.next();
                }
            } 
            else 
            {
         System.out.println("指令不正确！");
            }
           
	    if(path!=null) 
                {
         BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));//用绝对路径将字符流转化为字节流
       	 int charcount=0;
       	 int wordcount=0;
       	 int linecount=0;
       	 int blankline=0;
       	 int noteline=0;
       	 int codeline=0;
       	 while(br.read()!=-1)//当br.read()=-1时，文件读取完毕
       	  {
       	   String s = br.readLine();
       	   if(s.length()<=1)  blankline++;//空行
       	   charcount+= s.length();//将数组长度算作字符数
       	   linecount+=s.split("\n").length;//以换行符分割数组，由于是按行读取，所以也可写为linecount++
       	   /*用正则表达式的方法匹配特定字符，得出单词数，注释行，*/
       	   Collection<String> list = java.util.Arrays.asList(s);
       	   for(String nt:list) {
       		String pattern = "((//)|(/\\\\*+)|((^\\\\s)*\\\\*+/))+";
       		Pattern r = Pattern.compile(pattern);
       		Matcher m = r.matcher(s);
            if (m.find( )) 
            	noteline++;
       	   }
       	   for(String wc:list) 
       	   {
       		String pattern = "\\b[A-Za-z]+\\b";
       		Pattern r = Pattern.compile(pattern);
       		Matcher m = r.matcher(s);
            if (m.find( )) 
            	wordcount++;
       	   }   
       	  }
       	 br.close();
       	codeline=linecount-blankline-noteline;
        /*输出结果*/
	     if (command.equals("-c"))
            System.out.println("字符数为"+charcount);
         else if (command.equals("-w"))
            System.out.println("单词数为"+wordcount);
         else if (command.equals("-l"))
            System.out.println("行数为"+linecount);
         else if (command.equals("-a")) {
        	System.out.println("空行为"+blankline);
	        System.out.println("注释行为"+noteline);  
	        System.out.println("代码行为"+codeline);
         }
         else if (command.equals("-all")) {
        	 System.out.println("字符数为"+charcount);
        	 System.out.println("单词数为"+wordcount);
        	 System.out.println("行数为"+linecount);
        	 System.out.println("空行为"+blankline);
        	 System.out.println("注释行为"+noteline);
        	 System.out.println("代码行为"+codeline);
         }
        	 
                }
	}
}