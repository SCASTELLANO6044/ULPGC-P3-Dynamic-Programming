
def fib(n):
    if n < 2:
        return n
    else:
        table = [0, 1]

        for j in range(2, n+1):
            table.append(table[j-2]+table[j-1])
        return table[len(table)-1]


print(fib(8))
