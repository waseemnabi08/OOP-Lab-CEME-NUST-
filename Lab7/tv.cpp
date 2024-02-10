#include <iostream>
#include <string>
using namespace std;

class Television {
private:
    bool on;
    int channel;
    int volume;
    bool cableMode;
    string tvInput;
    int maxChannels;
    int maxVolume;



public:
    Television(int maxChannels, int maxVolume) : on(true), channel(1), volume(10), cableMode(true), tvInput("TV"), maxChannels(maxChannels), maxVolume(maxVolume) {}

    void Power() {
        on = !on;
    }

    void setChannel(int newChannel) {
        if (on && newChannel >= 1 && newChannel <= maxChannels) {
            channel = newChannel;
        }
    }

    void channelUp() {
        if (on && channel < maxChannels) {
            channel++;
        }
    }

    void channelDown() {
        if (on && channel > 1) {
            channel--;
        }
    }

    void setVolume(int newVolume) {
        if (on && newVolume >= 0 && newVolume <= maxVolume) {
            volume = newVolume;
        }
    }

    void volumeUp() {
        if (on && volume < maxVolume) {
            volume++;
        }
    }

    void volumeDown() {
        if (on && volume > 0) {
            volume--;
        }
    }

    void setMode() {
        if (on) {
            cableMode = !cableMode;
        }
    }

    void setInput(const string& inputType) {
        if (on) {
            tvInput = inputType;
        }
    }

    void viewSettings() {
        if(on){
            cout << "Volume setting = " << volume << std::endl;
            cout << "Channel setting = " << channel << std::endl;
            cout << "Mode = " << (cableMode ? "Cable" : "Antenna") << std::endl;
            cout << "Input = " << tvInput << endl;
        }
    }



friend class Remote;
};

class Remote {
private:
    string company;

public:
    Remote(const string& company) : company(company) {}

    void setChannel(Television& tv, int newChannel) {
        tv.setChannel(newChannel);
    }

    void volumeUp(Television& tv) {
        tv.volumeUp();
    }

    void volumeDown(Television& tv) {
        tv.volumeDown();
    }

    void viewSettings(Television& tv) {
        tv.viewSettings();
    }


};

int main() {
    Television t(100, 50);
    Remote r("ABC");

    r.setChannel(t, 25);
    r.volumeUp(t);
    r.volumeDown(t);
    r.viewSettings(t);

    Television t2 = t;
    r.setChannel(t2, 1);
    r.volumeDown(t2);
    r.volumeDown(t2);
    r.viewSettings(t2);

    Remote s("ABC Company");
    s.viewSettings(t);


    return 0;
}