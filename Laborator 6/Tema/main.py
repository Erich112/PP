# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.
import copy
from abc import ABCMeta, abstractmethod
class FileFactory:
    def factory(file_type):
        if file_type == "html" :
            return HTMLFile
        elif file_type == "json":
            return JSONFile
        else:
            return ArticleTextFile

class File(metaclass = ABCMeta):

    def __init__(self):
        self.title = "N/A"
        self.author = "N/A"
        self.paragrafe = []

    @abstractmethod
    def read_file_from_stdin(self):
        pass

class HTMLFile(File):
    #def __init__(self):
       # super().__init__()
    def read_file_from_stdin(self):
        self.title = input("titlu: ")
        self.author = input("autor: ")
        nrlin = int(input("nr parag.: "))
        self.paragrafe = []
        for i in range(0, nrlin):
            self.paragrafe.append(input(":"))
    def print_html(self,fname):
        f = open(fname, "a")
        f.write("<html>")
        f.write("<!DOCTYPE html>")
        f.write("<head>")
        f.write("<title>" + self.title + "</title>")
        f.write("</head>")
        f.write("<body>")
        f.write("<h1>" + self.title + "</h1>")
        f.write("<h2>" + self.author + "</h2>")
        for line in self.paragrafe:
            f.write("<p>" + line + "</p>")
        f.write("</body>")
        f.write("</html>")
        f.close()

class JSONFile(File):
    def read_file_from_stdin(self):
        self.title = input("titlu: ")
        self.author = input("autor: ")
        self.nrlin = int(input("nr parag.: "))
        for i in range(0, self.nrlin):
            self.paragrafe[i] = input(":")
    def print_json(self,fname):
        f = open(fname, "a")
        f.write("{")
        f.write('"' + "Ttile" + '"' + ":" + '"' + self.title + '"' + ",")
        f.write('"' + "Author" + '"' + ":" + '"' + self.author + '"' + ",")
        f.write('"' + "Content" + '"' + ":" + '[')
        for line in self.paragrafe:
            f.write('"' + "Author" + '"' + ":" + '"' + self.author + '"' + ",")
        f.write(']')
        f.write("}")
        f.close()

class TextFile(File):
    template = ""
    @abstractmethod
    def print_text(self):
        pass
    def clone(self):
        return copy.copy(self)

class ArticleTextFile(TextFile):
    template = "Article"
    def print_text(self):
        fname = self.title + ".txt"
        f = FileFactory.factory(fname)
        f = open(fname, "a")
        f.write("\t\t\t" + self.title + "\t\t\t")
        f.write("\t\t\t\t by " + self.author)
        for line in self.paragrafe:
            f.write(self.paragrafe[line])
        f.close()

class BlogTextFile(TextFile):
    template = "Blog"
    def print_text(self):
        fname = self.title + ".txt"
        f = FileFactory.factory(fname)
        f = open(fname, "a")
        f.write(self.title)
        for line in self.paragrafe:
            f.write(self.paragrafe[line])
        f.write()
        f.write("written by " + self.author)
        f.close()

if __name__ == '__main__':
    html1 = FileFactory.factory("html")
    html1.read_file_from_stdin(HTMLFile)
    html1.print_html()

# See PyCharm help at https://www.jetbrains.com/help/pycharm/
