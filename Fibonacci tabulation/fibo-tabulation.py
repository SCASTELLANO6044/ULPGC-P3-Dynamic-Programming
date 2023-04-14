def fib(n):
    tabulation_table = []

    if n < 2:
        return n
    else:
        tabulation_table.append(0)
        tabulation_table.append(1)

        for j in range (2, n+1):
            tabulation_table.append(tabulation_table[j-2]+tabulation_table[j-1])
        return tabulation_table[n]

print(fib(20))