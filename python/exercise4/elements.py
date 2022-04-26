import collections

def extract_unique(lst):
    return list(set(lst))

def extractRepeated(lst):
    conteo = collections.Counter(lst).items()
    listaRepetidos = []
    for element in conteo:
        if element[1] > 1:
            listaRepetidos.append(element[0])
    return listaRepetidos

lst = [11,1,2,3,3,3,2,2,1,11,22]

print(extract_unique(lst))
print(extractRepeated(lst))
