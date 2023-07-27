import java.util.Arrays;
import java.util.Scanner;

public class MaxHeap {
	int[] heap;
	int[] minHeap;

	
	public MaxHeap(int[] arr) {
		heap = arr.clone();
		minHeap=arr.clone();
	}
	
	int parent(int pos) {return (pos-1)/2;}
	
	int leftChild(int pos) {return pos*2+1;}
	int RightChild(int pos) {return pos*2+2;}
	
	void swap(int fPos, int sPos,int[] array) {
		int temp =array[fPos];
		array[fPos]=array[sPos];
		array[sPos]=temp;
		
	}
	
	void maxHeapify(int i) {
		int left=leftChild(i);
		int right=RightChild(i);
		int largest=i;
		if(left<heap.length && heap[left]>heap[largest]) {
			largest=left;
		}
		
		if(right<heap.length && heap[right]>heap[largest]) {
			largest=right;
		}
		if(largest!=i) {
			swap(i, largest, heap);
			maxHeapify(largest);
		}
		
	}
	
	void minHeapify(int i) {
		int left=leftChild(i);
		int right=RightChild(i);
		int smallest=i;
		if(left<minHeap.length && minHeap[left]<minHeap[smallest]) {
			smallest=left;
		}
		
		if(right<minHeap.length && minHeap[right]<minHeap[smallest]) {
			smallest=right;
		}
		if(smallest!=i) {
			swap(i, smallest,minHeap);
			minHeapify(smallest);
		}
		
	}
	
	int extractMax() {
		int max=heap[0];
		heap[0]=heap[heap.length-1];
		heap=Arrays.copyOf(heap, heap.length-1);
		maxHeapify(0);
		return max;
	}
	
	int extractMin() {
		int min=minHeap[0];
		minHeap[0]=minHeap[minHeap.length-1];
		minHeap=Arrays.copyOf(minHeap, minHeap.length-1);
		minHeapify(0);
		return min;
	}
	int[] maxHeapSort() {
        int[] sortedArray = new int[heap.length];
        for (int i =0; i< sortedArray.length;i++) {
            sortedArray[sortedArray.length - i - 1] = extractMax();
        }
        return sortedArray;
    }

    int[] minHeapSort() {
        int[] sortedArray = new int[minHeap.length];
        for (int i= sortedArray.length-1;i>=0; i--) {
            sortedArray[i] = extractMin();
        }
        return sortedArray;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner reader=new Scanner(System.in);
		
		System.out.println("Enter the number of nodes:");
		int nodes = reader.nextInt();
		
		System.out.println("Enter the nodes:");
		
		int[] original=new int[nodes];
		for(int i=0;i<nodes;i++) {
			original[i]=reader.nextInt();
		}
		reader.close();
		
		System.out.println("Input nodes: "+Arrays.toString(original));
		
		MaxHeap maxHeap=new MaxHeap(original);
		for(int i=nodes/2-1;i>=0;i--) {
			maxHeap.maxHeapify(i);
			maxHeap.minHeapify(i);
			
		}
		System.out.println("Max Heap: "+Arrays.toString(maxHeap.heap));
		System.out.println("Min Heap: "+Arrays.toString(maxHeap.minHeap));
		
		int[] maxHeapSort=maxHeap.maxHeapSort();
		int[] minHeapSort=maxHeap.minHeapSort();
		
		System.out.println("Max Heap Sorted Array (Ascending): " + Arrays.toString(maxHeapSort));
	    System.out.println("Min Heap Sorted Array (Descending): " + Arrays.toString(minHeapSort));

	}

}
