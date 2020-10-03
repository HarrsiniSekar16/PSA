class compareNode implements Comparator<Node>{
    public int compare(Node a, Node b){
        if(a.val!=b.val)return -(a.val-b.val);
        else return -(a.idx - b.idx);
    }
}
class Node{
    int key;
    int idx;
    int val;
    public Node(int k, int v, int i){
        key = k;
        val = v;
        idx = i;
    }
}
class FreqStack {
    Map<Integer,Integer> frq;
    PriorityQueue<Node> pq;
    int idx;
    public FreqStack() {
        frq = new HashMap<>();
        pq = new PriorityQueue<>(15, new compareNode());
        idx = 0;
    }
    public void push(int x) {
        idx++;
        frq.put(x,frq.getOrDefault(x,0)+1);
        Node node = new Node(x,frq.get(x),idx);
        pq.add(node);
    }
    
    public int pop() {    
        Node node = pq.poll();
        int k = node.key;
        if(frq.get(k)==1)
            frq.remove(k);
        else
            frq.put(k,frq.get(k)-1);
        return k;
        
    }
}