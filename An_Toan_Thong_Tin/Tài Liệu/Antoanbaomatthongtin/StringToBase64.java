
// Java program to demonstrate 
// Encodig simple String into Basic Base 64 format 
  
import java.util.*; 
public class StringToBase64 { 
    public static void main(String[] args) 
    { 
  
        // create a sample String to encode 
        String sample = "India Team will win the Cup"; 
  
        // print actual String 
        System.out.println("Sample String:\n"
                           + sample); 
  
        // Encode into Base64 format 
        String BasicBase64format 
            = Base64.getEncoder() 
                  .encodeToString(sample.getBytes()); 
  
        // print encoded String 
        System.out.println("Encoded String:\n"
                           + BasicBase64format); 
    } 
} 