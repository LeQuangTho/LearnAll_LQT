// C++ program for implementation of Heap Sort 
#include <iostream> 

using namespace std; 

// To heapify a subtree rooted with node i which is 
// an index in arr[]. n is size of heap 
void heapify(int arr[], int n, int i) 
{ 
	int cha = i; // chi so cua node cha
	int left = 2*i + 1; // left = 2*i + 1 chi so cua node con trai
	int right = 2*i + 2; // right = 2*i + 2 chi so cua node con phai

	// xet xem node trai co lon hon cha khong 
	if (left < n && arr[left] > arr[cha]) 
		cha = left; 

	// xet xem node phai co lon hon cha khong 
	if (right < n && arr[right] > arr[cha]) 
		cha = right; 

	// xet xem cha co la goc hay ko 
	if (cha != i) 
	{ 
		swap(arr[i], arr[cha]); 

		// Recursively heapify the affected sub-tree 
		heapify(arr, n, cha); 
	} 
} 

// ham sx
void heapSort(int arr[], int n) 
{ 
	// xay dung cay heap (rearrange array) 
	for (int i = n / 2 - 1; i >= 0; i--) 
		heapify(arr, n, i); 

	// chuyen tu cay heap ve thanh dang duoc sx 
	for (int i=n-1; i>=0; i--) 
	{ 
		// doi cho goc va node cuoi
		swap(arr[0], arr[i]); 

		// xay dung lai cay heap sau khi da xoa 1 phan tu 
		heapify(arr, i, 0); 
	} 
} 

/* A utility function to print array of size n */
void printArray(int arr[], int n) 
{ 
	for (int i=0; i<n; ++i) 
		cout << arr[i] << " "; 
	cout << "\n"; 
} 

// Driver program 
int main() 
{ 
	int arr[] = {23, 54, 1, 53,76, 123, 43, 87, 321, 43}; 
	int n = sizeof(arr)/sizeof(arr[0]); 
	cout<<n;
	heapSort(arr, n); 

	cout << "Sorted array is \n"; 
	printArray(arr, n); 
} 

