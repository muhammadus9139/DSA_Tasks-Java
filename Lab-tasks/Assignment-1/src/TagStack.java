
//SP25-BCS-151
public class TagStack {
    private String[] stack;
    private int top;
    private int capacity;

    TagStack(int capacity){
        this.capacity=capacity;
        this.stack=new String[capacity];
        this.top=-1;
    }

    public void push(String tag){
        if(top==capacity-1){
            String[] newStack=new String[capacity*2];

            for(int i=0;i<+top;i++){
                newStack[i]=stack[i];
            }
            stack=newStack;
            capacity=capacity*2;
        }
        stack[++top]=tag;
    }

    public String pop() {
        if (isempty())
            return null;
        return stack[top--];
    }

    public String peek() {
        if (isempty())
            return null;
        return stack[top];
    }

    public boolean isempty() {
        return top == -1;
    }

}
