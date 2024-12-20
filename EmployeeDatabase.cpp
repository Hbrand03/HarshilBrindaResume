#include <iostream>
#include <string>
#include <vector>
#include <iomanip>

using namespace std;

class employee
{
private:
    string name;
    string job;
    double wages;

public:
    employee(string n, string j, double w)
    {
        name = n;
        job = j;
        wages = w;
    }
    employee()
    {
        name = "";
        job = "";
        wages = 0;
    }
    void setName(string n)
    {
        name = n;
    }
    void setJob(string j)
    {
        job = j;
    }
    void setWage(double w)
    {
        wages = w;
    }
    string getName()
    {
        return name;
    }
    string getJob()
    {
        return job;
    }
    double getWages()
    {
        return wages;
    }
};



int main()
{
    vector<employee>EmployeeList;

    int choice;
    cout << "Welcome to the Employee database! Have a look at the options and choose one: \n";
    cout << "1. Print list of Employees \n2. Calculate total wages \n3. Add new employee \n4. Exit application \n";
    cin >> choice;
    while (choice != 4)
    {
        if (choice == 1)
        {
            for (int i = 0; i < EmployeeList.size(); i++)
            {
                cout << "Name: " << EmployeeList[i].getName() << " Job Title: " << EmployeeList[i].getJob() << " Hourly wages: " << EmployeeList[i].getWages()<<endl;
            }
        }
        else if (choice == 2)
        {
            double totalWages = 0;
            for (int i = 0; i < EmployeeList.size(); i++)
            {
                double hours = 0;
                do
                {
                    cout << "Enter the number of hours " << EmployeeList[i].getName() << " worked: \n";
                    cin >> hours;
                } while (hours < 0);
                totalWages = totalWages + EmployeeList[i].getWages() * hours;
            }
            cout << "The total employee wages are: " << totalWages;
        }
        else if (choice == 3)
        {
            employee emp;
            string name;
            string job;
            double wages;
            cout << "Enter the name: ";
            cin >> name;
            cout << "Enter the job title: ";
            cin >> job;
            do
            {
                cout << "Enter the hourly wages: ";
                cin >> wages;
            } while (wages < 0);
            emp.setName(name);
            emp.setJob(job);
            emp.setWage(wages);
            EmployeeList.push_back(emp);
        }
        cout << "\n1. Print list of Employees \n2. Calculate total wages \n3. Add new employee \n4. Exit application \n";
        cin >> choice;
    }
    cout << "Thank you for working with the Employee database! \n";
}
