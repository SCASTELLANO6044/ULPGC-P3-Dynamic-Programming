result = []
depth = 0


def searchtree(solution):
    res = []
    global depth
    for i in range(2):
        if (isvalid(solution, i)) and (depth < 3):
            depth = depth + 1
            res.append(i)
            aux = searchtree(res)
            if aux is not None:
                res.append(aux)
    depth = depth - 1
    if len(res) > 0:
        return res
    else:
        return


def isvalid(solution, val):
    if len(solution) == 0 or solution[len(solution) - 1] != val:
        return True
    else:
        return False


result.append(searchtree(result))
result = result[0]
print(result)
