import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Node {
	Node next;
	int num;

	public Node(int val) {
		num = val;
		next = null;
	}

}

class WithoutLibrary {
	private Node head = null;

	public WithoutLibrary() {
		head = null;
	}

	
	public static void main(String[] args) {
		List<WithoutLibrary> liste = new ArrayList<WithoutLibrary>();
		Scanner scan = new Scanner(System.in);

		int deger, key;
		boolean kontrol = true;
		while (kontrol) {
			System.out.println();
			System.out.println("List Operations");
			System.out.println("1.Create");
			System.out.println("2.Display");
			System.out.println("3.Insert");
			System.out.println("4.Delete");
			System.out.println("5.Search");
			System.out.println("6.Combine");
			System.out.println("7.Intersection");
			System.out.println("9.Exit");
			System.out.print("Enter your choose : ");
			int i = scan.nextInt();
			switch (i) {
			case 1:
				WithoutLibrary tmp = new WithoutLibrary();
				liste.add(tmp);
				break;
			case 2:
				goster(liste);
				break;
			case 3:
				goster(liste);
				System.out.println("Liste seç");
				deger = scan.nextInt();
				System.out.println("Değer gir");
				key = scan.nextInt();
				if (deger > liste.size())
					System.out.println("Tanımsız Değer");
				else
					insert(key, liste.get(deger));
				break;
	
			case 4:
				goster(liste);
				System.out.println("Liste seç");
				deger = scan.nextInt();
				System.out.println("Değer gir");
				key = scan.nextInt();
				if (deger > liste.size())
					System.out.println("Tanımsız Değer");
				else
					sil(key, liste.get(deger));
				break;
	
			case 5:
				goster(liste);
				System.out.println("Liste seç");
				deger = scan.nextInt();
				System.out.println("Değer gir");
				key = scan.nextInt();
				if (deger > liste.size())
					System.out.println("Tanımsız Değer");
				else
					System.out.println(ara(key, liste.get(deger)));
				break;
	
			case 6:
				goster(liste);
				System.out.println("1.Liste seç");
				deger = scan.nextInt();
				System.out.println("2.Liste seç");
				key = scan.nextInt();
				if (deger > liste.size())
					System.out.println("Tanımsız Değer");
				else
					liste.add(birlestir(liste.get(deger), liste.get(key)));
				break;

			case 7:
	
			case 9:
				kontrol = false;
				scan.close();

			default: {
				System.out.println("Invalid option");
			}
			}
		}
	}

	private static WithoutLibrary birlestir(WithoutLibrary list1, WithoutLibrary list2) {

		WithoutLibrary myList = list2;
		WithoutLibrary temp = list1;
		Node head = myList.head;
		while (list1.head.next != null) {
			Node tmp = new Node(temp.head.num);
			if (myList.head == null) {
				myList.head = tmp;
			} else {

				if (head.num > list1.head.num) {
					tmp.next = head;
					head = tmp;

				}

				while (head.num <= list1.head.num && head.next != null) {
					if (head.next.num <= list1.head.num)
						head = head.next;
					else
						break;
				}
				if (head.num == list1.head.num) {

				} else {
					tmp.next = head.next;
					head.next = tmp;

				}
			}
			temp.head = temp.head.next;
		}
		return myList;
	}

	public static void goster(List<WithoutLibrary> tmp) {
		for (int i = 0; i < tmp.size(); i++) {
			Node head = tmp.get(i).head;
			System.out.println("");
			if (head == null) {
				System.out.println("Now,Linked-List is Empty");

			}
			Node tmpNode = head;
			System.out.print(i + "-) ");
			while (tmpNode != null) {

				System.out.print("[" + tmpNode.num + "]" + " -> ");
				tmpNode = tmpNode.next;
			}
			System.out.println();
		}
	}

	public static boolean insert(int val, WithoutLibrary list) {
		Node tmp = new Node(val);
		if (list.head == null) {
			list.head = tmp;
			return true;
		} else {
			Node head = list.head;
			if (head.num > val) {
				tmp.next = head;
				list.head = tmp;
				return true;
			}

			while (head.num <= val && head.next != null) {
				if (head.next.num <= val)
					head = head.next;
				else
					break;
			}
			if (head.num == val) {
				return false;
			} else {
				tmp.next = head.next;
				head.next = tmp;
				return true;
			}
		}

	}

	public static void sil(int val, WithoutLibrary myLinkedL) {
		Node head = myLinkedL.head;
		if (head == null) {
			return;
		}
		if (head.num == val) {
			myLinkedL.head = head.next;
			return;
		}

		Node prevNode = null;
		Node currNode = head;
		while (currNode != null && currNode.num != val) {
			prevNode = currNode;
			currNode = currNode.next;
		}
		if (prevNode == null) {
			head = head.next;
			return;
		}
		if (currNode == null) {
			System.out.println("A node with that value does not exist.");
			return;
		}
		prevNode.next = currNode.next;
	}

	public static int ara(int val, WithoutLibrary myLinkedL) {
		Node head = myLinkedL.head;
		if (head == null) {
			return -1;
		}
		if (head.num == val) {
			return 0;
		}

		Node currNode = head;
		int ara = 0;
		while (currNode != null && currNode.num != val) {
			currNode = currNode.next;
			ara++;
		}
		if (currNode == null)
			return -1;
		else
			return ara;
	}
}
