/**
 * 
 */
/**
 * @author ���ʺ�
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
		System.out.println("��������:");
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
         System.out.println("ָ���ȷ��");
            }
           
	    if(path!=null) 
                {
         BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));//�þ���·�����ַ���ת��Ϊ�ֽ���
       	 int charcount=0;
       	 int wordcount=0;
       	 int linecount=0;
       	 int blankline=0;
       	 int noteline=0;
       	 int codeline=0;
       	 while(br.read()!=-1)//��br.read()=-1ʱ���ļ���ȡ���
       	  {
       	   String s = br.readLine();
       	   if(s.length()<=1)  blankline++;//����
       	   charcount+= s.length();//�����鳤�������ַ���
       	   linecount+=s.split("\n").length;//�Ի��з��ָ����飬�����ǰ��ж�ȡ������Ҳ��дΪlinecount++
       	   /*��������ʽ�ķ���ƥ���ض��ַ����ó���������ע���У�*/
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
        /*������*/
	     if (command.equals("-c"))
            System.out.println("�ַ���Ϊ"+charcount);
         else if (command.equals("-w"))
            System.out.println("������Ϊ"+wordcount);
         else if (command.equals("-l"))
            System.out.println("����Ϊ"+linecount);
         else if (command.equals("-a")) {
        	System.out.println("����Ϊ"+blankline);
	        System.out.println("ע����Ϊ"+noteline);  
	        System.out.println("������Ϊ"+codeline);
         }
         else if (command.equals("-all")) {
        	 System.out.println("�ַ���Ϊ"+charcount);
        	 System.out.println("������Ϊ"+wordcount);
        	 System.out.println("����Ϊ"+linecount);
        	 System.out.println("����Ϊ"+blankline);
        	 System.out.println("ע����Ϊ"+noteline);
        	 System.out.println("������Ϊ"+codeline);
         }
        	 
                }
	}
}