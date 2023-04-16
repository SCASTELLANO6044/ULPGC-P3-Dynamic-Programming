def memoization(coins, coinTypeNum, sum, memory):
    if sum == 0:
        combinations = [[]]
        return combinations
    if sum < 0 or coinTypeNum < 0:
        return []
    key = str(coinTypeNum) + "->" + str(sum)
    if key not in memory:
        takenCombinations = memoization(coins, coinTypeNum, sum - coins[coinTypeNum], memory)
        notTakenCombinations = memoization(coins, coinTypeNum-1, sum, memory)
        combinations = []
        for combination in takenCombinations:
            takenCombination = combination[:]
            takenCombination.append(coins[coinTypeNum])
            combinations.append(takenCombination)
        combinations += notTakenCombinations
        memory[key] = combinations
    return memory[key]

def tabulation(coins, sum):
    n = len(coins)
    table = [[0] * (sum+1) for _ in range(n+1)]
    for i in range(n+1):
        table[i][0] = 1
    for i in range(1, n+1):
        for j in range(1, sum+1):
            if coins[i-1] > j:
                table[i][j] = table[i-1][j]
            else:
                table[i][j] = table[i-1][j] + table[i][j-coins[i-1]]
    result = []
    for i in range(1, len(table[n])):
        result.append(getCombinations(table, coins, n, i))
    return result

def getCombinations(table, coins, i, j):
    combinations = []
    while i > 0 and j >= 0:
        if table[i-1][j] == table[i][j]:
            i -= 1
        else:
            combinations.append(coins[i-1])
            j -= coins[i-1]
    return combinations

coins = [1, 2, 3]
memory = {}
combinations = memoization(coins, len(coins)-1, 4, memory)
numOfCombinations = len(combinations)
print(numOfCombinations)
for combination in combinations:
    print(combination)

tabulation = tabulation(coins, 4)
print(tabulation)