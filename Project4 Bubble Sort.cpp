#include <iostream>
#include <iomanip>

using namespace std;

void bubbleSort(int* a, int size)
{
    if (a == nullptr)
    {
        cout << "No real values in array, program exits" << endl;
    }
    else
    {
        bool swapped;
        for (int i = 0; i < size - 1; i++)
        {
            swapped = false;
            for (int j = 0; j < size - i - 1; j++)
            {
                if (*(a+j) > *(a+j + 1))
                {
                    int temp = *(a+j);
                    *(a + j) = *(a + j + 1);
                    *(a + j + 1) = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
            {
                break;
            }
        }
    }   
}


int main()
{
    const int SIZE = 5;
    int a1[] = { 3, 4, 8, 2, 1 };
    int* p = nullptr;

    bubbleSort(a1, SIZE);

    for (int i = 0; i < SIZE; i++) {
        cout << a1[i] << endl;
    }

    bubbleSort(nullptr, SIZE);

    return 0;
}

