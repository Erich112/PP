#init and read file
file = open("fisier.txt", "rt")
text = file.readlines()
file.close()

#prepare file for writing
file = open("fisier.txt", "wt")


semne = ['.', ',', '?', '!', '-', ':', ';', '(', ')']

#meniu
print("ce vreti sa faceti cu acest text?")
print("1 pt eliminarea semnelor de punctuatie ( (),.?!-:;)")
print("2 pt a face toate literele mici UPPERCASE si cele mari lowercase")
print("3 pt a scrie toate cuvintele cu un anumit nr de caractere")
op = int(input(""))

#procesarea optiunii alese
if op == 1:
    for lin in text:
        for semn in semne:
            lin = lin.replace(semn, " ")
        print(lin)
        file.write(lin)

if op == 2:
    for lin in text:
        for x in lin:
            if x.islower() == 1:
                x = x.upper()
            if x.isupper() == 1:
                x = x.lower()
        print(lin)
        file.write(lin)

if op == 3:
    nrcar = int(input("nr de caract "))
    for lin in text:
        cuvinte = lin.split()
        for cuv in cuvinte:
            if len(cuv) == nrcar:
                file.write(cuv + ' ')


#close file
file.write('')
file.close()
exit()
