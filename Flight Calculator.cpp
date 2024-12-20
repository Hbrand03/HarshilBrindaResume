#include <iostream>
#include <vector>
#include <math.h>
#include <cmath>

using namespace std;

const double radius = 3958.8;

double haversine(double lat1, double long1, double lat2, double long2, double radius)
{
    double dLat = (lat2 - lat1) * 3.14 / 180.0;
    double dLong = (long2 - long1) * 3.14 / 180.0;

    lat1 = (lat1) * 3.14 / 180.0;
    lat2 = (lat2) * 3.14 / 180.0;

    double a = pow(sin(dLat / 2), 2) + pow(sin(dLong / 2), 2) * cos(lat1) * cos(lat2);
    double c = 2 * asin(sqrt(a));
    return radius * c;
}

double getFlightTime(double lat1, double long1, double lat2, double long2)
{
    double flightTime = haversine(lat1, long1, lat2, long2, radius) / 500;

    return flightTime;
    
}


int main()
{
    vector<string>cities
    {
        {"Raleigh, NC, USA"},
        {"Charlotte, NC, USA"},
        {"New York City, NY, USA"},
        {"San Francisco, CA, USA"},
        {"Indianapolis, IN, USA"},
        {"Dallas, TX, USA"},
        {"Houston, TX, USA"},
        {"Los Angeles, CA, USA"},
        {"Chicago, IL, USA"},
        {"Miami, FL, USA"}
    };

    vector<vector<double> >coordinates
    {
        {35.787743, -78.644257},
        {35.227085, -80.843124},
        {40.730610, -73.935242},
        {37.773972, -122.431297},
        {39.791000, -86.148003},
        {32.779167, -96.808891},
        {29.749907, -95.358421},
        {34.0522, -118.2437},
        {41.8781, -87.6298},
        {25.7617, -80.1918}
    };

    cout <<"Welcome to Flight Calculator! \nPlease have a look at the locations below \n \n";
    cout << "|  City               | Latitude |  Longitude  | \n \n";
    for (int i = 0; i < coordinates.size(); i++)
    {
        cout << i + 1<<" "<< cities[i]<< "      ";
        for (int j = 0; j < coordinates[i].size(); j++)
        {
            cout <<coordinates[i][j] << "    ";
        }
        cout << endl;
    }

    int choice;
    do
    {
        cout << "\nSelect a departure location by choosing the number \nassociated with the location on the list : ";
        cin >> choice;
    } while (choice > coordinates.size() || choice < 0);

    double  lat1 = coordinates[choice-1][0];
    double  long1 = coordinates[choice-1][1];
    
    cities.erase(cities.begin() + choice-1);
    coordinates.erase(coordinates.begin() + choice-1);
    cout << endl;
    for (int i = 0; i < coordinates.size(); i++)
    {
        cout << i + 1 << " " << cities[i] << "      ";
        for (int j = 0; j < coordinates[i].size(); j++)
        {
            cout << coordinates[i][j] << "    ";
        }
        cout << endl;
    }

    int choice2;
    do
    {
        cout << "\nSelect a destination by choosing the number \nassociated with the location on the list : ";
        cin >> choice2;
    } while (choice2 > coordinates.size() || choice2 < 0);

    double  lat2 = coordinates[choice2 - 1][0];
    double  long2 = coordinates[choice2 - 1][1];

    cout << endl;
    cout << "The distance between your two locations is: "<< haversine(lat1, long1, lat2, long2, radius)<<" miles" << endl;
    cout << "Assuming your plane flies somewhere between 460-575mph, \nit will take you approximately " << getFlightTime(lat1,long1,lat2,long2) << " hours to reach your destination. Enjoy your journey.";

    cout << endl;
}