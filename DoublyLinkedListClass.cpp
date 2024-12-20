#include <iostream>
#include <iomanip>

using namespace std;


struct Node
{
    int data;
    Node* next;
    Node* prev;
};

class DoublyLinkedList
{
public:
    void push(int data);
    void pop();
    int Size();
    void const print();
	int& at(int idx);
	void insert(int data, int pos);
	void remove(int pos);
    DoublyLinkedList()
    {
        data = 0;
        idx = 0;
        pos = 0;
        head = nullptr;
        tail = nullptr;
        size = 0;
    }
    ~DoublyLinkedList() //destructor is responsible for freeing the memory that was allocated for the nodes in the list when an objectw was destroyed
    {
        Node* current = head;
        while (current != NULL) 
        {
            Node* next = current->next;
            delete current;
            current = next;
        }
        head = NULL;
        tail = NULL;
        size = 0;
    }
    DoublyLinkedList(const DoublyLinkedList& other) //creates a new empty list and then copies all the elements from the other list using the push function 
    {
        head = NULL;
        tail = NULL;
        size = 0;
        Node* current = other.head;
        while (current != NULL) 
        {
            push(current->data);
            current = current->next;
        }
    }
    DoublyLinkedList& operator=(const DoublyLinkedList& other) //The copy assignment operator first checks if the lists are the same object as the other, 
    {// If same, function does nothing and returns *this. If different, clears the current list and copies all the elements from the other list using the push
        if (this != &other) 
        {
            while (head != NULL) {
                Node* nodeToRemove = head;
                head = head->next;
                delete nodeToRemove;
            }
            tail = NULL;
            size = 0;
            Node* current = other.head;
            while (current != NULL) {
                push(current->data);
                current = current->next;
            }
        }
        return *this;
    }

private:
	int data;
	int idx;
	int pos;
    Node* head;
    Node* tail;
    int size;
};

void DoublyLinkedList::push(int data) 
{
    Node* newNode = new Node;
    newNode->data = data;
    newNode->next = NULL;
    newNode->prev = tail;
    if (tail != NULL) {
        tail->next = newNode;
    }
    tail = newNode;
    if (head == NULL) {
        head = newNode;
    }
    size++;
}


void DoublyLinkedList::pop()
{
    Node* nodeToRemove = tail;
    int value = nodeToRemove->data;
    tail = tail->prev;
    if (tail != NULL) {
        tail->next = NULL;
    }
    else {
        head = NULL;
    }
}

int DoublyLinkedList::Size()
{
    return size;
}

void const DoublyLinkedList::print()
{
    Node* current = head;
    while (current != NULL) {
        cout << current->data << " ";
        current = current->next;
    }
    cout << endl;
}


int& DoublyLinkedList::at(int idx)
{
    if (idx < 0 || idx >= size)
    {
        cout << "Invalid index." << endl;
        exit(1);
    }
    Node* current = head;
    for (int i = 0; i < idx; i++) {
        current = current->next;
    }
    return current->data;
}

void DoublyLinkedList::insert(int data, int pos)
{
    if(pos < 0 || pos > size) 
    {
        cout << "invalid insert" << endl;
    }
    else
    {
        Node* newNode = new Node;
        newNode->data = data;
        if (pos == 0) {
            newNode->next = head;
            newNode->prev = NULL;
            if (head != NULL) {
                head->prev = newNode;
            }
            head = newNode;
            if (tail == NULL) {
                tail = newNode;
            }
        }
        else {
            Node* prevNode = head;
            for (int i = 0; i < pos - 1; i++) {
                prevNode = prevNode->next;
            }
            newNode->next = prevNode->next;
            newNode->prev = prevNode;
            if (prevNode->next != NULL) {
                prevNode->next->prev = newNode;
            }
            else {
                tail = newNode;
            }
            //prevNode->next = newNode;
        }
        size++;
    }
}



void DoublyLinkedList::remove(int pos)
{
    if (pos < 0 || pos >= size) {
        cout << "invalid removal"<<endl;
        throw out_of_range("Invalid position");
    }
    else if (pos == 0)
    {
        Node* nodeToRemove = head;
        int value = nodeToRemove->data;
        head = nodeToRemove->next;
        if (head != NULL) {
            head->prev = NULL;
        }
        else {
            tail = NULL;
        }
        delete nodeToRemove;
        size--;
    }
    else
    {
        Node* nodeToRemove = head;
        if (pos == 0) {
            head = nodeToRemove->next;
            if (head != NULL) {
                head->prev = NULL;
            }
            else {
                tail = NULL;
            }
        }
        else if (pos == size - 1) {
            nodeToRemove = tail;
            tail = nodeToRemove->prev;
            tail->next = NULL;
        }
        else {
            for (int i = 0; i < pos; i++) {
                nodeToRemove = nodeToRemove->next;
            }
            nodeToRemove->prev->next = nodeToRemove->next;
            nodeToRemove->next->prev = nodeToRemove->prev;
        }
        delete nodeToRemove;
        size--;
    }
}


void test() {
    DoublyLinkedList dll;

    dll.push(1);
    dll.push(2);
    dll.push(3);

    DoublyLinkedList dllCopy = dll;

    dllCopy.push(4);
    dllCopy.remove(1);
    dllCopy.remove(0);
    dllCopy.print();
    dllCopy.insert(1, 3);

    dll.print();
    dllCopy.print();

    dll = dllCopy;
    dll.print();
}

int main()
{
    test();

    return 0;
}

