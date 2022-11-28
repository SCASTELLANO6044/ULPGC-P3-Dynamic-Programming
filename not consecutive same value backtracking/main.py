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