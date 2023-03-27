import os
import tkinter as tk
import pygubu


def is_prime(n):
    for i in range(2, n):
        if (n % i) == 0:
            return False
    return True

class Parser:
    ROOT_DIR = os.path.dirname(os.path.abspath(__file__))

    def __init__(self, master):
        self.master = master
        # 1: Create a builder
        self.builder = builder = pygubu.Builder()

        # 2: Load an ui file
        ui_path = os.path.join(self.ROOT_DIR, 'parser0.ui')
        builder.add_from_file(ui_path)

        # 3: Create the widget using a master as parent
        self.parser = builder.get_object('Parser', master)

        self.add_list_btn = self.builder.get_object('add_list_btn')
        self.result_txt = self.builder.get_object('result_txt')
        self.filter_impare_btn = self.builder.get_object('filter_impare_btn')
        self.filer_prime_btn = self.builder.get_object('filer_prime_btn')
        self.sumare_btn = self.builder.get_object('sumare_btn')
        self.integer_list_text = self.builder.get_object('integer_list_text')

        self.add_list_btn['command'] = self.add_list

        builder.connect_callbacks(self)
        self.integer_list = None

    def add_list(self):
        result = self.integer_list_text.get("1.0", tk.END)
        result = result.strip().replace(' ', '')
        result = [int(item) for item in result.split(',')]
        self.integer_list = result
        resString = str(result)
        self.result_txt.delete("1.0", tk.END)
        self.result_txt.insert(tk.END, resString)

    def filter_impare(self):
        result = self.integer_list_text.get("1.0", tk.END)
        result = result.strip().replace(' ', '')
        result = [int(item) for item in result.split(',')]
        self.integer_list = result
        for nr in result:
            if (nr % 2 == 0):
                result.remove(nr)
        resString = str(result)
        self.result_txt.delete("1.0", tk.END)
        self.result_txt.insert(tk.END, resString)

    def filer_prime(self):
        result = self.integer_list_text.get("1.0", tk.END)
        result = result.strip().replace(' ', '')
        result = [int(item) for item in result.split(',')]
        self.integer_list = result
        for nr in result:
            if (is_prime(nr) == False):
                result.remove(nr)
        resString = str(result)
        self.result_txt.delete("1.0", tk.END)
        self.result_txt.insert(tk.END, resString)

    def sumare(self):
        result = self.integer_list_text.get("1.0", tk.END)
        result = result.strip().replace(' ', '')
        result = [int(item) for item in result.split(',')]
        self.integer_list = result
        result = 0
        for nr in self.integer_list:
            result = result + nr
        resString = str(result)
        self.result_txt.delete("1.0", tk.END)
        self.result_txt.insert(tk.END,resString)


if __name__ == '__main__':
    root = tk.Tk()
    root.title('Exemplul 1 cu Tkinter si PyGubu')
    app = Parser(root)
    root.mainloop()
