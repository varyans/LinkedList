import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WithLibrary {

	public static void main(String[] args) {

		Scanner giris = new Scanner(System.in);
		List<LinkedList<Integer>> links = new ArrayList<LinkedList<Integer>>();

		boolean kontrol = true;
		int girilen;

		while (kontrol) {
			home();
			girilen = giris.nextInt();

			switch (girilen) {
			case 1:
				LinkedList<Integer> tmp = new LinkedList<Integer>();
				links.add(tmp);
				break;
			case 2:
				show(links);
				break;
			case 3:
				show(links);
				insert(links, giris);
				break;
			case 4:
				show(links);
				if (remove(links, giris))
					System.out.println("Silme İşlemi Başarılı");
				else
					System.out.println("Silme Gerçekleştirilemedi");

				break;

			case 5:
				show(links);
				int result = search(links, giris);
				if (result != -1) {
					System.out.println("Aradığınız Node " + result);
				} else
					System.out.println("Aradağını Node Bulunamadı.");
				break;

			case 6:
				show(links);
				combine(links, giris);

				break;
			case 7:
				show(links);
				intersection(links, giris);
				break;
			case 9:
				kontrol = false;
				giris.close();
				break;
			default:
				System.out.println("Invalid Input");
				break;

			}

		}

	}

	static void home() {
		System.out.println("Lütfen bir seçenek giriniz :");
		System.out.println("1. Create a LinkedList");
		System.out.println("2. Show All Linkedlists");
		System.out.println("3. Insert a Node");
		System.out.println("4. Delete a Node");
		System.out.println("5. Search a Node");
		System.out.println("6. Combine two LinkedList");
		System.out.println("7. Find the Intersection");
		System.out.println("9. Exit");
	}

	static void show(List<LinkedList<Integer>> links) {
		int index = 0;
		for (LinkedList<Integer> x : links) {
			System.out.print(index + "-) ");
			for (Integer integer : x) {
				System.out.print(integer + "\t");
			}
			System.out.println();
			index++;
		}
	}

	static void insert(List<LinkedList<Integer>> links, Scanner giris) {
		int index, key;
		System.out.print("Eklemek yapmak istediğiniz listeyi seçin : ");
		index = giris.nextInt();
		System.out.println("");
		try {
			LinkedList<Integer> link = links.get(index);
			System.out.print("Eklemek istediğiniz Node u giriniz : ");
			key = giris.nextInt();
			link.add(key);
			Collections.sort(link);
			link = temizle(link);
		} catch (Exception e) {
			System.out.println("LinkedList Bulunamadı");
		}

	}

	static boolean remove(List<LinkedList<Integer>> links, Scanner giris) {
		System.out.print("Silme yapmak istediğiniz listeyi seçin : ");
		int index = giris.nextInt();
		System.out.println("");
		try {
			LinkedList<Integer> link = links.get(index);
			System.out.print("Silmek istediğiniz Node u giriniz : ");
			int key = giris.nextInt();
			int eleman = 0;
			for (Integer integer : link) {
				if (integer == key) {
					link.remove(eleman);
					return true;
				} else
					eleman++;
			}
		} catch (Exception e) {
			System.out.println("LinkedList Bulunamadı");
		}

		return false;
	}

	static int search(List<LinkedList<Integer>> links, Scanner giris) {
		System.out.print("Arama yapmak istediğiniz listeyi seçin : ");
		int index = giris.nextInt();
		System.out.println("");
		try {
			LinkedList<Integer> link = links.get(index);
			System.out.print("Aramak istediğiniz Node u giriniz : ");
			int key = giris.nextInt();
			int eleman = 0;
			for (Integer integer : link) {
				if (integer == key)
					return eleman;
				else
					eleman++;
			}

		} catch (Exception e) {
			System.out.println("LinkedList Bulunamadı");
		}

		return -1;
	}

	private static LinkedList<Integer> temizle(LinkedList<Integer> link) {
		LinkedList<Integer> tmp = link;
		for (int i = 0; i < link.size() - 1; i++) {
			for (int j = i + 1; j < link.size(); j++) {
				if (link.get(i) == link.get(j)) {
					tmp.remove(j);
				}
			}
		}
		return tmp;
	}

	private static void combine(List<LinkedList<Integer>> links, Scanner giris) {

		try {
			LinkedList<Integer> tmp = new LinkedList<>();
			System.out.print("1. LinkedList'i Seçin : ");
			int index = giris.nextInt();
			LinkedList<Integer> link = links.get(index);
			System.out.print("2. LinkedList'i Seçin : ");
			index = giris.nextInt();
			LinkedList<Integer> link2 = links.get(index);

			tmp.addAll(link);
			tmp.addAll(link2);
			Collections.sort(tmp);
			links.add(temizle(tmp));

		} catch (Exception e) {
			System.out.println("LinkedList Bulunamadı");
		}

	}

	private static void intersection(List<LinkedList<Integer>> links, Scanner giris) {
		try {
			LinkedList<Integer> tmp = new LinkedList<>();
			System.out.print("1. LinkedList'i Seçin : ");
			int index = giris.nextInt();
			LinkedList<Integer> link = links.get(index);
			System.out.print("2. LinkedList'i Seçin : ");
			index = giris.nextInt();
			LinkedList<Integer> link2 = links.get(index);

			tmp.addAll(link);
			tmp.addAll(link2);
			Collections.sort(tmp);
			links.add(ortaklar(tmp));

		} catch (Exception e) {
			System.out.println("LinkedList Bulunamadı");
		}

	}

	private static LinkedList<Integer> ortaklar(LinkedList<Integer> link) {
		LinkedList<Integer> tmp = new LinkedList<>();
		for (int i = 0; i < link.size() - 1; i++) {
			for (int j = i + 1; j < link.size(); j++) {
				if (link.get(i) == link.get(j)) {
					tmp.add(link.get(i));
				}
			}
		}
		return tmp;
	}

}
