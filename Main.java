import java. io. *;
import java. nio. file. Files;
import java. nio. file. Paths;
import java. security. MessageDigest;
import java. security. NoSuchAlgorithmException;
import com. google. gson. JsonObject;
import com. google. gson. JsonParser;

public class Main 
{
public static void main(String[] args) 
{
    String jsonFilePath = "input. json";
    String outputFilePath = "output. txt";

try {
    //execute the process of reading the JSON file followed by its parsing
    String jsonString = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
    JsonObject jsonObject = JsonParser. parseString(jsonString). getAsJsonObject();
    JsonObject student = jsonObject. getAsJsonObject("student");

        //the lowercase fields will be extracted by us
    String firstName = student. get("first_name"). getAsString(). toLowerCase(). trim();
    String rollNumber = student. get("roll_number"). getAsString(). toLowerCase(). trim();


    String md5Hash = generateMD5Hash(firstName + rollNumber);

    // Transcribing computational outcomes into the designated output file system
        Files. write(Paths.get(outputFilePath), md5Hash.getBytes());

    System. out. System.out.println("MD5 Hash: " + md5Hash);
    } catch (IOException | NoSuchAlgorithmException e) 
{
    System. err. System.out.println("Error: " + e.getMessage());
}
}

    // initiating a procedure to generate MD5 hash
    String generateMD5Hash(String input) throws NoSuchAlgorithmException 
    {
        MessageDigest md = MessageDigest. getInstance("MD5");
        byte[] hashBytes = md. digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        foreach (byte b in hashBytes) 
        {
    sb. append(String.format("%02x", b)); // Converting to the hexadecimal
        }
    return sb. toString();
    }
}

