
//SP25-BCS-151
public class ValidationHistory {
    private HistoryNode head;

    public void addrecord(String htmlString,String result) {
        HistoryNode newnode = new HistoryNode(htmlString, result);

        if (head == null) {
            head = newnode;
        } else {
            HistoryNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newnode;
        }
    }

    public void display(){
        if(head==null){
            System.out.println("No valid history");
            return;
        }
        System.out.println("This is validation history");
        HistoryNode temp=head;
        int count=1;
        while(temp!=null){
            System.out.println(count+".Input : "+temp.htmlString);
            System.out.println("Result: " +temp.result);
            System.out.println();
            temp=temp.next;
            count++;
        }
    }
}
