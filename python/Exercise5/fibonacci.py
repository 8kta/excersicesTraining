def fibonacci(n):
    a = 1
    b = 1
    if n < 0:
        print("Incorrect input")
    elif n == 0:
        return 0
    elif n == 1:
        print(b)
        return b
    else:
        for i in range(1, n):
            c = a + b
            a = b
            b = c
            print(b)
        return b


fibonacci(9)
