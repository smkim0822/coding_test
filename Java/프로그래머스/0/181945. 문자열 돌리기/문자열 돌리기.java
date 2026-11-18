import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (char c : br.readLine().toCharArray()) {
            sb.append(c).append("\n");
        }
        
        System.out.println(sb);
    }
}