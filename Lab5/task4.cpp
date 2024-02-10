#include <iostream>
#include <string>
#include <chrono>
#include <ctime>
#include <utility>
using namespace std;

class HeartRates {
private:
    string first_name;
    string last_name;
    int birth_month;
    int birth_day;
    int birth_year;

public:
    // Constructor
    HeartRates(string first, string last, int month, int day, int year)
        : first_name(first), last_name(last), birth_month(month), birth_day(day), birth_year(year) {}

    // Getters
    string getFirstName() const { return first_name; }
    string getLastName() const { return last_name; }
    int getBirthMonth() const { return birth_month; }
    int getBirthDay() const { return birth_day; }
    int getBirthYear() const { return birth_year; }

    // Calculate age (no user input)
    int getAge() const {
        auto now = chrono::system_clock::now();
        time_t t = chrono::system_clock::to_time_t(now);
        tm* now_tm = localtime(&t);
        int current_year = now_tm->tm_year + 1900;
        int current_month = now_tm->tm_mon + 1;
        int current_day = now_tm->tm_mday;

        int age = current_year - birth_year;

        // Adjust age if birthdate has not occurred this year yet
        if (current_month < birth_month || (current_month == birth_month && current_day < birth_day)) {
            age--;
        }

        return age;
    }

    // Calculate maximum heart rate (no user input)
    int getMaximumHeartRate() const {
        int age = getAge();
        int maximum_heart_rate = 220 - age;
        return maximum_heart_rate;
    }

    // Calculate target heart rate range (no user input)
    pair<int, int> getTargetHeartRate() const {
        int maximum_heart_rate = getMaximumHeartRate();
        int lower_target_rate = 0.5 * maximum_heart_rate;  // 50% of max heart rate
        int upper_target_rate = 0.85 * maximum_heart_rate; // 85% of max heart rate
        return make_pair(lower_target_rate, upper_target_rate);
    }
};

int main() {
    // Prompt for user's information
    string first_name, last_name;
    int birth_month, birth_day, birth_year;

    cout << "Enter your first name: ";
    cin >> first_name;
    cout << "Enter your last name: ";
    cin >> last_name;
    cout << "Enter your birth month (1-12): ";
    cin >> birth_month;
    cout << "Enter your birth day: ";
    cin >> birth_day;
    cout << "Enter your birth year: ";
    cin >> birth_year;

    // Create an object of the HeartRates class
    HeartRates person(first_name, last_name, birth_month, birth_day, birth_year);

    // Print the person's information
    cout << "First Name: " << person.getFirstName() << endl;
    cout << "Last Name: " << person.getLastName() << endl;
    cout << "Date of Birth: " << person.getBirthMonth() << "/" << person.getBirthDay() << "/" << person.getBirthYear() << endl;

    // Calculate and print age, maximum heart rate, and target heart rate range
    int max_heart_rate = person.getMaximumHeartRate();
    pair<int, int> target_heart_rate = person.getTargetHeartRate();

    cout << "Age: " << person.getAge() << " years" << endl;
    cout << "Maximum Heart Rate: " << max_heart_rate << " bpm" << endl;
    cout << "Target Heart Rate Range: " << target_heart_rate.first << " - " << target_heart_rate.second << " bpm" << endl;

    return 0;
}
