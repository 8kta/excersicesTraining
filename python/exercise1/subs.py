import collections

text = 'fernanda'

col = collections.Counter(text)

print(col)

tam = len(text)

substring = ''
for i in range(0, tam - 1):
    substring1 = text[i::]
