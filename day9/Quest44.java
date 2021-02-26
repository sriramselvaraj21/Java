package day9;
import java.util.*;
public class Quest44 {
	public static void main(String[] args) {
		int Size, i;
		Scanner sc = new Scanner(System.in);

		System.out.print(" Please Enter Number of elements in an array : ");
		Size = sc.nextInt();

		int[] a = new int[Size];
		int[] b = new int[Size];

		System.out.print(" Please Enter " + Size + " elements of First Array  : ");
		for (i = 0; i < Size; i++) {
			a[i] = sc.nextInt();
		}

		System.out.print(" Please Enter " + Size + " elements of Second Array  : ");
		for (i = 0; i < Size; i++) {
			b[i] = sc.nextInt();
		}

		for (i = 0; i < Size; i++) {
			a[i] = a[i] ^ b[i];
			b[i] = a[i] ^ b[i];
			a[i] = a[i] ^ b[i];
		}

		System.out.print("\n First  Array Elements (a[]) After Swapping :  ");
		printAttay(a, Size);
		System.out.print("\n Second Array Elements (b[]) After Swapping :  ");
		printAttay(b, Size);
	}

	public static void printAttay(int[] Array, int Size) {
		for (int Number : Array) {
			System.out.print(Number + " ");
		}

	}
}
