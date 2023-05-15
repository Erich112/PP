def imparte_cmd(linie):
    comenzi = linie.split(' | ')
    print("__________format__________")
    print("_functie: (input, output)_")
    print("")
    for i in range(len(comenzi)):
        comanda = comenzi[i].split()
        if (i == 0):
            func_temp = comanda[0]
            input_temp = comanda[1]
            out_temp = input_temp
        else:
            func_temp = comanda[0]
            input_temp = out_temp
            out_temp = comanda[1]
        print(func_temp + ": (" + input_temp +  ", " + out_temp + ")")
    return comenzi



if __name__ == "__main__":
    imparte_cmd("ip a | grep inet | wc -l")