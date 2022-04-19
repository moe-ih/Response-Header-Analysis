package code;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class Config {
	// adding colors to output later 
//	public static final String ANSI_RESET = "\u001B[0m";
//	public static final String ANSI_BLACK = "\u001B[30m";
//	public static final String ANSI_RED = "\u001B[31m";
//	public static final String ANSI_GREEN = "\u001B[32m";
//	public static final String ANSI_YELLOW = "\u001B[33m";
//	public static final String ANSI_BLUE = "\u001B[34m";
//	public static final sString ANSI_PURPLE = "\u001B[35m";
//	public static final String ANSI_CYAN = "\u001B[36m";
//	public static final String ANSI_WHITE = "\u001B[37m";
	
	public static String separator = "HTTP";
	
	/*
	 * Map<String , String>
	 *  1 - String header name
	 *  2 - String header description
	 *	All resources was taken from mdn @https://developer.mozilla.org
	 */
	public static Map<String, String> headers = new HashMap<String , String>();
	
	// if you have any additional header you can add them in this function 
	public static void init_all_headers() {
		headers.put("x-frame-options", "[Security] 	The X-Frame-Options HTTP response header can be used to indicate whether or not a browser should be allowed to render a page in a <frame>, <iframe>, <embed> or <object>. Sites can use this to avoid click-jacking attacks, by ensuring that their content is not embedded into other sites.");
		headers.put("x-xss-protection", "[Security]	The HTTP X-XSS-Protection response header is a feature of Internet Explorer, Chrome and Safari that stops pages from loading when they detect reflected cross-site scripting (XSS) attacks");
		headers.put("Content-Security-Policy", "[Security]	Content Security Policy (CSP) is an added layer of security that helps to detect and mitigate certain types of attacks, including Cross-Site Scripting (XSS) and data injection attacks. These attacks are used for everything from data theft, to site defacement, to malware distribution");
		headers.put("Strict-Transport-Security", "[Security]	The HTTP Strict-Transport-Security response header (often abbreviated as HSTS) informs browsers that the site should only be accessed using HTTPS, and that any future attempts to access it using HTTP should automatically be converted to HTTPS.");
		headers.put("X-Content-Type-Options", "[Security]	The X-Content-Type-Options response HTTP header is a marker used by the server to indicate that the MIME types advertised in the Content-Type headers should be followed and not be changed. The header allows you to avoid MIME type sniffing by saying that the MIME types are deliberately configured.");
		
	}
	
	
	public static boolean FileCheck(String file_Path) {
			File fb = new File(file_Path);
			if(fb.exists() && fb.isFile() && fb.canRead()) return true; return false;
	}
	
	public static boolean ArgsChecker(String[] args) {
		if(args.length < 1) return false;	return true;
	}
	
	
}
