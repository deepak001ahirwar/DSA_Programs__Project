import java.util.Stack;

public class ValidParentheses {


    public static void main(String[] args) {
        
        System.out.println(isValid());

        }
    
    public  static boolean isValid() {
        String str="()[]{}";
        
        Stack<Character> stc =new Stack<>();
        for(int i=0;i<str.length();i++){
            // push all first parentheses
            if(str.charAt(i)=='('){
                stc.push('(');                  
            }else if(str.charAt(i)=='{'){
                stc.push('{');                  
            }else if(str.charAt(i)=='['){
                stc.push('[');                  
            }
            // pop the value and 
            if(str.charAt(i)==')'){
                if(stc.empty()){
                    return false;
                }
                if(stc.pop()!='('){
                    return false;
                }
            }else if(str.charAt(i)=='}'){
                if(stc.empty()){
                    return false;
                }
                if(stc.pop()!='{'){
                    return false;
                }
            } else if(str.charAt(i)==']'){
                if(stc.empty()){
                    return false;
                }
                if(stc.pop()!='['){
                    return false;
                }
            }

            
        }
        if(stc.empty()){
            return true;
        }
        else{
            return false;
        }
    }
    }

