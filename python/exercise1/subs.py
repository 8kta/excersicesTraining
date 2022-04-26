import collections


def check(it):
    count_val = collections.Counter(it).values()
    valores = [x > 1 for x in count_val]
    return any(valores)


def check_word(str):
    tam = len(str)
    count = 1
    for i in range(1, tam + 1):
        for j in range(0, i):
            sub = text[j: tam - i + j + 1: 1]
            if (not check(sub)) & (count == 1):
                buena = sub
                count = count + 1
                break

    return len(buena)


text = 'abcabcdeabc'
print(check_word(text))

check(text)
