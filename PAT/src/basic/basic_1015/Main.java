//题目描述
//给定一个常数K以及一个单链表L，请编写程序将L中每K个结点反转。例如：给定L为1→2→3→4→5→6，K为3，则输出应该为
//
//3→2→1→6→5→4；如果K为4，则输出应该为4→3→2→1→5→6，即最后不到K个元素不反转。
//
//输入描述:
//每个输入包含1个测试用例。每个测试用例第1行给出第1个结点的地址、结点总个数正整数N(<= 105)、以及正整数K(<=N)，即要求反转的
//
//子链结点的个数。结点的地址是5位非负整数，NULL地址用-1表示。
//
//
//
//接下来有N行，每行格式为：
//
//
//
//Address Data Next
//
//
//
//其中Address是结点地址，Data是该结点保存的整数数据，Next是下一结点的地址。
//
//
//输出描述:
//对每个测试用例，顺序输出反转后的链表，其上每个结点占一行，格式与输入相同。
//
//输入例子:
//00100 6 4
//00000 4 99999
//00100 1 12309
//68237 6 -1
//33218 3 00000
//99999 5 68237
//12309 2 33218
//
//输出例子:
//00000 4 33218
//
//33218 3 12309
//
//12309 2 00100
//
//00100 1 99999
//
//99999 5 68237
//
//68237 6 -1


package basic.basic_1015;


//方法一（未完成）
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Main {
//	Node head = null; // 头节点
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		String[] start = bf.readLine().split(" ");
//		int len = Integer.valueOf(start[1]), k = Integer.valueOf(start[2]);
//		
//		Main list = new Main();
//		for (int i = 0; i < len; i++) {
//			
//		}
//	}
//
//	/**
//	 * 链表中的节点，address代表节点的地址，data代表节点的值，next是指向下一个节点的地址
//	 * @author Doss
//	 *
//	 */
//	class Node {
//		Node next = null;
//		int address;
//		int data;
//		
//		public Node(int address, int data) {
//			this.address = address;
//			this.data = data;
//		}
//	}
//	
//    /**
//     * 向链表中插入数据
//     * 
//     * @param d
//     */
//    public void addNode(int address, int data) {
//        Node newNode = new Node(address, data);// 实例化一个节点
//        if (head == null) {
//            head = newNode;
//            return;
//        }
//        Node tmp = head;
//        while (tmp.next != null) {
//            tmp = tmp.next;
//        }
//        tmp.next = newNode;
//    }
//}


//方法二(AC)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] start = bf.readLine().split(" ");
		String nowAdr = start[0];
		int len = Integer.valueOf(start[1]), k = Integer.valueOf(start[2]);
		
		HashMap<String, Node> nodes = new HashMap<String, Node> ();
		List<Node> list = new ArrayList<Node> ();
		for (int i = 0; i < len; i++) {
			String[] str = bf.readLine().split(" ");
			Node node = new Node(str[0], Integer.valueOf(str[1]), str[2]);
			nodes.put(str[0], node);
		}

		//顺寻存储
		while(!nowAdr.equals("-1")) {
			Node node = nodes.get(nowAdr);
			nowAdr = node.next;
			list.add(node);
		}
		
		//结点反转
		for (int i = 0; i + k < list.size(); i = i + k) {	//注意！此处不能为 i+k<len
			int l = i, r = i + k - 1;	//记录左右两侧的坐标
			while (l < r) {
				Node tempNode = list.get(l);
				list.set(l, list.get(r));
				list.set(r, tempNode);
				r--;
				l++; 
			}
		}

		//输出list     
        int i;
        
        for(i = 0; i<list.size()-1; i++) {
            Node node = list.get(i);
            System.out.println(node.address+" "+node.data+" "+list.get(i+1).address);
        }
        Node node = list.get(i);
        System.out.println(node.address+" "+node.data+" -1");
		
	}
	
	static class Node {
		String address;
		int data;
		String next;
		
		public Node(String address, int data, String next) {
			this.address = address;
			this.data = data;
			this.next = next; 
		}
	}
}