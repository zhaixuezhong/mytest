package testLife.link;

import org.w3c.dom.NodeList;

/**
 * Created by zhaixuezhong on 11/12/16.
 */
public class Link {
}



class Node{

    int date;

    public Node next;

    public Node(int date){
        this.date = date;
    }

    public void setNext(Node node){
        this.next = node;
    }

}


class MyLinkList{

    Node head = null;


    public void addNode(int d){
        Node newNode = new Node(d);

        if(head == null){
            this.head = newNode;
            return;
        }

        Node tmp = head;
        while(tmp.next!=null){
            tmp = tmp.next;
        }

        tmp.next = newNode;
    }

    public Boolean deleteNode(int indext){
        if(indext < 0 ||indext > length()){
            return false;
        }

        if(indext == 1){
            head = head.next;
            return true;
        }

        int i = 1;
        Node preNode = head;
        Node curNode = preNode.next;
        while(curNode != null){

            if(i == indext){
                preNode.next = curNode.next;
                return true;
            }

            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return true;

    }


    public int length(){
        int length = 0;
        Node tmp = head;
        while(tmp.next!=null){
            length++;
            tmp = tmp.next;
        }
        return length;
    }


    public Node sortNode(){
        Node nextNode = null;
        int tmp = 0;
        Node curNode = head;
        while(curNode.next != null){

            nextNode = curNode.next;
            while(nextNode != null){
                if(curNode.date >nextNode.date){
                    tmp = curNode.date;
                    curNode.date = nextNode.date;
                    nextNode.date = tmp;
                }
                nextNode = nextNode.next;
            }

            curNode = curNode.next;

        }
        return head;
    }



    public void printList(){

        Node tmp = head;

        while(tmp!=null){
            System.out.println(tmp.date);
            tmp = tmp.next;
        }



    }



}






class Test{

    public static void main(String[] args){

//        Node node = new Node(3);

        MyLinkList myLinkList = new MyLinkList();
        myLinkList.addNode(3);

        for(int i = 0;i<10;i++){
            myLinkList.addNode(i);
        }

        myLinkList.sortNode();

        myLinkList.printList();


    }


}