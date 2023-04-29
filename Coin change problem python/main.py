import sys

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

# Inicio del programa.

tab = False
mem = False
both = False
isDirectory = False

valid_first = ["-d", "--directory", "-f", "--file", "-h", "--help"]
valid_second = ["-sm", "--memoization", "-st", "--tabulation", "--check"]

if sys.argv[1] == "-h" or sys.argv[1] == "--help":
    print("Uso del programa: CoinChangeProblem.py [-d [DIRECTORY] | -f [FILE]] [-sm | -st | -check]\n\n" +
          "optional arguments:\n" +
          "    -d [DIRECTORY], --directory [DIRECTORY]     process many files in a directory\n" +
          "    -f [FILE], --file [FILE]                    process a single file\n" +
          "    -sm, --memoization                          count number of combinations to reach the change with the available coins through Memoization\n" +
          "    -st, --tabulation                           count number of combinations to reach the change with the available coins through Tabulation\n" +
          "    --check                                     check that the count number of combinations to reach the change with the available coins\n" +
          "                                                    is the same through Tabulation and Memoization\n")
elif sys.argv[1] not in valid_first or sys.argv[3] not in valid_second:
    print("No ha escrito los parámetros de entrada del programa correctamente:\n"
          "Uso del programa: CoinChangeProblem.py [-d [DIRECTORY] | -f [FILE]] [-sm | -st | -check]\n\n" +
          "optional arguments:\n" +
          "    -d [DIRECTORY], --directory [DIRECTORY]     process many files in a directory\n" +
          "    -f [FILE], --file [FILE]                    process a single file\n" +
          "    -sm, --memoization                          count number of combinations to reach the change with the available coins through Memoization\n" +
          "    -st, --tabulation                           count number of combinations to reach the change with the available coins through Tabulation\n" +
          "    --check                                     check that the count number of combinations to reach the change with the available coins\n" +
          "                                                    is the same through Tabulation and Memoization\n")
else:
    second_param = ""

    if sys.argv[1] == valid_first[0] or sys.argv[1] == valid_first[1]:
        isDirectory = True
        second_param = sys.argv[2]
        print(second_param)
    elif sys.argv[1] == valid_first[2] or sys.argv[1] == valid_first[3]:
        second_param = sys.argv[2]

    if sys.argv[3] == valid_second[4]:
        tab = False
        mem = False
        both = True
    elif sys.argv[3] == valid_second[0] or sys.argv[3] == valid_second[1]:
        tab = False
        mem = True
        both = False
    elif sys.argv[3] == valid_second[2] or sys.argv[3] == valid_second[3]:
        tab = True
        mem = False
        both = False


coins = [1, 2, 3]
memory = {}
combinations = memoization(coins, len(coins)-1, 4, memory)
numOfCombinations = len(combinations)
print(numOfCombinations)
for combination in combinations:
    print(combination)

tabulation = tabulation(coins, 4)
print(tabulation)
