import java.util.Stack;

public class SimplifyPath {

    // Given an absolute path for a file (Unix-style), simplify it to canonical path.
    // Note that the returned canonical path must always begin with a slash /,
    // and there must be only a single slash / between two directory names.
    // The last directory name (if it exists) must not end with a trailing /.
    // Also, the canonical path must be the shortest string representing the absolute path.
    private static String simplifyPath(String path) {
        // split based on at least one /
        String[] dirs = path.split("(/)+");

        // track the directories
        Stack<String> stack = new Stack<>();
        for(String s : dirs){
            // ignore empty string
            if(s.equals(""))
                continue;

            // same directory
            if(s.equals(".")){
                continue;
            }
            // up one directory
            else if(s.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            }
            // normal directory
            else{
                stack.push(s);
            }
        }

        // reverse stack to get directories in path order
        Stack<String> reverse = new Stack<>();
        while(!stack.isEmpty()){
            reverse.push(stack.pop());
        }

        // initial directory
        if(reverse.isEmpty())
            return "/";

        // to return
        StringBuilder out = new StringBuilder();
        while(!reverse.isEmpty()){
            out.append("/");
            out.append(reverse.pop());
        }
        return out.toString();
    }

    public static void main(String[] args) {
        // expected /home
        System.out.println(simplifyPath("/home/"));
        // expected /
        System.out.println(simplifyPath("/../"));
        // expected /home/foo
        System.out.println(simplifyPath("/home//foo/"));
        // expected /c
        System.out.println(simplifyPath("/a/./b/../../c/"));
        // expected /c
        System.out.println(simplifyPath("/a/../../b/../c//.//"));
        // expected /a/b/c
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }
}
