# Find from a lis, two numbers that sums a given number
def find_pairs(lst, sum):
    return [[y,x] for x in lst for y in lst if x+y==sum]

lst = [2,3,4,5,6]
sum = 10

lista = find_pairs(lst, sum)

print(f'Pairs that sum {sum} are {lista}')
