result = []
max_size = 3

def treeSearch():
    comb = []
    for i in range(2):
        if isValid(comb, i) == True:
            comb.append(i)
            treeSearch()
        

def isValid(array, val):
    if (len(array) == 0 or array[len(array)-1] == val):
        return False
    else:
        return True

treeSearch()
print(result)