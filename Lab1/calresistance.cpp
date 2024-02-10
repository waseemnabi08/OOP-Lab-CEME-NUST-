#include <iostream>
using namespace std;

const int MAX_COMPONENTS = 100; // Define a maximum number of components

// Function to input component values
void getInput(float arr[], int &total, const char componentType)
{
    cout << "Number of " << componentType << " components: ";
    cin >> total;

    for (int i = 0; i < total; i++)
    {
        cout << componentType << " # " << i + 1 << ": ";
        cin >> arr[i];
    }
}

// Function to calculate equivalent resistance or capacitance in series
float calculateSeries(float arr[], int total, const char operationType)
{
    float result = 0;

    for (int i = 0; i < total; i++)
    {
        if (operationType == 'R')
        {
            result += arr[i];
        }
        else if (operationType == 'C')
        {
            result += 1 / arr[i];
        }
    }

    if (operationType == 'C')
    {
        result = 1 / result;
    }

    return result;
}

// Function to calculate equivalent resistance or capacitance in parallel
float calculateParallel(float arr[], int total, const char operationType)
{
    float result = 0;

    for (int i = 0; i < total; i++)
    {
        if (operationType == 'R')
        {
            result += 1 / arr[i];
        }
        else if (operationType == 'C')
        {
            result += arr[i];
        }
    }

    if (operationType == 'R')
    {
        result = 1 / result;
    }

    return result;
}

int main()
{
    char componentType;
    int total;
    float arr[MAX_COMPONENTS];

    cout << "Equivalent Capacitance and Resistance Calculator....." << endl;
    do
    {
        cout << "Enter 'C' for capacitance and 'R' for resistance: ";
        cin >> componentType;
    } while (componentType != 'C' && componentType != 'R');

    getInput(arr, total, componentType);

    float seriesResult = 0;
    float parallelResult = 0;

    if (componentType == 'R')
    {
        seriesResult = calculateSeries(arr, total, 'R');
        parallelResult = calculateParallel(arr, total, 'R');
        cout << "Equivalent resistance in Series: " << seriesResult << " ohms" << endl;
        cout << "Equivalent resistance in Parallel: " << parallelResult << " ohms" << endl;
    }
    else
    {
        seriesResult = calculateSeries(arr, total, 'C');
        parallelResult = calculateParallel(arr, total, 'C');
        cout << "Equivalent capacitance in Series: " << seriesResult << " Farads" << endl;
        cout << "Equivalent capacitance in Parallel: " << parallelResult << " Farads" << endl;
    }




    return 0;
}
