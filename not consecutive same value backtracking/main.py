"""
result = []
max_size = 3

arrayL = []
arrayR = []

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
"""

result = []
depth = 0
def searchTree(result):
    res = []
    global depth
    for i in range (2):
        if ((isValid(result, i) == True) and (depth < 3)):
            depth = depth + 1
            res.append(i)
            aux = searchTree(res)
            if aux != None:
                res.append(aux)
    depth = depth -1
    if (len(res) > 0):
        return res
    else:
        return

def isValid(result, val):
    if (len(result)==0 or result[len(result)-1] != val):
        return True
    else:
        return False

result.append(searchTree(result))


print(result)