def isAnagram(str1, str2):
    str1_list = list(str1)
    str2_list = list(str2)
    str1_list.sort()
    str2_list.sort()
    return str1_list == str2_list


def extractAnagrams(lst):
    tam = len(lst)
    anagram = set()
    for i in range(tam):
        palabra1 = lst[i]
        for j in range(tam):
            if palabra1 != lst[j]:
                if isAnagram(palabra1, lst[j]):
                    anagram.add(palabra1)
            else:
                pass
    return list(anagram)


lst = ['hola', 'sala', 'ala', 'mentor', 'solos', 'laa', 'sools']

print(extractAnagrams(lst))
