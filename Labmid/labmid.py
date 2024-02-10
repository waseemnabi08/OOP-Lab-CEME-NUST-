import random

class CD:
    def __init__(self, title, artist, num_tracks, play_time):
        self.title = title
        self.artist = artist
        self.num_tracks = num_tracks
        self.play_time = play_time

    def print_info(self):
        print(f"Title: {self.title}")
        print(f"Artist: {self.artist}")
        print(f"Number of tracks: {self.num_tracks}")
        print(f"Play time: {self.play_time}")

class USB:
    def __init__(self, max_storage, number_of_songs, songs):
        self.max_storage = max_storage
        self.number_of_songs = number_of_songs
        self.songs = songs
        self.used_storage = number_of_songs * 5  # assuming each song is 5 MB

    def get_max_storage(self):
        return self.max_storage

    def get_free_storage(self):
        return self.max_storage - self.used_storage

    def add_storage(self, storage):
        self.used_storage += storage

    def remove_storage(self, storage):
        self.used_storage -= storage

    def print_info(self):
        print(f"Max storage: {self.max_storage}")
        print(f"Used storage: {self.used_storage}")
        print("Current playing songs:")
        for song in self.songs:
            print(song)

class AudioPlayer:
    def __init__(self, manufacturer, model):
        self.manufacturer = manufacturer
        self.model = model
        self.cd = None
        self.usb = None
        self.mounted = False
        self.is_playing = False
        self.is_paused = False
        self.is_stopped = True
        self.is_usb = False
        self.is_cd = False
        self.volume = 0

    def mount_usb(self, usb):
        self.usb = usb
        self.mounted = True
        self.is_usb = True
        self.is_cd = False

    def mount_cd(self, cd):
        self.cd = cd
        self.mounted = True
        self.is_usb = False
        self.is_cd = True

    def unmount(self):
        self.mounted = False
        self.is_usb = False
        self.is_cd = False

    def play(self):
        if self.mounted:
            if self.is_usb and self.usb.get_free_storage() > 0:
                self.is_playing = True
                self.is_paused = False
                self.is_stopped = False
            elif self.is_cd:
                self.is_playing = True
                self.is_paused = False
                self.is_stopped = False

    def pause(self):
        if self.mounted:
            if self.is_usb and self.usb.get_free_storage() > 0:
                self.is_playing = False
                self.is_paused = True
                self.is_stopped = False
            elif self.is_cd:
                self.is_playing = False
                self.is_paused = True
                self.is_stopped = False

    def stop(self):
        if self.mounted:
            if self.is_usb and self.usb.get_free_storage() > 0:
                self.is_playing = False
                self.is_paused = False
                self.is_stopped = True
            elif self.is_cd:
                self.is_playing = False
                self.is_paused = False
                self.is_stopped = True

    def increase_volume(self):
        if self.volume < 100:
            self.volume += 1

    def decrease_volume(self):
        if self.volume > 0:
            self.volume -= 1

    def print_info(self):
        print(f"Manufacturer: {self.manufacturer}")
        print(f"Model: {self.model}")
        print(f"Volume: {self.volume}")
        print(f"Mounted: {self.mounted}")
        if self.mounted:
            if self.is_usb:
                print("USB mounted")
                self.usb.print_info()
            elif self.is_cd:
                print("CD mounted")
                self.cd.print_info()

class IncarAudioPlayer(AudioPlayer):
    def __init__(self, manufacturer, model, max_volume, min_volume, max_storage, number_of_songs, songs):
        super().__init__(manufacturer, model)
        self.is_on = False
        self.is_muted = False
        self.max_volume = max_volume
        self.min_volume = min_volume
        self.volume = 0
        self.max_storage = max_storage
        self.number_of_songs = number_of_songs
        self.songs = songs
        self.used_storage = number_of_songs * 5  # assuming each song is 5 MB
        self.is_usb = False
        self.is_cd = False

    def power_on(self):
        self.is_on = True

    def play(self):
        if self.is_on:
            super().play()

    def power_off(self):
        self.is_on = False

    def mute(self):
        self.is_muted = True

    def unmute(self):
        self.is_muted = False

    def mount_usb(self, usb):
        if usb.get_max_storage() > 16:
            print("Error: USB is too large")
        else:
            self.is_usb = True
            self.is_cd = False
            super().mount_usb(usb)

    def mount_cd(self, cd):
        self.is_usb = False
        self.is_cd = True
        super().mount_cd(cd)

    def display(self):
        print(f"Manufacturer: {self.manufacturer}")
        print(f"Model: {self.model}")
        print(f"Volume: {self.volume}")
        print(f"Mounted: {self.mounted}")
        if self.mounted:
            if self.is_usb:
                print("USB mounted")
                self.usb.print_info()
            elif self.is_cd:
                print("CD mounted")
                self.cd.print_info()

class Playlist:
    def __init__(self, name, number_of_songs, songs):
        self.name = name
        self.number_of_songs = number_of_songs
        self.songs = songs

    def add_song(self, song):
        if self.number_of_songs < 10:
            self.songs.append(song)
            self.number_of_songs += 1
        else:
            print("Error: Playlist is full")

    def delete_song(self, song):
        if song in self.songs:
            self.songs.remove(song)
            self.number_of_songs -= 1
        else:
            print("Error: Song not found")

    def shuffle(self):
        random.shuffle(self.songs)

    def print_info(self):
        print(f"Name: {self.name}")
        print(f"Number of songs: {self.number_of_songs}")
        print("Songs:")
        for song in self.songs:
            print(song)

# Example usage
cd = CD("title", "artist", 10, 10.0)
cd.print_info()
print()

usb_songs = ["song1", "song2", "song3", "song4", "song5"]
usb = USB(16, 5, usb_songs)
usb.print_info()
print()

audio_player = AudioPlayer("manufacturer", 1)
audio_player.print_info()
print()

incar_audio_player = IncarAudioPlayer("manufacturer", 1, 100, 0, 16, 5, usb_songs)
incar_audio_player.print_info()
print()

playlist = Playlist("playlist", 5, usb_songs)
playlist.print_info()
print()
