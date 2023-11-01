import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bj2504 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		Stack<Character> stack = new Stack<>();

		int temp = 1;
		int result = 0;
		
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i)=='(') {
				stack.push(input.charAt(i));
				temp *= 2;
			}
			else if(input.charAt(i) == '[') {
				stack.push(input.charAt(i));
				temp *= 3;
			}
			else if(input.charAt(i)==')') {
				if(stack.isEmpty() || stack.peek() != '(') {
					result = 0;
					break;
				}
				
				if(input.charAt(i-1) == '(') {
					result += temp;
				}
				
				stack.pop();
				temp /= 2;
				
			}
			else if(input.charAt(i)==']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					result = 0;
					break;
				}
				
				if(input.charAt(i-1) == '[') {
					result += temp;
				}
				
				stack.pop();
				temp /= 3;
				
			}
		}
		
		if(!stack.isEmpty()) System.out.println(0);
		else System.out.println(result);
	}

}
