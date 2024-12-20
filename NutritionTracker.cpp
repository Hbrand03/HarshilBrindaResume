#include <iostream>
#include<iomanip>
#include<string>
#include<vector>
//#include "FoodItem.h"

using namespace std;


class FoodItem
{
private:
    string name;
    double calories;
    double fats;
    double sugars;
    double protein;
    double sodium;

public:
    FoodItem()
    {
        name = "";
        calories = 0;
        fats = 0;
        sugars = 0;
        protein = 0;
        sodium = 0;
    }
    FoodItem(string n, double c, double f, double su, double p, double so)
    {
        name = n;
        calories = c;
        fats = f;
        sugars = su;
        protein = p;
        sodium = so;
    }
    void setName(string n) 
    { 
        name = n; 
    }
    void setCalories(double c) 
    { 
        calories = c; 
    }
    void setFats(double f) 
    { 
        fats = f; 
    }
    void setProtein(double p) 
    { 
        protein = p; 
    }
    void setSodium(double so) 
    { 
        sodium = so; 
    }
    void setSugars(double su) 
    { 
        sugars = su; 
    }
    string getName()
    {
        return name;
    }
    double getCalories() 
    { 
        return calories; 
    }
    double getFats() 
    { 
        return fats; 
    }
    double getSugars() 
    { 
        return sugars; 
    }
    double getProtein() 
    { 
        return protein; 
    }
    double getSodium() 
    { 
        return sodium; 
    }
    FoodItem operator+ (FoodItem const& item)
    {
        FoodItem sum;
        sum.calories = this->calories + item.calories;
        sum.fats = this->fats + item.fats;
        sum.sugars = this->sugars + item.sugars;
        sum.protein = this->protein + item.protein;
        sum.sodium = this->sodium + item.sodium;
        
        return sum;
    }
};


int main()
{
    FoodItem item1 = { "donut",                270, 15, 15, 4, 260 };
    FoodItem item2 = { "protein bar",          190, 12, 7, 10, 190 };
    FoodItem item3 = { "apple",                95, 0, 19, 1, 2 };
    FoodItem item4 = { "pear",                 101, 0.285, 17.2, 0.676, 190 };
    FoodItem item5 = { "french fries",         180, 7.6, 0.9, 4, 246 };
    FoodItem item6 = { "hamburger",            266, 10.1, 5.2, 13.3, 396 };
    FoodItem item7 = { "instant ramen",        385, 14.5, 1.1, 7.9, 986 };
    FoodItem item8 = { "ten chicken nuggets",  410, 23, 1.9, 26, 750 };
    FoodItem item9 = { "supreme chicken taco", 340, 17, 4, 16, 580};
    FoodItem item10 = { "bean burrito",        350, 9, 3, 13, 1004};
    FoodItem calculatedTotal;

    vector<FoodItem>list = { item1, item2, item3, item4, item5, item6, item7, item8, item9, item10 };

    int choice;
    cout << "Welcome to Nutrition Tracker. Each value is represented in grams exept for calories. Please select an option from the list. \n";
    cout << "1. Select from list of food items. \n2. Add your own food item. \n3. Calculate selected total macros \n4. Finished \n";
    cin >> choice;
    while (choice != 4)
    {
        if (choice == 1)
        {
            cout << "List of food items: "<<endl;
            for (int i = 0; i < list.size(); i++)
            {
                cout << i + 1 << ". " << list[i].getName() << endl;
            }
            int option;
            cout << "Which item are you eating? Will be part of your combined nutritional value.";
            cin >> option;
            FoodItem temp = list[option - 1];
            calculatedTotal = calculatedTotal + temp;
                        
        }
        if (choice == 2)
        {
            cout << "You are only adding an item, if you eat it you must select it from the list."<<endl;
            FoodItem tempItem;
            string name;
            double calories;
            double fats;
            double sugars;
            double protein;
            double sodium;
            cout << "Enter the name of your food item: " << endl;
            cin >> ws;
            getline(cin, name);
            cout << "Enter calories: " << endl;
            cin >> calories;
            cout << "Enter fats (g): " << endl;
            cin >> fats;
            cout << "Enter sugars (g): " << endl;
            cin >> sugars;
            cout << "Enter protein (g): " << endl;
            cin >> protein;
            cout << "Enter sodium (mg): " << endl;
            cin >> sodium;
            tempItem.setName(name);
            tempItem.setCalories(calories);
            tempItem.setFats(fats);
            tempItem.setSugars(sugars);
            tempItem.setProtein(protein);
            tempItem.setSodium(sodium);
            list.push_back(tempItem);

        }
        if (choice == 3)
        {
            cout << "The total nutrional values are presented below.\n";
            cout << "Calories: " << calculatedTotal.getCalories()<<endl;
            if (calculatedTotal.getCalories() > 2000)
            {
                cout << "You have exceeded recommended 2000 calorie intake for the average adult" << endl;
            }
            cout << "Fats (g): " << calculatedTotal.getFats() << endl;
            if (calculatedTotal.getFats() > 70)
            {
                cout << "You have exceeded recommended 70g fats intake for the average adult" << endl;
            }
            cout << "Sugars (g):" << calculatedTotal.getSugars() << endl;
            if (calculatedTotal.getSugars() > 30)
            {
                cout << "You have exceeded recommended 30g sugar intake for the average adult" << endl;
            }
            cout << "Protein (g): " << calculatedTotal.getProtein() << endl;
            if (calculatedTotal.getProtein() > 50)
            {
                cout << "You have exceeded recommended 50g protein intake for the average adult" << endl;
            }
            cout << "Sodium (mg): " << calculatedTotal.getSodium() << endl;
            if (calculatedTotal.getSodium() > 2300)
            {
                cout << "You have exceeded recommended 2300mg sodium intake for the average adult" << endl;
            }
            
        }
        cout << "1. Select from list of food items. \n2. Add your own food item. \n3. Calculate selected total macros \n4. Finished \n"<<endl;
        cin >> choice;
    }
}
