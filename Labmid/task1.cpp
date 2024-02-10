#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

class CD {
private:
    std::string title;
    std::string artist;
    int numTracks;
    double playTime;

public:
    CD(std::string t, std::string a, int n, double p)
        : title(t), artist(a), numTracks(n), playTime(p) {}

    void print() const {
        std::cout << "Title: " << title << std::endl;
        std::cout << "Artist: " << artist << std::endl;
        std::cout << "Number of tracks: " << numTracks << std::endl;
        std::cout << "Play time: " << playTime << " minutes" << std::endl;
    }
};

class USB {
private:
    const int maxStorage;
    std::vector<std::string> songs;
    int usedStorage;

public:
    USB(int maxStorage, const std::vector<std::string>& songs)
        : maxStorage(maxStorage), songs(songs) {
        // assuming each song is 5 MB
        usedStorage = songs.size() * 5;
    }

    // Copy assignment operator
    USB& operator=(const USB& other) {
        if (this != &other) {
            // Copy the data members
            this->songs = other.songs;
            this->usedStorage = other.usedStorage;
        }
        return *this;
    }

    int getMaxStorage() const {
        return maxStorage;
    }

    int getFreeStorage() const {
        return maxStorage - usedStorage;
    }

    void addStorage(int storage) {
        usedStorage += storage;
    }

    void removeStorage(int storage) {
        usedStorage -= storage;
    }

    void print() const {
        std::cout << "Max storage: " << maxStorage << " MB" << std::endl;
        std::cout << "Used storage: " << usedStorage << " MB" << std::endl;
        std::cout << "Current playing songs: " << std::endl;
    }
};

class AudioPlayer {
protected:
    std::string manufacturer;
    int model;
    CD cd;
    USB usb;
    bool mounted;
    bool isPlaying;
    bool isPaused;
    bool isStopped;
    bool isUSB;
    bool isCD;
    int volume;

public:
    AudioPlayer(std::string manufacturer, int model)
        : manufacturer(manufacturer), model(model),
          mounted(false), isPlaying(false), isPaused(false),
          isStopped(true), isUSB(false), isCD(false), volume(0) {}

    void mountUSB(const USB& usb) {
        this->usb = usb;  // Using copy assignment
        mounted = true;
        isUSB = true;
        isCD = false;
    }

    void mountCD(const CD& cd) {
        this->cd = cd;  // Using copy assignment
        mounted = true;
        isUSB = false;
        isCD = true;
    }

    void unmount() {
        mounted = false;
        isUSB = false;
        isCD = false;
    }

    void play() {
        if (mounted) {
            if (isUSB && usb.getFreeStorage() > 0) {
                isPlaying = true;
                isPaused = false;
                isStopped = false;
            } else if (isCD) {
                isPlaying = true;
                isPaused = false;
                isStopped = false;
            }
        }
    }

    void pause() {
        if (mounted && isUSB && usb.getFreeStorage() > 0) {
            isPlaying = false;
            isPaused = true;
            isStopped = false;
        } else if (mounted && isCD) {
            isPlaying = false;
            isPaused = true;
            isStopped = false;
        }
    }

    void stop() {
        if (mounted && isUSB && usb.getFreeStorage() > 0) {
            isPlaying = false;
            isPaused = false;
            isStopped = true;
        } else if (mounted && isCD) {
            isPlaying = false;
            isPaused = false;
            isStopped = true;
        }
    }

    void increaseVolume() {
        if (volume < 100) {
            volume++;
        }
    }

    void decreaseVolume() {
        if (volume > 0) {
            volume--;
        }
    }

    void print() const {
        std::cout << "Manufacturer: " << manufacturer << std::endl;
        std::cout << "Model: " << model << std::endl;
        std::cout << "Volume: " << volume << std::endl;
        std::cout << "Mounted: " << (mounted ? "Yes" : "No") << std::endl;
        if (mounted) {
            if (isUSB) {
                std::cout << "USB mounted" << std::endl;
                usb.print();
            } else if (isCD) {
                std::cout << "CD mounted" << std::endl;
                cd.print();
            }
        }
    }
};

class IncarAudioPlayer : public AudioPlayer {
private:
    bool isOn;
    bool isMuted;

public:
    IncarAudioPlayer(std::string manufacturer, int model, int maxVolume, int minVolume, int maxStorage, const std::vector<std::string>& songs)
        : AudioPlayer(manufacturer, model), isOn(false), isMuted(false) {
        // additional initialization for IncarAudioPlayer
    }

    void powerOn() {
        isOn = true;
    }

    void play() {
        if (isOn) {
            AudioPlayer::play();
        }
    }

    void powerOff() {
        isOn = false;
    }

    void mute() {
        isMuted = true;
    }

    void unmute() {
        isMuted = false;
    }

    void USB(const USB& usb) {
        if (usb.getMaxStorage() > 16) {
            std::cout << "Error: USB is too large" << std::endl;
        } else {
            isUSB = true;
            isCD = false;
            AudioPlayer::mountUSB(usb);
        }
    }

    void CD(const CD& cd) {
        isUSB = false;
        isCD = true;
        AudioPlayer::mountCD(cd);
    }

    void display() const {
        std::cout << "Manufacturer: " << manufacturer << std::endl;
        std::cout << "Model: " << model << std::endl;
        std::cout << "Volume: " << volume << std::endl;
        std::cout << "Power: " << (isOn ? "On" : "Off") << std::endl;
        std::cout << "Muted: " << (isMuted ? "Yes" : "No") << std::endl;
        AudioPlayer::print();
    }
};

class Playlist {
private:
    std::string name;
    std::vector<std::string> songs;

public:
    Playlist(std::string name, const std::vector<std::string>& songs)
        : name(name), songs(songs) {}

    void addSong(const std::string& song) {
        if (songs.size() < 10) {
            songs.push_back(song);
        } else {
            std::cout << "Error: Playlist is full" << std::endl;
        }
    }

    void deleteSong(const std::string& song) {
        auto it = std::find(songs.begin(), songs.end(), song);
        if (it != songs.end()) {
            songs.erase(it);
        } else {
            std::cout << "Error: Song not found" << std::endl;
        }
    }

    void shuffle() {
        std::random_shuffle(songs.begin(), songs.end());
    }

    void print() const {
        std::cout << "Name: " << name << std::endl;
        std::cout << "Number of songs: " << songs.size() << std::endl;
        std::cout << "Songs: " << std::endl;
        for (const auto& song : songs) {
            std::cout << song << std::endl;
        }
    }
};

int main() {
    CD cd("title", "artist", 10, 10.0);
    cd.print();
    std::cout << std::endl;

    std::vector<std::string> usbSongs = {"song1", "song2", "song3", "song4", "song5"};
    USB usb(16, usbSongs);
    usb.print();
    std::cout << std::endl;

    AudioPlayer audioPlayer("manufacturer", 1);
    audioPlayer.print();
    std::cout << std::endl;

    IncarAudioPlayer incarAudioPlayer("manufacturer", 1, 100, 0, 16, usbSongs);
    incarAudioPlayer.print();
    std::cout << std::endl;

    std::vector<std::string> playlistSongs = {"songA", "songB", "songC", "songD", "songE"};
    Playlist playlist("playlist", playlistSongs);
    playlist.print();
    std::cout << std::endl;

    return 0;
}
