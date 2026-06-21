
//sp-25-bcs-151
public class PriorityQueue {
    Plane [] arr;
    int rear;
    int capacity;

    PriorityQueue(int capacity){
        this.capacity=capacity;
        arr=new Plane[capacity];
        rear=-1;
    }

    public boolean isEmpty(){
        if(rear==-1){
            return true;
        }
        else
            return false;
    }

    public boolean isFull(){
        if(rear==capacity-1){
            return true;
        }
        else
            return false;
    }

    public void enqueue(Plane p){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }

        int i = rear; // start from the last element

        // shift planes with higher fuel to the right
        while(i >= 0 && arr[i].fuellevel > p.fuellevel){
            arr[i + 1] = arr[i];
            i--;
        }

        arr[i + 1] = p; // insert the new plane
        rear++; // increase the count of elements

        System.out.println(p + " added to the queue");
    }

    public Plane dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }

        Plane p = arr[0];

        // shift all elements left
        for(int i = 0; i < rear; i++){
            arr[i] = arr[i + 1];
        }

        arr[rear] = null;
        rear--;
        return p;
    }

    public Plane peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }
        return arr[0];
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        for(int i=0;i<capacity;i++){
            System.out.println(arr[i]);
        }
    }

}
