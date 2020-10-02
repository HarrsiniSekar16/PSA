class MinStack {
    
    public Node top;
    public MinStack() {
        
    }
    
    public void push(int x) {
        Node node = new Node(x);
        if(top == null){
            top = node;
            node.min = x;
        }
        else{
            node.next = top;
            if(x < top.min){
                node.min = x;
            }
            else{
                node.min = top.min;
            }
            top = node;
        }
    }
    
    public void pop() {
        top =top.next;
    }
    
    public int top() {
        return top.value;
    }
    
    public int getMin() {
        return top.min;
    }
    class Node{
        public int value;
        public Node next;
        public int min;
        public Node(){}
        public Node(int v){
            this.value = v;
        }
    }
}