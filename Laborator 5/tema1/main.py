import os
import sys
import tkinter as tk
import pygubu

class Parser:
    ROOT_DIR = os.path.dirname(os.path.abspath(__file__))

    def __init__(self, master):
        self.master = master
        # 1: Create a builder
        self.builder = builder = pygubu.Builder()

        # 2: Load an ui file
        ui_path = os.path.join(self.ROOT_DIR, 'html.ui')
        builder.add_from_file(ui_path)

        # 3: Create the widget using a master as parent
        self.parser = builder.get_object('Parser', master)

        self.upload_btn = self.builder.get_object('upload_btn')
        self.path_ent = self.builder.get_object('path_ent')

        builder.connect_callbacks(self)
        self.integer_list = None

    def upload(self):
        txt_path = self.path_ent.get()
        file = open(txt_path, "rt")
        text = file.readlines()
        file.close()
        html_path = txt_path.replace(".txt", ".html")
        html_out = open(html_path, "wt")

        html_out.write("<!DOCTYPE html>")
        html_out.write("<html>")
        html_out.write("<head>")
        html_out.write("<title>" + text[0] +  "</title>")
        html_out.write("</head>")
        html_out.write("<body>")
        html_out.write("<h1>" + text[0] + "</h1>")
        html_out.write("<h2>" + text[1] + "</h2>")
        html_out.write("<p>")
        for i in range(2, len(text)):
            html_out.write(text[i] + "<br>")
        html_out.write("</p>")
        html_out.write("</body>")
        html_out.write("</html>")

if __name__ == '__main__':
    root = tk.Tk()
    root.title('Tema 1 cu Tkinter si PyGubu')
    app = Parser(root)
    root.mainloop()
