# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

import os
import numpy as np

class GenericFile:
    def __init__(self):
        self.path = ""
        self.freq = np.empty(256)
    def get_path(self):
        self.path = str(input("path="))

    def get_freq(self):
        file = open(self.path,"rb")
        content = file.read()
        for byte in content:
            self.freq[byte] = self.freq[byte]+1
        freqmulte = self.freq[9] + self.freq[10] + self.freq[13]
        for i in range (31,128):
            freqmulte = freqmulte + self.freq[i]


        freqputine = self.freq[11] + self.freq[12] + self.freq[14]
        for i in range (0,9):
            freqputine = freqputine + self.freq[i]
        for i in range(15, 32):
            freqputine = freqputine + self.freq[i]
        for i in range(128, 256):
            freqputine = freqputine + self.freq[i]
        total = 0
        for i in range(0, 256):
            total = total + self.freq[i]
        if (freqmulte > freqputine):
            print("fisierul este text UTF8")
        else:
            if (self.freq[0] <= total * 0.3):
                print("fisierul este text UTF16")
            else:
                print("fisierul este binar")



# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    gf = GenericFile()
    gf.get_path()
    gf.get_freq()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
