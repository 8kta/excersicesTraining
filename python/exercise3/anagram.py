def isAnagram(str):
    if str==str[::-1]:
        return True
    else:
        return False


lst = ['hola', 'sala', 'ala', 'mentor', 'solos']
for element in lst:
    print(isAnagram(element))
