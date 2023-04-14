
def fib(n):
    mem = {}

    def mem_fib(key):
        if key not in mem:
            print("key NOT found in mem")
            if key < 2:
                res = key
            else:
                res = fib(key - 1) + fib(key - 2)
            mem[key] = res
        print("key found in mem")
        return mem[key]

    return mem_fib(n)


print(fib(50))
