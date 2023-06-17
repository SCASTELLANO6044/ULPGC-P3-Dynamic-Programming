def quick_select(ítems):

 return valor_mediana

def Qselect (data, left, right, k):
    if left == right:
        return data[left]

    pivot_index = partition(data, left, right)
    if k == pivot_index:
        return data[k]
    elif k < pivot_index:
        return Qselect(data, left, pivot_index - 1, k)
    else:
        return Qselect(data, pivot_index + 1, right, k)
