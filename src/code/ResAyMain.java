package code;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import code.Config;

public class ResAyMain {

	public static void main(String[] args) throws IOException {
		if(args.length == 0) {
			System.out.println("Response Analysis Tool to help you check the response header");
			System.out.println("USING : ");
			System.out.println("Run without args ./javac ResAyMain.java to print out help message");
			System.out.println("Run with 1 arg ./javac ResAyMain.java response_headers.txt to Analysis all response header in response_headers.txt file");
			System.out.println("Run with 2 args ./javac ResAyMain.java response_headers.txt HTTP where the HTTP "
					+ "consider as separator between each response in file "
					+ "you can change HTTP as separator to any text or symbol [OPTIONAL]");
			
			System.out.println();
			
			System.exit(2);
		}
		
		if(!Config.ArgsChecker(args)) {
			System.out.println("Please Provide the Response File ! [+] ResAyMain.java headersFile.txt");
			System.exit(0);
		}
		
		
		if(args.length == 2) {
			Config.separator = args[1];
		}
		
		
		ArrayList<String> headers = FileReader(args[0]);
		Missing_Header_Checker(headers);

	}
	
	public static ArrayList<String> FileReader(String file) throws IOException  {
		
		if(!Config.FileCheck(file)) {
			System.out.println("File Not Valid or path not Valid or unreadable !");
			System.exit(0);
		}
		
		
		List<String> lines = Files.readAllLines(Paths.get(file));
		
		ArrayList<String> result = new ArrayList<String>();
		String data = "";
		
		
		for(int i = 0 ; i < lines.size() ; i++) {
			data+=lines.get(i);
			data+='\r';
			
			if(lines.get(i).startsWith(Config.separator)) {
				result.add(data);
				data = "";
			}
		}
		
		
		return result;
		
	}
	
	public static void Missing_Header_Checker(ArrayList<String> res_header) {
		
		Config.init_all_headers();
		int header_count = res_header.size();
		int counter = 0;
		
		if(header_count > 1) {
			System.out.println("Number of requests [ " + String.valueOf(header_count) + " ]");
		}else if (header_count == 1) {
			System.out.println("there is just [ " + String.valueOf(header_count) + " ] request");
		}else {
			System.out.println("No Request was provide Please make sure that you provide the request with valid separator ");
			System.exit(0);
		}
		System.out.println();
		
		for(int i  = 0 ; i < res_header.size() ; i++) {
			System.out.println("**********************************" );
			System.out.println(res_header.get(i));
			
			if(res_header.get(i).contains("Access-Control-Allow-Credentials: true") &&
					res_header.get(i).contains("Access-Control-Allow-Origin: *")) {
				
				System.out.println("Header Found 	* Access-Control-Allow-Credentials and "
						+ "Access-Control-Allow-Origin: [Security] which linked to "
						+ "unsef resourse which may lead to CORS attack ");
			}
			
			for(var entry : Config.headers.entrySet()) {
				
				if(res_header.get(i).contains(entry.getKey())) {
					System.out.println("Header Found *  " + entry.getKey() + " : " + entry.getValue());
				}else {
					System.out.println("Header NOT Found *  " + entry.getKey() + " : " + entry.getValue());
				}
				
			}
		}
		
	}
	
	
}
