# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.
#1
class int(int):
    def is_prime(self):
        print("aaaaaa")
#2
class str(str):
    def str2pascal(self):
        x = self.split()
        for word in x:
            print(word.capitalize(),end='')

if __name__ == '__main__':
    int(5).is_prime()
    l=list()
    #4
    [i^2 for i in range(10) if (i%2==0)]
    list(map(lambda x:x+1,l))
    str("so that is who i am").str2pascal()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
