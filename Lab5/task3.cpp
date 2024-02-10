#include <iostream>

class Time{
    const int hours;
    const int mints;
    const int sec;
public:
    Time(): hours(0), mints(0), sec(0)
    {}

    Time(int h, int m, int s): hours(h), mints(m), sec(s)
    {}

    void display() const {
        std :: cout << "Time: " << hours << ":" << mints << ":" << sec << std :: endl;
    }

    Time addTime(const Time & other) const {
        int total_sec = (hours * 3600 + mints*60 + sec) + (other.hours * 3600 + other.mints*60 + other.sec);
        int h = (total_sec / 3600) % 12 == 0 ? 12 : (total_sec / 3600) % 12;
        int m = (total_sec % 3600) / 60;
        int s = total_sec % 60;

        return Time(h, m, s);
    }


};

int main(){
    const Time T1(12,26,33);
    const Time T2(10,24,36);
     Time T3 = T1.addTime(T2);
     std :: cout << "Current time: ";
     T1.display();
     std :: cout << "Added time: ";
    T3.display();
}